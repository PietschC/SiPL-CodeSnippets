package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.DeltaModuleAnnotations;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;

/**
 * 
 * @author cpietsch
 *
 */
public class DeltaModuleInterrelationResolver extends DeltaModuleRelationResolver {

	public DeltaModuleInterrelationResolver(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings, Map<DeltaModule, DeltaModuleAnnotations> deltaModuleAnnotations) {
		super(ruleBases, ruleElementMappings);
	}

	
	public void resolveConflicts(ConflictRelation conflictRelation, IProgressMonitor monitor) {
		assert !conflictRelation.isDomainCompliant() && conflictRelation.isConstraintCompliant(): "non-compliant conflict relation expcected!";
//		if (!conflictRelation.isDomainCompliant() && conflictRelation.isConstraintCompliant()) {
			for (Conflict conflict : new HashSet<Conflict>(conflictRelation.getConflicts())) {
				this.conflictResolver.resolve(conflict);
			}
			if (conflictRelation.getConflicts().isEmpty()) {
				LogUtil.log(LogEvent.INFO, "Removed Conflict Relation: " + conflictRelation);
				EcoreUtil.delete(conflictRelation, true);
			}
//		}
	}
	
	public void resolveConflictGroups(ApplicationConditionConflictRelation applicationConditionConflictRelation, IProgressMonitor monitor) {
		assert !applicationConditionConflictRelation.isDomainCompliant() && applicationConditionConflictRelation.isConstraintCompliant(): "non-compliant application condition conflict relation expected!";
//		if(!conflictRelationGroup.isDomainCompliant() && conflictRelationGroup.isConstraintCompliant()) {
			for(ApplicationConditionConflict conflictGroup : new HashSet<ApplicationConditionConflict>(applicationConditionConflictRelation.getApplicationConditionConflicts())) {
				this.applicationConditionConflictResolver.resolve(conflictGroup);
			}
//		}
	}
	
	public void resolveDependencies(DependencyRelation dependencyRelation, IProgressMonitor monitor) {
		assert !(dependencyRelation.isDomainCompliant() && dependencyRelation.isConstraintCompliant()): "non-compliant dependency relation expected!";
//		if (!(dependencyRelation.isDomainCompliant() && dependencyRelation.isConstraintCompliant())) {
			for(Dependency dependency : new HashSet<Dependency>(dependencyRelation.getDependencies())) {
				this.dependencyResolver.resolve(dependency);
			}	
//		}
	}
	
	public void resolveDependencyGroups(ApplicationConditionDependencyRelation applicationConditionDependencyRelation, IProgressMonitor monitor) {
		assert !(applicationConditionDependencyRelation.isDomainCompliant() && applicationConditionDependencyRelation.isConstraintCompliant()): "non-compliant application condition dependency relation expected!";
//		if(!(dependencyRelationGroup.isDomainCompliant() && dependencyRelationGroup.isConstraintCompliant())) {
			for(ApplicationConditionDependency applicationConditionDependency : new HashSet<ApplicationConditionDependency>(applicationConditionDependencyRelation.getApplicationConditionDependencies())) {
				this.applicationConditionDependencyResolver.resolve(applicationConditionDependency);
			}
//		}
	}
}
