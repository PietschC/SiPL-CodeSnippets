/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConstraintGroupImpl#getDeltaModules <em>Delta Modules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintGroupImpl extends MinimalEObjectImpl.Container implements ConstraintGroup {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.CONSTRAINT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeltaModule> getDeltaModules() {
		if (deltaModules == null) {
			deltaModules = new EObjectResolvingEList<DeltaModule>(DeltaModule.class, this, DeltaModelPackage.CONSTRAINT_GROUP__DELTA_MODULES);
		}
		return deltaModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeltaModelPackage.CONSTRAINT_GROUP__DELTA_MODULES:
				return getDeltaModules();
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
			case DeltaModelPackage.CONSTRAINT_GROUP__DELTA_MODULES:
				getDeltaModules().clear();
				getDeltaModules().addAll((Collection<? extends DeltaModule>)newValue);
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
			case DeltaModelPackage.CONSTRAINT_GROUP__DELTA_MODULES:
				getDeltaModules().clear();
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
			case DeltaModelPackage.CONSTRAINT_GROUP__DELTA_MODULES:
				return deltaModules != null && !deltaModules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append("[");
		for (Iterator<DeltaModule> iterator = getDeltaModules().iterator(); iterator.hasNext();) {
			DeltaModule deltaModule = iterator.next();
			result.append(deltaModule.getName());
			if(iterator.hasNext()) {
				result.append(", ");
			}
		}
		result.append(']');
		return result.toString();
	}
} //ConstraintGroupImpl
