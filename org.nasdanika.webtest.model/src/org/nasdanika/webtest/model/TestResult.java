/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base class for test results.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.TestResult#getPageResults <em>Page Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.TestResult#getActorResults <em>Actor Results</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getTestResult()
 * @model
 * @generated
 */
public interface TestResult extends Descriptor {
	/**
	 * Returns the value of the '<em><b>Page Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.PageResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains page results, which hold aggregated page invocation information.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Results</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestResult_PageResults()
	 * @model containment="true"
	 * @generated
	 */
	EList<PageResult> getPageResults();

	/**
	 * Returns the value of the '<em><b>Actor Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.ActorResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains actor results, which hold aggregated actor invocation information.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actor Results</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestResult_ActorResults()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActorResult> getActorResults();

} // TestResult
