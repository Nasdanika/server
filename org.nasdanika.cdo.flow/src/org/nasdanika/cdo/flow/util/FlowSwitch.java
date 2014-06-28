/**
 */
package org.nasdanika.cdo.flow.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.nasdanika.cdo.flow.*;
import org.nasdanika.core.Context;

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
 * @see org.nasdanika.cdo.flow.FlowPackage
 * @generated
 */
public class FlowSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FlowPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSwitch() {
		if (modelPackage == null) {
			modelPackage = FlowPackage.eINSTANCE;
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FlowPackage.THEN: {
				Then<?, ?, ?> then = (Then<?, ?, ?>)theEObject;
				T result = caseThen(then);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.THEN_REFERENCE: {
				ThenReference<?, ?, ?> thenReference = (ThenReference<?, ?, ?>)theEObject;
				T result = caseThenReference(thenReference);
				if (result == null) result = caseThen(thenReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.EXECUTOR: {
				Executor<?> executor = (Executor<?>)theEObject;
				T result = caseExecutor(executor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PROMISE: {
				Promise<?, ?> promise = (Promise<?, ?>)theEObject;
				T result = casePromise(promise);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.COMMAND: {
				Command<?, ?> command = (Command<?, ?>)theEObject;
				T result = caseCommand(command);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DEFERRED: {
				Deferred<?, ?> deferred = (Deferred<?, ?>)theEObject;
				T result = caseDeferred(deferred);
				if (result == null) result = casePromise(deferred);
				if (result == null) result = caseCommand(deferred);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOB: {
				Job<?, ?> job = (Job<?, ?>)theEObject;
				T result = caseJob(job);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOB_QUEUE: {
				JobQueue<?> jobQueue = (JobQueue<?>)theEObject;
				T result = caseJobQueue(jobQueue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.INVOCABLE: {
				Invocable<?, ?> invocable = (Invocable<?, ?>)theEObject;
				T result = caseInvocable(invocable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.INVOCABLE_REFERENCE: {
				InvocableReference<?, ?> invocableReference = (InvocableReference<?, ?>)theEObject;
				T result = caseInvocableReference(invocableReference);
				if (result == null) result = caseInvocable(invocableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ACTION: {
				Action<?, ?> action = (Action<?, ?>)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseInvocable(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ACTION_OUTPUT: {
				@SuppressWarnings("unchecked") Map.Entry<String, Invocable> actionOutput = (Map.Entry<String, Invocable>)theEObject;
				T result = caseActionOutput(actionOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DISPATCH: {
				Dispatch dispatch = (Dispatch)theEObject;
				T result = caseDispatch(dispatch);
				if (result == null) result = (T)caseInvocable(dispatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PUBLISH: {
				Publish publish = (Publish)theEObject;
				T result = casePublish(publish);
				if (result == null) result = (T)caseInvocable(publish);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DEFERRED_INVOCATION: {
				DeferredInvocation deferredInvocation = (DeferredInvocation)theEObject;
				T result = caseDeferredInvocation(deferredInvocation);
				if (result == null) result = (T)caseCommand(deferredInvocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DEFERRING_INVOCABLE: {
				DeferringInvocable deferringInvocable = (DeferringInvocable)theEObject;
				T result = caseDeferringInvocable(deferringInvocable);
				if (result == null) result = (T)caseInvocable(deferringInvocable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Then</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Then</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, R1, C extends Context> T caseThen(Then<R, R1, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Then Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Then Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, R1, C extends Context> T caseThenReference(ThenReference<R, R1, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Promise</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Promise</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T casePromise(Promise<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T caseCommand(Command<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Context> T caseExecutor(Executor<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferred</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferred</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T caseDeferred(Deferred<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T caseJob(Job<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Job Queue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Job Queue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Context> T caseJobQueue(JobQueue<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T caseInvocable(Invocable<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T caseInvocableReference(InvocableReference<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T caseAction(Action<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionOutput(Map.Entry<String, Invocable> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dispatch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dispatch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDispatch(Dispatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublish(Publish object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferred Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferred Invocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeferredInvocation(DeferredInvocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferring Invocable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferring Invocable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeferringInvocable(DeferringInvocable object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //FlowSwitch
