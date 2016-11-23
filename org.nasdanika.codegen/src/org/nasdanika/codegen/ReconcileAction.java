/**
 */
package org.nasdanika.codegen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Reconcile Action</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Defines an action to take if project/resource with a given name already exists in the workspace.
 * <!-- end-model-doc -->
 * @see org.nasdanika.codegen.CodegenPackage#getReconcileAction()
 * @model
 * @generated
 */
public enum ReconcileAction implements Enumerator {
	/**
	 * The '<em><b>Keep</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEEP_VALUE
	 * @generated
	 * @ordered
	 */
	KEEP(0, "Keep", "Keep"),

	/**
	 * The '<em><b>Append</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPEND_VALUE
	 * @generated
	 * @ordered
	 */
	APPEND(1, "Append", "Append"), /**
	 * The '<em><b>Merge</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MERGE_VALUE
	 * @generated
	 * @ordered
	 */
	MERGE(2, "Merge", "Merge"),

	/**
	 * The '<em><b>Overwrite</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERWRITE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERWRITE(3, "Overwrite", "Overwrite"),

	/**
	 * The '<em><b>Cancel</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANCEL_VALUE
	 * @generated
	 * @ordered
	 */
	CANCEL(4, "Cancel", "Cancel");

	/**
	 * The '<em><b>Keep</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Keep</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Discard the generated content and keep the original or skip the generation step altogether.
	 * <!-- end-model-doc -->
	 * @see #KEEP
	 * @model name="Keep"
	 * @generated
	 * @ordered
	 */
	public static final int KEEP_VALUE = 0;

	/**
	 * The '<em><b>Append</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Append</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Append the new content to the existing. For project and directories it means
	 * adding new resources next to the existing, which is semantically equivalent to merging.
	 * <!-- end-model-doc -->
	 * @see #APPEND
	 * @model name="Append"
	 * @generated
	 * @ordered
	 */
	public static final int APPEND_VALUE = 1;

	/**
	 * The '<em><b>Merge</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Merge</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Merge new and existing content, typically using a merger service for files. 
	 * For projects and directories merge is equivalent to append.
	 * <!-- end-model-doc -->
	 * @see #MERGE
	 * @model name="Merge"
	 * @generated
	 * @ordered
	 */
	public static final int MERGE_VALUE = 2;

	/**
	 * The '<em><b>Overwrite</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Overwrite</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Replace existing content with the new one. 
	 * For directories and projects it means deleting the project/directory
	 * and re-creating with the new content.
	 * 
	 * If the generation context contains ``overwrite-predicate`` property, then the value
	 * of the property is cast to ``java.util.function.Predicate`` and its ``test()`` method is invoked.
	 * If the return value is ``true`` then the resource/project get overwritten, if ``false`` it is left intact (same as ``Keep``).
	 * 
	 * The predicate may throw ``org.eclipse.core.runtime.OperationCanceledException`` to cancel generation (same as ``Cancel``).
	 * 
	 * Clients may create overwrite predicates which open an overwrite confirmation dialog to solicit overwrite decision from the user. 
	 * <!-- end-model-doc -->
	 * @see #OVERWRITE
	 * @model name="Overwrite"
	 * @generated
	 * @ordered
	 */
	public static final int OVERWRITE_VALUE = 3;

	/**
	 * The '<em><b>Cancel</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cancel</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Throw ``OperationCancelledException`` if resource/project already exists.
	 * <!-- end-model-doc -->
	 * @see #CANCEL
	 * @model name="Cancel"
	 * @generated
	 * @ordered
	 */
	public static final int CANCEL_VALUE = 4;

	/**
	 * An array of all the '<em><b>Reconcile Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ReconcileAction[] VALUES_ARRAY =
		new ReconcileAction[] {
			KEEP,
			APPEND,
			MERGE,
			OVERWRITE,
			CANCEL,
		};

	/**
	 * A public read-only list of all the '<em><b>Reconcile Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ReconcileAction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Reconcile Action</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReconcileAction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReconcileAction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reconcile Action</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReconcileAction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReconcileAction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reconcile Action</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReconcileAction get(int value) {
		switch (value) {
			case KEEP_VALUE: return KEEP;
			case APPEND_VALUE: return APPEND;
			case MERGE_VALUE: return MERGE;
			case OVERWRITE_VALUE: return OVERWRITE;
			case CANCEL_VALUE: return CANCEL;
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
	private ReconcileAction(int value, String name, String literal) {
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
	
} //ReconcileAction
