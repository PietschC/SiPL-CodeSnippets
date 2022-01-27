/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Condition Conflict Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getSourceDeltaModules <em>Source Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getApplicationConditionConflicts <em>Application Condition Conflicts</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#isResolved <em>Resolved</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflictRelation()
 * @model
 * @generated
 */
public interface ApplicationConditionConflictRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Source Delta Modules</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DeltaModule}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionConflictRelations <em>Outgoing Application Condition Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Delta Modules</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflictRelation_SourceDeltaModules()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionConflictRelations
	 * @model opposite="outgoingApplicationConditionConflictRelations" required="true"
	 * @generated
	 */
	EList<DeltaModule> getSourceDeltaModules();

	/**
	 * Returns the value of the '<em><b>Target Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionConflictRelations <em>Incoming Application Condition Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Delta Module</em>' reference.
	 * @see #setTargetDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflictRelation_TargetDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionConflictRelations
	 * @model opposite="incomingApplicationConditionConflictRelations" required="true"
	 * @generated
	 */
	DeltaModule getTargetDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Delta Module</em>' reference.
	 * @see #getTargetDeltaModule()
	 * @generated
	 */
	void setTargetDeltaModule(DeltaModule value);

	/**
	 * Returns the value of the '<em><b>Application Condition Conflicts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Condition Conflicts</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflictRelation_ApplicationConditionConflicts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ApplicationConditionConflict> getApplicationConditionConflicts();

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflictRelation_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

} // ApplicationConditionConflictRelation
