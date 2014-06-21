/**
 */
package org.nasdanika.cdo.boxing;

import java.util.Map;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
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
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getMapBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.eclipse.emf.ecore.EMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>, org.nasdanika.cdo.boxing.ConverterContext>"
 * @generated
 */
public interface MapBox extends Box<Map<String, Object>, ConverterContext> {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' map.
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getMapBox_Entries()
	 * @model mapType="org.nasdanika.cdo.boxing.StringToEObjectMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<String, EObject> getEntries();

} // MapBox
