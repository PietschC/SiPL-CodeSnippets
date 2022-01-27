package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictKind;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.TransientEffect;
import org.sidiff.deltamodeling.deltamodel.TransientEffectDetail;
import org.sidiff.deltamodeling.deltamodel.TransientEffectKind;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * Extends {@link DeltaActionRelationAnalyzer} for detecting
 * {@link TransientEffect}s between delta actions.
 * 
 * @author cpietsch
 *
 */
public class DeltaActionTransientEffectAnalyzer extends DeltaActionRelationAnalyzer<TransientEffect> {	
	
	public DeltaActionTransientEffectAnalyzer(Set<IEditRuleBase> ruleBases, Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}
	
	@Override
	public TransientEffect analyze(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {

		this.ruleElementMapping1 = resolveRuleElementMapping(deltaAction1, deltaModule1);
		this.ruleElementMapping2 = resolveRuleElementMapping(deltaAction2, deltaModule2);

		if (ruleElementMapping1.getEditRule().getInverse() != null
				&& ruleElementMapping1.getEditRule().getInverses().contains(ruleElementMapping2.getEditRule())) {
			Dependency dependecy = getIncomingDependency(deltaAction1, deltaAction2);
			boolean isInternal = deltaAction1.eResource().equals(deltaAction2.eResource());
			
			if (dependecy != null || isInternal) {
				Set<TransientEffectDetail> transientEffectDetails = new HashSet<TransientEffectDetail>();

				if (!checkTransientNodeAction(ruleElementMapping1.getDeletionNodes(),
						ruleElementMapping2.getCreationNodes(), TransientEffectKind.DELETE_CREATE,
						transientEffectDetails))
					return null;
				if (!checkTransientNodeAction(ruleElementMapping1.getCreationNodes(),
						ruleElementMapping2.getDeletionNodes(), TransientEffectKind.CREATE_DELETE,
						transientEffectDetails))
					return null;
				if (!checkTransientEdgeAction(ruleElementMapping1.getDeletionEdges(),
						ruleElementMapping2.getCreationEdges(), TransientEffectKind.DELETE_CREATE,
						transientEffectDetails))
					return null;
				if (!checkTransientEdgeAction(ruleElementMapping1.getCreationEdges(),
						ruleElementMapping2.getDeletionEdges(), TransientEffectKind.CREATE_DELETE,
						transientEffectDetails))
					return null;
				if (!checkTransientAttributeAction(ruleElementMapping1.getSetAttributes(),
						ruleElementMapping2.getSetAttributes(), TransientEffectKind.CHANGE_CHANGE,
						transientEffectDetails))
					return null;
				if (!checkTransientAttributeAction(ruleElementMapping1.getChangeAttributes(),
						ruleElementMapping2.getChangeAttributes(), TransientEffectKind.CHANGE_CHANGE,
						transientEffectDetails))
					return null;

				TransientEffect transientEffect = FACTORY.createTransientEffect();
				transientEffect.setSourceDeltaAction(deltaAction1);
				transientEffect.setTargetDeltaAction(deltaAction2);
				transientEffect.getDetails().addAll(transientEffectDetails);
				if(dependecy != null) {
					transientEffect.setDependency(dependecy);
				}
				return transientEffect;
			}

		}else if(ruleElementMapping1.getEditRule().equals(ruleElementMapping2.getEditRule())) {
			Conflict conflict = getOutgoingConflict(deltaAction1, deltaAction2);
			if(conflict != null && conflict.getDetails().stream().allMatch(detail -> detail.getKind() == ConflictKind.CHANGE_CHANGE)) {
				Set<TransientEffectDetail> transientEffectDetails = new HashSet<TransientEffectDetail>();
				if(!checkTransientAttributeAction(ruleElementMapping1.getSetAttributes(), ruleElementMapping2.getSetAttributes(), TransientEffectKind.CHANGE_CHANGE, transientEffectDetails)) return null;
				TransientEffect transientEffect = FACTORY.createTransientEffect();
				transientEffect.setSourceDeltaAction(deltaAction1);
				transientEffect.setTargetDeltaAction(deltaAction2);
				transientEffect.getDetails().addAll(transientEffectDetails);
				return transientEffect;
			}
		}

		return null;
	}
	
	private boolean checkTransientNodeAction(Collection<Node> nodes1, Collection<Node> nodes2, TransientEffectKind kind, Collection<TransientEffectDetail> transientDetails) {
		
		if(nodes1.isEmpty() && !nodes2.isEmpty()) return false;
		
		for (Node srcNode : nodes1) {
			boolean hasTransientEffect = false;
			for (Node tgtNode : nodes2) {
				Set<SuperimposedElement> srcElements = ruleElementMapping1.getNodeMappings(srcNode);
				Set<SuperimposedElement> tgtElements = ruleElementMapping2.getNodeMappings(tgtNode);
				if (srcElements.equals(tgtElements)) {
					Set<Entity> elements = new HashSet<Entity>(srcElements);
					elements.retainAll(tgtElements);
					transientDetails.add(createTransientEffectDetail(elements, kind));
					hasTransientEffect = checkTransientAttributeAction(srcNode, tgtNode, srcElements, tgtElements, kind, transientDetails);
					break;
					
				}
			}
			if(!hasTransientEffect) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkTransientAttributeAction(Node srcNode, Node tgtNode,
			Collection<SuperimposedElement> srcElements, Collection<SuperimposedElement> tgtElements,
			TransientEffectKind kind, Collection<TransientEffectDetail> transientEffectDetails) {

		Set<EAttribute> node_attribute_intersection = srcNode.getAttributes().stream().map(a -> a.getType())
				.collect(Collectors.toSet());
		node_attribute_intersection
				.retainAll(tgtNode.getAttributes().stream().map(a -> a.getType()).collect(Collectors.toSet()));
		if (!node_attribute_intersection.isEmpty()) {
			for (SuperimposedElement srcElement : srcElements) {
				for (SuperimposedElement tgtElement : tgtElements) {
					if (srcElement.equals(tgtElement)) {

						for (Attribute srcAttribute : srcElement.getAttributes().stream()
								.filter(attribute -> node_attribute_intersection.contains(attribute.getType())
										&& attribute.getAnnotations().stream()
												.anyMatch(annotation -> annotation.getBody().toString()
														.equals(deltaModule1.getName())
														|| annotation.getBody().toString()
																.equals("not(" + deltaModule1.getName() + ")")))
								.collect(Collectors.toSet())) {
							boolean hasTransientEffect = false;
							for (Attribute tgtAttribute : tgtElement.getAttributes(srcAttribute.getType()).stream()
									.filter(attribute -> attribute.getAnnotations().stream().anyMatch(
											annotation -> annotation.getBody().toString().equals(deltaModule2.getName())
													|| annotation.getBody().toString()
															.equals("not(" + deltaModule2.getName() + ")")))
									.collect(Collectors.toSet())) {
								if (srcAttribute.equals(tgtAttribute)) {
									hasTransientEffect = true;
									Set<Entity> attributes = Collections.singleton(srcAttribute);
									transientEffectDetails.add(createTransientEffectDetail(attributes, kind));
								}
							}
							if (!hasTransientEffect) {
								return false;
							}
						}

					}

				}
			}
		}

		return true;
	}

	private boolean checkTransientAttributeAction(Collection<org.eclipse.emf.henshin.model.Attribute> attributes1, Collection<org.eclipse.emf.henshin.model.Attribute> attributes2,  TransientEffectKind kind, Collection<TransientEffectDetail> transientEffectDetails) {
	
		if(attributes1.isEmpty() && !attributes2.isEmpty()) return false;
		
		for(org.eclipse.emf.henshin.model.Attribute srcAttribute : attributes1) {
			boolean hasTransientEffect = false;
			Set<SuperimposedElement> srcElements = ruleElementMapping1.getNodeMappings(srcAttribute.getNode());
			for(org.eclipse.emf.henshin.model.Attribute tgtAttribute : attributes2) {
				Set<SuperimposedElement> tgtElements = ruleElementMapping2.getNodeMappings(tgtAttribute.getNode());
				if (srcAttribute.getType().equals(tgtAttribute.getType()) && srcElements.equals(tgtElements)) {
					Set<Attribute> srcAttributesOrigin = ruleElementMapping1.getAttributeSetOriginMappings(srcAttribute);
					Set<Attribute> srcAttributesChanged = ruleElementMapping1.getAttributeMappings(srcAttribute);
					Set<Attribute> tgtAttributesOrigin = ruleElementMapping2.getAttributeSetOriginMappings(tgtAttribute);
					Set<Attribute> tgtAttributesChanged = ruleElementMapping2.getAttributeMappings(tgtAttribute);
					if (srcAttributesOrigin.equals(tgtAttributesChanged) && srcAttributesChanged.equals(tgtAttributesOrigin)) {
						hasTransientEffect = true;
						Set<Entity> attributes = new HashSet<Entity>(srcAttributesOrigin);
						attributes.addAll(srcAttributesChanged);
						transientEffectDetails.add(createTransientEffectDetail(attributes, kind));
						break;
					}
				}
			}
			if(!hasTransientEffect) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkTransientEdgeAction(Collection<Edge> edges1, Collection<Edge> edges2, TransientEffectKind kind, Collection<TransientEffectDetail> transientEffectDetails) {

		if(edges1.isEmpty() && !edges2.isEmpty()) return false;
		
		for (Edge srcEdge : edges1) {
			boolean hasTransient = false;
			for (Edge tgtEdge : edges2) {
				Set<Reference> srcReferences = ruleElementMapping1.getEdgeMappings(srcEdge);
				Set<Reference> tgtReferences = ruleElementMapping2.getEdgeMappings(tgtEdge);
				if (srcReferences.equals(tgtReferences)) {
					hasTransient = true;
					Set<Entity> references = new HashSet<Entity>(srcReferences);
					references.retainAll(tgtReferences);
					transientEffectDetails.add(createTransientEffectDetail(references, kind));
				}
			}
			if(!hasTransient) {
				return false;
			}
		}
		
		return true;
	}

	private TransientEffectDetail createTransientEffectDetail(Set<Entity> entities, TransientEffectKind kind) {
		TransientEffectDetail detail = FACTORY.createTransientEffectDetail();
		detail.setKind(kind);
		detail.getEntities().addAll(entities);
		
		return detail;
	}
	
//	private Dependency getDependency(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {
//		for(Dependency dependency : deltaModule1.getOutgoingDependencies(deltaAction1)) {
//			if(dependency.getTargetDeltaAction().equals(deltaAction2)) {
//				return dependency;
//			}
//		}
//		return null;
//	}
//	
//	private Conflict getConflict(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {
//		for (Conflict conflict : deltaModule1.getOutgoingConflicts(deltaAction1)) {
//			if (conflict.getTargetDeltaAction().equals(deltaAction2)) {
//				return conflict;
//			}
//		}
//		return null;
//	}
}
