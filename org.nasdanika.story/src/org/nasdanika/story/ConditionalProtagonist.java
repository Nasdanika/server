/**
 */
package org.nasdanika.story;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Protagonist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.ConditionalProtagonist#getProtagonist <em>Protagonist</em>}</li>
 *   <li>{@link org.nasdanika.story.ConditionalProtagonist#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getConditionalProtagonist()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ConditionalProtagonist extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Protagonist</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Protagonist}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References one or more protagonists.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protagonist</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getConditionalProtagonist_Protagonist()
	 * @model required="true"
	 * @generated
	 */
	EList<Protagonist> getProtagonist();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Condition in JavaScript, e.g. amount<5000.00
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.nasdanika.story.StoryPackage#getConditionalProtagonist_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.ConditionalProtagonist#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // ConditionalProtagonist
