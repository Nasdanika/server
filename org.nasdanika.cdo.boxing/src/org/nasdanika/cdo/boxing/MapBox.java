/**
 */
package org.nasdanika.cdo.boxing;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.MapBox#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.MapBox#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getMapBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.eclipse.emf.ecore.EMap<K, V>, org.nasdanika.cdo.boxing.ConverterContext>"
 * @generated
 */
public interface MapBox<K, V> extends Box<Map<K, V>, ConverterContext> {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.boxing.MapEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getMapBox_Entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<MapEntry> getEntries();

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
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getMapBox_Type()
	 * @model type="org.nasdanika.cdo.boxing.ClassBox<org.eclipse.emf.ecore.EMap<K, V>>" containment="true"
	 * @generated
	 */
	ClassBox<Map<K, V>> getType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.MapBox#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ClassBox<Map<K, V>> value);

} // MapBox
