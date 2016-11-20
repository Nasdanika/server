/**
 */
package org.nasdanika.codegen.java.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Work;
import org.nasdanika.codegen.impl.GeneratorImpl;

import org.nasdanika.codegen.java.JavaPackage;
import org.nasdanika.codegen.java.PackageFragment;
import org.nasdanika.codegen.java.PackageFragmentRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Fragment Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.impl.PackageFragmentRootImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.java.impl.PackageFragmentRootImpl#getPackagefragments <em>Packagefragments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageFragmentRootImpl extends GeneratorImpl<IPackageFragmentRoot> implements PackageFragmentRoot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageFragmentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.PACKAGE_FRAGMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(JavaPackage.Literals.PACKAGE_FRAGMENT_ROOT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(JavaPackage.Literals.PACKAGE_FRAGMENT_ROOT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<PackageFragment> getPackagefragments() {
		return (EList<PackageFragment>)eGet(JavaPackage.Literals.PACKAGE_FRAGMENT_ROOT__PACKAGEFRAGMENTS, true);
	}

	@Override
	public Work<List<IPackageFragmentRoot>> createWork(Context context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

} //PackageFragmentRootImpl
