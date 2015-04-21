/**
 */
package org.nasdanika.cdo.sca;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.PropertySetting#getTargetName <em>Target Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.sca.ScaPackage#getPropertySetting()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface PropertySetting extends CDOObject {
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
	 * @see org.nasdanika.cdo.sca.ScaPackage#getPropertySetting_TargetName()
	 * @model
	 * @generated
	 */
	String getTargetName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.PropertySetting#getTargetName <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Name</em>' attribute.
	 * @see #getTargetName()
	 * @generated
	 */
	void setTargetName(String value);

} // PropertySetting
