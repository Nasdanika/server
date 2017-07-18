/**
 */
package org.nasdanika.cdo.scheduler.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.SchedulerTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getRunAt <em>Run At</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#isFixedRate <em>Fixed Rate</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#isActive <em>Active</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SchedulerTaskImpl<CR> extends CDOObjectImpl implements SchedulerTask<CR> {
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
	public Date getRunAt() {
		return (Date)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunAt(Date newRunAt) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AT, newRunAt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPeriod() {
		return (Long)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__PERIOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(long newPeriod) {
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
	public boolean isActive() {
		return (Boolean)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__ACTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__ACTIVE, newActive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void execute(CDOTransactionContext<CR> context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SchedulerPackage.SCHEDULER_TASK___EXECUTE__CDOTRANSACTIONCONTEXT:
				execute((CDOTransactionContext<CR>)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SchedulerTaskImpl
