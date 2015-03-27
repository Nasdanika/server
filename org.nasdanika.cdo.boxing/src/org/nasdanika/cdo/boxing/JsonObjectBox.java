/**
 */
package org.nasdanika.cdo.boxing;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.json.JSONObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Json Object Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.JsonObjectBox#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getJsonObjectBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.nasdanika.cdo.boxing.JSONObject, org.nasdanika.cdo.boxing.Context>"
 * @generated
 */
public interface JsonObjectBox extends Box<JSONObject, Context> {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' map.
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getJsonObjectBox_Elements()
	 * @model mapType="org.nasdanika.cdo.boxing.StringObjectMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<String, EObject> getElements();

} // JsonObjectBox
