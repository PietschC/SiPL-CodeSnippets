/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.emf.henshin.model.HenshinPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModelFactory;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.util.DeltaModelValidator;
import org.sidiff.difference.asymmetric.AsymmetricPackage;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.rulebase.RulebasePackage;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.matching.model.MatchingModelPackage;
import org.sidiff.superimposition.SuperimpositionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeltaModelPackageImpl extends EPackageImpl implements DeltaModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "deltamodel.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deltaModuleSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deltaModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationConditionConflictRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass duplicateRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transientEffectRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationConditionDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationConditionConflictEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass duplicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transientEffectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detailEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictDetailEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyDetailEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass duplicateDetailEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transientEffectDetailEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationConditionMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationConditionDependencyRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum conflictKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dependencyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum duplicateKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transientEffectKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum applicationConditionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iRelationAnalysisEngineEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DeltaModelPackageImpl() {
		super(eNS_URI, DeltaModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DeltaModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static DeltaModelPackage init() {
		if (isInited) return (DeltaModelPackage)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDeltaModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DeltaModelPackageImpl theDeltaModelPackage = registeredDeltaModelPackage instanceof DeltaModelPackageImpl ? (DeltaModelPackageImpl)registeredDeltaModelPackage : new DeltaModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		AsymmetricPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		EntitiesPackage.eINSTANCE.eClass();
		FormulaPackage.eINSTANCE.eClass();
		MatchingModelPackage.eINSTANCE.eClass();
		SuperimpositionModelPackage.eINSTANCE.eClass();
		SymmetricPackage.eINSTANCE.eClass();
		RulebasePackage.eINSTANCE.eClass();
		HenshinPackage.eINSTANCE.eClass();

		// Load packages
		theDeltaModelPackage.loadPackage();

		// Fix loaded packages
		theDeltaModelPackage.fixPackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDeltaModelPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return DeltaModelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDeltaModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DeltaModelPackage.eNS_URI, theDeltaModelPackage);
		return theDeltaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeltaModuleSet() {
		if (deltaModuleSetEClass == null) {
			deltaModuleSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(0);
		}
		return deltaModuleSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDeltaModuleSet_Name() {
        return (EAttribute)getDeltaModuleSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_FeatureModel() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_SuperimposedModel() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_DeltaModules() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_ConflictRelations() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_DependencyRelations() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_ApplicationConditionConflictRelations() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_DuplicateRelations() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_TransientEffectRelation() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_AllRelations() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_ApplicationConditionDependencyRelations() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_CoreModel() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModuleSet_ApplicationOrderConstraints() {
        return (EReference)getDeltaModuleSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDeltaModuleSet_AnalysisEngine() {
        return (EAttribute)getDeltaModuleSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModuleSet__GetDeltaModule__String() {
        return getDeltaModuleSet().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModuleSet__GetDeltaModules__Configuration() {
        return getDeltaModuleSet().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeltaModule() {
		if (deltaModuleEClass == null) {
			deltaModuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(2);
		}
		return deltaModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDeltaModule_Name() {
        return (EAttribute)getDeltaModule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_ApplicationCondition() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_OutgoingConflictRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_IncomingConflictRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_OutgoingDependencyRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_IncomingApplicationConditionConflictRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_OutgoingApplicationConditionConflictRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_IncomingDependencyRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_DuplicateRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_OutgoingTransientEffectRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_IncomingTransientEffectRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_After() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_Before() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_Delta() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_IncomingApplicationConditionDependencyRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeltaModule_OutgoingApplicationConditionDependencyRelations() {
        return (EReference)getDeltaModule().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetAllPredecessors() {
        return getDeltaModule().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetAllSuccessors() {
        return getDeltaModule().getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetOutgoingConflicts__OperationInvocation() {
        return getDeltaModule().getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetIncomingConflicts__OperationInvocation() {
        return getDeltaModule().getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetOutgoingDependencies__OperationInvocation() {
        return getDeltaModule().getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetIncomingDependencies__OperationInvocation() {
        return getDeltaModule().getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetDuplicates__OperationInvocation() {
        return getDeltaModule().getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetOutgoingTransientEffects__OperationInvocation() {
        return getDeltaModule().getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetIncomingApplicationConditionDependencies__OperationInvocation_ApplicationConditionKind() {
        return getDeltaModule().getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetOutgoingApplicationConditionDependencies__OperationInvocation_ApplicationConditionKind() {
        return getDeltaModule().getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetIncomingApplicationConditionConflicts__OperationInvocation_ApplicationConditionKind() {
        return getDeltaModule().getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetOutgoingApplicationConditionConflicts__OperationInvocation_ApplicationConditionKind() {
        return getDeltaModule().getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDeltaModule__GetIncomingTransientEffects__OperationInvocation() {
        return getDeltaModule().getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependencyRelation() {
		if (dependencyRelationEClass == null) {
			dependencyRelationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(6);
		}
		return dependencyRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyRelation_Dependencies() {
        return (EReference)getDependencyRelation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependencyRelation_Void() {
        return (EAttribute)getDependencyRelation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplicationConditionConflictRelation() {
		if (applicationConditionConflictRelationEClass == null) {
			applicationConditionConflictRelationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(7);
		}
		return applicationConditionConflictRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionConflictRelation_SourceDeltaModules() {
        return (EReference)getApplicationConditionConflictRelation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionConflictRelation_TargetDeltaModule() {
        return (EReference)getApplicationConditionConflictRelation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionConflictRelation_ApplicationConditionConflicts() {
        return (EReference)getApplicationConditionConflictRelation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationConditionConflictRelation_Resolved() {
        return (EAttribute)getApplicationConditionConflictRelation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyRelation_SourceDeltaModule() {
        return (EReference)getDependencyRelation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyRelation_TargetDeltaModule() {
        return (EReference)getDependencyRelation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependencyRelation_Resolved() {
        return (EAttribute)getDependencyRelation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConflictRelation() {
		if (conflictRelationEClass == null) {
			conflictRelationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(8);
		}
		return conflictRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictRelation_Conflicts() {
        return (EReference)getConflictRelation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictRelation_Soft() {
        return (EAttribute)getConflictRelation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictRelation_SourceDeltaModule() {
        return (EReference)getConflictRelation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictRelation_TargetDeltaModule() {
        return (EReference)getConflictRelation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictRelation_Resolved() {
        return (EAttribute)getConflictRelation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDuplicateRelation() {
		if (duplicateRelationEClass == null) {
			duplicateRelationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(9);
		}
		return duplicateRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDuplicateRelation_Duplicates() {
        return (EReference)getDuplicateRelation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDuplicateRelation_Resolved() {
        return (EAttribute)getDuplicateRelation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDuplicateRelation_DeltaModules() {
        return (EReference)getDuplicateRelation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransientEffectRelation() {
		if (transientEffectRelationEClass == null) {
			transientEffectRelationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(10);
		}
		return transientEffectRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransientEffectRelation_TransientEffects() {
        return (EReference)getTransientEffectRelation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplicationConditionDependency() {
		if (applicationConditionDependencyEClass == null) {
			applicationConditionDependencyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(11);
		}
		return applicationConditionDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionDependency_Contributions() {
        return (EReference)getApplicationConditionDependency().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionDependency_CoDependencies() {
        return (EReference)getApplicationConditionDependency().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransientEffectRelation_SourceDeltaModule() {
        return (EReference)getTransientEffectRelation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransientEffectRelation_TargetDeltaModule() {
        return (EReference)getTransientEffectRelation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConflict() {
		if (conflictEClass == null) {
			conflictEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(14);
		}
		return conflictEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflict_Details() {
        return (EReference)getConflict().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflict_SourceDeltaAction() {
        return (EReference)getConflict().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflict_TargetDeltaAction() {
        return (EReference)getConflict().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflict_Duplicate() {
        return (EReference)getConflict().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflict_Soft() {
        return (EAttribute)getConflict().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflict_Resolved() {
        return (EAttribute)getConflict().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflict_NonResolvableConfig() {
        return (EReference)getConflict().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependency() {
		if (dependencyEClass == null) {
			dependencyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(12);
		}
		return dependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_Details() {
        return (EReference)getDependency().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_SourceDeltaAction() {
        return (EReference)getDependency().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_TargetDeltaAction() {
        return (EReference)getDependency().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_TransientEffect() {
        return (EReference)getDependency().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_NonResolvableConfig() {
        return (EReference)getDependency().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplicationConditionConflict() {
		if (applicationConditionConflictEClass == null) {
			applicationConditionConflictEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(13);
		}
		return applicationConditionConflictEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionConflict_Contributions() {
        return (EReference)getApplicationConditionConflict().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionConflict_CoConflicts() {
        return (EReference)getApplicationConditionConflict().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_Resolved() {
        return (EAttribute)getDependency().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDuplicate() {
		if (duplicateEClass == null) {
			duplicateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(15);
		}
		return duplicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDuplicate_Details() {
        return (EReference)getDuplicate().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDuplicate_DeltaActions() {
        return (EReference)getDuplicate().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDuplicate_Conflict() {
        return (EReference)getDuplicate().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDuplicate_Resolved() {
        return (EAttribute)getDuplicate().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransientEffect() {
		if (transientEffectEClass == null) {
			transientEffectEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(16);
		}
		return transientEffectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransientEffect_Details() {
        return (EReference)getTransientEffect().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransientEffect_SourceDeltaAction() {
        return (EReference)getTransientEffect().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransientEffect_TargetDeltaAction() {
        return (EReference)getTransientEffect().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransientEffect_Dependency() {
        return (EReference)getTransientEffect().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDetail() {
		if (detailEClass == null) {
			detailEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(17);
		}
		return detailEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDetail_Entities() {
        return (EReference)getDetail().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConflictDetail() {
		if (conflictDetailEClass == null) {
			conflictDetailEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(19);
		}
		return conflictDetailEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictDetail_Kind() {
        return (EAttribute)getConflictDetail().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictDetail_Dangling() {
        return (EAttribute)getConflictDetail().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictDetail_Soft() {
        return (EAttribute)getConflictDetail().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictDetail_Duplicate() {
        return (EAttribute)getConflictDetail().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictDetail_Condition() {
        return (EAttribute)getConflictDetail().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependencyDetail() {
		if (dependencyDetailEClass == null) {
			dependencyDetailEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(18);
		}
		return dependencyDetailEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependencyDetail_Kind() {
        return (EAttribute)getDependencyDetail().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependencyDetail_Transient() {
        return (EAttribute)getDependencyDetail().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependencyDetail_Dangling() {
        return (EAttribute)getDependencyDetail().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependencyDetail_Condition() {
        return (EAttribute)getDependencyDetail().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDuplicateDetail() {
		if (duplicateDetailEClass == null) {
			duplicateDetailEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(20);
		}
		return duplicateDetailEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDuplicateDetail_Kind() {
        return (EAttribute)getDuplicateDetail().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransientEffectDetail() {
		if (transientEffectDetailEClass == null) {
			transientEffectDetailEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(21);
		}
		return transientEffectDetailEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTransientEffectDetail_Kind() {
        return (EAttribute)getTransientEffectDetail().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplicationConditionMatch() {
		if (applicationConditionMatchEClass == null) {
			applicationConditionMatchEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(27);
		}
		return applicationConditionMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationConditionMatch_ConditionID() {
        return (EAttribute)getApplicationConditionMatch().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationConditionMatch_MatchID() {
        return (EAttribute)getApplicationConditionMatch().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationConditionMatch_Kind() {
        return (EAttribute)getApplicationConditionMatch().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationConditionMatch_Resolved() {
        return (EAttribute)getApplicationConditionMatch().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionMatch_NonResolvableConfig() {
        return (EReference)getApplicationConditionMatch().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelation() {
		if (relationEClass == null) {
			relationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(4);
		}
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelation_DomainCompliant() {
        return (EAttribute)getRelation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_UnsatisfiedConfig() {
        return (EReference)getRelation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplicationConditionDependencyRelation() {
		if (applicationConditionDependencyRelationEClass == null) {
			applicationConditionDependencyRelationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(5);
		}
		return applicationConditionDependencyRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionDependencyRelation_SourceDeltaModule() {
        return (EReference)getApplicationConditionDependencyRelation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionDependencyRelation_TargetDeltaModules() {
        return (EReference)getApplicationConditionDependencyRelation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApplicationConditionDependencyRelation_ApplicationConditionDependencies() {
        return (EReference)getApplicationConditionDependencyRelation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationConditionDependencyRelation_Resolved() {
        return (EAttribute)getApplicationConditionDependencyRelation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationConditionDependencyRelation_Void() {
        return (EAttribute)getApplicationConditionDependencyRelation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelation_ConstraintCompliant() {
        return (EAttribute)getRelation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_UnfulfilledConstraints() {
        return (EReference)getRelation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelation_Internal() {
        return (EAttribute)getRelation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCoreModel() {
		if (coreModelEClass == null) {
			coreModelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(1);
		}
		return coreModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoreModel_Resource() {
        return (EAttribute)getCoreModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCoreModel_Uri() {
        return (EAttribute)getCoreModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCoreModel_Config() {
        return (EReference)getCoreModel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCoreModel_CoreModule() {
        return (EReference)getCoreModel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstraintGroup() {
		if (constraintGroupEClass == null) {
			constraintGroupEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(3);
		}
		return constraintGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraintGroup_DeltaModules() {
        return (EReference)getConstraintGroup().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getConflictKind() {
		if (conflictKindEEnum == null) {
			conflictKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(23);
		}
		return conflictKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDependencyKind() {
		if (dependencyKindEEnum == null) {
			dependencyKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(22);
		}
		return dependencyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDuplicateKind() {
		if (duplicateKindEEnum == null) {
			duplicateKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(24);
		}
		return duplicateKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTransientEffectKind() {
		if (transientEffectKindEEnum == null) {
			transientEffectKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(25);
		}
		return transientEffectKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getApplicationConditionKind() {
		if (applicationConditionKindEEnum == null) {
			applicationConditionKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(28);
		}
		return applicationConditionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getIRelationAnalysisEngine() {
		if (iRelationAnalysisEngineEDataType == null) {
			iRelationAnalysisEngineEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(DeltaModelPackage.eNS_URI).getEClassifiers().get(26);
		}
		return iRelationAnalysisEngineEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModelFactory getDeltaModelFactory() {
		return (DeltaModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.sidiff.deltamodeling.deltamodel." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //DeltaModelPackageImpl
