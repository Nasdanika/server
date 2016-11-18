/**
 */
package org.nasdanika.codegen.java.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.impl.NatureImpl;

import org.nasdanika.codegen.java.JavaNature;
import org.nasdanika.codegen.java.JavaPackage;
import org.nasdanika.codegen.java.PackageFragmentRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.impl.JavaNatureImpl#getPackagefragmentroots <em>Packagefragmentroots</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaNatureImpl extends NatureImpl implements JavaNature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaNatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JAVA_NATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<PackageFragmentRoot> getPackagefragmentroots() {
		return (EList<PackageFragmentRoot>)eGet(JavaPackage.Literals.JAVA_NATURE__PACKAGEFRAGMENTROOTS, true);
	}

} //JavaNatureImpl
