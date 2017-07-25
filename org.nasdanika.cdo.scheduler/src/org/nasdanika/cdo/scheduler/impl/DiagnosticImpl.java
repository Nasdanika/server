/**
 */
package org.nasdanika.cdo.scheduler.impl;

import java.util.Date;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.scheduler.Diagnostic;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.Status;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagnostic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.DiagnosticImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.DiagnosticImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.DiagnosticImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.DiagnosticImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagnosticImpl extends CDOObjectImpl implements Diagnostic {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.DIAGNOSTIC;
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
	public Status getStatus() {
		return (Status)eGet(SchedulerPackage.Literals.DIAGNOSTIC__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(Status newStatus) {
		eSet(SchedulerPackage.Literals.DIAGNOSTIC__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return (String)eGet(SchedulerPackage.Literals.DIAGNOSTIC__MESSAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		eSet(SchedulerPackage.Literals.DIAGNOSTIC__MESSAGE, newMessage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Diagnostic> getChildren() {
		return (EList<Diagnostic>)eGet(SchedulerPackage.Literals.DIAGNOSTIC__CHILDREN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getTime() {
		return (Date)eGet(SchedulerPackage.Literals.DIAGNOSTIC__TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(Date newTime) {
		eSet(SchedulerPackage.Literals.DIAGNOSTIC__TIME, newTime);
	}

} //DiagnosticImpl
