/**
 */
package org.nasdanika.cdo.scheduler.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.SchedulerTask;
import org.nasdanika.cdo.security.Principal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getRunAt <em>Run At</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#isFixedRate <em>Fixed Rate</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getRunAs <em>Run As</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulerTaskImpl extends CDOObjectImpl implements SchedulerTask {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SCHEDULER_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRunAt() {
		return (Long)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunAt(long newRunAt) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AT, newRunAt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getPeriod() {
		return (Long)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__PERIOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(Long newPeriod) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__PERIOD, newPeriod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFixedRate() {
		return (Boolean)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__FIXED_RATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedRate(boolean newFixedRate) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__FIXED_RATE, newFixedRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Principal getRunAs() {
		return (Principal)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunAs(Principal newRunAs) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AS, newRunAs);
	}

} //SchedulerTaskImpl
