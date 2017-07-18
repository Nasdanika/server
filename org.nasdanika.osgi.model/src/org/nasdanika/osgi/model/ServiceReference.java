/**
 */
package org.nasdanika.osgi.model;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.ServiceReference#getInterfaceName <em>Interface Name</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.ServiceReference#getObjectClass <em>Object Class</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.ServiceReference#getReferenceTarget <em>Reference Target</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.ServiceReference#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.osgi.model.ModelPackage#getServiceReference()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ServiceReference extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Interface Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface Name</em>' attribute.
	 * @see #setInterfaceName(String)
	 * @see org.nasdanika.osgi.model.ModelPackage#getServiceReference_InterfaceName()
	 * @model
	 * @generated
	 */
	String getInterfaceName();

	/**
	 * Sets the value of the '{@link org.nasdanika.osgi.model.ServiceReference#getInterfaceName <em>Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Name</em>' attribute.
	 * @see #getInterfaceName()
	 * @generated
	 */
	void setInterfaceName(String value);

	/**
	 * Returns the value of the '<em><b>Object Class</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Class</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Satisfied reference object classes (service interfaces).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object Class</em>' attribute list.
	 * @see org.nasdanika.osgi.model.ModelPackage#getServiceReference_ObjectClass()
	 * @model
	 * @generated
	 */
	EList<String> getObjectClass();

	/**
	 * Returns the value of the '<em><b>Reference Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.osgi.model.Element#getInboundReferences <em>Inbound References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Target</em>' reference.
	 * @see #setReferenceTarget(Element)
	 * @see org.nasdanika.osgi.model.ModelPackage#getServiceReference_ReferenceTarget()
	 * @see org.nasdanika.osgi.model.Element#getInboundReferences
	 * @model opposite="inboundReferences"
	 * @generated
	 */
	Element getReferenceTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.osgi.model.ServiceReference#getReferenceTarget <em>Reference Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Target</em>' reference.
	 * @see #getReferenceTarget()
	 * @generated
	 */
	void setReferenceTarget(Element value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference name for component references.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.osgi.model.ModelPackage#getServiceReference_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.osgi.model.ServiceReference#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ServiceReference
