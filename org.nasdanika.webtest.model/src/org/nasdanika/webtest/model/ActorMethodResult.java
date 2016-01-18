/**
 */
package org.nasdanika.webtest.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Method Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Result of actor method invocation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.ActorMethodResult#getActorResult <em>Actor Result</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getActorMethodResult()
 * @model
 * @generated
 */
public interface ActorMethodResult extends MethodResult {
	/**
	 * Returns the value of the '<em><b>Actor Result</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.webtest.model.ActorResult#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References actor result this invocation belongs to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actor Result</em>' reference.
	 * @see #setActorResult(ActorResult)
	 * @see org.nasdanika.webtest.model.ModelPackage#getActorMethodResult_ActorResult()
	 * @see org.nasdanika.webtest.model.ActorResult#getResults
	 * @model opposite="results"
	 * @generated
	 */
	ActorResult getActorResult();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.ActorMethodResult#getActorResult <em>Actor Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor Result</em>' reference.
	 * @see #getActorResult()
	 * @generated
	 */
	void setActorResult(ActorResult value);

} // ActorMethodResult
