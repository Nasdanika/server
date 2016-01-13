/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Generic container for [[Story|Stories]], [[Actor|Actors]], [[Role|Roles]], [[Epic|Epics]], [[Theme|Themes]], ...
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.Catalog#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getCatalog()
 * @model
 * @generated
 */
public interface Catalog extends CatalogElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.CatalogElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Catalog elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getCatalog_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<CatalogElement> getElements();

} // Catalog
