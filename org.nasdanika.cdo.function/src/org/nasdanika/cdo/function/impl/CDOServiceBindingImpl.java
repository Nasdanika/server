/**
 */
package org.nasdanika.cdo.function.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.function.CDOServiceBinding;
import org.nasdanika.cdo.function.FunctionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CDO Service Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.CDOServiceBindingImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.CDOServiceBindingImpl#getServiceType <em>Service Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CDOServiceBindingImpl extends CDOObjectImpl implements CDOServiceBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CDOServiceBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.CDO_SERVICE_BINDING;
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
	public String getFilter() {
		return (String)eGet(FunctionPackage.Literals.CDO_SERVICE_BINDING__FILTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(String newFilter) {
		eSet(FunctionPackage.Literals.CDO_SERVICE_BINDING__FILTER, newFilter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceType() {
		return (String)eGet(FunctionPackage.Literals.CDO_SERVICE_BINDING__SERVICE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceType(String newServiceType) {
		eSet(FunctionPackage.Literals.CDO_SERVICE_BINDING__SERVICE_TYPE, newServiceType);
	}

} //CDOServiceBindingImpl
