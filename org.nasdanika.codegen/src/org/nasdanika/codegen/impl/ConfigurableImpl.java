/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Configurable;
import org.nasdanika.codegen.Property;
import org.nasdanika.codegen.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configurable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurableImpl#getPropertiesReferences <em>Properties References</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurableImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurableImpl#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConfigurableImpl extends CDOObjectImpl implements Configurable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.CONFIGURABLE;
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
	@SuppressWarnings("unchecked")
	public EList<String> getPropertiesReferences() {
		return (EList<String>)eGet(CodegenPackage.Literals.CONFIGURABLE__PROPERTIES_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Property> getProperties() {
		return (EList<Property>)eGet(CodegenPackage.Literals.CONFIGURABLE__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service<Object>> getServices() {
		return (EList<Service<Object>>)eGet(CodegenPackage.Literals.CONFIGURABLE__SERVICES, true);
	}

} //ConfigurableImpl
