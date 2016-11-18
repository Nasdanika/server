/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.BinaryFile#getStreamgenerator <em>Streamgenerator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getBinaryFile()
 * @model
 * @generated
 */
public interface BinaryFile extends File {
	/**
	 * Returns the value of the '<em><b>Streamgenerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streamgenerator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Streamgenerator</em>' containment reference.
	 * @see #setStreamgenerator(StreamGenerator)
	 * @see org.nasdanika.codegen.CodegenPackage#getBinaryFile_Streamgenerator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StreamGenerator getStreamgenerator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.BinaryFile#getStreamgenerator <em>Streamgenerator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Streamgenerator</em>' containment reference.
	 * @see #getStreamgenerator()
	 * @generated
	 */
	void setStreamgenerator(StreamGenerator value);

} // BinaryFile
