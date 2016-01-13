/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Theme</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Theme is a cross-cutting concern, e.g. performance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.Theme#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getTheme()
 * @model
 * @generated
 */
public interface Theme extends CatalogElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.Theme}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Themes can be organized into a hierarchy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getTheme_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Theme> getChildren();

} // Theme
