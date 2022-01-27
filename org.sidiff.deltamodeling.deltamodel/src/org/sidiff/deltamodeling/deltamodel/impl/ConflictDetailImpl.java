/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.ConflictKind;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict Detail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl#isDangling <em>Dangling</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl#isSoft <em>Soft</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl#isCondition <em>Condition</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictDetailImpl#isDuplicate <em>Duplicate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConflictDetailImpl extends DetailImpl implements ConflictDetail {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ConflictKind KIND_EDEFAULT = ConflictKind.DELETE_USE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ConflictKind kind = KIND_EDEFAULT;

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
	 * The default value of the '{@link #isSoft() <em>Soft</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSoft()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOFT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSoft() <em>Soft</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSoft()
	 * @generated
	 * @ordered
	 */
	protected boolean soft = SOFT_EDEFAULT;

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
	 * The default value of the '{@link #isDuplicate() <em>Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDuplicate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DUPLICATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDuplicate() <em>Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDuplicate()
	 * @generated
	 * @ordered
	 */
	protected boolean duplicate = DUPLICATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictDetailImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.CONFLICT_DETAIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(ConflictKind newKind) {
		ConflictKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_DETAIL__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDangling() {
		return kind == ConflictKind.DANGLING_CONFLICT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSoft() {
		return soft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSoft(boolean newSoft) {
		boolean oldSoft = soft;
		soft = newSoft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_DETAIL__SOFT, oldSoft, soft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDuplicate() {
		return duplicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDuplicate(boolean newDuplicate) {
		boolean oldDuplicate = duplicate;
		duplicate = newDuplicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_DETAIL__DUPLICATE, oldDuplicate, duplicate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_DETAIL__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeltaModelPackage.CONFLICT_DETAIL__KIND:
				return getKind();
			case DeltaModelPackage.CONFLICT_DETAIL__DANGLING:
				return isDangling();
			case DeltaModelPackage.CONFLICT_DETAIL__SOFT:
				return isSoft();
			case DeltaModelPackage.CONFLICT_DETAIL__CONDITION:
				return isCondition();
			case DeltaModelPackage.CONFLICT_DETAIL__DUPLICATE:
				return isDuplicate();
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
			case DeltaModelPackage.CONFLICT_DETAIL__KIND:
				setKind((ConflictKind)newValue);
				return;
			case DeltaModelPackage.CONFLICT_DETAIL__SOFT:
				setSoft((Boolean)newValue);
				return;
			case DeltaModelPackage.CONFLICT_DETAIL__CONDITION:
				setCondition((Boolean)newValue);
				return;
			case DeltaModelPackage.CONFLICT_DETAIL__DUPLICATE:
				setDuplicate((Boolean)newValue);
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
			case DeltaModelPackage.CONFLICT_DETAIL__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case DeltaModelPackage.CONFLICT_DETAIL__SOFT:
				setSoft(SOFT_EDEFAULT);
				return;
			case DeltaModelPackage.CONFLICT_DETAIL__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case DeltaModelPackage.CONFLICT_DETAIL__DUPLICATE:
				setDuplicate(DUPLICATE_EDEFAULT);
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
			case DeltaModelPackage.CONFLICT_DETAIL__KIND:
				return kind != KIND_EDEFAULT;
			case DeltaModelPackage.CONFLICT_DETAIL__DANGLING:
				return isDangling() != DANGLING_EDEFAULT;
			case DeltaModelPackage.CONFLICT_DETAIL__SOFT:
				return soft != SOFT_EDEFAULT;
			case DeltaModelPackage.CONFLICT_DETAIL__CONDITION:
				return condition != CONDITION_EDEFAULT;
			case DeltaModelPackage.CONFLICT_DETAIL__DUPLICATE:
				return duplicate != DUPLICATE_EDEFAULT;
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
		result.append(", soft: ");
		result.append(soft);
		result.append(", condition: ");
		result.append(condition);
		result.append(", duplicate: ");
		result.append(duplicate);
		result.append(')');
		return result.toString();
	}

} //ConflictDetailImpl
