/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Duplicate Detail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DuplicateDetail#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicateDetail()
 * @model
 * @generated
 */
public interface DuplicateDetail extends Detail {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.deltamodeling.deltamodel.DuplicateKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateKind
	 * @see #setKind(DuplicateKind)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicateDetail_Kind()
	 * @model required="true"
	 * @generated
	 */
	DuplicateKind getKind();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DuplicateDetail#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DuplicateKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DuplicateKind value);

} // DuplicateDetail
