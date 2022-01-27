/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionConflict;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionDependency;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionKind;
import org.sidiff.deltamodeling.deltamodel.ApplicationConditionMatch;
import org.sidiff.deltamodeling.deltamodel.Conflict;
import org.sidiff.deltamodeling.deltamodel.DeltaModelPackage;
import org.sidiff.deltamodeling.deltamodel.Dependency;
import org.sidiff.formula.Variable;
import org.sidiff.formula.util.FormulaUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Application Condition Match</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl#getConditionID <em>Condition ID</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl#getMatchID <em>Match ID</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.deltamodeling.deltamodel.impl.ApplicationConditionMatchImpl#getNonResolvableConfig <em>Non Resolvable Config</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ApplicationConditionMatchImpl extends MinimalEObjectImpl.Container
		implements ApplicationConditionMatch {
	/**
	 * The default value of the '{@link #getConditionID() <em>Condition ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConditionID()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConditionID() <em>Condition ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConditionID()
	 * @generated
	 * @ordered
	 */
	protected String conditionID = CONDITION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMatchID() <em>Match ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMatchID()
	 * @generated
	 * @ordered
	 */
	protected static final String MATCH_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMatchID() <em>Match ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMatchID()
	 * @generated
	 * @ordered
	 */
	protected String matchID = MATCH_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ApplicationConditionKind KIND_EDEFAULT = ApplicationConditionKind.PAC;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ApplicationConditionKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationConditionMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltaModelPackage.Literals.APPLICATION_CONDITION_MATCH;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConditionID() {
		return conditionID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConditionID(String newConditionID) {
		String oldConditionID = conditionID;
		conditionID = newConditionID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_MATCH__CONDITION_ID, oldConditionID, conditionID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMatchID() {
		return matchID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatchID(String newMatchID) {
		String oldMatchID = matchID;
		matchID = newMatchID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_MATCH__MATCH_ID, oldMatchID, matchID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationConditionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(ApplicationConditionKind newKind) {
		ApplicationConditionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltaModelPackage.APPLICATION_CONDITION_MATCH__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		return getNonResolvableConfig().isEmpty();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getNonResolvableConfig() {
		EList<Variable> variables = new BasicEList<Variable>();
		switch (this.eClass().getClassifierID()) {
		case DeltaModelPackage.APPLICATION_CONDITION_CONFLICT:
			ApplicationConditionConflict applicationConditionConflict = (ApplicationConditionConflict) this;
			for (Conflict conflict : applicationConditionConflict.getContributions()) {
				if (conflict.isResolved()) {
					if (applicationConditionConflict.getKind() == ApplicationConditionKind.NAC) {
						return new BasicEList<Variable>();
					}
				} else {
					for (Variable variable : conflict.getNonResolvableConfig()) {
						if (variables.stream().noneMatch(v -> v.getName().equals(variable.getName()))) {
							variables.add(FormulaUtil.createVariable(variable.getName()));
						}
					}
				}
			}
			break;
		case DeltaModelPackage.APPLICATION_CONDITION_DEPENDENCY:
			ApplicationConditionDependency applicationConditionDependency = (ApplicationConditionDependency) this;
			for (Dependency dependency : applicationConditionDependency.getContributions()) {
				if (dependency.isResolved()) {
					if (applicationConditionDependency.getKind() == ApplicationConditionKind.NAC) {
						return new BasicEList<Variable>();
					}
				} else {
					for (Variable variable : dependency.getNonResolvableConfig()) {
						if (variables.stream().noneMatch(v -> v.getName().equals(variable.getName()))) {
							variables.add(FormulaUtil.createVariable(variable.getName()));
						}
					}
				}
			}
			break;
		default:
			break;
		}
		
		return variables;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__CONDITION_ID:
				return getConditionID();
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__MATCH_ID:
				return getMatchID();
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__KIND:
				return getKind();
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__RESOLVED:
				return isResolved();
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__NON_RESOLVABLE_CONFIG:
				return getNonResolvableConfig();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__CONDITION_ID:
				setConditionID((String)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__MATCH_ID:
				setMatchID((String)newValue);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__KIND:
				setKind((ApplicationConditionKind)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__CONDITION_ID:
				setConditionID(CONDITION_ID_EDEFAULT);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__MATCH_ID:
				setMatchID(MATCH_ID_EDEFAULT);
				return;
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__KIND:
				setKind(KIND_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__CONDITION_ID:
				return CONDITION_ID_EDEFAULT == null ? conditionID != null : !CONDITION_ID_EDEFAULT.equals(conditionID);
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__MATCH_ID:
				return MATCH_ID_EDEFAULT == null ? matchID != null : !MATCH_ID_EDEFAULT.equals(matchID);
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__KIND:
				return kind != KIND_EDEFAULT;
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
			case DeltaModelPackage.APPLICATION_CONDITION_MATCH__NON_RESOLVABLE_CONFIG:
				return !getNonResolvableConfig().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (conditionID: ");
		result.append(conditionID);
		result.append(", matchID: ");
		result.append(matchID);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} // ApplicationConditionMatchImpl
