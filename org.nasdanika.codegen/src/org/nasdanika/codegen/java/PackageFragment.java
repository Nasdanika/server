/**
 */
package org.nasdanika.codegen.java;

import org.eclipse.emf.common.util.EList;

import org.eclipse.jdt.core.IPackageFragment;

import org.nasdanika.codegen.Generator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.PackageFragment#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.java.PackageFragment#getCompilationunits <em>Compilationunits</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.java.JavaPackage#getPackageFragment()
 * @model superTypes="org.nasdanika.codegen.Generator<org.nasdanika.codegen.java.IPackageFragment>"
 * @generated
 */
public interface PackageFragment extends Generator<IPackageFragment> {
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
	 * @see org.nasdanika.codegen.java.JavaPackage#getPackageFragment_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.java.PackageFragment#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Compilationunits</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.java.CompilationUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compilationunits</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compilationunits</em>' containment reference list.
	 * @see org.nasdanika.codegen.java.JavaPackage#getPackageFragment_Compilationunits()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompilationUnit> getCompilationunits();

} // PackageFragment
