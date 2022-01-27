/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine;
import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.superimposition.SuperimposedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delta Module Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getAnalysisEngine <em>Analysis Engine</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getSuperimposedModel <em>Superimposed Model</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getCoreModel <em>Core Model</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDeltaModules <em>Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationOrderConstraints <em>Application Order Constraints</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getAllRelations <em>All Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationConditionDependencyRelations <em>Application Condition Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDependencyRelations <em>Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getApplicationConditionConflictRelations <em>Application Condition Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getConflictRelations <em>Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getDuplicateRelations <em>Duplicate Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getTransientEffectRelation <em>Transient Effect Relation</em>}</li>
 * </ul>
 *
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NonVoidFeatureModel NonDeadFeature NonFalseOptionalFeature NonEmptyFeature UniqueDeltaModuleNames NonUnresolvedDependencies NonUnresolvedConflicts'"
 * @generated
 */
public interface DeltaModuleSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Feature Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Model</em>' containment reference.
	 * @see #setFeatureModel(Formula)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_FeatureModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getFeatureModel();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getFeatureModel <em>Feature Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Model</em>' containment reference.
	 * @see #getFeatureModel()
	 * @generated
	 */
	void setFeatureModel(Formula value);

	/**
	 * Returns the value of the '<em><b>Superimposed Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Superimposed Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Superimposed Model</em>' containment reference.
	 * @see #setSuperimposedModel(SuperimposedModel)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_SuperimposedModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SuperimposedModel getSuperimposedModel();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getSuperimposedModel <em>Superimposed Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Superimposed Model</em>' containment reference.
	 * @see #getSuperimposedModel()
	 * @generated
	 */
	void setSuperimposedModel(SuperimposedModel value);

	/**
	 * Returns the value of the '<em><b>Delta Modules</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DeltaModule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Modules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Modules</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_DeltaModules()
	 * @model containment="true"
	 * @generated
	 */
	EList<DeltaModule> getDeltaModules();

	/**
	 * Returns the value of the '<em><b>Conflict Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ConflictRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflict Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflict Relations</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_ConflictRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConflictRelation> getConflictRelations();

	/**
	 * Returns the value of the '<em><b>Dependency Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DependencyRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency Relations</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_DependencyRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependencyRelation> getDependencyRelations();

	/**
	 * Returns the value of the '<em><b>Application Condition Conflict Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Condition Conflict Relations</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_ApplicationConditionConflictRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ApplicationConditionConflictRelation> getApplicationConditionConflictRelations();

	/**
	 * Returns the value of the '<em><b>Duplicate Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.DuplicateRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duplicate Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicate Relations</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_DuplicateRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<DuplicateRelation> getDuplicateRelations();

	/**
	 * Returns the value of the '<em><b>Transient Effect Relation</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.TransientEffectRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient Effect Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient Effect Relation</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_TransientEffectRelation()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransientEffectRelation> getTransientEffectRelation();

	/**
	 * Returns the value of the '<em><b>All Relations</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Relations</em>' reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_AllRelations()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Relation> getAllRelations();

	/**
	 * Returns the value of the '<em><b>Application Condition Dependency Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Condition Dependency Relations</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_ApplicationConditionDependencyRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ApplicationConditionDependencyRelation> getApplicationConditionDependencyRelations();

	/**
	 * Returns the value of the '<em><b>Core Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Core Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Core Model</em>' containment reference.
	 * @see #setCoreModel(CoreModel)
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_CoreModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CoreModel getCoreModel();

	/**
	 * Sets the value of the '{@link org.sidiff.deltamodeling.deltamodel.DeltaModuleSet#getCoreModel <em>Core Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core Model</em>' containment reference.
	 * @see #getCoreModel()
	 * @generated
	 */
	void setCoreModel(CoreModel value);

	/**
	 * Returns the value of the '<em><b>Application Order Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.deltamodeling.deltamodel.ConstraintGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Order Constraints</em>' containment reference list.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_ApplicationOrderConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintGroup> getApplicationOrderConstraints();

	/**
	 * Returns the value of the '<em><b>Analysis Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Engine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Engine</em>' attribute.
	 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getDeltaModuleSet_AnalysisEngine()
	 * @model dataType="org.sidiff.deltamodeling.deltamodel.IRelationAnalysisEngine" required="true" transient="true" changeable="false"
	 * @generated
	 */
	IRelationAnalysisEngine getAnalysisEngine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DeltaModule getDeltaModule(String deltaModuleName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<DeltaModule> getDeltaModules(Configuration config);

} // DeltaModuleSet
