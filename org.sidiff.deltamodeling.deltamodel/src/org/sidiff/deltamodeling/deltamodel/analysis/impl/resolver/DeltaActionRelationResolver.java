package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.ConflictKind;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.DependencyKind;
import org.sidiff.deltamodeling.deltamodel.analysis.IRuleElementMapping;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.DeltaActionRelationOperation;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.difference.asymmetric.AttributeDependency;
import org.sidiff.difference.asymmetric.EdgeDependency;
import org.sidiff.difference.asymmetric.NodeDependency;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.editrule.rulebase.view.editrule.IEditRuleBase;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;

/**
 * An abstract class for resolving dependencies and conflicts between delta actions.
 * 
 * @param <R> must be {@link Conflict}, {@link ApplicationConditionConflict},
 *            {@link Dependency} or {@link ApplicationConditionDependency}
 * @author cpietsch
 *
 */
public abstract class DeltaActionRelationResolver<R> extends DeltaActionRelationOperation {
	
	public DeltaActionRelationResolver(Set<IEditRuleBase> ruleBases,
			Map<OperationInvocation, IRuleElementMapping> ruleElementMappings) {
		super(ruleBases, ruleElementMappings);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void resolve(R relation);
	
	
	/**
	 * Checks if a delta action exists internally that reverts the conflict inducing
	 * detail.
	 * 
	 * @param conflictDetail a modification inducing a conflict
	 * @param dependency     an internal dependency to an delta action that
	 *                       potentially resolve the conflict induced by the
	 *                       conflict detail
	 * @return <code>true</code> if the target of the dependency reverts the
	 *         conflict inducing modification, <code>false</code> otherwise
	 */
	protected boolean isInverse(ConflictDetail conflictDetail, org.sidiff.difference.asymmetric.Dependency dependency, DeltaModule targetModule) {
		if(AnalysisUtils.INTERNAL_CONFLICT_RESOLUTION.get(conflictDetail.getKind()) == dependency.getKind()){
			if(dependency instanceof NodeDependency) {
				NodeDependency nodeDependency = (NodeDependency) dependency;
				
				if(conflictDetail.getEntities().contains(nodeDependency.getObject())){
					return true;
				}
			}else if(dependency instanceof EdgeDependency) {
				EdgeDependency edgeDependency = (EdgeDependency) dependency;
				for(Entity entity : conflictDetail.getEntities()) {
					if(entity instanceof Reference) {
						Reference reference = (Reference) entity;
						if(reference.getType().equals(edgeDependency.getType()) && reference.getSource().equals(edgeDependency.getSrcObject()) && reference.getTarget().equals(edgeDependency.getTgtObject())) {
							return true;
						}
					}
				}
			}else if(dependency instanceof AttributeDependency) {

				IRuleElementMapping ruleElementMapping = resolveRuleElementMapping(dependency.getTarget(), targetModule);
				for(Entity entity : conflictDetail.getEntities()) {
					if(entity instanceof Attribute) {
						Attribute conflictAttribute = (Attribute) entity;
						Set<org.eclipse.emf.henshin.model.Attribute> ruleAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();
						ruleAttributes.addAll(ruleElementMapping.getDeletionAttributes());
						ruleAttributes.addAll(ruleElementMapping.getPreservedAttributes());
						for(org.eclipse.emf.henshin.model.Attribute ruleAttribute : ruleAttributes) {
							if(conflictAttribute.getType().equals(ruleAttribute.getType())){
								Set<Attribute> dependencyAttribute = ruleElementMapping.getAttributeMappings(ruleAttribute);
								if(dependencyAttribute.contains(conflictAttribute)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if the conflict inducing detail is reverted that by a delta action by an respective dependency detail.
	 * @param conflictDetail a modification inducing a conflict
	 * @param dependencyDetail an external dependency detail of a delta action that
	 *                       potentially resolve the conflict induced by the
	 *                       conflict detail
	 * @return <code>true</code> if the target of the modification of the dependency detail reverts the
	 *         conflict inducing modification, <code>false</code> otherwise
	 */
	protected boolean isInverse(ConflictDetail conflictDetail, DependencyDetail dependencyDetail) {
		return (AnalysisUtils.CONFLICT_RESOLUTION.get(conflictDetail.getKind()) == dependencyDetail.getKind() || conflictDetail.getKind() == ConflictKind.CREATE_FORBID && dependencyDetail.getKind() == DependencyKind.CHANGE_FORBID) && conflictDetail.getEntities().equals(dependencyDetail.getEntities());		
	}
	
	protected boolean isEqual(DependencyDetail dependencyDetail, org.sidiff.difference.asymmetric.Dependency alternativeDependencyDetail, DeltaModule sourceModule) {
		if(AnalysisUtils.INTERNAL_DEPENDENCY_KIND.get(alternativeDependencyDetail.getKind()) == dependencyDetail.getKind()) {
			if(alternativeDependencyDetail instanceof NodeDependency) {
				NodeDependency nodeDependency = (NodeDependency) alternativeDependencyDetail;
				
				if(dependencyDetail.getEntities().contains(nodeDependency.getObject())){
					return true;
				}
			}else if(alternativeDependencyDetail instanceof EdgeDependency) {
				EdgeDependency edgeDependency = (EdgeDependency) alternativeDependencyDetail;
				for(Entity entity : dependencyDetail.getEntities()) {
					if(entity instanceof Reference) {
						Reference reference = (Reference) entity;
						if(reference.getType().equals(edgeDependency.getType()) && reference.getSource().equals(edgeDependency.getSrcObject()) && reference.getTarget().equals(edgeDependency.getTgtObject())) {
							return true;
						}
					}
				}
			}else if(alternativeDependencyDetail instanceof AttributeDependency) {

				IRuleElementMapping ruleElementMapping = resolveRuleElementMapping(alternativeDependencyDetail.getSource(), sourceModule);
				for(Entity entity : dependencyDetail.getEntities()) {
					if(entity instanceof Attribute) {
						Attribute conflictAttribute = (Attribute) entity;
						Set<org.eclipse.emf.henshin.model.Attribute> ruleAttributes = new HashSet<org.eclipse.emf.henshin.model.Attribute>();
						ruleAttributes.addAll(ruleElementMapping.getDeletionAttributes());
						ruleAttributes.addAll(ruleElementMapping.getPreservedAttributes());
						for(org.eclipse.emf.henshin.model.Attribute ruleAttribute : ruleAttributes) {
							if(conflictAttribute.getType().equals(ruleAttribute.getType())){
								Set<Attribute> dependencyAttribute = ruleElementMapping.getAttributeMappings(ruleAttribute);
								if(dependencyAttribute.contains(conflictAttribute)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if two modifications represented by the dependency details are equal.
	 * 
	 * @param dependencyDetail  a {@link DependencyDetail}
	 * @param alternativeDetail a {@link DependencyDetail}
	 * @return <code>true</code> if equal, <code>false</code> otherwise
	 */
	protected boolean isEqual(DependencyDetail dependencyDetail, DependencyDetail alternativeDetail) {
		return dependencyDetail.getKind() == alternativeDetail.getKind() && dependencyDetail.getEntities().equals(alternativeDetail.getEntities());
		
	}
}
