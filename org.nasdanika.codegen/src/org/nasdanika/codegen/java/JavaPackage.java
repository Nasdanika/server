/**
 */
package org.nasdanika.codegen.java;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.nasdanika.codegen.java.JavaFactory
 * @model kind="package"
 * @generated
 */
public interface JavaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "java";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.codegen.java";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.codegen.java";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavaPackage eINSTANCE = org.nasdanika.codegen.java.impl.JavaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.java.impl.JavaNatureImpl <em>Nature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.java.impl.JavaNatureImpl
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getJavaNature()
	 * @generated
	 */
	int JAVA_NATURE = 0;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__INCLUDES = CodegenPackage.NATURE__INCLUDES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__CONFIGURATION = CodegenPackage.NATURE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Default Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__DEFAULT_INCLUDES = CodegenPackage.NATURE__DEFAULT_INCLUDES;

	/**
	 * The feature id for the '<em><b>Base URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__BASE_URL = CodegenPackage.NATURE__BASE_URL;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__CLASS_PATH = CodegenPackage.NATURE__CLASS_PATH;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__INCLUDE = CodegenPackage.NATURE__INCLUDE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__ITERATOR = CodegenPackage.NATURE__ITERATOR;

	/**
	 * The feature id for the '<em><b>Packagefragmentroots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE__PACKAGEFRAGMENTROOTS = CodegenPackage.NATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE_FEATURE_COUNT = CodegenPackage.NATURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE___CREATE_CONTEXT__CONTEXT = CodegenPackage.NATURE___CREATE_CONTEXT__CONTEXT;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE___VALIDATE__DIAGNOSTICCHAIN_MAP = CodegenPackage.NATURE___VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Nature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NATURE_OPERATION_COUNT = CodegenPackage.NATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.java.impl.PackageFragmentRootImpl <em>Package Fragment Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.java.impl.PackageFragmentRootImpl
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getPackageFragmentRoot()
	 * @generated
	 */
	int PACKAGE_FRAGMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__INCLUDES = CodegenPackage.GENERATOR__INCLUDES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__CONFIGURATION = CodegenPackage.GENERATOR__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Default Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__DEFAULT_INCLUDES = CodegenPackage.GENERATOR__DEFAULT_INCLUDES;

	/**
	 * The feature id for the '<em><b>Base URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__BASE_URL = CodegenPackage.GENERATOR__BASE_URL;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__CLASS_PATH = CodegenPackage.GENERATOR__CLASS_PATH;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__INCLUDE = CodegenPackage.GENERATOR__INCLUDE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__ITERATOR = CodegenPackage.GENERATOR__ITERATOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__NAME = CodegenPackage.GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Packagefragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT__PACKAGEFRAGMENTS = CodegenPackage.GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Fragment Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT_FEATURE_COUNT = CodegenPackage.GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT___CREATE_CONTEXT__CONTEXT = CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT___VALIDATE__DIAGNOSTICCHAIN_MAP = CodegenPackage.GENERATOR___VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Package Fragment Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_ROOT_OPERATION_COUNT = CodegenPackage.GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.java.impl.PackageFragmentImpl <em>Package Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.java.impl.PackageFragmentImpl
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getPackageFragment()
	 * @generated
	 */
	int PACKAGE_FRAGMENT = 2;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__INCLUDES = CodegenPackage.GENERATOR__INCLUDES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__CONFIGURATION = CodegenPackage.GENERATOR__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Default Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__DEFAULT_INCLUDES = CodegenPackage.GENERATOR__DEFAULT_INCLUDES;

	/**
	 * The feature id for the '<em><b>Base URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__BASE_URL = CodegenPackage.GENERATOR__BASE_URL;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__CLASS_PATH = CodegenPackage.GENERATOR__CLASS_PATH;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__INCLUDE = CodegenPackage.GENERATOR__INCLUDE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__ITERATOR = CodegenPackage.GENERATOR__ITERATOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__NAME = CodegenPackage.GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Compilationunits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT__COMPILATIONUNITS = CodegenPackage.GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_FEATURE_COUNT = CodegenPackage.GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT___CREATE_CONTEXT__CONTEXT = CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT___VALIDATE__DIAGNOSTICCHAIN_MAP = CodegenPackage.GENERATOR___VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Package Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FRAGMENT_OPERATION_COUNT = CodegenPackage.GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.java.impl.CompilationUnitImpl <em>Compilation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.java.impl.CompilationUnitImpl
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getCompilationUnit()
	 * @generated
	 */
	int COMPILATION_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__INCLUDES = CodegenPackage.GENERATOR__INCLUDES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__CONFIGURATION = CodegenPackage.GENERATOR__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Default Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__DEFAULT_INCLUDES = CodegenPackage.GENERATOR__DEFAULT_INCLUDES;

	/**
	 * The feature id for the '<em><b>Base URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__BASE_URL = CodegenPackage.GENERATOR__BASE_URL;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__CLASS_PATH = CodegenPackage.GENERATOR__CLASS_PATH;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__INCLUDE = CodegenPackage.GENERATOR__INCLUDE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__ITERATOR = CodegenPackage.GENERATOR__ITERATOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__NAME = CodegenPackage.GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__MERGE = CodegenPackage.GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__FORMAT = CodegenPackage.GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_FEATURE_COUNT = CodegenPackage.GENERATOR_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT___CREATE_CONTEXT__CONTEXT = CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT___VALIDATE__DIAGNOSTICCHAIN_MAP = CodegenPackage.GENERATOR___VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_OPERATION_COUNT = CodegenPackage.GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.java.impl.TextCompilationUnitImpl <em>Text Compilation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.java.impl.TextCompilationUnitImpl
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getTextCompilationUnit()
	 * @generated
	 */
	int TEXT_COMPILATION_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__INCLUDES = COMPILATION_UNIT__INCLUDES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__CONFIGURATION = COMPILATION_UNIT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Default Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__DEFAULT_INCLUDES = COMPILATION_UNIT__DEFAULT_INCLUDES;

	/**
	 * The feature id for the '<em><b>Base URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__BASE_URL = COMPILATION_UNIT__BASE_URL;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__CLASS_PATH = COMPILATION_UNIT__CLASS_PATH;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__INCLUDE = COMPILATION_UNIT__INCLUDE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__ITERATOR = COMPILATION_UNIT__ITERATOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__NAME = COMPILATION_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__MERGE = COMPILATION_UNIT__MERGE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__FORMAT = COMPILATION_UNIT__FORMAT;

	/**
	 * The feature id for the '<em><b>Generator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT__GENERATOR = COMPILATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT_FEATURE_COUNT = COMPILATION_UNIT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT___CREATE_CONTEXT__CONTEXT = COMPILATION_UNIT___CREATE_CONTEXT__CONTEXT;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT___VALIDATE__DIAGNOSTICCHAIN_MAP = COMPILATION_UNIT___VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Text Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_COMPILATION_UNIT_OPERATION_COUNT = COMPILATION_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.java.impl.StructuredCompilationUnitImpl <em>Structured Compilation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.java.impl.StructuredCompilationUnitImpl
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getStructuredCompilationUnit()
	 * @generated
	 */
	int STRUCTURED_COMPILATION_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__INCLUDES = COMPILATION_UNIT__INCLUDES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__CONFIGURATION = COMPILATION_UNIT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Default Includes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__DEFAULT_INCLUDES = COMPILATION_UNIT__DEFAULT_INCLUDES;

	/**
	 * The feature id for the '<em><b>Base URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__BASE_URL = COMPILATION_UNIT__BASE_URL;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__CLASS_PATH = COMPILATION_UNIT__CLASS_PATH;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__INCLUDE = COMPILATION_UNIT__INCLUDE;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__ITERATOR = COMPILATION_UNIT__ITERATOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__NAME = COMPILATION_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__MERGE = COMPILATION_UNIT__MERGE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT__FORMAT = COMPILATION_UNIT__FORMAT;

	/**
	 * The number of structural features of the '<em>Structured Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT_FEATURE_COUNT = COMPILATION_UNIT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT___CREATE_CONTEXT__CONTEXT = COMPILATION_UNIT___CREATE_CONTEXT__CONTEXT;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT___VALIDATE__DIAGNOSTICCHAIN_MAP = COMPILATION_UNIT___VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Structured Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_COMPILATION_UNIT_OPERATION_COUNT = COMPILATION_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>IJava Project</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jdt.core.IJavaProject
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getIJavaProject()
	 * @generated
	 */
	int IJAVA_PROJECT = 6;

	/**
	 * The meta object id for the '<em>IPackage Fragment Root</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jdt.core.IPackageFragmentRoot
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getIPackageFragmentRoot()
	 * @generated
	 */
	int IPACKAGE_FRAGMENT_ROOT = 7;

	/**
	 * The meta object id for the '<em>IPackage Fragment</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jdt.core.IPackageFragment
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getIPackageFragment()
	 * @generated
	 */
	int IPACKAGE_FRAGMENT = 8;

	/**
	 * The meta object id for the '<em>ICompilation Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jdt.core.ICompilationUnit
	 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getICompilationUnit()
	 * @generated
	 */
	int ICOMPILATION_UNIT = 9;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.java.JavaNature <em>Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nature</em>'.
	 * @see org.nasdanika.codegen.java.JavaNature
	 * @generated
	 */
	EClass getJavaNature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.java.JavaNature#getPackagefragmentroots <em>Packagefragmentroots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packagefragmentroots</em>'.
	 * @see org.nasdanika.codegen.java.JavaNature#getPackagefragmentroots()
	 * @see #getJavaNature()
	 * @generated
	 */
	EReference getJavaNature_Packagefragmentroots();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.java.PackageFragmentRoot <em>Package Fragment Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Fragment Root</em>'.
	 * @see org.nasdanika.codegen.java.PackageFragmentRoot
	 * @generated
	 */
	EClass getPackageFragmentRoot();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.java.PackageFragmentRoot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.codegen.java.PackageFragmentRoot#getName()
	 * @see #getPackageFragmentRoot()
	 * @generated
	 */
	EAttribute getPackageFragmentRoot_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.java.PackageFragmentRoot#getPackagefragments <em>Packagefragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packagefragments</em>'.
	 * @see org.nasdanika.codegen.java.PackageFragmentRoot#getPackagefragments()
	 * @see #getPackageFragmentRoot()
	 * @generated
	 */
	EReference getPackageFragmentRoot_Packagefragments();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.java.PackageFragment <em>Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Fragment</em>'.
	 * @see org.nasdanika.codegen.java.PackageFragment
	 * @generated
	 */
	EClass getPackageFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.java.PackageFragment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.codegen.java.PackageFragment#getName()
	 * @see #getPackageFragment()
	 * @generated
	 */
	EAttribute getPackageFragment_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.java.PackageFragment#getCompilationunits <em>Compilationunits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compilationunits</em>'.
	 * @see org.nasdanika.codegen.java.PackageFragment#getCompilationunits()
	 * @see #getPackageFragment()
	 * @generated
	 */
	EReference getPackageFragment_Compilationunits();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.java.CompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compilation Unit</em>'.
	 * @see org.nasdanika.codegen.java.CompilationUnit
	 * @generated
	 */
	EClass getCompilationUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.java.CompilationUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.codegen.java.CompilationUnit#getName()
	 * @see #getCompilationUnit()
	 * @generated
	 */
	EAttribute getCompilationUnit_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.java.CompilationUnit#isMerge <em>Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Merge</em>'.
	 * @see org.nasdanika.codegen.java.CompilationUnit#isMerge()
	 * @see #getCompilationUnit()
	 * @generated
	 */
	EAttribute getCompilationUnit_Merge();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.java.CompilationUnit#isFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.nasdanika.codegen.java.CompilationUnit#isFormat()
	 * @see #getCompilationUnit()
	 * @generated
	 */
	EAttribute getCompilationUnit_Format();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.java.TextCompilationUnit <em>Text Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Compilation Unit</em>'.
	 * @see org.nasdanika.codegen.java.TextCompilationUnit
	 * @generated
	 */
	EClass getTextCompilationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.codegen.java.TextCompilationUnit#getGenerator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Generator</em>'.
	 * @see org.nasdanika.codegen.java.TextCompilationUnit#getGenerator()
	 * @see #getTextCompilationUnit()
	 * @generated
	 */
	EReference getTextCompilationUnit_Generator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.java.StructuredCompilationUnit <em>Structured Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Compilation Unit</em>'.
	 * @see org.nasdanika.codegen.java.StructuredCompilationUnit
	 * @generated
	 */
	EClass getStructuredCompilationUnit();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jdt.core.IJavaProject <em>IJava Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IJava Project</em>'.
	 * @see org.eclipse.jdt.core.IJavaProject
	 * @model instanceClass="org.eclipse.jdt.core.IJavaProject"
	 * @generated
	 */
	EDataType getIJavaProject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jdt.core.IPackageFragmentRoot <em>IPackage Fragment Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IPackage Fragment Root</em>'.
	 * @see org.eclipse.jdt.core.IPackageFragmentRoot
	 * @model instanceClass="org.eclipse.jdt.core.IPackageFragmentRoot"
	 * @generated
	 */
	EDataType getIPackageFragmentRoot();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jdt.core.IPackageFragment <em>IPackage Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IPackage Fragment</em>'.
	 * @see org.eclipse.jdt.core.IPackageFragment
	 * @model instanceClass="org.eclipse.jdt.core.IPackageFragment"
	 * @generated
	 */
	EDataType getIPackageFragment();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jdt.core.ICompilationUnit <em>ICompilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ICompilation Unit</em>'.
	 * @see org.eclipse.jdt.core.ICompilationUnit
	 * @model instanceClass="org.eclipse.jdt.core.ICompilationUnit"
	 * @generated
	 */
	EDataType getICompilationUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavaFactory getJavaFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.codegen.java.impl.JavaNatureImpl <em>Nature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.java.impl.JavaNatureImpl
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getJavaNature()
		 * @generated
		 */
		EClass JAVA_NATURE = eINSTANCE.getJavaNature();

		/**
		 * The meta object literal for the '<em><b>Packagefragmentroots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_NATURE__PACKAGEFRAGMENTROOTS = eINSTANCE.getJavaNature_Packagefragmentroots();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.java.impl.PackageFragmentRootImpl <em>Package Fragment Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.java.impl.PackageFragmentRootImpl
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getPackageFragmentRoot()
		 * @generated
		 */
		EClass PACKAGE_FRAGMENT_ROOT = eINSTANCE.getPackageFragmentRoot();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_FRAGMENT_ROOT__NAME = eINSTANCE.getPackageFragmentRoot_Name();

		/**
		 * The meta object literal for the '<em><b>Packagefragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_FRAGMENT_ROOT__PACKAGEFRAGMENTS = eINSTANCE.getPackageFragmentRoot_Packagefragments();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.java.impl.PackageFragmentImpl <em>Package Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.java.impl.PackageFragmentImpl
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getPackageFragment()
		 * @generated
		 */
		EClass PACKAGE_FRAGMENT = eINSTANCE.getPackageFragment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_FRAGMENT__NAME = eINSTANCE.getPackageFragment_Name();

		/**
		 * The meta object literal for the '<em><b>Compilationunits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_FRAGMENT__COMPILATIONUNITS = eINSTANCE.getPackageFragment_Compilationunits();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.java.impl.CompilationUnitImpl <em>Compilation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.java.impl.CompilationUnitImpl
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getCompilationUnit()
		 * @generated
		 */
		EClass COMPILATION_UNIT = eINSTANCE.getCompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILATION_UNIT__NAME = eINSTANCE.getCompilationUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Merge</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILATION_UNIT__MERGE = eINSTANCE.getCompilationUnit_Merge();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILATION_UNIT__FORMAT = eINSTANCE.getCompilationUnit_Format();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.java.impl.TextCompilationUnitImpl <em>Text Compilation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.java.impl.TextCompilationUnitImpl
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getTextCompilationUnit()
		 * @generated
		 */
		EClass TEXT_COMPILATION_UNIT = eINSTANCE.getTextCompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Generator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_COMPILATION_UNIT__GENERATOR = eINSTANCE.getTextCompilationUnit_Generator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.java.impl.StructuredCompilationUnitImpl <em>Structured Compilation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.java.impl.StructuredCompilationUnitImpl
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getStructuredCompilationUnit()
		 * @generated
		 */
		EClass STRUCTURED_COMPILATION_UNIT = eINSTANCE.getStructuredCompilationUnit();

		/**
		 * The meta object literal for the '<em>IJava Project</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jdt.core.IJavaProject
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getIJavaProject()
		 * @generated
		 */
		EDataType IJAVA_PROJECT = eINSTANCE.getIJavaProject();

		/**
		 * The meta object literal for the '<em>IPackage Fragment Root</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jdt.core.IPackageFragmentRoot
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getIPackageFragmentRoot()
		 * @generated
		 */
		EDataType IPACKAGE_FRAGMENT_ROOT = eINSTANCE.getIPackageFragmentRoot();

		/**
		 * The meta object literal for the '<em>IPackage Fragment</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jdt.core.IPackageFragment
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getIPackageFragment()
		 * @generated
		 */
		EDataType IPACKAGE_FRAGMENT = eINSTANCE.getIPackageFragment();

		/**
		 * The meta object literal for the '<em>ICompilation Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jdt.core.ICompilationUnit
		 * @see org.nasdanika.codegen.java.impl.JavaPackageImpl#getICompilationUnit()
		 * @generated
		 */
		EDataType ICOMPILATION_UNIT = eINSTANCE.getICompilationUnit();

	}

} //JavaPackage
