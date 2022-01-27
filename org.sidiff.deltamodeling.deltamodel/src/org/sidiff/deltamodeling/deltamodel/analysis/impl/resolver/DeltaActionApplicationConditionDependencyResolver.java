package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.DependencyKind;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.ApplicationConditionDependencyWrapper;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.DependencyWrapper;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.NegativeApplicationConditionDependencyWrapper;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.PositiveApplicationConditionDependencyWrapper;
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
public class DeltaActionApplicationConditionDependencyResolver
		extends DeltaActionRelationResolver<ApplicationConditionDependency> {

	protected DeltaModule sourceDeltaModule;

	protected Map<OperationInvocation, DeltaModule> targetDeltaModules;

	protected IRuleElementMapping ruleElementMapping_tgt;

	protected ArrayList<IRuleElementMapping> ruleElementMappings_tgt;

	public DeltaActionApplicationConditionDependencyResolver(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resolve(ApplicationConditionDependency applicationConditionDependency) {
		ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) applicationConditionDependency
				.eContainer();
		this.targetDeltaModules = new HashMap<>();

		for (OperationInvocation targetDeltaAction : applicationConditionDependency.getContributions().stream()
				.map(d -> d.getTargetDeltaAction()).collect(Collectors.toSet())) {
			for (DeltaModule targetDeltaModule : applicationConditionDependencyRelation.getTargetDeltaModules()) {
				if (targetDeltaModule.getDelta().getOperationInvocations().contains(targetDeltaAction)) {
					this.targetDeltaModules.put(targetDeltaAction, targetDeltaModule);
					break;
				}
			}
		}
		this.sourceDeltaModule = applicationConditionDependencyRelation.getSourceDeltaModule();

		ApplicationConditionDependencyWrapper wrapper = null;
		if (applicationConditionDependency.getKind() == ApplicationConditionKind.NAC) {
			wrapper = new NegativeApplicationConditionDependencyWrapper(applicationConditionDependency);
			resolveNegativeApplicationConditionDependency((NegativeApplicationConditionDependencyWrapper) wrapper);
		} else {
			wrapper = new PositiveApplicationConditionDependencyWrapper(applicationConditionDependency);
			resolvePositiveApplicationConditionDependency((PositiveApplicationConditionDependencyWrapper) wrapper);
		}

		// check if the dependencies are fulfilled for each configuration
		//
		for (Dependency dependency : applicationConditionDependency.getContributions()) {
			sat(dependency, wrapper);
		}

	}

	private void resolveNegativeApplicationConditionDependency(NegativeApplicationConditionDependencyWrapper wrapper) {
		// try to resolve all contributing conflicts
		for (Dependency dependency : wrapper.getWrappy().getContributions()) {
			resolveNegativeApplicationConditionDependency(dependency, wrapper);
		}
	}

	private void resolveNegativeApplicationConditionDependency(Dependency dependency,
			NegativeApplicationConditionDependencyWrapper wrapper) {
		// get potential alternatives, i.e. all domain- and constraint compliant
		// predecessors, via getAllPredecessors()
		List<DeltaModule> predecessors = new ArrayList<>(this.sourceDeltaModule.getAllPredecessors());
		predecessors.retainAll(this.targetDeltaModules.values());

		// check if the dependency is a conflict resolving one and thus must only be
		// resolved if the conflict wouldn't be resolvable otherwise
		//
		Set<ApplicationConditionConflict> applicationConditionConflicts = new HashSet<ApplicationConditionConflict>();
		for (ApplicationConditionConflict applicationConditionConflict : this.sourceDeltaModule
				.getIncomingApplicationConditionConflicts(dependency.getSourceDeltaAction(),
						ApplicationConditionKind.NAC)) {
			ApplicationConditionConflictRelation applicationConditionConflictRelation = (ApplicationConditionConflictRelation) applicationConditionConflict
					.eContainer();

			// TODO But at least constraint compliant and
			// not domain compliant
			if (applicationConditionConflictRelation.isConstraintCompliant()
					&& !applicationConditionConflictRelation.isDomainCompliant()) {
				Set<ConflictDetail> conflictDetails = applicationConditionConflict.getContributions().stream()
						.flatMap(c -> c.getDetails().stream()).collect(Collectors.toSet());
				for (DependencyDetail detail : dependency.getDetails()) {
					if (conflictDetails.stream().anyMatch(d -> d.getEntities().equals(detail.getEntities()))) {
						applicationConditionConflicts.add(applicationConditionConflict);
					}
				}
			}
		}
		// search for internal alternatives
		//
		for (DependencyContainer internalDependency : dependency.getSourceDeltaAction().getOutgoing()) {
			findResolutions(internalDependency, dependency, wrapper);
		}

		ApplicationConditionDependency applicationConditionDependency = (ApplicationConditionDependency) dependency
				.eContainer();

		// search for external alternatives
		// Note that any alternative delete or change/forbid dependency is contained in
		// the same application condition dependency
		for (Dependency externalDependency : applicationConditionDependency.getContributions()) {
			Optional<DeltaModule> preceedingTargetDeltaModule = predecessors.stream().filter(
					dm -> dm.getDelta().getOperationInvocations().contains(externalDependency.getTargetDeltaAction()))
					.findAny();
			if (preceedingTargetDeltaModule.isPresent() && predecessors.contains(preceedingTargetDeltaModule.get())) {
				if (!dependency.equals(externalDependency)) {

//					int operator = wrapper.getWrappy().getKind() == ApplicationConditionKind.NAC ? FormulaPackage.OR
//							: FormulaPackage.AND;
//					for(DependencyDetail dependencyDetail : dependency.getDetails()) {
//						wrapper.getDependencyWrapper(dependency).addFormulaToDetail(EcoreUtil.copy(preceedingTargetDeltaModule.get().getApplicationCondition()), dependencyDetail, operator);
//					}
					findResolutions(preceedingTargetDeltaModule.get(), externalDependency, dependency, wrapper);

				}
			}
			// check if the dependency must only be fulfilled iff a conflict inducing delta
			// actions occurs
			if (applicationConditionConflicts.isEmpty()) {
				for (DependencyDetail detail : dependency.getDetails()) {
					wrapper.getDependencyWrapper(dependency).addFormulaToDetail(FormulaUtil.create(true), detail,
							FormulaPackage.OR);
				}
			} else {
				for (ApplicationConditionConflict applicationConditionConflict : applicationConditionConflicts) {
					for (Conflict conflict : applicationConditionConflict.getContributions()) {
						findResolutions(conflict, externalDependency, wrapper.getDependencyWrapper(dependency));
					}
				}
			}
		}
	}

	private void resolvePositiveApplicationConditionDependency(PositiveApplicationConditionDependencyWrapper wrapper) {
		// try to resolve all contributing conflicts
		for (Dependency dependency : wrapper.getWrappy().getContributions()) {
			resolvePositiveApplicationConditionDependency(dependency, wrapper);
		}
	}

	private void resolvePositiveApplicationConditionDependency(Dependency dependency,
			PositiveApplicationConditionDependencyWrapper wrapper) {
		
		ApplicationConditionDependency applicationConditionDependency = (ApplicationConditionDependency) dependency.eContainer();
		
		// get potential alternatives, i.e. all domain- and constraint compliant
		// predecessors, via getAllPredecessors()
		List<DeltaModule> predecessors = new ArrayList<>(this.sourceDeltaModule.getAllPredecessors());
		predecessors.removeAll(this.targetDeltaModules.values());
		
		// search for internal alternatives
		//
		for (DependencyContainer internalDependency : dependency.getSourceDeltaAction().getOutgoing()) {
			findResolutions(internalDependency, dependency, wrapper);
		}
		
		// check if the dependency has an alternative solution with same or for PACs
		// with different entities
		for (ApplicationConditionDependency alternativeApplicationConditionDependency : applicationConditionDependency
				.getCoDependencies()) {
			// check in case of an PAC that the application condition dependency is resolved
			// by another application condition dependency that matches on other entities
			// that fulfill the application condition, too
			ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) alternativeApplicationConditionDependency
					.eContainer();
			if (alternativeApplicationConditionDependency.getKind() == ApplicationConditionKind.PAC
					&& predecessors.containsAll(applicationConditionDependencyRelation.getTargetDeltaModules())) {
				List<Formula> conjunctions = new ArrayList<>();

				for (DeltaModule targetDeltaModule : applicationConditionDependencyRelation
						.getTargetDeltaModules()) {
					conjunctions.add(EcoreUtil.copy(targetDeltaModule.getApplicationCondition()));
				}

				Formula formula = FormulaUtil.createAnd(conjunctions);
				for (DependencyDetail dependencyDetail : dependency.getDetails()) {
					wrapper.getDependencyWrapper(dependency).addFormulaToDetail(formula, dependencyDetail,
							FormulaPackage.OR);
				}
				// check if an alternative dependency exists that fulfills the application
				// condition dependency by matching the same entities
				for (Dependency alternativeDependency : alternativeApplicationConditionDependency
						.getContributions()) {
					Optional<DeltaModule> targetDeltaModule = applicationConditionDependencyRelation
							.getTargetDeltaModules().stream().filter(dm -> dm.getDelta().getOperationInvocations()
									.contains(alternativeDependency.getTargetDeltaAction()))
							.findAny();
					if (targetDeltaModule.isPresent() && predecessors.contains(targetDeltaModule.get())) {
						findResolutions(targetDeltaModule.get(), alternativeDependency, dependency, wrapper);
					}
				}
			}
		}
	}

//	private void resolve(Dependency dependency, ApplicationConditionDependencyWrapper wrapper) {
//		// get potential alternatives, i.e. all domain- and constraint compliant
//		// predecessors, via getAllPredecessors()
//		List<DeltaModule> predecessors = new ArrayList<>(this.sourceDeltaModule.getAllPredecessors());
//		predecessors.removeAll(this.targetDeltaModules.values());
//
//		// check if the dependency is a conflict resolving one and thus must only be
//		// resolved if the conflict wouldn't be resolvable otherwise
//		//
//		Set<ApplicationConditionConflict> applicationConditionConflicts = new HashSet<ApplicationConditionConflict>();
//		for (ApplicationConditionConflict applicationConditionConflict : this.sourceDeltaModule
//				.getIncomingApplicationConditionConflicts(dependency.getSourceDeltaAction(),
//						ApplicationConditionKind.NAC)) {
//			ApplicationConditionConflictRelation applicationConditionConflictRelation = (ApplicationConditionConflictRelation) applicationConditionConflict
//					.eContainer();
//
//			// TODO But at least constraint compliant and
//			// not domain compliant
//			if (applicationConditionConflictRelation.isConstraintCompliant()
//					&& !applicationConditionConflictRelation.isDomainCompliant()) {
//				Set<ConflictDetail> conflictDetails = applicationConditionConflict.getContributions().stream()
//						.flatMap(c -> c.getDetails().stream()).collect(Collectors.toSet());
//				for (DependencyDetail detail : dependency.getDetails()) {
//					if (conflictDetails.stream().anyMatch(d -> d.getEntities().equals(detail.getEntities()))) {
//						applicationConditionConflicts.add(applicationConditionConflict);
//					}
//				}
//			}
//
//			// search for internal alternatives
//			//
//			for (DependencyContainer internalDependency : dependency.getSourceDeltaAction().getOutgoing()) {
//				findResolutions(internalDependency, dependency, wrapper);
//			}
//
//			ApplicationConditionDependency applicationConditionDependency = (ApplicationConditionDependency) dependency
//					.eContainer();
//
//			// check if the dependency has an alternative solution with same or for PACs
//			// with different entities
//			for (ApplicationConditionDependency alternativeApplicationConditionDependency : applicationConditionDependency
//					.getCoDependencies()) {
//				// check in case of an PAC that the application condition dependency is resolved
//				// by another application condition dependency that matches on other entities
//				// that fulfill the application condition, too
//				ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) alternativeApplicationConditionDependency
//						.eContainer();
//				if (alternativeApplicationConditionDependency.getKind() == ApplicationConditionKind.PAC
//						&& predecessors.containsAll(applicationConditionDependencyRelation.getTargetDeltaModules())) {
//					List<Formula> conjunctions = new ArrayList<>();
//
//					for (DeltaModule targetDeltaModule : applicationConditionDependencyRelation
//							.getTargetDeltaModules()) {
//						conjunctions.add(EcoreUtil.copy(targetDeltaModule.getApplicationCondition()));
//					}
//
//					Formula formula = FormulaUtil.createAnd(conjunctions);
//					for (DependencyDetail dependencyDetail : dependency.getDetails()) {
//						wrapper.getDependencyWrapper(dependency).addFormulaToDetail(formula, dependencyDetail,
//								FormulaPackage.OR);
//					}
//					// check if an alternative dependency exists that fulfills the application
//					// condition dependency by matching the same entities
//					for (Dependency alternativeDependency : alternativeApplicationConditionDependency
//							.getContributions()) {
//						Optional<DeltaModule> targetDeltaModule = applicationConditionDependencyRelation
//								.getTargetDeltaModules().stream().filter(dm -> dm.getDelta().getOperationInvocations()
//										.contains(alternativeDependency.getTargetDeltaAction()))
//								.findAny();
//						if (targetDeltaModule.isEmpty() && predecessors.contains(targetDeltaModule.get())) {
//							findResolutions(targetDeltaModule.get(), alternativeDependency, dependency, wrapper);
//						}
//					}
//				}
//			}
//		}
//
//		Formula featureModel = EcoreUtil.copy(((DeltaModuleSet) sourceDeltaModule.eContainer()).getFeatureModel());
//		Formula implies_alternative = FormulaUtil.createImplies(
//				EcoreUtil.copy(sourceDeltaModule.getApplicationCondition()), wrapper.getFormula(dependency));
//		Formula formula = FormulaUtil.createAnd(featureModel, FormulaUtil.createNot(implies_alternative));
//		formula.setSatSolverAdapter(featureModel.getSatSolverAdapter());
//		SatResult result = formula.isSatisfiable();
//		if (result.getStatus() == EStatus.SATISFIABLE) {
//			for (String key : result.getAssignments().keySet()) {
//				if (Boolean.valueOf(result.getAssignments().get(key))) {
//					dependency.getNonResolvableConfig().add(FormulaUtil.createVariable(key));
//				}
//			}
//		}
//	}

	private void sat(Dependency dependency, ApplicationConditionDependencyWrapper wrapper) {

		Formula featureModel = EcoreUtil.copy(((DeltaModuleSet) sourceDeltaModule.eContainer()).getFeatureModel());
		Formula implies_alternative = FormulaUtil.createImplies(
				EcoreUtil.copy(sourceDeltaModule.getApplicationCondition()), wrapper.getFormula(dependency));
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

	private void findResolutions(DependencyContainer alternativeDependency, Dependency dependency,
			ApplicationConditionDependencyWrapper wrapper) {

		for (DependencyDetail dependencyDetail : dependency.getDetails()) {
			for (org.sidiff.difference.asymmetric.Dependency alternativeDetail : alternativeDependency
					.getDependencies()) {
				if (isEqual(dependencyDetail, alternativeDetail, sourceDeltaModule)) {
					DependencyWrapper dependencyWrapper = wrapper.getDependencyWrapper(dependency);
					dependencyWrapper.addFormulaToDetail(sourceDeltaModule.getApplicationCondition(), dependencyDetail,
							FormulaPackage.OR);
				}
			}
		}
	}

	private void findResolutions(DeltaModule targetDeltaModule, Dependency alternativeDependency, Dependency dependency,
			ApplicationConditionDependencyWrapper wrapper) {
		for (DependencyDetail dependencyDetail : dependency.getDetails()) {
			for (DependencyDetail alternativeDependencyDetail : alternativeDependency.getDetails()) {
				if (isEqual(dependencyDetail, alternativeDependencyDetail)) {
					DependencyWrapper dependencyWrapper = wrapper.getDependencyWrapper(dependency);
					dependencyWrapper.addFormulaToDetail(targetDeltaModule.getApplicationCondition(), dependencyDetail,
							FormulaPackage.OR);
				}
			}

		}
	}

	private void findResolutions(Conflict conflict, Dependency dependency, DependencyWrapper wrapper) {
		ApplicationConditionConflict applicationConditionConflict = (ApplicationConditionConflict) conflict
				.eContainer();
		ApplicationConditionConflictRelation applicationConditionConflictRelation = (ApplicationConditionConflictRelation) applicationConditionConflict
				.eContainer();
		ApplicationConditionDependency applicationConditionDependency = (ApplicationConditionDependency) dependency
				.eContainer();
		ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) applicationConditionDependency
				.eContainer();

		Optional<DeltaModule> conflictSourceDeltaModule = applicationConditionConflictRelation.getSourceDeltaModules()
				.stream()
				.filter(dm -> dm.getDelta().getOperationInvocations().contains(conflict.getSourceDeltaAction()))
				.findAny();
		Optional<DeltaModule> dependencyTargetDeltaModule = applicationConditionDependencyRelation
				.getTargetDeltaModules().stream()
				.filter(dm -> dm.getDelta().getOperationInvocations().contains(dependency.getTargetDeltaAction()))
				.findAny();

		assert conflictSourceDeltaModule.isPresent() && dependencyTargetDeltaModule
				.isPresent() : "No delta module found in sources or targets of application condition conflicts/dependencies";

		for (DependencyDetail dependencyDetail : wrapper.getWrappy().getDetails()) {
			if (dependencyDetail.getKind() == DependencyKind.DELETE_FORBID
					|| dependencyDetail.getKind() == DependencyKind.DANGLING_DEPENDENCY
					|| dependencyDetail.getKind() == DependencyKind.CHANGE_FORBID) {
				for (DependencyDetail alternativeDetail : dependency.getDetails()) {
					if (isEqual(dependencyDetail, alternativeDetail)) {
						for (ConflictDetail conflictDetail : conflict.getDetails()) {
							if (isInverse(conflictDetail, alternativeDetail)) {
								Formula formula = FormulaUtil.createImplies(
										EcoreUtil.copy(conflictSourceDeltaModule.get().getApplicationCondition()),
										EcoreUtil.copy(dependencyTargetDeltaModule.get().getApplicationCondition()));
								wrapper.addFormulaToDetail(formula, dependencyDetail, FormulaPackage.OR);
							}
						}
					}
				}
			}
		}
	}
}
