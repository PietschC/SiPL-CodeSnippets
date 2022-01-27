/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transient Effect Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getSourceDeltaModule <em>Source Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTargetDeltaModule <em>Target Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTransientEffects <em>Transient Effects</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffectRelation()
 * @model
 * @generated
 */
public interface TransientEffectRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Transient Effects</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.TransientEffect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient Effects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient Effects</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffectRelation_TransientEffects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TransientEffect> getTransientEffects();

	/**
	 * Returns the value of the '<em><b>Source Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingTransientEffectRelations <em>Outgoing Transient Effect Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Delta Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Delta Module</em>' reference.
	 * @see #setSourceDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffectRelation_SourceDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingTransientEffectRelations
	 * @model opposite="outgoingTransientEffectRelations" required="true"
	 * @generated
	 */
	DeltaModule getSourceDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getSourceDeltaModule <em>Source Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Delta Module</em>' reference.
	 * @see #getSourceDeltaModule()
	 * @generated
	 */
	void setSourceDeltaModule(DeltaModule value);

	/**
	 * Returns the value of the '<em><b>Target Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingTransientEffectRelations <em>Incoming Transient Effect Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Delta Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Delta Module</em>' reference.
	 * @see #setTargetDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffectRelation_TargetDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingTransientEffectRelations
	 * @model opposite="incomingTransientEffectRelations" required="true"
	 * @generated
	 */
	DeltaModule getTargetDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation#getTargetDeltaModule <em>Target Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Delta Module</em>' reference.
	 * @see #getTargetDeltaModule()
	 * @generated
	 */
	void setTargetDeltaModule(DeltaModule value);

} // TransientEffectRelation
