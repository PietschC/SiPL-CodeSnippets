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

import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.TransientEffect;
import org.sidiff.deltamodeling.deltamodel.TransientEffectDetail;

import org.sidiff.difference.asymmetric.OperationInvocation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transient Effect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl#getSourceDeltaAction <em>Source Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl#getTargetDeltaAction <em>Target Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.TransientEffectImpl#getDependency <em>Dependency</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransientEffectImpl extends MinimalEObjectImpl.Container implements TransientEffect {
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
	protected EList<TransientEffectDetail> details;

	/**
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency dependency;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransientEffectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.TRANSIENT_EFFECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransientEffectDetail> getDetails() {
		if (details == null) {
			details = new EObjectContainmentEList<TransientEffectDetail>(TransientEffectDetail.class, this, DeltaModelPackage.TRANSIENT_EFFECT__DETAILS);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.TRANSIENT_EFFECT__SOURCE_DELTA_ACTION, oldSourceDeltaAction, sourceDeltaAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.TRANSIENT_EFFECT__SOURCE_DELTA_ACTION, oldSourceDeltaAction, sourceDeltaAction));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.TRANSIENT_EFFECT__TARGET_DELTA_ACTION, oldTargetDeltaAction, targetDeltaAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.TRANSIENT_EFFECT__TARGET_DELTA_ACTION, oldTargetDeltaAction, targetDeltaAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Dependency getDependency() {
		if (dependency != null && dependency.eIsProxy()) {
			InternalEObject oldDependency = (InternalEObject)dependency;
			dependency = (Dependency)eResolveProxy(oldDependency);
			if (dependency != oldDependency) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY, oldDependency, dependency));
			}
		}
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetDependency() {
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependency(Dependency newDependency, NotificationChain msgs) {
		Dependency oldDependency = dependency;
		dependency = newDependency;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY, oldDependency, newDependency);
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
	public void setDependency(Dependency newDependency) {
		if (newDependency != dependency) {
			NotificationChain msgs = null;
			if (dependency != null)
				msgs = ((InternalEObject)dependency).eInverseRemove(this, DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT, Dependency.class, msgs);
			if (newDependency != null)
				msgs = ((InternalEObject)newDependency).eInverseAdd(this, DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT, Dependency.class, msgs);
			msgs = basicSetDependency(newDependency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY, newDependency, newDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY:
				if (dependency != null)
					msgs = ((InternalEObject)dependency).eInverseRemove(this, DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT, Dependency.class, msgs);
				return basicSetDependency((Dependency)otherEnd, msgs);
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
			case DeltaModelPackage.TRANSIENT_EFFECT__DETAILS:
				return ((InternalEList<?>)getDetails()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY:
				return basicSetDependency(null, msgs);
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
			case DeltaModelPackage.TRANSIENT_EFFECT__SOURCE_DELTA_ACTION:
				if (resolve) return getSourceDeltaAction();
				return basicGetSourceDeltaAction();
			case DeltaModelPackage.TRANSIENT_EFFECT__TARGET_DELTA_ACTION:
				if (resolve) return getTargetDeltaAction();
				return basicGetTargetDeltaAction();
			case DeltaModelPackage.TRANSIENT_EFFECT__DETAILS:
				return getDetails();
			case DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY:
				if (resolve) return getDependency();
				return basicGetDependency();
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
			case DeltaModelPackage.TRANSIENT_EFFECT__SOURCE_DELTA_ACTION:
				setSourceDeltaAction((OperationInvocation)newValue);
				return;
			case DeltaModelPackage.TRANSIENT_EFFECT__TARGET_DELTA_ACTION:
				setTargetDeltaAction((OperationInvocation)newValue);
				return;
			case DeltaModelPackage.TRANSIENT_EFFECT__DETAILS:
				getDetails().clear();
				getDetails().addAll((Collection<? extends TransientEffectDetail>)newValue);
				return;
			case DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY:
				setDependency((Dependency)newValue);
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
			case DeltaModelPackage.TRANSIENT_EFFECT__SOURCE_DELTA_ACTION:
				setSourceDeltaAction((OperationInvocation)null);
				return;
			case DeltaModelPackage.TRANSIENT_EFFECT__TARGET_DELTA_ACTION:
				setTargetDeltaAction((OperationInvocation)null);
				return;
			case DeltaModelPackage.TRANSIENT_EFFECT__DETAILS:
				getDetails().clear();
				return;
			case DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY:
				setDependency((Dependency)null);
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
			case DeltaModelPackage.TRANSIENT_EFFECT__SOURCE_DELTA_ACTION:
				return sourceDeltaAction != null;
			case DeltaModelPackage.TRANSIENT_EFFECT__TARGET_DELTA_ACTION:
				return targetDeltaAction != null;
			case DeltaModelPackage.TRANSIENT_EFFECT__DETAILS:
				return details != null && !details.isEmpty();
			case DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY:
				return dependency != null;
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
		result.append(getSourceDeltaAction().getName());
		result.append(" -> ");
		result.append(getTargetDeltaAction().getName());
		
		return result.toString();
	}

} //TransientEffectImpl
