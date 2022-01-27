package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.ConflictWrapper;
import org.sidiff.deltamodeling.deltamodel.util.DeltaModelUtils;
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
public class DeltaActionConflictResolver extends DeltaActionRelationResolver<Conflict> {

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
	
	public DeltaActionConflictResolver(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}

	/**
	 * Searches for resolutions for the given conflict. The conflict is resolvable
	 * iff the effect of the conflicting source delta action is reverted by intermediate delta
	 * actions
	 * 
	 * @param conflict the {@link Conflict} to be resolved
	 * 
	 */
	public void resolve(Conflict conflict) {
		ConflictRelation conflictRelation = (ConflictRelation) conflict.eContainer();
		this.deltaModule1 = conflictRelation.getSourceDeltaModule();
		this.deltaModule2 = conflictRelation.getTargetDeltaModule();
		this.ruleElementMapping1 = resolveRuleElementMapping(conflict.getSourceDeltaAction(), deltaModule1);
		this.ruleElementMapping2 = resolveRuleElementMapping(conflict.getTargetDeltaAction(), deltaModule2);

		ConflictWrapper wrapper = new ConflictWrapper(conflict);

		for (ConflictDetail detail : conflict.getDetails()) {
			if (detail.isSoft()) {
				wrapper.addFormulaToDetail(FormulaUtil.createVariable(String.valueOf(isResolvedSoftConflict(conflict))), detail, FormulaPackage.OR);
			}
		}

		// predecessors contains all delta modules that are in a constraint group before
		// that one of
		// deltaModule2 and after that one of deltaModule1
		// furthermore, their must be at least one dependency between delta module 2 and
		// a predecessor
		// that isn't void
		List<DeltaModule> predecessors = new ArrayList<DeltaModule>(deltaModule2.getAllPredecessors());
		predecessors.retainAll(deltaModule1.getAllSuccessors());

		// check if the conflict is (partially) resolved due to internal dependencies of
		// the target delta action
		// Note: we assume that the source delta module do not contain any (partial)
		// transient effect
		for (DependencyContainer dependency : conflict.getTargetDeltaAction().getOutgoing()) {
			findResolutions(dependency, wrapper);
		}

		// check if the conflict is (partially) resolved due to external dependencies of
		// the target delta action
		for (Dependency dependency : deltaModule2.getOutgoingDependencies(conflict.getTargetDeltaAction())) {
			DependencyRelation dependencyRelation = (DependencyRelation) dependency.eContainer();

			if (predecessors.contains(dependencyRelation.getTargetDeltaModule())) {
				findResolutions(dependency, wrapper);
			}
		}

		Formula featureModel = EcoreUtil.copy(((DeltaModuleSet) conflictRelation.eContainer()).getFeatureModel());

		Formula formula = FormulaUtil.createAnd(Arrays.asList(new Formula[] { featureModel,
				EcoreUtil.copy(conflictRelation.getSourceDeltaModule().getApplicationCondition()),
				EcoreUtil.copy(conflictRelation.getTargetDeltaModule().getApplicationCondition()) }));
		Formula not = FormulaUtil.createNot(wrapper.getFormula());
		formula = FormulaUtil.createAnd(formula, not);
		formula.setSatSolverAdapter(featureModel.getSatSolverAdapter());
		SatResult result = formula.isSatisfiable();
		if (result.getStatus() == EStatus.SATISFIABLE) {
			for (String key : result.getAssignments().keySet()) {
				if (Boolean.valueOf(result.getAssignments().get(key))) {
					conflict.getNonResolvableConfig().add(FormulaUtil.createVariable(key));
				}
			}
		}
	}
	
	/**
	 * find resolution in internal dependencies
	 * @param dependencyContainer
	 * @param wrapper
	 */
	private void findResolutions(DependencyContainer dependencyContainer, ConflictWrapper wrapper) {
		
		if (deltaModule2.getOutgoingDependencies(dependencyContainer.getTarget()).stream().anyMatch(d -> d.getTargetDeltaAction().equals(wrapper.getWrappy().getSourceDeltaAction()))) {
			for (ConflictDetail conflictDetail : wrapper.getWrappy().getDetails()) {
				for (org.sidiff.difference.asymmetric.Dependency dependency : dependencyContainer.getDependencies()) {
					if (isInverse(conflictDetail, dependency, deltaModule2)) {
						wrapper.addFormulaToDetail(((ConflictRelation) wrapper.getWrappy().eContainer()).getTargetDeltaModule()
										.getApplicationCondition(), conflictDetail, FormulaPackage.OR);
					}
				}
			}
		}
	}
	
	/**
	 * find resolution in external dependencies
	 * @param dependency
	 * @param wrapper
	 */
	private void findResolutions(Dependency dependency, ConflictWrapper wrapper) {
		DependencyRelation dependencyRelation = (DependencyRelation) dependency.eContainer();
		if (dependencyRelation.getTargetDeltaModule().getOutgoingDependencies(dependency.getTargetDeltaAction())
				.stream()
				.anyMatch(d -> d.getTargetDeltaAction().equals(wrapper.getWrappy().getSourceDeltaAction()))) {
			for(ConflictDetail conflictDetail : wrapper.getWrappy().getDetails()) {
				for(DependencyDetail dependencyDetail : dependency.getDetails()) {
					if(isInverse(conflictDetail, dependencyDetail)) {
						wrapper.addFormulaToDetail(dependencyRelation.getTargetDeltaModule().getApplicationCondition(), conflictDetail, FormulaPackage.OR);
					}
				}
			}
		}
	}

	/**
	 * Checks if the conflict is a soft-conflict and a respective application order
	 * is given.
	 * 
	 * @param conflict the conflict to be checked
	 * @return <code>true</code> if the soft-conflict is resolved due to a given
	 *         application order, <code>false</code> otherwise
	 */
	private boolean isResolvedSoftConflict(Conflict conflict) {
		return conflict.isSoft() && DeltaModelUtils.getConstraintGroup(deltaModule1).isPresent() && DeltaModelUtils.getConstraintGroup(deltaModule2).isPresent()
				&& !DeltaModelUtils.getConstraintGroup(deltaModule1).get().equals(DeltaModelUtils.getConstraintGroup(deltaModule2).get());
	}
}
