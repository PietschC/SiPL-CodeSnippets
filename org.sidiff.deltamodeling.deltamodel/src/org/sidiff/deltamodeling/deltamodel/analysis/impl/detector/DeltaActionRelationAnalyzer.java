package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.Duplicate;
import org.sidiff.deltamodeling.deltamodel.TransientEffect;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.DeltaActionRelationOperation;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * An abstract class for analyzing delta actions
 * 
 *
 * @param <R> must be {@link Conflict}, {@link Dependency}, {@link Duplicate} or
 *            {@link TransientEffect}
 *            
 * @author cpietsch
 */
public abstract class DeltaActionRelationAnalyzer<R> extends DeltaActionRelationOperation {

	/**
	 * The {@link DeltaModule} containing the fist delta action to be analyzed
	 */
	protected DeltaModule deltaModule1;

	/**
	 * The {@link DeltaModule} containing the second delta action to be analyzed
	 */
	protected DeltaModule deltaModule2;

	/**
	 * The {@link IRuleElementMapping} of the first delta action to be analyzed
	 */
	protected IRuleElementMapping ruleElementMapping1;

	/**
	 * The {@link IRuleElementMapping} of the second delta action to be analyzed
	 */
	protected IRuleElementMapping ruleElementMapping2;
	
	public DeltaActionRelationAnalyzer(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}

	public void init(DeltaModule deltaModule1, DeltaModule deltaModule2) {
		this.deltaModule1 = deltaModule1;
		this.deltaModule2 = deltaModule2;
	}

	/**
	 * Analyzes the given delta actions for a specific kind of relation. <R> must be
	 * {@link Conflict}, {@link Dependency}, {@link Duplicate} or
	 * {@link TransientEffect}
	 * 
	 * @param deltaAction1 a delta action
	 * @param deltaAction2 a delta action
	 * @return an interrelation of type <R> or null
	 */
	public abstract R analyze(OperationInvocation deltaAction1, OperationInvocation deltaAction2);

	/**
	 * Utility method for getting the conflict introduced by the former delta action
	 * that precludes the later one.
	 * 
	 * @param deltaAction1 conflict inducing delta action
	 * @param deltaAction2 conflict precluded delta action
	 * @return Conflict that is introduced by delta action 1 and precludes delta
	 *         action 2 or <code>null</code>
	 */
	protected Conflict getOutgoingConflict(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {
		for (Conflict conflict : deltaModule1.getOutgoingConflicts(deltaAction1)) {
			if (conflict.getTargetDeltaAction().equals(deltaAction2)) {
				return conflict;
			}
		}
		return null;
	}

	/**
	 * Utility method for getting the conflict introduced by the second delta action
	 * that precludes the former one.
	 * 
	 * @param deltaAction1 conflict precluded delta action
	 * @param deltaAction2 conflict inducing delta action
	 * @return {@link Conflict} introduced by delta action 2 and precludes delta
	 *         action 1 or <code>null</code>
	 */
	protected Conflict getIncomingConflict(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {
		for (Conflict conflict : deltaModule2.getOutgoingConflicts(deltaAction2)) {
			if (conflict.getTargetDeltaAction().equals(deltaAction1)) {
				return conflict;
			}
		}
		return null;
	}

	/**
	 * Utility method for getting the dependency of the first delta action to the
	 * later one.
	 * 
	 * @param deltaAction1 dependent delta action
	 * @param deltaAction2 preceding delta action
	 * @return {@link Dependency} from delta action 1 to delta action 2 or <code>null</code>
	 */
	protected Dependency getOutgoingDependency(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {
		for (Dependency dependency : deltaModule1.getOutgoingDependencies(deltaAction1)) {
			if (dependency.getTargetDeltaAction().equals(deltaAction2)) {
				return dependency;
			}
		}
		return null;
	}
	
	/**
	 * Utility method for getting the dependency of the second delta action to the
	 * former one.
	 * 
	 * @param deltaAction1 preceding delta action
	 * @param deltaAction2 dependent delta action
	 * @return {@link Dependency} from delta action 2 to delta action 1 or <code>null</code>
	 */
	protected Dependency getIncomingDependency(OperationInvocation deltaAction1, OperationInvocation deltaAction2) {
		for (Dependency dependency : deltaModule2.getOutgoingDependencies(deltaAction2)) {
			if (dependency.getTargetDeltaAction().equals(deltaAction1)) {
				return dependency;
			}
		}
		return null;
	}

	/**
	 * Utility method for getting the duplicate between both delta actions.
	 * 
	 * @param deltaAction1 delta action
	 * @param deltaAction2 duplicate delta action
	 * @return Duplicate between delta action 1 to delta action 2 or <code>null</code>
	 */
	protected Duplicate getDuplicate(OperationInvocation deltaAction1, OperationInvocation deltaActionn2) {
		for (Duplicate duplicate : deltaModule1.getDuplicates(deltaAction1)) {
			if (duplicate.getDeltaActions().contains(deltaActionn2)) {
				return duplicate;
			}
		}
		return null;
	}

	/**
	 * Utility method for getting the transient effect of delta action 1 that
	 * reverts delta action 2.
	 * 
	 * @param deltaAction1 reverting delta action
	 * @param deltaAction2 reverted delta action
	 * @return {@link TransientEffect} between delta action 1 reverting delta action
	 *         2 or <code>null</code>
	 */
	protected TransientEffect getOutgoingTransientEffect(OperationInvocation deltaAction1,
			OperationInvocation deltaAction2) {
		for (TransientEffect transientEffect : deltaModule1.getOutgoingTransientEffects(deltaAction1)) {
			if (transientEffect.getTargetDeltaAction().equals(deltaAction2)) {
				return transientEffect;
			}
		}
		return null;
	}

	/**
	 * Utility method for getting the transient effect of delta action 1 that
	 * is reverted by delta action 2.
	 * 
	 * @param deltaAction1 reverted delta action 
	 * @param deltaAction2 reverting delta action
	 * @return {@link TransientEffect} between delta action 1 reverting delta action
	 *         2 or <code>null</code>
	 */
	protected TransientEffect getIncomingTransientEffect(OperationInvocation deltaAction1,
			OperationInvocation deltaAction2) {
		for (TransientEffect transientEffect : deltaModule2.getOutgoingTransientEffects(deltaAction2)) {
			if (transientEffect.getTargetDeltaAction().equals(deltaAction1)) {
				return transientEffect;
			}
		}
		return null;
	}
}
