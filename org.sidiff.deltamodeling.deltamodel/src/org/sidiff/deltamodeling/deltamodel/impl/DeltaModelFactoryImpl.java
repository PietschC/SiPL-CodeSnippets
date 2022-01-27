/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sidiff.deltamodeling.deltamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeltaModelFactoryImpl extends EFactoryImpl implements DeltaModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeltaModelFactory init() {
		try {
			DeltaModelFactory theDeltaModelFactory = (DeltaModelFactory)EPackage.Registry.INSTANCE.getEFactory(DeltaModelPackage.eNS_URI);
			if (theDeltaModelFactory != null) {
				return theDeltaModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DeltaModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DeltaModelPackage.DELTA_MODULE_SET: return createDeltaModuleSet();
			case DeltaModelPackage.CORE_MODEL: return createCoreModel();
			case DeltaModelPackage.DELTA_MODULE: return createDeltaModule();
			case DeltaModelPackage.CONSTRAINT_GROUP: return createConstraintGroup();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION: return createApplicationConditionDependencyRelation();
			case DeltaModelPackage.DEPENDENCY_RELATION: return createDependencyRelation();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION: return createApplicationConditionConflictRelation();
			case DeltaModelPackage.CONFLICT_RELATION: return createConflictRelation();
			case DeltaModelPackage.DUPLICATE_RELATION: return createDuplicateRelation();
			case DeltaModelPackage.TRANSIENT_EFFECT_RELATION: return createTransientEffectRelation();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY: return createApplicationConditionDependency();
			case DeltaModelPackage.DEPENDENCY: return createDependency();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT: return createApplicationConditionConflict();
			case DeltaModelPackage.CONFLICT: return createConflict();
			case DeltaModelPackage.DUPLICATE: return createDuplicate();
			case DeltaModelPackage.TRANSIENT_EFFECT: return createTransientEffect();
			case DeltaModelPackage.DEPENDENCY_DETAIL: return createDependencyDetail();
			case DeltaModelPackage.CONFLICT_DETAIL: return createConflictDetail();
			case DeltaModelPackage.DUPLICATE_DETAIL: return createDuplicateDetail();
			case DeltaModelPackage.TRANSIENT_EFFECT_DETAIL: return createTransientEffectDetail();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DeltaModelPackage.DEPENDENCY_KIND:
				return createDependencyKindFromString(eDataType, initialValue);
			case DeltaModelPackage.CONFLICT_KIND:
				return createConflictKindFromString(eDataType, initialValue);
			case DeltaModelPackage.DUPLICATE_KIND:
				return createDuplicateKindFromString(eDataType, initialValue);
			case DeltaModelPackage.TRANSIENT_EFFECT_KIND:
				return createTransientEffectKindFromString(eDataType, initialValue);
			case DeltaModelPackage.APPLICATION_CONDITION_KIND:
				return createApplicationConditionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DeltaModelPackage.DEPENDENCY_KIND:
				return convertDependencyKindToString(eDataType, instanceValue);
			case DeltaModelPackage.CONFLICT_KIND:
				return convertConflictKindToString(eDataType, instanceValue);
			case DeltaModelPackage.DUPLICATE_KIND:
				return convertDuplicateKindToString(eDataType, instanceValue);
			case DeltaModelPackage.TRANSIENT_EFFECT_KIND:
				return convertTransientEffectKindToString(eDataType, instanceValue);
			case DeltaModelPackage.APPLICATION_CONDITION_KIND:
				return convertApplicationConditionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModuleSet createDeltaModuleSet() {
		DeltaModuleSetImpl deltaModuleSet = new DeltaModuleSetImpl();
		return deltaModuleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModule createDeltaModule() {
		DeltaModuleImpl deltaModule = new DeltaModuleImpl();
		return deltaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DependencyRelation createDependencyRelation() {
		DependencyRelationImpl dependencyRelation = new DependencyRelationImpl();
		return dependencyRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationConditionConflictRelation createApplicationConditionConflictRelation() {
		ApplicationConditionConflictRelationImpl applicationConditionConflictRelation = new ApplicationConditionConflictRelationImpl();
		return applicationConditionConflictRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictRelation createConflictRelation() {
		ConflictRelationImpl conflictRelation = new ConflictRelationImpl();
		return conflictRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DuplicateRelation createDuplicateRelation() {
		DuplicateRelationImpl duplicateRelation = new DuplicateRelationImpl();
		return duplicateRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransientEffectRelation createTransientEffectRelation() {
		TransientEffectRelationImpl transientEffectRelation = new TransientEffectRelationImpl();
		return transientEffectRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationConditionDependency createApplicationConditionDependency() {
		ApplicationConditionDependencyImpl applicationConditionDependency = new ApplicationConditionDependencyImpl();
		return applicationConditionDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Conflict createConflict() {
		ConflictImpl conflict = new ConflictImpl();
		return conflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Dependency createDependency() {
		DependencyImpl dependency = new DependencyImpl();
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationConditionConflict createApplicationConditionConflict() {
		ApplicationConditionConflictImpl applicationConditionConflict = new ApplicationConditionConflictImpl();
		return applicationConditionConflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duplicate createDuplicate() {
		DuplicateImpl duplicate = new DuplicateImpl();
		return duplicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransientEffect createTransientEffect() {
		TransientEffectImpl transientEffect = new TransientEffectImpl();
		return transientEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictDetail createConflictDetail() {
		ConflictDetailImpl conflictDetail = new ConflictDetailImpl();
		return conflictDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DependencyDetail createDependencyDetail() {
		DependencyDetailImpl dependencyDetail = new DependencyDetailImpl();
		return dependencyDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DuplicateDetail createDuplicateDetail() {
		DuplicateDetailImpl duplicateDetail = new DuplicateDetailImpl();
		return duplicateDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransientEffectDetail createTransientEffectDetail() {
		TransientEffectDetailImpl transientEffectDetail = new TransientEffectDetailImpl();
		return transientEffectDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CoreModel createCoreModel() {
		CoreModelImpl coreModel = new CoreModelImpl();
		return coreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintGroup createConstraintGroup() {
		ConstraintGroupImpl constraintGroup = new ConstraintGroupImpl();
		return constraintGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationConditionDependencyRelation createApplicationConditionDependencyRelation() {
		ApplicationConditionDependencyRelationImpl applicationConditionDependencyRelation = new ApplicationConditionDependencyRelationImpl();
		return applicationConditionDependencyRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictKind createConflictKindFromString(EDataType eDataType, String initialValue) {
		ConflictKind result = ConflictKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConflictKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyKind createDependencyKindFromString(EDataType eDataType, String initialValue) {
		DependencyKind result = DependencyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependencyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DuplicateKind createDuplicateKindFromString(EDataType eDataType, String initialValue) {
		DuplicateKind result = DuplicateKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDuplicateKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransientEffectKind createTransientEffectKindFromString(EDataType eDataType, String initialValue) {
		TransientEffectKind result = TransientEffectKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransientEffectKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationConditionKind createApplicationConditionKindFromString(EDataType eDataType, String initialValue) {
		ApplicationConditionKind result = ApplicationConditionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertApplicationConditionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModelPackage getDeltaModelPackage() {
		return (DeltaModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DeltaModelPackage getPackage() {
		return DeltaModelPackage.eINSTANCE;
	}

} //DeltaModelFactoryImpl
