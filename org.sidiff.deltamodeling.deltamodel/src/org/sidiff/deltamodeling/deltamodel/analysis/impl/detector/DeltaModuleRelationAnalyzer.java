package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.DeltaModelFactory;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.RuleElementMapping;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * An abstract class for analyzing delta modules.
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleRelationAnalyzer {

	protected static final DeltaModelFactory FACTORY = DeltaModelFactory.eINSTANCE;
	
	/**
	 * Cache of the {@link RuleElementMapping} for each delta action
	 */
	protected Map<OperationInvocation, IRuleElementMapping> ruleElementMappings;
	
	/**
	 * The {@link DeltaActionConflictAnalyzer}
	 */
	protected DeltaActionConflictAnalyzer conflictAnalyzer;
	
	/**
	 * The {@link DeltaActionDependencyAnalyzer}
	 */
	protected DeltaActionDependencyAnalyzer dependencyAnalyzer;
	
	/**
	 * The {@link DeltaActionDuplicateAnalyzer}
	 */
	protected DeltaActionDuplicateAnalyzer duplicateAnalyzer;
	
	/**
	 * The {@link DeltaActionTransientEffectAnalyzer}
	 */
	protected DeltaActionTransientEffectAnalyzer transientEffectAnalyzer;
	
	/**
	 * Constructor
	 * 
	 * @param ruleBases the {@link IEditRuleBase} containing the delta operations
	 * @param ruleElementMappings cache for the {@link IRuleElementMapping} of each delta action
	 */
	public DeltaModuleRelationAnalyzer(Set<IEditRuleBase> ruleBases, Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		this.ruleElementMappings = ruleElementMappings;
		this.conflictAnalyzer = new DeltaActionConflictAnalyzer(ruleBases, ruleElementMappings);
		this.dependencyAnalyzer = new DeltaActionDependencyAnalyzer(ruleBases, ruleElementMappings);
		this.duplicateAnalyzer = new DeltaActionDuplicateAnalyzer(ruleBases, ruleElementMappings);
		this.transientEffectAnalyzer = new DeltaActionTransientEffectAnalyzer(ruleBases, ruleElementMappings);
	}
	
}
