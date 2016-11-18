/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.TextFile#getTextgenerator <em>Textgenerator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getTextFile()
 * @model
 * @generated
 */
public interface TextFile extends File {
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
	 * @see org.nasdanika.codegen.CodegenPackage#getTextFile_Textgenerator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TextGenerator getTextgenerator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.TextFile#getTextgenerator <em>Textgenerator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Textgenerator</em>' containment reference.
	 * @see #getTextgenerator()
	 * @generated
	 */
	void setTextgenerator(TextGenerator value);

} // TextFile
