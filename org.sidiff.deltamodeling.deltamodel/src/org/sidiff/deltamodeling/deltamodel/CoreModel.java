/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getResource <em>Resource</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getUri <em>Uri</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getConfig <em>Config</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getCoreModule <em>Core Module</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getCoreModel()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidConfiguration'"
 * @generated
 */
public interface CoreModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getCoreModel_Resource()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getCoreModel_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.formula.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getCoreModel_Config()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getConfig();

	/**
	 * Returns the value of the '<em><b>Core Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Core Module</em>' reference.
	 * @see #setCoreModule(DeltaModule)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getCoreModel_CoreModule()
	 * @model required="true"
	 * @generated
	 */
	DeltaModule getCoreModule();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.CoreModel#getCoreModule <em>Core Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core Module</em>' reference.
	 * @see #getCoreModule()
	 * @generated
	 */
	void setCoreModule(DeltaModule value);

} // CoreModel
