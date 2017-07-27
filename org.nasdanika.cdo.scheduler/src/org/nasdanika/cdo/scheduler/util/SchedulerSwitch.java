/**
 */
package org.nasdanika.cdo.scheduler.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.nasdanika.cdo.scheduler.Diagnostic;
import org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask;
import org.nasdanika.cdo.scheduler.FixedRateSchedulerTask;
import org.nasdanika.cdo.scheduler.RecurringSchedulerTask;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.SchedulerTask;
import org.nasdanika.cdo.scheduler.StackTraceEntry;

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
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage
 * @generated
 */
public class SchedulerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerSwitch() {
		if (modelPackage == null) {
			modelPackage = SchedulerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case SchedulerPackage.DIAGNOSTIC: {
				Diagnostic diagnostic = (Diagnostic)theEObject;
				T result = caseDiagnostic(diagnostic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SCHEDULER_TASK: {
				SchedulerTask<?> schedulerTask = (SchedulerTask<?>)theEObject;
				T result = caseSchedulerTask(schedulerTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.RECURRING_SCHEDULER_TASK: {
				RecurringSchedulerTask<?> recurringSchedulerTask = (RecurringSchedulerTask<?>)theEObject;
				T result = caseRecurringSchedulerTask(recurringSchedulerTask);
				if (result == null) result = caseSchedulerTask(recurringSchedulerTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.FIXED_DELAY_SCHEDULER_TASK: {
				FixedDelaySchedulerTask<?> fixedDelaySchedulerTask = (FixedDelaySchedulerTask<?>)theEObject;
				T result = caseFixedDelaySchedulerTask(fixedDelaySchedulerTask);
				if (result == null) result = caseRecurringSchedulerTask(fixedDelaySchedulerTask);
				if (result == null) result = caseSchedulerTask(fixedDelaySchedulerTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.FIXED_RATE_SCHEDULER_TASK: {
				FixedRateSchedulerTask<?> fixedRateSchedulerTask = (FixedRateSchedulerTask<?>)theEObject;
				T result = caseFixedRateSchedulerTask(fixedRateSchedulerTask);
				if (result == null) result = caseRecurringSchedulerTask(fixedRateSchedulerTask);
				if (result == null) result = caseSchedulerTask(fixedRateSchedulerTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.THROWABLE: {
				org.nasdanika.cdo.scheduler.Throwable throwable = (org.nasdanika.cdo.scheduler.Throwable)theEObject;
				T result = caseThrowable(throwable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.STACK_TRACE_ENTRY: {
				StackTraceEntry stackTraceEntry = (StackTraceEntry)theEObject;
				T result = caseStackTraceEntry(stackTraceEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagnostic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagnostic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagnostic(Diagnostic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR> T caseSchedulerTask(SchedulerTask<CR> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recurring Scheduler Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recurring Scheduler Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR> T caseRecurringSchedulerTask(RecurringSchedulerTask<CR> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Rate Scheduler Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Rate Scheduler Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR> T caseFixedRateSchedulerTask(FixedRateSchedulerTask<CR> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Delay Scheduler Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Delay Scheduler Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR> T caseFixedDelaySchedulerTask(FixedDelaySchedulerTask<CR> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throwable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throwable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrowable(org.nasdanika.cdo.scheduler.Throwable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stack Trace Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStackTraceEntry(StackTraceEntry object) {
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

} //SchedulerSwitch
