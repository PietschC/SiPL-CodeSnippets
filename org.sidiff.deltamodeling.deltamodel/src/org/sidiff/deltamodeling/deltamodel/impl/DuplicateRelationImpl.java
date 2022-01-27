/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.Duplicate;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Duplicate Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateRelationImpl#getDeltaModules <em>Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateRelationImpl#getDuplicates <em>Duplicates</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateRelationImpl#isResolved <em>Resolved</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DuplicateRelationImpl extends RelationImpl implements DuplicateRelation {
	/**
	 * The cached value of the '{@link #getDeltaModules() <em>Delta Modules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeltaModules()
	 * @generated
	 * @ordered
	 */
	protected EList<DeltaModule> deltaModules;

	/**
	 * The cached value of the '{@link #getDuplicates() <em>Duplicates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicates()
	 * @generated
	 * @ordered
	 */
	protected EList<Duplicate> duplicates;

	/**
	 * The default value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DuplicateRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.DUPLICATE_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Duplicate> getDuplicates() {
		if (duplicates == null) {
			duplicates = new EObjectContainmentEList<Duplicate>(Duplicate.class, this, DeltaModelPackage.DUPLICATE_RELATION__DUPLICATES);
		}
		return duplicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		boolean resolved = true;
		for(Duplicate duplicate : getDuplicates()) {
			resolved &= duplicate.isResolved();
		}
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeltaModule> getDeltaModules() {
		if (deltaModules == null) {
			deltaModules = new EObjectWithInverseResolvingEList.ManyInverse<DeltaModule>(DeltaModule.class, this, DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES, DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS);
		}
		return deltaModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeltaModules()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES:
				return ((InternalEList<?>)getDeltaModules()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DUPLICATE_RELATION__DUPLICATES:
				return ((InternalEList<?>)getDuplicates()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES:
				return getDeltaModules();
			case DeltaModelPackage.DUPLICATE_RELATION__DUPLICATES:
				return getDuplicates();
			case DeltaModelPackage.DUPLICATE_RELATION__RESOLVED:
				return isResolved();
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
			case DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES:
				getDeltaModules().clear();
				getDeltaModules().addAll((Collection<? extends DeltaModule>)newValue);
				return;
			case DeltaModelPackage.DUPLICATE_RELATION__DUPLICATES:
				getDuplicates().clear();
				getDuplicates().addAll((Collection<? extends Duplicate>)newValue);
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
			case DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES:
				getDeltaModules().clear();
				return;
			case DeltaModelPackage.DUPLICATE_RELATION__DUPLICATES:
				getDuplicates().clear();
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
			case DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES:
				return deltaModules != null && !deltaModules.isEmpty();
			case DeltaModelPackage.DUPLICATE_RELATION__DUPLICATES:
				return duplicates != null && !duplicates.isEmpty();
			case DeltaModelPackage.DUPLICATE_RELATION__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {

		StringBuilder result = new StringBuilder(super.toString());
		for (Iterator<DeltaModule> iterator = getDeltaModules().iterator(); iterator.hasNext();) {
			DeltaModule deltaModule = iterator.next();
			result.append(deltaModule.getName());
			if(iterator.hasNext()) {
				result.append(", ");
			}
		}

		return result.toString();
	}

} //DuplicateRelationImpl
