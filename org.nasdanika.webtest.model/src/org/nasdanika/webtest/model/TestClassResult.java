/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Class Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Results collected from a JUnit test class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.TestClassResult#getMethodResults <em>Method Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.TestClassResult#getStats <em>Stats</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getTestClassResult()
 * @model
 * @generated
 */
public interface TestClassResult extends TestResult {
	/**
	 * Returns the value of the '<em><b>Method Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.TestMethodResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Test class result contains test method results.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Method Results</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestClassResult_MethodResults()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestMethodResult> getMethodResults();

	/**
	 * Returns the value of the '<em><b>Stats</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stats</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Test statistics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stats</em>' map.
	 * @see org.nasdanika.webtest.model.ModelPackage#getTestClassResult_Stats()
	 * @model mapType="org.nasdanika.webtest.model.StatsEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EIntegerObject>"
	 * @generated
	 */
	EMap<String, Integer> getStats();

} // TestClassResult
