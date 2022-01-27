package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.stream.Collectors;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.formula.Formula;
import org.sidiff.formula.util.FormulaUtil;

public class NegativeApplicationConditionDependencyWrapper extends ApplicationConditionDependencyWrapper {

	public NegativeApplicationConditionDependencyWrapper(ApplicationConditionDependency wrappy) {
		super(wrappy);
	}

	public Formula getFormula(Dependency dependency) {
		Formula formula = this.dependencies.get(dependency).getFormula();
		return formula;		
	}
	
	@Override
	public Formula getFormula() {
		return FormulaUtil.createOr(this.dependencies.values().stream().map(c -> c.getFormula()).collect(Collectors.toList()));
	}
}
