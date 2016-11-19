/**
 */
package org.nasdanika.codegen.maven;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.nasdanika.codegen.CodegenPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.nasdanika.codegen.maven.MavenFactory
 * @model kind="package"
 * @generated
 */
public interface MavenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "maven";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.codegen.maven";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.codegen.maven";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MavenPackage eINSTANCE = org.nasdanika.codegen.maven.impl.MavenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.maven.impl.MavenNatureImpl <em>Nature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.maven.impl.MavenNatureImpl
	 * @see org.nasdanika.codegen.maven.impl.MavenPackageImpl#getMavenNature()
	 * @generated
	 */
	int MAVEN_NATURE = 0;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_NATURE__PROPERTIES_REFERENCES = CodegenPackage.NATURE__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_NATURE__CONFIGURATION = CodegenPackage.NATURE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Default Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_NATURE__DEFAULT_PROPERTIES_REFERENCES = CodegenPackage.NATURE__DEFAULT_PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_NATURE__ITERATOR = CodegenPackage.NATURE__ITERATOR;

	/**
	 * The number of structural features of the '<em>Nature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_NATURE_FEATURE_COUNT = CodegenPackage.NATURE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_NATURE___CREATE_CONTEXT__CONTEXT = CodegenPackage.NATURE___CREATE_CONTEXT__CONTEXT;

	/**
	 * The number of operations of the '<em>Nature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_NATURE_OPERATION_COUNT = CodegenPackage.NATURE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.maven.MavenNature <em>Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nature</em>'.
	 * @see org.nasdanika.codegen.maven.MavenNature
	 * @generated
	 */
	EClass getMavenNature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MavenFactory getMavenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.maven.impl.MavenNatureImpl <em>Nature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.maven.impl.MavenNatureImpl
		 * @see org.nasdanika.codegen.maven.impl.MavenPackageImpl#getMavenNature()
		 * @generated
		 */
		EClass MAVEN_NATURE = eINSTANCE.getMavenNature();

	}

} //MavenPackage
