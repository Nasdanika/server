/**
 */
package org.nasdanika.cdo.scheduler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Rate Scheduler Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.FixedRateSchedulerTask#getPeriod <em>Period</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getFixedRateSchedulerTask()
 * @model abstract="true"
 * @generated
 */
public interface FixedRateSchedulerTask<CR> extends RecurringSchedulerTask<CR> {
	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Task period in time units.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(long)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getFixedRateSchedulerTask_Period()
	 * @model
	 * @generated
	 */
	long getPeriod();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.FixedRateSchedulerTask#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(long value);

} // FixedRateSchedulerTask
