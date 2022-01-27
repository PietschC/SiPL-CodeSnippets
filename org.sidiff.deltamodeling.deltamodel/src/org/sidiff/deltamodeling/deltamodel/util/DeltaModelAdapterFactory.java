/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.deltamodeling.deltamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage
 * @generated
 */
public class DeltaModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DeltaModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DeltaModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeltaModelSwitch<Adapter> modelSwitch =
		new DeltaModelSwitch<Adapter>() {
			@Override
			public Adapter caseDeltaModuleSet(DeltaModuleSet object) {
				return createDeltaModuleSetAdapter();
			}
			@Override
			public Adapter caseCoreModel(CoreModel object) {
				return createCoreModelAdapter();
			}
			@Override
			public Adapter caseDeltaModule(DeltaModule object) {
				return createDeltaModuleAdapter();
			}
			@Override
			public Adapter caseConstraintGroup(ConstraintGroup object) {
				return createConstraintGroupAdapter();
			}
			@Override
			public Adapter caseRelation(Relation object) {
				return createRelationAdapter();
			}
			@Override
			public Adapter caseApplicationConditionDependencyRelation(ApplicationConditionDependencyRelation object) {
				return createApplicationConditionDependencyRelationAdapter();
			}
			@Override
			public Adapter caseDependencyRelation(DependencyRelation object) {
				return createDependencyRelationAdapter();
			}
			@Override
			public Adapter caseApplicationConditionConflictRelation(ApplicationConditionConflictRelation object) {
				return createApplicationConditionConflictRelationAdapter();
			}
			@Override
			public Adapter caseConflictRelation(ConflictRelation object) {
				return createConflictRelationAdapter();
			}
			@Override
			public Adapter caseDuplicateRelation(DuplicateRelation object) {
				return createDuplicateRelationAdapter();
			}
			@Override
			public Adapter caseTransientEffectRelation(TransientEffectRelation object) {
				return createTransientEffectRelationAdapter();
			}
			@Override
			public Adapter caseApplicationConditionDependency(ApplicationConditionDependency object) {
				return createApplicationConditionDependencyAdapter();
			}
			@Override
			public Adapter caseDependency(Dependency object) {
				return createDependencyAdapter();
			}
			@Override
			public Adapter caseApplicationConditionConflict(ApplicationConditionConflict object) {
				return createApplicationConditionConflictAdapter();
			}
			@Override
			public Adapter caseConflict(Conflict object) {
				return createConflictAdapter();
			}
			@Override
			public Adapter caseDuplicate(Duplicate object) {
				return createDuplicateAdapter();
			}
			@Override
			public Adapter caseTransientEffect(TransientEffect object) {
				return createTransientEffectAdapter();
			}
			@Override
			public Adapter caseDetail(Detail object) {
				return createDetailAdapter();
			}
			@Override
			public Adapter caseDependencyDetail(DependencyDetail object) {
				return createDependencyDetailAdapter();
			}
			@Override
			public Adapter caseConflictDetail(ConflictDetail object) {
				return createConflictDetailAdapter();
			}
			@Override
			public Adapter caseDuplicateDetail(DuplicateDetail object) {
				return createDuplicateDetailAdapter();
			}
			@Override
			public Adapter caseTransientEffectDetail(TransientEffectDetail object) {
				return createTransientEffectDetailAdapter();
			}
			@Override
			public Adapter caseApplicationConditionMatch(ApplicationConditionMatch object) {
				return createApplicationConditionMatchAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet <em>Delta Module Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet
	 * @generated
	 */
	public Adapter createDeltaModuleSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule <em>Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule
	 * @generated
	 */
	public Adapter createDeltaModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation <em>Dependency Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation
	 * @generated
	 */
	public Adapter createDependencyRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation <em>Application Condition Conflict Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation
	 * @generated
	 */
	public Adapter createApplicationConditionConflictRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation <em>Conflict Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation
	 * @generated
	 */
	public Adapter createConflictRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation <em>Duplicate Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateRelation
	 * @generated
	 */
	public Adapter createDuplicateRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation <em>Transient Effect Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectRelation
	 * @generated
	 */
	public Adapter createTransientEffectRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency <em>Application Condition Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency
	 * @generated
	 */
	public Adapter createApplicationConditionDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.Conflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict
	 * @generated
	 */
	public Adapter createConflictAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict <em>Application Condition Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict
	 * @generated
	 */
	public Adapter createApplicationConditionConflictAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.Duplicate <em>Duplicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.Duplicate
	 * @generated
	 */
	public Adapter createDuplicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect <em>Transient Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffect
	 * @generated
	 */
	public Adapter createTransientEffectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.Detail <em>Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.Detail
	 * @generated
	 */
	public Adapter createDetailAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail <em>Conflict Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictDetail
	 * @generated
	 */
	public Adapter createConflictDetailAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail <em>Dependency Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyDetail
	 * @generated
	 */
	public Adapter createDependencyDetailAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.DuplicateDetail <em>Duplicate Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateDetail
	 * @generated
	 */
	public Adapter createDuplicateDetailAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectDetail <em>Transient Effect Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectDetail
	 * @generated
	 */
	public Adapter createTransientEffectDetailAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch <em>Application Condition Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch
	 * @generated
	 */
	public Adapter createApplicationConditionMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.Relation
	 * @generated
	 */
	public Adapter createRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation <em>Application Condition Dependency Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation
	 * @generated
	 */
	public Adapter createApplicationConditionDependencyRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.CoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.CoreModel
	 * @generated
	 */
	public Adapter createCoreModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup <em>Constraint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.deltamodeling.deltamodel.ConstraintGroup
	 * @generated
	 */
	public Adapter createConstraintGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DeltaModelAdapterFactory
