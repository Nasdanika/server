/**
 */
package org.nasdanika.cdo.flow;

import java.util.Date;
import org.eclipse.emf.cdo.CDOObject;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getCommand <em>Command</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getDeferred <em>Deferred</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getCreated <em>Created</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getStarted <em>Started</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getCompleted <em>Completed</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getStatus <em>Status</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getWhen <em>When</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Job#getFailureReason <em>Failure Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getJob()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @extends CDOObject
 * @generated
 */
public interface Job<R, C extends Context> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' reference.
	 * @see #setCommand(Command)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_Command()
	 * @model
	 * @generated
	 */
	Command<R, C> getCommand();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getCommand <em>Command</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command<R, C> value);

	/**
	 * Returns the value of the '<em><b>Deferred</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deferred</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deferred</em>' reference.
	 * @see #setDeferred(Deferred)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_Deferred()
	 * @model
	 * @generated
	 */
	Deferred<R, C> getDeferred();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getDeferred <em>Deferred</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deferred</em>' reference.
	 * @see #getDeferred()
	 * @generated
	 */
	void setDeferred(Deferred<R, C> value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Started</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Started</em>' attribute.
	 * @see #setStarted(Date)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_Started()
	 * @model
	 * @generated
	 */
	Date getStarted();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getStarted <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Started</em>' attribute.
	 * @see #getStarted()
	 * @generated
	 */
	void setStarted(Date value);

	/**
	 * Returns the value of the '<em><b>Completed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completed</em>' attribute.
	 * @see #setCompleted(Date)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_Completed()
	 * @model
	 * @generated
	 */
	Date getCompleted();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getCompleted <em>Completed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completed</em>' attribute.
	 * @see #getCompleted()
	 * @generated
	 */
	void setCompleted(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.nasdanika.cdo.flow.JobStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.nasdanika.cdo.flow.JobStatus
	 * @see #setStatus(JobStatus)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_Status()
	 * @model
	 * @generated
	 */
	JobStatus getStatus();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.nasdanika.cdo.flow.JobStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(JobStatus value);

	/**
	 * Returns the value of the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' attribute.
	 * @see #setWhen(Date)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_When()
	 * @model
	 * @generated
	 */
	Date getWhen();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getWhen <em>When</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' attribute.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(Date value);

	/**
	 * Returns the value of the '<em><b>Failure Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Reason</em>' attribute.
	 * @see #setFailureReason(String)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJob_FailureReason()
	 * @model
	 * @generated
	 */
	String getFailureReason();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Job#getFailureReason <em>Failure Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Reason</em>' attribute.
	 * @see #getFailureReason()
	 * @generated
	 */
	void setFailureReason(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canExecute();

} // Job
