/**
 */
package org.nasdanika.cdo.scheduler.impl;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.cdo.scheduler.RecurringSchedulerTask;
import org.nasdanika.cdo.scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recurring Scheduler Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.RecurringSchedulerTaskImpl#getTimeUnit <em>Time Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RecurringSchedulerTaskImpl<CR> extends SchedulerTaskImpl<CR> implements RecurringSchedulerTask<CR> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecurringSchedulerTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.RECURRING_SCHEDULER_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeUnit getTimeUnit() {
		return (TimeUnit)eGet(SchedulerPackage.Literals.RECURRING_SCHEDULER_TASK__TIME_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeUnit(TimeUnit newTimeUnit) {
		eSet(SchedulerPackage.Literals.RECURRING_SCHEDULER_TASK__TIME_UNIT, newTimeUnit);
	}

} //RecurringSchedulerTaskImpl
