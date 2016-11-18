/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Text Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.JavaTextGenerator#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getJavaTextGenerator()
 * @model
 * @generated
 */
public interface JavaTextGenerator extends TextGenerator {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getJavaTextGenerator_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.JavaTextGenerator#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

} // JavaTextGenerator
