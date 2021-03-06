/**
 */
package org.nasdanika.cdo.scheduler.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.scheduler.Diagnostic;
import org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask;
import org.nasdanika.cdo.scheduler.FixedRateSchedulerTask;
import org.nasdanika.cdo.scheduler.RecurringSchedulerTask;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.SchedulerTask;
import org.nasdanika.cdo.scheduler.StackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage
 * @generated
 */
public class SchedulerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SchedulerPackage.eINSTANCE;
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
	protected SchedulerSwitch<Adapter> modelSwitch =
		new SchedulerSwitch<Adapter>() {
			@Override
			public Adapter caseDiagnostic(Diagnostic object) {
				return createDiagnosticAdapter();
			}
			@Override
			public <CR> Adapter caseSchedulerTask(SchedulerTask<CR> object) {
				return createSchedulerTaskAdapter();
			}
			@Override
			public <CR> Adapter caseRecurringSchedulerTask(RecurringSchedulerTask<CR> object) {
				return createRecurringSchedulerTaskAdapter();
			}
			@Override
			public <CR> Adapter caseFixedDelaySchedulerTask(FixedDelaySchedulerTask<CR> object) {
				return createFixedDelaySchedulerTaskAdapter();
			}
			@Override
			public <CR> Adapter caseFixedRateSchedulerTask(FixedRateSchedulerTask<CR> object) {
				return createFixedRateSchedulerTaskAdapter();
			}
			@Override
			public Adapter caseThrowable(org.nasdanika.cdo.scheduler.Throwable object) {
				return createThrowableAdapter();
			}
			@Override
			public Adapter caseStackTraceEntry(StackTraceEntry object) {
				return createStackTraceEntryAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.scheduler.Diagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic
	 * @generated
	 */
	public Adapter createDiagnosticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.scheduler.SchedulerTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask
	 * @generated
	 */
	public Adapter createSchedulerTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.scheduler.RecurringSchedulerTask <em>Recurring Scheduler Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.scheduler.RecurringSchedulerTask
	 * @generated
	 */
	public Adapter createRecurringSchedulerTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.scheduler.FixedRateSchedulerTask <em>Fixed Rate Scheduler Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.scheduler.FixedRateSchedulerTask
	 * @generated
	 */
	public Adapter createFixedRateSchedulerTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask <em>Fixed Delay Scheduler Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask
	 * @generated
	 */
	public Adapter createFixedDelaySchedulerTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.scheduler.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.scheduler.Throwable
	 * @generated
	 */
	public Adapter createThrowableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.scheduler.StackTraceEntry <em>Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.scheduler.StackTraceEntry
	 * @generated
	 */
	public Adapter createStackTraceEntryAdapter() {
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

} //SchedulerAdapterFactory
