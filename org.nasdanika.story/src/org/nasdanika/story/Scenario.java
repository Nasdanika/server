/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;


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
 *   <li>{@link org.nasdanika.story.Scenario#getContextStates <em>Context States</em>}</li>
 *   <li>{@link org.nasdanika.story.Scenario#getAction <em>Action</em>}</li>
 *   <li>{@link org.nasdanika.story.Scenario#getOutcome <em>Outcome</em>}</li>
 *   <li>{@link org.nasdanika.story.Scenario#getOutcomeState <em>Outcome State</em>}</li>
 *   <li>{@link org.nasdanika.story.Scenario#getSteps <em>Steps</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends StateContainer {
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
	 * Returns the value of the '<em><b>Context States</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Context (Given) state(s), i.e. a start state(s) from which the scenario transitions to the 
	 * outcome (then) end state.
	 * 
	 * There can be more than one start state, e.g. two different pages with a link which
	 * initiates the scenario. Where it makes sense it is recommended to create super-states
	 * for states which are context/start states for the same scenario(s).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context States</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getScenario_ContextStates()
	 * @model
	 * @generated
	 */
	EList<State> getContextStates();

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

	/**
	 * Returns the value of the '<em><b>Outcome State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Outcome (then) state, i.e. the end state to which the scenario transitions from
	 *  the context/given/start state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outcome State</em>' reference.
	 * @see #setOutcomeState(State)
	 * @see org.nasdanika.story.StoryPackage#getScenario_OutcomeState()
	 * @model
	 * @generated
	 */
	State getOutcomeState();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Scenario#getOutcomeState <em>Outcome State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outcome State</em>' reference.
	 * @see #getOutcomeState()
	 * @generated
	 */
	void setOutcomeState(State value);

	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.Step}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getScenario_Steps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Step> getSteps();

} // Scenario
