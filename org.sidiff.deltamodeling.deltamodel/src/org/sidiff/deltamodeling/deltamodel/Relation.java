/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Relation#isConstraintCompliant <em>Constraint Compliant</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Relation#isDomainCompliant <em>Domain Compliant</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Relation#isInternal <em>Internal</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Relation#getUnfulfilledConstraints <em>Unfulfilled Constraints</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.Relation#getUnsatisfiedConfig <em>Unsatisfied Config</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getRelation()
 * @model abstract="true"
 * @generated
 */
public interface Relation extends EObject {

	/**
	 * Returns the value of the '<em><b>Domain Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Compliant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Compliant</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getRelation_DomainCompliant()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isDomainCompliant();

	/**
	 * Returns the value of the '<em><b>Unsatisfied Config</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.formula.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsatisfied Config</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsatisfied Config</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getRelation_UnsatisfiedConfig()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getUnsatisfiedConfig();

	/**
	 * Returns the value of the '<em><b>Constraint Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Compliant</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getRelation_ConstraintCompliant()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isConstraintCompliant();

	/**
	 * Returns the value of the '<em><b>Unfulfilled Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unfulfilled Constraints</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getRelation_UnfulfilledConstraints()
	 * @model
	 * @generated
	 */
	EList<ConstraintGroup> getUnfulfilledConstraints();

	/**
	 * Returns the value of the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getRelation_Internal()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isInternal();
} // Relation
