package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.Duplicate;
import org.sidiff.deltamodeling.deltamodel.DuplicateDetail;
import org.sidiff.deltamodeling.deltamodel.DuplicateKind;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * Extends {@link DeltaActionRelationAnalyzer} for detecting duplicates between
 * delta actions.
 * 
 * @author cpietsch
 *
 */
public class DeltaActionDuplicateAnalyzer extends DeltaActionRelationAnalyzer<Duplicate> {

	public DeltaActionDuplicateAnalyzer(Set<IEditRuleBase> ruleBases, Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}

	@Override
	public Duplicate analyze(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {

		this.ruleElementMapping1 = resolveRuleElementMapping(deltaAction1, deltaModule1);
		this.ruleElementMapping2 = resolveRuleElementMapping(deltaAction2, deltaModule2);

		if (this.ruleElementMapping1.getEditRule().equals(this.ruleElementMapping2.getEditRule())) {
			Conflict conflict = getOutgoingConflict(deltaAction1, deltaAction2);
			if (conflict != null) {
				Set<DuplicateDetail> duplicateDetails = new HashSet<DuplicateDetail>();

				if (!checkDuplicateNodeAction(ruleElementMapping1.getDeletionNodes(),
						ruleElementMapping2.getDeletionNodes(), DuplicateKind.DELETE_DELETE, duplicateDetails))
					return null;
				if (!checkDuplicateNodeAction(ruleElementMapping1.getCreationNodes(),
						ruleElementMapping2.getCreationNodes(), DuplicateKind.CREATE_CREATE, duplicateDetails))
					return null;
				if (!checkDuplicateEdgeAction(ruleElementMapping1.getDeletionEdges(),
						ruleElementMapping2.getDeletionEdges(), DuplicateKind.DELETE_DELETE, duplicateDetails))
					return null;
				if (!checkDuplicateEdgeAction(ruleElementMapping1.getCreationEdges(),
						ruleElementMapping2.getCreationEdges(), DuplicateKind.CREATE_CREATE, duplicateDetails))
					return null;
				if (!checkDuplicateAttributeAction(ruleElementMapping1.getSetAttributes(),
						ruleElementMapping2.getSetAttributes(), DuplicateKind.CHANGE_CHANGE, duplicateDetails))
					return null;
				if (!checkDuplicateAttributeAction(ruleElementMapping1.getChangeAttributes(),
						ruleElementMapping2.getChangeAttributes(), DuplicateKind.CHANGE_CHANGE, duplicateDetails))
					return null;

				Duplicate duplicate = FACTORY.createDuplicate();
				duplicate.getDeltaActions().add(deltaAction1);
				duplicate.getDeltaActions().add(deltaAction2);
				duplicate.getDetails().addAll(duplicateDetails);
				duplicate.getConflict().add(conflict);
				Conflict incomingConflict = getIncomingConflict(deltaAction1, deltaAction2);
				if(incomingConflict != null) {
					duplicate.getConflict().add(getIncomingConflict(deltaAction1, deltaAction2));
				}
				return duplicate;

			}
		}
		return null;
	}

	/**
	 * Checks if a ...
	 * @param nodes1
	 * @param nodes2
	 * @param kind
	 * @param duplicateDetails
	 * @return
	 */
	private boolean checkDuplicateNodeAction(Collection<Node> nodes1, Collection<Node> nodes2, DuplicateKind kind,
			Collection<DuplicateDetail> duplicateDetails) {

		for (Node srcNode : nodes1) {
			boolean hasDuplicate = false;
			for (Node tgtNode : nodes2) {
				Set<SuperimposedElement> srcElements = ruleElementMapping1.getNodeMappings(srcNode);
				Set<SuperimposedElement> tgtElements = ruleElementMapping2.getNodeMappings(tgtNode);
				if (srcElements.equals(tgtElements)) {
					Set<Entity> elements = new HashSet<Entity>(srcElements);
					elements.retainAll(tgtElements);
					duplicateDetails.add(createDuplicateDetail(elements, kind));
					hasDuplicate = checkDuplicateAttributeAction(srcNode.getAttributes(), tgtNode.getAttributes(), kind,
							duplicateDetails);
					break;

				}
			}
			if (!hasDuplicate) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks if ...
	 * @param edges1
	 * @param edges2
	 * @param kind
	 * @param duplicateDetails
	 * @return
	 */
	private boolean checkDuplicateEdgeAction(Collection<Edge> edges1, Collection<Edge> edges2, DuplicateKind kind,
			Collection<DuplicateDetail> duplicateDetails) {

		for (Edge srcEdge : edges1) {
			boolean hasDuplicate = false;
			for (Edge tgtEdge : edges2) {
				Set<Reference> srcReferences = ruleElementMapping1.getEdgeMappings(srcEdge);
				Set<Reference> tgtReferences = ruleElementMapping2.getEdgeMappings(tgtEdge);
				if (srcReferences.equals(tgtReferences)) {
					hasDuplicate = true;
					Set<Entity> references = new HashSet<Entity>(srcReferences);
					references.retainAll(tgtReferences);
					duplicateDetails.add(createDuplicateDetail(references, kind));
				}
			}
			if (!hasDuplicate) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks if ...
	 * @param attributes1
	 * @param attributes2
	 * @param kind
	 * @param duplicateDetails
	 * @return
	 */
	private boolean checkDuplicateAttributeAction(Collection<org.eclipse.emf.henshin.model.Attribute> attributes1,
			Collection<org.eclipse.emf.henshin.model.Attribute> attributes2, DuplicateKind kind,
			Collection<DuplicateDetail> duplicateDetails) {
		for (org.eclipse.emf.henshin.model.Attribute srcAttribute : attributes1) {
			Set<SuperimposedElement> srcElements = ruleElementMapping1.getNodeMappings(srcAttribute.getNode());
			boolean hasDuplicate = false;
			for (org.eclipse.emf.henshin.model.Attribute tgtAttribute : attributes2) {
				Set<SuperimposedElement> tgtElements = ruleElementMapping2.getNodeMappings(tgtAttribute.getNode());
				if (srcAttribute.getType().equals(tgtAttribute.getType()) && srcElements.equals(tgtElements)) {
					Set<Attribute> srcAttributesOrigin = ruleElementMapping1
							.getAttributeSetOriginMappings(srcAttribute);
					Set<Attribute> srcAttributesChanged = ruleElementMapping1.getAttributeMappings(srcAttribute);
					Set<Attribute> tgtAttributesOrigin = ruleElementMapping2
							.getAttributeSetOriginMappings(tgtAttribute);
					Set<Attribute> tgtAttributesChanged = ruleElementMapping2.getAttributeMappings(tgtAttribute);
					if (srcAttributesOrigin.equals(tgtAttributesOrigin)
							&& srcAttributesChanged.equals(tgtAttributesChanged)) {
						hasDuplicate = true;
						Set<Entity> attributes = new HashSet<Entity>(srcAttributesChanged);
						attributes.retainAll(tgtAttributesChanged);
						
						duplicateDetails.add(createDuplicateDetail(attributes, kind));
						break;
					}
				}
			}
			if (!hasDuplicate) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Creates a {@link DuplicateDetail}
	 * 
	 * @param entities a {@link Set} of {@link Entity} being created, deleted,
	 *                 changed by both rules in the same way under the same
	 *                 precondition
	 * @param kind     the {@link DuplicateKind}
	 * @return a {@link DuplicateDetail} containing entities created, deleted,
	 *         changed by both rules in the same way under the same precondition
	 */
	private DuplicateDetail createDuplicateDetail(Set<Entity> entities, DuplicateKind kind) {
		DuplicateDetail detail = FACTORY.createDuplicateDetail();
		detail.setKind(kind);
		detail.getEntities().addAll(entities);

		return detail;
	}

}
