/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.deltamodeling.deltamodel.CoreModel;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl#getConfig <em>Config</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.CoreModelImpl#getCoreModule <em>Core Module</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CoreModelImpl extends MinimalEObjectImpl.Container implements CoreModel {
	/**
	 * The default value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected static final Resource RESOURCE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfig() <em>Config</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfig()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> config;

	/**
	 * The cached value of the '{@link #getCoreModule() <em>Core Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreModule()
	 * @generated
	 * @ordered
	 */
	protected DeltaModule coreModule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.CORE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource getResource() {
		if(uri != null && !uri.isEmpty()) {
			URI uri_ = URI.createURI(uri);
			ResourceSet resourceSet = this.eResource().getResourceSet();
			if(resourceSet.getURIConverter().exists(uri_, null)) {
				return this.eResource().getResourceSet().getResource(uri_, true);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CORE_MODEL__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getConfig() {
		if (config == null) {
			config = new EObjectContainmentEList<Variable>(Variable.class, this, DeltaModelPackage.CORE_MODEL__CONFIG);
		}
		return config;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModule getCoreModule() {
		if (coreModule != null && coreModule.eIsProxy()) {
			InternalEObject oldCoreModule = (InternalEObject)coreModule;
			coreModule = (DeltaModule)eResolveProxy(oldCoreModule);
			if (coreModule != oldCoreModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.CORE_MODEL__CORE_MODULE, oldCoreModule, coreModule));
			}
		}
		return coreModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaModule basicGetCoreModule() {
		return coreModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCoreModule(DeltaModule newCoreModule) {
		DeltaModule oldCoreModule = coreModule;
		coreModule = newCoreModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.CORE_MODEL__CORE_MODULE, oldCoreModule, coreModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.CORE_MODEL__CONFIG:
				return ((InternalEList<?>)getConfig()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.CORE_MODEL__RESOURCE:
				return getResource();
			case DeltaModelPackage.CORE_MODEL__URI:
				return getUri();
			case DeltaModelPackage.CORE_MODEL__CONFIG:
				return getConfig();
			case DeltaModelPackage.CORE_MODEL__CORE_MODULE:
				if (resolve) return getCoreModule();
				return basicGetCoreModule();
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
			case DeltaModelPackage.CORE_MODEL__URI:
				setUri((String)newValue);
				return;
			case DeltaModelPackage.CORE_MODEL__CONFIG:
				getConfig().clear();
				getConfig().addAll((Collection<? extends Variable>)newValue);
				return;
			case DeltaModelPackage.CORE_MODEL__CORE_MODULE:
				setCoreModule((DeltaModule)newValue);
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
			case DeltaModelPackage.CORE_MODEL__URI:
				setUri(URI_EDEFAULT);
				return;
			case DeltaModelPackage.CORE_MODEL__CONFIG:
				getConfig().clear();
				return;
			case DeltaModelPackage.CORE_MODEL__CORE_MODULE:
				setCoreModule((DeltaModule)null);
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
			case DeltaModelPackage.CORE_MODEL__RESOURCE:
				return RESOURCE_EDEFAULT == null ? getResource() != null : !RESOURCE_EDEFAULT.equals(getResource());
			case DeltaModelPackage.CORE_MODEL__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case DeltaModelPackage.CORE_MODEL__CONFIG:
				return config != null && !config.isEmpty();
			case DeltaModelPackage.CORE_MODEL__CORE_MODULE:
				return coreModule != null;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //CoreModelImpl
