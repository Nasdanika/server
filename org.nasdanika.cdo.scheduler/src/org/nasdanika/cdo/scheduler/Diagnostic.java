/**
 */
package org.nasdanika.cdo.scheduler;

import java.util.Date;
import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagnostic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Diagnostic of the task run. The root diagnostic returned by the run() method is merged into the run history entry.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.Diagnostic#getTime <em>Time</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Diagnostic#getStatus <em>Status</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Diagnostic#getMessage <em>Message</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Diagnostic#getChildren <em>Children</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Diagnostic#getException <em>Exception</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Diagnostic#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getDiagnostic()
 * @model annotation="org.nasdanika.cdo.web.render editable='false'"
 * @extends CDOObject
 * @generated
 */
public interface Diagnostic extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.nasdanika.cdo.scheduler.Status}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.nasdanika.cdo.scheduler.Status
	 * @see #setStatus(Status)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getDiagnostic_Status()
	 * @model required="true"
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Diagnostic#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.nasdanika.cdo.scheduler.Status
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getDiagnostic_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Diagnostic#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.scheduler.Diagnostic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getDiagnostic_Children()
	 * @model containment="true"
	 *        annotation="org.nasdanika.cdo.web.render editable='false' tree-feature='false'"
	 * @generated
	 */
	EList<Diagnostic> getChildren();

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(org.nasdanika.cdo.scheduler.Throwable)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getDiagnostic_Exception()
	 * @model containment="true"
	 * @generated
	 */
	org.nasdanika.cdo.scheduler.Throwable getException();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Diagnostic#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(org.nasdanika.cdo.scheduler.Throwable value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Duration of task execution in milliseconds.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(long)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getDiagnostic_Duration()
	 * @model
	 * @generated
	 */
	long getDuration();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Diagnostic#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(long value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time of task execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(Date)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getDiagnostic_Time()
	 * @model required="true"
	 *        annotation="org.nasdanika.cdo.web.render format='yyyy-MM-dd HH:mm:ss.SSS z'"
	 * @generated
	 */
	Date getTime();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Diagnostic#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(Date value);

} // Diagnostic
