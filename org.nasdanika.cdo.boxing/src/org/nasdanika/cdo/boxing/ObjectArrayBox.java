/**
 */
package org.nasdanika.cdo.boxing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Array Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.ObjectArrayBox#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.ObjectArrayBox#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getObjectArrayBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.eclipse.emf.ecore.EJavaObject, org.nasdanika.cdo.boxing.Context>"
 * @generated
 */
public interface ObjectArrayBox<T> extends Box<Object, Context> {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' containment reference.
	 * @see #setElementType(ClassBox)
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getObjectArrayBox_ElementType()
	 * @model containment="true"
	 * @generated
	 */
	ClassBox<T> getElementType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.ObjectArrayBox#getElementType <em>Element Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' containment reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(ClassBox<T> value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getObjectArrayBox_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getElements();

} // ObjectArrayBox
