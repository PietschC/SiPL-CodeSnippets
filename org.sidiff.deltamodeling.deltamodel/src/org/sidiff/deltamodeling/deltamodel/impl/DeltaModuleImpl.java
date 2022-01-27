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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependencyRelation;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DeltaModule;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.Duplicate;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;
import org.sidiff.deltamodeling.deltamodel.TransientEffect;
import org.sidiff.deltamodeling.deltamodel.TransientEffectRelation;
import org.sidiff.deltamodeling.deltamodel.util.DeltaModelUtils;
import org.sidiff.difference.asymmetric.AsymmetricDifference;
import org.sidiff.difference.asymmetric.OperationInvocation;
import org.sidiff.formula.Formula;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delta Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getApplicationCondition <em>Application Condition</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getAfter <em>After</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getDelta <em>Delta</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getIncomingApplicationConditionDependencyRelations <em>Incoming Application Condition Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getOutgoingApplicationConditionDependencyRelations <em>Outgoing Application Condition Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getIncomingDependencyRelations <em>Incoming Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getOutgoingDependencyRelations <em>Outgoing Dependency Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getIncomingApplicationConditionConflictRelations <em>Incoming Application Condition Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getOutgoingApplicationConditionConflictRelations <em>Outgoing Application Condition Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getIncomingConflictRelations <em>Incoming Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getOutgoingConflictRelations <em>Outgoing Conflict Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getDuplicateRelations <em>Duplicate Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getIncomingTransientEffectRelations <em>Incoming Transient Effect Relations</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.DeltaModuleImpl#getOutgoingTransientEffectRelations <em>Outgoing Transient Effect Relations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeltaModuleImpl extends MinimalEObjectImpl.Container implements DeltaModule {
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
	 * The cached value of the '{@link #getApplicationCondition() <em>Application Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationCondition()
	 * @generated
	 * @ordered
	 */
	protected Formula applicationCondition;

	/**
	 * The cached value of the '{@link #getDelta() <em>Delta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelta()
	 * @generated
	 * @ordered
	 */
	protected AsymmetricDifference delta;

	/**
	 * The cached value of the '{@link #getIncomingApplicationConditionDependencyRelations() <em>Incoming Application Condition Dependency Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingApplicationConditionDependencyRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionDependencyRelation> incomingApplicationConditionDependencyRelations;

	/**
	 * The cached value of the '{@link #getOutgoingApplicationConditionDependencyRelations() <em>Outgoing Application Condition Dependency Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingApplicationConditionDependencyRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionDependencyRelation> outgoingApplicationConditionDependencyRelations;

	/**
	 * The cached value of the '{@link #getIncomingDependencyRelations() <em>Incoming Dependency Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingDependencyRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyRelation> incomingDependencyRelations;

	/**
	 * The cached value of the '{@link #getOutgoingDependencyRelations() <em>Outgoing Dependency Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingDependencyRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyRelation> outgoingDependencyRelations;

	/**
	 * The cached value of the '{@link #getIncomingApplicationConditionConflictRelations() <em>Incoming Application Condition Conflict Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingApplicationConditionConflictRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionConflictRelation> incomingApplicationConditionConflictRelations;

	/**
	 * The cached value of the '{@link #getOutgoingApplicationConditionConflictRelations() <em>Outgoing Application Condition Conflict Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingApplicationConditionConflictRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationConditionConflictRelation> outgoingApplicationConditionConflictRelations;

	/**
	 * The cached value of the '{@link #getIncomingConflictRelations() <em>Incoming Conflict Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingConflictRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictRelation> incomingConflictRelations;

	/**
	 * The cached value of the '{@link #getOutgoingConflictRelations() <em>Outgoing Conflict Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingConflictRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictRelation> outgoingConflictRelations;

	/**
	 * The cached value of the '{@link #getDuplicateRelations() <em>Duplicate Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicateRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<DuplicateRelation> duplicateRelations;

	/**
	 * The cached value of the '{@link #getIncomingTransientEffectRelations() <em>Incoming Transient Effect Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingTransientEffectRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientEffectRelation> incomingTransientEffectRelations;

	/**
	 * The cached value of the '{@link #getOutgoingTransientEffectRelations() <em>Outgoing Transient Effect Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransientEffectRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientEffectRelation> outgoingTransientEffectRelations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeltaModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.DELTA_MODULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Formula getApplicationCondition() {
		return applicationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplicationCondition(Formula newApplicationCondition, NotificationChain msgs) {
		Formula oldApplicationCondition = applicationCondition;
		applicationCondition = newApplicationCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION, oldApplicationCondition, newApplicationCondition);
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
	public void setApplicationCondition(Formula newApplicationCondition) {
		if (newApplicationCondition != applicationCondition) {
			NotificationChain msgs = null;
			if (applicationCondition != null)
				msgs = ((InternalEObject)applicationCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION, null, msgs);
			if (newApplicationCondition != null)
				msgs = ((InternalEObject)newApplicationCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION, null, msgs);
			msgs = basicSetApplicationCondition(newApplicationCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION, newApplicationCondition, newApplicationCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConflictRelation> getOutgoingConflictRelations() {
		if (outgoingConflictRelations == null) {
			outgoingConflictRelations = new EObjectWithInverseResolvingEList<ConflictRelation>(ConflictRelation.class, this, DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS, DeltaModelPackage.CONFLICT_RELATION__SOURCE_DELTA_MODULE);
		}
		return outgoingConflictRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConflictRelation> getIncomingConflictRelations() {
		if (incomingConflictRelations == null) {
			incomingConflictRelations = new EObjectWithInverseResolvingEList<ConflictRelation>(ConflictRelation.class, this, DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS, DeltaModelPackage.CONFLICT_RELATION__TARGET_DELTA_MODULE);
		}
		return incomingConflictRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyRelation> getOutgoingDependencyRelations() {
		if (outgoingDependencyRelations == null) {
			outgoingDependencyRelations = new EObjectWithInverseResolvingEList<DependencyRelation>(DependencyRelation.class, this, DeltaModelPackage.DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS, DeltaModelPackage.DEPENDENCY_RELATION__SOURCE_DELTA_MODULE);
		}
		return outgoingDependencyRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionConflictRelation> getIncomingApplicationConditionConflictRelations() {
		if (incomingApplicationConditionConflictRelations == null) {
			incomingApplicationConditionConflictRelations = new EObjectWithInverseResolvingEList<ApplicationConditionConflictRelation>(ApplicationConditionConflictRelation.class, this, DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__TARGET_DELTA_MODULE);
		}
		return incomingApplicationConditionConflictRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionConflictRelation> getOutgoingApplicationConditionConflictRelations() {
		if (outgoingApplicationConditionConflictRelations == null) {
			outgoingApplicationConditionConflictRelations = new EObjectWithInverseResolvingEList.ManyInverse<ApplicationConditionConflictRelation>(ApplicationConditionConflictRelation.class, this, DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS, DeltaModelPackage.APPLICATION_CONDITION_CONFLICT_RELATION__SOURCE_DELTA_MODULES);
		}
		return outgoingApplicationConditionConflictRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyRelation> getIncomingDependencyRelations() {
		if (incomingDependencyRelations == null) {
			incomingDependencyRelations = new EObjectWithInverseResolvingEList<DependencyRelation>(DependencyRelation.class, this, DeltaModelPackage.DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS, DeltaModelPackage.DEPENDENCY_RELATION__TARGET_DELTA_MODULE);
		}
		return incomingDependencyRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DuplicateRelation> getDuplicateRelations() {
		if (duplicateRelations == null) {
			duplicateRelations = new EObjectWithInverseResolvingEList.ManyInverse<DuplicateRelation>(DuplicateRelation.class, this, DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS, DeltaModelPackage.DUPLICATE_RELATION__DELTA_MODULES);
		}
		return duplicateRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransientEffectRelation> getOutgoingTransientEffectRelations() {
		if (outgoingTransientEffectRelations == null) {
			outgoingTransientEffectRelations = new EObjectWithInverseResolvingEList<TransientEffectRelation>(TransientEffectRelation.class, this, DeltaModelPackage.DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS, DeltaModelPackage.TRANSIENT_EFFECT_RELATION__SOURCE_DELTA_MODULE);
		}
		return outgoingTransientEffectRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransientEffectRelation> getIncomingTransientEffectRelations() {
		if (incomingTransientEffectRelations == null) {
			incomingTransientEffectRelations = new EObjectWithInverseResolvingEList<TransientEffectRelation>(TransientEffectRelation.class, this, DeltaModelPackage.DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS, DeltaModelPackage.TRANSIENT_EFFECT_RELATION__TARGET_DELTA_MODULE);
		}
		return incomingTransientEffectRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConstraintGroup> getAfter() {
		EList<ConstraintGroup> after = new EObjectContainmentEList<ConstraintGroup>(ConstraintGroup.class, this, DeltaModelPackage.DELTA_MODULE__AFTER);
		after.addAll(DeltaModelUtils.getAfter(this));
		
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConstraintGroup> getBefore() {
		EList<ConstraintGroup> before = new EObjectContainmentEList<ConstraintGroup>(ConstraintGroup.class, this, DeltaModelPackage.DELTA_MODULE__BEFORE);
		before.addAll(DeltaModelUtils.getBefore(this));
		
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AsymmetricDifference getDelta() {
		if (delta != null && delta.eIsProxy()) {
			InternalEObject oldDelta = (InternalEObject)delta;
			delta = (AsymmetricDifference)eResolveProxy(oldDelta);
			if (delta != oldDelta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeltaModelPackage.DELTA_MODULE__DELTA, oldDelta, delta));
			}
		}
		return delta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsymmetricDifference basicGetDelta() {
		return delta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDelta(AsymmetricDifference newDelta) {
		AsymmetricDifference oldDelta = delta;
		delta = newDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.DELTA_MODULE__DELTA, oldDelta, delta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionDependencyRelation> getIncomingApplicationConditionDependencyRelations() {
		if (incomingApplicationConditionDependencyRelations == null) {
			incomingApplicationConditionDependencyRelations = new EObjectWithInverseResolvingEList.ManyInverse<ApplicationConditionDependencyRelation>(ApplicationConditionDependencyRelation.class, this, DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__TARGET_DELTA_MODULES);
		}
		return incomingApplicationConditionDependencyRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionDependencyRelation> getOutgoingApplicationConditionDependencyRelations() {
		if (outgoingApplicationConditionDependencyRelations == null) {
			outgoingApplicationConditionDependencyRelations = new EObjectWithInverseResolvingEList<ApplicationConditionDependencyRelation>(ApplicationConditionDependencyRelation.class, this, DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS, DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY_RELATION__SOURCE_DELTA_MODULE);
		}
		return outgoingApplicationConditionDependencyRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeltaModule> getAllPredecessors() {
		return DeltaModelUtils.getAllPredecessors(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeltaModule> getAllSuccessors() {
		return DeltaModelUtils.getAllSuccessors(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conflict> getOutgoingConflicts(final OperationInvocation deltaAction) {
		EList<Conflict> outgoingConflicts = new BasicEList<Conflict>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (ConflictRelation conflictRelation : getOutgoingConflictRelations()) {
				for (Conflict conflict : conflictRelation.getConflicts()) {
					if (conflict.getSourceDeltaAction().equals(deltaAction)) {
						outgoingConflicts.add(conflict);
					}
				}
			}
		}
		return outgoingConflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conflict> getIncomingConflicts(final OperationInvocation deltaAction) {
		EList<Conflict> incomingConflicts = new BasicEList<Conflict>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (ConflictRelation conflictRelation : getIncomingConflictRelations()) {
				for (Conflict conflict : conflictRelation.getConflicts()) {
					if (conflict.getTargetDeltaAction().equals(deltaAction)) {
						incomingConflicts.add(conflict);
					}
				}
			}
		}
		return incomingConflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getOutgoingDependencies(final OperationInvocation deltaAction) {
		EList<Dependency> outgoingDependencies = new BasicEList<Dependency>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (DependencyRelation dependencyRelation : getOutgoingDependencyRelations()) {
				for (Dependency dependency : dependencyRelation.getDependencies()) {
					if (dependency.getSourceDeltaAction().equals(deltaAction)) {
						outgoingDependencies.add(dependency);
					}
				}
			}
		}
		return outgoingDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getIncomingDependencies(final OperationInvocation deltaAction) {
		EList<Dependency> incomingDependencies = new BasicEList<Dependency>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (DependencyRelation dependencyRelation : getIncomingDependencyRelations()) {
				for (Dependency dependency : dependencyRelation.getDependencies()) {
					if (dependency.getTargetDeltaAction().equals(deltaAction)) {
						incomingDependencies.add(dependency);
					}
				}
			}
		}
		return incomingDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Duplicate> getDuplicates(final OperationInvocation deltaAction) {
		EList<Duplicate> duplicates = new BasicEList<Duplicate>();
		if(getDelta().getOperationInvocations().contains(deltaAction)) {
			for(DuplicateRelation duplicateRelation : getDuplicateRelations()) {
				for(Duplicate duplicate : duplicateRelation.getDuplicates()) {
					if(duplicate.getDeltaActions().contains(deltaAction)) {
						duplicates.add(duplicate);
					}
				}
			}
		}
		return duplicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransientEffect> getOutgoingTransientEffects(final OperationInvocation deltaAction) {
		EList<TransientEffect> outgoingTransientEffects = new BasicEList<TransientEffect>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (TransientEffectRelation transientEffectRelation : getOutgoingTransientEffectRelations()) {
				for (TransientEffect transientEffect : transientEffectRelation.getTransientEffects()) {
					if (transientEffect.getSourceDeltaAction().equals(deltaAction)) {
						outgoingTransientEffects.add(transientEffect);
					}
				}
			}
		}
		return outgoingTransientEffects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionDependency> getIncomingApplicationConditionDependencies(final OperationInvocation deltaAction, final ApplicationConditionKind kind) {
		EList<ApplicationConditionDependency> incomingApplicationConditionDependencies = new BasicEList<ApplicationConditionDependency>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (ApplicationConditionDependencyRelation dependencyRelationGroup : getIncomingApplicationConditionDependencyRelations()) {
				for(ApplicationConditionDependency applicationConditionDependency : dependencyRelationGroup.getApplicationConditionDependencies()) {
					if(applicationConditionDependency.getKind() == kind && applicationConditionDependency.getContributions().stream().anyMatch(d -> d.getTargetDeltaAction().equals(deltaAction))) {
						incomingApplicationConditionDependencies.add(applicationConditionDependency);
					}
				}
			}
		}
		return incomingApplicationConditionDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionDependency> getOutgoingApplicationConditionDependencies(final OperationInvocation deltaAction, final ApplicationConditionKind kind) {
		EList<ApplicationConditionDependency> outgoingApplicationConditionDependencies = new BasicEList<ApplicationConditionDependency>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (ApplicationConditionDependencyRelation applicationConditionDependencyRelation : getOutgoingApplicationConditionDependencyRelations()) {
				for(ApplicationConditionDependency applicationConditionDependency : applicationConditionDependencyRelation.getApplicationConditionDependencies()) {
					if(applicationConditionDependency.getKind() == kind && applicationConditionDependency.getContributions().stream().anyMatch(d -> d.getSourceDeltaAction().equals(deltaAction))) {
						outgoingApplicationConditionDependencies.add(applicationConditionDependency);
					}
				}
			}
		}
		return outgoingApplicationConditionDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionConflict> getIncomingApplicationConditionConflicts(final OperationInvocation deltaAction, final ApplicationConditionKind kind) {
		EList<ApplicationConditionConflict> incomingApplicationConflicts = new BasicEList<ApplicationConditionConflict>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for(ApplicationConditionConflictRelation applicationConditionConflictRelation: getIncomingApplicationConditionConflictRelations()) {
				for(ApplicationConditionConflict applicationConditionConflict: applicationConditionConflictRelation.getApplicationConditionConflicts()) {
					if(applicationConditionConflict.getKind() == kind && applicationConditionConflict.getContributions().stream().anyMatch(c -> c.getTargetDeltaAction().equals(deltaAction))) {
						incomingApplicationConflicts.add(applicationConditionConflict);
					}
				}
			}
		}
		return incomingApplicationConflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApplicationConditionConflict> getOutgoingApplicationConditionConflicts(final OperationInvocation deltaAction, final ApplicationConditionKind kind) {
		EList<ApplicationConditionConflict> outgoingApplicationConditionConflict = new BasicEList<ApplicationConditionConflict>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for(ApplicationConditionConflictRelation applicationConditionConflictRelation : getOutgoingApplicationConditionConflictRelations()) {
				for(ApplicationConditionConflict applicationConditionConflict : applicationConditionConflictRelation.getApplicationConditionConflicts()) {
					if(applicationConditionConflict.getKind() == kind && applicationConditionConflict.getContributions().stream().anyMatch(c -> c.getSourceDeltaAction().equals(deltaAction))) {
						outgoingApplicationConditionConflict.add(applicationConditionConflict);
					}
				}
			}
		}
		return outgoingApplicationConditionConflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransientEffect> getIncomingTransientEffects(final OperationInvocation deltaAction) {
		EList<TransientEffect> incomingTransientEffects = new BasicEList<TransientEffect>();
		if (getDelta().getOperationInvocations().contains(deltaAction)) {
			for (TransientEffectRelation transientEffectRelation : getIncomingTransientEffectRelations()) {
				for (TransientEffect transientEffect : transientEffectRelation.getTransientEffects()) {
					if (transientEffect.getTargetDeltaAction().equals(deltaAction)) {
						incomingTransientEffects.add(transientEffect);
					}
				}
			}
		}
		return incomingTransientEffects;
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
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingApplicationConditionDependencyRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingApplicationConditionDependencyRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingDependencyRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingDependencyRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingApplicationConditionConflictRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingApplicationConditionConflictRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingConflictRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingConflictRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDuplicateRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransientEffectRelations()).basicAdd(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransientEffectRelations()).basicAdd(otherEnd, msgs);
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
			case DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION:
				return basicSetApplicationCondition(null, msgs);
			case DeltaModelPackage.DELTA_MODULE__BEFORE:
				return ((InternalEList<?>)getBefore()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__AFTER:
				return ((InternalEList<?>)getAfter()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return ((InternalEList<?>)getIncomingApplicationConditionDependencyRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return ((InternalEList<?>)getOutgoingApplicationConditionDependencyRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS:
				return ((InternalEList<?>)getIncomingDependencyRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS:
				return ((InternalEList<?>)getOutgoingDependencyRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return ((InternalEList<?>)getIncomingApplicationConditionConflictRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return ((InternalEList<?>)getOutgoingApplicationConditionConflictRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS:
				return ((InternalEList<?>)getIncomingConflictRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS:
				return ((InternalEList<?>)getOutgoingConflictRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS:
				return ((InternalEList<?>)getDuplicateRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS:
				return ((InternalEList<?>)getIncomingTransientEffectRelations()).basicRemove(otherEnd, msgs);
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS:
				return ((InternalEList<?>)getOutgoingTransientEffectRelations()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.DELTA_MODULE__NAME:
				return getName();
			case DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION:
				return getApplicationCondition();
			case DeltaModelPackage.DELTA_MODULE__BEFORE:
				return getBefore();
			case DeltaModelPackage.DELTA_MODULE__AFTER:
				return getAfter();
			case DeltaModelPackage.DELTA_MODULE__DELTA:
				if (resolve) return getDelta();
				return basicGetDelta();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return getIncomingApplicationConditionDependencyRelations();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return getOutgoingApplicationConditionDependencyRelations();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS:
				return getIncomingDependencyRelations();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS:
				return getOutgoingDependencyRelations();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return getIncomingApplicationConditionConflictRelations();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return getOutgoingApplicationConditionConflictRelations();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS:
				return getIncomingConflictRelations();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS:
				return getOutgoingConflictRelations();
			case DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS:
				return getDuplicateRelations();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS:
				return getIncomingTransientEffectRelations();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS:
				return getOutgoingTransientEffectRelations();
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
			case DeltaModelPackage.DELTA_MODULE__NAME:
				setName((String)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION:
				setApplicationCondition((Formula)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__DELTA:
				setDelta((AsymmetricDifference)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				getIncomingApplicationConditionDependencyRelations().clear();
				getIncomingApplicationConditionDependencyRelations().addAll((Collection<? extends ApplicationConditionDependencyRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				getOutgoingApplicationConditionDependencyRelations().clear();
				getOutgoingApplicationConditionDependencyRelations().addAll((Collection<? extends ApplicationConditionDependencyRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS:
				getIncomingDependencyRelations().clear();
				getIncomingDependencyRelations().addAll((Collection<? extends DependencyRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS:
				getOutgoingDependencyRelations().clear();
				getOutgoingDependencyRelations().addAll((Collection<? extends DependencyRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				getIncomingApplicationConditionConflictRelations().clear();
				getIncomingApplicationConditionConflictRelations().addAll((Collection<? extends ApplicationConditionConflictRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				getOutgoingApplicationConditionConflictRelations().clear();
				getOutgoingApplicationConditionConflictRelations().addAll((Collection<? extends ApplicationConditionConflictRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS:
				getIncomingConflictRelations().clear();
				getIncomingConflictRelations().addAll((Collection<? extends ConflictRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS:
				getOutgoingConflictRelations().clear();
				getOutgoingConflictRelations().addAll((Collection<? extends ConflictRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS:
				getDuplicateRelations().clear();
				getDuplicateRelations().addAll((Collection<? extends DuplicateRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS:
				getIncomingTransientEffectRelations().clear();
				getIncomingTransientEffectRelations().addAll((Collection<? extends TransientEffectRelation>)newValue);
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS:
				getOutgoingTransientEffectRelations().clear();
				getOutgoingTransientEffectRelations().addAll((Collection<? extends TransientEffectRelation>)newValue);
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
			case DeltaModelPackage.DELTA_MODULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION:
				setApplicationCondition((Formula)null);
				return;
			case DeltaModelPackage.DELTA_MODULE__DELTA:
				setDelta((AsymmetricDifference)null);
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				getIncomingApplicationConditionDependencyRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				getOutgoingApplicationConditionDependencyRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS:
				getIncomingDependencyRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS:
				getOutgoingDependencyRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				getIncomingApplicationConditionConflictRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				getOutgoingApplicationConditionConflictRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS:
				getIncomingConflictRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS:
				getOutgoingConflictRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS:
				getDuplicateRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS:
				getIncomingTransientEffectRelations().clear();
				return;
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS:
				getOutgoingTransientEffectRelations().clear();
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
			case DeltaModelPackage.DELTA_MODULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DeltaModelPackage.DELTA_MODULE__APPLICATION_CONDITION:
				return applicationCondition != null;
			case DeltaModelPackage.DELTA_MODULE__BEFORE:
				return !getBefore().isEmpty();
			case DeltaModelPackage.DELTA_MODULE__AFTER:
				return !getAfter().isEmpty();
			case DeltaModelPackage.DELTA_MODULE__DELTA:
				return delta != null;
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return incomingApplicationConditionDependencyRelations != null && !incomingApplicationConditionDependencyRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_DEPENDENCY_RELATIONS:
				return outgoingApplicationConditionDependencyRelations != null && !outgoingApplicationConditionDependencyRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_DEPENDENCY_RELATIONS:
				return incomingDependencyRelations != null && !incomingDependencyRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_DEPENDENCY_RELATIONS:
				return outgoingDependencyRelations != null && !outgoingDependencyRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return incomingApplicationConditionConflictRelations != null && !incomingApplicationConditionConflictRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_APPLICATION_CONDITION_CONFLICT_RELATIONS:
				return outgoingApplicationConditionConflictRelations != null && !outgoingApplicationConditionConflictRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_CONFLICT_RELATIONS:
				return incomingConflictRelations != null && !incomingConflictRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_CONFLICT_RELATIONS:
				return outgoingConflictRelations != null && !outgoingConflictRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__DUPLICATE_RELATIONS:
				return duplicateRelations != null && !duplicateRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__INCOMING_TRANSIENT_EFFECT_RELATIONS:
				return incomingTransientEffectRelations != null && !incomingTransientEffectRelations.isEmpty();
			case DeltaModelPackage.DELTA_MODULE__OUTGOING_TRANSIENT_EFFECT_RELATIONS:
				return outgoingTransientEffectRelations != null && !outgoingTransientEffectRelations.isEmpty();
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
			case DeltaModelPackage.DELTA_MODULE___GET_ALL_PREDECESSORS:
				return getAllPredecessors();
			case DeltaModelPackage.DELTA_MODULE___GET_ALL_SUCCESSORS:
				return getAllSuccessors();
			case DeltaModelPackage.DELTA_MODULE___GET_INCOMING_DEPENDENCIES__OPERATIONINVOCATION:
				return getIncomingDependencies((OperationInvocation)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE___GET_OUTGOING_DEPENDENCIES__OPERATIONINVOCATION:
				return getOutgoingDependencies((OperationInvocation)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE___GET_INCOMING_CONFLICTS__OPERATIONINVOCATION:
				return getIncomingConflicts((OperationInvocation)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE___GET_OUTGOING_CONFLICTS__OPERATIONINVOCATION:
				return getOutgoingConflicts((OperationInvocation)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE___GET_DUPLICATES__OPERATIONINVOCATION:
				return getDuplicates((OperationInvocation)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE___GET_INCOMING_TRANSIENT_EFFECTS__OPERATIONINVOCATION:
				return getIncomingTransientEffects((OperationInvocation)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE___GET_OUTGOING_TRANSIENT_EFFECTS__OPERATIONINVOCATION:
				return getOutgoingTransientEffects((OperationInvocation)arguments.get(0));
			case DeltaModelPackage.DELTA_MODULE___GET_INCOMING_APPLICATION_CONDITION_DEPENDENCIES__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND:
				return getIncomingApplicationConditionDependencies((OperationInvocation)arguments.get(0), (ApplicationConditionKind)arguments.get(1));
			case DeltaModelPackage.DELTA_MODULE___GET_OUTGOING_APPLICATION_CONDITION_DEPENDENCIES__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND:
				return getOutgoingApplicationConditionDependencies((OperationInvocation)arguments.get(0), (ApplicationConditionKind)arguments.get(1));
			case DeltaModelPackage.DELTA_MODULE___GET_INCOMING_APPLICATION_CONDITION_CONFLICTS__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND:
				return getIncomingApplicationConditionConflicts((OperationInvocation)arguments.get(0), (ApplicationConditionKind)arguments.get(1));
			case DeltaModelPackage.DELTA_MODULE___GET_OUTGOING_APPLICATION_CONDITION_CONFLICTS__OPERATIONINVOCATION_APPLICATIONCONDITIONKIND:
				return getOutgoingApplicationConditionConflicts((OperationInvocation)arguments.get(0), (ApplicationConditionKind)arguments.get(1));
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
		result.append(')');
		return result.toString();
	}

} //DeltaModuleImpl
