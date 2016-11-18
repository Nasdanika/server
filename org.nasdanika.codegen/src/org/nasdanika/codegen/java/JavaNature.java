/**
 */
package org.nasdanika.codegen.java;

import org.eclipse.emf.common.util.EList;

import org.nasdanika.codegen.Nature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.JavaNature#getPackagefragmentroots <em>Packagefragmentroots</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.java.JavaPackage#getJavaNature()
 * @model
 * @generated
 */
public interface JavaNature extends Nature {
	/**
	 * Returns the value of the '<em><b>Packagefragmentroots</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.java.PackageFragmentRoot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packagefragmentroots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packagefragmentroots</em>' containment reference list.
	 * @see org.nasdanika.codegen.java.JavaPackage#getJavaNature_Packagefragmentroots()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageFragmentRoot> getPackagefragmentroots();

} // JavaNature
