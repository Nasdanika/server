/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.TextFilter#getTextgenerator <em>Textgenerator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getTextFilter()
 * @model abstract="true"
 * @generated
 */
public interface TextFilter extends TextGenerator {
	/**
	 * Returns the value of the '<em><b>Textgenerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textgenerator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textgenerator</em>' containment reference.
	 * @see #setTextgenerator(TextGenerator)
	 * @see org.nasdanika.codegen.CodegenPackage#getTextFilter_Textgenerator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TextGenerator getTextgenerator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.TextFilter#getTextgenerator <em>Textgenerator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Textgenerator</em>' containment reference.
	 * @see #getTextgenerator()
	 * @generated
	 */
	void setTextgenerator(TextGenerator value);

} // TextFilter
