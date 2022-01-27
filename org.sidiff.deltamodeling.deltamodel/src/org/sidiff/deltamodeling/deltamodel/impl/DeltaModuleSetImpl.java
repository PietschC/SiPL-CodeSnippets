/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.CoreModel;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.DeltaModuleSet;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;
import org.sidiff.deltamodeling.deltamodel.Relation;
import org.sidiff.deltamodeling.deltamodel.TransientEffectRelation;
import org.sidiff.deltamodeling.deltamodel.analysis.IRelationAnalysisEngine;
import org.sidiff.deltamodeling.deltamodel.analysis.impl.RelationAnalysisEngine;
import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.Variable;
import org.sidiff.superimposition.SuperimposedModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delta Module Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getAnalysisEngine <em>Analysis Engine</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getSuperimposedModel <em>Superimposed Model</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getCoreModel <em>Core Model</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getDeltaModules <em>Delta Modules</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getApplicationOrderConstraints <em>Application Order Constraints</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getAllRelations <em>All Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getApplicationConditionDependencyRelations <em>Application Condition Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getDependencyRelations <em>Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getApplicationConditionConflictRelations <em>Application Condition Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getConflictRelations <em>Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getDuplicateRelations <em>Duplicate Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleSetImpl#getTransientEffectRelation <em>Transient Effect Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeltaModuleSetImpl extends MinimalEObjectImpl.Container implements DeltaModuleSet {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAnalysisEngine() <em>Analysis Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisEngine()
	 * @generated
	 * @ordered
	 */
	protected static final IRelationAnalysisEngine ANALYSIS_ENGINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnalysisEngine() <em>Analysis Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisEngine()
	 * @generated
	 * @ordered
	 */
	protected IRelationAnalysisEngine analysisEngine = ANALYSIS_ENGINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureModel() <em>Feature Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureModel()
	 * @generated
	 * @ordered
	 */
	protected Formula featureModel;

	/**
	 * The cached value of the '{@link #getSuperimposedModel() <em>Superimposed Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperimposedModel()
	 * @generated
	 * @ordered
	 */
	protected SuperimposedModel superimposedModel;

	/**
	 * The cached value of the '{@link #getCoreModel() <em>Core Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreModel()
	 * @generated
	 * @ordered
	 */
	protected CoreModel coreModel;

	/**
	 * The cached value of the '{@link #getDeltaModules() <em>Delta Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeltaModules()
	 * @generated
	 * @ordered
	 */
	protected EList<DeltaModule> deltaModules;

	/**
	 * The cached value of the '{@link #getApplicationOrderConstraints() <em>Application Order Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationOrderConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintGroup> applicationOrderConstraints;

	/**
	 * The cached value of the '{@link #getApplicationConditionDependencyRelations() <em>Application Condition Dependency Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationConditionDependencyRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionDependencyRelation> applicationConditionDependencyRelations;

	/**
	 * The cached value of the '{@link #getDependencyRelations() <em>Dependency Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyRelation> dependencyRelations;

	/**
	 * The cached value of the '{@link #getApplicationConditionConflictRelations() <em>Application Condition Conflict Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationConditionConflictRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionConflictRelation> applicationConditionConflictRelations;

	/**
	 * The cached value of the '{@link #getConflictRelations() <em>Conflict Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflictRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictRelation> conflictRelations;

	/**
	 * The cached value of the '{@link #getDuplicateRelations() <em>Duplicate Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicateRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<DuplicateRelation> duplicateRelations;

	/**
	 * The cached value of the '{@link #getTransientEffectRelation() <em>Transient Effect Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransientEffectRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientEffectRelation> transientEffectRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeltaModuleSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.DELTA_MODULE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE_SET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Formula getFeatureModel() {
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatureModel(Formula newFeatureModel, NotificationChain msgs) {
		Formula oldFeatureModel = featureModel;
		featureModel = newFeatureModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL, oldFeatureModel, newFeatureModel);
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
	public void setFeatureModel(Formula newFeatureModel) {
		if (newFeatureModel != featureModel) {
			NotificationChain msgs = null;
			if (featureModel != null)
				msgs = ((InternalEObject)featureModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL, null, msgs);
			if (newFeatureModel != null)
				msgs = ((InternalEObject)newFeatureModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL, null, msgs);
			msgs = basicSetFeatureModel(newFeatureModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL, newFeatureModel, newFeatureModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperimposedModel getSuperimposedModel() {
		return superimposedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperimposedModel(SuperimposedModel newSuperimposedModel, NotificationChain msgs) {
		SuperimposedModel oldSuperimposedModel = superimposedModel;
		superimposedModel = newSuperimposedModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL, oldSuperimposedModel, newSuperimposedModel);
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
	public void setSuperimposedModel(SuperimposedModel newSuperimposedModel) {
		if (newSuperimposedModel != superimposedModel) {
			NotificationChain msgs = null;
			if (superimposedModel != null)
				msgs = ((InternalEObject)superimposedModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL, null, msgs);
			if (newSuperimposedModel != null)
				msgs = ((InternalEObject)newSuperimposedModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL, null, msgs);
			msgs = basicSetSuperimposedModel(newSuperimposedModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL, newSuperimposedModel, newSuperimposedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeltaModule> getDeltaModules() {
		if (deltaModules == null) {
			deltaModules = new EObjectContainmentEList<DeltaModule>(DeltaModule.class, this, DeltaModelPackage.DELTA_MODULE_SET__DELTA_MODULES);
		}
		return deltaModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConflictRelation> getConflictRelations() {
		if (conflictRelations == null) {
			conflictRelations = new EObjectContainmentEList<ConflictRelation>(ConflictRelation.class, this, DeltaModelPackage.DELTA_MODULE_SET__CONFLICT_RELATIONS);
		}
		return conflictRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyRelation> getDependencyRelations() {
		if (dependencyRelations == null) {
			dependencyRelations = new EObjectContainmentEList<DependencyRelation>(DependencyRelation.class, this, DeltaModelPackage.DELTA_MODULE_SET__DEPENDENCY_RELATIONS);
		}
		return dependencyRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionConflictRelation> getApplicationConditionConflictRelations() {
		if (applicationConditionConflictRelations == null) {
			applicationConditionConflictRelations = new EObjectContainmentEList<ApplicationConditionConflictRelation>(ApplicationConditionConflictRelation.class, this, DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS);
		}
		return applicationConditionConflictRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DuplicateRelation> getDuplicateRelations() {
		if (duplicateRelations == null) {
			duplicateRelations = new EObjectContainmentEList<DuplicateRelation>(DuplicateRelation.class, this, DeltaModelPackage.DELTA_MODULE_SET__DUPLICATE_RELATIONS);
		}
		return duplicateRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransientEffectRelation> getTransientEffectRelation() {
		if (transientEffectRelation == null) {
			transientEffectRelation = new EObjectContainmentEList<TransientEffectRelation>(TransientEffectRelation.class, this, DeltaModelPackage.DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION);
		}
		return transientEffectRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Relation> getAllRelations() {
		EList<Relation> allRelations = new BasicEList<Relation>();
		allRelations.addAll(getApplicationConditionConflictRelations());
		allRelations.addAll(getConflictRelations());
		allRelations.addAll(getApplicationConditionDependencyRelations());
		allRelations.addAll(getDependencyRelations());
		allRelations.addAll(getDuplicateRelations());
		allRelations.addAll(getTransientEffectRelation());
						
		return new EcoreEList.UnmodifiableEList<Relation>(this,DeltaModelPackage.Literals.DELTA_MODULE_SET__ALL_RELATIONS, allRelations.size(), allRelations.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionDependencyRelation> getApplicationConditionDependencyRelations() {
		if (applicationConditionDependencyRelations == null) {
			applicationConditionDependencyRelations = new EObjectContainmentEList<ApplicationConditionDependencyRelation>(ApplicationConditionDependencyRelation.class, this, DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS);
		}
		return applicationConditionDependencyRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CoreModel getCoreModel() {
		return coreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoreModel(CoreModel newCoreModel, NotificationChain msgs) {
		CoreModel oldCoreModel = coreModel;
		coreModel = newCoreModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL, oldCoreModel, newCoreModel);
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
	public void setCoreModel(CoreModel newCoreModel) {
		if (newCoreModel != coreModel) {
			NotificationChain msgs = null;
			if (coreModel != null)
				msgs = ((InternalEObject)coreModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL, null, msgs);
			if (newCoreModel != null)
				msgs = ((InternalEObject)newCoreModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL, null, msgs);
			msgs = basicSetCoreModel(newCoreModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL, newCoreModel, newCoreModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConstraintGroup> getApplicationOrderConstraints() {
		if (applicationOrderConstraints == null) {
			applicationOrderConstraints = new EObjectContainmentEList<ConstraintGroup>(ConstraintGroup.class, this, DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS);
		}
		return applicationOrderConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IRelationAnalysisEngine getAnalysisEngine() {
		if(this.analysisEngine == null){
			this.analysisEngine = new RelationAnalysisEngine(this);
		}
		return this.analysisEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeltaModule getDeltaModule(final String deltaModuleName) {
		for(DeltaModule deltaModule : getDeltaModules()){
			if(deltaModule.getName().equals(deltaModuleName)){
				return deltaModule;
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
	public EList<DeltaModule> getDeltaModules(final Configuration config) {
		Configuration configuration = FormulaFactory.eINSTANCE.createConfiguration();
		for (DeltaModule deltaModule : this.getDeltaModules()) {
			Formula applicationCondition = deltaModule.getApplicationCondition();
			for (Variable applicationConditionVariable : applicationCondition.getVariables()) {
				for (Variable configurationVariable : config.getVariableAssignments().keySet()) {
					if (applicationConditionVariable.getName().equals(configurationVariable.getName())) {
						configuration.getVariableAssignments().put(applicationConditionVariable,
							config.getVariableAssignments().get(configurationVariable));
					}
				}
			}
		}
		EList<DeltaModule> deltaModules = new BasicEList<DeltaModule>();
		DeltaModule coreModule = getCoreModel().getCoreModule();
		for (DeltaModule deltaModule : getDeltaModules()) {
			if (!deltaModule.equals(coreModule) && deltaModule.getDelta() != null && deltaModule.getApplicationCondition().eval(configuration)) {
				deltaModules.add(deltaModule);
			}
		}
		return deltaModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL:
				return basicSetFeatureModel(null, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL:
				return basicSetSuperimposedModel(null, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL:
				return basicSetCoreModel(null, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__DELTA_MODULES:
				return ((InternalEList<?>)getDeltaModules()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS:
				return ((InternalEList<?>)getApplicationOrderConstraints()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return ((InternalEList<?>)getApplicationConditionDependencyRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__DEPENDENCY_RELATIONS:
				return ((InternalEList<?>)getDependencyRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return ((InternalEList<?>)getApplicationConditionConflictRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__CONFLICT_RELATIONS:
				return ((InternalEList<?>)getConflictRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__DUPLICATE_RELATIONS:
				return ((InternalEList<?>)getDuplicateRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION:
				return ((InternalEList<?>)getTransientEffectRelation()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.DELTA_MODULE_SET__NAME:
				return getName();
			case DeltaModelPackage.DELTA_MODULE_SET__ANALYSIS_ENGINE:
				return getAnalysisEngine();
			case DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL:
				return getFeatureModel();
			case DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL:
				return getSuperimposedModel();
			case DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL:
				return getCoreModel();
			case DeltaModelPackage.DELTA_MODULE_SET__DELTA_MODULES:
				return getDeltaModules();
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS:
				return getApplicationOrderConstraints();
			case DeltaModelPackage.DELTA_MODULE_SET__ALL_RELATIONS:
				return getAllRelations();
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return getApplicationConditionDependencyRelations();
			case DeltaModelPackage.DELTA_MODULE_SET__DEPENDENCY_RELATIONS:
				return getDependencyRelations();
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return getApplicationConditionConflictRelations();
			case DeltaModelPackage.DELTA_MODULE_SET__CONFLICT_RELATIONS:
				return getConflictRelations();
			case DeltaModelPackage.DELTA_MODULE_SET__DUPLICATE_RELATIONS:
				return getDuplicateRelations();
			case DeltaModelPackage.DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION:
				return getTransientEffectRelation();
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
			case DeltaModelPackage.DELTA_MODULE_SET__NAME:
				setName((String)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL:
				setFeatureModel((Formula)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL:
				setSuperimposedModel((SuperimposedModel)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__DELTA_MODULES:
				getDeltaModules().clear();
				getDeltaModules().addAll((Collection<? extends DeltaModule>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS:
				getApplicationOrderConstraints().clear();
				getApplicationOrderConstraints().addAll((Collection<? extends ConstraintGroup>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				getApplicationConditionDependencyRelations().clear();
				getApplicationConditionDependencyRelations().addAll((Collection<? extends ApplicationConditionDependencyRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__DEPENDENCY_RELATIONS:
				getDependencyRelations().clear();
				getDependencyRelations().addAll((Collection<? extends DependencyRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS:
				getApplicationConditionConflictRelations().clear();
				getApplicationConditionConflictRelations().addAll((Collection<? extends ApplicationConditionConflictRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__CONFLICT_RELATIONS:
				getConflictRelations().clear();
				getConflictRelations().addAll((Collection<? extends ConflictRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__DUPLICATE_RELATIONS:
				getDuplicateRelations().clear();
				getDuplicateRelations().addAll((Collection<? extends DuplicateRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION:
				getTransientEffectRelation().clear();
				getTransientEffectRelation().addAll((Collection<? extends TransientEffectRelation>)newValue);
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
			case DeltaModelPackage.DELTA_MODULE_SET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL:
				setFeatureModel((Formula)null);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL:
				setSuperimposedModel((SuperimposedModel)null);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL:
				setCoreModel((CoreModel)null);
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__DELTA_MODULES:
				getDeltaModules().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS:
				getApplicationOrderConstraints().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				getApplicationConditionDependencyRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__DEPENDENCY_RELATIONS:
				getDependencyRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS:
				getApplicationConditionConflictRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__CONFLICT_RELATIONS:
				getConflictRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__DUPLICATE_RELATIONS:
				getDuplicateRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION:
				getTransientEffectRelation().clear();
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
			case DeltaModelPackage.DELTA_MODULE_SET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DeltaModelPackage.DELTA_MODULE_SET__ANALYSIS_ENGINE:
				return ANALYSIS_ENGINE_EDEFAULT == null ? analysisEngine != null : !ANALYSIS_ENGINE_EDEFAULT.equals(analysisEngine);
			case DeltaModelPackage.DELTA_MODULE_SET__FEATURE_MODEL:
				return featureModel != null;
			case DeltaModelPackage.DELTA_MODULE_SET__SUPERIMPOSED_MODEL:
				return superimposedModel != null;
			case DeltaModelPackage.DELTA_MODULE_SET__CORE_MODEL:
				return coreModel != null;
			case DeltaModelPackage.DELTA_MODULE_SET__DELTA_MODULES:
				return deltaModules != null && !deltaModules.isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_ORDER_CONSTRAINTS:
				return applicationOrderConstraints != null && !applicationOrderConstraints.isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__ALL_RELATIONS:
				return !getAllRelations().isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return applicationConditionDependencyRelations != null && !applicationConditionDependencyRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__DEPENDENCY_RELATIONS:
				return dependencyRelations != null && !dependencyRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return applicationConditionConflictRelations != null && !applicationConditionConflictRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__CONFLICT_RELATIONS:
				return conflictRelations != null && !conflictRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__DUPLICATE_RELATIONS:
				return duplicateRelations != null && !duplicateRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE_SET__TRANSIENT_EFFECT_RELATION:
				return transientEffectRelation != null && !transientEffectRelation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DeltaModelPackage.DELTA_MODULE_SET___GET_DELTA_MODULE__STRING:
				return getDeltaModule((String)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE_SET___GET_DELTA_MODULES__CONFIGURATION:
				return getDeltaModules((Configuration)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", analysisEngine: ");
		result.append(analysisEngine);
		result.append(')');
		return result.toString();
	}

} //DeltaModuleSetImpl
