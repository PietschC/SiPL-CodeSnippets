package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.ConflictKind;
import org.sidiff.formula.Formula;

/**
 * 
 * @author cpietsch
 *
 */
public abstract class ApplicationConditionConflictWrapper extends DeltaActionRelationWrapper<ApplicationConditionConflict> {

	protected Map<Conflict, ConflictWrapper> conflicts;
	
	/**
	 * maps the conflict detail to conflict wrapper of other conflicts that contribute to the application condition conflict
	 */
	protected Map<ConflictDetail, Set<ConflictWrapper>> detailCoverage;
	
	/**
	 * maps the conflict detail to a conflict detail of another conflict wrapper in {@link #detailCoverage}
	 */
	protected Map<ConflictDetail, Set<ConflictDetail>> detailCorrespondences;
	
	public ApplicationConditionConflictWrapper(ApplicationConditionConflict wrappy) {
		super(wrappy);
		this.conflicts = new HashMap<>();
		this.detailCoverage = new HashMap<>();
		this.detailCorrespondences = new HashMap<>();
		for(Conflict conflict : wrappy.getContributions()) {
			ConflictWrapper wrapper = new ConflictWrapper(conflict);
			conflicts.put(conflict, wrapper);
			for(ConflictDetail detail: conflict.getDetails()) {
				detailCoverage.put(detail, new HashSet<>());
				detailCorrespondences.put(detail, new HashSet<>());
			}
		}
		for(ConflictWrapper outerWrapper : conflicts.values()) {
			for(ConflictWrapper innerWrapper : conflicts.values()) {
				if(!outerWrapper.equals(innerWrapper)) {
					for(ConflictDetail outerDetail : outerWrapper.getWrappy().getDetails()) {
						for(ConflictDetail innerDetail : innerWrapper.getWrappy().getDetails()) {
							if(isEqual(outerDetail, innerDetail)) {
								detailCoverage.get(outerDetail).add(innerWrapper);
								detailCorrespondences.get(outerDetail).add(innerDetail);
							}
						}
					}
				}
			}
		}
	}
	
	public ConflictWrapper getConflictWrapper(Conflict conflict){
		return this.conflicts.get(conflict);
	}
	
	
	public abstract Formula getFormula(Conflict conflict);
	
	private boolean isEqual(ConflictDetail conflictDetail1, ConflictDetail conflictDetail2) {
		return (conflictDetail1.getKind() == conflictDetail2.getKind() || conflictDetail1.getKind() == ConflictKind.CREATE_FORBID && conflictDetail2.getKind() == ConflictKind.CHANGE_FORBID || conflictDetail2.getKind() == ConflictKind.CREATE_FORBID && conflictDetail1.getKind() == ConflictKind.CHANGE_FORBID) && conflictDetail1.getEntities().equals(conflictDetail2.getEntities());
	}
}
