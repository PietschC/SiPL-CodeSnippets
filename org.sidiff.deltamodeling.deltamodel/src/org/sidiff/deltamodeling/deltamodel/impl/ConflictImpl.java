/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictDetail;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.Duplicate;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl#isSoft <em>Soft</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl#getSourceDeltaAction <em>Source Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl#getTargetDeltaAction <em>Target Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl#getDuplicate <em>Duplicate</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictImpl#getNonResolvableConfig <em>Non Resolvable Config</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConflictImpl extends MinimalEObjectImpl.Container implements Conflict {
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
	 * The default value of the '{@link #isSoft() <em>Soft</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSoft()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOFT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getSourceDeltaAction() <em>Source Delta Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDeltaAction()
	 * @generated
	 * @ordered
	 */
	protected OperationInvocation sourceDeltaAction;

	/**
	 * The cached value of the '{@link #getTargetDeltaAction() <em>Target Delta Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDeltaAction()
	 * @generated
	 * @ordered
	 */
	protected OperationInvocation targetDeltaAction;

	/**
	 * The cached value of the '{@link #getDetails() <em>Details</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictDetail> details;

	/**
	 * The cached value of the '{@link #getDuplicate() <em>Duplicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicate()
	 * @generated
	 * @ordered
	 */
	protected Duplicate duplicate;

	/**
	 * The cached value of the '{@link #getNonResolvableConfig() <em>Non Resolvable Config</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonResolvableConfig()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> nonResolvableConfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.CONFLICT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConflictDetail> getDetails() {
		if (details == null) {
			details = new EObjectContainmentEList<ConflictDetail>(ConflictDetail.class, this, DeltaModelPackage.CONFLICT__DETAILS);
		}
		return details;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationInvocation getSourceDeltaAction() {
		if (sourceDeltaAction != null && sourceDeltaAction.eIsProxy()) {
			InternalEObject oldSourceDeltaAction = (InternalEObject)sourceDeltaAction;
			sourceDeltaAction = (OperationInvocation)eResolveProxy(oldSourceDeltaAction);
			if (sourceDeltaAction != oldSourceDeltaAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.CONFLICT__SOURCE_DELTA_ACTION, oldSourceDeltaAction, sourceDeltaAction));
			}
		}
		return sourceDeltaAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationInvocation basicGetSourceDeltaAction() {
		return sourceDeltaAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceDeltaAction(OperationInvocation newSourceDeltaAction) {
		OperationInvocation oldSourceDeltaAction = sourceDeltaAction;
		sourceDeltaAction = newSourceDeltaAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT__SOURCE_DELTA_ACTION, oldSourceDeltaAction, sourceDeltaAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationInvocation getTargetDeltaAction() {
		if (targetDeltaAction != null && targetDeltaAction.eIsProxy()) {
			InternalEObject oldTargetDeltaAction = (InternalEObject)targetDeltaAction;
			targetDeltaAction = (OperationInvocation)eResolveProxy(oldTargetDeltaAction);
			if (targetDeltaAction != oldTargetDeltaAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.CONFLICT__TARGET_DELTA_ACTION, oldTargetDeltaAction, targetDeltaAction));
			}
		}
		return targetDeltaAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationInvocation basicGetTargetDeltaAction() {
		return targetDeltaAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetDeltaAction(OperationInvocation newTargetDeltaAction) {
		OperationInvocation oldTargetDeltaAction = targetDeltaAction;
		targetDeltaAction = newTargetDeltaAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT__TARGET_DELTA_ACTION, oldTargetDeltaAction, targetDeltaAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duplicate getDuplicate() {
		if (duplicate != null && duplicate.eIsProxy()) {
			InternalEObject oldDuplicate = (InternalEObject)duplicate;
			duplicate = (Duplicate)eResolveProxy(oldDuplicate);
			if (duplicate != oldDuplicate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.CONFLICT__DUPLICATE, oldDuplicate, duplicate));
			}
		}
		return duplicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Duplicate basicGetDuplicate() {
		return duplicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDuplicate(Duplicate newDuplicate, NotificationChain msgs) {
		Duplicate oldDuplicate = duplicate;
		duplicate = newDuplicate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT__DUPLICATE, oldDuplicate, newDuplicate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDuplicate(Duplicate newDuplicate) {
		if (newDuplicate != duplicate) {
			NotificationChain msgs = null;
			if (duplicate != null)
				msgs = ((InternalEObject)duplicate).eInverseRemove(this, DeltaModelPackage.DUPLICATE__CONFLICT, Duplicate.class, msgs);
			if (newDuplicate != null)
				msgs = ((InternalEObject)newDuplicate).eInverseAdd(this, DeltaModelPackage.DUPLICATE__CONFLICT, Duplicate.class, msgs);
			msgs = basicSetDuplicate(newDuplicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT__DUPLICATE, newDuplicate, newDuplicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSoft() {
		return getDetails().stream().allMatch(d -> d.isSoft());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		return getNonResolvableConfig().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getNonResolvableConfig() {
		if (nonResolvableConfig == null) {
			nonResolvableConfig = new EObjectContainmentEList<Variable>(Variable.class, this, DeltaModelPackage.CONFLICT__NON_RESOLVABLE_CONFIG);
		}
		return nonResolvableConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.CONFLICT__DUPLICATE:
				if (duplicate != null)
					msgs = ((InternalEObject)duplicate).eInverseRemove(this, DeltaModelPackage.DUPLICATE__CONFLICT, Duplicate.class, msgs);
				return basicSetDuplicate((Duplicate)otherEnd, msgs);
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
			case DeltaModelPackage.CONFLICT__DETAILS:
				return ((InternalEList<?>)getDetails()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.CONFLICT__DUPLICATE:
				return basicSetDuplicate(null, msgs);
			case DeltaModelPackage.CONFLICT__NON_RESOLVABLE_CONFIG:
				return ((InternalEList<?>)getNonResolvableConfig()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.CONFLICT__RESOLVED:
				return isResolved();
			case DeltaModelPackage.CONFLICT__SOFT:
				return isSoft();
			case DeltaModelPackage.CONFLICT__SOURCE_DELTA_ACTION:
				if (resolve) return getSourceDeltaAction();
				return basicGetSourceDeltaAction();
			case DeltaModelPackage.CONFLICT__TARGET_DELTA_ACTION:
				if (resolve) return getTargetDeltaAction();
				return basicGetTargetDeltaAction();
			case DeltaModelPackage.CONFLICT__DETAILS:
				return getDetails();
			case DeltaModelPackage.CONFLICT__DUPLICATE:
				if (resolve) return getDuplicate();
				return basicGetDuplicate();
			case DeltaModelPackage.CONFLICT__NON_RESOLVABLE_CONFIG:
				return getNonResolvableConfig();
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
			case DeltaModelPackage.CONFLICT__SOURCE_DELTA_ACTION:
				setSourceDeltaAction((OperationInvocation)newValue);
				return;
			case DeltaModelPackage.CONFLICT__TARGET_DELTA_ACTION:
				setTargetDeltaAction((OperationInvocation)newValue);
				return;
			case DeltaModelPackage.CONFLICT__DETAILS:
				getDetails().clear();
				getDetails().addAll((Collection<? extends ConflictDetail>)newValue);
				return;
			case DeltaModelPackage.CONFLICT__DUPLICATE:
				setDuplicate((Duplicate)newValue);
				return;
			case DeltaModelPackage.CONFLICT__NON_RESOLVABLE_CONFIG:
				getNonResolvableConfig().clear();
				getNonResolvableConfig().addAll((Collection<? extends Variable>)newValue);
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
			case DeltaModelPackage.CONFLICT__SOURCE_DELTA_ACTION:
				setSourceDeltaAction((OperationInvocation)null);
				return;
			case DeltaModelPackage.CONFLICT__TARGET_DELTA_ACTION:
				setTargetDeltaAction((OperationInvocation)null);
				return;
			case DeltaModelPackage.CONFLICT__DETAILS:
				getDetails().clear();
				return;
			case DeltaModelPackage.CONFLICT__DUPLICATE:
				setDuplicate((Duplicate)null);
				return;
			case DeltaModelPackage.CONFLICT__NON_RESOLVABLE_CONFIG:
				getNonResolvableConfig().clear();
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
			case DeltaModelPackage.CONFLICT__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
			case DeltaModelPackage.CONFLICT__SOFT:
				return isSoft() != SOFT_EDEFAULT;
			case DeltaModelPackage.CONFLICT__SOURCE_DELTA_ACTION:
				return sourceDeltaAction != null;
			case DeltaModelPackage.CONFLICT__TARGET_DELTA_ACTION:
				return targetDeltaAction != null;
			case DeltaModelPackage.CONFLICT__DETAILS:
				return details != null && !details.isEmpty();
			case DeltaModelPackage.CONFLICT__DUPLICATE:
				return duplicate != null;
			case DeltaModelPackage.CONFLICT__NON_RESOLVABLE_CONFIG:
				return nonResolvableConfig != null && !nonResolvableConfig.isEmpty();
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

		StringBuilder result = new StringBuilder();
		result.append("<");
		result.append(eClass().getName());
		result.append("> ");
		result.append(" (soft: ");
		result.append(isSoft());
		result.append("): ");
		result.append(getSourceDeltaAction().getName());
		result.append(" -> ");
		result.append(getTargetDeltaAction().getName());
		
		return result.toString();
	}

} //ConflictImpl
