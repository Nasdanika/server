/**
 */
package org.nasdanika.cdo.scheduler;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Principal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAt <em>Run At</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#isFixedRate <em>Fixed Rate</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAs <em>Run As</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface SchedulerTask extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(EObject)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_Target()
	 * @model containment="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>Run At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run At</em>' attribute.
	 * @see #setRunAt(long)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_RunAt()
	 * @model
	 * @generated
	 */
	long getRunAt();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAt <em>Run At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run At</em>' attribute.
	 * @see #getRunAt()
	 * @generated
	 */
	void setRunAt(long value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(Long)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_Period()
	 * @model
	 * @generated
	 */
	Long getPeriod();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(Long value);

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
	 * Returns the value of the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run As</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run As</em>' reference.
	 * @see #setRunAs(Principal)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getSchedulerTask_RunAs()
	 * @model
	 * @generated
	 */
	Principal getRunAs();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAs <em>Run As</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run As</em>' reference.
	 * @see #getRunAs()
	 * @generated
	 */
	void setRunAs(Principal value);

} // SchedulerTask
