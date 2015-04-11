/**
 */
package org.nasdanika.cdo.function.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.function.*;
import org.nasdanika.cdo.function.AbstractFunction;
import org.nasdanika.cdo.function.BoundFunction;
import org.nasdanika.cdo.function.CDOServiceBinding;
import org.nasdanika.cdo.function.CommandFunction;
import org.nasdanika.cdo.function.ContextArgument;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.JavaFunction;
import org.nasdanika.cdo.function.JavaScriptFunction;
import org.nasdanika.cdo.function.ObjectMethodFunction;
import org.nasdanika.cdo.function.ServiceMethodFunction;
import org.nasdanika.core.Context;
import org.nasdanika.function.ServiceBinding;
import org.nasdanika.function.cdo.CDOTransactionContextFunction;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.function.FunctionPackage
 * @generated
 */
public class FunctionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FunctionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FunctionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionSwitch<Adapter> modelSwitch =
		new FunctionSwitch<Adapter>() {
			@Override
			public Adapter caseContext(Context object) {
				return createContextAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseCDOTransactionContextFunction(CDOTransactionContextFunction<CR, T, R> object) {
				return createCDOTransactionContextFunctionAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseAbstractFunction(AbstractFunction<CR, T, R> object) {
				return createAbstractFunctionAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseBoundFunction(BoundFunction<CR, T, R> object) {
				return createBoundFunctionAdapter();
			}
			@Override
			public Adapter caseArgumentBinding(Map.Entry<Integer, EObject> object) {
				return createArgumentBindingAdapter();
			}
			@Override
			public Adapter caseServiceBinding(ServiceBinding object) {
				return createServiceBindingAdapter();
			}
			@Override
			public Adapter caseCDOServiceBinding(CDOServiceBinding object) {
				return createCDOServiceBindingAdapter();
			}
			@Override
			public Adapter caseContextArgument(ContextArgument object) {
				return createContextArgumentAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseCommandFunction(CommandFunction<CR, T, R> object) {
				return createCommandFunctionAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseJavaFunction(JavaFunction<CR, T, R> object) {
				return createJavaFunctionAdapter();
			}
			@Override
			public Adapter caseScriptBinding(Map.Entry<String, EObject> object) {
				return createScriptBindingAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseJavaScriptFunction(JavaScriptFunction<CR, T, R> object) {
				return createJavaScriptFunctionAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseObjectMethodFunction(ObjectMethodFunction<CR, T, R> object) {
				return createObjectMethodFunctionAdapter();
			}
			@Override
			public <CR, T, R> Adapter caseServiceMethodFunction(ServiceMethodFunction<CR, T, R> object) {
				return createServiceMethodFunctionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.core.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.core.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.function.cdo.CDOTransactionContextFunction <em>CDO Transaction Context Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.function.cdo.CDOTransactionContextFunction
	 * @generated
	 */
	public Adapter createCDOTransactionContextFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.AbstractFunction <em>Abstract Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.AbstractFunction
	 * @generated
	 */
	public Adapter createAbstractFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.BoundFunction <em>Bound Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.BoundFunction
	 * @generated
	 */
	public Adapter createBoundFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Argument Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createArgumentBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.function.ServiceBinding <em>Service Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.function.ServiceBinding
	 * @generated
	 */
	public Adapter createServiceBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.CDOServiceBinding <em>CDO Service Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.CDOServiceBinding
	 * @generated
	 */
	public Adapter createCDOServiceBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.ContextArgument <em>Context Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.ContextArgument
	 * @generated
	 */
	public Adapter createContextArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.CommandFunction <em>Command Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.CommandFunction
	 * @generated
	 */
	public Adapter createCommandFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.JavaFunction <em>Java Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.JavaFunction
	 * @generated
	 */
	public Adapter createJavaFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Script Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createScriptBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.JavaScriptFunction <em>Java Script Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.JavaScriptFunction
	 * @generated
	 */
	public Adapter createJavaScriptFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.ObjectMethodFunction <em>Object Method Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.ObjectMethodFunction
	 * @generated
	 */
	public Adapter createObjectMethodFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.function.ServiceMethodFunction <em>Service Method Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.function.ServiceMethodFunction
	 * @generated
	 */
	public Adapter createServiceMethodFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //FunctionAdapterFactory
