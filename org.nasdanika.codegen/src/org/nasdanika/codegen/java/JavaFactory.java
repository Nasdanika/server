/**
 */
package org.nasdanika.codegen.java;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.codegen.java.JavaPackage
 * @generated
 */
public interface JavaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavaFactory eINSTANCE = org.nasdanika.codegen.java.impl.JavaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Nature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nature</em>'.
	 * @generated
	 */
	JavaNature createJavaNature();

	/**
	 * Returns a new object of class '<em>Package Fragment Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Fragment Root</em>'.
	 * @generated
	 */
	PackageFragmentRoot createPackageFragmentRoot();

	/**
	 * Returns a new object of class '<em>Package Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Fragment</em>'.
	 * @generated
	 */
	PackageFragment createPackageFragment();

	/**
	 * Returns a new object of class '<em>Text Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Compilation Unit</em>'.
	 * @generated
	 */
	TextCompilationUnit createTextCompilationUnit();

	/**
	 * Returns a new object of class '<em>Structured Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Compilation Unit</em>'.
	 * @generated
	 */
	StructuredCompilationUnit createStructuredCompilationUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavaPackage getJavaPackage();

} //JavaFactory
