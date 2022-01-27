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
import org.sidiff.deltamodeling.deltamodel.DependencyDetail;
import org.sidiff.deltamodeling.deltamodel.TransientEffect;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl#getSourceDeltaAction <em>Source Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl#getTargetDeltaAction <em>Target Delta Action</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl#getTransientEffect <em>Transient Effect</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DependencyImpl#getNonResolvableConfig <em>Non Resolvable Config</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyImpl extends MinimalEObjectImpl.Container implements Dependency {
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
	protected EList<DependencyDetail> details;

	/**
	 * The cached value of the '{@link #getTransientEffect() <em>Transient Effect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientEffect()
	 * @generated
	 * @ordered
	 */
	protected TransientEffect transientEffect;

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
	protected DependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyDetail> getDetails() {
		if (details == null) {
			details = new EObjectContainmentEList<DependencyDetail>(DependencyDetail.class, this, DeltaModelPackage.DEPENDENCY__DETAILS);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.DEPENDENCY__SOURCE_DELTA_ACTION, oldSourceDeltaAction, sourceDeltaAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DEPENDENCY__SOURCE_DELTA_ACTION, oldSourceDeltaAction, sourceDeltaAction));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.DEPENDENCY__TARGET_DELTA_ACTION, oldTargetDeltaAction, targetDeltaAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DEPENDENCY__TARGET_DELTA_ACTION, oldTargetDeltaAction, targetDeltaAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransientEffect getTransientEffect() {
		if (transientEffect != null && transientEffect.eIsProxy()) {
			InternalEObject oldTransientEffect = (InternalEObject)transientEffect;
			transientEffect = (TransientEffect)eResolveProxy(oldTransientEffect);
			if (transientEffect != oldTransientEffect) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT, oldTransientEffect, transientEffect));
			}
		}
		return transientEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransientEffect basicGetTransientEffect() {
		return transientEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransientEffect(TransientEffect newTransientEffect, NotificationChain msgs) {
		TransientEffect oldTransientEffect = transientEffect;
		transientEffect = newTransientEffect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT, oldTransientEffect, newTransientEffect);
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
	public void setTransientEffect(TransientEffect newTransientEffect) {
		if (newTransientEffect != transientEffect) {
			NotificationChain msgs = null;
			if (transientEffect != null)
				msgs = ((InternalEObject)transientEffect).eInverseRemove(this, DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY, TransientEffect.class, msgs);
			if (newTransientEffect != null)
				msgs = ((InternalEObject)newTransientEffect).eInverseAdd(this, DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY, TransientEffect.class, msgs);
			msgs = basicSetTransientEffect(newTransientEffect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT, newTransientEffect, newTransientEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getNonResolvableConfig() {
		if (nonResolvableConfig == null) {
			nonResolvableConfig = new EObjectContainmentEList<Variable>(Variable.class, this, DeltaModelPackage.DEPENDENCY__NON_RESOLVABLE_CONFIG);
		}
		return nonResolvableConfig;
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT:
				if (transientEffect != null)
					msgs = ((InternalEObject)transientEffect).eInverseRemove(this, DeltaModelPackage.TRANSIENT_EFFECT__DEPENDENCY, TransientEffect.class, msgs);
				return basicSetTransientEffect((TransientEffect)otherEnd, msgs);
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
			case DeltaModelPackage.DEPENDENCY__DETAILS:
				return ((InternalEList<?>)getDetails()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT:
				return basicSetTransientEffect(null, msgs);
			case DeltaModelPackage.DEPENDENCY__NON_RESOLVABLE_CONFIG:
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
			case DeltaModelPackage.DEPENDENCY__RESOLVED:
				return isResolved();
			case DeltaModelPackage.DEPENDENCY__SOURCE_DELTA_ACTION:
				if (resolve) return getSourceDeltaAction();
				return basicGetSourceDeltaAction();
			case DeltaModelPackage.DEPENDENCY__TARGET_DELTA_ACTION:
				if (resolve) return getTargetDeltaAction();
				return basicGetTargetDeltaAction();
			case DeltaModelPackage.DEPENDENCY__DETAILS:
				return getDetails();
			case DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT:
				if (resolve) return getTransientEffect();
				return basicGetTransientEffect();
			case DeltaModelPackage.DEPENDENCY__NON_RESOLVABLE_CONFIG:
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
			case DeltaModelPackage.DEPENDENCY__SOURCE_DELTA_ACTION:
				setSourceDeltaAction((OperationInvocation)newValue);
				return;
			case DeltaModelPackage.DEPENDENCY__TARGET_DELTA_ACTION:
				setTargetDeltaAction((OperationInvocation)newValue);
				return;
			case DeltaModelPackage.DEPENDENCY__DETAILS:
				getDetails().clear();
				getDetails().addAll((Collection<? extends DependencyDetail>)newValue);
				return;
			case DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT:
				setTransientEffect((TransientEffect)newValue);
				return;
			case DeltaModelPackage.DEPENDENCY__NON_RESOLVABLE_CONFIG:
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
			case DeltaModelPackage.DEPENDENCY__SOURCE_DELTA_ACTION:
				setSourceDeltaAction((OperationInvocation)null);
				return;
			case DeltaModelPackage.DEPENDENCY__TARGET_DELTA_ACTION:
				setTargetDeltaAction((OperationInvocation)null);
				return;
			case DeltaModelPackage.DEPENDENCY__DETAILS:
				getDetails().clear();
				return;
			case DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT:
				setTransientEffect((TransientEffect)null);
				return;
			case DeltaModelPackage.DEPENDENCY__NON_RESOLVABLE_CONFIG:
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
			case DeltaModelPackage.DEPENDENCY__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
			case DeltaModelPackage.DEPENDENCY__SOURCE_DELTA_ACTION:
				return sourceDeltaAction != null;
			case DeltaModelPackage.DEPENDENCY__TARGET_DELTA_ACTION:
				return targetDeltaAction != null;
			case DeltaModelPackage.DEPENDENCY__DETAILS:
				return details != null && !details.isEmpty();
			case DeltaModelPackage.DEPENDENCY__TRANSIENT_EFFECT:
				return transientEffect != null;
			case DeltaModelPackage.DEPENDENCY__NON_RESOLVABLE_CONFIG:
				return nonResolvableConfig != null && !nonResolvableConfig.isEmpty();
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

} //DependencyImpl
