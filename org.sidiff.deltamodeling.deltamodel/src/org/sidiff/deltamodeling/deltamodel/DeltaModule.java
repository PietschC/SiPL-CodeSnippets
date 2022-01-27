/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.difference.asymmetric.AsymmetricDifference;

import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.formula.Formula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delta Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getApplicationCondition <em>Application Condition</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getBefore <em>Before</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getAfter <em>After</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getDelta <em>Delta</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionDependencyRelations <em>Incoming Application Condition Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionDependencyRelations <em>Outgoing Application Condition Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingDependencyRelations <em>Incoming Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingDependencyRelations <em>Outgoing Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionConflictRelations <em>Incoming Application Condition Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionConflictRelations <em>Outgoing Application Condition Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingConflictRelations <em>Incoming Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingConflictRelations <em>Outgoing Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getDuplicateRelations <em>Duplicate Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingTransientEffectRelations <em>Incoming Transient Effect Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingTransientEffectRelations <em>Outgoing Transient Effect Relations</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidApplicationCondition'"
 * @generated
 */
public interface DeltaModule extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Application Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Condition</em>' containment reference.
	 * @see #setApplicationCondition(Formula)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_ApplicationCondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getApplicationCondition();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getApplicationCondition <em>Application Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Condition</em>' containment reference.
	 * @see #getApplicationCondition()
	 * @generated
	 */
	void setApplicationCondition(Formula value);

	/**
	 * Returns the value of the '<em><b>Outgoing Conflict Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ConflictRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Conflict Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Conflict Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_OutgoingConflictRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation#getSourceDeltaModule
	 * @model opposite="sourceDeltaModule"
	 * @generated
	 */
	EList<ConflictRelation> getOutgoingConflictRelations();

	/**
	 * Returns the value of the '<em><b>Incoming Conflict Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ConflictRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Conflict Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Conflict Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_IncomingConflictRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictRelation#getTargetDeltaModule
	 * @model opposite="targetDeltaModule"
	 * @generated
	 */
	EList<ConflictRelation> getIncomingConflictRelations();

	/**
	 * Returns the value of the '<em><b>Outgoing Dependency Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DependencyRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Dependency Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Dependency Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_OutgoingDependencyRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation#getSourceDeltaModule
	 * @model opposite="sourceDeltaModule"
	 * @generated
	 */
	EList<DependencyRelation> getOutgoingDependencyRelations();

	/**
	 * Returns the value of the '<em><b>Incoming Application Condition Conflict Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Application Condition Conflict Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_IncomingApplicationConditionConflictRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getTargetDeltaModule
	 * @model opposite="targetDeltaModule"
	 * @generated
	 */
	EList<ApplicationConditionConflictRelation> getIncomingApplicationConditionConflictRelations();

	/**
	 * Returns the value of the '<em><b>Outgoing Application Condition Conflict Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getSourceDeltaModules <em>Source Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Application Condition Conflict Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_OutgoingApplicationConditionConflictRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getSourceDeltaModules
	 * @model opposite="sourceDeltaModules"
	 * @generated
	 */
	EList<ApplicationConditionConflictRelation> getOutgoingApplicationConditionConflictRelations();

	/**
	 * Returns the value of the '<em><b>Incoming Dependency Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DependencyRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Dependency Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Dependency Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_IncomingDependencyRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyRelation#getTargetDeltaModule
	 * @model opposite="targetDeltaModule"
	 * @generated
	 */
	EList<DependencyRelation> getIncomingDependencyRelations();

	/**
	 * Returns the value of the '<em><b>Duplicate Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDeltaModules <em>Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duplicate Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicate Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_DuplicateRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDeltaModules
	 * @model opposite="deltaModules"
	 * @generated
	 */
	EList<DuplicateRelation> getDuplicateRelations();

	/**
	 * Returns the value of the '<em><b>Outgoing Transient Effect Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transient Effect Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transient Effect Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_OutgoingTransientEffectRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getSourceDeltaModule
	 * @model opposite="sourceDeltaModule"
	 * @generated
	 */
	EList<TransientEffectRelation> getOutgoingTransientEffectRelations();

	/**
	 * Returns the value of the '<em><b>Incoming Transient Effect Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTargetDeltaModule <em>Target Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transient Effect Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transient Effect Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_IncomingTransientEffectRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTargetDeltaModule
	 * @model opposite="targetDeltaModule"
	 * @generated
	 */
	EList<TransientEffectRelation> getIncomingTransientEffectRelations();

	/**
	 * Returns the value of the '<em><b>After</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_After()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ConstraintGroup> getAfter();

	/**
	 * Returns the value of the '<em><b>Before</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Before</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_Before()
	 * @model containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ConstraintGroup> getBefore();

	/**
	 * Returns the value of the '<em><b>Delta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta</em>' reference.
	 * @see #setDelta(AsymmetricDifference)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_Delta()
	 * @model required="true"
	 * @generated
	 */
	AsymmetricDifference getDelta();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getDelta <em>Delta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta</em>' reference.
	 * @see #getDelta()
	 * @generated
	 */
	void setDelta(AsymmetricDifference value);

	/**
	 * Returns the value of the '<em><b>Incoming Application Condition Dependency Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getTargetDeltaModules <em>Target Delta Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Application Condition Dependency Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_IncomingApplicationConditionDependencyRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getTargetDeltaModules
	 * @model opposite="targetDeltaModules"
	 * @generated
	 */
	EList<ApplicationConditionDependencyRelation> getIncomingApplicationConditionDependencyRelations();

	/**
	 * Returns the value of the '<em><b>Outgoing Application Condition Dependency Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Application Condition Dependency Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModule_OutgoingApplicationConditionDependencyRelations()
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getSourceDeltaModule
	 * @model opposite="sourceDeltaModule"
	 * @generated
	 */
	EList<ApplicationConditionDependencyRelation> getOutgoingApplicationConditionDependencyRelations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DeltaModule> getAllPredecessors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DeltaModule> getAllSuccessors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Conflict> getOutgoingConflicts(OperationInvocation deltaAction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Conflict> getIncomingConflicts(OperationInvocation deltaAction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Dependency> getOutgoingDependencies(OperationInvocation deltaAction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Dependency> getIncomingDependencies(OperationInvocation deltaAction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Duplicate> getDuplicates(OperationInvocation deltaAction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<TransientEffect> getOutgoingTransientEffects(OperationInvocation deltaAction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model deltaActionRequired="true"
	 * @generated
	 */
	EList<ApplicationConditionDependency> getIncomingApplicationConditionDependencies(OperationInvocation deltaAction, ApplicationConditionKind kind);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model deltaActionRequired="true"
	 * @generated
	 */
	EList<ApplicationConditionDependency> getOutgoingApplicationConditionDependencies(OperationInvocation deltaAction, ApplicationConditionKind kind);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model deltaActionRequired="true"
	 * @generated
	 */
	EList<ApplicationConditionConflict> getIncomingApplicationConditionConflicts(OperationInvocation deltaAction, ApplicationConditionKind kind);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model deltaActionRequired="true"
	 * @generated
	 */
	EList<ApplicationConditionConflict> getOutgoingApplicationConditionConflicts(OperationInvocation deltaAction, ApplicationConditionKind kind);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<TransientEffect> getIncomingTransientEffects(OperationInvocation deltaAction);

} // DeltaModule
