/**
 */
package org.nasdanika.cdo.security;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.ActionKey#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.ActionKey#getTargetNamespaceURI <em>Target Namespace URI</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.ActionKey#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.ActionKey#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getActionKey()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ActionKey extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getActionKey_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ActionKey#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Target Namespace URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Namespace URI of the target class' package.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Namespace URI</em>' attribute.
	 * @see #setTargetNamespaceURI(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getActionKey_TargetNamespaceURI()
	 * @model
	 * @generated
	 */
	String getTargetNamespaceURI();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ActionKey#getTargetNamespaceURI <em>Target Namespace URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Namespace URI</em>' attribute.
	 * @see #getTargetNamespaceURI()
	 * @generated
	 */
	void setTargetNamespaceURI(String value);

	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Name of the target class.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Class</em>' attribute.
	 * @see #setTargetClass(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getActionKey_TargetClass()
	 * @model
	 * @generated
	 */
	String getTargetClass();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ActionKey#getTargetClass <em>Target Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' attribute.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(String value);

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute.
	 * @see #setQualifier(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getActionKey_Qualifier()
	 * @model
	 * @generated
	 */
	String getQualifier();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ActionKey#getQualifier <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' attribute.
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(String value);

} // ActionKey
