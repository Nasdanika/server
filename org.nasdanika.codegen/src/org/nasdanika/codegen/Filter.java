/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * .
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Filter#getGenerator <em>Generator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getFilter()
 * @model abstract="true"
 * @generated
 */
public interface Filter<T> extends Generator<T> {
	/**
	 * Returns the value of the '<em><b>Generator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * .
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generator</em>' containment reference.
	 * @see #setGenerator(Generator)
	 * @see org.nasdanika.codegen.CodegenPackage#getFilter_Generator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Generator<T> getGenerator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Filter#getGenerator <em>Generator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator</em>' containment reference.
	 * @see #getGenerator()
	 * @generated
	 */
	void setGenerator(Generator<T> value);

} // Filter
