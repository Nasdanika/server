/**
 */
package org.nasdanika.codegen.maven;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.codegen.maven.MavenPackage
 * @generated
 */
public interface MavenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MavenFactory eINSTANCE = org.nasdanika.codegen.maven.impl.MavenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Nature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nature</em>'.
	 * @generated
	 */
	MavenNature createMavenNature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MavenPackage getMavenPackage();

} //MavenFactory
