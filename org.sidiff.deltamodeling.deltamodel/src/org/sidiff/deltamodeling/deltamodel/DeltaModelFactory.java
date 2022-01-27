/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage
 * @generated
 */
public interface DeltaModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeltaModelFactory eINSTANCE = org.sidiff.deltamodeling.deltamodel.impl.DeltaModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Delta Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delta Module Set</em>'.
	 * @generated
	 */
	DeltaModuleSet createDeltaModuleSet();

	/**
	 * Returns a new object of class '<em>Delta Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delta Module</em>'.
	 * @generated
	 */
	DeltaModule createDeltaModule();

	/**
	 * Returns a new object of class '<em>Dependency Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Relation</em>'.
	 * @generated
	 */
	DependencyRelation createDependencyRelation();

	/**
	 * Returns a new object of class '<em>Application Condition Conflict Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Condition Conflict Relation</em>'.
	 * @generated
	 */
	ApplicationConditionConflictRelation createApplicationConditionConflictRelation();

	/**
	 * Returns a new object of class '<em>Conflict Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflict Relation</em>'.
	 * @generated
	 */
	ConflictRelation createConflictRelation();

	/**
	 * Returns a new object of class '<em>Duplicate Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Duplicate Relation</em>'.
	 * @generated
	 */
	DuplicateRelation createDuplicateRelation();

	/**
	 * Returns a new object of class '<em>Transient Effect Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transient Effect Relation</em>'.
	 * @generated
	 */
	TransientEffectRelation createTransientEffectRelation();

	/**
	 * Returns a new object of class '<em>Application Condition Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Condition Dependency</em>'.
	 * @generated
	 */
	ApplicationConditionDependency createApplicationConditionDependency();

	/**
	 * Returns a new object of class '<em>Conflict</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflict</em>'.
	 * @generated
	 */
	Conflict createConflict();

	/**
	 * Returns a new object of class '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency</em>'.
	 * @generated
	 */
	Dependency createDependency();

	/**
	 * Returns a new object of class '<em>Application Condition Conflict</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Condition Conflict</em>'.
	 * @generated
	 */
	ApplicationConditionConflict createApplicationConditionConflict();

	/**
	 * Returns a new object of class '<em>Duplicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Duplicate</em>'.
	 * @generated
	 */
	Duplicate createDuplicate();

	/**
	 * Returns a new object of class '<em>Transient Effect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transient Effect</em>'.
	 * @generated
	 */
	TransientEffect createTransientEffect();

	/**
	 * Returns a new object of class '<em>Conflict Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflict Detail</em>'.
	 * @generated
	 */
	ConflictDetail createConflictDetail();

	/**
	 * Returns a new object of class '<em>Dependency Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Detail</em>'.
	 * @generated
	 */
	DependencyDetail createDependencyDetail();

	/**
	 * Returns a new object of class '<em>Duplicate Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Duplicate Detail</em>'.
	 * @generated
	 */
	DuplicateDetail createDuplicateDetail();

	/**
	 * Returns a new object of class '<em>Transient Effect Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transient Effect Detail</em>'.
	 * @generated
	 */
	TransientEffectDetail createTransientEffectDetail();

	/**
	 * Returns a new object of class '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Model</em>'.
	 * @generated
	 */
	CoreModel createCoreModel();

	/**
	 * Returns a new object of class '<em>Constraint Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint Group</em>'.
	 * @generated
	 */
	ConstraintGroup createConstraintGroup();

	/**
	 * Returns a new object of class '<em>Application Condition Dependency Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Condition Dependency Relation</em>'.
	 * @generated
	 */
	ApplicationConditionDependencyRelation createApplicationConditionDependencyRelation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DeltaModelPackage getDeltaModelPackage();

} //DeltaModelFactory
