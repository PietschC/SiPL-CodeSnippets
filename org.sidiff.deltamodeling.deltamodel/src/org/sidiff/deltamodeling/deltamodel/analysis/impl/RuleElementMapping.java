package org.sidiff.deltamodeling.deltamodel.analysis.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatcher;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.difference.symmetric.EditRuleMatch;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * Implementation of the interface {@link IRuleElementMapping}
 * 
 * @author cpietsch
 *
 */
public class RuleElementMapping implements IRuleElementMapping {
	
	/**
	 * The {@link OperationInvocation} representing an applied delta action
	 */
	protected OperationInvocation deltaAction;
	
	/**
	 * The {@link SemanticChangeSet} containing the edit rule match
	 */
	protected SemanticChangeSet semanticChangeSet;

	/**
	 * The {@link EditRule} for which this EditRuleMatch is created
	 */
	protected EditRule editRule;

	/**
	 * The {@link DeltaModule} needed for identifying attribute mappings
	 */
	protected DeltaModule deltaModule;

	/**
	 * All possible {@link ApplicationConditionMatch}es
	 * if the set contains multiple nacs xor pacs we use disjunction
	 * otherwise we use conjunction
	 */
	protected Set<ApplicationConditionMatch> applicationConditionMatches = new HashSet<ApplicationConditionMatch>();

	/**
	 * Mapping: EditRuleNode -> SuperimposedElement
	 * 
	 * <b>Convention</b>: EditRuleNode:
	 * <ul>
	 * <li>Preserved node -> LHS Node</li>
	 * <li>Deleted node -> LHS Node</li>
	 * <li>Created node -> RHS Node</li>
	 * </ul>
	 * 
	 */
	protected Map<Node, Set<SuperimposedElement>> nodeMappings = new HashMap<Node, Set<SuperimposedElement>>();

	/**
	 * All mapped creation nodes (RHS only)
	 */
	protected Set<Node> creationNodes = new HashSet<Node>();

	/**
	 * All mapped deletion nodes (LHS only)
	 */
	protected Set<Node> deletionNodes = new HashSet<Node>();

	/**
	 * All mapped preserved nodes (LHS)
	 */
	protected Set<Node> preservedNodes = new HashSet<Node>();

	/**
	 * All mapped required nodes (PAC)
	 */
	protected Set<Node> requiredNodes = new HashSet<Node>();

	/**
	 * All mapped forbidden nodes (NAC)
	 */
	protected Set<Node> forbiddenNodes = new HashSet<Node>();

	/**
	 * Mapping: EditRuleEdge -> Reference
	 * 
	 * <b>Convention</b>: EditRuleEdge:
	 * <ul>
	 * <li>Preserved edge -> LHS edge</li>
	 * <li>Deleted edge -> LHS edge</li>
	 * <li>Created edge -> RHS edge</li>
	 * </ul>
	 * 
	 */
	protected Map<Edge, Set<Reference>> edgeMappings = new HashMap<Edge, Set<Reference>>();

	/**
	 * All mapped creation edges (RHS only)
	 */
	protected Set<Edge> creationEdges = new HashSet<Edge>();

	/**
	 * All mapped deletion edges (LHS only)
	 */
	protected Set<Edge> deletionEdges = new HashSet<Edge>();

	/**
	 * All mapped preserved edges (LHS)
	 */
	protected Set<Edge> preservedEdges = new HashSet<Edge>();
	
	/**
	 * All mapped required edges (PAC)
	 */
	protected Set<Edge> requiredEdges = new HashSet<Edge>();

	/**
	 * All mapped frobidden edges (NAC)
	 */
	protected Set<Edge> forbiddenEdges = new HashSet<Edge>();

	/**
	 * Mapping: EditRuleAttribute -> Attribute
	 * 
	 * <b>Convention</b>: EditRuleAttribute:
	 * <ul>
	 * <li>Preserved attribute -> LHS/RHS</li>
	 * <li>unset attribute -> LHS attribute only</li>
	 * <li>set attribute -> RHS attribute only</li>
	 * </ul>
	 * 
	 */
	protected Map<org.eclipse.emf.henshin.model.Attribute, Set<Attribute>> attributeMappings = new HashMap<org.eclipse.emf.henshin.model.Attribute, Set<Attribute>>();

	/**
	 * Mapping: EditRuleAttribute -> Attribute
	 * 
	 * <b>Convention</b>: EditRuleAttribute: set attribute -> RHS attribute only
	 * mapped onto the origin attribute
	 */
	protected Map<org.eclipse.emf.henshin.model.Attribute, Set<Attribute>> attributeSetOriginMappings = new HashMap<org.eclipse.emf.henshin.model.Attribute, Set<Attribute>>();

	/**
	 * All mapped creation attributes in creation nodes (RHS only)
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> creationAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();

	/**
	 * All mapped deletion attributes in deletion nodes (LHS only)
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> deletionAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();

	/**
	 * All preserved attributes (LHS/RHS)
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> preservedAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();

	/**
	 * All changed attributes (LHS and/or RHS)
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> changeAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();

	/**
	 * All set attributes (RHS only in preserved node)
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> setAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();

	/**
	 * All forbidden attributes (nested condition)
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> forbiddenAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();
	
	/**
	 * All required attributes (nested condition)
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> requiredAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();
	
	/**
	 * Constructor
	 * 
	 * @param scs         the {@link SemanticChangeSet} containing the edit rule
	 *                    match
	 * @param editRule    the resolved {@link EditRule}
	 * @param deltaModule the {@link DeltaModule} containing the scs
	 */
	public RuleElementMapping(OperationInvocation deltaAction, EditRule editRule, DeltaModule deltaModule) {

		this.deltaAction = deltaAction;
		this.semanticChangeSet = deltaAction.getChangeSet();
		this.editRule = editRule;
		this.deltaModule = deltaModule;

		Resource henshinResource = editRule.getExecuteMainUnit().eResource();

		EditRuleMatch erMatch = semanticChangeSet.getEditRuleMatch();

		assert (erMatch != null) : "No EditRuleMatch has been seriaized for  SemanticChangeSet " + semanticChangeSet + "!";

		// Resolve node occurrences in A
		for (String fragment : erMatch.getNodeOccurrencesA().keySet()) {
			Node node = (Node) henshinResource.getEObject(fragment);

			assert (node != null) : "Node with the URI fragment " + fragment + " cannot be found in resource "
					+ henshinResource + "!";

			Set<SuperimposedElement> elements = new HashSet<SuperimposedElement>();

			for (EObject eObject : erMatch.getNodeOccurrencesA().get(fragment).toJavaSet()) {
				elements.add((SuperimposedElement) eObject);
			}

			nodeMappings.put(node, elements);

			assert node.getAction().getType().equals(Type.DELETE) || node.getAction().getType()
					.equals(Type.PRESERVE) : "Assertion faild: deletion or preserved node expected!";

			if (node.getAction().getType().equals(Type.DELETE)) {
				this.deletionNodes.add(node);
			} else {
				this.preservedNodes.add(node);
			}
		}

		// Resolve node occurrences in B
		for (String fragment : erMatch.getNodeOccurrencesB().keySet()) {
			Node node = (Node) henshinResource.getEObject(fragment);

			assert (node != null) : "Node with the URI fragment " + fragment + " cannot be found in resource "
					+ henshinResource + "!";

			assert HenshinRuleAnalysisUtilEx.isPreservedNode(node) && HenshinRuleAnalysisUtilEx.isLHS(node)
					|| HenshinRuleAnalysisUtilEx.isCreationNode(
							node) : "Assertion faild: node from lhs expected if node is a preserve node!";

			Set<SuperimposedElement> elements = new HashSet<SuperimposedElement>();

			for (EObject eObject : erMatch.getNodeOccurrencesB().get(fragment).toJavaSet()) {
				elements.add((SuperimposedElement) eObject);
			}

			assert !nodeMappings.containsKey(node) || nodeMappings.get(node)
					.equals(elements) : "Assertion failed: preserved noes must be mapped onto the same elements";

			if (!nodeMappings.containsKey(node)) {
				nodeMappings.put(node, elements);
//				assert node.getAction().getType().equals(Type.CREATE): "creation node expected!";
				if (node.getAction().getType().equals(Type.CREATE)) {
					this.creationNodes.add(node);
				} else {
					this.preservedNodes.add(node);
				}
			}
		}

		// Derive the edge occurrences
		deriveEdgeMappings();

		// Derive the attribute occurrences
		deriveAttributeOccurrences();

		// Derive the required and forbidden occurrences
		// TODO enable if application conditions should be considered
		deriveApplicationConditionOccurrences();
	}
	
	@Override
	public OperationInvocation getDeltaAction() {
		return this.deltaAction;
	}

	@Override
	public EditRule getEditRule() {
		return this.editRule;
	}

	@Override
	public Set<Node> getEditRuleNodes() {
		return Collections.unmodifiableSet(this.nodeMappings.keySet());
	}

	@Override
	public Set<Node> getCreationNodes() {
		return Collections.unmodifiableSet(this.creationNodes);
	}

	@Override
	public Set<Node> getDeletionNodes() {
		return Collections.unmodifiableSet(this.deletionNodes);
	}

	@Override
	public Set<Node> getPreservedNodes() {
		return Collections.unmodifiableSet(this.preservedNodes);
	}

	@Override
	public Set<Edge> getEditRuleEdges() {
		return Collections.unmodifiableSet(this.edgeMappings.keySet());
	}

	@Override
	public Set<Edge> getCreationEdges() {
		return Collections.unmodifiableSet(this.creationEdges);
	}

	@Override
	public Set<Edge> getDeletionEdges() {
		return Collections.unmodifiableSet(this.deletionEdges);
	}

	@Override
	public Set<Edge> getPreservedEdges() {
		return Collections.unmodifiableSet(preservedEdges);
	}

	@Override
	public Set<org.eclipse.emf.henshin.model.Attribute> getEditRuleAttributes() {
		return Collections.unmodifiableSet(this.attributeMappings.keySet());
	}

	@Override
	public Set<org.eclipse.emf.henshin.model.Attribute> getCreationAttributes() {
		return Collections.unmodifiableSet(this.creationAttributes);
	}

	@Override
	public Set<org.eclipse.emf.henshin.model.Attribute> getDeletionAttributes() {
		return Collections.unmodifiableSet(this.deletionAttributes);
	}

	@Override
	public Set<org.eclipse.emf.henshin.model.Attribute> getPreservedAttributes() {
		return Collections.unmodifiableSet(this.preservedAttributes);
	}

	@Override
	public Set<org.eclipse.emf.henshin.model.Attribute> getChangeAttributes() {
		return Collections.unmodifiableSet(this.changeAttributes);
	}

	@Override
	public Set<org.eclipse.emf.henshin.model.Attribute> getSetAttributes() {
		return Collections.unmodifiableSet(this.setAttributes);
	}

	public Set<org.eclipse.emf.henshin.model.Attribute> getSetAttributes(Node node) {
		Node rhsNode = HenshinRuleAnalysisUtilEx.getRHS(node);
		Set<org.eclipse.emf.henshin.model.Attribute> rhsAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();
		for (org.eclipse.emf.henshin.model.Attribute attribute : rhsNode.getAttributes()) {
			if (this.setAttributes.contains(attribute)) {
				rhsAttributes.add(attribute);
			}
		}
		return rhsAttributes;
	}

	@Override
	public Set<SuperimposedElement> getNodeMappings(Node editRuleNode) {
		Node keyNode = getKeyNode(editRuleNode);
		if (nodeMappings.containsKey(keyNode)) {
			return nodeMappings.get(keyNode);
		} else {
			return Collections.emptySet();
		}
	}

	@Override
	public Set<Reference> getEdgeMappings(Edge editRuleEdge) {
		Edge keyEdge = getKeyEdge(editRuleEdge);
		if (edgeMappings.containsKey(keyEdge)) {
			return edgeMappings.get(keyEdge);
		} else {
			return Collections.emptySet();
		}
	}

	@Override
	public Set<Attribute> getAttributeMappings(org.eclipse.emf.henshin.model.Attribute editRuleAttribute) {
		if (attributeMappings.containsKey(editRuleAttribute)) {
			return attributeMappings.get(editRuleAttribute);
		} else {
			return Collections.emptySet();
		}
	}

	@Override
	public Set<Attribute> getAttributeSetOriginMappings(org.eclipse.emf.henshin.model.Attribute editRuleAttribute) {
		if (attributeSetOriginMappings.containsKey(editRuleAttribute)) {
			return attributeSetOriginMappings.get(editRuleAttribute);
		} else {
			return Collections.emptySet();
		}
	}

	@Override
	public Set<SuperimposedElement> getForbidNodeMappings(Node editRuleNode, ApplicationConditionMatch match) {
		assert match.isNac(): "NAC expected";
		return match.getACNodeMapping().get(editRuleNode);
	}

	@Override
	public Set<Reference> getForbidEdgeMappings(Edge editRuleEdge, ApplicationConditionMatch match) {
		assert match.isNac(): "NAC expected";
		return match.getACEdgeMapping().get(editRuleEdge);
	}

	@Override
	public Set<Attribute> getForbidAttributeMappings(org.eclipse.emf.henshin.model.Attribute editRuleAttribute, ApplicationConditionMatch match) {
		assert match.isNac(): "NAC expected";
		return match.getACAttributeMapping().get(editRuleAttribute);
	}

	@Override
	public Set<SuperimposedElement> getRequiredNodeMappings(Node editRuleNode, ApplicationConditionMatch match) {
		assert match.isPac(): "PAC expected";
		return match.getACNodeMapping().get(editRuleNode);
	}

	@Override
	public Set<Reference> getRequiredEdgeMappings(Edge editRuleEdge, ApplicationConditionMatch match) {
		assert match.isPac(): "PAC expected";
		return match.getACEdgeMapping().get(editRuleEdge);
	}

	@Override
	public Set<Attribute> getRequiredAttributeMappings(org.eclipse.emf.henshin.model.Attribute editRuleAttribute, ApplicationConditionMatch match) {
		assert match.isPac(): "PAC expected";
		return match.getACAttributeMapping().get(editRuleAttribute);
	}

	/**
	 * Derives the edge occurrences from the given node occurrences.
	 */
	protected void deriveEdgeMappings() {

		for (Edge edge : getAllEdges()) {
			Set<Reference> edgeOccurrences = new HashSet<Reference>();

			// if src is delete or preserve node, get LHS node, otherwise get RHS node
			Node src = getKeyNode(edge.getSource());
			// if tgt is delete or preserve node, get LHS node, otherwise get RHS node
			Node tgt = getKeyNode(edge.getTarget());

			for (SuperimposedElement elementSrc : getNodeMappings(src)) {
				for (SuperimposedElement elementTgt : getNodeMappings(tgt)) {
					for (Reference reference : elementSrc.getOutgoings()) {
						if (reference.getType().equals(edge.getType()) && reference.getTarget().equals(elementTgt)) {
							edgeOccurrences.add(reference);
						}
					}
				}
			}

			if (!edgeOccurrences.isEmpty()) {
				edgeMappings.put(edge, edgeOccurrences);
				if (edge.getAction().getType() == Type.CREATE) {
					this.creationEdges.add(edge);
				} else if (edge.getAction().getType() == Type.DELETE) {
					this.deletionEdges.add(edge);
				} else {
					this.preservedEdges.add(edge);
				}
			}
		}
	}

	/**
	 * Derives the attribute occurrences from the given node occurrences.
	 */
	protected void deriveAttributeOccurrences() {
		
		for (org.eclipse.emf.henshin.model.Attribute a : getAllAttributes()) {
			Set<Attribute> attributeOccurences = new HashSet<Attribute>();
			Set<Attribute> attributeSetOriginOccurences = new HashSet<Attribute>();
			Node keyNode = getKeyNode(a.getNode());
			for (SuperimposedElement element : nodeMappings.get(keyNode)) {
				for (Attribute attribute : element.getAttributes(a.getType())) {
					if (HenshinRuleAnalysisUtilEx.isLHS(a)) {
						for (Annotation annotation : attribute.getAnnotations()) {
							if (deltaModule != null && (annotation.getBody().toString()
									.equals("not(" + deltaModule.getName() + ")")
									|| annotation.getBody().toString().equals(
											"not(" + deltaModule.getName() + ") or " + deltaModule.getName()))) {
								attributeOccurences.add(attribute);
								break;
							}
						}
					} else {
						for (Annotation annotation : attribute.getAnnotations()) {
							if (deltaModule != null && (annotation.getBody().toString().equals(deltaModule.getName())
									|| annotation.getBody().toString().equals(
											"not(" + deltaModule.getName() + ") or " + deltaModule.getName()))) {
								attributeOccurences.add(attribute);
								if (HenshinRuleAnalysisUtilEx.isCreationAttribute(a)
										&& HenshinRuleAnalysisUtilEx.isPreservedNode(a.getNode())) {
									for(Attribute originAttribute :  element.getAttributes(a.getType())) {
										if(!originAttribute.equals(attribute)) {
											for (Annotation originAnnotation : originAttribute.getAnnotations()) {
												if (deltaModule != null && (originAnnotation.getBody().toString()
														.equals("not(" + deltaModule.getName() + ")")
														|| originAnnotation.getBody().toString()
																.equals("not(" + deltaModule.getName() + ") or "
																		+ deltaModule.getName()))) {
													attributeSetOriginOccurences.add(originAttribute);
													break;
												}
											}
										}
									}
								}
								break;
							}
						}
					}
				}
			}
			if (!attributeOccurences.isEmpty()) {
				attributeMappings.put(a, attributeOccurences);
				attributeSetOriginMappings.put(a, attributeSetOriginOccurences);
				if (HenshinRuleAnalysisUtilEx.isDeletionAttribute(a)
						&& HenshinRuleAnalysisUtilEx.isDeletionNode(a.getNode())) {
					deletionAttributes.add(a);
				} else if (HenshinRuleAnalysisUtilEx.isPreservedAttribute(a)) {
					if(HenshinRuleAnalysisUtilEx.isChangingAttribute(a)) {
						changeAttributes.add(a);
					}else {
						preservedAttributes.add(a);
					}
				} else if (HenshinRuleAnalysisUtilEx.isCreationAttribute(a)) {
					if (HenshinRuleAnalysisUtilEx.isCreationNode(a.getNode())) {
						creationAttributes.add(a);
					} else {
						setAttributes.add(a);
					}
				} else {
					throw new AssertionError("unexpected action on attribute occurences");
				}
			}
		}
	}

	/**
	 * Derives the application condition occurrences.
	 */
	protected void deriveApplicationConditionOccurrences() {

		ApplicationConditionMatcher matcher = ApplicationConditionMatcher.INSTANCE;
		
		this.applicationConditionMatches.addAll(matcher.match(this));
		for(ApplicationConditionMatch match : this.applicationConditionMatches) {
			for(Node ac_node : match.getACNodeMapping().keySet()) {
				if(!nodeMappings.containsKey(ac_node)) {
					nodeMappings.put(ac_node, new HashSet<SuperimposedElement>());
				}
				nodeMappings.get(ac_node).addAll(match.getACNodeMapping().get(ac_node));
				if(match.isNac()) {
					this.forbiddenNodes.add(ac_node);
				}else {
					this.requiredNodes.add(ac_node);
				}
			}
			
			for(Edge ac_edge : match.getACEdgeMapping().keySet()) {
				if(!edgeMappings.containsKey(ac_edge)) {
					edgeMappings.put(ac_edge, new HashSet<Reference>());
				}
				edgeMappings.get(ac_edge).addAll(match.getACEdgeMapping().get(ac_edge));
				if(match.isNac()) {
					this.forbiddenEdges.add(ac_edge);
				}else {
					this.requiredEdges.add(ac_edge);
				}
			}
			
			for(org.eclipse.emf.henshin.model.Attribute ac_attribute : match.getACAttributeMapping().keySet()) {
				if(!attributeMappings.containsKey(ac_attribute)) {
					attributeMappings.put(ac_attribute, new HashSet<Attribute>());
				}
				attributeMappings.get(ac_attribute).addAll(match.getACAttributeMapping().get(ac_attribute));
				if(match.isNac()) {
					this.forbiddenAttributes.add(ac_attribute);
				}else {
					this.requiredAttributes.add(ac_attribute);
				}
			}
		}

	}

	/**
	 * Get all edges w.r.t. to the convention handling LHS and RHS rule elements.
	 * 
	 * @return all edges
	 */
	protected Set<Edge> getAllEdges() {
		Set<Edge> edges = new HashSet<Edge>();
		for (Node n : nodeMappings.keySet()) {
			edges.addAll(n.getOutgoing());
			if (HenshinRuleAnalysisUtilEx.isPreservedNode(n)) {
				assert HenshinRuleAnalysisUtilEx.isLHS(n) : "a preserved node must be from LHS";
				Node rhs_node = HenshinRuleAnalysisUtilEx.getRHS(n);
				for (Edge rhs_edge : rhs_node.getOutgoing()) {
					if (HenshinRuleAnalysisUtilEx.isCreationEdge(rhs_edge)) {
						edges.add(rhs_edge);
					}
				}
			}
		}
		return edges;
	}

	/**
	 * Get all attributes w.r.t. to the convention handling LHS and RHS elements.
	 * 
	 * @return all attributes
	 */
	protected Set<org.eclipse.emf.henshin.model.Attribute> getAllAttributes() {
		Set<org.eclipse.emf.henshin.model.Attribute> attributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();
		for (Node n : nodeMappings.keySet()) {
			attributes.addAll(n.getAttributes());
			if (HenshinRuleAnalysisUtilEx.isPreservedNode(n)) {
				assert HenshinRuleAnalysisUtilEx.isLHS(n) : "a preserved node must be from LHS";
				Node rhs_node = HenshinRuleAnalysisUtilEx.getRHS(n);
				attributes.addAll(rhs_node.getAttributes());
			}
		}
		return attributes;
	}


	/**
	 * Get the key node used for occurrence-query:
	 * 
	 * The key node is defined as follows:
	 * (1) if the node is part of a multi-rule, then the key node is the origin node in the kernel-rule
	 *
	 * (2) if the node is a preserved or deleted node, then the key node is always the corresponding LHS node.
	 * Otherwise the RHS node is returned
	 * 
	 * @param editRuleNode an arbitrary node of the edit rule
	 * @return the key node which can be used for occurrence-query
	 */
	protected Node getKeyNode(Node editRuleNode) {
		Node keyNode = editRuleNode;

		// step (1):
		// note that multi-rules are not supported yet by the overall element mapping
		Rule henshinRule = editRuleNode.getGraph().getRule();
		if (henshinRule.isMultiRule()) {
			for (Mapping mapping : henshinRule.getMultiMappings()) {
				if (mapping.getImage() == editRuleNode) {
					keyNode = mapping.getOrigin();
				}
			}
		}

		// step (2):
		if (HenshinRuleAnalysisUtilEx.isPreservedNode(keyNode) && HenshinRuleAnalysisUtilEx.isRHS(keyNode)) {
			return HenshinRuleAnalysisUtilEx.findCorrespondingNodeInLHS(keyNode);
		} else {
			return keyNode;
		}
	}

	/**
	 * Get the edge used for occurrence-query
	 * 
	 * @param editRuleEdge an arbitrary edge of the edit rule
	 * @return the key edge which can be used for occurrence-query
	 */
	protected Edge getKeyEdge(Edge editRuleEdge) {
		if (HenshinRuleAnalysisUtilEx.isPreservedEdge(editRuleEdge) && HenshinRuleAnalysisUtilEx.isRHS(editRuleEdge)) {
			return HenshinRuleAnalysisUtilEx.findCorrespondingEdgeInLHS(editRuleEdge);
		} else {
			return editRuleEdge;
		}
	}

	@Override
	public Set<ApplicationConditionMatch> getApplicationConditionMatches() {
		return this.applicationConditionMatches;
	}
}
