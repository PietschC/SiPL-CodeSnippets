/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.deltamodeling.deltamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transient Effect Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sidiff.deltamodeling.deltamodel.DeltaModelPackage#getTransientEffectKind()
 * @model
 * @generated
 */
public enum TransientEffectKind implements Enumerator {
	/**
	 * The '<em><b>Create Delete</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_DELETE(0, "CreateDelete", "CreateDelete"),

	/**
	 * The '<em><b>Delete Create</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_CREATE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_CREATE(1, "DeleteCreate", "DeleteCreate"),

	/**
	 * The '<em><b>Change Change</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_CHANGE_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_CHANGE(2, "ChangeChange", "ChangeChange");

	/**
	 * The '<em><b>Create Delete</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CREATE DELETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CREATE_DELETE
	 * @model name="CreateDelete"
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_DELETE_VALUE = 0;

	/**
	 * The '<em><b>Delete Create</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELETE CREATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELETE_CREATE
	 * @model name="DeleteCreate"
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_CREATE_VALUE = 1;

	/**
	 * The '<em><b>Change Change</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_CHANGE
	 * @model name="ChangeChange"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_CHANGE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Transient Effect Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransientEffectKind[] VALUES_ARRAY =
		new TransientEffectKind[] {
			CREATE_DELETE,
			DELETE_CREATE,
			CHANGE_CHANGE,
		};

	/**
	 * A public read-only list of all the '<em><b>Transient Effect Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransientEffectKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transient Effect Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransientEffectKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransientEffectKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transient Effect Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransientEffectKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransientEffectKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transient Effect Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransientEffectKind get(int value) {
		switch (value) {
			case CREATE_DELETE_VALUE: return CREATE_DELETE;
			case DELETE_CREATE_VALUE: return DELETE_CREATE;
			case CHANGE_CHANGE_VALUE: return CHANGE_CHANGE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TransientEffectKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TransientEffectKind
