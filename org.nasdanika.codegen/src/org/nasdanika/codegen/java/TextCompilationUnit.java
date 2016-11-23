/**
 */
package org.nasdanika.codegen.java;

import org.nasdanika.codegen.Generator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Compilation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Text compilation units uses a text generator to produce its content.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.TextCompilationUnit#getGenerator <em>Generator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.java.JavaPackage#getTextCompilationUnit()
 * @model
 * @generated
 */
public interface TextCompilationUnit extends CompilationUnit {
	/**
	 * Returns the value of the '<em><b>Generator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generator to produce compilation unit content.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generator</em>' containment reference.
	 * @see #setGenerator(Generator)
	 * @see org.nasdanika.codegen.java.JavaPackage#getTextCompilationUnit_Generator()
	 * @model type="org.nasdanika.codegen.Generator<org.eclipse.emf.ecore.EString>" containment="true"
	 * @generated
	 */
	Generator<String> getGenerator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.java.TextCompilationUnit#getGenerator <em>Generator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator</em>' containment reference.
	 * @see #getGenerator()
	 * @generated
	 */
	void setGenerator(Generator<String> value);

} // TextCompilationUnit
