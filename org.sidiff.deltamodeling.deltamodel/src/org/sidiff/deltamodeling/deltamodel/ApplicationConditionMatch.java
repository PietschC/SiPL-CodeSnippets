/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Condition Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getConditionID <em>Condition ID</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getMatchID <em>Match ID</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getNonResolvableConfig <em>Non Resolvable Config</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionMatch()
 * @model abstract="true"
 * @generated
 */
public interface ApplicationConditionMatch extends EObject {
	/**
	 * Returns the value of the '<em><b>Condition ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition ID</em>' attribute.
	 * @see #setConditionID(String)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionMatch_ConditionID()
	 * @model required="true"
	 * @generated
	 */
	String getConditionID();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getConditionID <em>Condition ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition ID</em>' attribute.
	 * @see #getConditionID()
	 * @generated
	 */
	void setConditionID(String value);

	/**
	 * Returns the value of the '<em><b>Match ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match ID</em>' attribute.
	 * @see #setMatchID(String)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionMatch_MatchID()
	 * @model required="true"
	 * @generated
	 */
	String getMatchID();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getMatchID <em>Match ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match ID</em>' attribute.
	 * @see #getMatchID()
	 * @generated
	 */
	void setMatchID(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind
	 * @see #setKind(ApplicationConditionKind)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionMatch_Kind()
	 * @model required="true"
	 * @generated
	 */
	ApplicationConditionKind getKind();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ApplicationConditionKind value);

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionMatch_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

	/**
	 * Returns the value of the '<em><b>Non Resolvable Config</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.formula.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Resolvable Config</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionMatch_NonResolvableConfig()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Variable> getNonResolvableConfig();

} // ApplicationConditionMatch
