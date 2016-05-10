/**
 */
package org.nasdanika.osgi.model.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.osgi.model.Bundle;
import org.nasdanika.osgi.model.Component;
import org.nasdanika.osgi.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.impl.BundleImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.BundleImpl#getSymbolicName <em>Symbolic Name</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.BundleImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.BundleImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.BundleImpl#getRequiredBy <em>Required By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BundleImpl extends ElementImpl implements Bundle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.BUNDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getComponents() {
		return (EList<Component>)eGet(ModelPackage.Literals.BUNDLE__COMPONENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbolicName() {
		return (String)eGet(ModelPackage.Literals.BUNDLE__SYMBOLIC_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbolicName(String newSymbolicName) {
		eSet(ModelPackage.Literals.BUNDLE__SYMBOLIC_NAME, newSymbolicName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return (String)eGet(ModelPackage.Literals.BUNDLE__VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		eSet(ModelPackage.Literals.BUNDLE__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Bundle> getRequires() {
		return (EList<Bundle>)eGet(ModelPackage.Literals.BUNDLE__REQUIRES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Bundle> getRequiredBy() {
		return (EList<Bundle>)eGet(ModelPackage.Literals.BUNDLE__REQUIRED_BY, true);
	}

} //BundleImpl
