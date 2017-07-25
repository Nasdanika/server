/**
 */
package org.nasdanika.cdo.scheduler.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.StackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throwable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.ThrowableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.ThrowableImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.ThrowableImpl#getStackTrace <em>Stack Trace</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.ThrowableImpl#getSuppressed <em>Suppressed</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.ThrowableImpl#getCause <em>Cause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThrowableImpl extends CDOObjectImpl implements org.nasdanika.cdo.scheduler.Throwable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrowableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.THROWABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String)eGet(SchedulerPackage.Literals.THROWABLE__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(SchedulerPackage.Literals.THROWABLE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return (String)eGet(SchedulerPackage.Literals.THROWABLE__MESSAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		eSet(SchedulerPackage.Literals.THROWABLE__MESSAGE, newMessage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StackTraceEntry> getStackTrace() {
		return (EList<StackTraceEntry>)eGet(SchedulerPackage.Literals.THROWABLE__STACK_TRACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<org.nasdanika.cdo.scheduler.Throwable> getSuppressed() {
		return (EList<org.nasdanika.cdo.scheduler.Throwable>)eGet(SchedulerPackage.Literals.THROWABLE__SUPPRESSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.cdo.scheduler.Throwable getCause() {
		return (org.nasdanika.cdo.scheduler.Throwable)eGet(SchedulerPackage.Literals.THROWABLE__CAUSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCause(org.nasdanika.cdo.scheduler.Throwable newCause) {
		eSet(SchedulerPackage.Literals.THROWABLE__CAUSE, newCause);
	}

} //ThrowableImpl
