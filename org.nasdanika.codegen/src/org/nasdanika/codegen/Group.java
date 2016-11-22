/**
 */
package org.nasdanika.codegen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Group of generators from which zero to all can be invoked during the generation process.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Group#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Group#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getGroup()
 * @model
 * @generated
 */
public interface Group<T> extends Generator<T> {
	/**
	 * Returns the value of the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Java code to select which group elements shall be invoked and to customize their contexts. Selector code is a Java method body as shown below
	 * 
	 * ```java
	 * <G extends Generator> Context select(Context context, G group, Generator element) throws Exception {
	 *     // --- Selector code here ---
	 * }
	 * ```
	 * 
	 * where ``G`` is the type of the selector declaring group model element and ``element`` is the group element being evaluated. 
	 * 
	 * If selector returns ``null`` then given group element is not invoked during generation. Otherwise it is invoked with the returned context.
	 * 
	 * Blank selector code is equivalent to ``return context;``
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Selector</em>' attribute.
	 * @see #setSelector(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getGroup_Selector()
	 * @model
	 * @generated
	 */
	String getSelector();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Group#getSelector <em>Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector</em>' attribute.
	 * @see #getSelector()
	 * @generated
	 */
	void setSelector(String value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Generator}&lt;T>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getGroup_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Generator<T>> getElements();

} // Group
