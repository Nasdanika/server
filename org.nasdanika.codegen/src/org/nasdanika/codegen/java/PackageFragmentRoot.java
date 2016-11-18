/**
 */
package org.nasdanika.codegen.java;

import org.eclipse.emf.common.util.EList;

import org.eclipse.jdt.core.IPackageFragmentRoot;

import org.nasdanika.codegen.Generator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Fragment Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.PackageFragmentRoot#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.java.PackageFragmentRoot#getPackagefragments <em>Packagefragments</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.java.JavaPackage#getPackageFragmentRoot()
 * @model superTypes="org.nasdanika.codegen.Generator<org.nasdanika.codegen.java.IPackageFragmentRoot>"
 * @generated
 */
public interface PackageFragmentRoot extends Generator<IPackageFragmentRoot> {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.codegen.java.JavaPackage#getPackageFragmentRoot_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.java.PackageFragmentRoot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Packagefragments</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.java.PackageFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packagefragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packagefragments</em>' containment reference list.
	 * @see org.nasdanika.codegen.java.JavaPackage#getPackageFragmentRoot_Packagefragments()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageFragment> getPackagefragments();

} // PackageFragmentRoot
