/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.flow.Command;
import org.nasdanika.cdo.flow.Deferred;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Job;

import org.nasdanika.cdo.flow.JobStatus;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getDeferred <em>Deferred</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getStarted <em>Started</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getCompleted <em>Completed</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getWhen <em>When</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobImpl#getFailureReason <em>Failure Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobImpl<R, C extends Context> extends CDOObjectImpl implements Job<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.JOB;
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
	@SuppressWarnings("unchecked")
	public Command<R, C> getCommand() {
		return (Command<R, C>)eGet(FlowPackage.Literals.JOB__COMMAND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(Command<R, C> newCommand) {
		eSet(FlowPackage.Literals.JOB__COMMAND, newCommand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Deferred<R, C> getDeferred() {
		return (Deferred<R, C>)eGet(FlowPackage.Literals.JOB__DEFERRED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeferred(Deferred<R, C> newDeferred) {
		eSet(FlowPackage.Literals.JOB__DEFERRED, newDeferred);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreated() {
		return (Date)eGet(FlowPackage.Literals.JOB__CREATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(Date newCreated) {
		eSet(FlowPackage.Literals.JOB__CREATED, newCreated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStarted() {
		return (Date)eGet(FlowPackage.Literals.JOB__STARTED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarted(Date newStarted) {
		eSet(FlowPackage.Literals.JOB__STARTED, newStarted);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCompleted() {
		return (Date)eGet(FlowPackage.Literals.JOB__COMPLETED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompleted(Date newCompleted) {
		eSet(FlowPackage.Literals.JOB__COMPLETED, newCompleted);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobStatus getStatus() {
		return (JobStatus)eGet(FlowPackage.Literals.JOB__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(JobStatus newStatus) {
		eSet(FlowPackage.Literals.JOB__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getWhen() {
		return (Date)eGet(FlowPackage.Literals.JOB__WHEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(Date newWhen) {
		eSet(FlowPackage.Literals.JOB__WHEN, newWhen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureReason() {
		return (String)eGet(FlowPackage.Literals.JOB__FAILURE_REASON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureReason(String newFailureReason) {
		eSet(FlowPackage.Literals.JOB__FAILURE_REASON, newFailureReason);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canExecute() {
		return JobStatus.PENDING.equals(getStatus()) && (getWhen()==null || !getWhen().after(new Date()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FlowPackage.JOB___CAN_EXECUTE:
				return canExecute();
		}
		return super.eInvoke(operationID, arguments);
	}

} //JobImpl
