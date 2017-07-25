/**
 */
package org.nasdanika.cdo.scheduler;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Time and duration of SchedulerTask execution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.RunEntry#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.RunEntry#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getRunEntry()
 * @model annotation="org.nasdanika.cdo.web.render icon='fa fa-cog' editable='false'"
 * @generated
 */
public interface RunEntry extends Diagnostic {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Duration of task execution in milliseconds.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(long)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getRunEntry_Duration()
	 * @model
	 * @generated
	 */
	long getDuration();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.RunEntry#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(long value);

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
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getRunEntry_Exception()
	 * @model containment="true"
	 * @generated
	 */
	org.nasdanika.cdo.scheduler.Throwable getException();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.RunEntry#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(org.nasdanika.cdo.scheduler.Throwable value);

} // RunEntry
