/**
 */
package org.nasdanika.cdo.flow;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Job Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.flow.FlowPackage#getJobStatus()
 * @model
 * @generated
 */
public enum JobStatus implements Enumerator {
	/**
	 * The '<em><b>PENDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PENDING_VALUE
	 * @generated
	 * @ordered
	 */
	PENDING(0, "PENDING", "PENDING"),

	/**
	 * The '<em><b>RUNNING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNNING_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNING(1, "RUNNING", "RUNNING"),

	/**
	 * The '<em><b>COMPLETED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPLETED_VALUE
	 * @generated
	 * @ordered
	 */
	COMPLETED(2, "COMPLETED", "COMPLETED"), /**
	 * The '<em><b>FAILED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAILED_VALUE
	 * @generated
	 * @ordered
	 */
	FAILED(3, "FAILED", "FAILED"), /**
	 * The '<em><b>ROLLEDBACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLEDBACK_VALUE
	 * @generated
	 * @ordered
	 */
	ROLLEDBACK(4, "ROLLEDBACK", "ROLLEDBACK");

	/**
	 * The '<em><b>PENDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PENDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PENDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PENDING_VALUE = 0;

	/**
	 * The '<em><b>RUNNING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUNNING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNNING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUNNING_VALUE = 1;

	/**
	 * The '<em><b>COMPLETED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPLETED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPLETED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETED_VALUE = 2;

	/**
	 * The '<em><b>FAILED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAILED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAILED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAILED_VALUE = 3;

	/**
	 * The '<em><b>ROLLEDBACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROLLEDBACK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROLLEDBACK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROLLEDBACK_VALUE = 4;

	/**
	 * An array of all the '<em><b>Job Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JobStatus[] VALUES_ARRAY =
		new JobStatus[] {
			PENDING,
			RUNNING,
			COMPLETED,
			FAILED,
			ROLLEDBACK,
		};

	/**
	 * A public read-only list of all the '<em><b>Job Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<JobStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Job Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JobStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Job Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JobStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Job Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobStatus get(int value) {
		switch (value) {
			case PENDING_VALUE: return PENDING;
			case RUNNING_VALUE: return RUNNING;
			case COMPLETED_VALUE: return COMPLETED;
			case FAILED_VALUE: return FAILED;
			case ROLLEDBACK_VALUE: return ROLLEDBACK;
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
	private JobStatus(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	
} //JobStatus
