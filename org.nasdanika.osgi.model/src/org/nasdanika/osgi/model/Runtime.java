/**
 */
package org.nasdanika.osgi.model;

import org.apache.felix.scr.ScrService;
import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;
import org.osgi.framework.BundleException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runtime</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The root element of the model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.Runtime#getBundles <em>Bundles</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.osgi.model.ModelPackage#getRuntime()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Runtime extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Bundles</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.osgi.model.Bundle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Runtime consitst from a set of bundles.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bundles</em>' containment reference list.
	 * @see org.nasdanika.osgi.model.ModelPackage#getRuntime_Bundles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Bundle> getBundles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.nasdanika.osgi.model.BundleException" bundlesDataType="org.nasdanika.osgi.model.FrameworkBundle" bundlesMany="true" scrServiceDataType="org.nasdanika.osgi.model.ScrService"
	 * @generated
	 */
	void load(EList<org.osgi.framework.Bundle> bundles, ScrService scrService) throws BundleException;

} // Runtime
