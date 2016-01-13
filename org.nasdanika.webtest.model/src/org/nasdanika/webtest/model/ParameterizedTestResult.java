/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterized Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.ParameterizedTestResult#getParameterDescriptors <em>Parameter Descriptors</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getParameterizedTestResult()
 * @model
 * @generated
 */
public interface ParameterizedTestResult extends TestSuiteResult {
	/**
	 * Returns the value of the '<em><b>Parameter Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.Descriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Descriptors</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getParameterizedTestResult_ParameterDescriptors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Descriptor> getParameterDescriptors();

} // ParameterizedTestResult
