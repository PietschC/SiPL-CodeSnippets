package org.sidiff.deltamodeling.deltamodel.analysis.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.SelfCleaningEngineImpl;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.statistics.StatisticsUtil;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionRuleWrapper.AttributePattern;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionRuleWrapper.EdgePattern;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionRuleWrapper.NodePattern;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.entities.Reference;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelPackage;

public class ApplicationConditionMatcher {

	public static final ApplicationConditionMatcher INSTANCE = new ApplicationConditionMatcher();

	private Map<EditRule, Collection<ApplicationConditionRuleWrapper>> ruleMapping;

	private ApplicationConditionMatcher() {
		this.ruleMapping = new HashMap<>();
	}

	public Collection<ApplicationConditionMatch> match(IRuleElementMapping ruleElementMapping) {
		
		List<ApplicationConditionMatch> matches = new ArrayList<>();
		
		Set<ApplicationConditionMatch> unique_matches = new HashSet<>();
		
		Collection<ApplicationConditionRuleWrapper> ruleWrappers = ruleMapping.get(ruleElementMapping.getEditRule());
		
		// only derive rule if it doesn't already exist
		if (ruleWrappers == null) {
			StatisticsUtil.getInstance().start("Derive application condition rule");
			Rule originRule = (Rule) ruleElementMapping.getEditRule().getExecuteMainUnit().getSubUnits(false).get(0);
			assert originRule != null : "rule for main unit "
					+ ruleElementMapping.getEditRule().getExecuteModule().getName() + "missing";
			ruleWrappers = Transformer.INSTANCE.transformRule(originRule, true);
			
			ruleMapping.put(ruleElementMapping.getEditRule(), ruleWrappers);
			try {
				serializeRuleMappings("/home/cpietsch/eclipse-workspace/sipl/runtime/2020-06-R/casestudies/bcs/org.sidiff.deltamodeling.test.pacs/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StatisticsUtil.getInstance().stop("Derive application condition rule");
		}
		StatisticsUtil.getInstance().start("Application condition matching");
		EGraph graph = createModelAGraph(ruleElementMapping);
		Engine engine = new SelfCleaningEngineImpl();

		for(ApplicationConditionRuleWrapper ruleWrapper : ruleWrappers) {
			// build the partial match form existing rule element mappings
			Match partialMatch = new MatchImpl(ruleWrapper.getImageRule());
	
			for (NodePattern nodePattern : ruleWrapper.getNodePatterns()) {
				Set<SuperimposedElement> superimposedElements = ruleElementMapping.getNodeMappings(nodePattern.getOrigin());
				if (!superimposedElements.isEmpty()) {
					assert superimposedElements.size() == 1 : "Exactly one mapped element expected!";
					SuperimposedElement superimposedElement = superimposedElements.iterator().next();
					partialMatch.setNodeTarget(nodePattern.getElement(), superimposedElement);
				}
			}
	
			for (EdgePattern edgePattern : ruleWrapper.getEdgePatterns()) {
				Set<Reference> references = ruleElementMapping.getEdgeMappings(edgePattern.getOrigin());
				if (!references.isEmpty()) {
					assert references.size() == 1 : "Exactly one mapped reference expected!";
					Reference reference = references.iterator().next();
					partialMatch.setNodeTarget(edgePattern.getReference(), reference);
					partialMatch.setNodeTarget(edgePattern.getEType(), reference.getType());
				}
			}
	
			for (AttributePattern attributePattern : ruleWrapper.getAttributePatterns()) {
				Set<org.sidiff.entities.Attribute> attributes = ruleElementMapping
						.getAttributeMappings(attributePattern.getOrigin());
				if (!attributes.isEmpty()) {
					assert attributes.size() == 1 : "Exaclty one mapped attribute expected!";
					org.sidiff.entities.Attribute attribute = attributes.iterator().next();
					partialMatch.setNodeTarget(attributePattern.getAttribute(), attribute);
					partialMatch.setNodeTarget(attributePattern.geteType(), attribute.getType());
				}
			}

			// now, try to find matches of the application condition(s)
			for (Match match : engine.findMatches(ruleWrapper.getImageRule(), graph, partialMatch)) {
				ApplicationConditionMatch applicationConditionMatch = new ApplicationConditionMatch(ruleElementMapping, ruleWrapper);
				for (Node ac_node : ruleWrapper.getACNodes()) {
					NodePattern ac_nodePattern = ruleWrapper.getNodeTrace(ac_node);
					SuperimposedElement ac_node_target = (SuperimposedElement) match
							.getNodeTarget(ac_nodePattern.getElement());
					applicationConditionMatch.addACNodeMapping(ac_node, ac_node_target);
				}
	
				for (Edge ac_edge : ruleWrapper.getACEdges()) {
					EdgePattern ac_edge_pattern = ruleWrapper.getEdgeTrace(ac_edge);
					Reference ac_edge_target = (Reference) match.getNodeTarget(ac_edge_pattern.getReference());
					applicationConditionMatch.addACEdgeMapping(ac_edge, ac_edge_target);
				}
	
				for (Attribute ac_attribute : ruleWrapper.getACAttributes()) {
					AttributePattern ac_attribute_pattern = ruleWrapper.getAttributeTrace(ac_attribute);
					org.sidiff.entities.Attribute ac_attribute_target = (org.sidiff.entities.Attribute) match
							.getNodeTarget(ac_attribute_pattern.getAttribute());
					applicationConditionMatch.addACAttributeMapping(ac_attribute, ac_attribute_target);
				}
	
				matches.add(applicationConditionMatch);
			}
		}
		engine.shutdown();
		unique_matches.addAll(matches);
		if(!matches.isEmpty()) {
			LogUtil.log(LogEvent.DEBUG, "Application Condition Matches:\n - matches: " + matches.size() + "\n" + "- unique matches: " + unique_matches.size());
		}
		StatisticsUtil.getInstance().stop("Application condition matching");
		return unique_matches;
	}

	/**
	 * Creates a working graph for superimposed model
	 *
	 * @return The working graph.
	 */
	private EGraph createModelAGraph(IRuleElementMapping ruleElementMapping) {
		Resource resource = ruleElementMapping.getNodeMappings(ruleElementMapping.getEditRuleNodes().iterator().next())
				.iterator().next().eResource();

		// Initialize Henshin graph:
		EGraph graph = new EGraphImpl();

		for (EObject rootObj : resource.getContents()) {
			if (rootObj.eClass().getClassifierID() == DeltaModelPackage.DELTA_MODULE_SET) {
				SuperimposedModel superimposedModel = ((DeltaModuleSet) rootObj).getSuperimposedModel();
				for (Iterator<EObject> iterator = superimposedModel.eAllContents(); iterator.hasNext();) {
					EObject eObject = iterator.next();
					if (!eObject.eClass().getEPackage().equals(FormulaPackage.eINSTANCE)) {
						graph.add(eObject);
						switch (eObject.eClass().getClassifierID()) {
						case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT:
							graph.add(((SuperimposedElement) eObject).getType());
							break;
						case EntitiesPackage.REFERENCE:
							graph.add(((Reference) eObject).getType());
							break;
						case EntitiesPackage.ATTRIBUTE:
							graph.add(((org.sidiff.entities.Attribute) eObject).getType());
							break;
						default:
							break;
						}
					}
				}
			}
		}

		return graph;
	}

	public void serializeRuleMappings(String path) throws IOException {
		for(Entry<EditRule, Collection<ApplicationConditionRuleWrapper>> entry : ruleMapping.entrySet()) {
			for(ApplicationConditionRuleWrapper wrapper : entry.getValue()) {
				wrapper.serializeImageRule(path + wrapper.getImageRule().getName());
			}
		}
	}
	
	public static class Transformer {

		private static final Transformer INSTANCE = new Transformer();

		private Transformer() {	}

		private static final HenshinFactory FACTORY = HenshinFactory.eINSTANCE;

		private List<String> variables;

		private Collection<ApplicationConditionRuleWrapper> transformRule(Rule originRule, boolean lhs_only) {
			Set<ApplicationConditionRuleWrapper> wrappers = new HashSet<>();
			for (NestedCondition nestedCondition : originRule.getLhs().getNACs()) {
				wrappers.add(transformNestedCondition(originRule, nestedCondition, lhs_only, true));
			}
			for (NestedCondition nestedCondition : originRule.getLhs().getPACs()) {
				wrappers.add(transformNestedCondition(originRule, nestedCondition, lhs_only, false));
			}
			
			return wrappers;
		}

		private void handle(Node node, Rule rule, Map<Node, NodePattern> nodes, Map<EClass, Node> eClassNodes) {
			// create superimposed element node
			Node lhs_node_SuperimposedElement = FACTORY.createNode();
			lhs_node_SuperimposedElement.setType(SuperimpositionModelPackage.eINSTANCE.getSuperimposedElement());

			if (node.getName() != null) {
				lhs_node_SuperimposedElement.setName(node.getName());
			}
			rule.getLhs().getNodes().add(lhs_node_SuperimposedElement);

			// create type node if it doesn't already exist
			Node lhs_node_EClass = eClassNodes.get(node.getType());
			if (lhs_node_EClass == null) {
				lhs_node_EClass = FACTORY.createNode();
				lhs_node_EClass.setType(EcorePackage.eINSTANCE.getEClass());
				FACTORY.createAttribute(lhs_node_EClass, EcorePackage.eINSTANCE.getENamedElement_Name(),
						"\"" + node.getType().getName() + "\"");

				rule.getLhs().getNodes().add(lhs_node_EClass);
				eClassNodes.put(node.getType(), lhs_node_EClass);
			}

			Edge lhs_type = FACTORY.createEdge(lhs_node_SuperimposedElement, lhs_node_EClass,
					EntitiesPackage.eINSTANCE.getElement_Type());
			rule.getLhs().getEdges().add(lhs_type);

			nodes.put(node, new NodePattern(node, lhs_node_SuperimposedElement, lhs_node_EClass, lhs_type));
		}

		private void handle(Edge edge, Rule rule, Map<Node, NodePattern> nodes, Map<Edge, EdgePattern> edges,
				Map<EReference, Node> eReferenceNodes) {
			// get the origin rule
			Rule originRule = edge.getGraph().getRule();

			// get the superimposed element node for the source node of the edge
			NodePattern lhs_src_node_pattern = getImageNode(edge.getSource(), originRule, nodes);
			assert lhs_src_node_pattern != null : "No source node pattern found";

			// get the superimposed element node for the target node of the edge
			NodePattern lhs_tgt_node_pattern = getImageNode(edge.getTarget(), originRule, nodes);
			assert lhs_tgt_node_pattern != null : "No source node pattern found";

			// create reference node for edge
			Node lhs_node_Reference = FACTORY.createNode();
			lhs_node_Reference.setType(EntitiesPackage.eINSTANCE.getReference());
			rule.getLhs().getNodes().add(lhs_node_Reference);

			// set a name for the reference node if the source and target have also a name
			if (lhs_src_node_pattern.getElement().getName() != null && !lhs_src_node_pattern.getElement().getName().isEmpty()
					&& lhs_tgt_node_pattern.getElement().getName() != null
					&& !lhs_tgt_node_pattern.getElement().getName().isEmpty()) {
				lhs_node_Reference.setName(lhs_src_node_pattern.getElement().getName() + "_" + edge.getType().getName() + "_"
						+ lhs_tgt_node_pattern.getElement().getName());
			}

			// create edges between source and target nodes and the reference node
			Edge lhs_source = FACTORY.createEdge(lhs_src_node_pattern.getElement(), lhs_node_Reference,
					SuperimpositionModelPackage.eINSTANCE.getSuperimposedElement_OwnedReferences());
			rule.getLhs().getEdges().add(lhs_source);
			Edge lhs_target = FACTORY.createEdge(lhs_node_Reference, lhs_tgt_node_pattern.getElement(),
					EntitiesPackage.eINSTANCE.getReference_Target());
			rule.getLhs().getEdges().add(lhs_target);

			// create type node for edge if it doesn't already exist
			Node lhs_node_EReference = eReferenceNodes.get(edge.getType());
			if (lhs_node_EReference == null) {
				lhs_node_EReference = FACTORY.createNode();
				lhs_node_EReference.setType(EcorePackage.eINSTANCE.getEReference());
				FACTORY.createAttribute(lhs_node_EReference, EcorePackage.eINSTANCE.getENamedElement_Name(),
						"\"" + edge.getType().getName() + "\"");
				rule.getLhs().getNodes().add(lhs_node_EReference);

				eReferenceNodes.put(edge.getType(), lhs_node_EReference);
			}

			// create edge between superimposed element node and type node
			Edge lhs_type = FACTORY.createEdge(lhs_node_Reference, lhs_node_EReference,
					EntitiesPackage.eINSTANCE.getReference_Type());
			rule.getLhs().getEdges().add(lhs_type);

			edges.put(edge, new EdgePattern(edge, lhs_node_Reference, lhs_node_EReference, lhs_source, lhs_target, lhs_type));
		}

		private ApplicationConditionRuleWrapper transformNestedCondition(Rule originRule, NestedCondition nestedCondition, boolean lhs_only, boolean isNac) {
			variables = new ArrayList<>();

			Map<Node, NodePattern> nodes = new HashMap<>();
			Map<Edge, EdgePattern> edges = new HashMap<>();
			Map<Attribute, AttributePattern> attributes = new HashMap<>();

			Map<EClass, Node> eClassNodes = new HashMap<>();
			Map<EReference, Node> eReferenceNodes = new HashMap<>();
			Map<EAttribute, Node> eAttributeNodes = new HashMap<>();

			Rule imageRule = FACTORY.createRule();
			imageRule.setName(originRule.getName() + "_" +  nestedCondition.getConclusion().getName());			
			imageRule.setDescription(originRule.getDescription());
			imageRule.setLhs(FACTORY.createGraph());
			imageRule.setRhs(FACTORY.createGraph());

			for (Node node : originRule.getLhs().getNodes()) {
				handle(node, imageRule, nodes, eClassNodes);
				for (Attribute attribute : node.getAttributes()) {
					handle(attribute, imageRule, nodes, attributes, eAttributeNodes);
				}
			}

			for (Edge edge : originRule.getLhs().getEdges()) {
				handle(edge, imageRule, nodes, edges, eReferenceNodes);
			}

			for (Node node : originRule.getRhs().getNodes()) {
				if (!nodes.containsKey(originRule.getMappings().getOrigin(node))) {
					handle(node, imageRule, nodes, eClassNodes);
				}else {
					nodes.put(node, nodes.get(originRule.getMappings().getOrigin(node)));
				}
				for (Attribute attribute : node.getAttributes()) {
					handle(attribute, imageRule, nodes, attributes, eAttributeNodes);
				}
			}

			for (Edge edge : originRule.getRhs().getEdges()) {
				if (!edges.containsKey(imageRule.getMappings().getOrigin(edge))) {
					handle(edge, imageRule, nodes, edges, eReferenceNodes);
				}
			}

			for (Node node : nestedCondition.getConclusion().getNodes()) {
				NodePattern node_pattern = nodes.get(nestedCondition.getMappings().getOrigin(node));

				if (node_pattern == null) {
					handle(node, imageRule, nodes, eClassNodes);
				} else {
					nodes.put(node, node_pattern);
				}
				for (Attribute attribute : node.getAttributes()) {
					AttributePattern attribute_pattern = attributes.get(nestedCondition.getMappings().getOrigin(attribute));
					if (attribute_pattern == null) {
						handle(attribute, imageRule, nodes, attributes, eAttributeNodes);
					} else {
						attributes.put(attribute, attribute_pattern);
					}
				}
			}

			for (Edge edge : nestedCondition.getConclusion().getEdges()) {
				EdgePattern edge_pattern = edges.get(nestedCondition.getMappings().getOrigin(edge));

				if (edge_pattern == null) {
					handle(edge, imageRule, nodes, edges, eReferenceNodes);
				} else {
					edges.put(edge, edge_pattern);
				}
			}

			if (!lhs_only) {
				Copier copier = new Copier();

				for (Node node : imageRule.getLhs().getNodes()) {
					Node copy_node = (Node) copier.copy(node);
					copy_node.setType(node.getType());
					imageRule.getRhs().getNodes().add(copy_node);
					imageRule.getMappings().add(FACTORY.createMapping(node, copy_node));
					for (org.eclipse.emf.henshin.model.Attribute attribute : node.getAttributes()) {
						org.eclipse.emf.henshin.model.Attribute copy_attribute = (Attribute) copier.get(attribute);
						copy_attribute.setType(attribute.getType());
					}
				}

				for (Edge edge : imageRule.getLhs().getEdges()) {
					Edge edge_copy = (Edge) copier.copy(edge);
					edge_copy.setType(edge.getType());
					edge_copy.setSource((Node) copier.get(edge.getSource()));
					edge_copy.setTarget((Node) copier.get(edge.getTarget()));
					imageRule.getRhs().getEdges().add(edge_copy);
				}
			}

			for (Parameter originParameter : originRule.getParameters()) {
				Parameter imageParameter = FACTORY.createParameter(originParameter.getName());
				imageRule.getParameters().add(imageParameter);
			}

			for (String variable : variables) {
				Parameter imageParameter = FACTORY.createParameter(variable);
				imageRule.getParameters().add(imageParameter);
			}

			if (lhs_only) {
				imageRule.setCheckDangling(false);
			}
			
			return new ApplicationConditionRuleWrapper(nestedCondition.getConclusion().getName(), isNac?ConditionType.NAC:ConditionType.PAC, originRule, imageRule, nodes, edges, attributes);
		}
		
		private void handle(Attribute attribute, Rule rule, Map<Node, NodePattern> nodes,
				Map<Attribute, AttributePattern> attributes, Map<EAttribute, Node> eAttributeNodes) {
			// get the superimposed element node
			NodePattern node_Element = nodes.get(attribute.getNode());
			assert node_Element != null : "No node for attribute found";

			// create attribute node
			Node node_Attribute = FACTORY.createNode();
			node_Attribute.setType(EntitiesPackage.eINSTANCE.getAttribute());
			String value = attribute.getValue();

			if (Pattern.matches(".*[+-/*].*", value)) {
				// if the value is a script expression, replace the value with a variable name
				value = "var" + variables.size() + 1;
				variables.add(value);

			}

			node_Attribute.setName(node_Element.getElement().getName() + "_" + attribute.getType().getName() + "_"
					+ value.replaceAll("\"", ""));

			Attribute attribute_Value = FACTORY.createAttribute(node_Attribute,
					EntitiesPackage.eINSTANCE.getAttribute_Value(), value);

			rule.getLhs().getNodes().add(node_Attribute);

			// create edge between superimposed element node and attribute node
			Edge ownedAttributes = FACTORY.createEdge(node_Element.getElement(), node_Attribute,
					SuperimpositionModelPackage.eINSTANCE.getSuperimposedElement_OwnedAttributes());
			rule.getLhs().getEdges().add(ownedAttributes);

			// create type node for attribute if it doesn't already exist
			Node node_EAttribute = eAttributeNodes.get(attribute.getType());
			if (node_EAttribute == null) {
				node_EAttribute = FACTORY.createNode();
				node_EAttribute.setType(EcorePackage.eINSTANCE.getEAttribute());
				FACTORY.createAttribute(node_EAttribute, EcorePackage.eINSTANCE.getENamedElement_Name(),
						"\"" + attribute.getType().getName() + "\"");
				rule.getLhs().getNodes().add(node_EAttribute);

				eAttributeNodes.put(attribute.getType(), node_EAttribute);
			}

			// create edge between attribute node and type node
			Edge type = FACTORY.createEdge(node_Attribute, node_EAttribute,
					EntitiesPackage.eINSTANCE.getAttribute_Type());
			rule.getLhs().getEdges().add(type);

			attributes.put(attribute, new AttributePattern(attribute, node_Attribute, node_EAttribute, attribute_Value,
					ownedAttributes, type));
		}

		private NodePattern getImageNode(Node node, Rule originRule, Map<Node, NodePattern> nodes) {

			// get the superimposed element node for the source node of the edge
			NodePattern imageNode = nodes.get(node);

			// get the LHS node of preserved node
			if (imageNode == null) {
				imageNode = nodes.get(originRule.getMappings().getOrigin(node));
			}

			// get the origin node of node from nested condition
			if (imageNode == null) {
				EObject container = node.eContainer();
				while (container.eClass().getClassifierID() != HenshinPackage.NESTED_CONDITION) {
					container = container.eContainer();
				}

				NestedCondition condition = (NestedCondition) container;

				imageNode = nodes.get(condition.getMappings().getOrigin(node));
			}

			return imageNode;
		}
	}
}
