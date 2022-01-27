/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelFactory
 * @model kind="package"
 * @generated
 */
public interface DeltaModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "deltamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/deltamodeling/deltamodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "deltamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeltaModelPackage eINSTANCE = org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl <em>Delta Module Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDeltaModuleSet()
	 * @generated
	 */
	int DELTA_MODULE_SET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Analysis Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__ANALYSIS_ENGINE = 1;

	/**
	 * The feature id for the '<em><b>Feature Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__FEATURE_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Superimposed Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__SUPERIMPOSED_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__CORE_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Delta Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__DELTA_MODULES = 5;

	/**
	 * The feature id for the '<em><b>Application Order Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS = 6;

	/**
	 * The feature id for the '<em><b>All Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__ALL_RELATIONS = 7;

	/**
	 * The feature id for the '<em><b>Application Condition Dependency Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS = 8;

	/**
	 * The feature id for the '<em><b>Dependency Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__DEPENDENCY_RELATIONS = 9;

	/**
	 * The feature id for the '<em><b>Application Condition Conflict Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS = 10;

	/**
	 * The feature id for the '<em><b>Conflict Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__CONFLICT_RELATIONS = 11;

	/**
	 * The feature id for the '<em><b>Duplicate Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__DUPLICATE_RELATIONS = 12;

	/**
	 * The feature id for the '<em><b>Transient Effect Relation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION = 13;

	/**
	 * The number of structural features of the '<em>Delta Module Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET_FEATURE_COUNT = 14;

	/**
	 * The operation id for the '<em>Get Delta Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET___GET_DELTA_MODULE__STRING = 0;

	/**
	 * The operation id for the '<em>Get Delta Modules</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET___GET_DELTA_MODULES__CONFIGURATION = 1;

	/**
	 * The number of operations of the '<em>Delta Module Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_SET_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl <em>Delta Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDeltaModule()
	 * @generated
	 */
	int DELTA_MODULE = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.RelationImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 4;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyRelationImpl <em>Dependency Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DependencyRelationImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependencyRelation()
	 * @generated
	 */
	int DEPENDENCY_RELATION = 6;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl <em>Conflict Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflictRelation()
	 * @generated
	 */
	int CONFLICT_RELATION = 8;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateRelationImpl <em>Duplicate Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DuplicateRelationImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicateRelation()
	 * @generated
	 */
	int DUPLICATE_RELATION = 9;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectRelationImpl <em>Transient Effect Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.TransientEffectRelationImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffectRelation()
	 * @generated
	 */
	int TRANSIENT_EFFECT_RELATION = 10;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl <em>Conflict</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflict()
	 * @generated
	 */
	int CONFLICT = 14;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 12;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl <em>Duplicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicate()
	 * @generated
	 */
	int DUPLICATE = 15;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl <em>Transient Effect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffect()
	 * @generated
	 */
	int TRANSIENT_EFFECT = 16;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DetailImpl <em>Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DetailImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDetail()
	 * @generated
	 */
	int DETAIL = 17;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl <em>Conflict Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflictDetail()
	 * @generated
	 */
	int CONFLICT_DETAIL = 19;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl <em>Dependency Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependencyDetail()
	 * @generated
	 */
	int DEPENDENCY_DETAIL = 18;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateDetailImpl <em>Duplicate Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DuplicateDetailImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicateDetail()
	 * @generated
	 */
	int DUPLICATE_DETAIL = 20;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectDetailImpl <em>Transient Effect Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.TransientEffectDetailImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffectDetail()
	 * @generated
	 */
	int TRANSIENT_EFFECT_DETAIL = 21;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl <em>Core Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getCoreModel()
	 * @generated
	 */
	int CORE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__URI = 1;

	/**
	 * The feature id for the '<em><b>Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__CONFIG = 2;

	/**
	 * The feature id for the '<em><b>Core Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__CORE_MODULE = 3;

	/**
	 * The number of structural features of the '<em>Core Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Core Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Application Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__APPLICATION_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Before</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__BEFORE = 2;

	/**
	 * The feature id for the '<em><b>After</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__AFTER = 3;

	/**
	 * The feature id for the '<em><b>Delta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__DELTA = 4;

	/**
	 * The feature id for the '<em><b>Incoming Application Condition Dependency Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS = 5;

	/**
	 * The feature id for the '<em><b>Outgoing Application Condition Dependency Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS = 6;

	/**
	 * The feature id for the '<em><b>Incoming Dependency Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS = 7;

	/**
	 * The feature id for the '<em><b>Outgoing Dependency Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS = 8;

	/**
	 * The feature id for the '<em><b>Incoming Application Condition Conflict Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS = 9;

	/**
	 * The feature id for the '<em><b>Outgoing Application Condition Conflict Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS = 10;

	/**
	 * The feature id for the '<em><b>Incoming Conflict Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__INCOMING_CONFLICT_RELATIONS = 11;

	/**
	 * The feature id for the '<em><b>Outgoing Conflict Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS = 12;

	/**
	 * The feature id for the '<em><b>Duplicate Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__DUPLICATE_RELATIONS = 13;

	/**
	 * The feature id for the '<em><b>Incoming Transient Effect Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS = 14;

	/**
	 * The feature id for the '<em><b>Outgoing Transient Effect Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS = 15;

	/**
	 * The number of structural features of the '<em>Delta Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_FEATURE_COUNT = 16;

	/**
	 * The operation id for the '<em>Get All Predecessors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_ALL_PREDECESSORS = 0;

	/**
	 * The operation id for the '<em>Get All Successors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_ALL_SUCCESSORS = 1;

	/**
	 * The operation id for the '<em>Get Incoming Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_INCOMING_DEPENDENCIES__OPERATIONINVOCATION = 2;

	/**
	 * The operation id for the '<em>Get Outgoing Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_OUTGOING_DEPENDENCIES__OPERATIONINVOCATION = 3;

	/**
	 * The operation id for the '<em>Get Incoming Conflicts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_INCOMING_CONFLICTS__OPERATIONINVOCATION = 4;

	/**
	 * The operation id for the '<em>Get Outgoing Conflicts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_OUTGOING_CONFLICTS__OPERATIONINVOCATION = 5;

	/**
	 * The operation id for the '<em>Get Duplicates</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_DUPLICATES__OPERATIONINVOCATION = 6;

	/**
	 * The operation id for the '<em>Get Incoming Transient Effects</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_INCOMING_TRANSIENT_EFFECTS__OPERATIONINVOCATION = 7;

	/**
	 * The operation id for the '<em>Get Outgoing Transient Effects</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_OUTGOING_TRANSIENT_EFFECTS__OPERATIONINVOCATION = 8;

	/**
	 * The operation id for the '<em>Get Incoming Application Condition Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_INCOMING_APPLICATION_CONDITION_DEPENDENCIES__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = 9;

	/**
	 * The operation id for the '<em>Get Outgoing Application Condition Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_OUTGOING_APPLICATION_CONDITION_DEPENDENCIES__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = 10;

	/**
	 * The operation id for the '<em>Get Incoming Application Condition Conflicts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_INCOMING_APPLICATION_CONDITION_CONFLICTS__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = 11;

	/**
	 * The operation id for the '<em>Get Outgoing Application Condition Conflicts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE___GET_OUTGOING_APPLICATION_CONDITION_CONFLICTS__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = 12;

	/**
	 * The number of operations of the '<em>Delta Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_MODULE_OPERATION_COUNT = 13;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConstraintGroupImpl <em>Constraint Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ConstraintGroupImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConstraintGroup()
	 * @generated
	 */
	int CONSTRAINT_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Delta Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_GROUP__DELTA_MODULES = 0;

	/**
	 * The number of structural features of the '<em>Constraint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_GROUP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Constraint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_GROUP_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__CONSTRAINT_COMPLIANT = 0;

	/**
	 * The feature id for the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__DOMAIN_COMPLIANT = 1;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__INTERNAL = 2;

	/**
	 * The feature id for the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__UNFULFILLED_CONSTRAINTS = 3;

	/**
	 * The feature id for the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__UNSATISFIED_CONFIG = 4;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl <em>Application Condition Dependency Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionDependencyRelation()
	 * @generated
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION = 5;

	/**
	 * The feature id for the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__CONSTRAINT_COMPLIANT = RELATION__CONSTRAINT_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__DOMAIN_COMPLIANT = RELATION__DOMAIN_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__INTERNAL = RELATION__INTERNAL;

	/**
	 * The feature id for the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__UNFULFILLED_CONSTRAINTS = RELATION__UNFULFILLED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__UNSATISFIED_CONFIG = RELATION__UNSATISFIED_CONFIG;

	/**
	 * The feature id for the '<em><b>Source Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Delta Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES = RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Application Condition Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES = RELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__RESOLVED = RELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Void</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION__VOID = RELATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Application Condition Dependency Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Application Condition Dependency Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__CONSTRAINT_COMPLIANT = RELATION__CONSTRAINT_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__DOMAIN_COMPLIANT = RELATION__DOMAIN_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__INTERNAL = RELATION__INTERNAL;

	/**
	 * The feature id for the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__UNFULFILLED_CONSTRAINTS = RELATION__UNFULFILLED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__UNSATISFIED_CONFIG = RELATION__UNSATISFIED_CONFIG;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__RESOLVED = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__SOURCE_DELTA_MODULE = RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__TARGET_DELTA_MODULE = RELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__DEPENDENCIES = RELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Void</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION__VOID = RELATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Dependency Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Dependency Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl <em>Application Condition Conflict Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionConflictRelation()
	 * @generated
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION = 7;

	/**
	 * The feature id for the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__CONSTRAINT_COMPLIANT = RELATION__CONSTRAINT_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__DOMAIN_COMPLIANT = RELATION__DOMAIN_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__INTERNAL = RELATION__INTERNAL;

	/**
	 * The feature id for the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__UNFULFILLED_CONSTRAINTS = RELATION__UNFULFILLED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__UNSATISFIED_CONFIG = RELATION__UNSATISFIED_CONFIG;

	/**
	 * The feature id for the '<em><b>Source Delta Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE = RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Application Condition Conflicts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS = RELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION__RESOLVED = RELATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Application Condition Conflict Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Application Condition Conflict Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__CONSTRAINT_COMPLIANT = RELATION__CONSTRAINT_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__DOMAIN_COMPLIANT = RELATION__DOMAIN_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__INTERNAL = RELATION__INTERNAL;

	/**
	 * The feature id for the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__UNFULFILLED_CONSTRAINTS = RELATION__UNFULFILLED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__UNSATISFIED_CONFIG = RELATION__UNSATISFIED_CONFIG;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__RESOLVED = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__SOURCE_DELTA_MODULE = RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__TARGET_DELTA_MODULE = RELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Conflicts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__CONFLICTS = RELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Soft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION__SOFT = RELATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Conflict Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Conflict Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__CONSTRAINT_COMPLIANT = RELATION__CONSTRAINT_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__DOMAIN_COMPLIANT = RELATION__DOMAIN_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__INTERNAL = RELATION__INTERNAL;

	/**
	 * The feature id for the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__UNFULFILLED_CONSTRAINTS = RELATION__UNFULFILLED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__UNSATISFIED_CONFIG = RELATION__UNSATISFIED_CONFIG;

	/**
	 * The feature id for the '<em><b>Delta Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__DELTA_MODULES = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duplicates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__DUPLICATES = RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION__RESOLVED = RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Duplicate Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Duplicate Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__CONSTRAINT_COMPLIANT = RELATION__CONSTRAINT_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__DOMAIN_COMPLIANT = RELATION__DOMAIN_COMPLIANT;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__INTERNAL = RELATION__INTERNAL;

	/**
	 * The feature id for the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__UNFULFILLED_CONSTRAINTS = RELATION__UNFULFILLED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__UNSATISFIED_CONFIG = RELATION__UNSATISFIED_CONFIG;

	/**
	 * The feature id for the '<em><b>Source Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__SOURCE_DELTA_MODULE = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Delta Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__TARGET_DELTA_MODULE = RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transient Effects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION__TRANSIENT_EFFECTS = RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transient Effect Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Transient Effect Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl <em>Application Condition Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionMatch()
	 * @generated
	 */
	int APPLICATION_CONDITION_MATCH = 22;

	/**
	 * The feature id for the '<em><b>Condition ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_MATCH__CONDITION_ID = 0;

	/**
	 * The feature id for the '<em><b>Match ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_MATCH__MATCH_ID = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_MATCH__KIND = 2;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_MATCH__RESOLVED = 3;

	/**
	 * The feature id for the '<em><b>Non Resolvable Config</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_MATCH__NON_RESOLVABLE_CONFIG = 4;

	/**
	 * The number of structural features of the '<em>Application Condition Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_MATCH_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Application Condition Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_MATCH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyImpl <em>Application Condition Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionDependency()
	 * @generated
	 */
	int APPLICATION_CONDITION_DEPENDENCY = 11;

	/**
	 * The feature id for the '<em><b>Condition ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY__CONDITION_ID = APPLICATION_CONDITION_MATCH__CONDITION_ID;

	/**
	 * The feature id for the '<em><b>Match ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY__MATCH_ID = APPLICATION_CONDITION_MATCH__MATCH_ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY__KIND = APPLICATION_CONDITION_MATCH__KIND;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY__RESOLVED = APPLICATION_CONDITION_MATCH__RESOLVED;

	/**
	 * The feature id for the '<em><b>Non Resolvable Config</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY__NON_RESOLVABLE_CONFIG = APPLICATION_CONDITION_MATCH__NON_RESOLVABLE_CONFIG;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS = APPLICATION_CONDITION_MATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Co Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY__CO_DEPENDENCIES = APPLICATION_CONDITION_MATCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Application Condition Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_FEATURE_COUNT = APPLICATION_CONDITION_MATCH_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Application Condition Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_DEPENDENCY_OPERATION_COUNT = APPLICATION_CONDITION_MATCH_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__RESOLVED = 0;

	/**
	 * The feature id for the '<em><b>Source Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SOURCE_DELTA_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Target Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__TARGET_DELTA_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DETAILS = 3;

	/**
	 * The feature id for the '<em><b>Transient Effect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__TRANSIENT_EFFECT = 4;

	/**
	 * The feature id for the '<em><b>Non Resolvable Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__NON_RESOLVABLE_CONFIG = 5;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictImpl <em>Application Condition Conflict</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictImpl
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionConflict()
	 * @generated
	 */
	int APPLICATION_CONDITION_CONFLICT = 13;

	/**
	 * The feature id for the '<em><b>Condition ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT__CONDITION_ID = APPLICATION_CONDITION_MATCH__CONDITION_ID;

	/**
	 * The feature id for the '<em><b>Match ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT__MATCH_ID = APPLICATION_CONDITION_MATCH__MATCH_ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT__KIND = APPLICATION_CONDITION_MATCH__KIND;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT__RESOLVED = APPLICATION_CONDITION_MATCH__RESOLVED;

	/**
	 * The feature id for the '<em><b>Non Resolvable Config</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT__NON_RESOLVABLE_CONFIG = APPLICATION_CONDITION_MATCH__NON_RESOLVABLE_CONFIG;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS = APPLICATION_CONDITION_MATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Co Conflicts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT__CO_CONFLICTS = APPLICATION_CONDITION_MATCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Application Condition Conflict</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_FEATURE_COUNT = APPLICATION_CONDITION_MATCH_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Application Condition Conflict</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITION_CONFLICT_OPERATION_COUNT = APPLICATION_CONDITION_MATCH_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__RESOLVED = 0;

	/**
	 * The feature id for the '<em><b>Soft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__SOFT = 1;

	/**
	 * The feature id for the '<em><b>Source Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__SOURCE_DELTA_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Target Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__TARGET_DELTA_ACTION = 3;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__DETAILS = 4;

	/**
	 * The feature id for the '<em><b>Duplicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__DUPLICATE = 5;

	/**
	 * The feature id for the '<em><b>Non Resolvable Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__NON_RESOLVABLE_CONFIG = 6;

	/**
	 * The number of structural features of the '<em>Conflict</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Conflict</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Delta Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE__DELTA_ACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE__DETAILS = 1;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE__CONFLICT = 2;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE__RESOLVED = 3;

	/**
	 * The number of structural features of the '<em>Duplicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Duplicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Source Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT__SOURCE_DELTA_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Target Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT__TARGET_DELTA_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT__DETAILS = 2;

	/**
	 * The feature id for the '<em><b>Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT__DEPENDENCY = 3;

	/**
	 * The number of structural features of the '<em>Transient Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Transient Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__ENTITIES = 0;

	/**
	 * The number of structural features of the '<em>Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_DETAIL__ENTITIES = DETAIL__ENTITIES;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_DETAIL__KIND = DETAIL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dangling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_DETAIL__DANGLING = DETAIL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_DETAIL__CONDITION = DETAIL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_DETAIL__TRANSIENT = DETAIL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Dependency Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_DETAIL_FEATURE_COUNT = DETAIL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Dependency Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_DETAIL_OPERATION_COUNT = DETAIL_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL__ENTITIES = DETAIL__ENTITIES;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL__KIND = DETAIL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dangling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL__DANGLING = DETAIL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Soft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL__SOFT = DETAIL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL__CONDITION = DETAIL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Duplicate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL__DUPLICATE = DETAIL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Conflict Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL_FEATURE_COUNT = DETAIL_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Conflict Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DETAIL_OPERATION_COUNT = DETAIL_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_DETAIL__ENTITIES = DETAIL__ENTITIES;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_DETAIL__KIND = DETAIL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Duplicate Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_DETAIL_FEATURE_COUNT = DETAIL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Duplicate Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUPLICATE_DETAIL_OPERATION_COUNT = DETAIL_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_DETAIL__ENTITIES = DETAIL__ENTITIES;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_DETAIL__KIND = DETAIL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transient Effect Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_DETAIL_FEATURE_COUNT = DETAIL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Transient Effect Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_EFFECT_DETAIL_OPERATION_COUNT = DETAIL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.ConflictKind <em>Conflict Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictKind
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflictKind()
	 * @generated
	 */
	int CONFLICT_KIND = 24;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.DependencyKind <em>Dependency Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyKind
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependencyKind()
	 * @generated
	 */
	int DEPENDENCY_KIND = 23;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.DuplicateKind <em>Duplicate Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateKind
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicateKind()
	 * @generated
	 */
	int DUPLICATE_KIND = 25;

	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectKind <em>Transient Effect Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectKind
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffectKind()
	 * @generated
	 */
	int TRANSIENT_EFFECT_KIND = 26;


	/**
	 * The meta object id for the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind <em>Application Condition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionKind()
	 * @generated
	 */
	int APPLICATION_CONDITION_KIND = 27;

	/**
	 * The meta object id for the '<em>IRelation Analysis Engine</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine
	 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getIRelationAnalysisEngine()
	 * @generated
	 */
	int IRELATION_ANALYSIS_ENGINE = 28;

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet <em>Delta Module Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delta Module Set</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet
	 * @generated
	 */
	EClass getDeltaModuleSet();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getName()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EAttribute getDeltaModuleSet_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getFeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature Model</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getFeatureModel()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_FeatureModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getSuperimposedModel <em>Superimposed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Superimposed Model</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getSuperimposedModel()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_SuperimposedModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDeltaModules <em>Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Delta Modules</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDeltaModules()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_DeltaModules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getConflictRelations <em>Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conflict Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getConflictRelations()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_ConflictRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDependencyRelations <em>Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependency Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDependencyRelations()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_DependencyRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationConditionConflictRelations <em>Application Condition Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Condition Conflict Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationConditionConflictRelations()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_ApplicationConditionConflictRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDuplicateRelations <em>Duplicate Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Duplicate Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDuplicateRelations()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_DuplicateRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getTransientEffectRelation <em>Transient Effect Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transient Effect Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getTransientEffectRelation()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_TransientEffectRelation();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getAllRelations <em>All Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getAllRelations()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_AllRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationConditionDependencyRelations <em>Application Condition Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Condition Dependency Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationConditionDependencyRelations()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_ApplicationConditionDependencyRelations();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getCoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Core Model</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getCoreModel()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_CoreModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationOrderConstraints <em>Application Order Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Order Constraints</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationOrderConstraints()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EReference getDeltaModuleSet_ApplicationOrderConstraints();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getAnalysisEngine <em>Analysis Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analysis Engine</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getAnalysisEngine()
	 * @see #getDeltaModuleSet()
	 * @generated
	 */
	EAttribute getDeltaModuleSet_AnalysisEngine();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDeltaModule(java.lang.String) <em>Get Delta Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Delta Module</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDeltaModule(java.lang.String)
	 * @generated
	 */
	EOperation getDeltaModuleSet__GetDeltaModule__String();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDeltaModules(org.sidiff.formula.Configuration) <em>Get Delta Modules</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Delta Modules</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDeltaModules(org.sidiff.formula.Configuration)
	 * @generated
	 */
	EOperation getDeltaModuleSet__GetDeltaModules__Configuration();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule <em>Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule
	 * @generated
	 */
	EClass getDeltaModule();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getName()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EAttribute getDeltaModule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getApplicationCondition <em>Application Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application Condition</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getApplicationCondition()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_ApplicationCondition();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingConflictRelations <em>Outgoing Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Conflict Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingConflictRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_OutgoingConflictRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingConflictRelations <em>Incoming Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Conflict Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingConflictRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_IncomingConflictRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingDependencyRelations <em>Outgoing Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Dependency Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingDependencyRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_OutgoingDependencyRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionConflictRelations <em>Incoming Application Condition Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Application Condition Conflict Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionConflictRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_IncomingApplicationConditionConflictRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionConflictRelations <em>Outgoing Application Condition Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Application Condition Conflict Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionConflictRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_OutgoingApplicationConditionConflictRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingDependencyRelations <em>Incoming Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Dependency Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingDependencyRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_IncomingDependencyRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getDuplicateRelations <em>Duplicate Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Duplicate Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getDuplicateRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_DuplicateRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingTransientEffectRelations <em>Outgoing Transient Effect Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transient Effect Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingTransientEffectRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_OutgoingTransientEffectRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingTransientEffectRelations <em>Incoming Transient Effect Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transient Effect Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingTransientEffectRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_IncomingTransientEffectRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>After</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getAfter()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_After();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Before</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getBefore()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_Before();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getDelta <em>Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delta</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getDelta()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_Delta();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionDependencyRelations <em>Incoming Application Condition Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Application Condition Dependency Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionDependencyRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_IncomingApplicationConditionDependencyRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionDependencyRelations <em>Outgoing Application Condition Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Application Condition Dependency Relations</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionDependencyRelations()
	 * @see #getDeltaModule()
	 * @generated
	 */
	EReference getDeltaModule_OutgoingApplicationConditionDependencyRelations();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getAllPredecessors() <em>Get All Predecessors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Predecessors</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getAllPredecessors()
	 * @generated
	 */
	EOperation getDeltaModule__GetAllPredecessors();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getAllSuccessors() <em>Get All Successors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Successors</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getAllSuccessors()
	 * @generated
	 */
	EOperation getDeltaModule__GetAllSuccessors();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingConflicts(org.sidiff.difference.asymmetric.OperationInvocation) <em>Get Outgoing Conflicts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing Conflicts</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingConflicts(org.sidiff.difference.asymmetric.OperationInvocation)
	 * @generated
	 */
	EOperation getDeltaModule__GetOutgoingConflicts__OperationInvocation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingConflicts(org.sidiff.difference.asymmetric.OperationInvocation) <em>Get Incoming Conflicts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming Conflicts</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingConflicts(org.sidiff.difference.asymmetric.OperationInvocation)
	 * @generated
	 */
	EOperation getDeltaModule__GetIncomingConflicts__OperationInvocation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingDependencies(org.sidiff.difference.asymmetric.OperationInvocation) <em>Get Outgoing Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing Dependencies</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingDependencies(org.sidiff.difference.asymmetric.OperationInvocation)
	 * @generated
	 */
	EOperation getDeltaModule__GetOutgoingDependencies__OperationInvocation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingDependencies(org.sidiff.difference.asymmetric.OperationInvocation) <em>Get Incoming Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming Dependencies</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingDependencies(org.sidiff.difference.asymmetric.OperationInvocation)
	 * @generated
	 */
	EOperation getDeltaModule__GetIncomingDependencies__OperationInvocation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getDuplicates(org.sidiff.difference.asymmetric.OperationInvocation) <em>Get Duplicates</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Duplicates</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getDuplicates(org.sidiff.difference.asymmetric.OperationInvocation)
	 * @generated
	 */
	EOperation getDeltaModule__GetDuplicates__OperationInvocation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingTransientEffects(org.sidiff.difference.asymmetric.OperationInvocation) <em>Get Outgoing Transient Effects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing Transient Effects</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingTransientEffects(org.sidiff.difference.asymmetric.OperationInvocation)
	 * @generated
	 */
	EOperation getDeltaModule__GetOutgoingTransientEffects__OperationInvocation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionDependencies(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind) <em>Get Incoming Application Condition Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming Application Condition Dependencies</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionDependencies(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind)
	 * @generated
	 */
	EOperation getDeltaModule__GetIncomingApplicationConditionDependencies__OperationInvocation_ApplicationConditionKind();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionDependencies(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind) <em>Get Outgoing Application Condition Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing Application Condition Dependencies</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionDependencies(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind)
	 * @generated
	 */
	EOperation getDeltaModule__GetOutgoingApplicationConditionDependencies__OperationInvocation_ApplicationConditionKind();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionConflicts(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind) <em>Get Incoming Application Condition Conflicts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming Application Condition Conflicts</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionConflicts(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind)
	 * @generated
	 */
	EOperation getDeltaModule__GetIncomingApplicationConditionConflicts__OperationInvocation_ApplicationConditionKind();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionConflicts(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind) <em>Get Outgoing Application Condition Conflicts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing Application Condition Conflicts</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionConflicts(org.sidiff.difference.asymmetric.OperationInvocation, org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind)
	 * @generated
	 */
	EOperation getDeltaModule__GetOutgoingApplicationConditionConflicts__OperationInvocation_ApplicationConditionKind();

	/**
	 * Returns the meta object for the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingTransientEffects(org.sidiff.difference.asymmetric.OperationInvocation) <em>Get Incoming Transient Effects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming Transient Effects</em>' operation.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingTransientEffects(org.sidiff.difference.asymmetric.OperationInvocation)
	 * @generated
	 */
	EOperation getDeltaModule__GetIncomingTransientEffects__OperationInvocation();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation <em>Dependency Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation
	 * @generated
	 */
	EClass getDependencyRelation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation#getDependencies()
	 * @see #getDependencyRelation()
	 * @generated
	 */
	EReference getDependencyRelation_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#isVoid <em>Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Void</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation#isVoid()
	 * @see #getDependencyRelation()
	 * @generated
	 */
	EAttribute getDependencyRelation_Void();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation <em>Application Condition Conflict Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Condition Conflict Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation
	 * @generated
	 */
	EClass getApplicationConditionConflictRelation();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getSourceDeltaModules <em>Source Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Delta Modules</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getSourceDeltaModules()
	 * @see #getApplicationConditionConflictRelation()
	 * @generated
	 */
	EReference getApplicationConditionConflictRelation_SourceDeltaModules();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getTargetDeltaModule()
	 * @see #getApplicationConditionConflictRelation()
	 * @generated
	 */
	EReference getApplicationConditionConflictRelation_TargetDeltaModule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getApplicationConditionConflicts <em>Application Condition Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Condition Conflicts</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getApplicationConditionConflicts()
	 * @see #getApplicationConditionConflictRelation()
	 * @generated
	 */
	EReference getApplicationConditionConflictRelation_ApplicationConditionConflicts();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#isResolved()
	 * @see #getApplicationConditionConflictRelation()
	 * @generated
	 */
	EAttribute getApplicationConditionConflictRelation_Resolved();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation#getSourceDeltaModule()
	 * @see #getDependencyRelation()
	 * @generated
	 */
	EReference getDependencyRelation_SourceDeltaModule();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation#getTargetDeltaModule()
	 * @see #getDependencyRelation()
	 * @generated
	 */
	EReference getDependencyRelation_TargetDeltaModule();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation#isResolved()
	 * @see #getDependencyRelation()
	 * @generated
	 */
	EAttribute getDependencyRelation_Resolved();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation <em>Conflict Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation
	 * @generated
	 */
	EClass getConflictRelation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getConflicts <em>Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conflicts</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation#getConflicts()
	 * @see #getConflictRelation()
	 * @generated
	 */
	EReference getConflictRelation_Conflicts();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#isSoft <em>Soft</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Soft</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation#isSoft()
	 * @see #getConflictRelation()
	 * @generated
	 */
	EAttribute getConflictRelation_Soft();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation#getSourceDeltaModule()
	 * @see #getConflictRelation()
	 * @generated
	 */
	EReference getConflictRelation_SourceDeltaModule();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation#getTargetDeltaModule()
	 * @see #getConflictRelation()
	 * @generated
	 */
	EReference getConflictRelation_TargetDeltaModule();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation#isResolved()
	 * @see #getConflictRelation()
	 * @generated
	 */
	EAttribute getConflictRelation_Resolved();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation <em>Duplicate Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Duplicate Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateRelation
	 * @generated
	 */
	EClass getDuplicateRelation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDuplicates <em>Duplicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Duplicates</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDuplicates()
	 * @see #getDuplicateRelation()
	 * @generated
	 */
	EReference getDuplicateRelation_Duplicates();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateRelation#isResolved()
	 * @see #getDuplicateRelation()
	 * @generated
	 */
	EAttribute getDuplicateRelation_Resolved();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDeltaModules <em>Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Delta Modules</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDeltaModules()
	 * @see #getDuplicateRelation()
	 * @generated
	 */
	EReference getDuplicateRelation_DeltaModules();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation <em>Transient Effect Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transient Effect Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectRelation
	 * @generated
	 */
	EClass getTransientEffectRelation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTransientEffects <em>Transient Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transient Effects</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTransientEffects()
	 * @see #getTransientEffectRelation()
	 * @generated
	 */
	EReference getTransientEffectRelation_TransientEffects();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency <em>Application Condition Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Condition Dependency</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency
	 * @generated
	 */
	EClass getApplicationConditionDependency();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributions</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency#getContributions()
	 * @see #getApplicationConditionDependency()
	 * @generated
	 */
	EReference getApplicationConditionDependency_Contributions();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency#getCoDependencies <em>Co Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Co Dependencies</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency#getCoDependencies()
	 * @see #getApplicationConditionDependency()
	 * @generated
	 */
	EReference getApplicationConditionDependency_CoDependencies();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getSourceDeltaModule()
	 * @see #getTransientEffectRelation()
	 * @generated
	 */
	EReference getTransientEffectRelation_SourceDeltaModule();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTargetDeltaModule()
	 * @see #getTransientEffectRelation()
	 * @generated
	 */
	EReference getTransientEffectRelation_TargetDeltaModule();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.Conflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict
	 * @generated
	 */
	EClass getConflict();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.Conflict#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#getDetails()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_Details();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.Conflict#getSourceDeltaAction <em>Source Delta Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Delta Action</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#getSourceDeltaAction()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_SourceDeltaAction();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.Conflict#getTargetDeltaAction <em>Target Delta Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Delta Action</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#getTargetDeltaAction()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_TargetDeltaAction();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.Conflict#getDuplicate <em>Duplicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Duplicate</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#getDuplicate()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_Duplicate();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.Conflict#isSoft <em>Soft</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Soft</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#isSoft()
	 * @see #getConflict()
	 * @generated
	 */
	EAttribute getConflict_Soft();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.Conflict#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#isResolved()
	 * @see #getConflict()
	 * @generated
	 */
	EAttribute getConflict_Resolved();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.Conflict#getNonResolvableConfig <em>Non Resolvable Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Non Resolvable Config</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#getNonResolvableConfig()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_NonResolvableConfig();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency#getDetails()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Details();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getSourceDeltaAction <em>Source Delta Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Delta Action</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency#getSourceDeltaAction()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_SourceDeltaAction();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getTargetDeltaAction <em>Target Delta Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Delta Action</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency#getTargetDeltaAction()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_TargetDeltaAction();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getTransientEffect <em>Transient Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transient Effect</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency#getTransientEffect()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_TransientEffect();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getNonResolvableConfig <em>Non Resolvable Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Non Resolvable Config</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency#getNonResolvableConfig()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_NonResolvableConfig();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict <em>Application Condition Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Condition Conflict</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict
	 * @generated
	 */
	EClass getApplicationConditionConflict();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributions</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict#getContributions()
	 * @see #getApplicationConditionConflict()
	 * @generated
	 */
	EReference getApplicationConditionConflict_Contributions();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict#getCoConflicts <em>Co Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Co Conflicts</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict#getCoConflicts()
	 * @see #getApplicationConditionConflict()
	 * @generated
	 */
	EReference getApplicationConditionConflict_CoConflicts();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.Dependency#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency#isResolved()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Resolved();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.Duplicate <em>Duplicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Duplicate</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Duplicate
	 * @generated
	 */
	EClass getDuplicate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.Duplicate#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Duplicate#getDetails()
	 * @see #getDuplicate()
	 * @generated
	 */
	EReference getDuplicate_Details();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.Duplicate#getDeltaActions <em>Delta Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Delta Actions</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Duplicate#getDeltaActions()
	 * @see #getDuplicate()
	 * @generated
	 */
	EReference getDuplicate_DeltaActions();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.Duplicate#getConflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conflict</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Duplicate#getConflict()
	 * @see #getDuplicate()
	 * @generated
	 */
	EReference getDuplicate_Conflict();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.Duplicate#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Duplicate#isResolved()
	 * @see #getDuplicate()
	 * @generated
	 */
	EAttribute getDuplicate_Resolved();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect <em>Transient Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transient Effect</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffect
	 * @generated
	 */
	EClass getTransientEffect();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffect#getDetails()
	 * @see #getTransientEffect()
	 * @generated
	 */
	EReference getTransientEffect_Details();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getSourceDeltaAction <em>Source Delta Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Delta Action</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffect#getSourceDeltaAction()
	 * @see #getTransientEffect()
	 * @generated
	 */
	EReference getTransientEffect_SourceDeltaAction();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getTargetDeltaAction <em>Target Delta Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Delta Action</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffect#getTargetDeltaAction()
	 * @see #getTransientEffect()
	 * @generated
	 */
	EReference getTransientEffect_TargetDeltaAction();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependency</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffect#getDependency()
	 * @see #getTransientEffect()
	 * @generated
	 */
	EReference getTransientEffect_Dependency();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.Detail <em>Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Detail
	 * @generated
	 */
	EClass getDetail();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.Detail#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entities</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Detail#getEntities()
	 * @see #getDetail()
	 * @generated
	 */
	EReference getDetail_Entities();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail <em>Conflict Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict Detail</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictDetail
	 * @generated
	 */
	EClass getConflictDetail();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictDetail#getKind()
	 * @see #getConflictDetail()
	 * @generated
	 */
	EAttribute getConflictDetail_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isDangling <em>Dangling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dangling</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictDetail#isDangling()
	 * @see #getConflictDetail()
	 * @generated
	 */
	EAttribute getConflictDetail_Dangling();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isSoft <em>Soft</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Soft</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictDetail#isSoft()
	 * @see #getConflictDetail()
	 * @generated
	 */
	EAttribute getConflictDetail_Soft();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isDuplicate <em>Duplicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duplicate</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictDetail#isDuplicate()
	 * @see #getConflictDetail()
	 * @generated
	 */
	EAttribute getConflictDetail_Duplicate();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictDetail#isCondition()
	 * @see #getConflictDetail()
	 * @generated
	 */
	EAttribute getConflictDetail_Condition();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail <em>Dependency Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Detail</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyDetail
	 * @generated
	 */
	EClass getDependencyDetail();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyDetail#getKind()
	 * @see #getDependencyDetail()
	 * @generated
	 */
	EAttribute getDependencyDetail_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isTransient <em>Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transient</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyDetail#isTransient()
	 * @see #getDependencyDetail()
	 * @generated
	 */
	EAttribute getDependencyDetail_Transient();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isDangling <em>Dangling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dangling</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyDetail#isDangling()
	 * @see #getDependencyDetail()
	 * @generated
	 */
	EAttribute getDependencyDetail_Dangling();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyDetail#isCondition()
	 * @see #getDependencyDetail()
	 * @generated
	 */
	EAttribute getDependencyDetail_Condition();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.DuplicateDetail <em>Duplicate Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Duplicate Detail</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateDetail
	 * @generated
	 */
	EClass getDuplicateDetail();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.DuplicateDetail#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateDetail#getKind()
	 * @see #getDuplicateDetail()
	 * @generated
	 */
	EAttribute getDuplicateDetail_Kind();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectDetail <em>Transient Effect Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transient Effect Detail</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectDetail
	 * @generated
	 */
	EClass getTransientEffectDetail();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectDetail#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectDetail#getKind()
	 * @see #getTransientEffectDetail()
	 * @generated
	 */
	EAttribute getTransientEffectDetail_Kind();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch <em>Application Condition Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Condition Match</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch
	 * @generated
	 */
	EClass getApplicationConditionMatch();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getConditionID <em>Condition ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition ID</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getConditionID()
	 * @see #getApplicationConditionMatch()
	 * @generated
	 */
	EAttribute getApplicationConditionMatch_ConditionID();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getMatchID <em>Match ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match ID</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getMatchID()
	 * @see #getApplicationConditionMatch()
	 * @generated
	 */
	EAttribute getApplicationConditionMatch_MatchID();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getKind()
	 * @see #getApplicationConditionMatch()
	 * @generated
	 */
	EAttribute getApplicationConditionMatch_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#isResolved()
	 * @see #getApplicationConditionMatch()
	 * @generated
	 */
	EAttribute getApplicationConditionMatch_Resolved();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getNonResolvableConfig <em>Non Resolvable Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Non Resolvable Config</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getNonResolvableConfig()
	 * @see #getApplicationConditionMatch()
	 * @generated
	 */
	EReference getApplicationConditionMatch_NonResolvableConfig();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.Relation#isDomainCompliant <em>Domain Compliant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Compliant</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Relation#isDomainCompliant()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_DomainCompliant();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.Relation#getUnsatisfiedConfig <em>Unsatisfied Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unsatisfied Config</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Relation#getUnsatisfiedConfig()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_UnsatisfiedConfig();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation <em>Application Condition Dependency Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Condition Dependency Relation</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation
	 * @generated
	 */
	EClass getApplicationConditionDependencyRelation();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Delta Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getSourceDeltaModule()
	 * @see #getApplicationConditionDependencyRelation()
	 * @generated
	 */
	EReference getApplicationConditionDependencyRelation_SourceDeltaModule();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getTargetDeltaModules <em>Target Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Delta Modules</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getTargetDeltaModules()
	 * @see #getApplicationConditionDependencyRelation()
	 * @generated
	 */
	EReference getApplicationConditionDependencyRelation_TargetDeltaModules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getApplicationConditionDependencies <em>Application Condition Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Condition Dependencies</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getApplicationConditionDependencies()
	 * @see #getApplicationConditionDependencyRelation()
	 * @generated
	 */
	EReference getApplicationConditionDependencyRelation_ApplicationConditionDependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#isResolved()
	 * @see #getApplicationConditionDependencyRelation()
	 * @generated
	 */
	EAttribute getApplicationConditionDependencyRelation_Resolved();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#isVoid <em>Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Void</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#isVoid()
	 * @see #getApplicationConditionDependencyRelation()
	 * @generated
	 */
	EAttribute getApplicationConditionDependencyRelation_Void();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.Relation#isConstraintCompliant <em>Constraint Compliant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Compliant</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Relation#isConstraintCompliant()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_ConstraintCompliant();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.Relation#getUnfulfilledConstraints <em>Unfulfilled Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unfulfilled Constraints</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Relation#getUnfulfilledConstraints()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_UnfulfilledConstraints();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.Relation#isInternal <em>Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.Relation#isInternal()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Internal();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.CoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Model</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.CoreModel
	 * @generated
	 */
	EClass getCoreModel();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.CoreModel#getResource()
	 * @see #getCoreModel()
	 * @generated
	 */
	EAttribute getCoreModel_Resource();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.CoreModel#getUri()
	 * @see #getCoreModel()
	 * @generated
	 */
	EAttribute getCoreModel_Uri();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Config</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.CoreModel#getConfig()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Config();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getCoreModule <em>Core Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Core Module</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.CoreModel#getCoreModule()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_CoreModule();

	/**
	 * Returns the meta object for class '{@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup <em>Constraint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Group</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConstraintGroup
	 * @generated
	 */
	EClass getConstraintGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup#getDeltaModules <em>Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Delta Modules</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConstraintGroup#getDeltaModules()
	 * @see #getConstraintGroup()
	 * @generated
	 */
	EReference getConstraintGroup_DeltaModules();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.deltamodeling.deltamodel.ConflictKind <em>Conflict Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Conflict Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictKind
	 * @generated
	 */
	EEnum getConflictKind();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.deltamodeling.deltamodel.DependencyKind <em>Dependency Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dependency Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyKind
	 * @generated
	 */
	EEnum getDependencyKind();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.deltamodeling.deltamodel.DuplicateKind <em>Duplicate Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Duplicate Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateKind
	 * @generated
	 */
	EEnum getDuplicateKind();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectKind <em>Transient Effect Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transient Effect Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectKind
	 * @generated
	 */
	EEnum getTransientEffectKind();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind <em>Application Condition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Application Condition Kind</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind
	 * @generated
	 */
	EEnum getApplicationConditionKind();

	/**
	 * Returns the meta object for data type '{@link org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine <em>IRelation Analysis Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IRelation Analysis Engine</em>'.
	 * @see org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine
	 * @model instanceClass="org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine" serializeable="false"
	 * @generated
	 */
	EDataType getIRelationAnalysisEngine();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeltaModelFactory getDeltaModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl <em>Delta Module Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDeltaModuleSet()
		 * @generated
		 */
		EClass DELTA_MODULE_SET = eINSTANCE.getDeltaModuleSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELTA_MODULE_SET__NAME = eINSTANCE.getDeltaModuleSet_Name();

		/**
		 * The meta object literal for the '<em><b>Feature Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__FEATURE_MODEL = eINSTANCE.getDeltaModuleSet_FeatureModel();

		/**
		 * The meta object literal for the '<em><b>Superimposed Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__SUPERIMPOSED_MODEL = eINSTANCE.getDeltaModuleSet_SuperimposedModel();

		/**
		 * The meta object literal for the '<em><b>Delta Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__DELTA_MODULES = eINSTANCE.getDeltaModuleSet_DeltaModules();

		/**
		 * The meta object literal for the '<em><b>Conflict Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__CONFLICT_RELATIONS = eINSTANCE.getDeltaModuleSet_ConflictRelations();

		/**
		 * The meta object literal for the '<em><b>Dependency Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__DEPENDENCY_RELATIONS = eINSTANCE.getDeltaModuleSet_DependencyRelations();

		/**
		 * The meta object literal for the '<em><b>Application Condition Conflict Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS = eINSTANCE.getDeltaModuleSet_ApplicationConditionConflictRelations();

		/**
		 * The meta object literal for the '<em><b>Duplicate Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__DUPLICATE_RELATIONS = eINSTANCE.getDeltaModuleSet_DuplicateRelations();

		/**
		 * The meta object literal for the '<em><b>Transient Effect Relation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION = eINSTANCE.getDeltaModuleSet_TransientEffectRelation();

		/**
		 * The meta object literal for the '<em><b>All Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__ALL_RELATIONS = eINSTANCE.getDeltaModuleSet_AllRelations();

		/**
		 * The meta object literal for the '<em><b>Application Condition Dependency Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS = eINSTANCE.getDeltaModuleSet_ApplicationConditionDependencyRelations();

		/**
		 * The meta object literal for the '<em><b>Core Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__CORE_MODEL = eINSTANCE.getDeltaModuleSet_CoreModel();

		/**
		 * The meta object literal for the '<em><b>Application Order Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS = eINSTANCE.getDeltaModuleSet_ApplicationOrderConstraints();

		/**
		 * The meta object literal for the '<em><b>Analysis Engine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELTA_MODULE_SET__ANALYSIS_ENGINE = eINSTANCE.getDeltaModuleSet_AnalysisEngine();

		/**
		 * The meta object literal for the '<em><b>Get Delta Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE_SET___GET_DELTA_MODULE__STRING = eINSTANCE.getDeltaModuleSet__GetDeltaModule__String();

		/**
		 * The meta object literal for the '<em><b>Get Delta Modules</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE_SET___GET_DELTA_MODULES__CONFIGURATION = eINSTANCE.getDeltaModuleSet__GetDeltaModules__Configuration();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl <em>Delta Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDeltaModule()
		 * @generated
		 */
		EClass DELTA_MODULE = eINSTANCE.getDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELTA_MODULE__NAME = eINSTANCE.getDeltaModule_Name();

		/**
		 * The meta object literal for the '<em><b>Application Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__APPLICATION_CONDITION = eINSTANCE.getDeltaModule_ApplicationCondition();

		/**
		 * The meta object literal for the '<em><b>Outgoing Conflict Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS = eINSTANCE.getDeltaModule_OutgoingConflictRelations();

		/**
		 * The meta object literal for the '<em><b>Incoming Conflict Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__INCOMING_CONFLICT_RELATIONS = eINSTANCE.getDeltaModule_IncomingConflictRelations();

		/**
		 * The meta object literal for the '<em><b>Outgoing Dependency Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS = eINSTANCE.getDeltaModule_OutgoingDependencyRelations();

		/**
		 * The meta object literal for the '<em><b>Incoming Application Condition Conflict Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS = eINSTANCE.getDeltaModule_IncomingApplicationConditionConflictRelations();

		/**
		 * The meta object literal for the '<em><b>Outgoing Application Condition Conflict Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS = eINSTANCE.getDeltaModule_OutgoingApplicationConditionConflictRelations();

		/**
		 * The meta object literal for the '<em><b>Incoming Dependency Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS = eINSTANCE.getDeltaModule_IncomingDependencyRelations();

		/**
		 * The meta object literal for the '<em><b>Duplicate Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__DUPLICATE_RELATIONS = eINSTANCE.getDeltaModule_DuplicateRelations();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transient Effect Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS = eINSTANCE.getDeltaModule_OutgoingTransientEffectRelations();

		/**
		 * The meta object literal for the '<em><b>Incoming Transient Effect Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS = eINSTANCE.getDeltaModule_IncomingTransientEffectRelations();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__AFTER = eINSTANCE.getDeltaModule_After();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__BEFORE = eINSTANCE.getDeltaModule_Before();

		/**
		 * The meta object literal for the '<em><b>Delta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__DELTA = eINSTANCE.getDeltaModule_Delta();

		/**
		 * The meta object literal for the '<em><b>Incoming Application Condition Dependency Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS = eINSTANCE.getDeltaModule_IncomingApplicationConditionDependencyRelations();

		/**
		 * The meta object literal for the '<em><b>Outgoing Application Condition Dependency Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS = eINSTANCE.getDeltaModule_OutgoingApplicationConditionDependencyRelations();

		/**
		 * The meta object literal for the '<em><b>Get All Predecessors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_ALL_PREDECESSORS = eINSTANCE.getDeltaModule__GetAllPredecessors();

		/**
		 * The meta object literal for the '<em><b>Get All Successors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_ALL_SUCCESSORS = eINSTANCE.getDeltaModule__GetAllSuccessors();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing Conflicts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_OUTGOING_CONFLICTS__OPERATIONINVOCATION = eINSTANCE.getDeltaModule__GetOutgoingConflicts__OperationInvocation();

		/**
		 * The meta object literal for the '<em><b>Get Incoming Conflicts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_INCOMING_CONFLICTS__OPERATIONINVOCATION = eINSTANCE.getDeltaModule__GetIncomingConflicts__OperationInvocation();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_OUTGOING_DEPENDENCIES__OPERATIONINVOCATION = eINSTANCE.getDeltaModule__GetOutgoingDependencies__OperationInvocation();

		/**
		 * The meta object literal for the '<em><b>Get Incoming Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_INCOMING_DEPENDENCIES__OPERATIONINVOCATION = eINSTANCE.getDeltaModule__GetIncomingDependencies__OperationInvocation();

		/**
		 * The meta object literal for the '<em><b>Get Duplicates</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_DUPLICATES__OPERATIONINVOCATION = eINSTANCE.getDeltaModule__GetDuplicates__OperationInvocation();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing Transient Effects</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_OUTGOING_TRANSIENT_EFFECTS__OPERATIONINVOCATION = eINSTANCE.getDeltaModule__GetOutgoingTransientEffects__OperationInvocation();

		/**
		 * The meta object literal for the '<em><b>Get Incoming Application Condition Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_INCOMING_APPLICATION_CONDITION_DEPENDENCIES__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = eINSTANCE.getDeltaModule__GetIncomingApplicationConditionDependencies__OperationInvocation_ApplicationConditionKind();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing Application Condition Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_OUTGOING_APPLICATION_CONDITION_DEPENDENCIES__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = eINSTANCE.getDeltaModule__GetOutgoingApplicationConditionDependencies__OperationInvocation_ApplicationConditionKind();

		/**
		 * The meta object literal for the '<em><b>Get Incoming Application Condition Conflicts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_INCOMING_APPLICATION_CONDITION_CONFLICTS__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = eINSTANCE.getDeltaModule__GetIncomingApplicationConditionConflicts__OperationInvocation_ApplicationConditionKind();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing Application Condition Conflicts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_OUTGOING_APPLICATION_CONDITION_CONFLICTS__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND = eINSTANCE.getDeltaModule__GetOutgoingApplicationConditionConflicts__OperationInvocation_ApplicationConditionKind();

		/**
		 * The meta object literal for the '<em><b>Get Incoming Transient Effects</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DELTA_MODULE___GET_INCOMING_TRANSIENT_EFFECTS__OPERATIONINVOCATION = eINSTANCE.getDeltaModule__GetIncomingTransientEffects__OperationInvocation();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyRelationImpl <em>Dependency Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DependencyRelationImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependencyRelation()
		 * @generated
		 */
		EClass DEPENDENCY_RELATION = eINSTANCE.getDependencyRelation();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_RELATION__DEPENDENCIES = eINSTANCE.getDependencyRelation_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Void</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_RELATION__VOID = eINSTANCE.getDependencyRelation_Void();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl <em>Application Condition Conflict Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionConflictRelation()
		 * @generated
		 */
		EClass APPLICATION_CONDITION_CONFLICT_RELATION = eINSTANCE.getApplicationConditionConflictRelation();

		/**
		 * The meta object literal for the '<em><b>Source Delta Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES = eINSTANCE.getApplicationConditionConflictRelation_SourceDeltaModules();

		/**
		 * The meta object literal for the '<em><b>Target Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE = eINSTANCE.getApplicationConditionConflictRelation_TargetDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Application Condition Conflicts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS = eINSTANCE.getApplicationConditionConflictRelation_ApplicationConditionConflicts();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_CONDITION_CONFLICT_RELATION__RESOLVED = eINSTANCE.getApplicationConditionConflictRelation_Resolved();

		/**
		 * The meta object literal for the '<em><b>Source Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_RELATION__SOURCE_DELTA_MODULE = eINSTANCE.getDependencyRelation_SourceDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Target Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_RELATION__TARGET_DELTA_MODULE = eINSTANCE.getDependencyRelation_TargetDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_RELATION__RESOLVED = eINSTANCE.getDependencyRelation_Resolved();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl <em>Conflict Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflictRelation()
		 * @generated
		 */
		EClass CONFLICT_RELATION = eINSTANCE.getConflictRelation();

		/**
		 * The meta object literal for the '<em><b>Conflicts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_RELATION__CONFLICTS = eINSTANCE.getConflictRelation_Conflicts();

		/**
		 * The meta object literal for the '<em><b>Soft</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_RELATION__SOFT = eINSTANCE.getConflictRelation_Soft();

		/**
		 * The meta object literal for the '<em><b>Source Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_RELATION__SOURCE_DELTA_MODULE = eINSTANCE.getConflictRelation_SourceDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Target Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_RELATION__TARGET_DELTA_MODULE = eINSTANCE.getConflictRelation_TargetDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_RELATION__RESOLVED = eINSTANCE.getConflictRelation_Resolved();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateRelationImpl <em>Duplicate Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DuplicateRelationImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicateRelation()
		 * @generated
		 */
		EClass DUPLICATE_RELATION = eINSTANCE.getDuplicateRelation();

		/**
		 * The meta object literal for the '<em><b>Duplicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUPLICATE_RELATION__DUPLICATES = eINSTANCE.getDuplicateRelation_Duplicates();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUPLICATE_RELATION__RESOLVED = eINSTANCE.getDuplicateRelation_Resolved();

		/**
		 * The meta object literal for the '<em><b>Delta Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUPLICATE_RELATION__DELTA_MODULES = eINSTANCE.getDuplicateRelation_DeltaModules();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectRelationImpl <em>Transient Effect Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.TransientEffectRelationImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffectRelation()
		 * @generated
		 */
		EClass TRANSIENT_EFFECT_RELATION = eINSTANCE.getTransientEffectRelation();

		/**
		 * The meta object literal for the '<em><b>Transient Effects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_EFFECT_RELATION__TRANSIENT_EFFECTS = eINSTANCE.getTransientEffectRelation_TransientEffects();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyImpl <em>Application Condition Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionDependency()
		 * @generated
		 */
		EClass APPLICATION_CONDITION_DEPENDENCY = eINSTANCE.getApplicationConditionDependency();

		/**
		 * The meta object literal for the '<em><b>Contributions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS = eINSTANCE.getApplicationConditionDependency_Contributions();

		/**
		 * The meta object literal for the '<em><b>Co Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_DEPENDENCY__CO_DEPENDENCIES = eINSTANCE.getApplicationConditionDependency_CoDependencies();

		/**
		 * The meta object literal for the '<em><b>Source Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_EFFECT_RELATION__SOURCE_DELTA_MODULE = eINSTANCE.getTransientEffectRelation_SourceDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Target Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_EFFECT_RELATION__TARGET_DELTA_MODULE = eINSTANCE.getTransientEffectRelation_TargetDeltaModule();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl <em>Conflict</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflict()
		 * @generated
		 */
		EClass CONFLICT = eINSTANCE.getConflict();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__DETAILS = eINSTANCE.getConflict_Details();

		/**
		 * The meta object literal for the '<em><b>Source Delta Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__SOURCE_DELTA_ACTION = eINSTANCE.getConflict_SourceDeltaAction();

		/**
		 * The meta object literal for the '<em><b>Target Delta Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__TARGET_DELTA_ACTION = eINSTANCE.getConflict_TargetDeltaAction();

		/**
		 * The meta object literal for the '<em><b>Duplicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__DUPLICATE = eINSTANCE.getConflict_Duplicate();

		/**
		 * The meta object literal for the '<em><b>Soft</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT__SOFT = eINSTANCE.getConflict_Soft();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT__RESOLVED = eINSTANCE.getConflict_Resolved();

		/**
		 * The meta object literal for the '<em><b>Non Resolvable Config</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__NON_RESOLVABLE_CONFIG = eINSTANCE.getConflict_NonResolvableConfig();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DETAILS = eINSTANCE.getDependency_Details();

		/**
		 * The meta object literal for the '<em><b>Source Delta Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__SOURCE_DELTA_ACTION = eINSTANCE.getDependency_SourceDeltaAction();

		/**
		 * The meta object literal for the '<em><b>Target Delta Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__TARGET_DELTA_ACTION = eINSTANCE.getDependency_TargetDeltaAction();

		/**
		 * The meta object literal for the '<em><b>Transient Effect</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__TRANSIENT_EFFECT = eINSTANCE.getDependency_TransientEffect();

		/**
		 * The meta object literal for the '<em><b>Non Resolvable Config</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__NON_RESOLVABLE_CONFIG = eINSTANCE.getDependency_NonResolvableConfig();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictImpl <em>Application Condition Conflict</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionConflict()
		 * @generated
		 */
		EClass APPLICATION_CONDITION_CONFLICT = eINSTANCE.getApplicationConditionConflict();

		/**
		 * The meta object literal for the '<em><b>Contributions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS = eINSTANCE.getApplicationConditionConflict_Contributions();

		/**
		 * The meta object literal for the '<em><b>Co Conflicts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_CONFLICT__CO_CONFLICTS = eINSTANCE.getApplicationConditionConflict_CoConflicts();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__RESOLVED = eINSTANCE.getDependency_Resolved();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl <em>Duplicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicate()
		 * @generated
		 */
		EClass DUPLICATE = eINSTANCE.getDuplicate();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUPLICATE__DETAILS = eINSTANCE.getDuplicate_Details();

		/**
		 * The meta object literal for the '<em><b>Delta Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUPLICATE__DELTA_ACTIONS = eINSTANCE.getDuplicate_DeltaActions();

		/**
		 * The meta object literal for the '<em><b>Conflict</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUPLICATE__CONFLICT = eINSTANCE.getDuplicate_Conflict();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUPLICATE__RESOLVED = eINSTANCE.getDuplicate_Resolved();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl <em>Transient Effect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffect()
		 * @generated
		 */
		EClass TRANSIENT_EFFECT = eINSTANCE.getTransientEffect();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_EFFECT__DETAILS = eINSTANCE.getTransientEffect_Details();

		/**
		 * The meta object literal for the '<em><b>Source Delta Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_EFFECT__SOURCE_DELTA_ACTION = eINSTANCE.getTransientEffect_SourceDeltaAction();

		/**
		 * The meta object literal for the '<em><b>Target Delta Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_EFFECT__TARGET_DELTA_ACTION = eINSTANCE.getTransientEffect_TargetDeltaAction();

		/**
		 * The meta object literal for the '<em><b>Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_EFFECT__DEPENDENCY = eINSTANCE.getTransientEffect_Dependency();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DetailImpl <em>Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DetailImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDetail()
		 * @generated
		 */
		EClass DETAIL = eINSTANCE.getDetail();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAIL__ENTITIES = eINSTANCE.getDetail_Entities();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl <em>Conflict Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflictDetail()
		 * @generated
		 */
		EClass CONFLICT_DETAIL = eINSTANCE.getConflictDetail();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_DETAIL__KIND = eINSTANCE.getConflictDetail_Kind();

		/**
		 * The meta object literal for the '<em><b>Dangling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_DETAIL__DANGLING = eINSTANCE.getConflictDetail_Dangling();

		/**
		 * The meta object literal for the '<em><b>Soft</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_DETAIL__SOFT = eINSTANCE.getConflictDetail_Soft();

		/**
		 * The meta object literal for the '<em><b>Duplicate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_DETAIL__DUPLICATE = eINSTANCE.getConflictDetail_Duplicate();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_DETAIL__CONDITION = eINSTANCE.getConflictDetail_Condition();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl <em>Dependency Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependencyDetail()
		 * @generated
		 */
		EClass DEPENDENCY_DETAIL = eINSTANCE.getDependencyDetail();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_DETAIL__KIND = eINSTANCE.getDependencyDetail_Kind();

		/**
		 * The meta object literal for the '<em><b>Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_DETAIL__TRANSIENT = eINSTANCE.getDependencyDetail_Transient();

		/**
		 * The meta object literal for the '<em><b>Dangling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_DETAIL__DANGLING = eINSTANCE.getDependencyDetail_Dangling();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_DETAIL__CONDITION = eINSTANCE.getDependencyDetail_Condition();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateDetailImpl <em>Duplicate Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DuplicateDetailImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicateDetail()
		 * @generated
		 */
		EClass DUPLICATE_DETAIL = eINSTANCE.getDuplicateDetail();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUPLICATE_DETAIL__KIND = eINSTANCE.getDuplicateDetail_Kind();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectDetailImpl <em>Transient Effect Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.TransientEffectDetailImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffectDetail()
		 * @generated
		 */
		EClass TRANSIENT_EFFECT_DETAIL = eINSTANCE.getTransientEffectDetail();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSIENT_EFFECT_DETAIL__KIND = eINSTANCE.getTransientEffectDetail_Kind();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl <em>Application Condition Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionMatch()
		 * @generated
		 */
		EClass APPLICATION_CONDITION_MATCH = eINSTANCE.getApplicationConditionMatch();

		/**
		 * The meta object literal for the '<em><b>Condition ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_CONDITION_MATCH__CONDITION_ID = eINSTANCE.getApplicationConditionMatch_ConditionID();

		/**
		 * The meta object literal for the '<em><b>Match ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_CONDITION_MATCH__MATCH_ID = eINSTANCE.getApplicationConditionMatch_MatchID();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_CONDITION_MATCH__KIND = eINSTANCE.getApplicationConditionMatch_Kind();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_CONDITION_MATCH__RESOLVED = eINSTANCE.getApplicationConditionMatch_Resolved();

		/**
		 * The meta object literal for the '<em><b>Non Resolvable Config</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_MATCH__NON_RESOLVABLE_CONFIG = eINSTANCE.getApplicationConditionMatch_NonResolvableConfig();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.RelationImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Domain Compliant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__DOMAIN_COMPLIANT = eINSTANCE.getRelation_DomainCompliant();

		/**
		 * The meta object literal for the '<em><b>Unsatisfied Config</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__UNSATISFIED_CONFIG = eINSTANCE.getRelation_UnsatisfiedConfig();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl <em>Application Condition Dependency Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionDependencyRelation()
		 * @generated
		 */
		EClass APPLICATION_CONDITION_DEPENDENCY_RELATION = eINSTANCE.getApplicationConditionDependencyRelation();

		/**
		 * The meta object literal for the '<em><b>Source Delta Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE = eINSTANCE.getApplicationConditionDependencyRelation_SourceDeltaModule();

		/**
		 * The meta object literal for the '<em><b>Target Delta Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES = eINSTANCE.getApplicationConditionDependencyRelation_TargetDeltaModules();

		/**
		 * The meta object literal for the '<em><b>Application Condition Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES = eINSTANCE.getApplicationConditionDependencyRelation_ApplicationConditionDependencies();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_CONDITION_DEPENDENCY_RELATION__RESOLVED = eINSTANCE.getApplicationConditionDependencyRelation_Resolved();

		/**
		 * The meta object literal for the '<em><b>Void</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_CONDITION_DEPENDENCY_RELATION__VOID = eINSTANCE.getApplicationConditionDependencyRelation_Void();

		/**
		 * The meta object literal for the '<em><b>Constraint Compliant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__CONSTRAINT_COMPLIANT = eINSTANCE.getRelation_ConstraintCompliant();

		/**
		 * The meta object literal for the '<em><b>Unfulfilled Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__UNFULFILLED_CONSTRAINTS = eINSTANCE.getRelation_UnfulfilledConstraints();

		/**
		 * The meta object literal for the '<em><b>Internal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__INTERNAL = eINSTANCE.getRelation_Internal();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl <em>Core Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getCoreModel()
		 * @generated
		 */
		EClass CORE_MODEL = eINSTANCE.getCoreModel();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_MODEL__RESOURCE = eINSTANCE.getCoreModel_Resource();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_MODEL__URI = eINSTANCE.getCoreModel_Uri();

		/**
		 * The meta object literal for the '<em><b>Config</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__CONFIG = eINSTANCE.getCoreModel_Config();

		/**
		 * The meta object literal for the '<em><b>Core Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__CORE_MODULE = eINSTANCE.getCoreModel_CoreModule();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.impl.ConstraintGroupImpl <em>Constraint Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.impl.ConstraintGroupImpl
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConstraintGroup()
		 * @generated
		 */
		EClass CONSTRAINT_GROUP = eINSTANCE.getConstraintGroup();

		/**
		 * The meta object literal for the '<em><b>Delta Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_GROUP__DELTA_MODULES = eINSTANCE.getConstraintGroup_DeltaModules();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.ConflictKind <em>Conflict Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.ConflictKind
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getConflictKind()
		 * @generated
		 */
		EEnum CONFLICT_KIND = eINSTANCE.getConflictKind();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.DependencyKind <em>Dependency Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.DependencyKind
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDependencyKind()
		 * @generated
		 */
		EEnum DEPENDENCY_KIND = eINSTANCE.getDependencyKind();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.DuplicateKind <em>Duplicate Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.DuplicateKind
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getDuplicateKind()
		 * @generated
		 */
		EEnum DUPLICATE_KIND = eINSTANCE.getDuplicateKind();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectKind <em>Transient Effect Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectKind
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getTransientEffectKind()
		 * @generated
		 */
		EEnum TRANSIENT_EFFECT_KIND = eINSTANCE.getTransientEffectKind();

		/**
		 * The meta object literal for the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind <em>Application Condition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getApplicationConditionKind()
		 * @generated
		 */
		EEnum APPLICATION_CONDITION_KIND = eINSTANCE.getApplicationConditionKind();

		/**
		 * The meta object literal for the '<em>IRelation Analysis Engine</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine
		 * @see org.sidiff.deltamodeling.deltamodel.impl.DeltaModelPackageImpl#getIRelationAnalysisEngine()
		 * @generated
		 */
		EDataType IRELATION_ANALYSIS_ENGINE = eINSTANCE.getIRelationAnalysisEngine();

	}

} //DeltaModelPackage
