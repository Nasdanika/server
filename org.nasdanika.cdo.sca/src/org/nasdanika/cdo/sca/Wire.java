/**
 */
package org.nasdanika.cdo.sca;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.JSONLoader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.Wire#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Wire#isTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Wire#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Wire#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Wire#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.sca.ScaPackage#getWire()
 * @model superTypes="org.nasdanika.cdo.sca.JSONLoader"
 * @extends CDOObject
 * @generated
 */
public interface Wire extends CDOObject, JSONLoader {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.cdo.sca.ScaPackage#getWire_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Wire#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(boolean)
	 * @see org.nasdanika.cdo.sca.ScaPackage#getWire_TypeName()
	 * @model
	 * @generated
	 */
	boolean isTypeName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Wire#isTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #isTypeName()
	 * @generated
	 */
	void setTypeName(boolean value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Component)
	 * @see org.nasdanika.cdo.sca.ScaPackage#getWire_Target()
	 * @model
	 * @generated
	 */
	Component getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Wire#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Component value);

	/**
	 * Returns the value of the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Name</em>' attribute.
	 * @see #setTargetName(String)
	 * @see org.nasdanika.cdo.sca.ScaPackage#getWire_TargetName()
	 * @model
	 * @generated
	 */
	String getTargetName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Wire#getTargetName <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Name</em>' attribute.
	 * @see #getTargetName()
	 * @generated
	 */
	void setTargetName(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.nasdanika.cdo.sca.ScaPackage#getWire_Properties()
	 * @model mapType="org.nasdanika.cdo.sca.PropertyEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<String, EObject> getProperties();
} // Wire
