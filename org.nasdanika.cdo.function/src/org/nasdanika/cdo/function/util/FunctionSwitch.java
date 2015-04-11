/**
 */
package org.nasdanika.cdo.function.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.function.FunctionPackage
 * @generated
 */
public class FunctionSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FunctionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionSwitch() {
		if (modelPackage == null) {
			modelPackage = FunctionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FunctionPackage.CONTEXT: {
				Context context = (Context)theEObject;
				T1 result = caseContext(context);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.CDO_TRANSACTION_CONTEXT_FUNCTION: {
				CDOTransactionContextFunction<?, ?, ?, ?> cdoTransactionContextFunction = (CDOTransactionContextFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseCDOTransactionContextFunction(cdoTransactionContextFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.ABSTRACT_FUNCTION: {
				AbstractFunction<?, ?, ?, ?> abstractFunction = (AbstractFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseAbstractFunction(abstractFunction);
				if (result == null) result = caseCDOTransactionContextFunction(abstractFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.BOUND_FUNCTION: {
				BoundFunction<?, ?, ?, ?> boundFunction = (BoundFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseBoundFunction(boundFunction);
				if (result == null) result = caseAbstractFunction(boundFunction);
				if (result == null) result = caseCDOTransactionContextFunction(boundFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.ARGUMENT_BINDING: {
				@SuppressWarnings("unchecked") Map.Entry<Integer, EObject> argumentBinding = (Map.Entry<Integer, EObject>)theEObject;
				T1 result = caseArgumentBinding(argumentBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.SERVICE_BINDING: {
				ServiceBinding serviceBinding = (ServiceBinding)theEObject;
				T1 result = caseServiceBinding(serviceBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.CDO_SERVICE_BINDING: {
				CDOServiceBinding cdoServiceBinding = (CDOServiceBinding)theEObject;
				T1 result = caseCDOServiceBinding(cdoServiceBinding);
				if (result == null) result = caseServiceBinding(cdoServiceBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.CONTEXT_ARGUMENT: {
				ContextArgument contextArgument = (ContextArgument)theEObject;
				T1 result = caseContextArgument(contextArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.COMMAND_FUNCTION: {
				CommandFunction<?, ?, ?, ?> commandFunction = (CommandFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseCommandFunction(commandFunction);
				if (result == null) result = caseAbstractFunction(commandFunction);
				if (result == null) result = caseCDOTransactionContextFunction(commandFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.JAVA_FUNCTION: {
				JavaFunction<?, ?, ?, ?> javaFunction = (JavaFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseJavaFunction(javaFunction);
				if (result == null) result = caseAbstractFunction(javaFunction);
				if (result == null) result = caseCDOTransactionContextFunction(javaFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.SCRIPT_BINDING: {
				@SuppressWarnings("unchecked") Map.Entry<String, EObject> scriptBinding = (Map.Entry<String, EObject>)theEObject;
				T1 result = caseScriptBinding(scriptBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.JAVA_SCRIPT_FUNCTION: {
				JavaScriptFunction<?, ?, ?, ?> javaScriptFunction = (JavaScriptFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseJavaScriptFunction(javaScriptFunction);
				if (result == null) result = caseAbstractFunction(javaScriptFunction);
				if (result == null) result = caseCDOTransactionContextFunction(javaScriptFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.OBJECT_METHOD_FUNCTION: {
				ObjectMethodFunction<?, ?, ?, ?> objectMethodFunction = (ObjectMethodFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseObjectMethodFunction(objectMethodFunction);
				if (result == null) result = caseAbstractFunction(objectMethodFunction);
				if (result == null) result = caseCDOTransactionContextFunction(objectMethodFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionPackage.SERVICE_METHOD_FUNCTION: {
				ServiceMethodFunction<?, ?, ?, ?> serviceMethodFunction = (ServiceMethodFunction<?, ?, ?, ?>)theEObject;
				T1 result = caseServiceMethodFunction(serviceMethodFunction);
				if (result == null) result = caseAbstractFunction(serviceMethodFunction);
				if (result == null) result = caseCDOTransactionContextFunction(serviceMethodFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CDO Transaction Context Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CDO Transaction Context Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseCDOTransactionContextFunction(CDOTransactionContextFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseAbstractFunction(AbstractFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseBoundFunction(BoundFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Argument Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseArgumentBinding(Map.Entry<Integer, EObject> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseServiceBinding(ServiceBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CDO Service Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CDO Service Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCDOServiceBinding(CDOServiceBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContextArgument(ContextArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseCommandFunction(CommandFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseJavaFunction(JavaFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseScriptBinding(Map.Entry<String, EObject> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Script Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Script Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseJavaScriptFunction(JavaScriptFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Method Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Method Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseObjectMethodFunction(ObjectMethodFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Method Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Method Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR, MC extends Context, T, R> T1 caseServiceMethodFunction(ServiceMethodFunction<CR, MC, T, R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //FunctionSwitch
