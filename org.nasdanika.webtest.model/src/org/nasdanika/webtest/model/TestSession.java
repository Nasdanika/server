/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Session</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.TestSession#getTestResults <em>Test Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.TestSession#getPageResults <em>Page Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.TestSession#getActorResults <em>Actor Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.TestSession#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.TestSession#getNode <em>Node</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.TestSession#getScreenshots <em>Screenshots</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getTestSession()
 * @model
 * @generated
 */
public interface TestSession extends Descriptor {
	/**
	 * Returns the value of the '<em><b>Test Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.TestResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Results</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestSession_TestResults()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestResult> getTestResults();

	/**
	 * Returns the value of the '<em><b>Page Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.PageResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Results</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestSession_PageResults()
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
	 * @return the value of the '<em>Actor Results</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestSession_ActorResults()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActorResult> getActorResults();

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(long)
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestSession_Timestamp()
	 * @model
	 * @generated
	 */
	long getTimestamp();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.TestSession#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' attribute.
	 * @see #setNode(String)
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestSession_Node()
	 * @model
	 * @generated
	 */
	String getNode();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.TestSession#getNode <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' attribute.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(String value);

	/**
	 * Returns the value of the '<em><b>Screenshots</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.Screenshot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Screenshots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Screenshots</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestSession_Screenshots()
	 * @model containment="true"
	 * @generated
	 */
	EList<Screenshot> getScreenshots();

} // TestSession
