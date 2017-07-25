/**
 */
package org.nasdanika.cdo.scheduler;

import java.util.concurrent.TimeUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recurring Scheduler Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.RecurringSchedulerTask#getTimeUnit <em>Time Unit</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getRecurringSchedulerTask()
 * @model abstract="true"
 * @generated
 */
public interface RecurringSchedulerTask<CR> extends SchedulerTask<CR> {
	/**
	 * Returns the value of the '<em><b>Time Unit</b></em>' attribute.
	 * The default value is <code>"SECONDS"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Unit</em>' attribute.
	 * @see #setTimeUnit(TimeUnit)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getRecurringSchedulerTask_TimeUnit()
	 * @model default="SECONDS" dataType="org.nasdanika.cdo.scheduler.TimeUnit" required="true"
	 * @generated
	 */
	TimeUnit getTimeUnit();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.RecurringSchedulerTask#getTimeUnit <em>Time Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Unit</em>' attribute.
	 * @see #getTimeUnit()
	 * @generated
	 */
	void setTimeUnit(TimeUnit value);

} // RecurringSchedulerTask
