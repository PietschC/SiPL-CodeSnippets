/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict Detail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isDangling <em>Dangling</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isSoft <em>Soft</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isCondition <em>Condition</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isDuplicate <em>Duplicate</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictDetail()
 * @model
 * @generated
 */
public interface ConflictDetail extends Detail {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.deltamodeling.deltamodel.ConflictKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictKind
	 * @see #setKind(ConflictKind)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictDetail_Kind()
	 * @model required="true"
	 * @generated
	 */
	ConflictKind getKind();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.ConflictKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ConflictKind value);

	/**
	 * Returns the value of the '<em><b>Dangling</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dangling</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictDetail_Dangling()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isDangling();

	/**
	 * Returns the value of the '<em><b>Soft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soft</em>' attribute.
	 * @see #setSoft(boolean)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictDetail_Soft()
	 * @model required="true"
	 * @generated
	 */
	boolean isSoft();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isSoft <em>Soft</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soft</em>' attribute.
	 * @see #isSoft()
	 * @generated
	 */
	void setSoft(boolean value);

	/**
	 * Returns the value of the '<em><b>Duplicate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicate</em>' attribute.
	 * @see #setDuplicate(boolean)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictDetail_Duplicate()
	 * @model required="true"
	 * @generated
	 */
	boolean isDuplicate();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isDuplicate <em>Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duplicate</em>' attribute.
	 * @see #isDuplicate()
	 * @generated
	 */
	void setDuplicate(boolean value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(boolean)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConflictDetail_Condition()
	 * @model required="true"
	 * @generated
	 */
	boolean isCondition();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ConflictDetail#isCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #isCondition()
	 * @generated
	 */
	void setCondition(boolean value);

} // ConflictDetail
