package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.formula.Formula;
import org.sidiff.formula.util.FormulaUtil;

public class NegativeApplicationConditionConflictWrapper extends ApplicationConditionConflictWrapper {

	public NegativeApplicationConditionConflictWrapper(ApplicationConditionConflict wrappy) {
		super(wrappy);
	}

	public Formula getFormula(Conflict conflict) {
		// in case of a NAC at least one conflict detail must be resolved
		// however, if another conflict of the same application condition conflict
		// contains an equivalent conflict detail, it must also be resolved

		ConflictWrapper conflictWrapper = this.conflicts.get(conflict);
		Set<Formula> disjunction = new HashSet<>();
		for (ConflictDetail detail : conflictWrapper.getFormulas().keySet()) {

			Formula copyFormula = EcoreUtil.copy(conflictWrapper.getFormulas().get(detail));

			if (detailCoverage.get(detail).size() > 0) {
				Set<Formula> conjunction = new HashSet<>();
				for (ConflictWrapper wrapper : detailCoverage.get(detail)) {
					Optional<ConflictDetail> originDetail = detailCorrespondences.get(detail).stream()
							.filter(d -> wrapper.getWrappy().getDetails().contains(d)).findAny();

					if (originDetail.isPresent()) {
						conjunction.add(EcoreUtil.copy(wrapper.getFormulas().get(originDetail.get())));
					}
				}

				disjunction.add(
						FormulaUtil.createAnd(copyFormula, FormulaUtil.createAnd(new ArrayList<Formula>(conjunction))));
			} else {
				disjunction.add(copyFormula);
			}
		}
		return FormulaUtil.createOr(new ArrayList<Formula>(disjunction));
	}
	
	@Override
	public Formula getFormula() {
		return FormulaUtil.createOr(this.conflicts.values().stream().map(c -> c.getFormula()).collect(Collectors.toList()));		
	}
}
