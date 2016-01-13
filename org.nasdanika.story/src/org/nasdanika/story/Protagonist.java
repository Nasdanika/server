/**
 */
package org.nasdanika.story;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protagonist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base interface representing the main character of a story. Protagonists may contain stories, in this case the containing protagonist becomes an implicit protagonist of the contained stories.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.Protagonist#getLinkTo <em>Link To</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getProtagonist()
 * @model abstract="true"
 * @generated
 */
public interface Protagonist extends StoryContainer {
	/**
	 * Returns the value of the '<em><b>Link To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Protagonist can be linked to EClass. In this case protagonist documentation is displayed as a tab in the EClass documentation and 
	 * user stories are mounted under the target EClass in the documentation tree.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link To</em>' reference.
	 * @see #setLinkTo(EClass)
	 * @see org.nasdanika.story.StoryPackage#getProtagonist_LinkTo()
	 * @model
	 * @generated
	 */
	EClass getLinkTo();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.Protagonist#getLinkTo <em>Link To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link To</em>' reference.
	 * @see #getLinkTo()
	 * @generated
	 */
	void setLinkTo(EClass value);

} // Protagonist
