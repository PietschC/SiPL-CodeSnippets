/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Condition Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency#getContributions <em>Contributions</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency#getCoDependencies <em>Co Dependencies</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependency()
 * @model
 * @generated
 */
public interface ApplicationConditionDependency extends ApplicationConditionMatch {
	/**
	 * Returns the value of the '<em><b>Contributions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.Dependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependency_Contributions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Dependency> getContributions();

	/**
	 * Returns the value of the '<em><b>Co Dependencies</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Co Dependencies</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getApplicationConditionDependency_CoDependencies()
	 * @model
	 * @generated
	 */
	EList<ApplicationConditionDependency> getCoDependencies();

} // ApplicationConditionDependency
