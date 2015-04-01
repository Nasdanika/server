/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.nasdanika.cdo.function.FunctionFactory
 * @model kind="package"
 * @generated
 */
public interface FunctionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "function";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.cdo.function";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.function";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionPackage eINSTANCE = org.nasdanika.cdo.function.impl.FunctionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.core.Context <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.Context
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.function.cdo.CDOTransactionContextFunction <em>CDO Transaction Context Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.function.cdo.CDOTransactionContextFunction
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getCDOTransactionContextFunction()
	 * @generated
	 */
	int CDO_TRANSACTION_CONTEXT_FUNCTION = 1;

	/**
	 * The number of structural features of the '<em>CDO Transaction Context Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_TRANSACTION_CONTEXT_FUNCTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>CDO Transaction Context Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_TRANSACTION_CONTEXT_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.AbstractFunctionImpl <em>Abstract Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.AbstractFunctionImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getAbstractFunction()
	 * @generated
	 */
	int ABSTRACT_FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION__RUN_AS = CDO_TRANSACTION_CONTEXT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION_FEATURE_COUNT = CDO_TRANSACTION_CONTEXT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION_OPERATION_COUNT = CDO_TRANSACTION_CONTEXT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.BoundFunctionImpl <em>Bound Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.BoundFunctionImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getBoundFunction()
	 * @generated
	 */
	int BOUND_FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_FUNCTION__RUN_AS = ABSTRACT_FUNCTION__RUN_AS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_FUNCTION__TARGET = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_FUNCTION__BINDINGS = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bound Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_FUNCTION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bound Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_FUNCTION_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.ArgumentBindingImpl <em>Argument Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.ArgumentBindingImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getArgumentBinding()
	 * @generated
	 */
	int ARGUMENT_BINDING = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_BINDING__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_BINDING__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Argument Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_BINDING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Argument Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.function.ServiceBinding <em>Service Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.function.ServiceBinding
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getServiceBinding()
	 * @generated
	 */
	int SERVICE_BINDING = 5;

	/**
	 * The number of structural features of the '<em>Service Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_BINDING_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Service Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.CDOServiceBindingImpl <em>CDO Service Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.CDOServiceBindingImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getCDOServiceBinding()
	 * @generated
	 */
	int CDO_SERVICE_BINDING = 6;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_SERVICE_BINDING__FILTER = SERVICE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_SERVICE_BINDING__SERVICE_TYPE = SERVICE_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CDO Service Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_SERVICE_BINDING_FEATURE_COUNT = SERVICE_BINDING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CDO Service Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDO_SERVICE_BINDING_OPERATION_COUNT = SERVICE_BINDING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.ContextArgumentImpl <em>Context Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.ContextArgumentImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getContextArgument()
	 * @generated
	 */
	int CONTEXT_ARGUMENT = 7;

	/**
	 * The number of structural features of the '<em>Context Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_ARGUMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Context Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_ARGUMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.CommandFunctionImpl <em>Command Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.CommandFunctionImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getCommandFunction()
	 * @generated
	 */
	int COMMAND_FUNCTION = 8;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FUNCTION__RUN_AS = ABSTRACT_FUNCTION__RUN_AS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FUNCTION__TARGET = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FUNCTION__PARAMETER_TYPES = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FUNCTION__RETURN_TYPE = ABSTRACT_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Command Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FUNCTION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Command Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FUNCTION_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl <em>Java Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.JavaFunctionImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getJavaFunction()
	 * @generated
	 */
	int JAVA_FUNCTION = 9;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION__RUN_AS = ABSTRACT_FUNCTION__RUN_AS;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION__PARAMETER_TYPES = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION__RETURN_TYPE = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Thrown Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION__THROWN_EXCEPTIONS = ABSTRACT_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION__PARAMETER_NAMES = ABSTRACT_FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION__CODE = ABSTRACT_FUNCTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Code URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION__CODE_URL = ABSTRACT_FUNCTION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Java Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Java Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FUNCTION_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.ScriptBindingImpl <em>Script Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.ScriptBindingImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getScriptBinding()
	 * @generated
	 */
	int SCRIPT_BINDING = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_BINDING__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_BINDING__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Script Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_BINDING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Script Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl <em>Java Script Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getJavaScriptFunction()
	 * @generated
	 */
	int JAVA_SCRIPT_FUNCTION = 11;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SCRIPT_FUNCTION__RUN_AS = ABSTRACT_FUNCTION__RUN_AS;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SCRIPT_FUNCTION__CODE = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Code URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SCRIPT_FUNCTION__CODE_URL = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SCRIPT_FUNCTION__PARAMETER_NAMES = ABSTRACT_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SCRIPT_FUNCTION__BINDINGS = ABSTRACT_FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Java Script Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SCRIPT_FUNCTION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Java Script Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SCRIPT_FUNCTION_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl <em>Object Method Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getObjectMethodFunction()
	 * @generated
	 */
	int OBJECT_METHOD_FUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_METHOD_FUNCTION__RUN_AS = ABSTRACT_FUNCTION__RUN_AS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_METHOD_FUNCTION__TARGET = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_METHOD_FUNCTION__METHOD_NAME = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_METHOD_FUNCTION__PARAMETER_TYPES = ABSTRACT_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Object Method Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_METHOD_FUNCTION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Object Method Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_METHOD_FUNCTION_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl <em>Service Method Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getServiceMethodFunction()
	 * @generated
	 */
	int SERVICE_METHOD_FUNCTION = 13;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FUNCTION__RUN_AS = ABSTRACT_FUNCTION__RUN_AS;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FUNCTION__SERVICE_TYPE = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FUNCTION__FILTER = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FUNCTION__METHOD_NAME = ABSTRACT_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FUNCTION__PARAMETER_TYPES = ABSTRACT_FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Service Method Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FUNCTION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Service Method Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FUNCTION_OPERATION_COUNT = ABSTRACT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.nasdanika.core.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.nasdanika.core.Context
	 * @model instanceClass="org.nasdanika.core.Context"
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.function.cdo.CDOTransactionContextFunction <em>CDO Transaction Context Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CDO Transaction Context Function</em>'.
	 * @see org.nasdanika.function.cdo.CDOTransactionContextFunction
	 * @model instanceClass="org.nasdanika.function.cdo.CDOTransactionContextFunction" typeParameters="CR MC T R" MCBounds="org.nasdanika.cdo.function.Context"
	 * @generated
	 */
	EClass getCDOTransactionContextFunction();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.AbstractFunction <em>Abstract Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Function</em>'.
	 * @see org.nasdanika.cdo.function.AbstractFunction
	 * @generated
	 */
	EClass getAbstractFunction();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.function.AbstractFunction#getRunAs <em>Run As</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Run As</em>'.
	 * @see org.nasdanika.cdo.function.AbstractFunction#getRunAs()
	 * @see #getAbstractFunction()
	 * @generated
	 */
	EReference getAbstractFunction_RunAs();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.BoundFunction <em>Bound Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Function</em>'.
	 * @see org.nasdanika.cdo.function.BoundFunction
	 * @generated
	 */
	EClass getBoundFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.function.BoundFunction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.function.BoundFunction#getTarget()
	 * @see #getBoundFunction()
	 * @generated
	 */
	EReference getBoundFunction_Target();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.function.BoundFunction#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Bindings</em>'.
	 * @see org.nasdanika.cdo.function.BoundFunction#getBindings()
	 * @see #getBoundFunction()
	 * @generated
	 */
	EReference getBoundFunction_Bindings();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Argument Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument Binding</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EIntegerObject"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getArgumentBinding();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getArgumentBinding()
	 * @generated
	 */
	EAttribute getArgumentBinding_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getArgumentBinding()
	 * @generated
	 */
	EReference getArgumentBinding_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.function.ServiceBinding <em>Service Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Binding</em>'.
	 * @see org.nasdanika.function.ServiceBinding
	 * @model instanceClass="org.nasdanika.function.ServiceBinding"
	 * @generated
	 */
	EClass getServiceBinding();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.CDOServiceBinding <em>CDO Service Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CDO Service Binding</em>'.
	 * @see org.nasdanika.cdo.function.CDOServiceBinding
	 * @generated
	 */
	EClass getCDOServiceBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.CDOServiceBinding#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.nasdanika.cdo.function.CDOServiceBinding#getFilter()
	 * @see #getCDOServiceBinding()
	 * @generated
	 */
	EAttribute getCDOServiceBinding_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.CDOServiceBinding#getServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Type</em>'.
	 * @see org.nasdanika.cdo.function.CDOServiceBinding#getServiceType()
	 * @see #getCDOServiceBinding()
	 * @generated
	 */
	EAttribute getCDOServiceBinding_ServiceType();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.ContextArgument <em>Context Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Argument</em>'.
	 * @see org.nasdanika.cdo.function.ContextArgument
	 * @generated
	 */
	EClass getContextArgument();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.CommandFunction <em>Command Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Function</em>'.
	 * @see org.nasdanika.cdo.function.CommandFunction
	 * @generated
	 */
	EClass getCommandFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.function.CommandFunction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.function.CommandFunction#getTarget()
	 * @see #getCommandFunction()
	 * @generated
	 */
	EReference getCommandFunction_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.function.CommandFunction#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Types</em>'.
	 * @see org.nasdanika.cdo.function.CommandFunction#getParameterTypes()
	 * @see #getCommandFunction()
	 * @generated
	 */
	EReference getCommandFunction_ParameterTypes();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.function.CommandFunction#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.nasdanika.cdo.function.CommandFunction#getReturnType()
	 * @see #getCommandFunction()
	 * @generated
	 */
	EReference getCommandFunction_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.JavaFunction <em>Java Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Function</em>'.
	 * @see org.nasdanika.cdo.function.JavaFunction
	 * @generated
	 */
	EClass getJavaFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.function.JavaFunction#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Types</em>'.
	 * @see org.nasdanika.cdo.function.JavaFunction#getParameterTypes()
	 * @see #getJavaFunction()
	 * @generated
	 */
	EReference getJavaFunction_ParameterTypes();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.function.JavaFunction#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.nasdanika.cdo.function.JavaFunction#getReturnType()
	 * @see #getJavaFunction()
	 * @generated
	 */
	EReference getJavaFunction_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.function.JavaFunction#getThrownExceptions <em>Thrown Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thrown Exceptions</em>'.
	 * @see org.nasdanika.cdo.function.JavaFunction#getThrownExceptions()
	 * @see #getJavaFunction()
	 * @generated
	 */
	EReference getJavaFunction_ThrownExceptions();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.function.JavaFunction#getParameterNames <em>Parameter Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameter Names</em>'.
	 * @see org.nasdanika.cdo.function.JavaFunction#getParameterNames()
	 * @see #getJavaFunction()
	 * @generated
	 */
	EAttribute getJavaFunction_ParameterNames();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.JavaFunction#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.nasdanika.cdo.function.JavaFunction#getCode()
	 * @see #getJavaFunction()
	 * @generated
	 */
	EAttribute getJavaFunction_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.JavaFunction#getCodeURL <em>Code URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code URL</em>'.
	 * @see org.nasdanika.cdo.function.JavaFunction#getCodeURL()
	 * @see #getJavaFunction()
	 * @generated
	 */
	EAttribute getJavaFunction_CodeURL();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Script Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Binding</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getScriptBinding();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getScriptBinding()
	 * @generated
	 */
	EAttribute getScriptBinding_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getScriptBinding()
	 * @generated
	 */
	EReference getScriptBinding_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.JavaScriptFunction <em>Java Script Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Script Function</em>'.
	 * @see org.nasdanika.cdo.function.JavaScriptFunction
	 * @generated
	 */
	EClass getJavaScriptFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.JavaScriptFunction#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.nasdanika.cdo.function.JavaScriptFunction#getCode()
	 * @see #getJavaScriptFunction()
	 * @generated
	 */
	EAttribute getJavaScriptFunction_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.JavaScriptFunction#getCodeURL <em>Code URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code URL</em>'.
	 * @see org.nasdanika.cdo.function.JavaScriptFunction#getCodeURL()
	 * @see #getJavaScriptFunction()
	 * @generated
	 */
	EAttribute getJavaScriptFunction_CodeURL();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.function.JavaScriptFunction#getParameterNames <em>Parameter Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameter Names</em>'.
	 * @see org.nasdanika.cdo.function.JavaScriptFunction#getParameterNames()
	 * @see #getJavaScriptFunction()
	 * @generated
	 */
	EAttribute getJavaScriptFunction_ParameterNames();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.function.JavaScriptFunction#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Bindings</em>'.
	 * @see org.nasdanika.cdo.function.JavaScriptFunction#getBindings()
	 * @see #getJavaScriptFunction()
	 * @generated
	 */
	EReference getJavaScriptFunction_Bindings();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.ObjectMethodFunction <em>Object Method Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Method Function</em>'.
	 * @see org.nasdanika.cdo.function.ObjectMethodFunction
	 * @generated
	 */
	EClass getObjectMethodFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.function.ObjectMethodFunction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.function.ObjectMethodFunction#getTarget()
	 * @see #getObjectMethodFunction()
	 * @generated
	 */
	EReference getObjectMethodFunction_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.ObjectMethodFunction#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see org.nasdanika.cdo.function.ObjectMethodFunction#getMethodName()
	 * @see #getObjectMethodFunction()
	 * @generated
	 */
	EAttribute getObjectMethodFunction_MethodName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.function.ObjectMethodFunction#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Types</em>'.
	 * @see org.nasdanika.cdo.function.ObjectMethodFunction#getParameterTypes()
	 * @see #getObjectMethodFunction()
	 * @generated
	 */
	EReference getObjectMethodFunction_ParameterTypes();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.function.ServiceMethodFunction <em>Service Method Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Method Function</em>'.
	 * @see org.nasdanika.cdo.function.ServiceMethodFunction
	 * @generated
	 */
	EClass getServiceMethodFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.ServiceMethodFunction#getServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Type</em>'.
	 * @see org.nasdanika.cdo.function.ServiceMethodFunction#getServiceType()
	 * @see #getServiceMethodFunction()
	 * @generated
	 */
	EAttribute getServiceMethodFunction_ServiceType();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.ServiceMethodFunction#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.nasdanika.cdo.function.ServiceMethodFunction#getFilter()
	 * @see #getServiceMethodFunction()
	 * @generated
	 */
	EAttribute getServiceMethodFunction_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.function.ServiceMethodFunction#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see org.nasdanika.cdo.function.ServiceMethodFunction#getMethodName()
	 * @see #getServiceMethodFunction()
	 * @generated
	 */
	EAttribute getServiceMethodFunction_MethodName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.function.ServiceMethodFunction#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Types</em>'.
	 * @see org.nasdanika.cdo.function.ServiceMethodFunction#getParameterTypes()
	 * @see #getServiceMethodFunction()
	 * @generated
	 */
	EReference getServiceMethodFunction_ParameterTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FunctionFactory getFunctionFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.core.Context <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.Context
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '{@link org.nasdanika.function.cdo.CDOTransactionContextFunction <em>CDO Transaction Context Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.function.cdo.CDOTransactionContextFunction
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getCDOTransactionContextFunction()
		 * @generated
		 */
		EClass CDO_TRANSACTION_CONTEXT_FUNCTION = eINSTANCE.getCDOTransactionContextFunction();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.AbstractFunctionImpl <em>Abstract Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.AbstractFunctionImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getAbstractFunction()
		 * @generated
		 */
		EClass ABSTRACT_FUNCTION = eINSTANCE.getAbstractFunction();

		/**
		 * The meta object literal for the '<em><b>Run As</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_FUNCTION__RUN_AS = eINSTANCE.getAbstractFunction_RunAs();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.BoundFunctionImpl <em>Bound Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.BoundFunctionImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getBoundFunction()
		 * @generated
		 */
		EClass BOUND_FUNCTION = eINSTANCE.getBoundFunction();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_FUNCTION__TARGET = eINSTANCE.getBoundFunction_Target();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_FUNCTION__BINDINGS = eINSTANCE.getBoundFunction_Bindings();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.ArgumentBindingImpl <em>Argument Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.ArgumentBindingImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getArgumentBinding()
		 * @generated
		 */
		EClass ARGUMENT_BINDING = eINSTANCE.getArgumentBinding();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT_BINDING__KEY = eINSTANCE.getArgumentBinding_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT_BINDING__VALUE = eINSTANCE.getArgumentBinding_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.function.ServiceBinding <em>Service Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.function.ServiceBinding
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getServiceBinding()
		 * @generated
		 */
		EClass SERVICE_BINDING = eINSTANCE.getServiceBinding();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.CDOServiceBindingImpl <em>CDO Service Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.CDOServiceBindingImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getCDOServiceBinding()
		 * @generated
		 */
		EClass CDO_SERVICE_BINDING = eINSTANCE.getCDOServiceBinding();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CDO_SERVICE_BINDING__FILTER = eINSTANCE.getCDOServiceBinding_Filter();

		/**
		 * The meta object literal for the '<em><b>Service Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CDO_SERVICE_BINDING__SERVICE_TYPE = eINSTANCE.getCDOServiceBinding_ServiceType();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.ContextArgumentImpl <em>Context Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.ContextArgumentImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getContextArgument()
		 * @generated
		 */
		EClass CONTEXT_ARGUMENT = eINSTANCE.getContextArgument();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.CommandFunctionImpl <em>Command Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.CommandFunctionImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getCommandFunction()
		 * @generated
		 */
		EClass COMMAND_FUNCTION = eINSTANCE.getCommandFunction();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_FUNCTION__TARGET = eINSTANCE.getCommandFunction_Target();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_FUNCTION__PARAMETER_TYPES = eINSTANCE.getCommandFunction_ParameterTypes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_FUNCTION__RETURN_TYPE = eINSTANCE.getCommandFunction_ReturnType();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl <em>Java Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.JavaFunctionImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getJavaFunction()
		 * @generated
		 */
		EClass JAVA_FUNCTION = eINSTANCE.getJavaFunction();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_FUNCTION__PARAMETER_TYPES = eINSTANCE.getJavaFunction_ParameterTypes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_FUNCTION__RETURN_TYPE = eINSTANCE.getJavaFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Thrown Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_FUNCTION__THROWN_EXCEPTIONS = eINSTANCE.getJavaFunction_ThrownExceptions();

		/**
		 * The meta object literal for the '<em><b>Parameter Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_FUNCTION__PARAMETER_NAMES = eINSTANCE.getJavaFunction_ParameterNames();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_FUNCTION__CODE = eINSTANCE.getJavaFunction_Code();

		/**
		 * The meta object literal for the '<em><b>Code URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_FUNCTION__CODE_URL = eINSTANCE.getJavaFunction_CodeURL();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.ScriptBindingImpl <em>Script Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.ScriptBindingImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getScriptBinding()
		 * @generated
		 */
		EClass SCRIPT_BINDING = eINSTANCE.getScriptBinding();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_BINDING__KEY = eINSTANCE.getScriptBinding_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_BINDING__VALUE = eINSTANCE.getScriptBinding_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl <em>Java Script Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getJavaScriptFunction()
		 * @generated
		 */
		EClass JAVA_SCRIPT_FUNCTION = eINSTANCE.getJavaScriptFunction();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_SCRIPT_FUNCTION__CODE = eINSTANCE.getJavaScriptFunction_Code();

		/**
		 * The meta object literal for the '<em><b>Code URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_SCRIPT_FUNCTION__CODE_URL = eINSTANCE.getJavaScriptFunction_CodeURL();

		/**
		 * The meta object literal for the '<em><b>Parameter Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_SCRIPT_FUNCTION__PARAMETER_NAMES = eINSTANCE.getJavaScriptFunction_ParameterNames();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_SCRIPT_FUNCTION__BINDINGS = eINSTANCE.getJavaScriptFunction_Bindings();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl <em>Object Method Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getObjectMethodFunction()
		 * @generated
		 */
		EClass OBJECT_METHOD_FUNCTION = eINSTANCE.getObjectMethodFunction();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_METHOD_FUNCTION__TARGET = eINSTANCE.getObjectMethodFunction_Target();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_METHOD_FUNCTION__METHOD_NAME = eINSTANCE.getObjectMethodFunction_MethodName();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_METHOD_FUNCTION__PARAMETER_TYPES = eINSTANCE.getObjectMethodFunction_ParameterTypes();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl <em>Service Method Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getServiceMethodFunction()
		 * @generated
		 */
		EClass SERVICE_METHOD_FUNCTION = eINSTANCE.getServiceMethodFunction();

		/**
		 * The meta object literal for the '<em><b>Service Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_METHOD_FUNCTION__SERVICE_TYPE = eINSTANCE.getServiceMethodFunction_ServiceType();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_METHOD_FUNCTION__FILTER = eINSTANCE.getServiceMethodFunction_Filter();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_METHOD_FUNCTION__METHOD_NAME = eINSTANCE.getServiceMethodFunction_MethodName();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_METHOD_FUNCTION__PARAMETER_TYPES = eINSTANCE.getServiceMethodFunction_ParameterTypes();

	}

} //FunctionPackage
