/**
 */
package org.nasdanika.cdo.scheduler.impl;

import java.lang.Throwable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.concurrent.SchedulerContext;
import org.nasdanika.cdo.scheduler.Diagnostic;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.SchedulerTask;
import org.nasdanika.cdo.security.Principal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#getHistory <em>History</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl#isDone <em>Done</em>}</li>
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
	public Date getStart() {
		return (Date)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(Date newStart) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__START, newStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDone() {
		return (Boolean)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__DONE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDone(boolean newDone) {
		eSet(SchedulerPackage.Literals.SCHEDULER_TASK__DONE, newDone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic run(SchedulerContext<CR> context) throws Exception {
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
			case SchedulerPackage.SCHEDULER_TASK___RUN__SCHEDULERCONTEXT:
				try {
					return run((SchedulerContext<CR>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Principal> getSubject() {
		return (EList<Principal>)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__SUBJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Diagnostic> getHistory() {
		return (EList<Diagnostic>)eGet(SchedulerPackage.Literals.SCHEDULER_TASK__HISTORY, true);
	}

} //SchedulerTaskImpl
