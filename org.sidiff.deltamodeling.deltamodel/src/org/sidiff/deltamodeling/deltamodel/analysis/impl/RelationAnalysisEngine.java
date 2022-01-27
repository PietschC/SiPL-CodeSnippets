package org.sidiff.deltamodeling.deltamodel.analysis.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.statistics.StatisticsUtil;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;
import org.sidiff.deltamodeling.deltamodel.Relation;
import org.sidiff.deltamodeling.deltamodel.TransientEffectRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.detector.DeltaModuleInterrelationAnalyzer;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.detector.DeltaModuleIntrarelationAnalyzer;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.DeltaModuleInterrelationResolver;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.deltamodeling.deltamodel.util.DeltaModelUtils;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.difference.lifting.api.util.PipelineUtils;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.formula.Variable;

/**
 * The {@link RelationAnalysisEngine} provides analysis and resolving operations
 * for conflicts and dependencies between delta modules.
 * 
 * @author cpietsch
 *
 */
public class RelationAnalysisEngine implements IRelationAnalysisEngine {

	/**
	 * The {@link DeltaModuleSet} containing the {@link DeltaModule}s to be analyzed
	 */
	private DeltaModuleSet dms;

	/**
	 * Cache for the {@link IRuleElementMapping} of a delta action
	 */
	private Map<OperationInvocation, IRuleElementMapping> ruleElementMappings;

	/**
	 * The {@link DeltaModuleIntrarelationAnalyzer} for pairwise analyzing delta actions of one delta module
	 */
	private DeltaModuleIntrarelationAnalyzer intrarelationAnalyzer;
	
	/**
	 * The {@link DeltaModuleInterrelationAnalyzer} for pairwise analyzing delta actions of different delta modules
	 */
	private DeltaModuleInterrelationAnalyzer interrelationAnalyzer;

	/**
	 * The {@link DeltaModuleInterrelationResolver} for resolving conflicts and filtering unnecessary relations
	 */
	private DeltaModuleInterrelationResolver interrelationResolver;

	/**
	 * The {@link DomainComplianceAnalyzer} for checking if a relation really occur in the problem space
	 */
	private DomainComplianceAnalyzer domainComplianceAnalyzer;
	
	/**
	 * The {@link ApplicationOrderComplianceAnalyzer} for checking if a relation isn't compliant to the application order constraints.
	 */
	private ApplicationOrderComplianceAnalyzer applicationOrderComplianceAnalyzer;

	/**
	 * Constructor
	 * 
	 * @param dms the {@link DeltaModuleSet} containing the {@link DeltaModule}s to
	 *            be analyzed
	 */
	public RelationAnalysisEngine(DeltaModuleSet dms) {
		this.dms = dms;
		EcoreUtil.resolveAll(this.dms);
		
		this.ruleElementMappings = new HashMap<OperationInvocation, IRuleElementMapping>();
		Set<IEditRuleBase> ruleBases = new HashSet<IEditRuleBase>();

		// TODO find a better solution to get the correct rule base
		for (ILiftingRuleBase liftingRuleBase : PipelineUtils
				.getAvailableRulebases(new HashSet<String>(dms.getSuperimposedModel().getDocType()))) {
			ruleBases.add(liftingRuleBase);
		}

		Map<DeltaModule, DeltaModuleAnnotations> deltaModuleAnnotations = new HashMap<DeltaModule, DeltaModuleAnnotations>();
		for(DeltaModule deltaModule : dms.getDeltaModules()) {
			deltaModuleAnnotations.put(deltaModule, new DeltaModuleAnnotations(deltaModule));
		}
		this.intrarelationAnalyzer = new DeltaModuleIntrarelationAnalyzer(ruleBases, ruleElementMappings);
		this.interrelationAnalyzer = new DeltaModuleInterrelationAnalyzer(ruleBases, ruleElementMappings);

		this.interrelationResolver = new DeltaModuleInterrelationResolver(ruleBases, ruleElementMappings, deltaModuleAnnotations);

		this.domainComplianceAnalyzer = new DomainComplianceAnalyzer(this.dms.getFeatureModel());

		this.applicationOrderComplianceAnalyzer = new ApplicationOrderComplianceAnalyzer();

	}
	
	@Override
	public void analyze(IProgressMonitor monitor) {
		int work = AnalysisUtils.MathUtils.nCr(dms.getDeltaModules().size(), 2).intValueExact() + dms.getDeltaModules().size();
		SubMonitor progress =  SubMonitor.convert(monitor, work);
		progress.setTaskName("Analyzing relations ...");
		
		clear();
		
		for (int i = 0; i < dms.getDeltaModules().size() - 1; i++) {
			for (int j = i + 1; j < dms.getDeltaModules().size(); j++) {			
				analyze(dms.getDeltaModules().get(i), dms.getDeltaModules().get(j), progress.split(1));
			}
		}
		
		for(DeltaModule deltaModule : dms.getDeltaModules()) {
			analyze(deltaModule, progress.split(1));
		}
	}
	
	@Override
	public void resolve(IProgressMonitor monitor) {
		
		Set<ConflictRelation> nonCompliantConflictRelations = new HashSet<>(dms.getConflictRelations().stream().filter(r -> r.isConstraintCompliant() && !r.isDomainCompliant()).collect(Collectors.toSet()));
		Set<ApplicationConditionConflictRelation> nonCompliantApplicationConditionConflictRelations = new HashSet<>(dms.getApplicationConditionConflictRelations().stream().filter(r -> r.isConstraintCompliant() && !r.isDomainCompliant()).collect(Collectors.toSet()));
		Set<DependencyRelation> nonCompliantDependencyRelations = new HashSet<>(dms.getDependencyRelations().stream().filter(r -> !r.isConstraintCompliant() || !r.isDomainCompliant()).collect(Collectors.toSet()));
		Set<ApplicationConditionDependencyRelation> nonCompliantDependencyRelationGroups = new HashSet<>(dms.getApplicationConditionDependencyRelations().stream().filter(r -> !r.isConstraintCompliant() || !r.isDomainCompliant()).collect(Collectors.toSet()));
		
		int work = nonCompliantConflictRelations.size()+nonCompliantApplicationConditionConflictRelations.size()+nonCompliantDependencyRelations.size()+nonCompliantDependencyRelationGroups.size(); 
		SubMonitor progress =  SubMonitor.convert(monitor, work);
		progress.setTaskName("Resolving relations ...");
		
		StatisticsUtil.getInstance().start("Family-based approach");
		
		for (ConflictRelation conflictRelation : nonCompliantConflictRelations) {
			resolve(conflictRelation, progress.split(1));
		}
		
		for(ApplicationConditionConflictRelation applicationConditionConflictRelation : nonCompliantApplicationConditionConflictRelations) {
			resolve(applicationConditionConflictRelation, progress.split(1));
		}
		
		for (DependencyRelation dependencyRelation : nonCompliantDependencyRelations) {
			resolve(dependencyRelation, progress.split(1));
		}
		
		for (ApplicationConditionDependencyRelation applicationConditionDependencyRelation : nonCompliantDependencyRelationGroups) {
			resolve(applicationConditionDependencyRelation, progress.split(1));
		}
		
		StatisticsUtil.getInstance().stop("Family-based approach");
	}

	/**
	 * Analyze conflicts, dependencies, duplicates and transient effects between
	 * pairs of delta modules.
	 * 
	 * @param deltaModule1 a {@link DeltaModule}
	 * @param deltaModule2 a {@link DeltaModule}
	 * @param monitor an {@link IProgressMonitor}
	 */
	private void analyze(DeltaModule deltaModule1, DeltaModule deltaModule2, IProgressMonitor monitor) {
		int work = 0;
		if(DeltaModelUtils.isCoreModule(deltaModule1) || DeltaModelUtils.isCoreModule(deltaModule2)){
			work = 11;
		}else {
			work = 13;
		}
		
		SubMonitor progress =  SubMonitor.convert(monitor, work);
		progress.setTaskName("Analyzing relations between " + deltaModule1.getName() + " and " + deltaModule2.getName());
		
		// skip empty delta modules
		if(deltaModule1.getDelta() == null || deltaModule2.getDelta() == null) {
			progress.worked(work);
			return;
		}		
		
//		if(!DeltaModelUtils.isCoreModule(deltaModule2)) {
			StatisticsUtil.getInstance().start("Pair-wise approach");
			ConflictRelation conflictRelation = interrelationAnalyzer.analyzeConflicts(deltaModule1, deltaModule2, progress.split(1));
			StatisticsUtil.getInstance().stop("Pair-wise approach");
			if (conflictRelation != null) {
				dms.getConflictRelations().add(conflictRelation);
				checkCompliance(conflictRelation, progress.split(1));
			}else {
				progress.worked(1);
			}
//		}
		
//		if(!DeltaModelUtils.isCoreModule(deltaModule1)) {
			StatisticsUtil.getInstance().start("Pair-wise approach");
			conflictRelation = interrelationAnalyzer.analyzeConflicts(deltaModule2, deltaModule1, progress.split(1));
			StatisticsUtil.getInstance().stop("Pair-wise approach");
			if (conflictRelation != null) {
				dms.getConflictRelations().add(conflictRelation);
				checkCompliance(conflictRelation, progress.split(1));
			}else {
				progress.worked(1);
			}
//		}

//		if (!DeltaModelUtils.isCoreModule(deltaModule1)) {
			StatisticsUtil.getInstance().start("Pair-wise approach");
			DependencyRelation dependencyRelation = interrelationAnalyzer.analyzeDependencies(deltaModule1,
					deltaModule2, progress.split(1));
			StatisticsUtil.getInstance().stop("Pair-wise approach");
			if (dependencyRelation != null) {
				dms.getDependencyRelations().add(dependencyRelation);
				checkCompliance(dependencyRelation, progress.split(1));
			}else {
				progress.worked(1);
			}
//		}
		
//		if(!DeltaModelUtils.isCoreModule(deltaModule2)) {
			StatisticsUtil.getInstance().start("Pair-wise approach");
			dependencyRelation = interrelationAnalyzer.analyzeDependencies(deltaModule2, deltaModule1, progress.split(1));
			StatisticsUtil.getInstance().stop("Pair-wise approach");
			if (dependencyRelation != null) {
				dms.getDependencyRelations().add(dependencyRelation);
				checkCompliance(dependencyRelation, progress.split(1));
			}else {
				progress.worked(1);
			}
//		}
		
		if (!DeltaModelUtils.isCoreModule(deltaModule2)) {
			StatisticsUtil.getInstance().start("Pair-wise approach");
			TransientEffectRelation transientEffectRelation = interrelationAnalyzer
					.analyzeTransientEffects(deltaModule1, deltaModule2, progress.split(1));
			StatisticsUtil.getInstance().stop("Pair-wise approach");
			if (transientEffectRelation != null) {
				dms.getTransientEffectRelation().add(transientEffectRelation);
				checkCompliance(transientEffectRelation, progress.split(1));
			}else {
				progress.worked(1);
			}
		}
		
		if(!DeltaModelUtils.isCoreModule(deltaModule1)) {
			StatisticsUtil.getInstance().start("Pair-wise approach");
			TransientEffectRelation transientEffectRelation = interrelationAnalyzer.analyzeTransientEffects(deltaModule2,
					deltaModule1, progress.split(1));
			StatisticsUtil.getInstance().stop("Pair-wise approach");
			if (transientEffectRelation != null) {
				dms.getTransientEffectRelation().add(transientEffectRelation);
				checkCompliance(transientEffectRelation, progress.split(1));
			}else {
				progress.worked(1);
			}
		}

		StatisticsUtil.getInstance().start("Pair-wise approach");
		DuplicateRelation duplicateRelation = interrelationAnalyzer.analyzeDuplicates(deltaModule1, deltaModule2, progress.split(1));
		StatisticsUtil.getInstance().stop("Pair-wise approach");
		if (duplicateRelation != null) {
			dms.getDuplicateRelations().add(duplicateRelation);
			checkCompliance(duplicateRelation, progress.split(1));
		}else {
			progress.worked(1);
		}

	}
	
	/**
	 * Analyzes a given delta module for internal relations
	 * 
	 * @param deltaModule a {@link DeltaModule}
	 * @param monitor     an {@link IProgressMonitor}
	 */
	private void analyze(DeltaModule deltaModule, IProgressMonitor monitor) {
		int work = 5;
		SubMonitor progress =  SubMonitor.convert(monitor, work);
		progress.setTaskName("Analyzing application conditions for " + deltaModule.getName());
		// skip empty delta modules
		if (deltaModule.getDelta() == null) {
			return;
		}
		
		// analyze for internal transient effects
		//
		TransientEffectRelation transientEffectRelation = intrarelationAnalyzer.analyzeTransientEffects(deltaModule, progress.split(1));
		if(transientEffectRelation != null) {
			dms.getTransientEffectRelation().add(transientEffectRelation);
		}

		// analyze for dependencies and conflicts due to nacs and pacs
		StatisticsUtil.getInstance().start("Application conditions");
		Set<ApplicationConditionDependencyRelation> applicationConditionDependencyRelations = interrelationAnalyzer.analyzeDependencies(deltaModule, progress.split(1));
		StatisticsUtil.getInstance().stop("Application conditions");
		if(!applicationConditionDependencyRelations.isEmpty()) {
			dms.getApplicationConditionDependencyRelations().addAll(applicationConditionDependencyRelations);
			checkCompliance(applicationConditionDependencyRelations, progress.split(1));
		}else {
			progress.worked(1);
		}
		
		StatisticsUtil.getInstance().start("Application conditions");
		Set<ApplicationConditionConflictRelation> applicationConditionConflictRelations = interrelationAnalyzer.analyzeConflicts(deltaModule, progress.split(1));
		StatisticsUtil.getInstance().stop("Application conditions");
		if(!applicationConditionConflictRelations.isEmpty()) {
			dms.getApplicationConditionConflictRelations().addAll(applicationConditionConflictRelations);
			checkCompliance(applicationConditionConflictRelations, progress.split(1));
		}else {
			progress.worked(1);
		}
	}
	
	/**
	 * Tries to resolve a given dependency or conflict relation.
	 * @param relation a {@link Relation}
	 * @param monitor an {@link IProgressMonitor}
	 */
	private void resolve(Relation relation, IProgressMonitor monitor) {
		
		SubMonitor progress = SubMonitor.convert(monitor, 1);
		
		switch (relation.eClass().getClassifierID()) {
		case DeltaModelPackage.DEPENDENCY_RELATION:
			DependencyRelation dependencyRelation = (DependencyRelation) relation;
			if(!dependencyRelation.isInternal()) {
//				progress =  SubMonitor.convert(monitor, dependencyRelation.getDependencies().size());
				this.interrelationResolver.resolveDependencies((DependencyRelation) relation, progress.split(1));
			}else {progress.worked(1);}
			break;
		case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION:
			ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) relation;
			if(!applicationConditionDependencyRelation.isInternal()) {
//				progress =  SubMonitor.convert(monitor, dependencyRelationGroup.getDependencyGroups().size());
				this.interrelationResolver.resolveDependencyGroups(applicationConditionDependencyRelation, progress.split(1));
			}else {progress.worked(1);}
			break;
		case DeltaModelPackage.CONFLICT_RELATION:
			ConflictRelation conflictRelation = (ConflictRelation) relation;
			if(!conflictRelation.isInternal()) {
//				progress =  SubMonitor.convert(monitor, conflictRelation.getConflicts().size());
				this.interrelationResolver.resolveConflicts((ConflictRelation) relation, progress.split(1));
			}else {progress.worked(1);}
			break;
		case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION:
			ApplicationConditionConflictRelation applicationConditionConflictRelation = (ApplicationConditionConflictRelation) relation;
			if(!applicationConditionConflictRelation.isInternal()) {
//				progress =  SubMonitor.convert(monitor, conflictRelationGroup.getConflictGroups().size());
				this.interrelationResolver.resolveConflictGroups(applicationConditionConflictRelation, progress.split(1));
			}else {progress.worked(1);}
			break;
		default:
			new AssertionError("unsupported relation type");
			break;
		}
		
	}
	
	/**
	 * Iterates over a given set of relations to check their domain and application
	 * order compliance.
	 * 
	 * @param relations set of {@link Relation}s
	 * @param monitor   an {@link IProgressMonitor}
	 */
	private void checkCompliance(Set<? extends Relation> relations, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, relations.size());
		relations.forEach(group -> checkCompliance(group, progress.split(1)));
	}
	
	/**
	 * Checks the compliance of a given relation
	 * 
	 * @param relation a {@link Relation}
	 * @param monitor  an {@link IProgressMonitor}
	 */
	private void checkCompliance(Relation relation, IProgressMonitor monitor) {
		SubMonitor progress =  SubMonitor.convert(monitor, 2);
		StatisticsUtil.getInstance().start("Compliance approach");
		Collection<Variable> config = new HashSet<Variable>();
		Collection<ConstraintGroup> constraints = new HashSet<ConstraintGroup>();
		switch(relation.eClass().getClassifierID()) {
		case DeltaModelPackage.CONFLICT_RELATION:
			ConflictRelation conflictRelation = (ConflictRelation) relation;
			config = domainComplianceAnalyzer.analyze(conflictRelation, progress.split(1));
			constraints = applicationOrderComplianceAnalyzer.analyze(conflictRelation, progress.split(1));
			break;
		case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION:
			ApplicationConditionConflictRelation applicationConditionConflictRelation = (ApplicationConditionConflictRelation) relation;
			config = domainComplianceAnalyzer.analyze(applicationConditionConflictRelation, progress.split(1));
			constraints = applicationOrderComplianceAnalyzer.analyze(applicationConditionConflictRelation, progress.split(1));
			break;
		case DeltaModelPackage.DEPENDENCY_RELATION:
			DependencyRelation dependencyRelation = (DependencyRelation) relation;
			config = domainComplianceAnalyzer.analyze(dependencyRelation, progress.split(1));
			if(!config.isEmpty()) {
				dependencyRelation.setVoid(domainComplianceAnalyzer.isVoid(dependencyRelation, progress.split(1)));
			}
			constraints = applicationOrderComplianceAnalyzer.analyze(dependencyRelation, progress.split(1));
			break;
		case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION:
			ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) relation;
			config = domainComplianceAnalyzer.analyze(applicationConditionDependencyRelation, progress.split(1));
			constraints = applicationOrderComplianceAnalyzer.analyze(applicationConditionDependencyRelation, progress.split(1));
			break;
		case DeltaModelPackage.DUPLICATE_RELATION:
			config = domainComplianceAnalyzer.analyze((DuplicateRelation) relation, progress.split(1));
			break;
		case DeltaModelPackage.TRANSIENT_EFFECT_RELATION:
			TransientEffectRelation transientEffectRelation = (TransientEffectRelation) relation;
			config = domainComplianceAnalyzer.analyze(transientEffectRelation, progress.split(1));
			constraints = applicationOrderComplianceAnalyzer.analyze(transientEffectRelation, progress.split(1));
			break;
		default:
			break;
		}
		
		relation.getUnsatisfiedConfig().addAll(config);
		relation.getUnfulfilledConstraints().addAll(constraints);
		StatisticsUtil.getInstance().stop("Compliance approach");
	}

	/**
	 * Deletes all relations.
	 */
	private void clear() {
		StatisticsUtil.getInstance().start("Clean up");
		EcoreUtil.deleteAll(this.dms.getAllRelations(), true);
		StatisticsUtil.getInstance().stop("Clean up");
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
