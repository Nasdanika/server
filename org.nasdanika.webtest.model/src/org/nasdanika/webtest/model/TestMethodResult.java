/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Method Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Result of test method invocation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.TestMethodResult#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getTestMethodResult()
 * @model
 * @generated
 */
public interface TestMethodResult extends MethodResult {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Names of test parameters
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestMethodResult_Parameters()
	 * @model
	 * @generated
	 */
	EList<String> getParameters();

} // TestMethodResult
