package org.sidiff.deltamodeling.deltamodel.analysis.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.superimposition.SuperimpositionModelPackage;

public class ApplicationConditionRuleWrapper {
	
	private String id;
	private Rule originRule;
	private Rule imageRule;
	private ConditionType type;
	private Map<Node, NodePattern> nodes;
	private Map<Edge, EdgePattern> edges;
	private Map<Attribute, AttributePattern> attributes;
	
	private Map<Node, Node> originNodes = new HashMap<Node, Node>();
	private Map<Node, Edge> originEdges = new HashMap<Node, Edge>();
	private Map<Node, Attribute> originAttributes = new HashMap<Node, Attribute>();
	
	private Set<Node> ac_nodes = new HashSet<Node>();
	private Set<Edge> ac_edges = new HashSet<Edge>();
	private Set<Attribute> ac_attributes = new HashSet<Attribute>();
		
	public ApplicationConditionRuleWrapper(String id, ConditionType type, Rule originRule, Rule imageRule, Map<Node, NodePattern> nodes, Map<Edge, EdgePattern> edges, Map<Attribute, AttributePattern> attributes) {
		super();
		this.id = id;
		this.originRule = originRule;
		this.imageRule = imageRule;
		this.type = type;
		this.nodes = new HashMap<Node, ApplicationConditionRuleWrapper.NodePattern>(nodes);
		this.edges = new HashMap<Edge, ApplicationConditionRuleWrapper.EdgePattern>(edges);
		this.attributes = new HashMap<Attribute, ApplicationConditionRuleWrapper.AttributePattern>(attributes);
	
		for(NodePattern nodePattern : nodes.values()) {
			originNodes.put(nodePattern.getElement(), nodePattern.origin);
			if(type == ConditionType.NAC && HenshinRuleAnalysisUtilEx.isForbiddenNode(nodePattern.origin)) {
				ac_nodes.add(nodePattern.origin);
			}else if(type == ConditionType.PAC && HenshinRuleAnalysisUtilEx.isRequireNode(nodePattern.origin)) {
				ac_nodes.add(nodePattern.origin);
			}
		}
		
		for(EdgePattern edgePattern : edges.values()) {
			originEdges.put(edgePattern.getReference(), edgePattern.origin);
			if(type == ConditionType.NAC && HenshinRuleAnalysisUtilEx.isForbiddenEdge(edgePattern.origin)) {
				ac_edges.add(edgePattern.origin);
			}else if(type == ConditionType.PAC && HenshinRuleAnalysisUtilEx.isRequireEdge(edgePattern.origin)) {
				ac_edges.add(edgePattern.origin);
			}
		}
		
		for(AttributePattern attributePattern : attributes.values()) {
			originAttributes.put(attributePattern.getAttribute(), attributePattern.origin);
			if(type == ConditionType.NAC && HenshinRuleAnalysisUtilEx.isForbiddenAttribute(attributePattern.origin)) {
				ac_attributes.add(attributePattern.origin);
			}else if(type == ConditionType.PAC && HenshinRuleAnalysisUtilEx.isRequireAttribute(attributePattern.origin)) {
				ac_attributes.add(attributePattern.origin);
			}
		}
	}
	
	public String getId() {
		return id;
	}
	
	public Rule getOriginRule() {
		return originRule;
	}
	
	public Rule getImageRule() {
		return imageRule;
	}
	
	public ConditionType getType() {
		return type;
	}
	
	public Collection<NodePattern> getNodePatterns(){
		return Collections.unmodifiableCollection(this.nodes.values());
	}
	
	public Collection<EdgePattern> getEdgePatterns(){
		return Collections.unmodifiableCollection(this.edges.values());
	}

	public Collection<AttributePattern> getAttributePatterns(){
		return Collections.unmodifiableCollection(this.attributes.values());
	}
	public NodePattern getNodeTrace(Node node) {
		return this.nodes.get(node);
	}
	
	public EdgePattern getEdgeTrace(Edge edge) {
		return this.edges.get(edge);
	}
	
	public AttributePattern getAttributeTrace(Attribute attribute) {
		return this.attributes.get(attribute);
	}
	
	public Node getOriginNode(Node node) {
		return this.originNodes.get(node);
	}
	
	public Edge getOriginEdge(Node node) {
		return this.originEdges.get(node);
	}
	
	public Attribute getOriginAttribute(Node node) {
		return this.originAttributes.get(node);
	}
	
	public Collection<Node> getACNodes() {
		return Collections.unmodifiableCollection(ac_nodes);
	}
	
	public Collection<Edge> getACEdges() {
		return Collections.unmodifiableCollection(ac_edges);
	}
	
	public Collection<Attribute> getACAttributes() {
		return Collections.unmodifiableCollection(ac_attributes);
	}
	
	public void serializeImageRule(String path) throws IOException {
		Module module_transformed = HenshinFactory.eINSTANCE.createModule();
		module_transformed.getImports().add(DeltaModelPackage.eINSTANCE);
		module_transformed.getImports().add(SuperimpositionModelPackage.eINSTANCE);
		module_transformed.getImports().add(EntitiesPackage.eINSTANCE);
		module_transformed.getImports().add(FormulaPackage.eINSTANCE);
		module_transformed.getImports().addAll(originRule.getModule().getImports());
		module_transformed.getUnits().add(imageRule);
		
		ResourceSet resourceSet = new HenshinResourceSet();
		Resource resource_transformed = resourceSet.createResource(URI.createFileURI(path));
		resource_transformed.getContents().add(module_transformed);
	
		resource_transformed.save(null);
		
	}
	
	static class AttributePattern {
		private Attribute origin;
		private Node attribute;
		private Node eType;
		private Attribute value;
		private Edge ownedAttributes;
		private Edge type;
		
		
		public AttributePattern(Attribute origin, Node attribute, Node eType, Attribute value, Edge ownedAttributes,
				Edge type) {
			super();
			this.origin = origin;
			this.attribute = attribute;
			this.eType = eType;
			this.value = value;
			this.ownedAttributes = ownedAttributes;
			this.type = type;
		}
		
		public Attribute getOrigin() {
			return origin;
		}
		public Node getAttribute() {
			return attribute;
		}
		public Node geteType() {
			return eType;
		}
		public Attribute getValue() {
			return value;
		}
		public Edge getOwnedAttributes() {
			return ownedAttributes;
		}
		public Edge getType() {
			return type;
		}		
	}
	
	
	static class NodePattern {
		private Node origin;
		private Node element;
		private Node eType;
		private Edge type;
		
		public NodePattern(Node origin, Node element, Node eType, Edge type) {
			super();
			this.origin = origin;
			this.element = element;
			this.eType = eType;
			this.type = type;
		}

		public Node getOrigin() {
			return origin;
		}
		public Node getElement() {
			return element;
		}
		public Node geteType() {
			return eType;
		}
		public Edge getType() {
			return type;
		}
	}
	
	static class EdgePattern {
		
		private Edge origin;
		private Node reference;
		private Node eType;

		private Edge source;
		private Edge target;
		private Edge type;
		
		public EdgePattern(Edge origin, Node reference, Node eType, Edge source, Edge target, Edge type) {
			super();
			this.origin = origin;
			this.reference = reference;
			this.eType = eType;
			this.source = source;
			this.target = target;
			this.type = type;
		}

		public Edge getOrigin() {
			return origin;
		}
		public Node getReference() {
			return reference;
		}
		public Node getEType() {
			return eType;
		}
		public Edge getSource() {
			return source;
		}
		public Edge getTarget() {
			return target;
		}
		public Edge getType() {
			return type;
		}
	}
}
