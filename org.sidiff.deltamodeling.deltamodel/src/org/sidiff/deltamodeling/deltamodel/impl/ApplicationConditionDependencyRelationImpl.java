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

import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Condition Dependency Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl#getSourceDeltaModule <em>Source Delta Module</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl#getTargetDeltaModules <em>Target Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl#getApplicationConditionDependencies <em>Application Condition Dependencies</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionDependencyRelationImpl#isVoid <em>Void</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationConditionDependencyRelationImpl extends RelationImpl implements ApplicationConditionDependencyRelation {
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
	 * The cached value of the '{@link #getTargetDeltaModules() <em>Target Delta Modules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDeltaModules()
	 * @generated
	 * @ordered
	 */
	protected EList<DeltaModule> targetDeltaModules;

	/**
	 * The cached value of the '{@link #getApplicationConditionDependencies() <em>Application Condition Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationConditionDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionDependency> applicationConditionDependencies;

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
	 * The default value of the '{@link #isVoid() <em>Void</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVoid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VOID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVoid() <em>Void</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVoid()
	 * @generated
	 * @ordered
	 */
	protected boolean void_ = VOID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationConditionDependencyRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.APPLICATION_CONDITION_DEPENDENCY_RELATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE, oldSourceDeltaModule, sourceDeltaModule));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE, oldSourceDeltaModule, newSourceDeltaModule);
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
				msgs = ((InternalEObject)sourceDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS, DeltaModule.class, msgs);
			if (newSourceDeltaModule != null)
				msgs = ((InternalEObject)newSourceDeltaModule).eInverseAdd(this, DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS, DeltaModule.class, msgs);
			msgs = basicSetSourceDeltaModule(newSourceDeltaModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE, newSourceDeltaModule, newSourceDeltaModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeltaModule> getTargetDeltaModules() {
		if (targetDeltaModules == null) {
			targetDeltaModules = new EObjectWithInverseResolvingEList.ManyInverse<DeltaModule>(DeltaModule.class, this, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES, DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS);
		}
		return targetDeltaModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionDependency> getApplicationConditionDependencies() {
		if (applicationConditionDependencies == null) {
			applicationConditionDependencies = new EObjectContainmentEList<ApplicationConditionDependency>(ApplicationConditionDependency.class, this, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES);
		}
		return applicationConditionDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		boolean resolved = true;
		for(ApplicationConditionDependency dependency: getApplicationConditionDependencies()) {
			resolved &= dependency.isResolved();
		}
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVoid() {
		return void_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVoid(boolean newVoid) {
		boolean oldVoid = void_;
		void_ = newVoid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__VOID, oldVoid, void_));
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
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE:
				if (sourceDeltaModule != null)
					msgs = ((InternalEObject)sourceDeltaModule).eInverseRemove(this, DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS, DeltaModule.class, msgs);
				return basicSetSourceDeltaModule((DeltaModule)otherEnd, msgs);
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetDeltaModules()).basicAdd(otherEnd, msgs);
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
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE:
				return basicSetSourceDeltaModule(null, msgs);
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES:
				return ((InternalEList<?>)getTargetDeltaModules()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES:
				return ((InternalEList<?>)getApplicationConditionDependencies()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE:
				if (resolve) return getSourceDeltaModule();
				return basicGetSourceDeltaModule();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES:
				return getTargetDeltaModules();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES:
				return getApplicationConditionDependencies();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__RESOLVED:
				return isResolved();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__VOID:
				return isVoid();
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
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE:
				setSourceDeltaModule((DeltaModule)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES:
				getTargetDeltaModules().clear();
				getTargetDeltaModules().addAll((Collection<? extends DeltaModule>)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES:
				getApplicationConditionDependencies().clear();
				getApplicationConditionDependencies().addAll((Collection<? extends ApplicationConditionDependency>)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__VOID:
				setVoid((Boolean)newValue);
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
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE:
				setSourceDeltaModule((DeltaModule)null);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES:
				getTargetDeltaModules().clear();
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES:
				getApplicationConditionDependencies().clear();
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__VOID:
				setVoid(VOID_EDEFAULT);
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
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE:
				return sourceDeltaModule != null;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES:
				return targetDeltaModules != null && !targetDeltaModules.isEmpty();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__APPLICATION_CONDITION_DEPENDENCIES:
				return applicationConditionDependencies != null && !applicationConditionDependencies.isEmpty();
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
			case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__VOID:
				return void_ != VOID_EDEFAULT;
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
		result.append(" (void: ");
		result.append(void_);
		result.append(')');
		return result.toString();
	}

} //ApplicationConditionDependencyRelationImpl
