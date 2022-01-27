package org.sidiff.deltamodeling.deltamodel.analysis.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictKind;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyKind;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.DuplicateKind;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;
import org.sidiff.deltamodeling.deltamodel.Relation;
import org.sidiff.deltamodeling.deltamodel.TransientEffectKind;
import org.sidiff.deltamodeling.deltamodel.TransientEffectRelation;
import org.sidiff.editrule.analysis.criticalpairs.InterRuleBasePotentialConflictAnalyzer;
import org.sidiff.editrule.analysis.criticalpairs.InterRuleBasePotentialDependencyAnalyzer;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.PotentialConflict;
import org.sidiff.editrule.rulebase.PotentialConflictKind;
import org.sidiff.editrule.rulebase.PotentialDependency;
import org.sidiff.editrule.rulebase.PotentialDependencyKind;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * 
 * @author cpietsch
 *
 */
public class AnalysisUtils {
	
public static final Map<org.sidiff.difference.asymmetric.DependencyKind, DependencyKind> INTERNAL_DEPENDENCY_KIND = new HashMap<org.sidiff.difference.asymmetric.DependencyKind, DependencyKind>();
	
	public static final Map<ConflictKind, org.sidiff.difference.asymmetric.DependencyKind> INTERNAL_CONFLICT_RESOLUTION = new HashMap<ConflictKind, org.sidiff.difference.asymmetric.DependencyKind>();
	public static final Map<ConflictKind, DependencyKind> CONFLICT_RESOLUTION = new HashMap<ConflictKind, DependencyKind>();
	public static final Map<PotentialConflictKind, ConflictKind> CONFLICT_KIND = new HashMap<PotentialConflictKind, ConflictKind>();
	public static final Map<PotentialDependencyKind, DependencyKind> DEPENDENCY_KIND = new HashMap<PotentialDependencyKind, DependencyKind>();
	public static final Map<PotentialConflictKind, DuplicateKind> DUPLICATE_KIND = new HashMap<PotentialConflictKind, DuplicateKind>();
	public static final Map<PotentialDependencyKind, TransientEffectKind> DEP_TRANSIENT_EFFECT_KIND = new HashMap<PotentialDependencyKind, TransientEffectKind>();
	public static final Map<PotentialConflictKind, TransientEffectKind> CON_TRANSIENT_EFFECT_KIND = new HashMap<PotentialConflictKind, TransientEffectKind>();
	static {
		INTERNAL_CONFLICT_RESOLUTION.put(ConflictKind.DELETE_USE, org.sidiff.difference.asymmetric.DependencyKind.CREATE_USE);
		INTERNAL_CONFLICT_RESOLUTION.put(ConflictKind.CREATE_FORBID, org.sidiff.difference.asymmetric.DependencyKind.DELETE_FORBID);
		INTERNAL_CONFLICT_RESOLUTION.put(ConflictKind.CHANGE_USE, org.sidiff.difference.asymmetric.DependencyKind.CHANGE_USE);
		INTERNAL_CONFLICT_RESOLUTION.put(ConflictKind.CHANGE_FORBID, org.sidiff.difference.asymmetric.DependencyKind.CHANGE_FORBID);
		INTERNAL_CONFLICT_RESOLUTION.put(ConflictKind.DANGLING_CONFLICT, org.sidiff.difference.asymmetric.DependencyKind.DANGLING_DEPENDENCY);
		
		INTERNAL_DEPENDENCY_KIND.put(org.sidiff.difference.asymmetric.DependencyKind.CREATE_USE, DependencyKind.CREATE_USE);
		INTERNAL_DEPENDENCY_KIND.put(org.sidiff.difference.asymmetric.DependencyKind.DELETE_FORBID, DependencyKind.DELETE_FORBID);
		INTERNAL_DEPENDENCY_KIND.put(org.sidiff.difference.asymmetric.DependencyKind.CHANGE_USE, DependencyKind.CHANGE_USE);
		INTERNAL_DEPENDENCY_KIND.put(org.sidiff.difference.asymmetric.DependencyKind.CHANGE_FORBID, DependencyKind.CHANGE_FORBID);
		INTERNAL_DEPENDENCY_KIND.put(org.sidiff.difference.asymmetric.DependencyKind.DANGLING_DEPENDENCY, DependencyKind.DANGLING_DEPENDENCY);
		
		CONFLICT_RESOLUTION.put(ConflictKind.DELETE_USE, DependencyKind.CREATE_USE);
		CONFLICT_RESOLUTION.put(ConflictKind.CREATE_FORBID, DependencyKind.DELETE_FORBID);
		CONFLICT_RESOLUTION.put(ConflictKind.CHANGE_USE, DependencyKind.CHANGE_USE);
		CONFLICT_RESOLUTION.put(ConflictKind.CHANGE_FORBID, DependencyKind.CHANGE_FORBID);
		CONFLICT_RESOLUTION.put(ConflictKind.DANGLING_CONFLICT, DependencyKind.DANGLING_DEPENDENCY);
		
		CONFLICT_KIND.put(PotentialConflictKind.DELETE_USE, ConflictKind.DELETE_USE);
		CONFLICT_KIND.put(PotentialConflictKind.CREATE_FORBID, ConflictKind.CREATE_FORBID);
		CONFLICT_KIND.put(PotentialConflictKind.CHANGE_USE, ConflictKind.CHANGE_USE);
		CONFLICT_KIND.put(PotentialConflictKind.CHANGE_FORBID, ConflictKind.CHANGE_FORBID);
		CONFLICT_KIND.put(PotentialConflictKind.CHANGE_CHANGE, ConflictKind.CHANGE_CHANGE);
		CONFLICT_KIND.put(PotentialConflictKind.DANGLING_CONFLICT, ConflictKind.DANGLING_CONFLICT);
		
		DEPENDENCY_KIND.put(PotentialDependencyKind.CREATE_USE, DependencyKind.CREATE_USE);
		DEPENDENCY_KIND.put(PotentialDependencyKind.DELETE_FORBID, DependencyKind.DELETE_FORBID);
		DEPENDENCY_KIND.put(PotentialDependencyKind.CHANGE_USE, DependencyKind.CHANGE_USE);
		DEPENDENCY_KIND.put(PotentialDependencyKind.CHANGE_FORBID, DependencyKind.CHANGE_FORBID);
		DEPENDENCY_KIND.put(PotentialDependencyKind.DANGLING_DEPENDENCY, DependencyKind.DANGLING_DEPENDENCY);
		
		DUPLICATE_KIND.put(PotentialConflictKind.CREATE_FORBID, DuplicateKind.CREATE_CREATE);
		DUPLICATE_KIND.put(PotentialConflictKind.DELETE_USE, DuplicateKind.DELETE_DELETE);
		DUPLICATE_KIND.put(PotentialConflictKind.CHANGE_USE, DuplicateKind.CHANGE_CHANGE);
		DUPLICATE_KIND.put(PotentialConflictKind.CHANGE_CHANGE, DuplicateKind.CHANGE_CHANGE);
		
		DEP_TRANSIENT_EFFECT_KIND.put(PotentialDependencyKind.CREATE_USE, TransientEffectKind.CREATE_DELETE);
		DEP_TRANSIENT_EFFECT_KIND.put(PotentialDependencyKind.DELETE_FORBID, TransientEffectKind.DELETE_CREATE);
		DEP_TRANSIENT_EFFECT_KIND.put(PotentialDependencyKind.CHANGE_USE, TransientEffectKind.CHANGE_CHANGE);
		
		CON_TRANSIENT_EFFECT_KIND.put(PotentialConflictKind.CHANGE_CHANGE, TransientEffectKind.CHANGE_CHANGE);
	}

	public static  EditRule getEditRule(String name, Set<IEditRuleBase> ruleBases) {
		EditRule editRule = null;
		for(IEditRuleBase editRuleBase : ruleBases) {
			editRule = editRuleBase.getEditRule(name);
			if(editRule != null) {
				break;
			}
		}
		return editRule;
	}
	
	public static Set<PotentialConflict> getPotentialConflicts(EditRule erSrc, EditRule erTgt, Set<IEditRuleBase> ruleBases) {
		// Rule base internal potential conflicts
		Set<PotentialConflict> potentialConflicts = new HashSet<PotentialConflict>();
		for (IEditRuleBase rb : ruleBases) {
			for(PotentialConflict potentialConflict : rb.getPotentialConflicts(erSrc)){
				if(potentialConflict.getTargetRule().equals(erTgt)){
					potentialConflicts.add(potentialConflict);
				}
			}
		}
	
		// Rule base cross over potential conflicts
		if (ruleBases.size() > 1) {
			InterRuleBasePotentialConflictAnalyzer interRuleBasePotentialConflictAnalyzer = new InterRuleBasePotentialConflictAnalyzer(
					ruleBases);

			if (interRuleBasePotentialConflictAnalyzer.isNecessary()) {
				for (PotentialConflict potentialConflict : interRuleBasePotentialConflictAnalyzer
						.getPotentialConflicts(erSrc)) {
					if (potentialConflict.getTargetRule().equals(erTgt)) {
						potentialConflicts.add(potentialConflict);
					}
				}
			}
		}
		return potentialConflicts;
	}
	
	public static Set<PotentialDependency> getPotentialDependencies(EditRule erSrc, EditRule erTgt, Set<IEditRuleBase> ruleBases) {
		// Rule base internal potential dependencies
		Set<PotentialDependency> potentialDependencies = new HashSet<PotentialDependency>();
		for (IEditRuleBase rb : ruleBases) {
			for(PotentialDependency potentialDependency : rb.getPotentialDependencies(erSrc)){
				if(potentialDependency.getTargetRule().equals(erTgt)){
					potentialDependencies.add(potentialDependency);
				}
			}
			
		}

		// Rule base cross over potential dependencies
		if(ruleBases.size() > 1){
			InterRuleBasePotentialDependencyAnalyzer interRuleBasePotentialDependencyAnalyzer = new InterRuleBasePotentialDependencyAnalyzer(
					ruleBases);
		
		if (interRuleBasePotentialDependencyAnalyzer.isNecessary()) {
			for(PotentialDependency potentialDependency : interRuleBasePotentialDependencyAnalyzer.getPotentialDependencies(erSrc)){
				if(potentialDependency.getTargetRule().equals(erTgt)){
					potentialDependencies.add(potentialDependency);
				}
			}
		}
		}

		return potentialDependencies;
	}
	
	
	public static boolean isNegativeApplicationConditionRelation(Relation relation) {
		if(relation instanceof ApplicationConditionConflictRelation) {
			return ((ApplicationConditionConflictRelation) relation).getApplicationConditionConflicts().stream()
			.allMatch(acc -> acc.getKind() == ApplicationConditionKind.NAC);	
		}else if( relation instanceof ApplicationConditionDependencyRelation) {
			return ((ApplicationConditionDependencyRelation) relation).getApplicationConditionDependencies().stream()
					.allMatch(acc -> acc.getKind() == ApplicationConditionKind.NAC);	
		}
		return false;
	}
	
	public static List<ConflictRelation> getConflictRelations(DuplicateRelation duplicateRelation){
		List<ConflictRelation> conflictRelations = new ArrayList<ConflictRelation>();
		for(Conflict conflict : duplicateRelation.getDuplicates().get(0).getConflict()) {
			ConflictRelation conflictRelation = (ConflictRelation) conflict.eContainer();
			conflictRelations.add(conflictRelation);
		}
		return conflictRelations;
	}
	
	public static DependencyRelation getDependencyRelations(TransientEffectRelation transientEffectRelation){
		Dependency dependency = transientEffectRelation.getTransientEffects().get(0).getDependency();
		return (DependencyRelation) dependency.eContainer();
	}
	
	public static class MathUtils {
		public static BigInteger factorial(int n) {
			BigInteger result = BigInteger.ONE;
		    for (int i = 2; i <= n; i++)
		        result = result.multiply(BigInteger.valueOf(i));
		    return result;
		}
		
		public static BigInteger nCr(int n, int r) {
			return factorial(n).divide(factorial(r).multiply(factorial(n-r)));
		}
	}
}
