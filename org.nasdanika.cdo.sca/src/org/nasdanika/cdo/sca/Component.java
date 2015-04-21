/**
 */
package org.nasdanika.cdo.sca;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.JSONLoader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.Component#getWires <em>Wires</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Component#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Component#isImmediatelyActivated <em>Immediately Activated</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.sca.ScaPackage#getComponent()
 * @model abstract="true" superTypes="org.nasdanika.cdo.sca.JSONLoader"
 * @extends CDOObject
 * @generated
 */
public interface Component extends CDOObject, JSONLoader {

	/**
	 * Returns the value of the '<em><b>Wires</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.sca.Wire}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wires</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wires</em>' containment reference list.
	 * @see org.nasdanika.cdo.sca.ScaPackage#getComponent_Wires()
	 * @model containment="true"
	 * @generated
	 */
	EList<Wire> getWires();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.nasdanika.cdo.sca.ScaPackage#getComponent_Properties()
	 * @model mapType="org.nasdanika.cdo.sca.PropertyEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<String, EObject> getProperties();

	/**
	 * Returns the value of the '<em><b>Immediately Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immediately Activated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immediately Activated</em>' attribute.
	 * @see #setImmediatelyActivated(boolean)
	 * @see org.nasdanika.cdo.sca.ScaPackage#getComponent_ImmediatelyActivated()
	 * @model
	 * @generated
	 */
	boolean isImmediatelyActivated();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Component#isImmediatelyActivated <em>Immediately Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediately Activated</em>' attribute.
	 * @see #isImmediatelyActivated()
	 * @generated
	 */
	void setImmediatelyActivated(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.cdo.sca.ServiceReference<T>" contextDataType="org.nasdanika.cdo.sca.ComponentContext"
	 * @generated
	 */
	<T> ServiceReference<T> getServiceReference(Class<T> serviceType, ComponentContext context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.cdo.sca.ServiceReference<?>" contextDataType="org.nasdanika.cdo.sca.ComponentContext"
	 * @generated
	 */
	ServiceReference<?> getServiceReference(String serviceName, ComponentContext context);
} // Component
