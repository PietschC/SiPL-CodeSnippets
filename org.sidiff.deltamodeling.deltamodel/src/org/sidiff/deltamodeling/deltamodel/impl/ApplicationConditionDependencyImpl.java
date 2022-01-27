/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Condition Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyImpl#getContributions <em>Contributions</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyImpl#getCoDependencies <em>Co Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationConditionDependencyImpl extends ApplicationConditionMatchImpl implements ApplicationConditionDependency {
	/**
	 * The cached value of the '{@link #getContributions() <em>Contributions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributions()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> contributions;

	/**
	 * The cached value of the '{@link #getCoDependencies() <em>Co Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionDependency> coDependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationConditionDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.APPLICATION_CONDITION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getContributions() {
		if (contributions == null) {
			contributions = new EObjectContainmentEList<Dependency>(Dependency.class, this, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS);
		}
		return contributions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionDependency> getCoDependencies() {
		if (coDependencies == null) {
			coDependencies = new EObjectResolvingEList<ApplicationConditionDependency>(ApplicationConditionDependency.class, this, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CO_DEPENDENCIES);
		}
		return coDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS:
				return ((InternalEList<?>)getContributions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS:
				return getContributions();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CO_DEPENDENCIES:
				return getCoDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS:
				getContributions().clear();
				getContributions().addAll((Collection<? extends Dependency>)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CO_DEPENDENCIES:
				getCoDependencies().clear();
				getCoDependencies().addAll((Collection<? extends ApplicationConditionDependency>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS:
				getContributions().clear();
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CO_DEPENDENCIES:
				getCoDependencies().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CONTRIBUTIONS:
				return contributions != null && !contributions.isEmpty();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY__CO_DEPENDENCIES:
				return coDependencies != null && !coDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ApplicationConditionDependencyImpl
