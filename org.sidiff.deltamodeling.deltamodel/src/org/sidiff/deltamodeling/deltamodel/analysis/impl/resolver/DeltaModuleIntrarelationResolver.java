package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver;

import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleIntrarelationResolver extends DeltaModuleRelationResolver {

	public DeltaModuleIntrarelationResolver(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
		// TODO Auto-generated constructor stub
	}

}
