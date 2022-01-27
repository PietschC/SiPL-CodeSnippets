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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Condition Conflict Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl#getSourceDeltaModules <em>Source Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl#getTargetDeltaModule <em>Target Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl#getApplicationConditionConflicts <em>Application Condition Conflicts</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionConflictRelationImpl#isResolved <em>Resolved</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationConditionConflictRelationImpl extends RelationImpl implements ApplicationConditionConflictRelation {
	/**
	 * The cached value of the '{@link #getSourceDeltaModules() <em>Source Delta Modules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDeltaModules()
	 * @generated
	 * @ordered
	 */
	protected EList<DeltaModule> sourceDeltaModules;

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
	 * The cached value of the '{@link #getApplicationConditionConflicts() <em>Application Condition Conflicts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationConditionConflicts()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionConflict> applicationConditionConflicts;

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
	protected ApplicationConditionConflictRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.APPLICATION_CONDITION_CONFLICT_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeltaModule> getSourceDeltaModules() {
		if (sourceDeltaModules == null) {
			sourceDeltaModules = new EObjectWithInverseResolvingEList.ManyInverse<DeltaModule>(DeltaModule.class, this, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES, DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS);
		}
		return sourceDeltaModules;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE, oldTargetDeltaModule, targetDeltaModule));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE, oldTargetDeltaModule, newTargetDeltaModule);
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
				msgs = ((InternalEObject)targetDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS, DeltaModule.class, msgs);
			if (newTargetDeltaModule != null)
				msgs = ((InternalEObject)newTargetDeltaModule).eInverseAdd(this, DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS, DeltaModule.class, msgs);
			msgs = basicSetTargetDeltaModule(newTargetDeltaModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE, newTargetDeltaModule, newTargetDeltaModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionConflict> getApplicationConditionConflicts() {
		if (applicationConditionConflicts == null) {
			applicationConditionConflicts = new EObjectContainmentEList<ApplicationConditionConflict>(ApplicationConditionConflict.class, this, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS);
		}
		return applicationConditionConflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		boolean resolved = true;
		for(ApplicationConditionConflict conflict : getApplicationConditionConflicts()) {
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceDeltaModules()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE:
				if (targetDeltaModule != null)
					msgs = ((InternalEObject)targetDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS, DeltaModule.class, msgs);
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES:
				return ((InternalEList<?>)getSourceDeltaModules()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE:
				return basicSetTargetDeltaModule(null, msgs);
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS:
				return ((InternalEList<?>)getApplicationConditionConflicts()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES:
				return getSourceDeltaModules();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE:
				if (resolve) return getTargetDeltaModule();
				return basicGetTargetDeltaModule();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS:
				return getApplicationConditionConflicts();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__RESOLVED:
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES:
				getSourceDeltaModules().clear();
				getSourceDeltaModules().addAll((Collection<? extends DeltaModule>)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE:
				setTargetDeltaModule((DeltaModule)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS:
				getApplicationConditionConflicts().clear();
				getApplicationConditionConflicts().addAll((Collection<? extends ApplicationConditionConflict>)newValue);
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES:
				getSourceDeltaModules().clear();
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE:
				setTargetDeltaModule((DeltaModule)null);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS:
				getApplicationConditionConflicts().clear();
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
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES:
				return sourceDeltaModules != null && !sourceDeltaModules.isEmpty();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE:
				return targetDeltaModule != null;
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__APPLICATION_CONDITION_CONFLICTS:
				return applicationConditionConflicts != null && !applicationConditionConflicts.isEmpty();
			case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ApplicationConditionConflictRelationImpl
