/**
 */
package org.nasdanika.osgi.model;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base class for OSGi runtime element which can expose and consume services - bundles and components.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.Element#getOutboundReferences <em>Outbound References</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.Element#getInboundReferences <em>Inbound References</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.Element#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.osgi.model.ModelPackage#getElement()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Element extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Outbound References</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.osgi.model.ServiceReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outbound References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outbound References</em>' containment reference list.
	 * @see org.nasdanika.osgi.model.ModelPackage#getElement_OutboundReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServiceReference> getOutboundReferences();

	/**
	 * Returns the value of the '<em><b>Inbound References</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.osgi.model.ServiceReference}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.osgi.model.ServiceReference#getReferenceTarget <em>Reference Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound References</em>' reference list.
	 * @see org.nasdanika.osgi.model.ModelPackage#getElement_InboundReferences()
	 * @see org.nasdanika.osgi.model.ServiceReference#getReferenceTarget
	 * @model opposite="referenceTarget"
	 * @generated
	 */
	EList<ServiceReference> getInboundReferences();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see org.nasdanika.osgi.model.ModelPackage#getElement_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link org.nasdanika.osgi.model.Element#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

} // Element
