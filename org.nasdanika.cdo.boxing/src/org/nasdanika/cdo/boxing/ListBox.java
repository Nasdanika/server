/**
 */
package org.nasdanika.cdo.boxing;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.ListBox#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getListBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.nasdanika.cdo.boxing.List<T>, org.nasdanika.cdo.boxing.ConverterContext>"
 * @generated
 */
public interface ListBox<T> extends Box<List<T>, ConverterContext> {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getListBox_Elements()
	 * @model
	 * @generated
	 */
	EList<EObject> getElements();

} // ListBox
