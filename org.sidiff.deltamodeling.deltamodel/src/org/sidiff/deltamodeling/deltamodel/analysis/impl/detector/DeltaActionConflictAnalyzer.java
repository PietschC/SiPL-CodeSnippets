package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.ConflictKind;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch.PartialConflict;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.PotentialAttributeConflict;
import org.sidiff.editrule.rulebase.PotentialConflict;
import org.sidiff.editrule.rulebase.PotentialConflictKind;
import org.sidiff.editrule.rulebase.PotentialDanglingEdgeConflict;
import org.sidiff.editrule.rulebase.PotentialEdgeConflict;
import org.sidiff.editrule.rulebase.PotentialNodeConflict;
import org.sidiff.editrule.rulebase.RulebasePackage;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * Extends {@link DeltaActionRelationAnalyzer} for detecting {@link Conflict}s
 * between delta actions.
 * 
 * @author cpietsch
 *
 */
public class DeltaActionConflictAnalyzer extends DeltaActionRelationAnalyzer<Conflict> {	
	
	public DeltaActionConflictAnalyzer(Set<IEditRuleBase> ruleBases, Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}
	
	@Override
	public Conflict analyze(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {

		// resolve the rule element mappings
		//
		this.ruleElementMapping1 = resolveRuleElementMapping(deltaAction1, deltaModule1);
		this.ruleElementMapping2 = resolveRuleElementMapping(deltaAction2, deltaModule2);
		
		// get potential conflicts between the respective delta operations
		//
		Set<PotentialConflict> potentialConflicts = AnalysisUtils.getPotentialConflicts(this.ruleElementMapping1.getEditRule(), this.ruleElementMapping2.getEditRule(), ruleBases);	
				
		if(!potentialConflicts.isEmpty()){
			Set<ConflictDetail> conflictDetails = new HashSet<ConflictDetail>();
			for(PotentialConflict potentialConflict : potentialConflicts){
			
				switch (potentialConflict.eClass().getClassifierID()) {
				case RulebasePackage.POTENTIAL_NODE_CONFLICT:
					checkNodeConflict(potentialConflict, conflictDetails);
					break;
				case RulebasePackage.POTENTIAL_EDGE_CONFLICT:
					checkEdgeConflict(potentialConflict, conflictDetails);
					break;
				case RulebasePackage.POTENTIAL_DANGLING_EDGE_CONFLICT:
					checkDanglingEdgeConflict(potentialConflict, conflictDetails);
					break;
				case RulebasePackage.POTENTIAL_ATTRIBUTE_CONFLICT:
					checkAttributeConflict(potentialConflict, conflictDetails);
					break;
				default:
					LogUtil.log(LogEvent.WARNING, "Unsupported potential conflict:  " + potentialConflict.eClass().getName()
							+ ": " + potentialConflict.getKind());
					break;
				}
			}
	
//			checkApplicationConditionCoverage(conflictDetails);
			
			// create conflict if at least one conflict detail has been created
			//
			if(!conflictDetails.isEmpty()){
				Conflict conflict = FACTORY.createConflict();
				conflict.setSourceDeltaAction(deltaAction1);
				conflict.setTargetDeltaAction(deltaAction2);
				conflict.getDetails().addAll(conflictDetails);
				return conflict;
			}
		}
		return null;
	}
	
	
	@SuppressWarnings("unused")
	private void checkApplicationConditionCoverage(Set<ConflictDetail> conflictDetails) {
		
		for(ApplicationConditionMatch applicationConditionMatch : ruleElementMapping2.getApplicationConditionMatches()) {
			PartialConflict partialConflict = applicationConditionMatch.getPartialConflict(ruleElementMapping1.getDeltaAction());
			if(partialConflict != null && partialConflict.isCompleteMatch()) {
				conflictDetails.addAll(partialConflict.getDetails());
			}
		}
	}


	/**
	 * Checks if a {@link PotentialNodeConflict} between the source and target delta
	 * action is a real one
	 * 
	 * @param potentialConflict the {@link PotentialConflict} to check
	 * @param conflictDetails   a {@link Set} of detected conflicts
	 */
	private void checkNodeConflict(PotentialConflict potentialConflict, Set<ConflictDetail> conflictDetails) {
		
		PotentialNodeConflict potentialNodeConflict = (PotentialNodeConflict) potentialConflict;
		
		// get element of source node that is a deleted or created element
		//
		Set<SuperimposedElement> srcElements = ruleElementMapping1.getNodeMappings(potentialNodeConflict.getSourceNode());
		
		//check if the conflict is due to an application condition (AC)
		//
		if(potentialConflict.isCondition()) {
			
			// check all matches of the target node
			//
			for(ApplicationConditionMatch applicationConditionMatch : ruleElementMapping2.getApplicationConditionMatches()) {
				
				// get element of the target node that is a required or forbidden element
				//
				Set<SuperimposedElement> tgtElements = applicationConditionMatch.getACNodeMapping().get(potentialNodeConflict.getTargetNode());
				
				// check if the source node and target node are mapped to the same element(s), i.e., the potential node conflict is an actual one
				//
				if (tgtElements != null && !Collections.disjoint(srcElements, tgtElements)) {
					Set<Entity> elements = new HashSet<Entity>(srcElements);
					elements.retainAll(tgtElements);
					applicationConditionMatch.addPartialConflict(deltaModule1, ruleElementMapping1.getDeltaAction(), createConflictDetail(elements, potentialConflict));
					// in case of delete/require node dependency, check if the deleted element of
					// the source node contains attribute values that are required by the target
					// node, leading to an implicit delete/require attribute dependency
					// Note that create/forbid attribute conflicts are detected by
					// checkAttributeConflicts
					if (potentialConflict.getKind() == PotentialConflictKind.DELETE_USE) {
						assert tgtElements.size() == 1 : "only one source element expected!";
						SuperimposedElement srcElement = srcElements.iterator().next();
						for (org.eclipse.emf.henshin.model.Attribute targetAttribute : potentialNodeConflict
								.getTargetNode().getAttributes()) {
							Set<Attribute> targetAttributes = applicationConditionMatch.getACAttributeMapping()
									.get(targetAttribute);

							for (Attribute srcAttribute : srcElement.getAttributes(targetAttribute.getType())
									.stream()
									.filter(attribute -> attribute.getAnnotations().stream()
											.anyMatch(annotation -> annotation.getBody().toString()
															.equals("not(" + deltaModule1.getName() + ")")))
									.collect(Collectors.toSet())) {
								if (targetAttributes.contains(srcAttribute)) {

									Set<Entity> attributes = Collections.singleton(srcAttribute);
									applicationConditionMatch.addPartialConflict(deltaModule1,
											ruleElementMapping1.getDeltaAction(),
											createConflictDetail(attributes, potentialConflict));
								}
							}
						}
					}else if(potentialConflict.getKind() == PotentialConflictKind.CREATE_FORBID) {
						assert tgtElements.size() == 1 : "only one source element expected!";
						applicationConditionMatch.addPartialConflict(deltaModule1, ruleElementMapping1.getDeltaAction(), createConflictDetail(elements, potentialConflict));
						SuperimposedElement srcElement = srcElements.iterator().next();
						for (org.eclipse.emf.henshin.model.Attribute targetAttribute : potentialNodeConflict
								.getTargetNode().getAttributes()) {
							Set<Attribute> targetAttributes = applicationConditionMatch.getACAttributeMapping()
									.get(targetAttribute);

							for (Attribute srcAttribute : srcElement.getAttributes(targetAttribute.getType())
									.stream()
									.filter(attribute -> attribute.getAnnotations().stream()
											.anyMatch(annotation -> annotation.getBody().toString()
															.equals(deltaModule1.getName())))
									.collect(Collectors.toSet())) {
								if (targetAttributes.contains(srcAttribute)) {

									Set<Entity> attributes = Collections.singleton(srcAttribute);
									applicationConditionMatch.addPartialConflict(deltaModule1,
											ruleElementMapping1.getDeltaAction(),
											createConflictDetail(attributes, potentialConflict));
								}
							}
						}
					}
				}
			}
		}else {
			
			// get element of the target node that is a preserved element
			//
			Set<SuperimposedElement> tgtElements = ruleElementMapping2.getNodeMappings(potentialNodeConflict.getTargetNode());
			
			// check if the source node and target node are mapped to the same element(s), i.e., the potential node conflict is an actual one
			//
			if (!Collections.disjoint(srcElements, tgtElements)) {
				Set<Entity> elements = new HashSet<Entity>(srcElements);
				elements.retainAll(tgtElements);
				ConflictDetail detail = createConflictDetail(elements, potentialConflict);
				conflictDetails.add(detail);
			}
		}
	}
	
	/**
	 * Checks if a {@link PotentialEdgeConflict} between the source and target delta
	 * action is a real one
	 * 
	 * @param potentialConflict the {@link PotentialConflict} to check
	 * @param conflictDetails   a {@link Set} of detected conflicts
	 */
	private void checkEdgeConflict(PotentialConflict potentialConflict, Set<ConflictDetail> conflictDetails) {
		
		PotentialEdgeConflict potentialEdgeConflict = (PotentialEdgeConflict) potentialConflict;

		// get reference of source edge that is a deleted or created reference
		//
		Set<Reference> srcReferences = ruleElementMapping1.getEdgeMappings(potentialEdgeConflict.getSourceEdge());
		
		//check if the conflict is due to an application condition (AC)
		//
		if(potentialConflict.isCondition()) {
			
			// check all matches of the target edge
			//
			for(ApplicationConditionMatch applicationConditionMatch : ruleElementMapping2.getApplicationConditionMatches()) {
				
				// get reference of the target edge that is a required or forbidden reference
				//
				Set<Reference> tgtReferences = applicationConditionMatch.getACEdgeMapping().get(potentialEdgeConflict.getTargetEdge());
				
				// check if the source edge and target edge are mapped to the same reference(s), i.e., the potential edge conflict is an actual one
				//
				if (tgtReferences != null && !Collections.disjoint(srcReferences, tgtReferences)) {
					Set<Entity> references = new HashSet<Entity>(srcReferences);
					references.retainAll(tgtReferences);
					applicationConditionMatch.addPartialConflict(deltaModule1, ruleElementMapping1.getDeltaAction(), createConflictDetail(references, potentialConflict));
				}
			}
		}else {
			
			// get reference of the target edge that is a preserved reference
			//
			Set<Reference> tgtReferences = ruleElementMapping2.getEdgeMappings(potentialEdgeConflict.getTargetEdge());
			
			// check if the source edge and target edge are mapped to the same reference(s), i.e., the potential edge conflict is an actual one
			//
			if (!Collections.disjoint(srcReferences, tgtReferences)) {
				Set<Entity> references = new HashSet<Entity>(srcReferences);
				references.retainAll(tgtReferences);
				ConflictDetail detail = createConflictDetail(references, potentialConflict);
				conflictDetails.add(detail);
			}
		}
	}
	
	/**
	 * Checks if a {@link PotentialDanglingEdgeConflict} between the source and
	 * target delta action is a real one
	 * 
	 * @param potentialConflict potentialConflict the {@link PotentialConflict} to
	 *                          check
	 * @param conflictDetails   a {@link Set} of detected conflicts
	 */
	private void checkDanglingEdgeConflict(PotentialConflict potentialConflict,
			Set<ConflictDetail> conflictDetails) {
		
		PotentialDanglingEdgeConflict potentialDanglingEdgeConflict = (PotentialDanglingEdgeConflict) potentialConflict;
		
		// Get creation references with source and target elements
		//
		Set<Reference> creationReferences = new HashSet<Reference>(ruleElementMapping1.getEdgeMappings(potentialDanglingEdgeConflict.getCreationEdge()));
		Set<SuperimposedElement> referencedElements = creationReferences.stream().map(r -> (SuperimposedElement) r.getSource()).collect(Collectors.toSet());
		referencedElements.addAll(creationReferences.stream().map(r -> (SuperimposedElement) r.getTarget()).collect(Collectors.toSet()));
		
		// Get deletion element with incoming and outgoing references having the same type as the creation references
		//
		Set<SuperimposedElement> deletionElement = ruleElementMapping2.getNodeMappings(potentialDanglingEdgeConflict.getDeletionNode());
		Set<Reference> deletionReferences = new HashSet<Reference>();
		potentialDanglingEdgeConflict.getDeletionNode().getOutgoing(potentialDanglingEdgeConflict.getCreationEdge().getType()).forEach(edge -> deletionReferences.addAll(ruleElementMapping2.getEdgeMappings(edge)));
		potentialDanglingEdgeConflict.getDeletionNode().getIncoming(potentialDanglingEdgeConflict.getCreationEdge().getType()).forEach(edge -> deletionReferences.addAll(ruleElementMapping2.getEdgeMappings(edge)));

		// remove all creation references that are deleted
		//
		creationReferences.removeAll(deletionReferences);
		
		// check if their exist at least one creation reference that isn't removed and if the source or target element is removed
		//
		if (!creationReferences.isEmpty() && !Collections.disjoint(referencedElements, deletionElement)) {
			Set<Entity> entities = new HashSet<Entity>();
			entities.addAll(creationReferences);
			ConflictDetail detail = createConflictDetail(entities, potentialConflict);
			conflictDetails.add(detail);
		}
	}
	
	/**
	 * Checks if a {@link PotentialAttributeConflict} between the source and target
	 * delta action is a real one
	 * 
	 * @param potentialConflict the {@link PotentialConflict} to check
	 * @param conflictDetails   a {@link Set} of detected conflicts
	 */
	private void checkAttributeConflict(PotentialConflict potentialConflict,
			Set<ConflictDetail> conflictDetails) {
		
		PotentialAttributeConflict potentialAttributeConflict = (PotentialAttributeConflict) potentialConflict;
		
		// get the element of the source node that may be a deleted, created or preserved element
		//
		Set<SuperimposedElement> srcElements_Attribute = ruleElementMapping1
				.getNodeMappings(potentialAttributeConflict.getSourceAttribute().getNode());
		
		if(potentialAttributeConflict.isCondition()) {
			for(ApplicationConditionMatch applicationConditionMatch : ruleElementMapping2.getApplicationConditionMatches()) {
				// get the element of the target node if it is a preserved element
				//
				Set<SuperimposedElement> tgtElements_attribute = ruleElementMapping2
						.getNodeMappings(potentialAttributeConflict.getTargetAttribute().getNode());
				
				// get the element of the target node from application condition match if it is a required or forbidden element
				//
				if(tgtElements_attribute == null) {
					tgtElements_attribute = applicationConditionMatch.getACNodeMapping().get(potentialAttributeConflict.getTargetAttribute().getNode());
				}
				
				// check if the source and target nodes are mapped onto the same element
				//
				if(srcElements_Attribute.equals(tgtElements_attribute)) {
					// get the attribute value of the source attribute that is a unset, set or changed attribute value
					//
					Set<Attribute> srcAttributes = ruleElementMapping1
							.getAttributeMappings(potentialAttributeConflict.getSourceAttribute());
					
					// get the attribute value of the target attribute from application condition match that is a required or forbidden attribute value
					//
					Set<Attribute> tgtAttributes = applicationConditionMatch.getACAttributeMapping().get(potentialAttributeConflict.getTargetAttribute());
					
					// check if the source attribute and target attribute are mapped to the same attribute value(s), i.e., the potential attribute conflict is an actual one
					// 
					if (!Collections.disjoint(srcAttributes, tgtAttributes)) {
						Set<Entity> entities = new HashSet<Entity>(srcAttributes);
						entities.retainAll(tgtAttributes);
						applicationConditionMatch.addPartialConflict(deltaModule1, ruleElementMapping1.getDeltaAction(), createConflictDetail(entities, potentialConflict));
					}
				}
			}
		}else {
		
			// get the element of the target node
			//
			Set<SuperimposedElement> tgtElements_attribute = ruleElementMapping2
					.getNodeMappings(potentialAttributeConflict.getTargetAttribute().getNode());
			
			// check if the source and target nodes are mapped onto the same element
			//
			if (srcElements_Attribute.equals(tgtElements_attribute)) {
				
				// get the attribute of the source attribute
				//
				Set<Attribute> srcAttributes = ruleElementMapping1
						.getAttributeMappings(potentialAttributeConflict.getSourceAttribute());
				
				// get the attribute of the target attribute
				//
				Set<Attribute> tgtAttributes = ruleElementMapping2
						.getAttributeMappings(potentialAttributeConflict.getTargetAttribute());
				
				// check if the source attribute and target attribute are mapped to the same attributes(s), i.e., the potential attribute conflict is an actual one
				// FIXME case distinction between Change/Use and Change/Change
				if (!Collections.disjoint(srcAttributes, tgtAttributes) || potentialAttributeConflict.getKind() == PotentialConflictKind.CHANGE_CHANGE) {
					Set<Entity> entities = new HashSet<Entity>(srcAttributes);
					if(!Collections.disjoint(srcAttributes, tgtAttributes))
						entities.retainAll(tgtAttributes);
					else
						entities.addAll(tgtAttributes);
					ConflictDetail detail = createConflictDetail(entities, potentialConflict);
					conflictDetails.add(detail);
					detail.setSoft(detail.getKind() == ConflictKind.CHANGE_CHANGE);
					detail.setDuplicate(potentialAttributeConflict.isDuplicate());
				}
			}
		}
	}

	/**
	 * Creates a {@link ConflictDetail} according to the {@link PotentialConflict}
	 * kind
	 * 
	 * @param entities          a {@link Set} of {@link Entity} being in conflict
	 * @param potentialConflict the {@link PotentialConflict} that is a real one
	 * @return a {@link ConflictDetail} containing the entities being in conflict
	 *         according to the {@link PotentialConflict}
	 */
	private ConflictDetail createConflictDetail(Set<Entity> entities, PotentialConflict potentialConflict) {
		ConflictDetail detail = FACTORY.createConflictDetail();
		detail.setKind(AnalysisUtils.CONFLICT_KIND.get(potentialConflict.getKind()));
		detail.getEntities().addAll(entities);
		detail.setDuplicate(potentialConflict.isDuplicate());
		detail.setCondition(potentialConflict.isCondition());
		return detail;
	}	
}
