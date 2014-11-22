/**
 */
package org.nasdanika.webtest.performance.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.webtest.performance.DocumentTiming;
import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.ResourceTiming;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Timing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getEntryType <em>Entry Type</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getInitiatorType <em>Initiator Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentTimingImpl extends NavigationTimingImpl implements DocumentTiming {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentTimingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PerformancePackage.Literals.DOCUMENT_TIMING;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceTiming.class) {
			switch (derivedFeatureID) {
				case PerformancePackage.DOCUMENT_TIMING__DURATION: return PerformancePackage.RESOURCE_TIMING__DURATION;
				case PerformancePackage.DOCUMENT_TIMING__START_TIME: return PerformancePackage.RESOURCE_TIMING__START_TIME;
				case PerformancePackage.DOCUMENT_TIMING__ENTRY_TYPE: return PerformancePackage.RESOURCE_TIMING__ENTRY_TYPE;
				case PerformancePackage.DOCUMENT_TIMING__INITIATOR_TYPE: return PerformancePackage.RESOURCE_TIMING__INITIATOR_TYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceTiming.class) {
			switch (baseFeatureID) {
				case PerformancePackage.RESOURCE_TIMING__DURATION: return PerformancePackage.DOCUMENT_TIMING__DURATION;
				case PerformancePackage.RESOURCE_TIMING__START_TIME: return PerformancePackage.DOCUMENT_TIMING__START_TIME;
				case PerformancePackage.RESOURCE_TIMING__ENTRY_TYPE: return PerformancePackage.DOCUMENT_TIMING__ENTRY_TYPE;
				case PerformancePackage.RESOURCE_TIMING__INITIATOR_TYPE: return PerformancePackage.DOCUMENT_TIMING__INITIATOR_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //DocumentTimingImpl
