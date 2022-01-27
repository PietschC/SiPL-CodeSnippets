package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.DependencyKind;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.DependencyWrapper;
import org.sidiff.difference.asymmetric.DependencyContainer;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.SatResult.EStatus;
import org.sidiff.formula.util.FormulaUtil;

/**
 * 
 * @author cpietsch
 *
 */
public class DeltaActionDependencyResolver extends DeltaActionRelationResolver<Dependency> {

	/**
	 * The {@link DeltaModule} containing the fist delta action to be analyzed
	 */
	protected DeltaModule deltaModule1;

	/**
	 * The {@link DeltaModule} containing the second delta action to be analyzed
	 */
	protected DeltaModule deltaModule2;

	/**
	 * The {@link IRuleElementMapping} of the first delta action to be analyzed
	 */
	protected IRuleElementMapping ruleElementMapping1;

	/**
	 * The {@link IRuleElementMapping} of the second delta action to be analyzed
	 */
	protected IRuleElementMapping ruleElementMapping2;

	public DeltaActionDependencyResolver(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}

	/**
	 * Searches for resolutions for the given dependency. The dependency is
	 * resolvable iff: - their exists another dependency serving as alternative or -
	 * the dependency is of kind delete/forbid and the forbidden element isn't
	 * created first
	 * 
	 * {@link Dependency} the {@link Dependency} to be resolved
	 */
	public void resolve(Dependency dependency) {
		DependencyRelation dependencyRelation = (DependencyRelation) dependency.eContainer();
		this.deltaModule1 = dependencyRelation.getSourceDeltaModule();
		this.deltaModule2 = dependencyRelation.getTargetDeltaModule();
		this.ruleElementMapping1 = resolveRuleElementMapping(dependency.getSourceDeltaAction(), deltaModule1);
		this.ruleElementMapping2 = resolveRuleElementMapping(dependency.getTargetDeltaAction(), deltaModule2);

		DependencyWrapper wrapper = new DependencyWrapper(dependency);

		// get potential alternatives, i.e. all domain- and constraint compliant
		// predecessors, via getAllPredecessors()
		List<DeltaModule> predecessors = new ArrayList<DeltaModule>(deltaModule1.getAllPredecessors());
		predecessors.remove(deltaModule2);

		// check if the dependency is a conflict resolving one and thus must only be
		// resolved if the conflict wouldn't be resolvable otherwise
		//
		Set<Conflict> conflicts = new HashSet<Conflict>();
		for (Conflict conflict : deltaModule1.getIncomingConflicts(dependency.getSourceDeltaAction())) {
			ConflictRelation conflictRelation = (ConflictRelation) conflict.eContainer();
			// TODO But at least constraint compliant and
			// not domain compliant

			if (conflictRelation.isConstraintCompliant() && !conflictRelation.isDomainCompliant()) {
				for (ConflictDetail conflictDetail : conflict.getDetails()) {
					for (DependencyDetail dependencyDetail : dependency.getDetails()) {
						if (conflictDetail.getEntities().equals(dependencyDetail.getEntities())) {
							conflicts.add(conflict);
						}
					}
				}
			}
		}
		// search for internal alternatives
		//
		for (DependencyContainer internalDependency : dependency.getSourceDeltaAction().getOutgoing()) {
			findResolutions(internalDependency, wrapper);
		}

		// search for external alternatives
		//
		for (Dependency externalDependency : deltaModule1.getOutgoingDependencies(dependency.getSourceDeltaAction())) {
			DependencyRelation externalDependencyRelation = (DependencyRelation) externalDependency.eContainer();

			if (predecessors.contains(externalDependencyRelation.getTargetDeltaModule())) {
				findResolutions(externalDependency, wrapper);
			}
		}

		if (conflicts.isEmpty()) {
			for (DependencyDetail detail : wrapper.getWrappy().getDetails()) {
				if (detail.getKind() == DependencyKind.DELETE_FORBID
						|| detail.getKind() == DependencyKind.DANGLING_DEPENDENCY
						|| detail.getKind() == DependencyKind.CHANGE_FORBID) {
					wrapper.addFormulaToDetail(FormulaUtil.create(true), detail, FormulaPackage.OR);
				}
			}
		} else {
			for (Conflict conflict : conflicts) {
				ConflictRelation conflictRelation = (ConflictRelation) conflict.eContainer();
				// dm2 must be inbetween the conflict introducing d and dm1
				List<DeltaModule> prec = new ArrayList<DeltaModule>(
						conflictRelation.getTargetDeltaModule().getAllPredecessors());
				prec.retainAll(conflictRelation.getSourceDeltaModule().getAllSuccessors());
//				if (prec.isEmpty()) {
//					for (DependencyDetail detail : wrapper.getWrappy().getDetails()) {
//
//						if ( detail.getKind() == DependencyKind.DANGLING_DEPENDENCY) {
//							wrapper.getFormulas().get(detail).clear();
//							wrapper.getFormulas().get(detail).add(FormulaUtil.create(false));
//						}
//					}
//				}
				for (Dependency externalDependency : deltaModule1
						.getOutgoingDependencies(dependency.getSourceDeltaAction())) {

					if (prec.contains(((DependencyRelation) externalDependency.eContainer()).getTargetDeltaModule())) {
						findResolutions(conflict, externalDependency, wrapper);
					}
				}
			}
		}

		Formula featureModel = EcoreUtil.copy(((DeltaModuleSet) dependencyRelation.eContainer()).getFeatureModel());

		Formula implies_alternative = FormulaUtil.createImplies(
				EcoreUtil.copy(dependencyRelation.getSourceDeltaModule().getApplicationCondition()),
				wrapper.getFormula());

		Formula formula = FormulaUtil.createAnd(featureModel, FormulaUtil.createNot(implies_alternative));
		formula.setSatSolverAdapter(featureModel.getSatSolverAdapter());
		SatResult result = formula.isSatisfiable();
		if (result.getStatus() == EStatus.SATISFIABLE) {
			for (String key : result.getAssignments().keySet()) {
				if (Boolean.valueOf(result.getAssignments().get(key))) {
					dependency.getNonResolvableConfig().add(FormulaUtil.createVariable(key));
				}
			}
		}

	}

	private void findResolutions(DependencyContainer alternativeDependency, DependencyWrapper wrapper) {
		for (DependencyDetail dependencyDetail : wrapper.getWrappy().getDetails()) {
			for (org.sidiff.difference.asymmetric.Dependency alternativeDetail : alternativeDependency
					.getDependencies()) {
				if (isEqual(dependencyDetail, alternativeDetail, deltaModule1)) {
					wrapper.addFormulaToDetail(((DependencyRelation) wrapper.getWrappy().eContainer()).getSourceDeltaModule()
									.getApplicationCondition(), dependencyDetail, FormulaPackage.OR);
				}
			}
		}
	}

	private void findResolutions(Dependency alternativeDependency, DependencyWrapper wrapper) {
		DependencyRelation dependencyRelation = (DependencyRelation) alternativeDependency.eContainer();
		for (DependencyDetail dependencyDetail : wrapper.getWrappy().getDetails()) {
			if (!(dependencyDetail.getKind() == DependencyKind.DELETE_FORBID
					|| dependencyDetail.getKind() == DependencyKind.DANGLING_DEPENDENCY
					|| dependencyDetail.getKind() == DependencyKind.CHANGE_FORBID)) {
				for (DependencyDetail alternativeDetail : alternativeDependency.getDetails()) {
					if (isEqual(dependencyDetail, alternativeDetail)) {
						wrapper.addFormulaToDetail(dependencyRelation.getTargetDeltaModule()
								.getApplicationCondition(), dependencyDetail, FormulaPackage.OR);
					}
				}
			}
		}
	}

	private void findResolutions(Conflict conflict, Dependency dependency, DependencyWrapper wrapper) {
		DependencyRelation dependencyRelation = (DependencyRelation) dependency.eContainer();
		ConflictRelation conflictRelation = (ConflictRelation) conflict.eContainer();
		for (DependencyDetail dependencyDetail : wrapper.getWrappy().getDetails()) {
			if (dependencyDetail.getKind() == DependencyKind.DELETE_FORBID
					|| dependencyDetail.getKind() == DependencyKind.DANGLING_DEPENDENCY
					|| dependencyDetail.getKind() == DependencyKind.CHANGE_FORBID) {
				for (DependencyDetail alternativeDetail : dependency.getDetails()) {
					if (isEqual(dependencyDetail, alternativeDetail)) {
						for (ConflictDetail conflictDetail : conflict.getDetails()) {
							if (isInverse(conflictDetail, alternativeDetail)) {
								Formula formula = FormulaUtil.createImplies(
										EcoreUtil.copy(
												conflictRelation.getSourceDeltaModule().getApplicationCondition()),
										EcoreUtil.copy(
												dependencyRelation.getTargetDeltaModule().getApplicationCondition()));
								wrapper.addFormulaToDetail(formula, dependencyDetail, FormulaPackage.OR);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Checks if there is a dependency cycle due to transient effects that is
	 * resolvable due to a given application order.
	 * 
	 * @param dependency the dependency to be checked
	 * @return <code>true</code> if the dependency is resolvable, <code>false</code>
	 *         otherwise
	 */
//	private boolean isResolvedCyle(Dependency dependency) {
//		if (dependency.getTransientEffect() != null
//				&& deltaModule1.getBefore().stream().anyMatch(g -> g.getDeltaModules().contains(deltaModule2))) {
//			LogUtil.log(LogEvent.INFO, "Removable Dependency:" + dependency + "is resolved cycle");
//			return true;
//		}
//
//		// TODO check partial transient effects
//		return false;
//	}
}