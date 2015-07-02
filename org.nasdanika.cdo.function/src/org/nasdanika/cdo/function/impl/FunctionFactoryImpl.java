/**
 */
package org.nasdanika.cdo.function.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.cdo.function.BoundFunction;
import org.nasdanika.cdo.function.CDOServiceBinding;
import org.nasdanika.cdo.function.CommandFunction;
import org.nasdanika.cdo.function.ContextArgument;
import org.nasdanika.cdo.function.FunctionFactory;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.JavaFunction;
import org.nasdanika.cdo.function.JavaScriptFunction;
import org.nasdanika.cdo.function.ObjectMethodFunction;
import org.nasdanika.cdo.function.ServiceMethodFunction;

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
	public <CR, T, R> BoundFunction<CR, T, R> createBoundFunction() {
		BoundFunctionImpl<CR, T, R> boundFunction = new BoundFunctionImpl<CR, T, R>();
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
	public <CR, T, R> CommandFunction<CR, T, R> createCommandFunction() {
		CommandFunctionImpl<CR, T, R> commandFunction = new CommandFunctionImpl<CR, T, R>();
		return commandFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, T, R> JavaFunction<CR, T, R> createJavaFunction() {
		JavaFunctionImpl<CR, T, R> javaFunction = new JavaFunctionImpl<CR, T, R>();
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
	public <CR, T, R> JavaScriptFunction<CR, T, R> createJavaScriptFunction() {
		JavaScriptFunctionImpl<CR, T, R> javaScriptFunction = new JavaScriptFunctionImpl<CR, T, R>();
		return javaScriptFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, T, R> ObjectMethodFunction<CR, T, R> createObjectMethodFunction() {
		ObjectMethodFunctionImpl<CR, T, R> objectMethodFunction = new ObjectMethodFunctionImpl<CR, T, R>();
		return objectMethodFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, T, R> ServiceMethodFunction<CR, T, R> createServiceMethodFunction() {
		ServiceMethodFunctionImpl<CR, T, R> serviceMethodFunction = new ServiceMethodFunctionImpl<CR, T, R>();
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
