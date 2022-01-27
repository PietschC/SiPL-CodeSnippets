/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.difference.asymmetric.OperationInvocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Duplicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Duplicate#getDeltaActions <em>Delta Actions</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Duplicate#getDetails <em>Details</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Duplicate#getConflict <em>Conflict</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Duplicate#isResolved <em>Resolved</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicate()
 * @model
 * @generated
 */
public interface Duplicate extends EObject {
	/**
	 * Returns the value of the '<em><b>Details</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DuplicateDetail}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicate_Details()
	 * @model containment="true"
	 * @generated
	 */
	EList<DuplicateDetail> getDetails();

	/**
	 * Returns the value of the '<em><b>Delta Actions</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.difference.asymmetric.OperationInvocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Actions</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicate_DeltaActions()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<OperationInvocation> getDeltaActions();

	/**
	 * Returns the value of the '<em><b>Conflict</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.Conflict}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.Conflict#getDuplicate <em>Duplicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflict</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicate_Conflict()
	 * @see org.sidiff.deltamodeling.deltamodel.Conflict#getDuplicate
	 * @model opposite="duplicate" upper="2"
	 * @generated
	 */
	EList<Conflict> getConflict();

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicate_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

} // Duplicate
