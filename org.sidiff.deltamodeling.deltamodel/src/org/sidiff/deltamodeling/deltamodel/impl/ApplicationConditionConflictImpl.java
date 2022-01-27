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

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Condition Conflict</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictImpl#getContributions <em>Contributions</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictImpl#getCoConflicts <em>Co Conflicts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationConditionConflictImpl extends ApplicationConditionMatchImpl implements ApplicationConditionConflict {
	/**
	 * The cached value of the '{@link #getContributions() <em>Contributions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributions()
	 * @generated
	 * @ordered
	 */
	protected EList<Conflict> contributions;

	/**
	 * The cached value of the '{@link #getCoConflicts() <em>Co Conflicts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoConflicts()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionConflict> coConflicts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationConditionConflictImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.APPLICATION_CONDITION_CONFLICT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conflict> getContributions() {
		if (contributions == null) {
			contributions = new EObjectContainmentEList<Conflict>(Conflict.class, this, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS);
		}
		return contributions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionConflict> getCoConflicts() {
		if (coConflicts == null) {
			coConflicts = new EObjectResolvingEList<ApplicationConditionConflict>(ApplicationConditionConflict.class, this, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CO_CONFLICTS);
		}
		return coConflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS:
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS:
				return getContributions();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CO_CONFLICTS:
				return getCoConflicts();
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS:
				getContributions().clear();
				getContributions().addAll((Collection<? extends Conflict>)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CO_CONFLICTS:
				getCoConflicts().clear();
				getCoConflicts().addAll((Collection<? extends ApplicationConditionConflict>)newValue);
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS:
				getContributions().clear();
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CO_CONFLICTS:
				getCoConflicts().clear();
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CONTRIBUTIONS:
				return contributions != null && !contributions.isEmpty();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT__CO_CONFLICTS:
				return coConflicts != null && !coConflicts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ApplicationConditionConflictImpl
