/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.difference.asymmetric.OperationInvocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transient Effect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getSourceDeltaAction <em>Source Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getTargetDeltaAction <em>Target Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getDetails <em>Details</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getDependency <em>Dependency</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffect()
 * @model
 * @generated
 */
public interface TransientEffect extends EObject {
	/**
	 * Returns the value of the '<em><b>Details</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.TransientEffectDetail}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffect_Details()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransientEffectDetail> getDetails();

	/**
	 * Returns the value of the '<em><b>Source Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Delta Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Delta Action</em>' reference.
	 * @see #setSourceDeltaAction(OperationInvocation)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffect_SourceDeltaAction()
	 * @model required="true"
	 * @generated
	 */
	OperationInvocation getSourceDeltaAction();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getSourceDeltaAction <em>Source Delta Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Delta Action</em>' reference.
	 * @see #getSourceDeltaAction()
	 * @generated
	 */
	void setSourceDeltaAction(OperationInvocation value);

	/**
	 * Returns the value of the '<em><b>Target Delta Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Delta Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Delta Action</em>' reference.
	 * @see #setTargetDeltaAction(OperationInvocation)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffect_TargetDeltaAction()
	 * @model required="true"
	 * @generated
	 */
	OperationInvocation getTargetDeltaAction();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getTargetDeltaAction <em>Target Delta Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Delta Action</em>' reference.
	 * @see #getTargetDeltaAction()
	 * @generated
	 */
	void setTargetDeltaAction(OperationInvocation value);

	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getTransientEffect <em>Transient Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' reference.
	 * @see #setDependency(Dependency)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffect_Dependency()
	 * @see org.sidiff.deltamodeling.deltamodel.Dependency#getTransientEffect
	 * @model opposite="transientEffect"
	 * @generated
	 */
	Dependency getDependency();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getDependency <em>Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency</em>' reference.
	 * @see #getDependency()
	 * @generated
	 */
	void setDependency(Dependency value);

} // TransientEffect
