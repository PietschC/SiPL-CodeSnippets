package org.sidiff.deltamodeling.deltamodel.analysis.impl.resolver.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.Relation;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.deltamodeling.deltamodel.util.DeltaModelUtils;
import org.sidiff.deltamodeling.deltamodel.util.EcoreUtils;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.util.FormulaUtil;

/**
 * 
 * @author cpietsch
 *
 */
public class DependencyWrapper extends DeltaActionRelationWrapper<Dependency> {
	
	private Map<DependencyDetail, Formula> formulas;
	
	public DependencyWrapper(Dependency wrappy) {
		super(wrappy);
		this.formulas = new HashMap<DependencyDetail, Formula>();
		Relation relation = EcoreUtils.getContainer(wrappy, Relation.class);
		if(relation.isConstraintCompliant()) {
			if(relation instanceof DependencyRelation) {
				for(DependencyDetail detail : wrappy.getDetails()) {
					this.formulas.put(detail, EcoreUtil.copy(((DependencyRelation)relation).getTargetDeltaModule().getApplicationCondition()));
				}
			}else {
				ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation) relation;
				boolean isNAC = AnalysisUtils.isNegativeApplicationConditionRelation(applicationConditionDependencyRelation);
				if(isNAC) {
					DeltaModule sourceDeltaModule = applicationConditionDependencyRelation.getSourceDeltaModule();
					DeltaModule targetDeltaModule = applicationConditionDependencyRelation.getTargetDeltaModules().stream().filter(dm -> dm.getDelta().getOperationInvocations().contains(wrappy.getTargetDeltaAction())).findAny().get();
					Optional<ConstraintGroup> srcConstraintGroup = DeltaModelUtils.getConstraintGroup(sourceDeltaModule);
					Optional<ConstraintGroup> tgtConstraintGroup = DeltaModelUtils.getConstraintGroup(targetDeltaModule);
					assert srcConstraintGroup.isPresent() && tgtConstraintGroup.isPresent() : "delta module is not part of any partition of the application order constraint";
					DeltaModuleSet dms = (DeltaModuleSet) sourceDeltaModule.eContainer();
					int srcIndex = dms.getApplicationOrderConstraints().indexOf(srcConstraintGroup.get());
					int tgtIndex = dms.getApplicationOrderConstraints().indexOf(tgtConstraintGroup.get());
				
					for (DependencyDetail detail : wrappy.getDetails()) {
						this.formulas.put(detail,
								tgtIndex < srcIndex ? EcoreUtil.copy(targetDeltaModule.getApplicationCondition())
										: FormulaUtil.createFalse());
					}
					
				}else {		
					for(DependencyDetail detail : wrappy.getDetails()) {
						List<Formula> formulas = applicationConditionDependencyRelation.getTargetDeltaModules().stream().map(dm -> EcoreUtil.copy(dm.getApplicationCondition())).collect(Collectors.toList());
						this.formulas.put(detail, FormulaUtil.createAnd(formulas));
					}
				}
			}
		}else {
			for(DependencyDetail detail : wrappy.getDetails()) {
				this.formulas.put(detail, FormulaUtil.createFalse());
			}
		}
	}
	
	public Map<DependencyDetail, Formula> getFormulas() {
		return formulas;
	}
	
	public void addFormulaToDetail(Formula formula, DependencyDetail detail, final int OPERATOR) {
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
		for (DependencyDetail detail : formulas.keySet()) {
			conjunction.add(formulas.get(detail));
		}

		return FormulaUtil.createAnd(new ArrayList<Formula>(conjunction));
	}

}
