package org.sidiff.deltamodeling.deltamodel.analysis;

import java.util.Set;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Reference;

/**
 * Interface with declarations of getters that return the respective rule
 * element mappings of an {@link EditRule}, also called delta operation in this
 * context.
 * 
 * @author cpietsch
 *
 */
public interface IRuleElementMapping {
	
	public OperationInvocation getDeltaAction();

	public EditRule getEditRule();
	
	public Set<Node> getEditRuleNodes();
	
	public Set<Node> getCreationNodes();
	
	public Set<Node> getDeletionNodes();
	
	public Set<Node> getPreservedNodes();
	
	public Set<Edge> getEditRuleEdges();
	
	public Set<Edge> getCreationEdges();
	
	public Set<Edge> getDeletionEdges();
	
	public Set<Edge> getPreservedEdges();
	
	public Set<org.eclipse.emf.henshin.model.Attribute> getEditRuleAttributes();
	
	public Set<org.eclipse.emf.henshin.model.Attribute> getCreationAttributes();
	
	public Set<org.eclipse.emf.henshin.model.Attribute> getDeletionAttributes();
	
	public Set<org.eclipse.emf.henshin.model.Attribute> getPreservedAttributes();
	
	public Set<org.eclipse.emf.henshin.model.Attribute> getChangeAttributes();
	
	public Set<org.eclipse.emf.henshin.model.Attribute> getSetAttributes();
	
	public Set<ApplicationConditionMatch> getApplicationConditionMatches();

	public Set<SuperimposedElement> getNodeMappings(Node editRuleNode);

	public Set<Reference> getEdgeMappings(Edge editRuleEdge);
	
	public Set<Attribute> getAttributeMappings(org.eclipse.emf.henshin.model.Attribute editRuleAttribute);
	
	public Set<Attribute> getAttributeSetOriginMappings(org.eclipse.emf.henshin.model.Attribute editRuleAttribute);
	
	public Set<SuperimposedElement> getForbidNodeMappings(Node editRuleNode, ApplicationConditionMatch match);
	
	public Set<Reference> getForbidEdgeMappings(Edge editRuleEdge, ApplicationConditionMatch match);
	
	public Set<Attribute> getForbidAttributeMappings(org.eclipse.emf.henshin.model.Attribute editRuleAttribute, ApplicationConditionMatch match);
	
	public Set<SuperimposedElement> getRequiredNodeMappings(Node editRuleNode, ApplicationConditionMatch match);
	
	public Set<Reference> getRequiredEdgeMappings(Edge editRuleEdge, ApplicationConditionMatch match);
	
	public Set<Attribute> getRequiredAttributeMappings (org.eclipse.emf.henshin.model.Attribute editRuleAttribute, ApplicationConditionMatch match);
}
