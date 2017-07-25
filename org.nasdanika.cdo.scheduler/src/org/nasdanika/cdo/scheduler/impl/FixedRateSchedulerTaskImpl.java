/**
 */
package org.nasdanika.cdo.scheduler.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.cdo.scheduler.FixedRateSchedulerTask;
import org.nasdanika.cdo.scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Rate Scheduler Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.FixedRateSchedulerTaskImpl#getPeriod <em>Period</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FixedRateSchedulerTaskImpl<CR> extends RecurringSchedulerTaskImpl<CR> implements FixedRateSchedulerTask<CR> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedRateSchedulerTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.FIXED_RATE_SCHEDULER_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPeriod() {
		return (Long)eGet(SchedulerPackage.Literals.FIXED_RATE_SCHEDULER_TASK__PERIOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(long newPeriod) {
		eSet(SchedulerPackage.Literals.FIXED_RATE_SCHEDULER_TASK__PERIOD, newPeriod);
	}

} //FixedRateSchedulerTaskImpl
