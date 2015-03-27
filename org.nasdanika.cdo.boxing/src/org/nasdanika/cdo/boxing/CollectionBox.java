/**
 */
package org.nasdanika.cdo.boxing;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.CollectionBox#getElements <em>Elements</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.CollectionBox#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getCollectionBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.nasdanika.cdo.boxing.Collection<T>, org.nasdanika.cdo.boxing.Context>"
 * @generated
 */
public interface CollectionBox<T> extends Box<Collection<T>, Context> {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getCollectionBox_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getElements();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(ClassBox)
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getCollectionBox_Type()
	 * @model type="org.nasdanika.cdo.boxing.ClassBox<org.eclipse.emf.ecore.EJavaObject>" containment="true"
	 * @generated
	 */
	ClassBox<Object> getType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.CollectionBox#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ClassBox<Object> value);

} // CollectionBox
