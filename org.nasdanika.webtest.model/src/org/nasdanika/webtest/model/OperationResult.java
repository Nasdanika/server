/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base class for operation results where operation is a method or a constructor.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getScreenshots <em>Screenshots</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getChildren <em>Children</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getError <em>Error</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getStart <em>Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getFinish <em>Finish</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getStatus <em>Status</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getResult <em>Result</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationResult#getInstanceAliasPath <em>Instance Alias Path</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult()
 * @model
 * @generated
 */
public interface OperationResult extends Descriptor {
	/**
	 * Returns the value of the '<em><b>Screenshots</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.ScreenshotEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Screenshots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each operation may contain multiple screenshot entries, e.g. 
	 * a screenshot taken before operation invocation, screenshots taken explicitly during 
	 * operation execution via WebTestUtil.TakeScreenshot(String comment) method,
	 * and screenshots taken after operation invocation or if operation threw an exception.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Screenshots</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Screenshots()
	 * @model containment="true"
	 * @generated
	 */
	EList<ScreenshotEntry> getScreenshots();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.OperationResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Other operations invoked by this operation. E.g. test method result may contain
	 * actor method results, which in turn may contain page method results.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationResult> getChildren();

	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operation name. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation Name</em>' attribute.
	 * @see #setOperationName(String)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_OperationName()
	 * @model
	 * @generated
	 */
	String getOperationName();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationResult#getOperationName <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' attribute.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(String value);

	/**
	 * Returns the value of the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Root cause of the failure thrown by the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Failure</em>' containment reference.
	 * @see #setFailure(org.nasdanika.webtest.model.Throwable)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Failure()
	 * @model containment="true"
	 * @generated
	 */
	org.nasdanika.webtest.model.Throwable getFailure();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationResult#getFailure <em>Failure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure</em>' containment reference.
	 * @see #getFailure()
	 * @generated
	 */
	void setFailure(org.nasdanika.webtest.model.Throwable value);

	/**
	 * Returns the value of the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Root cause of the error thrown by the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Error</em>' containment reference.
	 * @see #setError(org.nasdanika.webtest.model.Throwable)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Error()
	 * @model containment="true"
	 * @generated
	 */
	org.nasdanika.webtest.model.Throwable getError();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationResult#getError <em>Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' containment reference.
	 * @see #getError()
	 * @generated
	 */
	void setError(org.nasdanika.webtest.model.Throwable value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operation start time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(long)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Start()
	 * @model
	 * @generated
	 */
	long getStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationResult#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(long value);

	/**
	 * Returns the value of the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operation finish time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Finish</em>' attribute.
	 * @see #setFinish(long)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Finish()
	 * @model
	 * @generated
	 */
	long getFinish();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationResult#getFinish <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish</em>' attribute.
	 * @see #getFinish()
	 * @generated
	 */
	void setFinish(long value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.nasdanika.webtest.model.OperationStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Status of operation execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.nasdanika.webtest.model.OperationStatus
	 * @see #setStatus(OperationStatus)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Status()
	 * @model
	 * @generated
	 */
	OperationStatus getStatus();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationResult#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.nasdanika.webtest.model.OperationStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(OperationStatus value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.OperationArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operation arguments.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationArgument> getArguments();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Operation return value, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(OperationArgument)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_Result()
	 * @model containment="true"
	 * @generated
	 */
	OperationArgument getResult();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationResult#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(OperationArgument value);

	/**
	 * Returns the value of the '<em><b>Instance Alias Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Instance alias can be used to differentiate between several instances of the same
	 * type participating in a test.
	 * 
	 * Alias path would be a size of 1 for top-level actors/pages and more than one for delegates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Alias Path</em>' attribute list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationResult_InstanceAliasPath()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getInstanceAliasPath();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a list of all screenshots taken by this operation and its children ordered and without duplicates.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EList<ScreenshotEntry> allScreenshots();

} // OperationResult
