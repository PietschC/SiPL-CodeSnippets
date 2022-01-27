/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.deltamodeling.deltamodel.*;

import org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine;
import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.Variable;
import org.sidiff.formula.VariationType;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.SatResult.EStatus;
import org.sidiff.formula.util.FormulaUtil;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage
 * @generated
 */
public class DeltaModelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DeltaModelValidator INSTANCE = new DeltaModelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.sidiff.deltamodeling.deltamodel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * @see #validateDeltaModuleSet_NonVoidFeatureModel(DeltaModuleSet, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int NON_VOID_FEATURE_MODEL = 1;
	
	/**
	 * @see #validateDeltaModuleSet_NonDeadFeature(DeltaModuleSet, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int NON_DEAD_FEATURE = 2;
	
	/**
	 * @see #validateDeltaModuleSet_NonFalseOptionalFeature(DeltaModuleSet, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int NON_FALSE_OPTIONAL_FEATURE = 3;
	
	/**
	 * @see #validateDeltaModuleSet_NonEmptyFeature(DeltaModuleSet, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int NONE_EMPTY_FEATURE = 4;
	
	/**
	 * @see #validateDeltaModuleSet_UniqueDeltaModuleNames(DeltaModuleSet, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int UNIQUE_DELTA_MODULE_NAMES = 5;
	
	/**
	 * @see #validateDeltaModuleSet_NonUnresolvedDependencies(DeltaModuleSet, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int NON_UNRESOLVED_DEPENDENCIES = 6;
	
	/**
	 * @see #validateDeltaModuleSet_NonUnresolvedConflicts(DeltaModuleSet, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int NON_UNRESOLVED_CONFLICTS = 7;
	
	/**
	 * @see #validateDeltaModule_ValidApplicationCondition(DeltaModule, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int VALID_APPLICATION_CONDITION = 8;
	
	/**
	 * @see #validateCoreModel_ValidConfiguration(CoreModel, DiagnosticChain, Map)
	 * @generated NOT
	 */
	public static final int VALID_CONFIGURATION = 9;
	
	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaModelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return DeltaModelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case DeltaModelPackage.DELTA_MODULE_SET:
				return validateDeltaModuleSet((DeltaModuleSet)value, diagnostics, context);
			case DeltaModelPackage.CORE_MODEL:
				return validateCoreModel((CoreModel)value, diagnostics, context);
			case DeltaModelPackage.DELTA_MODULE:
				return validateDeltaModule((DeltaModule)value, diagnostics, context);
			case DeltaModelPackage.CONSTRAINT_GROUP:
				return validateConstraintGroup((ConstraintGroup)value, diagnostics, context);
			case DeltaModelPackage.RELATION:
				return validateRelation((Relation)value, diagnostics, context);
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION:
				return validateApplicationConditionDependencyRelation((ApplicationConditionDependencyRelation)value, diagnostics, context);
			case DeltaModelPackage.DEPENDENCY_RELATION:
				return validateDependencyRelation((DependencyRelation)value, diagnostics, context);
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION:
				return validateApplicationConditionConflictRelation((ApplicationConditionConflictRelation)value, diagnostics, context);
			case DeltaModelPackage.CONFLICT_RELATION:
				return validateConflictRelation((ConflictRelation)value, diagnostics, context);
			case DeltaModelPackage.DUPLICATE_RELATION:
				return validateDuplicateRelation((DuplicateRelation)value, diagnostics, context);
			case DeltaModelPackage.TRANSIENT_EFFECT_RELATION:
				return validateTransientEffectRelation((TransientEffectRelation)value, diagnostics, context);
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY:
				return validateApplicationConditionDependency((ApplicationConditionDependency)value, diagnostics, context);
			case DeltaModelPackage.DEPENDENCY:
				return validateDependency((Dependency)value, diagnostics, context);
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT:
				return validateApplicationConditionConflict((ApplicationConditionConflict)value, diagnostics, context);
			case DeltaModelPackage.CONFLICT:
				return validateConflict((Conflict)value, diagnostics, context);
			case DeltaModelPackage.DUPLICATE:
				return validateDuplicate((Duplicate)value, diagnostics, context);
			case DeltaModelPackage.TRANSIENT_EFFECT:
				return validateTransientEffect((TransientEffect)value, diagnostics, context);
			case DeltaModelPackage.DETAIL:
				return validateDetail((Detail)value, diagnostics, context);
			case DeltaModelPackage.DEPENDENCY_DETAIL:
				return validateDependencyDetail((DependencyDetail)value, diagnostics, context);
			case DeltaModelPackage.CONFLICT_DETAIL:
				return validateConflictDetail((ConflictDetail)value, diagnostics, context);
			case DeltaModelPackage.DUPLICATE_DETAIL:
				return validateDuplicateDetail((DuplicateDetail)value, diagnostics, context);
			case DeltaModelPackage.TRANSIENT_EFFECT_DETAIL:
				return validateTransientEffectDetail((TransientEffectDetail)value, diagnostics, context);
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH:
				return validateApplicationConditionMatch((ApplicationConditionMatch)value, diagnostics, context);
			case DeltaModelPackage.DEPENDENCY_KIND:
				return validateDependencyKind((DependencyKind)value, diagnostics, context);
			case DeltaModelPackage.CONFLICT_KIND:
				return validateConflictKind((ConflictKind)value, diagnostics, context);
			case DeltaModelPackage.DUPLICATE_KIND:
				return validateDuplicateKind((DuplicateKind)value, diagnostics, context);
			case DeltaModelPackage.TRANSIENT_EFFECT_KIND:
				return validateTransientEffectKind((TransientEffectKind)value, diagnostics, context);
			case DeltaModelPackage.APPLICATION_CONDITION_KIND:
				return validateApplicationConditionKind((ApplicationConditionKind)value, diagnostics, context);
			case DeltaModelPackage.IRELATION_ANALYSIS_ENGINE:
				return validateIRelationAnalysisEngine((IRelationAnalysisEngine)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeltaModuleSet(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(deltaModuleSet, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModuleSet_NonVoidFeatureModel(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModuleSet_NonDeadFeature(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModuleSet_NonFalseOptionalFeature(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModuleSet_NonEmptyFeature(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModuleSet_UniqueDeltaModuleNames(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModuleSet_NonUnresolvedDependencies(deltaModuleSet, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModuleSet_NonUnresolvedConflicts(deltaModuleSet, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NonVoidFeatureModel constraint of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * The constraint is violated if no valid configuration exists for the referenced feature model.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModuleSet_NonVoidFeatureModel(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (deltaModuleSet.getFeatureModel().isSatisfiable().getStatus() != EStatus.SATISFIABLE) {
			if (diagnostics != null) {
				// message substitutions
				Object[] messageSubstitutions = {"NonVoidFeatureModel", getObjectLabel(deltaModuleSet, context)};
				// data
				Object[] data = {deltaModuleSet};
				
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 NON_VOID_FEATURE_MODEL,
						 "_UI_NonVoidFeatureModel_diagnostic",
						 messageSubstitutions,
						 data,
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the NonDeadFeature constraint of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * The constraint is violated if a feature cannot be selected for any valid configuration.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModuleSet_NonDeadFeature(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Map<String, Set<Variable>> variables = new HashMap<String, Set<Variable>>();
		
		for(Variable variable : deltaModuleSet.getFeatureModel().getVariables()) {
			if(!variables.containsKey(variable.getName())) {
				variables.put(variable.getName(), new HashSet<Variable>());
			}
			variables.get(variable.getName()).add(variable);
		}
		boolean result = true;
		for(String key : variables.keySet()) {
			Formula formula = FormulaUtil.createAnd(EcoreUtil.copy(deltaModuleSet.getFeatureModel()), FormulaUtil.createVariable(key, variables.get(key).iterator().next().getType()));
			formula.setSatSolverAdapter(deltaModuleSet.getFeatureModel().getSatSolverAdapter());
			if (formula.isSatisfiable().getStatus() != EStatus.SATISFIABLE) {
				if (diagnostics != null) {
					// message substitutions
					Object[] messageSubstitutions = {"NonDeadFeature", getObjectLabel(deltaModuleSet, context), key};
					// data
					Set<Variable> data_variables = variables.get(key);
					Object[] data = new Object[2 + data_variables.size()];
					data[0] = deltaModuleSet;
					data[1] = deltaModuleSet.getFeatureModel();
					int i = 0;
					for(Variable v : data_variables) {
						data[i+2] = v;
						i++;
					}
					
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 NON_DEAD_FEATURE,
							 "_UI_NonDeadFeature_diagnostic",
							 messageSubstitutions,
							 data,
							 context));
				}
				result = false;
			}
		}
		return result;
	}

	/**
	 * Validates the NonFalseOptionalFeature constraint of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModuleSet_NonFalseOptionalFeature(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Map<String, Set<Variable>> variables = new HashMap<String, Set<Variable>>();
		
		for(Variable variable : deltaModuleSet.getFeatureModel().getVariables()) {
			if(variable.getType() == VariationType.OPTIONAL) {
				if(!variables.containsKey(variable.getName())) {
					variables.put(variable.getName(), new HashSet<Variable>());
				}
				variables.get(variable.getName()).add(variable);
			}
		}
		boolean result = true;
		for(String key : variables.keySet()) {
			Formula formula = FormulaUtil.createAnd(EcoreUtil.copy(deltaModuleSet.getFeatureModel()), FormulaUtil.createNot(FormulaUtil.createVariable(key, variables.get(key).iterator().next().getType())));
			formula.setSatSolverAdapter(deltaModuleSet.getFeatureModel().getSatSolverAdapter());
			if (formula.isSatisfiable().getStatus() != EStatus.SATISFIABLE) {
				if (diagnostics != null) {
					// message substitutions
					Object[] messageSubstitutions = {"NonFalseOptionalFeature", getObjectLabel(deltaModuleSet, context), key};
					// data
					Set<Variable> data_variables = variables.get(key);
					Object[] data = new Object[2 + data_variables.size()];
					data[0] = deltaModuleSet;
					data[1] = deltaModuleSet.getFeatureModel();
					int i = 0;
					for(Variable v : data_variables) {
						data[i+2] = v;
						i++;
					}
					
					diagnostics.add
						(createDiagnostic
							(Diagnostic.WARNING,
							 DIAGNOSTIC_SOURCE,
							 NON_FALSE_OPTIONAL_FEATURE,
							 "_UI_NonFalseOptionalFeature_diagnostic",
							 messageSubstitutions,
							 data,
							 context));
				}
				result = false;
			}
		}
		return result;
	}

	/**
	 * Validates the NonEmptyFeature constraint of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * The constraint is violated if the feature doesn't have any effect on the application condition of any delta module. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModuleSet_NonEmptyFeature(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		Map<String, Set<Variable>> variables = new HashMap<String, Set<Variable>>();
		
		for(Variable v : deltaModuleSet.getFeatureModel().getVariables()) {
			variables.putIfAbsent(v.getName(), new HashSet<Variable>());
			variables.get(v.getName()).add(v);
		}
		
		Set<String> features = variables.keySet();
		Set<String> applicationConditions = deltaModuleSet.getDeltaModules().stream().flatMap(d -> d.getApplicationCondition().getVariables().stream().map(v -> v.getName()).collect(Collectors.toSet()).stream()).collect(Collectors.toSet());
		applicationConditions.addAll(deltaModuleSet.getCoreModel().getConfig().stream().map(v -> v.getName()).collect(Collectors.toSet()));
		features.removeAll(applicationConditions);
		
		boolean result = true;
		if (!features.isEmpty()) {
			for(String feature : features) {
			if (diagnostics != null) {
				
				// message substitutions
				Object[] messageSubstitutions = {"NonEmptyFeature", getObjectLabel(deltaModuleSet, context), feature};
				// data
				Object[] data = new Object[1 + variables.get(feature).size()];
				data[0] = deltaModuleSet;
				int i = 1;
				for(Variable variable : variables.get(feature)) {
					data[i] = variable;
					i++;
				}
				
				diagnostics.add
					(createDiagnostic
						(Diagnostic.INFO,
						 DIAGNOSTIC_SOURCE,
						 NONE_EMPTY_FEATURE,
						 "_UI_NonEmptyFeature_diagnostic",
						 messageSubstitutions,
						 data,
						 context));
			}
				result =  false;
			}
		}
		return result;
	}

	/**
	 * Validates the UniqueDeltaModuleNames constraint of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * The constraint is violated if their exists at least two delta modules with the same name.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModuleSet_UniqueDeltaModuleNames(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Map<String, Set<DeltaModule>> names = new HashMap<String, Set<DeltaModule>>();
		for (DeltaModule deltaModule : deltaModuleSet.getDeltaModules()) {
			if (!names.containsKey(deltaModule.getName())) {
				names.put(deltaModule.getName(), new HashSet<DeltaModule>());
			}
			names.get(deltaModule.getName()).add(deltaModule);
		}
		boolean result = true;
		for(Entry<String, Set<DeltaModule>> entry : names.entrySet()) {
			if (entry.getValue().size() > 1) {
				if (diagnostics != null) {
					// message substitutions
					Object[] messageSubstitutions = {"UniqueDeltaModuleNames", getObjectLabel(deltaModuleSet, context), entry.getKey()};
					// data
					Object[] data = new Object[1 + entry.getValue().size()];
					data[0] = deltaModuleSet;
					int i = 0;
					for(DeltaModule deltaModule : entry.getValue()) {
						data[i+1] = deltaModule;
						i++;
					}
					
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 UNIQUE_DELTA_MODULE_NAMES,
							 "_UI_UniqueDeltaModuleNames_diagnostic",
							 messageSubstitutions,
							 data,
							 context));
				}
				result = false;
			}
		}
		return result;
	}

	/**
	 * Validates the NonUnresolvedDependencies constraint of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModuleSet_NonUnresolvedDependencies(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Map<DependencyRelation, Set<Dependency>> unresolvedDependencies = new HashMap<DependencyRelation, Set<Dependency>>();
		for(DependencyRelation relation : deltaModuleSet.getDependencyRelations()) {
			if(!relation.isResolved()) {
				Set<Dependency> dependencies = new HashSet<Dependency>();
				for(Dependency dependency : relation.getDependencies()) {
					if(!dependency.isResolved()) {
						dependencies.add(dependency);
					}
				}
				unresolvedDependencies.put(relation, dependencies);
			}
		}
		
		boolean result = true;
		
		if (!unresolvedDependencies.isEmpty()) {
			for(DependencyRelation relation : unresolvedDependencies.keySet()) {
				if (diagnostics != null) {
					
					// message substitutions
					Object[] messageSubstitutions = {"NonUnresolvedDependencies", getObjectLabel(deltaModuleSet, context), relation.getSourceDeltaModule().getName() + " -> " + relation.getTargetDeltaModule().getName() + " (" + relation.getUnsatisfiedConfig()+ ")"};
					// data
					Object[] data = new Object[2 + unresolvedDependencies.get(relation).size()];
					data[0] = deltaModuleSet;
					data[1] = relation;
					int i=2;
					for(Dependency dependency : unresolvedDependencies.get(relation)) {
						data[i] = dependency;
						i++;
					}
					
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 NON_UNRESOLVED_DEPENDENCIES,
							 "_UI_NonUnresolvedDependencies_diagnostic",
							 messageSubstitutions,
							 data,
							 context));
				}
			result = false;
			}
			
		}
		return result;
	}

	/**
	 * Validates the NonUnresolvedConflicts constraint of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModuleSet_NonUnresolvedConflicts(DeltaModuleSet deltaModuleSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Map<ConflictRelation, Set<Conflict>> unresolvedConflicts = new HashMap<ConflictRelation, Set<Conflict>>();
		for(ConflictRelation relation : deltaModuleSet.getConflictRelations()) {
			if(!relation.isResolved()) {
				Set<Conflict> conflicts = new HashSet<Conflict>();
				for(Conflict conflict : relation.getConflicts()) {
					if(!conflict.isResolved()) {
						conflicts.add(conflict);
					}
				}
				unresolvedConflicts.put(relation, conflicts);
			}
		}
		
		boolean result = true;
		
		if (!unresolvedConflicts.isEmpty()) {
			for(ConflictRelation relation : unresolvedConflicts.keySet()) {
				if (diagnostics != null) {
					
					// message substitutions
					Object[] messageSubstitutions = {"NonUnresolvedConflicts", getObjectLabel(deltaModuleSet, context), relation.getSourceDeltaModule().getName() + " -> " + relation.getTargetDeltaModule().getName() + " (" + relation.getUnsatisfiedConfig()+ ")"};
					// data
					Object[] data = new Object[2 + unresolvedConflicts.get(relation).size()];
					data[0] = deltaModuleSet;
					data[1] = relation;
					int i=2;
					for(Conflict conflict : unresolvedConflicts.get(relation)) {
						data[i] = conflict;
						i++;
					}
					
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 NON_UNRESOLVED_CONFLICTS,
							 "_UI_NonUnresolvedConflicts_diagnostic",
							 messageSubstitutions,
							 data,
							 context));
				}
			result = false;
			}
			
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeltaModule(DeltaModule deltaModule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(deltaModule, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(deltaModule, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeltaModule_ValidApplicationCondition(deltaModule, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidApplicationCondition constraint of '<em>Delta Module</em>'.
	 * <!-- begin-user-doc -->
	 * This constraint is violated if the application condition contains at least one feature that isn't specified in the corresponding feature model or the application condition isn't satisfiable for the corresponding feature model.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateDeltaModule_ValidApplicationCondition(DeltaModule deltaModule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Formula featureModel = ((DeltaModuleSet) deltaModule.eContainer()).getFeatureModel();
		
		boolean result = true;
		for (Variable variable : deltaModule.getApplicationCondition().getVariables()) {
			if (!variable.getName().equals("true") && featureModel.getVariables().stream().noneMatch(v -> v.getName().equals(variable.getName()))) {
				if(diagnostics != null) {
					// message substitutions
					Object[] messageSubstitutions = {"ValidApplicationCondition", getObjectLabel(deltaModule, context), variable.getName()};
					// data
					Object[] data = {deltaModule, variable};
					
					diagnostics.add(createDiagnostic(Diagnostic.ERROR, 
							DIAGNOSTIC_SOURCE, 
							VALID_APPLICATION_CONDITION,
							"_UI_ValidApplicationCondition_Variable_diagnostic", 
							messageSubstitutions, 
							data, 
							context));
				}
				result = false;
			}
		}
		
		if(result) {
			Formula formula = FormulaUtil.createAnd(EcoreUtil.copy(featureModel),
					EcoreUtil.copy(deltaModule.getApplicationCondition()));
			formula.setSatSolverAdapter(featureModel.getSatSolverAdapter());
			if(formula.isSatisfiable().getStatus() != EStatus.SATISFIABLE) {
				if (diagnostics != null) {
					// message substitutions
					Object[] messageSubstitutions = {"ValidApplicationCondition", getObjectLabel(deltaModule, context), deltaModule.getApplicationCondition().toString()};
					// data
					Object[] data = {deltaModule, deltaModule.getApplicationCondition()};
					
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 VALID_APPLICATION_CONDITION,
							 "_UI_ValidApplicationCondition_diagnostic",
							 messageSubstitutions,
							 data,
							 context));
				}
				result= false;
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyRelation(DependencyRelation dependencyRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyRelation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationConditionConflictRelation(ApplicationConditionConflictRelation applicationConditionConflictRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(applicationConditionConflictRelation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConflictRelation(ConflictRelation conflictRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conflictRelation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDuplicateRelation(DuplicateRelation duplicateRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(duplicateRelation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransientEffectRelation(TransientEffectRelation transientEffectRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transientEffectRelation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationConditionDependency(ApplicationConditionDependency applicationConditionDependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(applicationConditionDependency, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConflict(Conflict conflict, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conflict, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency(Dependency dependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependency, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationConditionConflict(ApplicationConditionConflict applicationConditionConflict, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(applicationConditionConflict, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDuplicate(Duplicate duplicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(duplicate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransientEffect(TransientEffect transientEffect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transientEffect, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetail(Detail detail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(detail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConflictDetail(ConflictDetail conflictDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conflictDetail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyDetail(DependencyDetail dependencyDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyDetail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDuplicateDetail(DuplicateDetail duplicateDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(duplicateDetail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransientEffectDetail(TransientEffectDetail transientEffectDetail, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transientEffectDetail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationConditionMatch(ApplicationConditionMatch applicationConditionMatch, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(applicationConditionMatch, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationConditionDependencyRelation(ApplicationConditionDependencyRelation applicationConditionDependencyRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(applicationConditionDependencyRelation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoreModel(CoreModel coreModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(coreModel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateCoreModel_ValidConfiguration(coreModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidConfiguration constraint of '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * This constraint is violated if the core model isn't configured, the configuration contains at least one feature that isn't specified in the corresponding feature model or the configuration isn't satisfiable for the corresponding feature model.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateCoreModel_ValidConfiguration(CoreModel coreModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		DeltaModuleSet deltaModuleSet = (DeltaModuleSet) coreModel.eContainer();
		Formula featureModel = deltaModuleSet.getFeatureModel();
		
		boolean result = true;
		if(coreModel.getConfig().isEmpty()) {
			// message substitutions
			Object[] messageSubstitutions = {"ValidConfiguration", getObjectLabel(coreModel, context)};
			// data
			Object[] data = {coreModel};
			
			diagnostics.add(createDiagnostic(Diagnostic.WARNING, 
					DIAGNOSTIC_SOURCE, 
					VALID_CONFIGURATION,
					"_UI_ValidConfiguration_Empty_diagnostic", 
					messageSubstitutions, 
					data, 
					context));
		
			result = false;
		}else {
			for (Variable variable : coreModel.getConfig()) {
				if (featureModel.getVariables().stream().noneMatch(v -> v.getName().equals(variable.getName()))) {
					if(diagnostics != null) {
						// message substitutions
						Object[] messageSubstitutions = {"ValidConfiguration", getObjectLabel(coreModel, context), variable.getName()};
						// data
						Object[] data = {coreModel, variable};
						
						diagnostics.add(createDiagnostic(Diagnostic.ERROR, 
								DIAGNOSTIC_SOURCE, 
								VALID_CONFIGURATION,
								"_UI_ValidConfiguration_Variable_diagnostic", 
								messageSubstitutions, 
								data, 
								context));
					}
					result = false;
				}
			}
		}
		if (result) {
			
			Formula formula = EcoreUtil.copy(featureModel);
			for(Variable v : coreModel.getConfig()) {
				formula = FormulaUtil.createAnd(formula, EcoreUtil.copy(v));
			}
			formula.setSatSolverAdapter(featureModel.getSatSolverAdapter());
			
			if(formula.isSatisfiable().getStatus() == SatResult.EStatus.SATISFIABLE) {
			
			Configuration configuration = FormulaFactory.eINSTANCE.createConfiguration();
			configuration.init(featureModel);
			for(Variable variable : coreModel.getConfig()) {
				Set<Variable> variables = featureModel.getVariables().stream().filter(v -> v.getName().equals(variable.getName()))
						.collect(Collectors.toSet());
				variables.stream().forEach(v -> configuration.getVariableAssignments().put(v, true));
			}
			
			if(!featureModel.eval(configuration)) {
					// message substitutions
					Object[] messageSubstitutions = { "ValidConfiguration", getObjectLabel(coreModel, context) };
					// data
					Object[] data = { coreModel };

					if (diagnostics != null) {
						diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, VALID_CONFIGURATION,
								"_UI_ValidConfiguration_CoreModel_diagnostic", messageSubstitutions, data, context));
					}
				}
				result = false;
			}
			else {
				// message substitutions
				Object[] messageSubstitutions = { "ValidConfiguration", getObjectLabel(coreModel, context) };
				// data
				Object[] data = { coreModel };

				if (diagnostics != null) {
					diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, VALID_CONFIGURATION,
							"_UI_ValidConfiguration_CoreModel_Unsat_diagnostic", messageSubstitutions, data, context));
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraintGroup(ConstraintGroup constraintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constraintGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConflictKind(ConflictKind conflictKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyKind(DependencyKind dependencyKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDuplicateKind(DuplicateKind duplicateKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransientEffectKind(TransientEffectKind transientEffectKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationConditionKind(ApplicationConditionKind applicationConditionKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIRelationAnalysisEngine(IRelationAnalysisEngine iRelationAnalysisEngine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DeltaModelPlugin.INSTANCE;
	}

} //DeltaModelValidator
