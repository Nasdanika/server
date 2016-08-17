/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Container of stories.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.StoryContainer#getStories <em>Stories</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getStoryContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface StoryContainer extends StateContainer {
	/**
	 * Returns the value of the '<em><b>Stories</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.StoryBase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Story container may contain zero or more stories or epics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stories</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getStoryContainer_Stories()
	 * @model containment="true"
	 * @generated
	 */
	EList<StoryBase> getStories();

} // StoryContainer
