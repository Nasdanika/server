/**
 */
package org.nasdanika.cdo.scheduler.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask;
import org.nasdanika.cdo.scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Delay Scheduler Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.FixedDelaySchedulerTaskImpl#getDelay <em>Delay</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FixedDelaySchedulerTaskImpl<CR> extends RecurringSchedulerTaskImpl<CR> implements FixedDelaySchedulerTask<CR> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedDelaySchedulerTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.FIXED_DELAY_SCHEDULER_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDelay() {
		return (Long)eGet(SchedulerPackage.Literals.FIXED_DELAY_SCHEDULER_TASK__DELAY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelay(long newDelay) {
		eSet(SchedulerPackage.Literals.FIXED_DELAY_SCHEDULER_TASK__DELAY, newDelay);
	}

} //FixedDelaySchedulerTaskImpl
