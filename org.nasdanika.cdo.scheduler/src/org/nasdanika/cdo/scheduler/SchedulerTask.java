/**
 */
package org.nasdanika.cdo.scheduler;

import java.util.Date;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.nasdanika.cdo.concurrent.SchedulerContext;
import org.nasdanika.cdo.security.Principal;

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
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getStart <em>Start</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunHistory <em>Run History</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#isDone <em>Done</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface SchedulerTask<CR> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When to execute task. Submits task if this value is before the current time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(Date)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_Start()
	 * @model required="true"
	 *        annotation="org.nasdanika.cdo.web.render format='display: yyyy-MM-dd HH:mm:ss.SSS z\r\nedit: yyyy-MM-dd\'T\'HH:mm' input-type='datetime_local'"
	 * @generated
	 */
	Date getStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Date value);

	/**
	 * Returns the value of the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tasks are scheduled only if they are not done. Scheduler sets done to true for
	 * one-off tasks (not fixed rate or fixed delay).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Done</em>' attribute.
	 * @see #setDone(boolean)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_Done()
	 * @model
	 * @generated
	 */
	boolean isDone();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#isDone <em>Done</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Done</em>' attribute.
	 * @see #isDone()
	 * @generated
	 */
	void setDone(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.nasdanika.cdo.security.Exception" contextDataType="org.nasdanika.cdo.scheduler.SchedulerContext&lt;CR&gt;"
	 * @generated
	 */
	Diagnostic run(SchedulerContext<CR> context) throws Exception;

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Principal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' reference list.
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_Subject()
	 * @model
	 * @generated
	 */
	EList<Principal> getSubject();

	/**
	 * Returns the value of the '<em><b>Run History</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.scheduler.RunEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * History of task execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Run History</em>' containment reference list.
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_RunHistory()
	 * @model containment="true"
	 *        annotation="org.nasdanika.cdo.web.render tree-feature='false' editable='false'"
	 * @generated
	 */
	EList<RunEntry> getRunHistory();

} // SchedulerTask
