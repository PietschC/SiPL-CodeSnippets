/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Dependency#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Dependency#getSourceDeltaAction <em>Source Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Dependency#getTargetDeltaAction <em>Target Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Dependency#getDetails <em>Details</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Dependency#getTransientEffect <em>Transient Effect</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Dependency#getNonResolvableConfig <em>Non Resolvable Config</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependency()
 * @model
 * @generated
 */
public interface Dependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Details</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DependencyDetail}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependency_Details()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependencyDetail> getDetails();

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
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependency_SourceDeltaAction()
	 * @model required="true"
	 * @generated
	 */
	OperationInvocation getSourceDeltaAction();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getSourceDeltaAction <em>Source Delta Action</em>}' reference.
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
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependency_TargetDeltaAction()
	 * @model required="true"
	 * @generated
	 */
	OperationInvocation getTargetDeltaAction();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getTargetDeltaAction <em>Target Delta Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Delta Action</em>' reference.
	 * @see #getTargetDeltaAction()
	 * @generated
	 */
	void setTargetDeltaAction(OperationInvocation value);

	/**
	 * Returns the value of the '<em><b>Transient Effect</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.TransientEffect#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient Effect</em>' reference.
	 * @see #setTransientEffect(TransientEffect)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependency_TransientEffect()
	 * @see org.sidiff.deltamodeling.deltamodel.TransientEffect#getDependency
	 * @model opposite="dependency"
	 * @generated
	 */
	TransientEffect getTransientEffect();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.Dependency#getTransientEffect <em>Transient Effect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient Effect</em>' reference.
	 * @see #getTransientEffect()
	 * @generated
	 */
	void setTransientEffect(TransientEffect value);

	/**
	 * Returns the value of the '<em><b>Non Resolvable Config</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.formula.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Resolvable Config</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependency_NonResolvableConfig()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getNonResolvableConfig();

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependency_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

} // Dependency
