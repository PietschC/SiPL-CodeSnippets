/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sidiff.deltamodeling.deltamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage
 * @generated
 */
public class DeltaModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DeltaModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaModelSwitch() {
		if (modelPackage == null) {
			modelPackage = DeltaModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DeltaModelPackage.DELTA_MODULE_SET: {
				DeltaModuleSet deltaModuleSet = (DeltaModuleSet)theEObject;
				T result = caseDeltaModuleSet(deltaModuleSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.CORE_MODEL: {
				CoreModel coreModel = (CoreModel)theEObject;
				T result = caseCoreModel(coreModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DELTA_MODULE: {
				DeltaModule deltaModule = (DeltaModule)theEObject;
				T result = caseDeltaModule(deltaModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.CONSTRAINT_GROUP: {
				ConstraintGroup constraintGroup = (ConstraintGroup)theEObject;
				T result = caseConstraintGroup(constraintGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION: {
				ApplicationConditionDependencyRelation applicationConditionDependencyRelation = (ApplicationConditionDependencyRelation)theEObject;
				T result = caseApplicationConditionDependencyRelation(applicationConditionDependencyRelation);
				if (result == null) result = caseRelation(applicationConditionDependencyRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DEPENDENCY_RELATION: {
				DependencyRelation dependencyRelation = (DependencyRelation)theEObject;
				T result = caseDependencyRelation(dependencyRelation);
				if (result == null) result = caseRelation(dependencyRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION: {
				ApplicationConditionConflictRelation applicationConditionConflictRelation = (ApplicationConditionConflictRelation)theEObject;
				T result = caseApplicationConditionConflictRelation(applicationConditionConflictRelation);
				if (result == null) result = caseRelation(applicationConditionConflictRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.CONFLICT_RELATION: {
				ConflictRelation conflictRelation = (ConflictRelation)theEObject;
				T result = caseConflictRelation(conflictRelation);
				if (result == null) result = caseRelation(conflictRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DUPLICATE_RELATION: {
				DuplicateRelation duplicateRelation = (DuplicateRelation)theEObject;
				T result = caseDuplicateRelation(duplicateRelation);
				if (result == null) result = caseRelation(duplicateRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.TRANSIENT_EFFECT_RELATION: {
				TransientEffectRelation transientEffectRelation = (TransientEffectRelation)theEObject;
				T result = caseTransientEffectRelation(transientEffectRelation);
				if (result == null) result = caseRelation(transientEffectRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY: {
				ApplicationConditionDependency applicationConditionDependency = (ApplicationConditionDependency)theEObject;
				T result = caseApplicationConditionDependency(applicationConditionDependency);
				if (result == null) result = caseApplicationConditionMatch(applicationConditionDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DEPENDENCY: {
				Dependency dependency = (Dependency)theEObject;
				T result = caseDependency(dependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT: {
				ApplicationConditionConflict applicationConditionConflict = (ApplicationConditionConflict)theEObject;
				T result = caseApplicationConditionConflict(applicationConditionConflict);
				if (result == null) result = caseApplicationConditionMatch(applicationConditionConflict);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.CONFLICT: {
				Conflict conflict = (Conflict)theEObject;
				T result = caseConflict(conflict);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DUPLICATE: {
				Duplicate duplicate = (Duplicate)theEObject;
				T result = caseDuplicate(duplicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.TRANSIENT_EFFECT: {
				TransientEffect transientEffect = (TransientEffect)theEObject;
				T result = caseTransientEffect(transientEffect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DETAIL: {
				Detail detail = (Detail)theEObject;
				T result = caseDetail(detail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DEPENDENCY_DETAIL: {
				DependencyDetail dependencyDetail = (DependencyDetail)theEObject;
				T result = caseDependencyDetail(dependencyDetail);
				if (result == null) result = caseDetail(dependencyDetail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.CONFLICT_DETAIL: {
				ConflictDetail conflictDetail = (ConflictDetail)theEObject;
				T result = caseConflictDetail(conflictDetail);
				if (result == null) result = caseDetail(conflictDetail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.DUPLICATE_DETAIL: {
				DuplicateDetail duplicateDetail = (DuplicateDetail)theEObject;
				T result = caseDuplicateDetail(duplicateDetail);
				if (result == null) result = caseDetail(duplicateDetail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.TRANSIENT_EFFECT_DETAIL: {
				TransientEffectDetail transientEffectDetail = (TransientEffectDetail)theEObject;
				T result = caseTransientEffectDetail(transientEffectDetail);
				if (result == null) result = caseDetail(transientEffectDetail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH: {
				ApplicationConditionMatch applicationConditionMatch = (ApplicationConditionMatch)theEObject;
				T result = caseApplicationConditionMatch(applicationConditionMatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delta Module Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeltaModuleSet(DeltaModuleSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delta Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delta Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeltaModule(DeltaModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyRelation(DependencyRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Condition Conflict Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Condition Conflict Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationConditionConflictRelation(ApplicationConditionConflictRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conflict Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conflict Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConflictRelation(ConflictRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duplicate Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duplicate Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDuplicateRelation(DuplicateRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transient Effect Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transient Effect Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransientEffectRelation(TransientEffectRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Condition Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Condition Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationConditionDependency(ApplicationConditionDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conflict</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conflict</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConflict(Conflict object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Condition Conflict</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Condition Conflict</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationConditionConflict(ApplicationConditionConflict object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duplicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duplicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDuplicate(Duplicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transient Effect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transient Effect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransientEffect(TransientEffect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Detail</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Detail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDetail(Detail object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conflict Detail</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conflict Detail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConflictDetail(ConflictDetail object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Detail</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Detail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyDetail(DependencyDetail object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duplicate Detail</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duplicate Detail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDuplicateDetail(DuplicateDetail object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transient Effect Detail</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transient Effect Detail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransientEffectDetail(TransientEffectDetail object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Condition Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Condition Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationConditionMatch(ApplicationConditionMatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelation(Relation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Condition Dependency Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Condition Dependency Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationConditionDependencyRelation(ApplicationConditionDependencyRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreModel(CoreModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintGroup(ConstraintGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DeltaModelSwitch
