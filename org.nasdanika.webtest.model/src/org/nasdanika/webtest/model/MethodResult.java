/**
 */
package org.nasdanika.webtest.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Result of method invocation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.MethodResult#getMethod <em>Method</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getMethodResult()
 * @model
 * @generated
 */
public interface MethodResult extends OperationResult {

	/**
	 * Returns the value of the '<em><b>Method</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.webtest.model.Method#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' reference.
	 * @see #setMethod(Method)
	 * @see org.nasdanika.webtest.model.ModelPackage#getMethodResult_Method()
	 * @see org.nasdanika.webtest.model.Method#getResults
	 * @model opposite="results"
	 * @generated
	 */
	Method getMethod();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.MethodResult#getMethod <em>Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(Method value);
} // MethodResult
