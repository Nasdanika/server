/**
 */
package org.nasdanika.sca;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.core.Context;
import org.osgi.framework.BundleContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.sca.AbstractComponent#getServices <em>Services</em>}</li>
 *   <li>{@link org.nasdanika.sca.AbstractComponent#getReferences <em>References</em>}</li>
 *   <li>{@link org.nasdanika.sca.AbstractComponent#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.sca.AbstractComponent#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.nasdanika.sca.AbstractComponent#getActivators <em>Activators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.sca.ScaPackage#getAbstractComponent()
 * @model abstract="true"
 * @generated
 */
public interface AbstractComponent extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getAbstractComponent_Services()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getServices();

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getAbstractComponent_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reference> getReferences();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getAbstractComponent_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getAbstractComponent_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Activators</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.Activator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activators</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getAbstractComponent_Activators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Activator> getActivators();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.nasdanika.sca.Exception" bundleContextDataType="org.nasdanika.sca.BundleContext" contextDataType="org.nasdanika.sca.Context"
	 * @generated
	 */
	Component createRuntimeComponent(BundleContext bundleContext, Context context) throws Exception;

} // AbstractComponent
