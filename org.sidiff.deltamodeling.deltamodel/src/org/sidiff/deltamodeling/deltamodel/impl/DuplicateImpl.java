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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.Duplicate;
import org.sidiff.deltamodeling.deltamodel.DuplicateDetail;

import org.sidiff.difference.asymmetric.OperationInvocation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Duplicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl#getDeltaActions <em>Delta Actions</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl#getConflict <em>Conflict</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DuplicateImpl#isResolved <em>Resolved</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DuplicateImpl extends MinimalEObjectImpl.Container implements Duplicate {
	/**
	 * The cached value of the '{@link #getDeltaActions() <em>Delta Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeltaActions()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationInvocation> deltaActions;

	/**
	 * The cached value of the '{@link #getDetails() <em>Details</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected EList<DuplicateDetail> details;

	/**
	 * The cached value of the '{@link #getConflict() <em>Conflict</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflict()
	 * @generated
	 * @ordered
	 */
	protected EList<Conflict> conflict;

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
	protected DuplicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.DUPLICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DuplicateDetail> getDetails() {
		if (details == null) {
			details = new EObjectContainmentEList<DuplicateDetail>(DuplicateDetail.class, this, DeltaModelPackage.DUPLICATE__DETAILS);
		}
		return details;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OperationInvocation> getDeltaActions() {
		if (deltaActions == null) {
			deltaActions = new EObjectResolvingEList<OperationInvocation>(OperationInvocation.class, this, DeltaModelPackage.DUPLICATE__DELTA_ACTIONS);
		}
		return deltaActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conflict> getConflict() {
		if (conflict == null) {
			conflict = new EObjectWithInverseResolvingEList<Conflict>(Conflict.class, this, DeltaModelPackage.DUPLICATE__CONFLICT, DeltaModelPackage.CONFLICT__DUPLICATE);
		}
		return conflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		boolean resolved = true;
		for(Conflict conflict : getConflict()) {
			resolved &= conflict.isResolved();
		}
		return resolved;
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
			case DeltaModelPackage.DUPLICATE__CONFLICT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConflict()).basicAdd(otherEnd, msgs);
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
			case DeltaModelPackage.DUPLICATE__DETAILS:
				return ((InternalEList<?>)getDetails()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DUPLICATE__CONFLICT:
				return ((InternalEList<?>)getConflict()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.DUPLICATE__DELTA_ACTIONS:
				return getDeltaActions();
			case DeltaModelPackage.DUPLICATE__DETAILS:
				return getDetails();
			case DeltaModelPackage.DUPLICATE__CONFLICT:
				return getConflict();
			case DeltaModelPackage.DUPLICATE__RESOLVED:
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
			case DeltaModelPackage.DUPLICATE__DELTA_ACTIONS:
				getDeltaActions().clear();
				getDeltaActions().addAll((Collection<? extends OperationInvocation>)newValue);
				return;
			case DeltaModelPackage.DUPLICATE__DETAILS:
				getDetails().clear();
				getDetails().addAll((Collection<? extends DuplicateDetail>)newValue);
				return;
			case DeltaModelPackage.DUPLICATE__CONFLICT:
				getConflict().clear();
				getConflict().addAll((Collection<? extends Conflict>)newValue);
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
			case DeltaModelPackage.DUPLICATE__DELTA_ACTIONS:
				getDeltaActions().clear();
				return;
			case DeltaModelPackage.DUPLICATE__DETAILS:
				getDetails().clear();
				return;
			case DeltaModelPackage.DUPLICATE__CONFLICT:
				getConflict().clear();
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
			case DeltaModelPackage.DUPLICATE__DELTA_ACTIONS:
				return deltaActions != null && !deltaActions.isEmpty();
			case DeltaModelPackage.DUPLICATE__DETAILS:
				return details != null && !details.isEmpty();
			case DeltaModelPackage.DUPLICATE__CONFLICT:
				return conflict != null && !conflict.isEmpty();
			case DeltaModelPackage.DUPLICATE__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		
		StringBuilder result = new StringBuilder();
		result.append("<");
		result.append(eClass().getName());
		result.append(">: ");
		for (Iterator<OperationInvocation> iterator = getDeltaActions().iterator(); iterator.hasNext();) {
			OperationInvocation deltaAction = iterator.next();
			result.append(deltaAction.getName());
			if(iterator.hasNext()) {
				result.append(", ");
			}	
		}
		
		return result.toString();
	}

} //DuplicateImpl
