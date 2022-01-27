/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Condition Dependency Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getTargetDeltaModules <em>Target Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getApplicationConditionDependencies <em>Application Condition Dependencies</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#isVoid <em>Void</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependencyRelation()
 * @model
 * @generated
 */
public interface ApplicationConditionDependencyRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Source Delta Module</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionDependencyRelations <em>Outgoing Application Condition Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Delta Module</em>' reference.
	 * @see #setSourceDeltaModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependencyRelation_SourceDeltaModule()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getOutgoingApplicationConditionDependencyRelations
	 * @model opposite="outgoingApplicationConditionDependencyRelations" required="true"
	 * @generated
	 */
	DeltaModule getSourceDeltaModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#getSourceDeltaModule <em>Source Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Delta Module</em>' reference.
	 * @see #getSourceDeltaModule()
	 * @generated
	 */
	void setSourceDeltaModule(DeltaModule value);

	/**
	 * Returns the value of the '<em><b>Target Delta Modules</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DeltaModule}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionDependencyRelations <em>Incoming Application Condition Dependency Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Delta Modules</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependencyRelation_TargetDeltaModules()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getIncomingApplicationConditionDependencyRelations
	 * @model opposite="incomingApplicationConditionDependencyRelations" required="true"
	 * @generated
	 */
	EList<DeltaModule> getTargetDeltaModules();

	/**
	 * Returns the value of the '<em><b>Application Condition Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Condition Dependencies</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependencyRelation_ApplicationConditionDependencies()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ApplicationConditionDependency> getApplicationConditionDependencies();

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependencyRelation_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

	/**
	 * Returns the value of the '<em><b>Void</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Void</em>' attribute.
	 * @see #setVoid(boolean)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependencyRelation_Void()
	 * @model
	 * @generated
	 */
	boolean isVoid();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation#isVoid <em>Void</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Void</em>' attribute.
	 * @see #isVoid()
	 * @generated
	 */
	void setVoid(boolean value);

} // ApplicationConditionDependencyRelation
