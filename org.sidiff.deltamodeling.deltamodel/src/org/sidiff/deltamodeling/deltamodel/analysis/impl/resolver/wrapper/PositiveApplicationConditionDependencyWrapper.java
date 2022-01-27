package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.stream.Collectors;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.formula.Formula;
import org.sidiff.formula.util.FormulaUtil;

public class PositiveApplicationConditionDependencyWrapper extends ApplicationConditionDependencyWrapper {

	public PositiveApplicationConditionDependencyWrapper(ApplicationConditionDependency wrappy) {
		super(wrappy);
	}
	
	public Formula getFormula(Dependency dependency) {
		return this.dependencies.get(dependency).getFormula();
	}
	
	@Override
	public Formula getFormula() {
		return FormulaUtil.createAnd(this.dependencies.values().stream().map(c -> c.getFormula()).collect(Collectors.toList()));
	}

}
