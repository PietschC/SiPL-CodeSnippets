package org.sidiff.deltamodeling.deltamodel.analysis.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;
import org.sidiff.deltamodeling.deltamodel.TransientEffectRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.util.AnalysisUtils;
import org.sidiff.formula.Formula;
import org.sidiff.formula.Variable;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.SatResult.EStatus;
import org.sidiff.formula.util.FormulaUtil;

/**
 * The {@link DomainComplianceAnalyzer} provides analysis operations for
 * checking the correctness of specified application conditions between related
 * delta modules w.r.t. the feature model.
 * 
 * @author cpietsch
 *
 */
public class DomainComplianceAnalyzer {

	/**
	 * The feature model as a propositional formula
	 */
	private Formula featureModel;

	/**
	 * Constructor
	 * 
	 * @param featureModel a propositional formula
	 */
	public DomainComplianceAnalyzer(Formula featureModel) {
		this.featureModel = featureModel;
	}

	/**
	 * Checks a {@link ConflictRelation} against the feature model.
	 * A conflict between two delta modules is said to be non-compliant if both
	 * delta modules can be applied together w.r.t. their application conditions
	 * 
	 * @param relation a {@link ConflictRelation} between two delta modules
	 * @param monitor  an {@link IProgressMonitor}
	 * @return a configuration as a collection of feature variables for that both
	 *         delta modules can be applied together
	 */
	public Collection<Variable> analyze(ConflictRelation relation, IProgressMonitor monitor) {

		Formula formula = FormulaUtil.createAnd(EcoreUtil.copy(featureModel),
				FormulaUtil.createAnd(EcoreUtil.copy(relation.getSourceDeltaModule().getApplicationCondition()),
						EcoreUtil.copy(relation.getTargetDeltaModule().getApplicationCondition())));

		return checkDomainCompliance(formula);

	}

	/**
	 * checks an {@link ApplicationConditionConflictRelation} against the feature
	 * model. An {@link ApplicationConditionConflictRelation} is said to be not
	 * domain compliant if: 
	 * - NAC: their exists at least one configuration for that
	 * all conflict inducing delta modules (source delta modules) are applied with
	 * the prevented delta module (target delta module) 
	 * - PAC: at least one conflict
	 * inducing delta module is applied with the target delta module for at least
	 * one configuration
	 * 
	 * @param relation the {@link ApplicationConditionDependencyRelation} to check
	 * @param monitor  an {@link IProgressMonitor} monitor
	 * @return <code>true</code> if domain compliant, <code>false</code> otherwise
	 */
	public Collection<Variable> analyze(ApplicationConditionConflictRelation relation, IProgressMonitor monitor) {

		boolean isNAC = relation.getApplicationConditionConflicts().stream()
				.allMatch(acc -> acc.getKind() == ApplicationConditionKind.NAC);

		Formula formula = EcoreUtil.copy(relation.getTargetDeltaModule().getApplicationCondition());
		if (isNAC) {
			for (DeltaModule src : relation.getSourceDeltaModules()) {
				formula = FormulaUtil.createAnd(formula, EcoreUtil.copy(src.getApplicationCondition()));
			}
		} else {
			for (DeltaModule src : relation.getSourceDeltaModules()) {
				formula = FormulaUtil.createOr(formula, EcoreUtil.copy(src.getApplicationCondition()));
			}
		}

		formula = FormulaUtil.createAnd(EcoreUtil.copy(featureModel), formula);
		return checkDomainCompliance(formula);

	}

	/**
	 * Checks a {@link DependencyRelation} against the feature model. A dependency
	 * between two delta modules is said to be non-compliant if the depending delta
	 * module can be applied without the dependency inducing delta module.
	 * 
	 * @param relation a {@link DependencyRelation} between two delta modules
	 * @param monitor  an {@link IProgressMonitor}
	 * @return a configuration as a collection of feature variables for that the
	 *         depending delta module is applied without the dependency inducing
	 *         delta module
	 */
	public Collection<Variable> analyze(DependencyRelation relation, IProgressMonitor monitor) {
		Formula formula = FormulaUtil.createAnd(EcoreUtil.copy(featureModel),
				FormulaUtil.createNot(FormulaUtil.createImplies(
						EcoreUtil.copy(relation.getSourceDeltaModule().getApplicationCondition()),
						EcoreUtil.copy(relation.getTargetDeltaModule().getApplicationCondition()))));

		return checkDomainCompliance(formula);

	}

	/**
	 * checks an {@link ApplicationConditionDependencyRelation} against the feature
	 * model. An {@link ApplicationConditionDependencyRelation} is said to be
	 * domain compliant if: 
	 * - PAC: whenever the depending delta module (source delta module) is applied, all target delta modules are also applied
	 * the prevented delta module (target delta module) 
	 * - NAC: whenever the depending delta module (source delta module) is applied, at least one target delta module is also applied
	 * 
	 * @param relation the {@link ApplicationConditionDependencyRelation} to check
	 * @param monitor  an {@link IProgressMonitor} monitor
	 * @return <code>true</code> if domain compliant, <code>false</code> otherwise
	 */
	public Collection<Variable> analyze(ApplicationConditionDependencyRelation relation, IProgressMonitor monitor) {

		boolean isNac = relation.getApplicationConditionDependencies().stream().allMatch(d -> d.getKind() == ApplicationConditionKind.NAC);
		
		
		List<Formula> formulas = new ArrayList<>();
		for(DeltaModule tgt : relation.getTargetDeltaModules()) {
			formulas.add(EcoreUtil.copy(tgt.getApplicationCondition()));
		}
		
		Formula formula = isNac?FormulaUtil.createOr(formulas):FormulaUtil.createAnd(formulas);
				
		formula = FormulaUtil.createAnd(EcoreUtil.copy(featureModel),
				FormulaUtil.createNot(FormulaUtil.createImplies(
						EcoreUtil.copy(relation.getSourceDeltaModule().getApplicationCondition()),
						formula)));

		return checkDomainCompliance(formula);
		
	}

	/**
	 * Checks if a {@link DependencyRelation} is void, i.e., if their exists no
	 * configuration for that the dependency is fulfilled.
	 * 
	 * @param relation a {@link DependencyRelation}
	 * @param monitor  a {@link IProgressMonitor}
	 * @return <code>true</code> if the dependency is void, <code>false</code>
	 *         otherwise
	 */
	public boolean isVoid(DependencyRelation relation, IProgressMonitor monitor) {
		Formula formula = FormulaUtil.createAnd(EcoreUtil.copy(featureModel),
				FormulaUtil.createAnd(EcoreUtil.copy(relation.getSourceDeltaModule().getApplicationCondition()),
						EcoreUtil.copy(relation.getTargetDeltaModule().getApplicationCondition())));

		return checkDomainCompliance(formula).isEmpty();
	}

	/**
	 * Checks if a {@link DuplicateRelation} isn't domain compliant, i.e., both
	 * delta modules can be applied together for at least one configuration. Note
	 * that {@link DuplicateRelation} is a special case of a
	 * {@link ConflictRelation} and thus is non-domain compliant if the
	 * {@link ConflictRelation} is non-domain compliant.
	 * 
	 * @param relation a {@link DuplicateRelation}
	 * @param monitor a {@link IProgressMonitor}
	 * @return  a configuration as a collection of feature variables for that both
	 *         delta modules can be applied together
	 */
	public Collection<Variable> analyze(DuplicateRelation relation, IProgressMonitor monitor) {
		Collection<Variable> variables = new HashSet<Variable>();
		for (Variable variable : AnalysisUtils.getConflictRelations(relation).get(0).getUnsatisfiedConfig()) {
			variables.add(EcoreUtil.copy(variable));
		}
		return variables;
	}

	/**
	 * Checks if a {@link TransientEffectRelation} is domain compliant, i.e., if it
	 * really occur for at least one configuration
	 * 
	 * @param relation a {@link TransientEffectRelation}
	 * @param monitor  a {@link IProgressMonitor}
	 * @return a configuration as a collection of feature variables for that both
	 *         delta modules can be applied together
	 */
	public Collection<Variable> analyze(TransientEffectRelation relation, IProgressMonitor monitor) {
		Formula formula = FormulaUtil.createAnd(EcoreUtil.copy(featureModel),
				FormulaUtil.createAnd(EcoreUtil.copy(relation.getSourceDeltaModule().getApplicationCondition()),
						EcoreUtil.copy(relation.getTargetDeltaModule().getApplicationCondition())));

		return checkDomainCompliance(formula);
	}

	/**
	 * Evaluates a given propositional formula and returns a collection of feature
	 * variables for that the formula is satisfiable
	 * 
	 * @param formula a propositional formula
	 * @return a set of feature variables for that the formula is satisfiable, or an
	 *         empty set.
	 */
	private Collection<Variable> checkDomainCompliance(Formula formula) {
		Collection<Variable> variables = new HashSet<Variable>();

		formula.setSatSolverAdapter(featureModel.getSatSolverAdapter());
		SatResult result = formula.isSatisfiable();
		if (result.getStatus().equals(EStatus.SATISFIABLE)) {

			for (String key : result.getAssignments().keySet()) {
				if (Boolean.valueOf(result.getAssignments().get(key))) {
					variables.add(FormulaUtil.createVariable(key));
				}
			}
		}
		return variables;
	}
}
