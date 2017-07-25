/**
 */
package org.nasdanika.cdo.scheduler.impl;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.cdo.scheduler.RunEntry;
import org.nasdanika.cdo.scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.RunEntryImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.RunEntryImpl#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RunEntryImpl extends DiagnosticImpl implements RunEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.RUN_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDuration() {
		return (Long)eGet(SchedulerPackage.Literals.RUN_ENTRY__DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(long newDuration) {
		eSet(SchedulerPackage.Literals.RUN_ENTRY__DURATION, newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.cdo.scheduler.Throwable getException() {
		return (org.nasdanika.cdo.scheduler.Throwable)eGet(SchedulerPackage.Literals.RUN_ENTRY__EXCEPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(org.nasdanika.cdo.scheduler.Throwable newException) {
		eSet(SchedulerPackage.Literals.RUN_ENTRY__EXCEPTION, newException);
	}

} //RunEntryImpl
