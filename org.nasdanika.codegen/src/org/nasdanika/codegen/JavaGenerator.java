/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This generator instantiates and invokes Java class to generate output. 
 * The generator Java class shall implement ``org.nasdanika.codegen.IGenerator``.
 * 
 * For example, JET templates may use a skeleton like shown below:
 * 
 * 
 * ```java
 * public class CLASS implements org.nasdanika.codegen.IGenerator<String> {
 * 
 *     
 * 
 * public String generate(org.nasdanika.codegen.Context context, org.eclipse.core.runtime.IProgressMonitor monitor) throws Exception {
 *         
 * return "";
 *    
 *     }
 *  
 * }
 * ```
 * 
 * and classes compiled from these template can be used by the JavaGenerator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.JavaGenerator#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getJavaGenerator()
 * @model abstract="true"
 * @generated
 */
public interface JavaGenerator<T> extends Generator<T> {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generator class name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getJavaGenerator_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.JavaGenerator#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

} // JavaGenerator
