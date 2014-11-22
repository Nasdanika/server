/**
 */
package org.nasdanika.webtest.performance.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.ResourceTiming;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Timing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.impl.ResourceTimingImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.ResourceTimingImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.ResourceTimingImpl#getEntryType <em>Entry Type</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.ResourceTimingImpl#getInitiatorType <em>Initiator Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceTimingImpl extends TimingBaseImpl implements ResourceTiming {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceTimingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PerformancePackage.Literals.RESOURCE_TIMING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDuration() {
		return (Double)eGet(PerformancePackage.Literals.RESOURCE_TIMING__DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(double newDuration) {
		eSet(PerformancePackage.Literals.RESOURCE_TIMING__DURATION, newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStartTime() {
		return (Double)eGet(PerformancePackage.Literals.RESOURCE_TIMING__START_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(double newStartTime) {
		eSet(PerformancePackage.Literals.RESOURCE_TIMING__START_TIME, newStartTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryType() {
		return (String)eGet(PerformancePackage.Literals.RESOURCE_TIMING__ENTRY_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryType(String newEntryType) {
		eSet(PerformancePackage.Literals.RESOURCE_TIMING__ENTRY_TYPE, newEntryType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitiatorType() {
		return (String)eGet(PerformancePackage.Literals.RESOURCE_TIMING__INITIATOR_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiatorType(String newInitiatorType) {
		eSet(PerformancePackage.Literals.RESOURCE_TIMING__INITIATOR_TYPE, newInitiatorType);
	}

} //ResourceTimingImpl
