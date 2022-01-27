/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.deltamodeling.deltamodel.ConflictRelation;
import org.sidiff.deltamodeling.deltamodel.ConstraintGroup;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.DependencyRelation;
import org.sidiff.deltamodeling.deltamodel.DuplicateRelation;
import org.sidiff.deltamodeling.deltamodel.Relation;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.RelationImpl#isConstraintCompliant <em>Constraint Compliant</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.RelationImpl#isDomainCompliant <em>Domain Compliant</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.RelationImpl#isInternal <em>Internal</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.RelationImpl#getUnfulfilledConstraints <em>Unfulfilled Constraints</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.RelationImpl#getUnsatisfiedConfig <em>Unsatisfied Config</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RelationImpl extends MinimalEObjectImpl.Container implements Relation {
	/**
	 * The default value of the '{@link #isConstraintCompliant() <em>Constraint Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstraintCompliant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTRAINT_COMPLIANT_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isDomainCompliant() <em>Domain Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDomainCompliant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DOMAIN_COMPLIANT_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isInternal() <em>Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERNAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #getUnfulfilledConstraints() <em>Unfulfilled Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnfulfilledConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintGroup> unfulfilledConstraints;
	/**
	 * The cached value of the '{@link #getUnsatisfiedConfig() <em>Unsatisfied Config</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsatisfiedConfig()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> unsatisfiedConfig;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDomainCompliant() {
		return getUnsatisfiedConfig().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getUnsatisfiedConfig() {
		if (unsatisfiedConfig == null) {
			unsatisfiedConfig = new EObjectContainmentEList<Variable>(Variable.class, this, DeltaModelPackage.RELATION__UNSATISFIED_CONFIG);
		}
		return unsatisfiedConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConstraintCompliant() {
		return getUnfulfilledConstraints().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConstraintGroup> getUnfulfilledConstraints() {
		if (unfulfilledConstraints == null) {
			unfulfilledConstraints = new EObjectResolvingEList<ConstraintGroup>(ConstraintGroup.class, this, DeltaModelPackage.RELATION__UNFULFILLED_CONSTRAINTS);
		}
		return unfulfilledConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInternal() {
		switch(this.eClass().getClassifierID()) {
			case DeltaModelPackage.CONFLICT_RELATION:
				return ((ConflictRelation)this).getSourceDeltaModule().equals(((ConflictRelation)this).getTargetDeltaModule());
			case DeltaModelPackage.DEPENDENCY_RELATION:
				return ((DependencyRelation)this).getSourceDeltaModule().equals(((DependencyRelation)this).getTargetDeltaModule());
			case DeltaModelPackage.DUPLICATE_RELATION:
				return ((DuplicateRelation)this).getDeltaModules().get(0).equals(((DuplicateRelation)this).getDeltaModules().get(1));
			case DeltaModelPackage.TRANSIENT_EFFECT_RELATION:
				return ((TransientEffectRelationImpl)this).getSourceDeltaModule().equals(((TransientEffectRelationImpl)this).getTargetDeltaModule());
			default:
				return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltaModelPackage.RELATION__UNSATISFIED_CONFIG:
				return ((InternalEList<?>)getUnsatisfiedConfig()).basicRemove(otherEnd, msgs);
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
			case DeltaModelPackage.RELATION__CONSTRAINT_COMPLIANT:
				return isConstraintCompliant();
			case DeltaModelPackage.RELATION__DOMAIN_COMPLIANT:
				return isDomainCompliant();
			case DeltaModelPackage.RELATION__INTERNAL:
				return isInternal();
			case DeltaModelPackage.RELATION__UNFULFILLED_CONSTRAINTS:
				return getUnfulfilledConstraints();
			case DeltaModelPackage.RELATION__UNSATISFIED_CONFIG:
				return getUnsatisfiedConfig();
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
			case DeltaModelPackage.RELATION__UNFULFILLED_CONSTRAINTS:
				getUnfulfilledConstraints().clear();
				getUnfulfilledConstraints().addAll((Collection<? extends ConstraintGroup>)newValue);
				return;
			case DeltaModelPackage.RELATION__UNSATISFIED_CONFIG:
				getUnsatisfiedConfig().clear();
				getUnsatisfiedConfig().addAll((Collection<? extends Variable>)newValue);
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
			case DeltaModelPackage.RELATION__UNFULFILLED_CONSTRAINTS:
				getUnfulfilledConstraints().clear();
				return;
			case DeltaModelPackage.RELATION__UNSATISFIED_CONFIG:
				getUnsatisfiedConfig().clear();
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
			case DeltaModelPackage.RELATION__CONSTRAINT_COMPLIANT:
				return isConstraintCompliant() != CONSTRAINT_COMPLIANT_EDEFAULT;
			case DeltaModelPackage.RELATION__DOMAIN_COMPLIANT:
				return isDomainCompliant() != DOMAIN_COMPLIANT_EDEFAULT;
			case DeltaModelPackage.RELATION__INTERNAL:
				return isInternal() != INTERNAL_EDEFAULT;
			case DeltaModelPackage.RELATION__UNFULFILLED_CONSTRAINTS:
				return unfulfilledConstraints != null && !unfulfilledConstraints.isEmpty();
			case DeltaModelPackage.RELATION__UNSATISFIED_CONFIG:
				return unsatisfiedConfig != null && !unsatisfiedConfig.isEmpty();
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

		return result.toString();
	}
	
} //RelationImpl
