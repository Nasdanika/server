/**
 */
package org.nasdanika.codegen;

import org.eclipse.core.resources.IFile;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.File#getMerger <em>Merger</em>}</li>
 *   <li>{@link org.nasdanika.codegen.File#getGenerator <em>Generator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getFile()
 * @model abstract="true" superTypes="org.nasdanika.codegen.Resource<org.nasdanika.codegen.IFile>"
 * @generated
 */
public interface File<C> extends Resource<IFile> {

	/**
	 * Returns the value of the '<em><b>Merger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merger</em>' containment reference.
	 * @see #setMerger(Service)
	 * @see org.nasdanika.codegen.CodegenPackage#getFile_Merger()
	 * @model containment="true"
	 * @generated
	 */
	Service getMerger();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.File#getMerger <em>Merger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Merger</em>' containment reference.
	 * @see #getMerger()
	 * @generated
	 */
	void setMerger(Service value);

	/**
	 * Returns the value of the '<em><b>Generator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator</em>' containment reference.
	 * @see #setGenerator(Generator)
	 * @see org.nasdanika.codegen.CodegenPackage#getFile_Generator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Generator<C> getGenerator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.File#getGenerator <em>Generator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator</em>' containment reference.
	 * @see #getGenerator()
	 * @generated
	 */
	void setGenerator(Generator<C> value);
} // File
