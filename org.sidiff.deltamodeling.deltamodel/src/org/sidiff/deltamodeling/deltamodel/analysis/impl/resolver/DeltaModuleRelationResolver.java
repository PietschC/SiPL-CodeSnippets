package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver;

import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * An abstract class for resolving dependencies and conflicts between delta
 * modules.
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleRelationResolver {

	protected DeltaActionConflictResolver conflictResolver;
	
	protected DeltaActionApplicationConditionConflictResolver applicationConditionConflictResolver;
	
	protected DeltaActionDependencyResolver dependencyResolver;
	
	protected DeltaActionApplicationConditionDependencyResolver applicationConditionDependencyResolver;
	
	
	public DeltaModuleRelationResolver(Set<IEditRuleBase> ruleBases, Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		this.conflictResolver = new DeltaActionConflictResolver(ruleBases, ruleElementMappings);
		this.applicationConditionConflictResolver = new DeltaActionApplicationConditionConflictResolver(ruleBases, ruleElementMappings);
		this.dependencyResolver = new DeltaActionDependencyResolver(ruleBases, ruleElementMappings);
		this.applicationConditionDependencyResolver = new DeltaActionApplicationConditionDependencyResolver(ruleBases, ruleElementMappings);
	}
}
