/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transient Effect Detail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffectDetail#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffectDetail()
 * @model
 * @generated
 */
public interface TransientEffectDetail extends Detail {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.deltamodeling.deltamodel.TransientEffectKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectKind
	 * @see #setKind(TransientEffectKind)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffectDetail_Kind()
	 * @model required="true"
	 * @generated
	 */
	TransientEffectKind getKind();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectDetail#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffectKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TransientEffectKind value);

} // TransientEffectDetail
