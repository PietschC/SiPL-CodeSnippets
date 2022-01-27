/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Condition Conflict</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict#getContributions <em>Contributions</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict#getCoConflicts <em>Co Conflicts</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflict()
 * @model
 * @generated
 */
public interface ApplicationConditionConflict extends ApplicationConditionMatch {
	/**
	 * Returns the value of the '<em><b>Contributions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.Conflict}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflict_Contributions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Conflict> getContributions();

	/**
	 * Returns the value of the '<em><b>Co Conflicts</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Co Conflicts</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionConflict_CoConflicts()
	 * @model
	 * @generated
	 */
	EList<ApplicationConditionConflict> getCoConflicts();

} // ApplicationConditionConflict
