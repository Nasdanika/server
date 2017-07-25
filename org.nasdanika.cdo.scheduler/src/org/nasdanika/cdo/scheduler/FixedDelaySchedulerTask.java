/**
 */
package org.nasdanika.cdo.scheduler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Delay Scheduler Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask#getDelay <em>Delay</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getFixedDelaySchedulerTask()
 * @model abstract="true"
 * @generated
 */
public interface FixedDelaySchedulerTask<CR> extends RecurringSchedulerTask<CR> {
	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Task delay in time units.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(long)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getFixedDelaySchedulerTask_Delay()
	 * @model
	 * @generated
	 */
	long getDelay();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(long value);

} // FixedDelaySchedulerTask
