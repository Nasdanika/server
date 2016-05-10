/**
 */
package org.nasdanika.osgi.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * <!-- begin-model-doc -->
 * OSGi runtime model for documentation purposes.
 * <!-- end-model-doc -->
 * @see org.nasdanika.osgi.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.osgi.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.osgi.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.nasdanika.osgi.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.osgi.model.impl.RuntimeImpl <em>Runtime</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.osgi.model.impl.RuntimeImpl
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getRuntime()
	 * @generated
	 */
	int RUNTIME = 0;

	/**
	 * The feature id for the '<em><b>Bundles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME__BUNDLES = 0;

	/**
	 * The number of structural features of the '<em>Runtime</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Load</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME___LOAD__ELIST_SCRSERVICE = 0;

	/**
	 * The number of operations of the '<em>Runtime</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.osgi.model.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.osgi.model.impl.ElementImpl
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Outbound References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OUTBOUND_REFERENCES = 0;

	/**
	 * The feature id for the '<em><b>Inbound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__INBOUND_REFERENCES = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ID = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.osgi.model.impl.ServiceReferenceImpl <em>Service Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.osgi.model.impl.ServiceReferenceImpl
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getServiceReference()
	 * @generated
	 */
	int SERVICE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Object Class</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE__OBJECT_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Reference Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE__REFERENCE_TARGET = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Service Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Service Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.osgi.model.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.osgi.model.impl.BundleImpl
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 3;

	/**
	 * The feature id for the '<em><b>Outbound References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__OUTBOUND_REFERENCES = ELEMENT__OUTBOUND_REFERENCES;

	/**
	 * The feature id for the '<em><b>Inbound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__INBOUND_REFERENCES = ELEMENT__INBOUND_REFERENCES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__COMPONENTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Symbolic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__SYMBOLIC_NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__VERSION = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__REQUIRES = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__REQUIRED_BY = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.osgi.model.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.osgi.model.impl.ComponentImpl
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 4;

	/**
	 * The feature id for the '<em><b>Outbound References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTBOUND_REFERENCES = ELEMENT__OUTBOUND_REFERENCES;

	/**
	 * The feature id for the '<em><b>Inbound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INBOUND_REFERENCES = ELEMENT__INBOUND_REFERENCES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CLASS_NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '<em>Scr Service</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.scr.ScrService
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getScrService()
	 * @generated
	 */
	int SCR_SERVICE = 5;

	/**
	 * The meta object id for the '<em>Framework Bundle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osgi.framework.Bundle
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getFrameworkBundle()
	 * @generated
	 */
	int FRAMEWORK_BUNDLE = 6;


	/**
	 * The meta object id for the '<em>Bundle Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osgi.framework.BundleException
	 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getBundleException()
	 * @generated
	 */
	int BUNDLE_EXCEPTION = 7;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.osgi.model.Runtime <em>Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime</em>'.
	 * @see org.nasdanika.osgi.model.Runtime
	 * @generated
	 */
	EClass getRuntime();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.osgi.model.Runtime#getBundles <em>Bundles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bundles</em>'.
	 * @see org.nasdanika.osgi.model.Runtime#getBundles()
	 * @see #getRuntime()
	 * @generated
	 */
	EReference getRuntime_Bundles();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.osgi.model.Runtime#load(org.eclipse.emf.common.util.EList, org.apache.felix.scr.ScrService) <em>Load</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Load</em>' operation.
	 * @see org.nasdanika.osgi.model.Runtime#load(org.eclipse.emf.common.util.EList, org.apache.felix.scr.ScrService)
	 * @generated
	 */
	EOperation getRuntime__Load__EList_ScrService();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.osgi.model.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.nasdanika.osgi.model.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.osgi.model.Element#getOutboundReferences <em>Outbound References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outbound References</em>'.
	 * @see org.nasdanika.osgi.model.Element#getOutboundReferences()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OutboundReferences();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.osgi.model.Element#getInboundReferences <em>Inbound References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inbound References</em>'.
	 * @see org.nasdanika.osgi.model.Element#getInboundReferences()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_InboundReferences();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.osgi.model.Element#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.nasdanika.osgi.model.Element#getId()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Id();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.osgi.model.ServiceReference <em>Service Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Reference</em>'.
	 * @see org.nasdanika.osgi.model.ServiceReference
	 * @generated
	 */
	EClass getServiceReference();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.osgi.model.ServiceReference#getObjectClass <em>Object Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Object Class</em>'.
	 * @see org.nasdanika.osgi.model.ServiceReference#getObjectClass()
	 * @see #getServiceReference()
	 * @generated
	 */
	EAttribute getServiceReference_ObjectClass();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.osgi.model.ServiceReference#getReferenceTarget <em>Reference Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference Target</em>'.
	 * @see org.nasdanika.osgi.model.ServiceReference#getReferenceTarget()
	 * @see #getServiceReference()
	 * @generated
	 */
	EReference getServiceReference_ReferenceTarget();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.osgi.model.ServiceReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.osgi.model.ServiceReference#getName()
	 * @see #getServiceReference()
	 * @generated
	 */
	EAttribute getServiceReference_Name();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.osgi.model.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see org.nasdanika.osgi.model.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.osgi.model.Bundle#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.nasdanika.osgi.model.Bundle#getComponents()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_Components();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.osgi.model.Bundle#getSymbolicName <em>Symbolic Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbolic Name</em>'.
	 * @see org.nasdanika.osgi.model.Bundle#getSymbolicName()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_SymbolicName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.osgi.model.Bundle#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.nasdanika.osgi.model.Bundle#getVersion()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Version();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.osgi.model.Bundle#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requires</em>'.
	 * @see org.nasdanika.osgi.model.Bundle#getRequires()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_Requires();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.osgi.model.Bundle#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required By</em>'.
	 * @see org.nasdanika.osgi.model.Bundle#getRequiredBy()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_RequiredBy();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.osgi.model.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.nasdanika.osgi.model.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.osgi.model.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.osgi.model.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.osgi.model.Component#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.nasdanika.osgi.model.Component#getClassName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_ClassName();

	/**
	 * Returns the meta object for data type '{@link org.apache.felix.scr.ScrService <em>Scr Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Scr Service</em>'.
	 * @see org.apache.felix.scr.ScrService
	 * @model instanceClass="org.apache.felix.scr.ScrService"
	 * @generated
	 */
	EDataType getScrService();

	/**
	 * Returns the meta object for data type '{@link org.osgi.framework.Bundle <em>Framework Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Framework Bundle</em>'.
	 * @see org.osgi.framework.Bundle
	 * @model instanceClass="org.osgi.framework.Bundle"
	 * @generated
	 */
	EDataType getFrameworkBundle();

	/**
	 * Returns the meta object for data type '{@link org.osgi.framework.BundleException <em>Bundle Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bundle Exception</em>'.
	 * @see org.osgi.framework.BundleException
	 * @model instanceClass="org.osgi.framework.BundleException"
	 * @generated
	 */
	EDataType getBundleException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.osgi.model.impl.RuntimeImpl <em>Runtime</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.osgi.model.impl.RuntimeImpl
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getRuntime()
		 * @generated
		 */
		EClass RUNTIME = eINSTANCE.getRuntime();

		/**
		 * The meta object literal for the '<em><b>Bundles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME__BUNDLES = eINSTANCE.getRuntime_Bundles();

		/**
		 * The meta object literal for the '<em><b>Load</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RUNTIME___LOAD__ELIST_SCRSERVICE = eINSTANCE.getRuntime__Load__EList_ScrService();

		/**
		 * The meta object literal for the '{@link org.nasdanika.osgi.model.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.osgi.model.impl.ElementImpl
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Outbound References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OUTBOUND_REFERENCES = eINSTANCE.getElement_OutboundReferences();

		/**
		 * The meta object literal for the '<em><b>Inbound References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__INBOUND_REFERENCES = eINSTANCE.getElement_InboundReferences();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__ID = eINSTANCE.getElement_Id();

		/**
		 * The meta object literal for the '{@link org.nasdanika.osgi.model.impl.ServiceReferenceImpl <em>Service Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.osgi.model.impl.ServiceReferenceImpl
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getServiceReference()
		 * @generated
		 */
		EClass SERVICE_REFERENCE = eINSTANCE.getServiceReference();

		/**
		 * The meta object literal for the '<em><b>Object Class</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_REFERENCE__OBJECT_CLASS = eINSTANCE.getServiceReference_ObjectClass();

		/**
		 * The meta object literal for the '<em><b>Reference Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_REFERENCE__REFERENCE_TARGET = eINSTANCE.getServiceReference_ReferenceTarget();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_REFERENCE__NAME = eINSTANCE.getServiceReference_Name();

		/**
		 * The meta object literal for the '{@link org.nasdanika.osgi.model.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.osgi.model.impl.BundleImpl
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__COMPONENTS = eINSTANCE.getBundle_Components();

		/**
		 * The meta object literal for the '<em><b>Symbolic Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__SYMBOLIC_NAME = eINSTANCE.getBundle_SymbolicName();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__VERSION = eINSTANCE.getBundle_Version();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__REQUIRES = eINSTANCE.getBundle_Requires();

		/**
		 * The meta object literal for the '<em><b>Required By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__REQUIRED_BY = eINSTANCE.getBundle_RequiredBy();

		/**
		 * The meta object literal for the '{@link org.nasdanika.osgi.model.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.osgi.model.impl.ComponentImpl
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__CLASS_NAME = eINSTANCE.getComponent_ClassName();

		/**
		 * The meta object literal for the '<em>Scr Service</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.scr.ScrService
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getScrService()
		 * @generated
		 */
		EDataType SCR_SERVICE = eINSTANCE.getScrService();

		/**
		 * The meta object literal for the '<em>Framework Bundle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osgi.framework.Bundle
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getFrameworkBundle()
		 * @generated
		 */
		EDataType FRAMEWORK_BUNDLE = eINSTANCE.getFrameworkBundle();

		/**
		 * The meta object literal for the '<em>Bundle Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osgi.framework.BundleException
		 * @see org.nasdanika.osgi.model.impl.ModelPackageImpl#getBundleException()
		 * @generated
		 */
		EDataType BUNDLE_EXCEPTION = eINSTANCE.getBundleException();

	}

} //ModelPackage
