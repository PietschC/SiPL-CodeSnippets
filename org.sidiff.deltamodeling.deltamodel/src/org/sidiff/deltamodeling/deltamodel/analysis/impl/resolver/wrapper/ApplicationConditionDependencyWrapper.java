package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.formula.Formula;

/**
 * 
 * @author cpietsch
 *
 */
public abstract class ApplicationConditionDependencyWrapper extends DeltaActionRelationWrapper<ApplicationConditionDependency> {

	protected Map<Dependency, DependencyWrapper> dependencies;
	
	public ApplicationConditionDependencyWrapper(ApplicationConditionDependency wrappy) {
		super(wrappy);
		this.dependencies = new HashMap<>();
		for(Dependency dependency : wrappy.getContributions()) {
			DependencyWrapper wrapper = new DependencyWrapper(dependency);
			dependencies.put(dependency, wrapper);
		}
	}
	
	public DependencyWrapper getDependencyWrapper(Dependency dependency){
		return this.dependencies.get(dependency);
	}
	
	public abstract Formula getFormula(Dependency dependency);

}
