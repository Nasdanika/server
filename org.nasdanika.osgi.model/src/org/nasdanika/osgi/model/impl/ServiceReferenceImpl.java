/**
 */
package org.nasdanika.osgi.model.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.osgi.model.Element;
import org.nasdanika.osgi.model.ModelPackage;
import org.nasdanika.osgi.model.ServiceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.impl.ServiceReferenceImpl#getInterfaceName <em>Interface Name</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.ServiceReferenceImpl#getObjectClass <em>Object Class</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.ServiceReferenceImpl#getReferenceTarget <em>Reference Target</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.ServiceReferenceImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceReferenceImpl extends CDOObjectImpl implements ServiceReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SERVICE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterfaceName() {
		return (String)eGet(ModelPackage.Literals.SERVICE_REFERENCE__INTERFACE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceName(String newInterfaceName) {
		eSet(ModelPackage.Literals.SERVICE_REFERENCE__INTERFACE_NAME, newInterfaceName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getObjectClass() {
		return (EList<String>)eGet(ModelPackage.Literals.SERVICE_REFERENCE__OBJECT_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getReferenceTarget() {
		return (Element)eGet(ModelPackage.Literals.SERVICE_REFERENCE__REFERENCE_TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceTarget(Element newReferenceTarget) {
		eSet(ModelPackage.Literals.SERVICE_REFERENCE__REFERENCE_TARGET, newReferenceTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(ModelPackage.Literals.SERVICE_REFERENCE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ModelPackage.Literals.SERVICE_REFERENCE__NAME, newName);
	}

} //ServiceReferenceImpl
