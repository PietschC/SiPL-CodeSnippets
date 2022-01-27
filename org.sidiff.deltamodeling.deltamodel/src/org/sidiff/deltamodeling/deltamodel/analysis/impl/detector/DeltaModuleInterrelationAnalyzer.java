package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.Duplicate;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;
import org.sidiff.deltamodeling.deltamodel.TransientEffect;
import org.sidiff.deltamodeling.deltamodel.TransientEffectRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch.PartialConflict;
import org.sidiff.deltamodeling.deltamodel.analysis.util.ApplicationConditionMatch.PartialDependency;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * Extends {@link DeltaModuleRelationAnalyzer} for analyzing interrelations
 * between delta modules.
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleInterrelationAnalyzer extends DeltaModuleRelationAnalyzer {
	
	/**
	 * Constructor
	 * 
	 * @param ruleBases the {@link IEditRuleBase} containing the delta operations
	 * @param ruleElementMappings cache for the {@link IRuleElementMapping} of each delta action
	 */
	public DeltaModuleInterrelationAnalyzer(Set<IEditRuleBase> ruleBases, Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}
	
	/**
	 * Analyzes the given {@link DeltaModule}s for conflicts. The delta modules are
	 * in conflict if at least one delta action of srcDeltaModule conflicts with a
	 * delta action of tgtDeltaModule.
	 * 
	 * @param srcDeltaModule the source {@link DeltaModule}
	 * @param tgtDeltaModule the target {@link DeltaModule}
	 * @param monitor        an {@link IProgressMonitor}
	 * @return a {@link ConflictRelation} between both delta modules containing all
	 *         conflicts between the respective delta actions or <code>null</code>
	 *         if their aren't any conflicts
	 */
	public ConflictRelation analyzeConflicts(DeltaModule srcDeltaModule, DeltaModule tgtDeltaModule, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 1);
		Set<Conflict> conflicts =  analyze(srcDeltaModule, tgtDeltaModule, this.conflictAnalyzer, progress.split(1));
		if(!conflicts.isEmpty()) {
			ConflictRelation conflictyRelation = FACTORY.createConflictRelation();
			conflictyRelation.setSourceDeltaModule(srcDeltaModule);
			conflictyRelation.setTargetDeltaModule(tgtDeltaModule);
			conflictyRelation.getConflicts().addAll(conflicts);
			return conflictyRelation;
		}
		return null;
	}
	
	/**
	 * Analyzes the given {@link DeltaModule}s for dependencies. The srcDeltaModule
	 * depends on the tgtDeltamodule if at least one delta action of the former one
	 * depends on one delta action of the later one. Furthermore detected conflicts
	 * are check for resolving dependencies.
	 * 
	 * @param srcDeltaModule the source {@link DeltaModule}
	 * @param tgtDeltaModule the target {@link DeltaModule}
	 * @param monitor        an {@link IProgressMonitor}
	 * @return a {@link DependencyRelation} between both delta modules containing
	 *         all dependencies of the respective delta actions or <code>null</code>
	 *         if their aren't any dependencies
	 */
	public DependencyRelation analyzeDependencies(DeltaModule srcDeltaModule, DeltaModule tgtDeltaModule, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 1);
		Set<Dependency> dependencies = analyze(srcDeltaModule, tgtDeltaModule, this.dependencyAnalyzer, progress.split(1));
		if(!dependencies.isEmpty()) {
			DependencyRelation dependencyRelation = FACTORY.createDependencyRelation();
			dependencyRelation.setSourceDeltaModule(srcDeltaModule);
			dependencyRelation.setTargetDeltaModule(tgtDeltaModule);
			dependencyRelation.getDependencies().addAll(dependencies);
			return dependencyRelation;
		}
		return null;
	}
	
	/**
	 * Analyzes both {@link DeltaModule}s for duplicates. The delta modules lead to
	 * duplicates if the contain at least one pair of delta actions that are
	 * duplicates.
	 * 
	 * @param deltaModule1 a {@link DeltaModule}
	 * @param deltaModule2 a {@link DeltaModule}
	 * @param monitor      and {@link IProgressMonitor}
	 * @return a {@link DuplicateRelation} between both delta modules containing all
	 *         duplicated delta actions or <code>null</code> if their aren't any
	 *         duplicates
	 */
	public DuplicateRelation analyzeDuplicates(DeltaModule deltaModule1, DeltaModule deltaModule2, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 1);
		Set<Duplicate> duplicates = analyze(deltaModule1, deltaModule2, this.duplicateAnalyzer, progress.split(1));
		if(!duplicates.isEmpty()) {
			DuplicateRelation duplicateRelation = FACTORY.createDuplicateRelation();
			duplicateRelation.getDeltaModules().add(deltaModule1);
			duplicateRelation.getDeltaModules().add(deltaModule2);
			duplicateRelation.getDuplicates().addAll(duplicates);
			return duplicateRelation;
		}
		return null;
	}
	
	/**
	 * Analyzes both {@link DeltaModule}s for occurring transient effects, i.e. at
	 * least one delta action of the srcDeltaModule reverts the effect of a delta
	 * action of the tgtDeltaModule.
	 * 
	 * @param srcDeltaModule the source {@link DeltaModule}
	 * @param tgtDeltaModule the target {@link DeltaModule}
	 * @param monitor        an {@link IProgressMonitor}
	 * @return a {@link TransientEffectRelation} between both delta modules
	 *         containing all pairs of delta actions leading to transient effects of
	 *         <code>null</code> if their aren't any transient effects
	 */
	public TransientEffectRelation analyzeTransientEffects(DeltaModule srcDeltaModule, DeltaModule tgtDeltaModule, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 1);
		Set<TransientEffect> transientEffects = analyze(srcDeltaModule, tgtDeltaModule, this.transientEffectAnalyzer, progress.split(1));
		if(!transientEffects.isEmpty()) {
			TransientEffectRelation transientEffectRelation = FACTORY.createTransientEffectRelation();
			transientEffectRelation.setSourceDeltaModule(srcDeltaModule);
			transientEffectRelation.setTargetDeltaModule(tgtDeltaModule);
			transientEffectRelation.getTransientEffects().addAll(transientEffects);
			return transientEffectRelation;
		}
		return null;
	}
	
	
	/**
	 * Iterates over all delta actions of deltaModule1 and deltaModule2 and analyzes
	 * each pair of delta action for respective interrelations.
	 * 
	 * @param <S>                         must be {@link Conflict},
	 *                                    {@link Dependency}, {@link Duplicate} or
	 *                                    {@link TransientEffect}
	 * @param deltaModule1                a {@link DeltaModule}
	 * @param deltaModule2                a {@link DeltaModule}
	 * @param monitor	an {@link IProgressMonitor}
	 * @param deltaActionRelationAnalyzer a {@link DeltaActionConflictAnalyzer}
	 * @return a set of interrelations according to the type parameter <S>
	 */
	private <S> Set<S> analyze(DeltaModule deltaModule1, DeltaModule deltaModule2, DeltaActionRelationAnalyzer<S> deltaActionRelationAnalyzer, IProgressMonitor monitor){
		SubMonitor progress =  SubMonitor.convert(monitor, deltaModule1.getDelta().getOperationInvocations().size() * deltaModule2.getDelta().getOperationInvocations().size());
		deltaActionRelationAnalyzer.init(deltaModule1, deltaModule2);
		Set<S> deltaActionRelations = new HashSet<S>();
		for(OperationInvocation deltaAction1 : deltaModule1.getDelta().getOperationInvocations()){
			for(OperationInvocation deltaAction2 : deltaModule2.getDelta().getOperationInvocations()){
				S deltaActionRelation = deltaActionRelationAnalyzer.analyze(deltaAction1, deltaAction2);
				if(deltaActionRelation != null){
					deltaActionRelations.add(deltaActionRelation);
				}
				progress.worked(1);
			}
		}
		return deltaActionRelations;
	}	
	

	/**
	 * Iterates over the {@link ApplicationConditionMatch}es for each delta action
	 * in the given {@link DeltaModule} in order to find all
	 * {@link ApplicationConditionDependency}(ies)
	 * 
	 * @param deltaModule a {@link DeltaModule}
	 * @param monitor     an {@link IProgressMonitor}
	 * @return all detected {@link ApplicationConditionDependencyRelation}s for each
	 *         delta-action in the given delta-module
	 */
	public Set<ApplicationConditionDependencyRelation> analyzeDependencies(DeltaModule deltaModule, IProgressMonitor monitor){
		SubMonitor progress =  SubMonitor.convert(monitor, deltaModule.getDelta().getOperationInvocations().size());
		Set<ApplicationConditionDependencyRelation> result = new HashSet<ApplicationConditionDependencyRelation>();
		Map<Set<DeltaModule>, Set<ApplicationConditionDependency>> applicationConditionDependencies = new HashMap<Set<DeltaModule>, Set<ApplicationConditionDependency>>();
		for(OperationInvocation deltaAction : deltaModule.getDelta().getOperationInvocations()) {
			IRuleElementMapping ruleElementMapping = ruleElementMappings.get(deltaAction);
			Map<String, Set<ApplicationConditionDependency>> alternatives = new HashMap<>();
			for (ApplicationConditionMatch applicationConditionMatch : ruleElementMapping
					.getApplicationConditionMatches()) {
				Set<Set<PartialDependency>> combinations = applicationConditionMatch.combinePartialDependencies();
				

				for (Set<PartialDependency> variant : combinations) {

					Set<DeltaModule> deltaModules = new HashSet<DeltaModule>();
					ApplicationConditionDependency applicationConditionDependency = FACTORY.createApplicationConditionDependency();
					applicationConditionDependency.setMatchID(applicationConditionMatch.getMatchID());
					applicationConditionDependency.setConditionID(applicationConditionMatch.getACId());
					applicationConditionDependency.setKind(applicationConditionMatch.isNac()?ApplicationConditionKind.NAC: ApplicationConditionKind.PAC);

					for (PartialDependency partialDependency : variant) {

						OperationInvocation tgtAction = partialDependency.getDeltaAction();
						OperationInvocation srcAction = ruleElementMapping.getDeltaAction();

						Dependency dependency = FACTORY.createDependency();
						dependency.setSourceDeltaAction(srcAction);
						dependency.setTargetDeltaAction(tgtAction);
						dependency.getDetails().addAll(EcoreUtil.copyAll(partialDependency.getDetails()));

						deltaModules.add(partialDependency.getDeltaModule());
						applicationConditionDependency.getContributions().add(dependency);
					}
					if (!applicationConditionDependencies.containsKey(deltaModules)) {
						applicationConditionDependencies.put(deltaModules, new HashSet<ApplicationConditionDependency>());
					}
					applicationConditionDependencies.get(deltaModules).add(applicationConditionDependency);
					if (alternatives.get(applicationConditionMatch.getACId()) == null) {
						alternatives.put(applicationConditionMatch.getACId(), new HashSet<>());
					}
					alternatives.get(applicationConditionMatch.getACId()).add(applicationConditionDependency);
				}
			}
			
			for(String key : alternatives.keySet()) {
				for(ApplicationConditionDependency applicationConditionDependency : alternatives.get(key)) {
					applicationConditionDependency.getCoDependencies().addAll(alternatives.get(key));
					applicationConditionDependency.getCoDependencies().remove(applicationConditionDependency);
				}
			}
			progress.worked(1);
		}
		
		for (Entry<Set<DeltaModule>, Set<ApplicationConditionDependency>> entry : applicationConditionDependencies.entrySet()) {
			ApplicationConditionDependencyRelation applicationConditionDependencyRelation = FACTORY.createApplicationConditionDependencyRelation();
			applicationConditionDependencyRelation.getTargetDeltaModules().addAll(entry.getKey());
			applicationConditionDependencyRelation.setSourceDeltaModule(deltaModule);
			applicationConditionDependencyRelation.getApplicationConditionDependencies().addAll(entry.getValue());
			result.add(applicationConditionDependencyRelation);
		}

		return result;
	}
	
	/**
	 * Iterates over the {@link ApplicationConditionMatch}es for each delta action
	 * in the given {@link DeltaModule} in order to find all
	 * {@link ApplicationConditionConflict}s
	 * 
	 * @param deltaModule a {@link DeltaModule}
	 * @param monitor     an {@link IProgressMonitor}
	 * @return all detected {@link ApplicationConditionConflictRelation}s for each
	 *         delta-action in the given delta-module
	 */
	public Set<ApplicationConditionConflictRelation> analyzeConflicts(DeltaModule deltaModule, IProgressMonitor monitor){
		SubMonitor progress =  SubMonitor.convert(monitor, deltaModule.getDelta().getOperationInvocations().size());
		Set<ApplicationConditionConflictRelation> result = new HashSet<ApplicationConditionConflictRelation>();
		Map<Set<DeltaModule>, Set<ApplicationConditionConflict>> applicationConditionConflicts = new HashMap<Set<DeltaModule>, Set<ApplicationConditionConflict>>();
		for(OperationInvocation deltaAction : deltaModule.getDelta().getOperationInvocations()) {
			IRuleElementMapping ruleElementMapping = ruleElementMappings.get(deltaAction);
			Map<String, Set<ApplicationConditionConflict>> alternatives = new HashMap<>();
			for (ApplicationConditionMatch applicationConditionMatch : ruleElementMapping
					.getApplicationConditionMatches()) {
				Set<Set<PartialConflict>> combinations = applicationConditionMatch.combinePartialConflicts();
				
				for (Set<PartialConflict> variant : combinations) {

					Set<DeltaModule> deltaModules = new HashSet<DeltaModule>();
					ApplicationConditionConflict applicationConditionConflict = FACTORY.createApplicationConditionConflict();
					applicationConditionConflict.setMatchID(applicationConditionMatch.getMatchID());
					applicationConditionConflict.setConditionID(applicationConditionMatch.getACId());
					applicationConditionConflict.setKind(applicationConditionMatch.isNac()? ApplicationConditionKind.NAC : ApplicationConditionKind.PAC);
					for (PartialConflict partialConflict : variant) {

						OperationInvocation tgtAction = ruleElementMapping.getDeltaAction();
						OperationInvocation srcAction = partialConflict.getDeltaAction();

						Conflict conflict = FACTORY.createConflict();
						conflict.setSourceDeltaAction(srcAction);
						conflict.setTargetDeltaAction(tgtAction);

						conflict.getDetails().addAll(EcoreUtil.copyAll(partialConflict.getDetails()));

						deltaModules.add(partialConflict.getDeltaModule());
						applicationConditionConflict.getContributions().add(conflict);
					}
					if (!applicationConditionConflicts.containsKey(deltaModules)) {
						applicationConditionConflicts.put(deltaModules, new HashSet<ApplicationConditionConflict>());
					}
					applicationConditionConflicts.get(deltaModules).add(applicationConditionConflict);
					if (alternatives.get(applicationConditionMatch.getACId()) == null) {
						alternatives.put(applicationConditionMatch.getACId(), new HashSet<>());
					}
					alternatives.get(applicationConditionMatch.getACId()).add(applicationConditionConflict);
				}
			}
			for(String key : alternatives.keySet()) {
				for(ApplicationConditionConflict applicationConditionConflict : alternatives.get(key)) {
					applicationConditionConflict.getCoConflicts().addAll(alternatives.get(key));
					applicationConditionConflict.getCoConflicts().remove(applicationConditionConflict);
				}
			}	
			progress.worked(1);
		}
		
		for (Entry<Set<DeltaModule>, Set<ApplicationConditionConflict>> entry : applicationConditionConflicts.entrySet()) {
			ApplicationConditionConflictRelation conflictRelationGroup = FACTORY.createApplicationConditionConflictRelation();
			conflictRelationGroup.setTargetDeltaModule(deltaModule);
			conflictRelationGroup.getSourceDeltaModules().addAll(entry.getKey());
			conflictRelationGroup.getApplicationConditionConflicts().addAll(entry.getValue());
			result.add(conflictRelationGroup);
		}
		
		return result;
	}
}
