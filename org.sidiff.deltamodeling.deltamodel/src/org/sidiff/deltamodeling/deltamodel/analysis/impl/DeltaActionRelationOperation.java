package org.sidiff.deltamodeling.deltamodel.analysis.impl;

import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.DeltaModelFactory;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * An {@link DeltaActionRelationOperation} is responsible for resolving and
 * caching {@link IRuleElementMapping}s for a given set of delta actions.
 * 
 * @author cpietsch
 *
 */
public abstract class DeltaActionRelationOperation {

	protected static final DeltaModelFactory FACTORY = DeltaModelFactory.eINSTANCE;

	/**
	 * The {@link IEditRuleBase}s containing delta operations of delta actions to be
	 * analyzed
	 */
	protected Set<IEditRuleBase> ruleBases;

	/**
	 * Cache of the {@link RuleElementMapping} for each delta action
	 */
	protected Map<OperationInvocation, IRuleElementMapping> ruleElementMappings;


	public DeltaActionRelationOperation(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		this.ruleBases = ruleBases;
		this.ruleElementMappings = ruleElementMappings;
	}
	
	/**
	 * Resolves and caches the {@link IRuleElementMapping} for a given delta action.
	 * 
	 * @param deltaAction a delta action for that the {@link IRuleElementMapping}
	 *                    should be resolved
	 * @param deltaModule a {@link DeltaModule} that contains the delta action
	 * @return the resolved {@link IRuleElementMapping}
	 */
	protected IRuleElementMapping resolveRuleElementMapping(OperationInvocation deltaAction, DeltaModule deltaModule) {
		IRuleElementMapping ruleElementMapping = ruleElementMappings.get(deltaAction);
		if (ruleElementMapping == null) {
			EditRule editRule = AnalysisUtils.getEditRule(deltaAction.getEditRuleName(), ruleBases);
			assert (editRule != null) : "EditRule for delta operation " + deltaAction.getEditRuleName()
					+ " cannot be resolved!";
			ruleElementMapping = new RuleElementMapping(deltaAction, editRule, deltaModule);
			ruleElementMappings.put(deltaAction, ruleElementMapping);
		}
		return ruleElementMapping;
	}
}
