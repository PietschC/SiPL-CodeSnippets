package org.sidiff.deltamodeling.deltamodel.analysis.impl.detector;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
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
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * Extends {@link DeltaModuleRelationAnalyzer} for analyzing intrarelations between delta actions of a delta module.
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleIntrarelationAnalyzer extends DeltaModuleRelationAnalyzer {

	public DeltaModuleIntrarelationAnalyzer(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
	}

	public ConflictRelation analyzeConflicts(DeltaModule deltaModule, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 1);
		Set<Conflict> conflicts =  analyze(deltaModule, this.conflictAnalyzer, progress.split(1));
		if(!conflicts.isEmpty()) {
			ConflictRelation conflictyRelation = FACTORY.createConflictRelation();
			conflictyRelation.setSourceDeltaModule(deltaModule);
			conflictyRelation.setTargetDeltaModule(deltaModule);
			conflictyRelation.getConflicts().addAll(conflicts);
			return conflictyRelation;
		}
		return null;
	}
	
	public DependencyRelation analyzeDependencies(DeltaModule deltaModule, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 1);
		Set<Dependency> dependencies = analyze(deltaModule, this.dependencyAnalyzer, progress.split(1));
		if(!dependencies.isEmpty()) {
			DependencyRelation dependencyRelation = FACTORY.createDependencyRelation();
			dependencyRelation.setSourceDeltaModule(deltaModule);
			dependencyRelation.setTargetDeltaModule(deltaModule);
			dependencyRelation.getDependencies().addAll(dependencies);
			return dependencyRelation;
		}
		return null;
	}
	
	public DuplicateRelation analyzeDuplicates(DeltaModule deltaModule, IProgressMonitor monitor) {
		int work = AnalysisUtils.MathUtils.nCr(deltaModule.getDelta().getOperationInvocations().size(), 2).intValueExact();
		SubMonitor progress =  SubMonitor.convert(monitor, work);
		Set<Duplicate> duplicates = new HashSet<Duplicate>();
		for(int i = 0; i <  deltaModule.getDelta().getOperationInvocations().size()-1; i++) {
			for(int j = i+1; j < deltaModule.getDelta().getOperationInvocations().size(); j++) {
				Duplicate duplicate = duplicateAnalyzer.analyze(deltaModule.getDelta().getOperationInvocations().get(i), deltaModule.getDelta().getOperationInvocations().get(j));
				if(duplicate != null) {
					duplicates.add(duplicate);
				}
				progress.worked(1);
			}
		}
		if(!duplicates.isEmpty()) {
			DuplicateRelation duplicateRelation = FACTORY.createDuplicateRelation();
			duplicateRelation.getDeltaModules().add(deltaModule);
			duplicateRelation.getDeltaModules().add(deltaModule);
			duplicateRelation.getDuplicates().addAll(duplicates);
			return duplicateRelation;
		}
		return null;
	}
	
	public TransientEffectRelation analyzeTransientEffects(DeltaModule deltaModule, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 1);
		Set<TransientEffect> transientEffects = analyze(deltaModule, this.transientEffectAnalyzer, progress.split(1));
		if(!transientEffects.isEmpty()) {
			TransientEffectRelation transientEffectRelation = FACTORY.createTransientEffectRelation();
			transientEffectRelation.setSourceDeltaModule(deltaModule);
			transientEffectRelation.setTargetDeltaModule(deltaModule);
			transientEffectRelation.getTransientEffects().addAll(transientEffects);
			return transientEffectRelation;
		}
		return null;
	}
	
	private <S> Set<S> analyze(DeltaModule deltaModule, DeltaActionRelationAnalyzer<S> deltaActionRelationAnalyzer, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, deltaModule.getDelta().getOperationInvocations().size()*deltaModule.getDelta().getOperationInvocations().size());
		deltaActionRelationAnalyzer.init(deltaModule, deltaModule);
		Set<S> deltaActionRelations = new HashSet<S>();
		for (OperationInvocation deltaAction1 : deltaModule.getDelta().getOperationInvocations()) {
			for (OperationInvocation deltaAction2 : deltaModule.getDelta().getOperationInvocations()) {
				if (!deltaAction1.equals(deltaAction2)) {
					S deltaActionRelation = deltaActionRelationAnalyzer.analyze(deltaAction1, deltaAction2);
					if (deltaActionRelation != null) {
						deltaActionRelations.add(deltaActionRelation);
					}
				}
				progress.worked(1);
			}
		}
		return deltaActionRelations;
	}

}
