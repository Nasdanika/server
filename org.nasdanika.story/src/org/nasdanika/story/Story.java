/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Story</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.Story#getAcceptancecriteria <em>Acceptancecriteria</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getDepends <em>Depends</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getThemes <em>Themes</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getProtagonists <em>Protagonists</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getConditionalprotagonists <em>Conditionalprotagonists</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getGoal <em>Goal</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getBenefit <em>Benefit</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#isCompleted <em>Completed</em>}</li>
 *   <li>{@link org.nasdanika.story.Story#getRealizes <em>Realizes</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getStory()
 * @model
 * @generated
 */
public interface Story extends StoryBase {
	/**
	 * Returns the value of the '<em><b>Acceptancecriteria</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.Scenario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A story may contain zero or more acceptance criteria.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Acceptancecriteria</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getStory_Acceptancecriteria()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario> getAcceptancecriteria();

	/**
	 * Returns the value of the '<em><b>Depends</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Story}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A story may depend (include, use) other user stories. E.g. ``edit`` user story may depend on ``view`` user story, 
	 * i.e. a user need to view something first in order to edit it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Depends</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getStory_Depends()
	 * @model
	 * @generated
	 */
	EList<Story> getDepends();

	/**
	 * Returns the value of the '<em><b>Themes</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Theme}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * User story may be associated with zero or more themes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Themes</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getStory_Themes()
	 * @model
	 * @generated
	 */
	EList<Theme> getThemes();

	/**
	 * Returns the value of the '<em><b>Protagonists</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Protagonist}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A story shall have at least one protagonist. If a story is played by multiple types of protagonists, more than one protagonist can be set for the story to obviate artificial generalization relationships between protagonists.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protagonists</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getStory_Protagonists()
	 * @model
	 * @generated
	 */
	EList<Protagonist> getProtagonists();

	/**
	 * Returns the value of the '<em><b>Conditionalprotagonists</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.ConditionalProtagonist}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Some story protagonists may be defined as conditional. For example ``Approve credit application``
	 * story may have a conditional protagonist with credit amount used in the condition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conditionalprotagonists</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getStory_Conditionalprotagonists()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConditionalProtagonist> getConditionalprotagonists();

	/**
	 * Returns the value of the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Story goal (I want).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Goal</em>' attribute.
	 * @see #setGoal(String)
	 * @see org.nasdanika.story.StoryPackage#getStory_Goal()
	 * @model
	 * @generated
	 */
	String getGoal();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Story#getGoal <em>Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goal</em>' attribute.
	 * @see #getGoal()
	 * @generated
	 */
	void setGoal(String value);

	/**
	 * Returns the value of the '<em><b>Benefit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Story benefit (So that).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Benefit</em>' attribute.
	 * @see #setBenefit(String)
	 * @see org.nasdanika.story.StoryPackage#getStory_Benefit()
	 * @model
	 * @generated
	 */
	String getBenefit();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Story#getBenefit <em>Benefit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Benefit</em>' attribute.
	 * @see #getBenefit()
	 * @generated
	 */
	void setBenefit(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A story may have parameters, e.g. ``Approve credit application`` story may have parameter ``creditAmount``.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getStory_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Completed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Completed flag.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Completed</em>' attribute.
	 * @see #setCompleted(boolean)
	 * @see org.nasdanika.story.StoryPackage#getStory_Completed()
	 * @model
	 * @generated
	 */
	boolean isCompleted();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Story#isCompleted <em>Completed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completed</em>' attribute.
	 * @see #isCompleted()
	 * @generated
	 */
	void setCompleted(boolean value);

	/**
	 * Returns the value of the '<em><b>Realizes</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Goal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realizes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realizes</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getStory_Realizes()
	 * @model
	 * @generated
	 */
	EList<Goal> getRealizes();

} // Story
