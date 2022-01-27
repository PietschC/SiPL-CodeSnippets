package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.stream.Collectors;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.formula.Formula;
import org.sidiff.formula.util.FormulaUtil;

public class PositiveApplicationConditionConflictWrapper extends ApplicationConditionConflictWrapper {

	public PositiveApplicationConditionConflictWrapper(ApplicationConditionConflict wrappy) {
		super(wrappy);
	}

	public Formula getFormula(Conflict conflict) {
		// in case of an PAC all details must be resolved
		return this.conflicts.get(conflict).getFormula();
	}
	
	@Override
	public Formula getFormula() {
		return FormulaUtil.createAnd(this.conflicts.values().stream().map(c -> c.getFormula()).collect(Collectors.toList()));
	}
}
