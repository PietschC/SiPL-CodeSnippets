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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl#getSourceDeltaModule <em>Source Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl#getTargetDeltaModule <em>Target Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl#getConflicts <em>Conflicts</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ConflictRelationImpl#isSoft <em>Soft</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConflictRelationImpl extends RelationImpl implements ConflictRelation {
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
	 * The cached value of the '{@link #getSourceDeltaModule() <em>Source Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDeltaModule()
	 * @generated
	 * @ordered
	 */
	protected DeltaModule sourceDeltaModule;

	/**
	 * The cached value of the '{@link #getTargetDeltaModule() <em>Target Delta Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDeltaModule()
	 * @generated
	 * @ordered
	 */
	protected DeltaModule targetDeltaModule;

	/**
	 * The cached value of the '{@link #getConflicts() <em>Conflicts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflicts()
	 * @generated
	 * @ordered
	 */
	protected EList<Conflict> conflicts;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.CONFLICT_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conflict> getConflicts() {
		if (conflicts == null) {
			conflicts = new EObjectContainmentEList<Conflict>(Conflict.class, this, DeltaModelPackage.CONFLICT_RELATION__CONFLICTS);
		}
		return conflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSoft() {
		boolean soft = true;
		for(Conflict conflict : getConflicts()) {
			soft &= conflict.isSoft();
		}
		return soft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModule getSourceDeltaModule() {
		if (sourceDeltaModule != null && sourceDeltaModule.eIsProxy()) {
			InternalEObject oldSourceDeltaModule = (InternalEObject)sourceDeltaModule;
			sourceDeltaModule = (DeltaModule)eResolveProxy(oldSourceDeltaModule);
			if (sourceDeltaModule != oldSourceDeltaModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE, oldSourceDeltaModule, sourceDeltaModule));
			}
		}
		return sourceDeltaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaModule basicGetSourceDeltaModule() {
		return sourceDeltaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceDeltaModule(DeltaModule newSourceDeltaModule, NotificationChain msgs) {
		DeltaModule oldSourceDeltaModule = sourceDeltaModule;
		sourceDeltaModule = newSourceDeltaModule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE, oldSourceDeltaModule, newSourceDeltaModule);
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
	public void setSourceDeltaModule(DeltaModule newSourceDeltaModule) {
		if (newSourceDeltaModule != sourceDeltaModule) {
			NotificationChain msgs = null;
			if (sourceDeltaModule != null)
				msgs = ((InternalEObject)sourceDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS, DeltaModule.class, msgs);
			if (newSourceDeltaModule != null)
				msgs = ((InternalEObject)newSourceDeltaModule).eInverseAdd(this, DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS, DeltaModule.class, msgs);
			msgs = basicSetSourceDeltaModule(newSourceDeltaModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE, newSourceDeltaModule, newSourceDeltaModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModule getTargetDeltaModule() {
		if (targetDeltaModule != null && targetDeltaModule.eIsProxy()) {
			InternalEObject oldTargetDeltaModule = (InternalEObject)targetDeltaModule;
			targetDeltaModule = (DeltaModule)eResolveProxy(oldTargetDeltaModule);
			if (targetDeltaModule != oldTargetDeltaModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE, oldTargetDeltaModule, targetDeltaModule));
			}
		}
		return targetDeltaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaModule basicGetTargetDeltaModule() {
		return targetDeltaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetDeltaModule(DeltaModule newTargetDeltaModule, NotificationChain msgs) {
		DeltaModule oldTargetDeltaModule = targetDeltaModule;
		targetDeltaModule = newTargetDeltaModule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE, oldTargetDeltaModule, newTargetDeltaModule);
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
	public void setTargetDeltaModule(DeltaModule newTargetDeltaModule) {
		if (newTargetDeltaModule != targetDeltaModule) {
			NotificationChain msgs = null;
			if (targetDeltaModule != null)
				msgs = ((InternalEObject)targetDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS, DeltaModule.class, msgs);
			if (newTargetDeltaModule != null)
				msgs = ((InternalEObject)newTargetDeltaModule).eInverseAdd(this, DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS, DeltaModule.class, msgs);
			msgs = basicSetTargetDeltaModule(newTargetDeltaModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE, newTargetDeltaModule, newTargetDeltaModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		boolean resolved = true;
		for(Conflict conflict : getConflicts()) {
			resolved &= conflict.isResolved();
		}
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE:
				if (sourceDeltaModule != null)
					msgs = ((InternalEObject)sourceDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS, DeltaModule.class, msgs);
				return basicSetSourceDeltaModule((DeltaModule)otherEnd, msgs);
			case DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE:
				if (targetDeltaModule != null)
					msgs = ((InternalEObject)targetDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS, DeltaModule.class, msgs);
				return basicSetTargetDeltaModule((DeltaModule)otherEnd, msgs);
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
			case DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE:
				return basicSetSourceDeltaModule(null, msgs);
			case DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE:
				return basicSetTargetDeltaModule(null, msgs);
			case DeltaModelPackage.CONFLICT_RELATION__CONFLICTS:
				return ((InternalEList<?>)getConflicts()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.CONFLICT_RELATION__RESOLVED:
				return isResolved();
			case DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE:
				if (resolve) return getSourceDeltaModule();
				return basicGetSourceDeltaModule();
			case DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE:
				if (resolve) return getTargetDeltaModule();
				return basicGetTargetDeltaModule();
			case DeltaModelPackage.CONFLICT_RELATION__CONFLICTS:
				return getConflicts();
			case DeltaModelPackage.CONFLICT_RELATION__SOFT:
				return isSoft();
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
			case DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE:
				setSourceDeltaModule((DeltaModule)newValue);
				return;
			case DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE:
				setTargetDeltaModule((DeltaModule)newValue);
				return;
			case DeltaModelPackage.CONFLICT_RELATION__CONFLICTS:
				getConflicts().clear();
				getConflicts().addAll((Collection<? extends Conflict>)newValue);
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
			case DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE:
				setSourceDeltaModule((DeltaModule)null);
				return;
			case DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE:
				setTargetDeltaModule((DeltaModule)null);
				return;
			case DeltaModelPackage.CONFLICT_RELATION__CONFLICTS:
				getConflicts().clear();
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
			case DeltaModelPackage.CONFLICT_RELATION__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
			case DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE:
				return sourceDeltaModule != null;
			case DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE:
				return targetDeltaModule != null;
			case DeltaModelPackage.CONFLICT_RELATION__CONFLICTS:
				return conflicts != null && !conflicts.isEmpty();
			case DeltaModelPackage.CONFLICT_RELATION__SOFT:
				return isSoft() != SOFT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(getSourceDeltaModule().getName());
		result.append(" -> ");
		result.append(getTargetDeltaModule().getName());
		
		return result.toString();
	}
} //ConflictRelationImpl
