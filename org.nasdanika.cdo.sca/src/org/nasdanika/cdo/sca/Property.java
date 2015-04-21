/**
 */
package org.nasdanika.cdo.sca;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.Property#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Property#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Property#getTargetName <em>Target Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.sca.ScaPackage#getProperty()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Property extends CDOObject {
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
	 * @see org.nasdanika.cdo.sca.ScaPackage#getProperty_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Property#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.nasdanika.cdo.sca.ScaPackage#getProperty_Target()
	 * @model
	 * @generated
	 */
	Component getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Property#getTarget <em>Target</em>}' reference.
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
	 * @see org.nasdanika.cdo.sca.ScaPackage#getProperty_TargetName()
	 * @model
	 * @generated
	 */
	String getTargetName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.sca.Property#getTargetName <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Name</em>' attribute.
	 * @see #getTargetName()
	 * @generated
	 */
	void setTargetName(String value);

} // Property
