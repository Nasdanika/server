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
	 * The number of structural features of the '<em>Abstract Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FUNCTION_FEATURE_COUNT = CDO_TRANSACTION_CONTEXT_FUNCTION_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.function.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.function.impl.BindingImpl
	 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OPERATION_COUNT = 0;


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
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EIntegerObject"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Value();

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
		 * The meta object literal for the '{@link org.nasdanika.cdo.function.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.function.impl.BindingImpl
		 * @see org.nasdanika.cdo.function.impl.FunctionPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__KEY = eINSTANCE.getBinding_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__VALUE = eINSTANCE.getBinding_Value();

	}

} //FunctionPackage
