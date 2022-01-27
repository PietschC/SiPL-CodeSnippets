package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch.PartialDependency;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.PotentialAttributeDependency;
import org.sidiff.editrule.rulebase.PotentialDanglingEdgeDependency;
import org.sidiff.editrule.rulebase.PotentialDependency;
import org.sidiff.editrule.rulebase.PotentialDependencyKind;
import org.sidiff.editrule.rulebase.PotentialEdgeDependency;
import org.sidiff.editrule.rulebase.PotentialNodeDependency;
import org.sidiff.editrule.rulebase.RulebasePackage;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * Extends {@link DeltaActionRelationAnalyzer} for detecting
 * {@link Dependency}(ies) between delta actions.
 * 
 * @author cpietsch
 *
 */
public class DeltaActionDependencyAnalyzer extends DeltaActionRelationAnalyzer<Dependency> {

	public DeltaActionDependencyAnalyzer(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}

	@Override
	public Dependency analyze(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {

		// resolve the rule element mappings
		//
		this.ruleElementMapping1 = resolveRuleElementMapping(deltaAction1, deltaModule1);
		this.ruleElementMapping2 = resolveRuleElementMapping(deltaAction2, deltaModule2);

		// get potential dependencies but only consider non conflict resolving
		// dependencies in this step
		//
		Set<PotentialDependency> potentialDependencies = AnalysisUtils
				.getPotentialDependencies(this.ruleElementMapping1.getEditRule(),
						this.ruleElementMapping2.getEditRule(), ruleBases)
				.stream()
				.filter(potentialDependency -> AnalysisUtils.DEPENDENCY_KIND.containsKey(potentialDependency.getKind()))
				.collect(Collectors.toSet());

		if (!potentialDependencies.isEmpty()) {

			Set<DependencyDetail> dependencyDetails = new HashSet<DependencyDetail>();

			for (PotentialDependency potentialDependency : potentialDependencies) {
				switch (potentialDependency.eClass().getClassifierID()) {
				case RulebasePackage.POTENTIAL_NODE_DEPENDENCY:
					checkNodeDependency(potentialDependency, dependencyDetails);
					break;
				case RulebasePackage.POTENTIAL_EDGE_DEPENDENCY:
					checkEdgeDependency(potentialDependency, dependencyDetails);
					break;
				case RulebasePackage.POTENTIAL_DANGLING_EDGE_DEPENDENCY:
					checkDanglingEdgeDependency(potentialDependency, dependencyDetails);
					break;
				case RulebasePackage.POTENTIAL_ATTRIBUTE_DEPENDENCY:
					checkAttributeDependency(potentialDependency, dependencyDetails);
					break;
				default:
					LogUtil.log(LogEvent.WARNING, "Unsupported dependency:  " + potentialDependency.eClass().getName()
							+ ": " + potentialDependency.getKind());
					break;
				}
			}

//			checkApplicationConditionCoverage(dependencyDetails);

			// create dependency if at least one dependency detail has been created
			//
			if (!dependencyDetails.isEmpty()) {
				Dependency dependency = FACTORY.createDependency();
				dependency.setSourceDeltaAction(deltaAction1);
				dependency.setTargetDeltaAction(deltaAction2);
				dependency.getDetails().addAll(dependencyDetails);
				return dependency;
			}
		}

		return null;
	}

	@SuppressWarnings("unused")
	private void checkApplicationConditionCoverage(Set<DependencyDetail> dependencyDetails) {

		for (ApplicationConditionMatch applicationConditionMatch : ruleElementMapping1
				.getApplicationConditionMatches()) {
			PartialDependency partialDependency = applicationConditionMatch
					.getPartialDependency(ruleElementMapping2.getDeltaAction());
			if (partialDependency != null
					&& (applicationConditionMatch.isNac() || partialDependency.isCompleteMatch())) {
				dependencyDetails.addAll(partialDependency.getDetails());
			}
		}
	}

	/**
	 * Checks if a {@link PotentialNodeDependency} between the source and target
	 * delta action is a real one
	 * 
	 * @param potentialDependency the {@link PotentialDependency} to check
	 * @param dependencyDetails   a {@link Set} of detected dependencies
	 */
	private void checkNodeDependency(PotentialDependency potentialDependency, Set<DependencyDetail> dependencyDetails) {

		PotentialNodeDependency potentialNodeDependency = (PotentialNodeDependency) potentialDependency;

		// check if the conflict is due to an application condition (AC)
		//
		if (potentialDependency.isCondition()) {

			// get element of the target node that is a deleted or created element
			//
			Set<SuperimposedElement> tgtElements = ruleElementMapping2
					.getNodeMappings(potentialNodeDependency.getTargetNode());

			// check all matches of the source node
			//
			for (ApplicationConditionMatch applicationConditionMatch : ruleElementMapping1
					.getApplicationConditionMatches()) {

				// get element of the source node that is a forbidden or required element
				//
				Set<SuperimposedElement> srcElements = applicationConditionMatch.getACNodeMapping()
						.get(potentialNodeDependency.getSourceNode());

				// check if the source node and target node are mapped to the same element(s),
				// i.e., the potential node dependency is an actual one
				//
				if (srcElements != null && !Collections.disjoint(srcElements, tgtElements)) {
					Set<Entity> elements = new HashSet<Entity>(srcElements);
					elements.retainAll(tgtElements);

					applicationConditionMatch.addPartialDependency(deltaModule2, ruleElementMapping2.getDeltaAction(),
							createDependencyDetail(elements, potentialDependency));

					// in case of delete/forbid node dependency, check if the deleted element of the
					// target node contains attribute values that are forbidden by the source node,
					// leading to an implicit delete/forbid attribute dependency
					// Note that create/require attribute dependencies are detected by
					// checkAttributeDependency
					if (potentialDependency.getKind() == PotentialDependencyKind.DELETE_FORBID) {
						assert tgtElements.size() == 1 : "only one target element expected!";
						SuperimposedElement tgtElement = tgtElements.iterator().next();
						for (org.eclipse.emf.henshin.model.Attribute srcAttribute : potentialNodeDependency
								.getSourceNode().getAttributes()) {
							Set<Attribute> srcAttributes = applicationConditionMatch.getACAttributeMapping()
									.get(srcAttribute);

							for (Attribute tgtAttribute : tgtElement.getAttributes(srcAttribute.getType()).stream()
									.filter(attribute -> attribute.getAnnotations().stream()
											.anyMatch(annotation -> annotation.getBody().toString()
													.equals("not(" + deltaModule2.getName() + ")")))
									.collect(Collectors.toSet())) {
								if (srcAttributes.contains(tgtAttribute)) {

									Set<Entity> attributes = Collections.singleton(tgtAttribute);
									DependencyDetail attribute_detail = createDependencyDetail(attributes,
											potentialDependency);
									applicationConditionMatch.addPartialDependency(deltaModule2,
											ruleElementMapping2.getDeltaAction(), attribute_detail);

								}
							}
						}
					}
				}
			}
		} else {

			// get element of the source node that is a preserved, created or deleted
			// element
			//
			Set<SuperimposedElement> srcElements = ruleElementMapping1
					.getNodeMappings(potentialNodeDependency.getSourceNode());

			// get element of the target node that is a created or deleted element
			//
			Set<SuperimposedElement> tgtElements = ruleElementMapping2
					.getNodeMappings(potentialNodeDependency.getTargetNode());

			// check if the source node and target node are mapped to the same element(s),
			// i.e., the potential node dependency is an actual one
			//
			if (!Collections.disjoint(srcElements, tgtElements)) {
				Set<Entity> elements = new HashSet<Entity>(srcElements);
				elements.retainAll(tgtElements);
				DependencyDetail detail = createDependencyDetail(elements, potentialDependency);
				dependencyDetails.add(detail);
			}
		}
	}

	/**
	 * Checks if a {@link PotentialEdgeDependency} between the source and target
	 * delta action is a real one
	 * 
	 * @param potentialDependency the {@link PotentialDependency} to check
	 * @param dependencyDetails   a {@link Set} of detected dependencies
	 */
	private void checkEdgeDependency(PotentialDependency potentialDependency, Set<DependencyDetail> dependencyDetails) {

		PotentialEdgeDependency potentialEdgeDependency = (PotentialEdgeDependency) potentialDependency;

		// check if the conflict is due to an application condition (AC)
		//
		if (potentialDependency.isCondition()) {

			// get reference of the target edge that is a deleted or created reference
			//
			Set<Reference> tgtReferences = ruleElementMapping2.getEdgeMappings(potentialEdgeDependency.getTargetEdge());

			// check all matches of the source edge
			//
			for (ApplicationConditionMatch applicationConditionMatch : ruleElementMapping1
					.getApplicationConditionMatches()) {

				// get reference of the source edge that is a forbidden or required reference
				//
				Set<Reference> srcReferences = applicationConditionMatch.getACEdgeMapping()
						.get(potentialEdgeDependency.getSourceEdge());

				// check if the source edge and target edge are mapped to the same reference(s),
				// i.e., the potential edge dependency is an actual one
				//
				if (srcReferences != null && !Collections.disjoint(srcReferences, tgtReferences)) {
					Set<Entity> references = new HashSet<Entity>(srcReferences);
					references.retainAll(tgtReferences);

					applicationConditionMatch.addPartialDependency(deltaModule2, ruleElementMapping2.getDeltaAction(),
							createDependencyDetail(references, potentialDependency));

				}
			}
		} else {

			// get reference of the source edge that is a preserved, created or deleted
			// reference
			//
			Set<Reference> srcReferences = ruleElementMapping1.getEdgeMappings(potentialEdgeDependency.getSourceEdge());

			// get reference of the target edge that is a created or deleted reference
			//
			Set<Reference> tgtReferences = ruleElementMapping2.getEdgeMappings(potentialEdgeDependency.getTargetEdge());

			// check if the source edge and target edge are mapped to the same reference(s),
			// i.e., the potential edge dependency is an actual one
			//
			if (!Collections.disjoint(srcReferences, tgtReferences)) {
				Set<Entity> references = new HashSet<Entity>(srcReferences);
				references.retainAll(tgtReferences);
				DependencyDetail detail = createDependencyDetail(references, potentialDependency);
				dependencyDetails.add(detail);
			}
		}
	}

	/**
	 * Checks if a {@link PotentialDanglingEdgeDependency} between the source and
	 * target delta action is a real one
	 * 
	 * @param potentialDependency the {@link PotentialDependency} to check
	 * @param dependencyDetails   a {@link Set} of detected dependencies
	 */
	private void checkDanglingEdgeDependency(PotentialDependency potentialDependency,
			Set<DependencyDetail> dependencyDetails) {

		PotentialDanglingEdgeDependency potentialDanglingEdgeConflict = (PotentialDanglingEdgeDependency) potentialDependency;

		// Get deletion references with source and target elements
		//
		Set<Reference> predecessorDeletionReferences = new HashSet<Reference>(
				ruleElementMapping2.getEdgeMappings(potentialDanglingEdgeConflict.getDeletionEdge()));
		Set<SuperimposedElement> referencedElements = predecessorDeletionReferences.stream()
				.map(r -> (SuperimposedElement) r.getSource()).collect(Collectors.toSet());
		referencedElements.addAll(predecessorDeletionReferences.stream().map(r -> (SuperimposedElement) r.getTarget())
				.collect(Collectors.toSet()));

		// Get deletion element with incoming and outgoing references having the same
		// type as the deletion references
		//
		Set<SuperimposedElement> deletionElement = ruleElementMapping1
				.getNodeMappings(potentialDanglingEdgeConflict.getDeletionNode());
		Set<Reference> successorDeletionReferences = new HashSet<Reference>();
		potentialDanglingEdgeConflict.getDeletionNode()
				.getOutgoing(potentialDanglingEdgeConflict.getDeletionEdge().getType())
				.forEach(edge -> successorDeletionReferences.addAll(ruleElementMapping1.getEdgeMappings(edge)));
		potentialDanglingEdgeConflict.getDeletionNode()
				.getIncoming(potentialDanglingEdgeConflict.getDeletionEdge().getType())
				.forEach(edge -> successorDeletionReferences.addAll(ruleElementMapping1.getEdgeMappings(edge)));

		// remove all creation references that are deleted
		//
		predecessorDeletionReferences.removeAll(successorDeletionReferences);

		// check if their exist at least one creation reference that isn't removed and
		// if the source or target element is removed
		//
		if (!predecessorDeletionReferences.isEmpty() && !Collections.disjoint(referencedElements, deletionElement)) {
			Set<Entity> entities = new HashSet<Entity>();
			entities.addAll(predecessorDeletionReferences);
			DependencyDetail detail = createDependencyDetail(entities, potentialDependency);
			dependencyDetails.add(detail);
		}
	}

	/**
	 * Checks if a {@link PotentialAttributeDependency} between the source and
	 * target delta action is a real one
	 * 
	 * @param potentialDependency the {@link PotentialDependency} to check
	 * @param dependencyDetails   a {@link Set} of detected dependencies
	 */
	private void checkAttributeDependency(PotentialDependency potentialDependency,
			Set<DependencyDetail> dependencyDetails) {
		PotentialAttributeDependency pad = (PotentialAttributeDependency) potentialDependency;

		if (pad.isCondition()) {

			// get element of target node that is a preserved or delete element
			//
			Set<SuperimposedElement> tgtElements_Attribute = ruleElementMapping2
					.getNodeMappings(pad.getTargetAttribute().getNode());

			// check all matches of the source edge
			//
			for (ApplicationConditionMatch applicationConditionMatch : ruleElementMapping1
					.getApplicationConditionMatches()) {

				// get the element of the source node if it is a preserved element
				//
				Set<SuperimposedElement> srcElements_Attribute = ruleElementMapping1
						.getNodeMappings(pad.getSourceAttribute().getNode());

				// get the element of the source node from application condition match if it is
				// a required or forbidden element
				//
				if (srcElements_Attribute == null) {
					srcElements_Attribute = applicationConditionMatch.getACNodeMapping()
							.get(pad.getSourceAttribute().getNode());
				}

				// check if the source and target nodes are mapped onto the same element
				//
				if (srcElements_Attribute.equals(tgtElements_Attribute)) {

					// get the attribute value of the source attribute from application condition
					// match that is a forbidden or required attribute value
					//
					Set<Attribute> srcAttributes = applicationConditionMatch.getACAttributeMapping()
							.get(pad.getSourceAttribute());

					// get the attribute value of the target attribute that is a set, unset or
					// changed
					//
					Set<Attribute> tgtAttributes = ruleElementMapping2.getAttributeMappings(pad.getTargetAttribute());

					if (potentialDependency.getKind() == PotentialDependencyKind.CHANGE_FORBID) {
						// get the origin attribute value of the target attribute that is actually a
						// set, unset or changed
						//
						tgtAttributes = ruleElementMapping2.getAttributeSetOriginMappings(pad.getTargetAttribute());

					}

					// check if the source attribute and target attribute are mapped to the same
					// attribute value(s), i.e., the potential attribute dependency is an actual one
					//
					if (!Collections.disjoint(srcAttributes, tgtAttributes)) {
						Set<Entity> elements = new HashSet<Entity>(srcAttributes);
						elements.retainAll(tgtAttributes);

						applicationConditionMatch.addPartialDependency(deltaModule2,
								ruleElementMapping2.getDeltaAction(),
								createDependencyDetail(elements, potentialDependency));

					}
				}

			}
		} else {

			Set<SuperimposedElement> srcElements_Attribute = ruleElementMapping1
					.getNodeMappings(pad.getSourceAttribute().getNode());
			Set<SuperimposedElement> tgtElements_attribute = ruleElementMapping2
					.getNodeMappings(pad.getTargetAttribute().getNode());
			if (!(srcElements_Attribute.isEmpty() || tgtElements_attribute.isEmpty())
					&& srcElements_Attribute.equals(tgtElements_attribute)) {
				Set<Attribute> srcAttributes = ruleElementMapping1.getAttributeMappings(pad.getSourceAttribute());
				Set<Attribute> tgtAttributes = ruleElementMapping2.getAttributeMappings(pad.getTargetAttribute());
				if (!Collections.disjoint(srcAttributes, tgtAttributes)) {
					Set<Entity> entities = new HashSet<Entity>(srcAttributes);
					entities.retainAll(tgtAttributes);
					DependencyDetail detail = createDependencyDetail(entities, potentialDependency);
					dependencyDetails.add(detail);
				}
			}
		}
	}

	/**
	 * Creates a {@link DependencyDetail} according to the
	 * {@link PotentialDependency} kind
	 * 
	 * @param entities            a {@link Set} of {@link Entity} being in conflict
	 * @param potentialDependency the {@link PotentialDependency} that is a real one
	 * @return a {@link DependencyDetail} containing the entities depending on each
	 *         other according to the {@link PotentialDependency}
	 */
	private DependencyDetail createDependencyDetail(Set<Entity> entities, PotentialDependency potentialDependency) {
		DependencyDetail detail = FACTORY.createDependencyDetail();
		detail.setKind(AnalysisUtils.DEPENDENCY_KIND.get(potentialDependency.getKind()));
		detail.getEntities().addAll(entities);
		detail.setTransient(potentialDependency.isRevert());
		detail.setCondition(potentialDependency.isCondition());
		return detail;
	}
}
