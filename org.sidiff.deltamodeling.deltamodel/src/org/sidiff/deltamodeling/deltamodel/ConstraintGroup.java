/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup#getDeltaModules <em>Delta Modules</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConstraintGroup()
 * @model
 * @generated
 */
public interface ConstraintGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Delta Modules</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DeltaModule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Modules</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Modules</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getConstraintGroup_DeltaModules()
	 * @model required="true"
	 * @generated
	 */
	EList<DeltaModule> getDeltaModules();

} // ConstraintGroup
