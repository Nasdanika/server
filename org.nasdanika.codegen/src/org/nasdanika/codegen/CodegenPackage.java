/**
 */
package org.nasdanika.codegen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.nasdanika.codegen.CodegenFactory
 * @model kind="package"
 * @generated
 */
public interface CodegenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "codegen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.codegen";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.codegen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodegenPackage eINSTANCE = org.nasdanika.codegen.impl.CodegenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.ConfigurableImpl <em>Configurable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.ConfigurableImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getConfigurable()
	 * @generated
	 */
	int CONFIGURABLE = 0;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE__PROPERTIES_REFERENCES = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE__PROPERTIES = 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE__SERVICES = 2;

	/**
	 * The number of structural features of the '<em>Configurable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Configurable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.ServiceImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 1;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROPERTIES_REFERENCES = CONFIGURABLE__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROPERTIES = CONFIGURABLE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICES = CONFIGURABLE__SERVICES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TYPE = CONFIGURABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__IMPLEMENTATION = CONFIGURABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = CONFIGURABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = CONFIGURABLE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = CONFIGURABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.PropertyImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__PROPERTIES_REFERENCES = CONFIGURABLE__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__PROPERTIES = CONFIGURABLE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SERVICES = CONFIGURABLE__SERVICES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = CONFIGURABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = CONFIGURABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = CONFIGURABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTION = CONFIGURABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = CONFIGURABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = CONFIGURABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.ContextProviderImpl <em>Context Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.ContextProviderImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getContextProvider()
	 * @generated
	 */
	int CONTEXT_PROVIDER = 3;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PROVIDER__PROPERTIES_REFERENCES = CONFIGURABLE__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PROVIDER__PROPERTIES = CONFIGURABLE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PROVIDER__SERVICES = CONFIGURABLE__SERVICES;

	/**
	 * The number of structural features of the '<em>Context Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PROVIDER_FEATURE_COUNT = CONFIGURABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PROVIDER___CREATE_CONTEXT__CONTEXT_BOOLEAN = CONFIGURABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Context Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PROVIDER_OPERATION_COUNT = CONFIGURABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.IGenerator <em>IGenerator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.IGenerator
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIGenerator()
	 * @generated
	 */
	int IGENERATOR = 4;

	/**
	 * The number of structural features of the '<em>IGenerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGENERATOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IGenerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGENERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.GeneratorImpl <em>Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.GeneratorImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getGenerator()
	 * @generated
	 */
	int GENERATOR = 5;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR__PROPERTIES_REFERENCES = IGENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR__PROPERTIES = IGENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR__SERVICES = IGENERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_FEATURE_COUNT = IGENERATOR_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN = IGENERATOR_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_OPERATION_COUNT = IGENERATOR_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.GroupImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 6;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__PROPERTIES_REFERENCES = GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__PROPERTIES = GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__SERVICES = GENERATOR__SERVICES;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ITERATOR = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__SELECTOR = GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__MEMBERS = GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP___CREATE_CONTEXT__CONTEXT_BOOLEAN = GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.ResourceGeneratorImpl <em>Resource Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.ResourceGeneratorImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getResourceGenerator()
	 * @generated
	 */
	int RESOURCE_GENERATOR = 7;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_GENERATOR__PROPERTIES_REFERENCES = GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_GENERATOR__PROPERTIES = GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_GENERATOR__SERVICES = GENERATOR__SERVICES;

	/**
	 * The number of structural features of the '<em>Resource Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_GENERATOR_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN = GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Resource Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_GENERATOR_OPERATION_COUNT = GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.WorkspaceRootImpl <em>Workspace Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.WorkspaceRootImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getWorkspaceRoot()
	 * @generated
	 */
	int WORKSPACE_ROOT = 8;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__PROPERTIES_REFERENCES = RESOURCE_GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__PROPERTIES = RESOURCE_GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__SERVICES = RESOURCE_GENERATOR__SERVICES;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__PROJECTS = RESOURCE_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Workspace Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT_FEATURE_COUNT = RESOURCE_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT___CREATE_CONTEXT__CONTEXT_BOOLEAN = RESOURCE_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Workspace Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT_OPERATION_COUNT = RESOURCE_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.ResourceImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Reconcile Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RECONCILE_ACTION = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.FolderImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Reconcile Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__RECONCILE_ACTION = RESOURCE__RECONCILE_ACTION;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__PROPERTIES_REFERENCES = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__PROPERTIES = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__SERVICES = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__CHILDREN = RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER___CREATE_CONTEXT__CONTEXT_BOOLEAN = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.NatureImpl <em>Nature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.NatureImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getNature()
	 * @generated
	 */
	int NATURE = 10;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURE__PROPERTIES_REFERENCES = GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURE__PROPERTIES = GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURE__SERVICES = GENERATOR__SERVICES;

	/**
	 * The number of structural features of the '<em>Nature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURE_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURE___CREATE_CONTEXT__CONTEXT_BOOLEAN = GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Nature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURE_OPERATION_COUNT = GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.FileImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Reconcile Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__RECONCILE_ACTION = RESOURCE__RECONCILE_ACTION;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PROPERTIES_REFERENCES = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PROPERTIES = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__SERVICES = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE___CREATE_CONTEXT__CONTEXT_BOOLEAN = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.TextGeneratorImpl <em>Text Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.TextGeneratorImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextGenerator()
	 * @generated
	 */
	int TEXT_GENERATOR = 12;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_GENERATOR__PROPERTIES_REFERENCES = GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_GENERATOR__PROPERTIES = GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_GENERATOR__SERVICES = GENERATOR__SERVICES;

	/**
	 * The number of structural features of the '<em>Text Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_GENERATOR_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN = GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Text Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_GENERATOR_OPERATION_COUNT = GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.StreamGeneratorImpl <em>Stream Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.StreamGeneratorImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getStreamGenerator()
	 * @generated
	 */
	int STREAM_GENERATOR = 13;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_GENERATOR__PROPERTIES_REFERENCES = GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_GENERATOR__PROPERTIES = GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_GENERATOR__SERVICES = GENERATOR__SERVICES;

	/**
	 * The number of structural features of the '<em>Stream Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_GENERATOR_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN = GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Stream Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_GENERATOR_OPERATION_COUNT = GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.ProjectImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 14;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PROPERTIES_REFERENCES = RESOURCE_GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PROPERTIES = RESOURCE_GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SERVICES = RESOURCE_GENERATOR__SERVICES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = RESOURCE_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Natures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NATURES = RESOURCE_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__RESOURCES = RESOURCE_GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reconcile Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__RECONCILE_ACTION = RESOURCE_GENERATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = RESOURCE_GENERATOR_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___CREATE_CONTEXT__CONTEXT_BOOLEAN = RESOURCE_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = RESOURCE_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.BinaryFileImpl <em>Binary File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.BinaryFileImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getBinaryFile()
	 * @generated
	 */
	int BINARY_FILE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE__NAME = FILE__NAME;

	/**
	 * The feature id for the '<em><b>Reconcile Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE__RECONCILE_ACTION = FILE__RECONCILE_ACTION;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE__PROPERTIES_REFERENCES = FILE__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE__PROPERTIES = FILE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE__SERVICES = FILE__SERVICES;

	/**
	 * The feature id for the '<em><b>Streamgenerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE__STREAMGENERATOR = FILE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Binary File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE_FEATURE_COUNT = FILE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE___CREATE_CONTEXT__CONTEXT_BOOLEAN = FILE___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Binary File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FILE_OPERATION_COUNT = FILE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.TextFileImpl <em>Text File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.TextFileImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextFile()
	 * @generated
	 */
	int TEXT_FILE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE__NAME = FILE__NAME;

	/**
	 * The feature id for the '<em><b>Reconcile Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE__RECONCILE_ACTION = FILE__RECONCILE_ACTION;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE__PROPERTIES_REFERENCES = FILE__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE__PROPERTIES = FILE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE__SERVICES = FILE__SERVICES;

	/**
	 * The feature id for the '<em><b>Textgenerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE__TEXTGENERATOR = FILE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE_FEATURE_COUNT = FILE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE___CREATE_CONTEXT__CONTEXT_BOOLEAN = FILE___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Text File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILE_OPERATION_COUNT = FILE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.ResourceReferenceImpl <em>Resource Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.ResourceReferenceImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getResourceReference()
	 * @generated
	 */
	int RESOURCE_REFERENCE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Reconcile Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE__RECONCILE_ACTION = RESOURCE__RECONCILE_ACTION;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE__TARGET = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.StaticTextImpl <em>Static Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.StaticTextImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getStaticText()
	 * @generated
	 */
	int STATIC_TEXT = 19;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_TEXT__PROPERTIES_REFERENCES = TEXT_GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_TEXT__PROPERTIES = TEXT_GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_TEXT__SERVICES = TEXT_GENERATOR__SERVICES;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_TEXT__CONTENT = TEXT_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Static Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_TEXT_FEATURE_COUNT = TEXT_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_TEXT___CREATE_CONTEXT__CONTEXT_BOOLEAN = TEXT_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Static Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_TEXT_OPERATION_COUNT = TEXT_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.TextReferenceImpl <em>Text Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.TextReferenceImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextReference()
	 * @generated
	 */
	int TEXT_REFERENCE = 20;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__PROPERTIES_REFERENCES = TEXT_GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__PROPERTIES = TEXT_GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__SERVICES = TEXT_GENERATOR__SERVICES;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE__REF = TEXT_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE_FEATURE_COUNT = TEXT_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE___CREATE_CONTEXT__CONTEXT_BOOLEAN = TEXT_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Text Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REFERENCE_OPERATION_COUNT = TEXT_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.TextFilterImpl <em>Text Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.TextFilterImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextFilter()
	 * @generated
	 */
	int TEXT_FILTER = 21;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILTER__PROPERTIES_REFERENCES = TEXT_GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILTER__PROPERTIES = TEXT_GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILTER__SERVICES = TEXT_GENERATOR__SERVICES;

	/**
	 * The feature id for the '<em><b>Textgenerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILTER__TEXTGENERATOR = TEXT_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILTER_FEATURE_COUNT = TEXT_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILTER___CREATE_CONTEXT__CONTEXT_BOOLEAN = TEXT_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Text Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FILTER_OPERATION_COUNT = TEXT_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.JavaTextGeneratorImpl <em>Java Text Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.JavaTextGeneratorImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getJavaTextGenerator()
	 * @generated
	 */
	int JAVA_TEXT_GENERATOR = 22;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_GENERATOR__PROPERTIES_REFERENCES = TEXT_GENERATOR__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_GENERATOR__PROPERTIES = TEXT_GENERATOR__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_GENERATOR__SERVICES = TEXT_GENERATOR__SERVICES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_GENERATOR__CLASS_NAME = TEXT_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Text Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_GENERATOR_FEATURE_COUNT = TEXT_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN = TEXT_GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Java Text Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_GENERATOR_OPERATION_COUNT = TEXT_GENERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.InterpolatorImpl <em>Interpolator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.InterpolatorImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getInterpolator()
	 * @generated
	 */
	int INTERPOLATOR = 23;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERPOLATOR__PROPERTIES_REFERENCES = TEXT_FILTER__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERPOLATOR__PROPERTIES = TEXT_FILTER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERPOLATOR__SERVICES = TEXT_FILTER__SERVICES;

	/**
	 * The feature id for the '<em><b>Textgenerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERPOLATOR__TEXTGENERATOR = TEXT_FILTER__TEXTGENERATOR;

	/**
	 * The number of structural features of the '<em>Interpolator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERPOLATOR_FEATURE_COUNT = TEXT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERPOLATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN = TEXT_FILTER___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Interpolator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERPOLATOR_OPERATION_COUNT = TEXT_FILTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.impl.JavaTextFilterImpl <em>Java Text Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.impl.JavaTextFilterImpl
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getJavaTextFilter()
	 * @generated
	 */
	int JAVA_TEXT_FILTER = 24;

	/**
	 * The feature id for the '<em><b>Properties References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER__PROPERTIES_REFERENCES = TEXT_FILTER__PROPERTIES_REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER__PROPERTIES = TEXT_FILTER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER__SERVICES = TEXT_FILTER__SERVICES;

	/**
	 * The feature id for the '<em><b>Textgenerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER__TEXTGENERATOR = TEXT_FILTER__TEXTGENERATOR;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER__CLASS_NAME = TEXT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Text Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER_FEATURE_COUNT = TEXT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER___CREATE_CONTEXT__CONTEXT_BOOLEAN = TEXT_FILTER___CREATE_CONTEXT__CONTEXT_BOOLEAN;

	/**
	 * The number of operations of the '<em>Java Text Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_TEXT_FILTER_OPERATION_COUNT = TEXT_FILTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.codegen.ReconcileAction <em>Reconcile Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.ReconcileAction
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getReconcileAction()
	 * @generated
	 */
	int RECONCILE_ACTION = 25;

	/**
	 * The meta object id for the '<em>Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.codegen.Context
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 26;

	/**
	 * The meta object id for the '<em>Input Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.InputStream
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getInputStream()
	 * @generated
	 */
	int INPUT_STREAM = 27;

	/**
	 * The meta object id for the '<em>Void</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Void
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getVoid()
	 * @generated
	 */
	int VOID = 28;

	/**
	 * The meta object id for the '<em>IFile</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IFile
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIFile()
	 * @generated
	 */
	int IFILE = 29;

	/**
	 * The meta object id for the '<em>IFolder</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IFolder
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIFolder()
	 * @generated
	 */
	int IFOLDER = 30;

	/**
	 * The meta object id for the '<em>IProject</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IProject
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIProject()
	 * @generated
	 */
	int IPROJECT = 31;

	/**
	 * The meta object id for the '<em>IProject Nature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IProjectNature
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIProjectNature()
	 * @generated
	 */
	int IPROJECT_NATURE = 32;

	/**
	 * The meta object id for the '<em>IWorkspace Root</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IWorkspaceRoot
	 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIWorkspaceRoot()
	 * @generated
	 */
	int IWORKSPACE_ROOT = 33;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Configurable <em>Configurable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configurable</em>'.
	 * @see org.nasdanika.codegen.Configurable
	 * @generated
	 */
	EClass getConfigurable();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.codegen.Configurable#getPropertiesReferences <em>Properties References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Properties References</em>'.
	 * @see org.nasdanika.codegen.Configurable#getPropertiesReferences()
	 * @see #getConfigurable()
	 * @generated
	 */
	EAttribute getConfigurable_PropertiesReferences();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.Configurable#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.nasdanika.codegen.Configurable#getProperties()
	 * @see #getConfigurable()
	 * @generated
	 */
	EReference getConfigurable_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.Configurable#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see org.nasdanika.codegen.Configurable#getServices()
	 * @see #getConfigurable()
	 * @generated
	 */
	EReference getConfigurable_Services();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.nasdanika.codegen.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Service#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.codegen.Service#getType()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Service#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.nasdanika.codegen.Service#getImplementation()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Implementation();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Service#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.codegen.Service#getDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Description();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.nasdanika.codegen.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.codegen.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.codegen.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.codegen.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Property#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.codegen.Property#getDescription()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Description();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.ContextProvider <em>Context Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Provider</em>'.
	 * @see org.nasdanika.codegen.ContextProvider
	 * @generated
	 */
	EClass getContextProvider();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.codegen.ContextProvider#createContext(org.nasdanika.codegen.Context, boolean) <em>Create Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Context</em>' operation.
	 * @see org.nasdanika.codegen.ContextProvider#createContext(org.nasdanika.codegen.Context, boolean)
	 * @generated
	 */
	EOperation getContextProvider__CreateContext__Context_boolean();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.IGenerator <em>IGenerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGenerator</em>'.
	 * @see org.nasdanika.codegen.IGenerator
	 * @model instanceClass="org.nasdanika.codegen.IGenerator" typeParameters="T"
	 * @generated
	 */
	EClass getIGenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Generator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator</em>'.
	 * @see org.nasdanika.codegen.Generator
	 * @generated
	 */
	EClass getGenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.nasdanika.codegen.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Group#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iterator</em>'.
	 * @see org.nasdanika.codegen.Group#getIterator()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Iterator();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Group#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selector</em>'.
	 * @see org.nasdanika.codegen.Group#getSelector()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Selector();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.Group#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.nasdanika.codegen.Group#getMembers()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Members();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.ResourceGenerator <em>Resource Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Generator</em>'.
	 * @see org.nasdanika.codegen.ResourceGenerator
	 * @generated
	 */
	EClass getResourceGenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.WorkspaceRoot <em>Workspace Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace Root</em>'.
	 * @see org.nasdanika.codegen.WorkspaceRoot
	 * @generated
	 */
	EClass getWorkspaceRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.WorkspaceRoot#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see org.nasdanika.codegen.WorkspaceRoot#getProjects()
	 * @see #getWorkspaceRoot()
	 * @generated
	 */
	EReference getWorkspaceRoot_Projects();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see org.nasdanika.codegen.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.Folder#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.codegen.Folder#getChildren()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_Children();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Nature <em>Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nature</em>'.
	 * @see org.nasdanika.codegen.Nature
	 * @generated
	 */
	EClass getNature();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see org.nasdanika.codegen.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.TextGenerator <em>Text Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Generator</em>'.
	 * @see org.nasdanika.codegen.TextGenerator
	 * @generated
	 */
	EClass getTextGenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.StreamGenerator <em>Stream Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Generator</em>'.
	 * @see org.nasdanika.codegen.StreamGenerator
	 * @generated
	 */
	EClass getStreamGenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.nasdanika.codegen.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.codegen.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.Project#getNatures <em>Natures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Natures</em>'.
	 * @see org.nasdanika.codegen.Project#getNatures()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Natures();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.codegen.Project#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.nasdanika.codegen.Project#getResources()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Resources();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Project#getReconcileAction <em>Reconcile Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reconcile Action</em>'.
	 * @see org.nasdanika.codegen.Project#getReconcileAction()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_ReconcileAction();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.nasdanika.codegen.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.codegen.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.Resource#getReconcileAction <em>Reconcile Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reconcile Action</em>'.
	 * @see org.nasdanika.codegen.Resource#getReconcileAction()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_ReconcileAction();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.BinaryFile <em>Binary File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary File</em>'.
	 * @see org.nasdanika.codegen.BinaryFile
	 * @generated
	 */
	EClass getBinaryFile();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.codegen.BinaryFile#getStreamgenerator <em>Streamgenerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Streamgenerator</em>'.
	 * @see org.nasdanika.codegen.BinaryFile#getStreamgenerator()
	 * @see #getBinaryFile()
	 * @generated
	 */
	EReference getBinaryFile_Streamgenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.TextFile <em>Text File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text File</em>'.
	 * @see org.nasdanika.codegen.TextFile
	 * @generated
	 */
	EClass getTextFile();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.codegen.TextFile#getTextgenerator <em>Textgenerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Textgenerator</em>'.
	 * @see org.nasdanika.codegen.TextFile#getTextgenerator()
	 * @see #getTextFile()
	 * @generated
	 */
	EReference getTextFile_Textgenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.ResourceReference <em>Resource Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Reference</em>'.
	 * @see org.nasdanika.codegen.ResourceReference
	 * @generated
	 */
	EClass getResourceReference();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.codegen.ResourceReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.codegen.ResourceReference#getTarget()
	 * @see #getResourceReference()
	 * @generated
	 */
	EReference getResourceReference_Target();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.StaticText <em>Static Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Text</em>'.
	 * @see org.nasdanika.codegen.StaticText
	 * @generated
	 */
	EClass getStaticText();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.StaticText#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.nasdanika.codegen.StaticText#getContent()
	 * @see #getStaticText()
	 * @generated
	 */
	EAttribute getStaticText_Content();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.TextReference <em>Text Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Reference</em>'.
	 * @see org.nasdanika.codegen.TextReference
	 * @generated
	 */
	EClass getTextReference();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.TextReference#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see org.nasdanika.codegen.TextReference#getRef()
	 * @see #getTextReference()
	 * @generated
	 */
	EAttribute getTextReference_Ref();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.TextFilter <em>Text Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Filter</em>'.
	 * @see org.nasdanika.codegen.TextFilter
	 * @generated
	 */
	EClass getTextFilter();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.codegen.TextFilter#getTextgenerator <em>Textgenerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Textgenerator</em>'.
	 * @see org.nasdanika.codegen.TextFilter#getTextgenerator()
	 * @see #getTextFilter()
	 * @generated
	 */
	EReference getTextFilter_Textgenerator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.JavaTextGenerator <em>Java Text Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Text Generator</em>'.
	 * @see org.nasdanika.codegen.JavaTextGenerator
	 * @generated
	 */
	EClass getJavaTextGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.JavaTextGenerator#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.nasdanika.codegen.JavaTextGenerator#getClassName()
	 * @see #getJavaTextGenerator()
	 * @generated
	 */
	EAttribute getJavaTextGenerator_ClassName();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.Interpolator <em>Interpolator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interpolator</em>'.
	 * @see org.nasdanika.codegen.Interpolator
	 * @generated
	 */
	EClass getInterpolator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.codegen.JavaTextFilter <em>Java Text Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Text Filter</em>'.
	 * @see org.nasdanika.codegen.JavaTextFilter
	 * @generated
	 */
	EClass getJavaTextFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.codegen.JavaTextFilter#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.nasdanika.codegen.JavaTextFilter#getClassName()
	 * @see #getJavaTextFilter()
	 * @generated
	 */
	EAttribute getJavaTextFilter_ClassName();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.codegen.ReconcileAction <em>Reconcile Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reconcile Action</em>'.
	 * @see org.nasdanika.codegen.ReconcileAction
	 * @generated
	 */
	EEnum getReconcileAction();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.codegen.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Context</em>'.
	 * @see org.nasdanika.codegen.Context
	 * @model instanceClass="org.nasdanika.codegen.Context"
	 * @generated
	 */
	EDataType getContext();

	/**
	 * Returns the meta object for data type '{@link java.io.InputStream <em>Input Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Input Stream</em>'.
	 * @see java.io.InputStream
	 * @model instanceClass="java.io.InputStream"
	 * @generated
	 */
	EDataType getInputStream();

	/**
	 * Returns the meta object for data type '{@link java.lang.Void <em>Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Void</em>'.
	 * @see java.lang.Void
	 * @model instanceClass="java.lang.Void"
	 * @generated
	 */
	EDataType getVoid();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IFile <em>IFile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IFile</em>'.
	 * @see org.eclipse.core.resources.IFile
	 * @model instanceClass="org.eclipse.core.resources.IFile"
	 * @generated
	 */
	EDataType getIFile();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IFolder <em>IFolder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IFolder</em>'.
	 * @see org.eclipse.core.resources.IFolder
	 * @model instanceClass="org.eclipse.core.resources.IFolder"
	 * @generated
	 */
	EDataType getIFolder();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IProject <em>IProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProject</em>'.
	 * @see org.eclipse.core.resources.IProject
	 * @model instanceClass="org.eclipse.core.resources.IProject"
	 * @generated
	 */
	EDataType getIProject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IProjectNature <em>IProject Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProject Nature</em>'.
	 * @see org.eclipse.core.resources.IProjectNature
	 * @model instanceClass="org.eclipse.core.resources.IProjectNature"
	 * @generated
	 */
	EDataType getIProjectNature();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IWorkspaceRoot <em>IWorkspace Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IWorkspace Root</em>'.
	 * @see org.eclipse.core.resources.IWorkspaceRoot
	 * @model instanceClass="org.eclipse.core.resources.IWorkspaceRoot"
	 * @generated
	 */
	EDataType getIWorkspaceRoot();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CodegenFactory getCodegenFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.ConfigurableImpl <em>Configurable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.ConfigurableImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getConfigurable()
		 * @generated
		 */
		EClass CONFIGURABLE = eINSTANCE.getConfigurable();

		/**
		 * The meta object literal for the '<em><b>Properties References</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURABLE__PROPERTIES_REFERENCES = eINSTANCE.getConfigurable_PropertiesReferences();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE__PROPERTIES = eINSTANCE.getConfigurable_Properties();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE__SERVICES = eINSTANCE.getConfigurable_Services();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.ServiceImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__TYPE = eINSTANCE.getService_Type();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__IMPLEMENTATION = eINSTANCE.getService_Implementation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__DESCRIPTION = eINSTANCE.getService_Description();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.PropertyImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DESCRIPTION = eINSTANCE.getProperty_Description();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.ContextProviderImpl <em>Context Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.ContextProviderImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getContextProvider()
		 * @generated
		 */
		EClass CONTEXT_PROVIDER = eINSTANCE.getContextProvider();

		/**
		 * The meta object literal for the '<em><b>Create Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT_PROVIDER___CREATE_CONTEXT__CONTEXT_BOOLEAN = eINSTANCE.getContextProvider__CreateContext__Context_boolean();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.IGenerator <em>IGenerator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.IGenerator
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIGenerator()
		 * @generated
		 */
		EClass IGENERATOR = eINSTANCE.getIGenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.GeneratorImpl <em>Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.GeneratorImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getGenerator()
		 * @generated
		 */
		EClass GENERATOR = eINSTANCE.getGenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.GroupImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__ITERATOR = eINSTANCE.getGroup_Iterator();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__SELECTOR = eINSTANCE.getGroup_Selector();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__MEMBERS = eINSTANCE.getGroup_Members();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.ResourceGeneratorImpl <em>Resource Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.ResourceGeneratorImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getResourceGenerator()
		 * @generated
		 */
		EClass RESOURCE_GENERATOR = eINSTANCE.getResourceGenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.WorkspaceRootImpl <em>Workspace Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.WorkspaceRootImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getWorkspaceRoot()
		 * @generated
		 */
		EClass WORKSPACE_ROOT = eINSTANCE.getWorkspaceRoot();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_ROOT__PROJECTS = eINSTANCE.getWorkspaceRoot_Projects();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.FolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.FolderImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER__CHILDREN = eINSTANCE.getFolder_Children();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.NatureImpl <em>Nature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.NatureImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getNature()
		 * @generated
		 */
		EClass NATURE = eINSTANCE.getNature();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.FileImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.TextGeneratorImpl <em>Text Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.TextGeneratorImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextGenerator()
		 * @generated
		 */
		EClass TEXT_GENERATOR = eINSTANCE.getTextGenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.StreamGeneratorImpl <em>Stream Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.StreamGeneratorImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getStreamGenerator()
		 * @generated
		 */
		EClass STREAM_GENERATOR = eINSTANCE.getStreamGenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.ProjectImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Natures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__NATURES = eINSTANCE.getProject_Natures();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__RESOURCES = eINSTANCE.getProject_Resources();

		/**
		 * The meta object literal for the '<em><b>Reconcile Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__RECONCILE_ACTION = eINSTANCE.getProject_ReconcileAction();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.ResourceImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>Reconcile Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__RECONCILE_ACTION = eINSTANCE.getResource_ReconcileAction();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.BinaryFileImpl <em>Binary File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.BinaryFileImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getBinaryFile()
		 * @generated
		 */
		EClass BINARY_FILE = eINSTANCE.getBinaryFile();

		/**
		 * The meta object literal for the '<em><b>Streamgenerator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_FILE__STREAMGENERATOR = eINSTANCE.getBinaryFile_Streamgenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.TextFileImpl <em>Text File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.TextFileImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextFile()
		 * @generated
		 */
		EClass TEXT_FILE = eINSTANCE.getTextFile();

		/**
		 * The meta object literal for the '<em><b>Textgenerator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_FILE__TEXTGENERATOR = eINSTANCE.getTextFile_Textgenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.ResourceReferenceImpl <em>Resource Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.ResourceReferenceImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getResourceReference()
		 * @generated
		 */
		EClass RESOURCE_REFERENCE = eINSTANCE.getResourceReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REFERENCE__TARGET = eINSTANCE.getResourceReference_Target();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.StaticTextImpl <em>Static Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.StaticTextImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getStaticText()
		 * @generated
		 */
		EClass STATIC_TEXT = eINSTANCE.getStaticText();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_TEXT__CONTENT = eINSTANCE.getStaticText_Content();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.TextReferenceImpl <em>Text Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.TextReferenceImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextReference()
		 * @generated
		 */
		EClass TEXT_REFERENCE = eINSTANCE.getTextReference();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_REFERENCE__REF = eINSTANCE.getTextReference_Ref();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.TextFilterImpl <em>Text Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.TextFilterImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getTextFilter()
		 * @generated
		 */
		EClass TEXT_FILTER = eINSTANCE.getTextFilter();

		/**
		 * The meta object literal for the '<em><b>Textgenerator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_FILTER__TEXTGENERATOR = eINSTANCE.getTextFilter_Textgenerator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.JavaTextGeneratorImpl <em>Java Text Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.JavaTextGeneratorImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getJavaTextGenerator()
		 * @generated
		 */
		EClass JAVA_TEXT_GENERATOR = eINSTANCE.getJavaTextGenerator();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_TEXT_GENERATOR__CLASS_NAME = eINSTANCE.getJavaTextGenerator_ClassName();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.InterpolatorImpl <em>Interpolator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.InterpolatorImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getInterpolator()
		 * @generated
		 */
		EClass INTERPOLATOR = eINSTANCE.getInterpolator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.impl.JavaTextFilterImpl <em>Java Text Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.impl.JavaTextFilterImpl
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getJavaTextFilter()
		 * @generated
		 */
		EClass JAVA_TEXT_FILTER = eINSTANCE.getJavaTextFilter();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_TEXT_FILTER__CLASS_NAME = eINSTANCE.getJavaTextFilter_ClassName();

		/**
		 * The meta object literal for the '{@link org.nasdanika.codegen.ReconcileAction <em>Reconcile Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.ReconcileAction
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getReconcileAction()
		 * @generated
		 */
		EEnum RECONCILE_ACTION = eINSTANCE.getReconcileAction();

		/**
		 * The meta object literal for the '<em>Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.codegen.Context
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getContext()
		 * @generated
		 */
		EDataType CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em>Input Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.InputStream
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getInputStream()
		 * @generated
		 */
		EDataType INPUT_STREAM = eINSTANCE.getInputStream();

		/**
		 * The meta object literal for the '<em>Void</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Void
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getVoid()
		 * @generated
		 */
		EDataType VOID = eINSTANCE.getVoid();

		/**
		 * The meta object literal for the '<em>IFile</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IFile
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIFile()
		 * @generated
		 */
		EDataType IFILE = eINSTANCE.getIFile();

		/**
		 * The meta object literal for the '<em>IFolder</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IFolder
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIFolder()
		 * @generated
		 */
		EDataType IFOLDER = eINSTANCE.getIFolder();

		/**
		 * The meta object literal for the '<em>IProject</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IProject
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIProject()
		 * @generated
		 */
		EDataType IPROJECT = eINSTANCE.getIProject();

		/**
		 * The meta object literal for the '<em>IProject Nature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IProjectNature
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIProjectNature()
		 * @generated
		 */
		EDataType IPROJECT_NATURE = eINSTANCE.getIProjectNature();

		/**
		 * The meta object literal for the '<em>IWorkspace Root</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IWorkspaceRoot
		 * @see org.nasdanika.codegen.impl.CodegenPackageImpl#getIWorkspaceRoot()
		 * @generated
		 */
		EDataType IWORKSPACE_ROOT = eINSTANCE.getIWorkspaceRoot();

	}

} //CodegenPackage
