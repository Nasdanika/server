/**
 */
package org.nasdanika.codegen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.codegen.CodegenPackage
 * @generated
 */
public interface CodegenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodegenFactory eINSTANCE = org.nasdanika.codegen.impl.CodegenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	<T> Service<T> createService();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	<T> Property<T> createProperty();

	/**
	 * Returns a new object of class '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group</em>'.
	 * @generated
	 */
	<T> Group<T> createGroup();

	/**
	 * Returns a new object of class '<em>Workspace Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workspace Root</em>'.
	 * @generated
	 */
	WorkspaceRoot createWorkspaceRoot();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated
	 */
	Folder createFolder();

	/**
	 * Returns a new object of class '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	Project createProject();

	/**
	 * Returns a new object of class '<em>Binary File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary File</em>'.
	 * @generated
	 */
	BinaryFile createBinaryFile();

	/**
	 * Returns a new object of class '<em>Text File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text File</em>'.
	 * @generated
	 */
	TextFile createTextFile();

	/**
	 * Returns a new object of class '<em>Resource Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Reference</em>'.
	 * @generated
	 */
	ResourceReference createResourceReference();

	/**
	 * Returns a new object of class '<em>Static Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Text</em>'.
	 * @generated
	 */
	StaticText createStaticText();

	/**
	 * Returns a new object of class '<em>Text Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Reference</em>'.
	 * @generated
	 */
	TextReference createTextReference();

	/**
	 * Returns a new object of class '<em>Java Text Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Text Generator</em>'.
	 * @generated
	 */
	JavaTextGenerator createJavaTextGenerator();

	/**
	 * Returns a new object of class '<em>Interpolator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interpolator</em>'.
	 * @generated
	 */
	Interpolator createInterpolator();

	/**
	 * Returns a new object of class '<em>Java Text Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Text Filter</em>'.
	 * @generated
	 */
	JavaTextFilter createJavaTextFilter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CodegenPackage getCodegenPackage();

} //CodegenFactory
