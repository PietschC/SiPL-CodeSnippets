/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Detail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isDangling <em>Dangling</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isCondition <em>Condition</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isTransient <em>Transient</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyDetail()
 * @model
 * @generated
 */
public interface DependencyDetail extends Detail {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.deltamodeling.deltamodel.DependencyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyKind
	 * @see #setKind(DependencyKind)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyDetail_Kind()
	 * @model required="true"
	 * @generated
	 */
	DependencyKind getKind();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DependencyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DependencyKind value);

	/**
	 * Returns the value of the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient</em>' attribute.
	 * @see #setTransient(boolean)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyDetail_Transient()
	 * @model required="true"
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isTransient <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Dangling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dangling</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyDetail_Dangling()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isDangling();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(boolean)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyDetail_Condition()
	 * @model required="true"
	 * @generated
	 */
	boolean isCondition();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DependencyDetail#isCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #isCondition()
	 * @generated
	 */
	void setCondition(boolean value);

} // DependencyDetail
