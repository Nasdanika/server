/**
 */
package org.nasdanika.cdo.scheduler;

import java.util.Date;
import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.cdo.CDOTransactionContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Supertype for scheduler tasks.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAt <em>Run At</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#isFixedRate <em>Fixed Rate</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#isActive <em>Active</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface SchedulerTask<CR> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Run At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When to execute task. Submits task if this value is before the current time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Run At</em>' attribute.
	 * @see #setRunAt(Date)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_RunAt()
	 * @model
	 * @generated
	 */
	Date getRunAt();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAt <em>Run At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run At</em>' attribute.
	 * @see #getRunAt()
	 * @generated
	 */
	void setRunAt(Date value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Task period/interval. One-off task if set to non-positive value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(long)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_Period()
	 * @model
	 * @generated
	 */
	long getPeriod();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(long value);

	/**
	 * Returns the value of the '<em><b>Fixed Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Rate</em>' attribute.
	 * @see #setFixedRate(boolean)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_FixedRate()
	 * @model
	 * @generated
	 */
	boolean isFixedRate();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#isFixedRate <em>Fixed Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Rate</em>' attribute.
	 * @see #isFixedRate()
	 * @generated
	 */
	void setFixedRate(boolean value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Task's execute() method is invoked by the scheduler only if the task is active.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_Active()
	 * @model default="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Invoked by the scheduler to execute the task.
	 * If this method returns false, then the task is canceled.
	 * <!-- end-model-doc -->
	 * @model contextDataType="org.nasdanika.cdo.scheduler.CDOTransactionContext&lt;CR&gt;"
	 * @generated
	 */
	void execute(CDOTransactionContext<CR> context);

} // SchedulerTask
