/**
 */
package org.nasdanika.sca;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.nasdanika.sca.ScaFactory
 * @model kind="package"
 * @generated
 */
public interface ScaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sca";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.sca";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.sca";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScaPackage eINSTANCE = org.nasdanika.sca.impl.ScaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.AbstractComponentImpl <em>Abstract Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.AbstractComponentImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getAbstractComponent()
	 * @generated
	 */
	int ABSTRACT_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT__CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT__SERVICES = 3;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT__REFERENCES = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT__PROPERTIES = 5;

	/**
	 * The number of structural features of the '<em>Abstract Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Create Runtime Component</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT___CREATE_RUNTIME_COMPONENT = 0;

	/**
	 * The number of operations of the '<em>Abstract Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPONENT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.ComponentImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = ABSTRACT_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DESCRIPTION = ABSTRACT_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CONFIGURATION = ABSTRACT_COMPONENT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SERVICES = ABSTRACT_COMPONENT__SERVICES;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REFERENCES = ABSTRACT_COMPONENT__REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROPERTIES = ABSTRACT_COMPONENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__IMPLEMENTATION = ABSTRACT_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__IMPLEMENTATION_CLASS = ABSTRACT_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Immediately Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__IMMEDIATELY_ACTIVATED = ABSTRACT_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = ABSTRACT_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Runtime Component</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT___CREATE_RUNTIME_COMPONENT = ABSTRACT_COMPONENT___CREATE_RUNTIME_COMPONENT;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = ABSTRACT_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.CompositeImpl <em>Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.CompositeImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getComposite()
	 * @generated
	 */
	int COMPOSITE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__NAME = ABSTRACT_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__DESCRIPTION = ABSTRACT_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__CONFIGURATION = ABSTRACT_COMPONENT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__SERVICES = ABSTRACT_COMPONENT__SERVICES;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__REFERENCES = ABSTRACT_COMPONENT__REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__PROPERTIES = ABSTRACT_COMPONENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__COMPONENTS = ABSTRACT_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exported Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__EXPORTED_SERVICES = ABSTRACT_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Imported References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__IMPORTED_REFERENCES = ABSTRACT_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Imported Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__IMPORTED_PROPERTIES = ABSTRACT_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__IMPLEMENTATION = ABSTRACT_COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__IMPLEMENTATION_CLASS = ABSTRACT_COMPONENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FEATURE_COUNT = ABSTRACT_COMPONENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Create Runtime Component</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE___CREATE_RUNTIME_COMPONENT = ABSTRACT_COMPONENT___CREATE_RUNTIME_COMPONENT;

	/**
	 * The number of operations of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION_COUNT = ABSTRACT_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.CompositeReferenceImpl <em>Composite Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.CompositeReferenceImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getCompositeReference()
	 * @generated
	 */
	int COMPOSITE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__NAME = ABSTRACT_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__DESCRIPTION = ABSTRACT_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__CONFIGURATION = ABSTRACT_COMPONENT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__SERVICES = ABSTRACT_COMPONENT__SERVICES;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__REFERENCES = ABSTRACT_COMPONENT__REFERENCES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__PROPERTIES = ABSTRACT_COMPONENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE__TARGET = ABSTRACT_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE_FEATURE_COUNT = ABSTRACT_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Runtime Component</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE___CREATE_RUNTIME_COMPONENT = ABSTRACT_COMPONENT___CREATE_RUNTIME_COMPONENT;

	/**
	 * The number of operations of the '<em>Composite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_REFERENCE_OPERATION_COUNT = ABSTRACT_COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.Wireable <em>Wireable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.Wireable
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getWireable()
	 * @generated
	 */
	int WIREABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIREABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIREABLE__CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Wireable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIREABLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Wireable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIREABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.WireSource <em>Wire Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.WireSource
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getWireSource()
	 * @generated
	 */
	int WIRE_SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_SOURCE__NAME = WIREABLE__NAME;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_SOURCE__CONFIGURATION = WIREABLE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Wire Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_SOURCE__WIRE_TARGET = WIREABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wire Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_SOURCE_FEATURE_COUNT = WIREABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Wire Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_SOURCE_OPERATION_COUNT = WIREABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.ReferenceImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 7;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.WireTarget <em>Wire Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.WireTarget
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getWireTarget()
	 * @generated
	 */
	int WIRE_TARGET = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TARGET__NAME = WIREABLE__NAME;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TARGET__CONFIGURATION = WIREABLE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TARGET__TYPE = WIREABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wire Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TARGET_FEATURE_COUNT = WIREABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Wire Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_TARGET_OPERATION_COUNT = WIREABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = WIRE_SOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CONFIGURATION = WIRE_SOURCE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Wire Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__WIRE_TARGET = WIRE_SOURCE__WIRE_TARGET;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = WIRE_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = WIRE_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.ServiceImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = WIRE_TARGET__NAME;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CONFIGURATION = WIRE_TARGET__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TYPE = WIRE_TARGET__TYPE;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = WIRE_TARGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = WIRE_TARGET_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.ReferenceImportImpl <em>Reference Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.ReferenceImportImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getReferenceImport()
	 * @generated
	 */
	int REFERENCE_IMPORT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMPORT__NAME = WIRE_TARGET__NAME;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMPORT__CONFIGURATION = WIRE_TARGET__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMPORT__TYPE = WIRE_TARGET__TYPE;

	/**
	 * The number of structural features of the '<em>Reference Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMPORT_FEATURE_COUNT = WIRE_TARGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMPORT_OPERATION_COUNT = WIRE_TARGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.ServiceExportImpl <em>Service Export</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.ServiceExportImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getServiceExport()
	 * @generated
	 */
	int SERVICE_EXPORT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXPORT__NAME = WIRE_SOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXPORT__CONFIGURATION = WIRE_SOURCE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Wire Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXPORT__WIRE_TARGET = WIRE_SOURCE__WIRE_TARGET;

	/**
	 * The number of structural features of the '<em>Service Export</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXPORT_FEATURE_COUNT = WIRE_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Service Export</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXPORT_OPERATION_COUNT = WIRE_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.PropertyImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__BINDING = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.sca.impl.PropertyImportImpl <em>Property Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.sca.impl.PropertyImportImpl
	 * @see org.nasdanika.sca.impl.ScaPackageImpl#getPropertyImport()
	 * @generated
	 */
	int PROPERTY_IMPORT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_IMPORT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Property Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_IMPORT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Property Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_IMPORT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.AbstractComponent <em>Abstract Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Component</em>'.
	 * @see org.nasdanika.sca.AbstractComponent
	 * @generated
	 */
	EClass getAbstractComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.AbstractComponent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.sca.AbstractComponent#getName()
	 * @see #getAbstractComponent()
	 * @generated
	 */
	EAttribute getAbstractComponent_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.AbstractComponent#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.sca.AbstractComponent#getDescription()
	 * @see #getAbstractComponent()
	 * @generated
	 */
	EAttribute getAbstractComponent_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.AbstractComponent#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration</em>'.
	 * @see org.nasdanika.sca.AbstractComponent#getConfiguration()
	 * @see #getAbstractComponent()
	 * @generated
	 */
	EAttribute getAbstractComponent_Configuration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.sca.AbstractComponent#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see org.nasdanika.sca.AbstractComponent#getServices()
	 * @see #getAbstractComponent()
	 * @generated
	 */
	EReference getAbstractComponent_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.sca.AbstractComponent#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.nasdanika.sca.AbstractComponent#getReferences()
	 * @see #getAbstractComponent()
	 * @generated
	 */
	EReference getAbstractComponent_References();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.sca.AbstractComponent#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.nasdanika.sca.AbstractComponent#getProperties()
	 * @see #getAbstractComponent()
	 * @generated
	 */
	EReference getAbstractComponent_Properties();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.sca.AbstractComponent#createRuntimeComponent() <em>Create Runtime Component</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Runtime Component</em>' operation.
	 * @see org.nasdanika.sca.AbstractComponent#createRuntimeComponent()
	 * @generated
	 */
	EOperation getAbstractComponent__CreateRuntimeComponent();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.nasdanika.sca.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.Component#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see org.nasdanika.sca.Component#getImplementation()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Implementation();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.Component#getImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Class</em>'.
	 * @see org.nasdanika.sca.Component#getImplementationClass()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ImplementationClass();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.Component#isImmediatelyActivated <em>Immediately Activated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediately Activated</em>'.
	 * @see org.nasdanika.sca.Component#isImmediatelyActivated()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_ImmediatelyActivated();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.Composite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite</em>'.
	 * @see org.nasdanika.sca.Composite
	 * @generated
	 */
	EClass getComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.sca.Composite#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.nasdanika.sca.Composite#getComponents()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.sca.Composite#getExportedServices <em>Exported Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Services</em>'.
	 * @see org.nasdanika.sca.Composite#getExportedServices()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_ExportedServices();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.sca.Composite#getImportedReferences <em>Imported References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imported References</em>'.
	 * @see org.nasdanika.sca.Composite#getImportedReferences()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_ImportedReferences();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.sca.Composite#getImportedProperties <em>Imported Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imported Properties</em>'.
	 * @see org.nasdanika.sca.Composite#getImportedProperties()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_ImportedProperties();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.Composite#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see org.nasdanika.sca.Composite#getImplementation()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_Implementation();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.Composite#getImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Class</em>'.
	 * @see org.nasdanika.sca.Composite#getImplementationClass()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_ImplementationClass();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.CompositeReference <em>Composite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Reference</em>'.
	 * @see org.nasdanika.sca.CompositeReference
	 * @generated
	 */
	EClass getCompositeReference();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.CompositeReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.sca.CompositeReference#getTarget()
	 * @see #getCompositeReference()
	 * @generated
	 */
	EReference getCompositeReference_Target();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.Wireable <em>Wireable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wireable</em>'.
	 * @see org.nasdanika.sca.Wireable
	 * @generated
	 */
	EClass getWireable();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.Wireable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.sca.Wireable#getName()
	 * @see #getWireable()
	 * @generated
	 */
	EAttribute getWireable_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.Wireable#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration</em>'.
	 * @see org.nasdanika.sca.Wireable#getConfiguration()
	 * @see #getWireable()
	 * @generated
	 */
	EAttribute getWireable_Configuration();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.nasdanika.sca.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.nasdanika.sca.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.ReferenceImport <em>Reference Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Import</em>'.
	 * @see org.nasdanika.sca.ReferenceImport
	 * @generated
	 */
	EClass getReferenceImport();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.ServiceExport <em>Service Export</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Export</em>'.
	 * @see org.nasdanika.sca.ServiceExport
	 * @generated
	 */
	EClass getServiceExport();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.nasdanika.sca.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.sca.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.Property#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding</em>'.
	 * @see org.nasdanika.sca.Property#getBinding()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Binding();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.PropertyImport <em>Property Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Import</em>'.
	 * @see org.nasdanika.sca.PropertyImport
	 * @generated
	 */
	EClass getPropertyImport();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.sca.PropertyImport#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.sca.PropertyImport#getName()
	 * @see #getPropertyImport()
	 * @generated
	 */
	EAttribute getPropertyImport_Name();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.WireTarget <em>Wire Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wire Target</em>'.
	 * @see org.nasdanika.sca.WireTarget
	 * @generated
	 */
	EClass getWireTarget();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.WireTarget#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.nasdanika.sca.WireTarget#getType()
	 * @see #getWireTarget()
	 * @generated
	 */
	EReference getWireTarget_Type();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.sca.WireSource <em>Wire Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wire Source</em>'.
	 * @see org.nasdanika.sca.WireSource
	 * @generated
	 */
	EClass getWireSource();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.sca.WireSource#getWireTarget <em>Wire Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wire Target</em>'.
	 * @see org.nasdanika.sca.WireSource#getWireTarget()
	 * @see #getWireSource()
	 * @generated
	 */
	EReference getWireSource_WireTarget();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScaFactory getScaFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.AbstractComponentImpl <em>Abstract Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.AbstractComponentImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getAbstractComponent()
		 * @generated
		 */
		EClass ABSTRACT_COMPONENT = eINSTANCE.getAbstractComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_COMPONENT__NAME = eINSTANCE.getAbstractComponent_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_COMPONENT__DESCRIPTION = eINSTANCE.getAbstractComponent_Description();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_COMPONENT__CONFIGURATION = eINSTANCE.getAbstractComponent_Configuration();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COMPONENT__SERVICES = eINSTANCE.getAbstractComponent_Services();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COMPONENT__REFERENCES = eINSTANCE.getAbstractComponent_References();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COMPONENT__PROPERTIES = eINSTANCE.getAbstractComponent_Properties();

		/**
		 * The meta object literal for the '<em><b>Create Runtime Component</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_COMPONENT___CREATE_RUNTIME_COMPONENT = eINSTANCE.getAbstractComponent__CreateRuntimeComponent();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.ComponentImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__IMPLEMENTATION = eINSTANCE.getComponent_Implementation();

		/**
		 * The meta object literal for the '<em><b>Implementation Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__IMPLEMENTATION_CLASS = eINSTANCE.getComponent_ImplementationClass();

		/**
		 * The meta object literal for the '<em><b>Immediately Activated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__IMMEDIATELY_ACTIVATED = eINSTANCE.getComponent_ImmediatelyActivated();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.CompositeImpl <em>Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.CompositeImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getComposite()
		 * @generated
		 */
		EClass COMPOSITE = eINSTANCE.getComposite();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__COMPONENTS = eINSTANCE.getComposite_Components();

		/**
		 * The meta object literal for the '<em><b>Exported Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__EXPORTED_SERVICES = eINSTANCE.getComposite_ExportedServices();

		/**
		 * The meta object literal for the '<em><b>Imported References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__IMPORTED_REFERENCES = eINSTANCE.getComposite_ImportedReferences();

		/**
		 * The meta object literal for the '<em><b>Imported Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__IMPORTED_PROPERTIES = eINSTANCE.getComposite_ImportedProperties();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__IMPLEMENTATION = eINSTANCE.getComposite_Implementation();

		/**
		 * The meta object literal for the '<em><b>Implementation Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__IMPLEMENTATION_CLASS = eINSTANCE.getComposite_ImplementationClass();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.CompositeReferenceImpl <em>Composite Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.CompositeReferenceImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getCompositeReference()
		 * @generated
		 */
		EClass COMPOSITE_REFERENCE = eINSTANCE.getCompositeReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_REFERENCE__TARGET = eINSTANCE.getCompositeReference_Target();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.Wireable <em>Wireable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.Wireable
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getWireable()
		 * @generated
		 */
		EClass WIREABLE = eINSTANCE.getWireable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIREABLE__NAME = eINSTANCE.getWireable_Name();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIREABLE__CONFIGURATION = eINSTANCE.getWireable_Configuration();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.ReferenceImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.ServiceImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.ReferenceImportImpl <em>Reference Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.ReferenceImportImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getReferenceImport()
		 * @generated
		 */
		EClass REFERENCE_IMPORT = eINSTANCE.getReferenceImport();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.ServiceExportImpl <em>Service Export</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.ServiceExportImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getServiceExport()
		 * @generated
		 */
		EClass SERVICE_EXPORT = eINSTANCE.getServiceExport();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.PropertyImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getProperty()
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
		 * The meta object literal for the '<em><b>Binding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__BINDING = eINSTANCE.getProperty_Binding();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.impl.PropertyImportImpl <em>Property Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.impl.PropertyImportImpl
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getPropertyImport()
		 * @generated
		 */
		EClass PROPERTY_IMPORT = eINSTANCE.getPropertyImport();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_IMPORT__NAME = eINSTANCE.getPropertyImport_Name();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.WireTarget <em>Wire Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.WireTarget
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getWireTarget()
		 * @generated
		 */
		EClass WIRE_TARGET = eINSTANCE.getWireTarget();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE_TARGET__TYPE = eINSTANCE.getWireTarget_Type();

		/**
		 * The meta object literal for the '{@link org.nasdanika.sca.WireSource <em>Wire Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.sca.WireSource
		 * @see org.nasdanika.sca.impl.ScaPackageImpl#getWireSource()
		 * @generated
		 */
		EClass WIRE_SOURCE = eINSTANCE.getWireSource();

		/**
		 * The meta object literal for the '<em><b>Wire Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE_SOURCE__WIRE_TARGET = eINSTANCE.getWireSource_WireTarget();

	}

} //ScaPackage
