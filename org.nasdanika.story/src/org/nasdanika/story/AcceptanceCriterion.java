/**
 */
package org.nasdanika.story;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Acceptance Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.AcceptanceCriterion#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.story.AcceptanceCriterion#getContext <em>Context</em>}</li>
 *   <li>{@link org.nasdanika.story.AcceptanceCriterion#getAction <em>Action</em>}</li>
 *   <li>{@link org.nasdanika.story.AcceptanceCriterion#getOutcome <em>Outcome</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getAcceptanceCriterion()
 * @model
 * @generated
 */
public interface AcceptanceCriterion extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Acceptance criterion unique identifier (resource-wide). It is used to link tesst to acceptance criteria.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.nasdanika.story.StoryPackage#getAcceptanceCriterion_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.AcceptanceCriterion#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Context (Given).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see org.nasdanika.story.StoryPackage#getAcceptanceCriterion_Context()
	 * @model
	 * @generated
	 */
	String getContext();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.AcceptanceCriterion#getContext <em>Context</em>}' attribute.
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
	 * @see org.nasdanika.story.StoryPackage#getAcceptanceCriterion_Action()
	 * @model
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.AcceptanceCriterion#getAction <em>Action</em>}' attribute.
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
	 * @see org.nasdanika.story.StoryPackage#getAcceptanceCriterion_Outcome()
	 * @model
	 * @generated
	 */
	String getOutcome();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.AcceptanceCriterion#getOutcome <em>Outcome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outcome</em>' attribute.
	 * @see #getOutcome()
	 * @generated
	 */
	void setOutcome(String value);

} // AcceptanceCriterion
