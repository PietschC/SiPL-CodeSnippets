/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getSourceDeltaModule <em>Source Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getConflicts <em>Conflicts</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#isSoft <em>Soft</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictRelation()
 * @model
 * @generated
 */
public interface ConflictRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Conflicts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.Conflict}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflicts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflicts</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictRelation_Conflicts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Conflict> getConflicts();

	/**
	 * Returns the value of the '<em><b>Soft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soft</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictRelation_Soft()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isSoft();

	/**
	 * Returns the value of the '<em><b>Source Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingConflictRelations <em>Outgoing Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Delta Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Delta Module</em>' reference.
	 * @see #setSourceDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictRelation_SourceDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingConflictRelations
	 * @model opposite="outgoingConflictRelations" required="true"
	 * @generated
	 */
	DeltaModule getSourceDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getSourceDeltaModule <em>Source Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Delta Module</em>' reference.
	 * @see #getSourceDeltaModule()
	 * @generated
	 */
	void setSourceDeltaModule(DeltaModule value);

	/**
	 * Returns the value of the '<em><b>Target Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingConflictRelations <em>Incoming Conflict Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Delta Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Delta Module</em>' reference.
	 * @see #setTargetDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictRelation_TargetDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingConflictRelations
	 * @model opposite="incomingConflictRelations" required="true"
	 * @generated
	 */
	DeltaModule getTargetDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ConflictRelation#getTargetDeltaModule <em>Target Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Delta Module</em>' reference.
	 * @see #getTargetDeltaModule()
	 * @generated
	 */
	void setTargetDeltaModule(DeltaModule value);

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictRelation_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

} // ConflictRelation
