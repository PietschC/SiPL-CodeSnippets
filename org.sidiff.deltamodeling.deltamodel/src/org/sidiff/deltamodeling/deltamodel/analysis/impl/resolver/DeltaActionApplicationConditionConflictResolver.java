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
import org.sidiff.deltamodeling.deltamodel.ConflictKind;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.ApplicationConditionConflictWrapper;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.ConflictWrapper;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.NegativeApplicationConditionConflictWrapper;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper.PositiveApplicationConditionConflictWrapper;
import org.sidiff.deltamodeling.deltamodel.util.DeltaModelUtils;
import org.sidiff.difference.asymmetric.DependencyContainer;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
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
public class DeltaActionApplicationConditionConflictResolver
		extends DeltaActionRelationResolver<ApplicationConditionConflict> {

	/**
	 * The delta-modules that contain delta actions inducing an application condition conflict
	 */
	protected Map<OperationInvocation, DeltaModule> sourceDeltaModules;

	/**
	 * The delta-module of the precluded delta action
	 */
	protected DeltaModule targetDeltaModule;

	/**
	 * The {@link IRuleElementMapping}s for the conflict inducing delta actions
	 */
	protected ArrayList<IRuleElementMapping> ruleElementMappings_src;

	/**
	 * The {@link IRuleElementMapping} for the conflict precluded delta action
	 */
	protected IRuleElementMapping ruleElementMapping_tgt;

	/**
	 * Constructor
	 * 
	 * @param ruleBases
	 * @param ruleElementMappings
	 */
	public DeltaActionApplicationConditionConflictResolver(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}

	/**
	 * Searches for resolutions for the given conflict group. The conflict group is
	 * resolvable iff: - PAC (delete/require or change/require): ~ the effect of the
	 * conflicting source delta actions is <i>totally</i> reverted by intermediate
	 * delta similar to delete/use conflicts or ~ the application condition is
	 * fulfilled by an compliant dependencyGroup, representing an alternative
	 * application condition match - NAC (create/forbid or change/forbid): ~ the
	 * effect of the conflicting source delta actions is <i>partially</> reverted by
	 * intermediate delta actions
	 * 
	 * @param applicationConditionConflict the {@link ApplicationConditionConflict}
	 *                                     to be resolved
	 * 
	 */
	@Override
	public void resolve(ApplicationConditionConflict applicationConditionConflict) {

		ApplicationConditionConflictRelation applicationConditionConflictRelation = (ApplicationConditionConflictRelation) applicationConditionConflict
				.eContainer();

		// maps conflict inducing delta actions to their delta module
		this.sourceDeltaModules = new HashMap<>();

		for (OperationInvocation sourceDeltaAction : applicationConditionConflict.getContributions().stream()
				.map(c -> c.getSourceDeltaAction()).collect(Collectors.toSet())) {
			for (DeltaModule sourceDeltaModule : applicationConditionConflictRelation.getSourceDeltaModules()) {
				if (sourceDeltaModule.getDelta().getOperationInvocations().contains(sourceDeltaAction)) {
					this.sourceDeltaModules.put(sourceDeltaAction, sourceDeltaModule);
					break;
				}
			}
		}
		this.targetDeltaModule = applicationConditionConflictRelation.getTargetDeltaModule();

		ApplicationConditionConflictWrapper wrapper = null;
		if (applicationConditionConflict.getKind() == ApplicationConditionKind.NAC) {
			wrapper = new NegativeApplicationConditionConflictWrapper(applicationConditionConflict);
			resolveNegativeApplicationConditionConflict((NegativeApplicationConditionConflictWrapper) wrapper);
		} else {
			wrapper = new PositiveApplicationConditionConflictWrapper(applicationConditionConflict);
			resolvePositiveApplicationConditionConflict((PositiveApplicationConditionConflictWrapper) wrapper);
		}

		// check if the conflict resolutions are fulfilled for each configuration
		//
		for (Conflict conflict : applicationConditionConflict.getContributions()) {
			sat(conflict, wrapper);
		}

	}

	private void resolveNegativeApplicationConditionConflict(NegativeApplicationConditionConflictWrapper wrapper) {
		// try to resolve all contributing conflicts
		for (Conflict conflict : wrapper.getWrappy().getContributions()) {
			resolveNegativeApplicationConditionConflict(conflict, wrapper);
		}
	}

	private void resolveNegativeApplicationConditionConflict(Conflict conflict,
			NegativeApplicationConditionConflictWrapper wrapper) {

		// check if the conflict is (partially) resolved due to internal dependencies of
		// the target delta action
		// Note: we assume that the source delta module do not contain any (partial)
		// transient effect
		for (DependencyContainer dependency : conflict.getTargetDeltaAction().getOutgoing()) {
			findResolutions(dependency, conflict, wrapper);
		}

		List<DeltaModule> predecessors = getPredecessorsInbetweenConflictInducingAndPreventingDeltaAction(
				conflict.getSourceDeltaAction());

		Set<ConflictDetail> coverage = new HashSet<>();

		// check if the conflict is (partially) resolved due to external dependencies of
		// the target delta action
		for (ApplicationConditionDependency applicationConditionDependency : targetDeltaModule
				.getOutgoingApplicationConditionDependencies(conflict.getTargetDeltaAction(),
						ApplicationConditionKind.NAC)) {
			if (wrapper.getWrappy().getKind() == applicationConditionDependency.getKind()) {
				ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) applicationConditionDependency
						.eContainer();
				for (Dependency dependency : applicationConditionDependency.getContributions()) {
					Optional<DeltaModule> targetDeltaModule = applicationConditionDependencyRelation
							.getTargetDeltaModules().stream().filter(dm -> dm.getDelta().getOperationInvocations()
									.contains(dependency.getTargetDeltaAction()))
							.findAny();
					if (targetDeltaModule.isPresent()) {
						if (predecessors.contains(targetDeltaModule.get())) {
							findResolutions(targetDeltaModule.get(), dependency, conflict, wrapper, true, coverage);
						}
					}
				}
			}
		}

		// check if the conflict is (partially) resolved due to attribute value changes
		// that do not constitute a dependency
		for (DeltaModule predecessor : predecessors) {
			findResolution(predecessor, conflict, wrapper);
		}
	}

	private void resolvePositiveApplicationConditionConflict(PositiveApplicationConditionConflictWrapper wrapper) {
		// try to resolve all contributing conflicts
		for (Conflict conflict : wrapper.getWrappy().getContributions()) {
			resolvePositiveApplicationConditionConflict(conflict, wrapper);
		}
	}

	private void resolvePositiveApplicationConditionConflict(Conflict conflict,
			PositiveApplicationConditionConflictWrapper wrapper) {
		// check if the conflict is (partially) resolved due to internal dependencies of
		// the target delta action
		// Note: we assume that the source delta module do not contain any (partial)
		// transient effect
		for (DependencyContainer dependency : conflict.getTargetDeltaAction().getOutgoing()) {
			findResolutions(dependency, conflict, wrapper);
		}

		List<DeltaModule> predecessors = getPredecessorsInbetweenConflictInducingAndPreventingDeltaAction(
				conflict.getSourceDeltaAction());

		// check if the conflict is (partially) resolved due to external dependencies of
		// the target delta action
		for (ApplicationConditionDependency applicationConditionDependency : targetDeltaModule
				.getOutgoingApplicationConditionDependencies(conflict.getTargetDeltaAction(),
						ApplicationConditionKind.PAC)) {
			Set<ConflictDetail> coverage = new HashSet<>();
			if (wrapper.getWrappy().getKind() == applicationConditionDependency.getKind()) {
				ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) applicationConditionDependency
						.eContainer();
				for (Dependency dependency : applicationConditionDependency.getContributions()) {
					Optional<DeltaModule> targetDeltaModule = applicationConditionDependencyRelation
							.getTargetDeltaModules().stream().filter(dm -> dm.getDelta().getOperationInvocations()
									.contains(dependency.getTargetDeltaAction()))
							.findAny();
					if (targetDeltaModule.isPresent()) {
						findResolutions(targetDeltaModule.get(), dependency, conflict, wrapper,
								predecessors.contains(targetDeltaModule.get()), coverage);
					}
				}

				// FIXME now, we have to check if their exist also co-dependencies resolving the
				// conflict, i.e., we have to check all application condition dependencies
				// covering the same create/require dependencies but with a different matches
				if (coverage.containsAll(conflict.getDetails())) {
					for (ApplicationConditionDependency coApplicationConditionDependency : applicationConditionDependency
							.getCoDependencies()) {
						if (!coApplicationConditionDependency.getMatchID().equals(applicationConditionDependency.getMatchID())) {
							
							ApplicationConditionDependencyRelation coApplicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) coApplicationConditionDependency
									.eContainer();

							List<Formula> conjunction = new ArrayList<>();
							for (DeltaModule coTargetDeltaModule : coApplicationConditionDependencyRelation
									.getTargetDeltaModules()) {
								conjunction.add(EcoreUtil.copy(coTargetDeltaModule.getApplicationCondition()));
							}

							if (DeltaModelUtils.getAllPredecessors_(targetDeltaModule).containsAll(coApplicationConditionDependencyRelation.getTargetDeltaModules())) {
								for (Dependency coDependency : coApplicationConditionDependency.getContributions()) {
									
									for (ApplicationConditionConflict coApplicationConditionConflict : coApplicationConditionDependencyRelation
											.getSourceDeltaModule().getIncomingApplicationConditionConflicts(coDependency.getSourceDeltaAction(), ApplicationConditionKind.PAC)) {
										
										ApplicationConditionConflictRelation coApplicationConditionConflictRelation = (ApplicationConditionConflictRelation) coApplicationConditionConflict
												.eContainer();
										if (!coApplicationConditionConflict.equals(conflict.eContainer()) && coApplicationConditionConflictRelation.isConstraintCompliant()) {
											for (Conflict coConflict : coApplicationConditionConflict.getContributions()) {
												if (coDependency.getSourceDeltaAction().equals(coConflict.getTargetDeltaAction())) {
													for (DependencyDetail dependencyDetail : coDependency
															.getDetails()) {
														for (ConflictDetail conflictDetail : coConflict.getDetails()) {
															if (isInverse(conflictDetail, dependencyDetail)) {
																
																Optional<DeltaModule> src = coApplicationConditionConflictRelation
																		.getSourceDeltaModules().stream()
																		.filter(dm -> dm.getDelta()
																				.getOperationInvocations()
																				.contains(coConflict
																						.getSourceDeltaAction()))
																		.findAny();
																if (src.isPresent()) {
																	if(DeltaModelUtils
																	.getAllPredecessors_(targetDeltaModule)
																	.contains(src.get())) {
																	Formula not = FormulaUtil.createNot(EcoreUtil
																			.copy(src.get().getApplicationCondition()));
																	conjunction.add(not);
																	}
																} else {
																	throw new AssertionError(
																			"source module for conlict not found");
																}
															}
														}
													}
												}
											}
										}
									}
								}
								
								Formula formula = FormulaUtil.createAnd(conjunction);
								for (ConflictDetail conflictDetail : conflict.getDetails()) {
									ConflictWrapper w = wrapper.getConflictWrapper(conflict);
									w.addFormulaToDetail(formula, conflictDetail, FormulaPackage.OR);
								}
							}
						}
					}
				}
			}
		}

	}

	private List<DeltaModule> getPredecessorsInbetweenConflictInducingAndPreventingDeltaAction(
			OperationInvocation inducingDeltaAction) {
		// predecessors contains all delta modules that are in a constraint group before
		// that one of the target delta module and after that one of the source delta
		// module
		DeltaModule sourceDeltaModule = sourceDeltaModules.get(inducingDeltaAction);
		List<DeltaModule> predecessors = new ArrayList<DeltaModule>(
				DeltaModelUtils.getAllPredecessors_(targetDeltaModule));
		predecessors.retainAll(DeltaModelUtils.getAllSuccessors_(sourceDeltaModule));
		return predecessors;
	}

	private void sat(Conflict conflict, ApplicationConditionConflictWrapper wrapper) {

		Formula featureModel = EcoreUtil.copy(((DeltaModuleSet) targetDeltaModule.eContainer()).getFeatureModel());
		List<Formula> precondition = new ArrayList<>();
		precondition.add(featureModel);
		sourceDeltaModules.values().stream()
				.forEach(dm -> precondition.add(EcoreUtil.copy(dm.getApplicationCondition())));
		precondition.add(EcoreUtil.copy(targetDeltaModule.getApplicationCondition()));
		Formula formula = FormulaUtil.createAnd(precondition);
		Formula not = FormulaUtil.createNot(wrapper.getFormula(conflict));
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
	 * 
	 * @param dependencyContainer
	 * @param wrapper
	 */
	private void findResolutions(DependencyContainer dependencyContainer, Conflict conflict,
			ApplicationConditionConflictWrapper wrapper) {

		if (targetDeltaModule.getOutgoingDependencies(dependencyContainer.getTarget()).stream()
				.anyMatch(d -> d.getTargetDeltaAction().equals(conflict.getSourceDeltaAction()))) {
			ConflictWrapper w = wrapper.getConflictWrapper(conflict);
			for (ConflictDetail conflictDetail : conflict.getDetails()) {
				for (org.sidiff.difference.asymmetric.Dependency dependency : dependencyContainer.getDependencies()) {
					if (isInverse(conflictDetail, dependency, targetDeltaModule)) {
						w.addFormulaToDetail(targetDeltaModule.getApplicationCondition(), conflictDetail,
								FormulaPackage.OPERATOR);
					}
				}
			}
		}
	}

	/**
	 * find resolution in external dependencies
	 * 
	 * @param dependency
	 * @param wrapper
	 */
	private void findResolutions(DeltaModule targetDeltaModule, Dependency dependency, Conflict conflict,
			ApplicationConditionConflictWrapper wrapper, boolean preceding, Set<ConflictDetail> coverage) {

		int operator = FormulaPackage.OR;
		if (targetDeltaModule.getOutgoingDependencies(dependency.getTargetDeltaAction()).stream()
				.anyMatch(d -> d.getTargetDeltaAction().equals(conflict.getSourceDeltaAction()))
				|| targetDeltaModule
						.getOutgoingApplicationConditionDependencies(dependency.getTargetDeltaAction(),
								wrapper.getWrappy().getKind())
						.stream().flatMap(d -> d.getContributions().stream())
						.anyMatch(d -> d.getTargetDeltaAction().equals(conflict.getSourceDeltaAction()))) {
			ConflictWrapper w = wrapper.getConflictWrapper(conflict);
			for (ConflictDetail conflictDetail : conflict.getDetails()) {
				for (DependencyDetail dependencyDetail : dependency.getDetails()) {
					if (isInverse(conflictDetail, dependencyDetail)) {
						coverage.add(conflictDetail);
						if (preceding) {
							w.addFormulaToDetail(targetDeltaModule.getApplicationCondition(), conflictDetail, operator);
						}
					}
				}
			}
		}
	}

	/**
	 * find resolution for any conflict without considering existing dependency
	 * relations. Actually, it is only used for attribute value changes by
	 * overwriting the value leading to an change/forbid conflict. A resolving delta
	 * action may simple overwrite the conflicting value again such that their isn't
	 * any dependency to the conflict inducing delta action
	 * 
	 * @param predecessor a delta module that is applied in-between the source and
	 *                    target delta module of the conflict
	 * @param conflict    the conflict to be resolved
	 * @param wrapper     the {@link ApplicationConditionConflictWrapper} containing
	 *                    the current considered conflict
	 */
	private void findResolution(DeltaModule predecessor, Conflict conflict,
			ApplicationConditionConflictWrapper wrapper) {
		for (ConflictDetail detail : conflict.getDetails()) {
			if (detail.getKind() == ConflictKind.CHANGE_FORBID || detail.getKind() == ConflictKind.CREATE_FORBID) {
				List<Entity> attributes = detail.getEntities();
				for (OperationInvocation precedingDeltaAction : predecessor.getDelta().getOperationInvocations()) {
					IRuleElementMapping precedingRuleElementMapping = ruleElementMappings.get(precedingDeltaAction);

					for (org.eclipse.emf.henshin.model.Attribute attribute : precedingRuleElementMapping
							.getSetAttributes()) {
						Set<Attribute> originAttributes = new HashSet<>(
								precedingRuleElementMapping.getAttributeSetOriginMappings(attribute));
						originAttributes.retainAll(attributes);
						if (!originAttributes.isEmpty()) {
							Set<Attribute> imageAttributes = new HashSet<>(
									precedingRuleElementMapping.getAttributeMappings(attribute));
							imageAttributes.retainAll(attributes);
							if (imageAttributes.isEmpty()) {
								wrapper.getConflictWrapper(conflict).addFormulaToDetail(
										predecessor.getApplicationCondition(), detail, FormulaPackage.OR);
							}
						}
					}
				}
			}
		}
	}
}
