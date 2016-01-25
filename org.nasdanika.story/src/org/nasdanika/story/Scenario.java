/**
 */
package org.nasdanika.story;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.Scenario#getContext <em>Context</em>}</li>
 *   <li>{@link org.nasdanika.story.Scenario#getAction <em>Action</em>}</li>
 *   <li>{@link org.nasdanika.story.Scenario#getOutcome <em>Outcome</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends CatalogElement {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Context (Given).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see org.nasdanika.story.StoryPackage#getScenario_Context()
	 * @model
	 * @generated
	 */
	String getContext();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Scenario#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Action (when).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see org.nasdanika.story.StoryPackage#getScenario_Action()
	 * @model
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Scenario#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

	/**
	 * Returns the value of the '<em><b>Outcome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Outcome (then).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outcome</em>' attribute.
	 * @see #setOutcome(String)
	 * @see org.nasdanika.story.StoryPackage#getScenario_Outcome()
	 * @model
	 * @generated
	 */
	String getOutcome();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Scenario#getOutcome <em>Outcome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outcome</em>' attribute.
	 * @see #getOutcome()
	 * @generated
	 */
	void setOutcome(String value);

} // Scenario
