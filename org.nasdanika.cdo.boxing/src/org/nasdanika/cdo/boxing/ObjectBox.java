/**
 */
package org.nasdanika.cdo.boxing;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.ObjectBox#getFields <em>Fields</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.ObjectBox#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getObjectBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<T, org.nasdanika.cdo.boxing.Context>"
 * @generated
 */
public interface ObjectBox<T> extends Box<T, Context> {
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.boxing.FieldEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getObjectBox_Fields()
	 * @model containment="true"
	 * @generated
	 */
	EList<FieldEntry> getFields();

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
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getObjectBox_Type()
	 * @model containment="true"
	 * @generated
	 */
	ClassBox<T> getType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.ObjectBox#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ClassBox<T> value);

} // ObjectBox
