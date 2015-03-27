/**
 */
package org.nasdanika.cdo.function.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.cdo.function.*;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionFactoryImpl extends EFactoryImpl implements FunctionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionFactory init() {
		try {
			FunctionFactory theFunctionFactory = (FunctionFactory)EPackage.Registry.INSTANCE.getEFactory(FunctionPackage.eNS_URI);
			if (theFunctionFactory != null) {
				return theFunctionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FunctionPackage.BOUND_FUNCTION: return (EObject)createBoundFunction();
			case FunctionPackage.ARGUMENT_BINDING: return (EObject)createArgumentBinding();
			case FunctionPackage.CDO_SERVICE_BINDING: return (EObject)createCDOServiceBinding();
			case FunctionPackage.CONTEXT_ARGUMENT: return (EObject)createContextArgument();
			case FunctionPackage.COMMAND_FUNCTION: return (EObject)createCommandFunction();
			case FunctionPackage.JAVA_FUNCTION: return (EObject)createJavaFunction();
			case FunctionPackage.SCRIPT_BINDING: return (EObject)createScriptBinding();
			case FunctionPackage.JAVA_SCRIPT_FUNCTION: return (EObject)createJavaScriptFunction();
			case FunctionPackage.OBJECT_METHOD_FUNCTION: return (EObject)createObjectMethodFunction();
			case FunctionPackage.SERVICE_METHOD_FUNCTION: return (EObject)createServiceMethodFunction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, MC extends Context, T, R> BoundFunction<CR, MC, T, R> createBoundFunction() {
		BoundFunctionImpl<CR, MC, T, R> boundFunction = new BoundFunctionImpl<CR, MC, T, R>();
		return boundFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Integer, EObject> createArgumentBinding() {
		ArgumentBindingImpl argumentBinding = new ArgumentBindingImpl();
		return argumentBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDOServiceBinding createCDOServiceBinding() {
		CDOServiceBindingImpl cdoServiceBinding = new CDOServiceBindingImpl();
		return cdoServiceBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextArgument createContextArgument() {
		ContextArgumentImpl contextArgument = new ContextArgumentImpl();
		return contextArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, MC extends Context, T, R> CommandFunction<CR, MC, T, R> createCommandFunction() {
		CommandFunctionImpl<CR, MC, T, R> commandFunction = new CommandFunctionImpl<CR, MC, T, R>();
		return commandFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, MC extends Context, T, R> JavaFunction<CR, MC, T, R> createJavaFunction() {
		JavaFunctionImpl<CR, MC, T, R> javaFunction = new JavaFunctionImpl<CR, MC, T, R>();
		return javaFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EObject> createScriptBinding() {
		ScriptBindingImpl scriptBinding = new ScriptBindingImpl();
		return scriptBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, MC extends Context, T, R> JavaScriptFunction<CR, MC, T, R> createJavaScriptFunction() {
		JavaScriptFunctionImpl<CR, MC, T, R> javaScriptFunction = new JavaScriptFunctionImpl<CR, MC, T, R>();
		return javaScriptFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, MC extends Context, T, R> ObjectMethodFunction<CR, MC, T, R> createObjectMethodFunction() {
		ObjectMethodFunctionImpl<CR, MC, T, R> objectMethodFunction = new ObjectMethodFunctionImpl<CR, MC, T, R>();
		return objectMethodFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, MC extends Context, T, R> ServiceMethodFunction<CR, MC, T, R> createServiceMethodFunction() {
		ServiceMethodFunctionImpl<CR, MC, T, R> serviceMethodFunction = new ServiceMethodFunctionImpl<CR, MC, T, R>();
		return serviceMethodFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionPackage getFunctionPackage() {
		return (FunctionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FunctionPackage getPackage() {
		return FunctionPackage.eINSTANCE;
	}

} //FunctionFactoryImpl
