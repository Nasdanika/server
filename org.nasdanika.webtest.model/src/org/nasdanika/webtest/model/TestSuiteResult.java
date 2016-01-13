/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.TestSuiteResult#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getTestSuiteResult()
 * @model
 * @generated
 */
public interface TestSuiteResult extends TestResult {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.TestResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestSuiteResult_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestResult> getChildren();

} // TestSuiteResult
