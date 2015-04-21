/**
 */
package org.nasdanika.cdo.sca;

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
 * @see org.nasdanika.cdo.sca.ScaFactory
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
	String eNS_URI = "urn:org.nasdanika.cdo.sca";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.sca";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScaPackage eINSTANCE = org.nasdanika.cdo.sca.impl.ScaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.core.JSONLoader <em>JSON Loader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.JSONLoader
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getJSONLoader()
	 * @generated
	 */
	int JSON_LOADER = 4;

	/**
	 * The number of structural features of the '<em>JSON Loader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_LOADER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>JSON Loader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_LOADER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.sca.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.sca.impl.ComponentImpl
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__WIRES = JSON_LOADER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROPERTIES = JSON_LOADER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Immediately Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__IMMEDIATELY_ACTIVATED = JSON_LOADER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = JSON_LOADER_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Service Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT___GET_SERVICE_REFERENCE__CLASS_COMPONENTCONTEXT = JSON_LOADER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Service Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT___GET_SERVICE_REFERENCE__STRING_COMPONENTCONTEXT = JSON_LOADER_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = JSON_LOADER_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.sca.impl.CompositeImpl <em>Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.sca.impl.CompositeImpl
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getComposite()
	 * @generated
	 */
	int COMPOSITE = 1;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__WIRES = COMPONENT__WIRES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__PROPERTIES = COMPONENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Immediately Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__IMMEDIATELY_ACTIVATED = COMPONENT__IMMEDIATELY_ACTIVATED;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__COMPONENTS = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Service Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE___GET_SERVICE_REFERENCE__CLASS_COMPONENTCONTEXT = COMPONENT___GET_SERVICE_REFERENCE__CLASS_COMPONENTCONTEXT;

	/**
	 * The operation id for the '<em>Get Service Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE___GET_SERVICE_REFERENCE__STRING_COMPONENTCONTEXT = COMPONENT___GET_SERVICE_REFERENCE__STRING_COMPONENTCONTEXT;

	/**
	 * The number of operations of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.sca.impl.WireImpl <em>Wire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.sca.impl.WireImpl
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getWire()
	 * @generated
	 */
	int WIRE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__NAME = JSON_LOADER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__TYPE_NAME = JSON_LOADER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__TARGET = JSON_LOADER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__TARGET_NAME = JSON_LOADER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__PROPERTIES = JSON_LOADER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Wire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_FEATURE_COUNT = JSON_LOADER_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Wire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_OPERATION_COUNT = JSON_LOADER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.sca.impl.PropertySettingImpl <em>Property Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.sca.impl.PropertySettingImpl
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getPropertySetting()
	 * @generated
	 */
	int PROPERTY_SETTING = 3;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTING__TARGET_NAME = 0;

	/**
	 * The number of structural features of the '<em>Property Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Property Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SETTING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.sca.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.sca.impl.PropertyEntryImpl
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getPropertyEntry()
	 * @generated
	 */
	int PROPERTY_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Component Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.sca.ComponentContext
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getComponentContext()
	 * @generated
	 */
	int COMPONENT_CONTEXT = 6;

	/**
	 * The meta object id for the '<em>Service Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.sca.ServiceReference
	 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getServiceReference()
	 * @generated
	 */
	int SERVICE_REFERENCE = 7;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.sca.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.nasdanika.cdo.sca.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.sca.Component#getWires <em>Wires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wires</em>'.
	 * @see org.nasdanika.cdo.sca.Component#getWires()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Wires();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.sca.Component#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.nasdanika.cdo.sca.Component#getProperties()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Properties();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.sca.Component#isImmediatelyActivated <em>Immediately Activated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediately Activated</em>'.
	 * @see org.nasdanika.cdo.sca.Component#isImmediatelyActivated()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_ImmediatelyActivated();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.sca.Component#getServiceReference(java.lang.Class, org.nasdanika.cdo.sca.ComponentContext) <em>Get Service Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Service Reference</em>' operation.
	 * @see org.nasdanika.cdo.sca.Component#getServiceReference(java.lang.Class, org.nasdanika.cdo.sca.ComponentContext)
	 * @generated
	 */
	EOperation getComponent__GetServiceReference__Class_ComponentContext();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.sca.Component#getServiceReference(java.lang.String, org.nasdanika.cdo.sca.ComponentContext) <em>Get Service Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Service Reference</em>' operation.
	 * @see org.nasdanika.cdo.sca.Component#getServiceReference(java.lang.String, org.nasdanika.cdo.sca.ComponentContext)
	 * @generated
	 */
	EOperation getComponent__GetServiceReference__String_ComponentContext();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.sca.Composite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite</em>'.
	 * @see org.nasdanika.cdo.sca.Composite
	 * @generated
	 */
	EClass getComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.sca.Composite#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.nasdanika.cdo.sca.Composite#getComponents()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_Components();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.sca.Wire <em>Wire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wire</em>'.
	 * @see org.nasdanika.cdo.sca.Wire
	 * @generated
	 */
	EClass getWire();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.sca.Wire#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.cdo.sca.Wire#getName()
	 * @see #getWire()
	 * @generated
	 */
	EAttribute getWire_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.sca.Wire#isTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see org.nasdanika.cdo.sca.Wire#isTypeName()
	 * @see #getWire()
	 * @generated
	 */
	EAttribute getWire_TypeName();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.sca.Wire#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.sca.Wire#getTarget()
	 * @see #getWire()
	 * @generated
	 */
	EReference getWire_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.sca.Wire#getTargetName <em>Target Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Name</em>'.
	 * @see org.nasdanika.cdo.sca.Wire#getTargetName()
	 * @see #getWire()
	 * @generated
	 */
	EAttribute getWire_TargetName();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.sca.Wire#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.nasdanika.cdo.sca.Wire#getProperties()
	 * @see #getWire()
	 * @generated
	 */
	EReference getWire_Properties();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.sca.PropertySetting <em>Property Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Setting</em>'.
	 * @see org.nasdanika.cdo.sca.PropertySetting
	 * @generated
	 */
	EClass getPropertySetting();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.sca.PropertySetting#getTargetName <em>Target Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Name</em>'.
	 * @see org.nasdanika.cdo.sca.PropertySetting#getTargetName()
	 * @see #getPropertySetting()
	 * @generated
	 */
	EAttribute getPropertySetting_TargetName();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.core.JSONLoader <em>JSON Loader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JSON Loader</em>'.
	 * @see org.nasdanika.core.JSONLoader
	 * @model instanceClass="org.nasdanika.core.JSONLoader"
	 * @generated
	 */
	EClass getJSONLoader();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Property Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getPropertyEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyEntry()
	 * @generated
	 */
	EAttribute getPropertyEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyEntry()
	 * @generated
	 */
	EReference getPropertyEntry_Value();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.sca.ComponentContext <em>Component Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Component Context</em>'.
	 * @see org.nasdanika.cdo.sca.ComponentContext
	 * @model instanceClass="org.nasdanika.cdo.sca.ComponentContext" serializeable="false"
	 * @generated
	 */
	EDataType getComponentContext();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.sca.ServiceReference <em>Service Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Service Reference</em>'.
	 * @see org.nasdanika.cdo.sca.ServiceReference
	 * @model instanceClass="org.nasdanika.cdo.sca.ServiceReference" serializeable="false" typeParameters="T"
	 * @generated
	 */
	EDataType getServiceReference();

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
		 * The meta object literal for the '{@link org.nasdanika.cdo.sca.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.sca.impl.ComponentImpl
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Wires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__WIRES = eINSTANCE.getComponent_Wires();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PROPERTIES = eINSTANCE.getComponent_Properties();

		/**
		 * The meta object literal for the '<em><b>Immediately Activated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__IMMEDIATELY_ACTIVATED = eINSTANCE.getComponent_ImmediatelyActivated();

		/**
		 * The meta object literal for the '<em><b>Get Service Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPONENT___GET_SERVICE_REFERENCE__CLASS_COMPONENTCONTEXT = eINSTANCE.getComponent__GetServiceReference__Class_ComponentContext();

		/**
		 * The meta object literal for the '<em><b>Get Service Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPONENT___GET_SERVICE_REFERENCE__STRING_COMPONENTCONTEXT = eINSTANCE.getComponent__GetServiceReference__String_ComponentContext();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.sca.impl.CompositeImpl <em>Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.sca.impl.CompositeImpl
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getComposite()
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
		 * The meta object literal for the '{@link org.nasdanika.cdo.sca.impl.WireImpl <em>Wire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.sca.impl.WireImpl
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getWire()
		 * @generated
		 */
		EClass WIRE = eINSTANCE.getWire();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE__NAME = eINSTANCE.getWire_Name();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE__TYPE_NAME = eINSTANCE.getWire_TypeName();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE__TARGET = eINSTANCE.getWire_Target();

		/**
		 * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE__TARGET_NAME = eINSTANCE.getWire_TargetName();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRE__PROPERTIES = eINSTANCE.getWire_Properties();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.sca.impl.PropertySettingImpl <em>Property Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.sca.impl.PropertySettingImpl
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getPropertySetting()
		 * @generated
		 */
		EClass PROPERTY_SETTING = eINSTANCE.getPropertySetting();

		/**
		 * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_SETTING__TARGET_NAME = eINSTANCE.getPropertySetting_TargetName();

		/**
		 * The meta object literal for the '{@link org.nasdanika.core.JSONLoader <em>JSON Loader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.JSONLoader
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getJSONLoader()
		 * @generated
		 */
		EClass JSON_LOADER = eINSTANCE.getJSONLoader();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.sca.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.sca.impl.PropertyEntryImpl
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getPropertyEntry()
		 * @generated
		 */
		EClass PROPERTY_ENTRY = eINSTANCE.getPropertyEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_ENTRY__KEY = eINSTANCE.getPropertyEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ENTRY__VALUE = eINSTANCE.getPropertyEntry_Value();

		/**
		 * The meta object literal for the '<em>Component Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.sca.ComponentContext
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getComponentContext()
		 * @generated
		 */
		EDataType COMPONENT_CONTEXT = eINSTANCE.getComponentContext();

		/**
		 * The meta object literal for the '<em>Service Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.sca.ServiceReference
		 * @see org.nasdanika.cdo.sca.impl.ScaPackageImpl#getServiceReference()
		 * @generated
		 */
		EDataType SERVICE_REFERENCE = eINSTANCE.getServiceReference();

	}

} //ScaPackage
