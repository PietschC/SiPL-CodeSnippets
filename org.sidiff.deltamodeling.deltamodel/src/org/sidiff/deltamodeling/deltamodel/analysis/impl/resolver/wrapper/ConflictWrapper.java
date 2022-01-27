package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.util.FormulaUtil;

/**
 * 
 * @author cpietsch
 *
 */
public class ConflictWrapper extends DeltaActionRelationWrapper<Conflict> {

	private Map<ConflictDetail, Formula> formulas;
	
	public ConflictWrapper(Conflict wrappy) {
		super(wrappy);
		this.formulas = new HashMap<ConflictDetail, Formula>();
		for (ConflictDetail detail : wrappy.getDetails()) {
			this.formulas.put(detail, FormulaUtil.createFalse());
		}
	}
	
	public Map<ConflictDetail, Formula> getFormulas() {
		return formulas;
	}
	
	public void addFormulaToDetail(Formula formula, ConflictDetail detail, final int OPERATOR) {
		Formula copy = EcoreUtil.copy(formula);
		Formula origin = this.formulas.get(detail);
		switch (OPERATOR) {
		case FormulaPackage.AND:
			this.formulas.put(detail, FormulaUtil.createAnd(origin, copy));
			break;
		case FormulaPackage.OR:
			this.formulas.put(detail, FormulaUtil.createOr(origin, copy));
			break;
		default:
			throw new AssertionError("unsupported formula operator with class id: " + OPERATOR);
			
		}
	}

	@Override
	public Formula getFormula() {
		Set<Formula> conjunction = new HashSet<Formula>();
		for (ConflictDetail detail : formulas.keySet()) {
			conjunction.add(formulas.get(detail));
		}

		return FormulaUtil.createAnd(new ArrayList<Formula>(conjunction));
	}

}
