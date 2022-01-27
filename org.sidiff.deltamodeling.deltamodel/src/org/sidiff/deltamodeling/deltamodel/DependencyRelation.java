/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getTargetDeltaModule <em>Target Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#isVoid <em>Void</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyRelation()
 * @model
 * @generated
 */
public interface DependencyRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.Dependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyRelation_Dependencies()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Dependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Void</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Void</em>' attribute.
	 * @see #setVoid(boolean)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyRelation_Void()
	 * @model
	 * @generated
	 */
	boolean isVoid();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#isVoid <em>Void</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Void</em>' attribute.
	 * @see #isVoid()
	 * @generated
	 */
	void setVoid(boolean value);

	/**
	 * Returns the value of the '<em><b>Source Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingDependencyRelations <em>Outgoing Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Delta Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Delta Module</em>' reference.
	 * @see #setSourceDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyRelation_SourceDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingDependencyRelations
	 * @model opposite="outgoingDependencyRelations" required="true"
	 * @generated
	 */
	DeltaModule getSourceDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Delta Module</em>' reference.
	 * @see #getSourceDeltaModule()
	 * @generated
	 */
	void setSourceDeltaModule(DeltaModule value);

	/**
	 * Returns the value of the '<em><b>Target Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingDependencyRelations <em>Incoming Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Delta Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Delta Module</em>' reference.
	 * @see #setTargetDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyRelation_TargetDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingDependencyRelations
	 * @model opposite="incomingDependencyRelations" required="true"
	 * @generated
	 */
	DeltaModule getTargetDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DependencyRelation#getTargetDeltaModule <em>Target Delta Module</em>}' reference.
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
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDependencyRelation_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

} // DependencyRelation
