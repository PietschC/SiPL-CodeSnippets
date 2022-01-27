/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Duplicate Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDeltaModules <em>Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation#getDuplicates <em>Duplicates</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation#isResolved <em>Resolved</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicateRelation()
 * @model
 * @generated
 */
public interface DuplicateRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Duplicates</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.Duplicate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duplicates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicates</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicateRelation_Duplicates()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Duplicate> getDuplicates();

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicateRelation_Resolved()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

	/**
	 * Returns the value of the '<em><b>Delta Modules</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DeltaModule}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.deltamodeling.deltamodel.DeltaModule#getDuplicateRelations <em>Duplicate Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Modules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Modules</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDuplicateRelation_DeltaModules()
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModule#getDuplicateRelations
	 * @model opposite="duplicateRelations" lower="2" upper="2"
	 * @generated
	 */
	EList<DeltaModule> getDeltaModules();

} // DuplicateRelation
