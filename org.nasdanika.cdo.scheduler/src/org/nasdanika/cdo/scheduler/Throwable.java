/**
 */
package org.nasdanika.cdo.scheduler;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throwable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Models java.lang.Throwable.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.Throwable#getType <em>Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Throwable#getMessage <em>Message</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Throwable#getStackTrace <em>Stack Trace</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Throwable#getSuppressed <em>Suppressed</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.Throwable#getCause <em>Cause</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getThrowable()
 * @model annotation="org.nasdanika.cdo.web.render icon='fa fa-bolt' editable='false'"
 * @extends CDOObject
 * @generated
 */
public interface Throwable extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Throwable class name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getThrowable_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Throwable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Error message.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getThrowable_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Throwable#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Stack Trace</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.scheduler.StackTraceEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Stack trace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stack Trace</em>' containment reference list.
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getThrowable_StackTrace()
	 * @model containment="true"
	 * @generated
	 */
	EList<StackTraceEntry> getStackTrace();

	/**
	 * Returns the value of the '<em><b>Suppressed</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.scheduler.Throwable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Stack trace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Suppressed</em>' containment reference list.
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getThrowable_Suppressed()
	 * @model containment="true"
	 * @generated
	 */
	EList<Throwable> getSuppressed();

	/**
	 * Returns the value of the '<em><b>Cause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Stack trace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cause</em>' containment reference.
	 * @see #setCause(Throwable)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getThrowable_Cause()
	 * @model containment="true"
	 * @generated
	 */
	Throwable getCause();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.Throwable#getCause <em>Cause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cause</em>' containment reference.
	 * @see #getCause()
	 * @generated
	 */
	void setCause(Throwable value);

} // Throwable
