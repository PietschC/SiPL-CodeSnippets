/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.DependencyKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Detail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl#isDangling <em>Dangling</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl#isCondition <em>Condition</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyDetailImpl#isTransient <em>Transient</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyDetailImpl extends DetailImpl implements DependencyDetail {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final DependencyKind KIND_EDEFAULT = DependencyKind.CREATE_USE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected DependencyKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #isDangling() <em>Dangling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDangling()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DANGLING_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCondition()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONDITION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCondition()
	 * @generated
	 * @ordered
	 */
	protected boolean condition = CONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean transient_ = TRANSIENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyDetailImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.DEPENDENCY_DETAIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DependencyKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(DependencyKind newKind) {
		DependencyKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DEPENDENCY_DETAIL__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTransient() {
		return transient_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransient(boolean newTransient) {
		boolean oldTransient = transient_;
		transient_ = newTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DEPENDENCY_DETAIL__TRANSIENT, oldTransient, transient_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDangling() {
		return kind == DependencyKind.DANGLING_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(boolean newCondition) {
		boolean oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DEPENDENCY_DETAIL__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeltaModelPackage.DEPENDENCY_DETAIL__KIND:
				return getKind();
			case DeltaModelPackage.DEPENDENCY_DETAIL__DANGLING:
				return isDangling();
			case DeltaModelPackage.DEPENDENCY_DETAIL__CONDITION:
				return isCondition();
			case DeltaModelPackage.DEPENDENCY_DETAIL__TRANSIENT:
				return isTransient();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DeltaModelPackage.DEPENDENCY_DETAIL__KIND:
				setKind((DependencyKind)newValue);
				return;
			case DeltaModelPackage.DEPENDENCY_DETAIL__CONDITION:
				setCondition((Boolean)newValue);
				return;
			case DeltaModelPackage.DEPENDENCY_DETAIL__TRANSIENT:
				setTransient((Boolean)newValue);
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
			case DeltaModelPackage.DEPENDENCY_DETAIL__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case DeltaModelPackage.DEPENDENCY_DETAIL__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case DeltaModelPackage.DEPENDENCY_DETAIL__TRANSIENT:
				setTransient(TRANSIENT_EDEFAULT);
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
			case DeltaModelPackage.DEPENDENCY_DETAIL__KIND:
				return kind != KIND_EDEFAULT;
			case DeltaModelPackage.DEPENDENCY_DETAIL__DANGLING:
				return isDangling() != DANGLING_EDEFAULT;
			case DeltaModelPackage.DEPENDENCY_DETAIL__CONDITION:
				return condition != CONDITION_EDEFAULT;
			case DeltaModelPackage.DEPENDENCY_DETAIL__TRANSIENT:
				return transient_ != TRANSIENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(", condition: ");
		result.append(condition);
		result.append(", transient: ");
		result.append(transient_);
		result.append(')');
		return result.toString();
	}

} //DependencyDetailImpl
