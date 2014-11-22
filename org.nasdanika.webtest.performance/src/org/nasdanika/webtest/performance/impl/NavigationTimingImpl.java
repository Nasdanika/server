/**
 */
package org.nasdanika.webtest.performance.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.webtest.performance.NavigationTiming;
import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.TimingBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Timing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getDomComplete <em>Dom Complete</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getDomContentLoadedEventEnd <em>Dom Content Loaded Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getDomContentLoadedEventStart <em>Dom Content Loaded Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getDomInteractive <em>Dom Interactive</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getDomLoading <em>Dom Loading</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getLoadEventEnd <em>Load Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getLoadEventStart <em>Load Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getNavigationStart <em>Navigation Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getUnloadEventEnd <em>Unload Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getUnloadEventStart <em>Unload Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavigationTimingImpl extends TimingBaseImpl implements NavigationTiming {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigationTimingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PerformancePackage.Literals.NAVIGATION_TIMING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDomComplete() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_COMPLETE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomComplete(long newDomComplete) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_COMPLETE, newDomComplete);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDomContentLoadedEventEnd() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomContentLoadedEventEnd(long newDomContentLoadedEventEnd) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END, newDomContentLoadedEventEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDomContentLoadedEventStart() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomContentLoadedEventStart(long newDomContentLoadedEventStart) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START, newDomContentLoadedEventStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDomInteractive() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_INTERACTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomInteractive(long newDomInteractive) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_INTERACTIVE, newDomInteractive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDomLoading() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_LOADING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomLoading(long newDomLoading) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__DOM_LOADING, newDomLoading);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLoadEventEnd() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__LOAD_EVENT_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadEventEnd(long newLoadEventEnd) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__LOAD_EVENT_END, newLoadEventEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLoadEventStart() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__LOAD_EVENT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadEventStart(long newLoadEventStart) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__LOAD_EVENT_START, newLoadEventStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getNavigationStart() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__NAVIGATION_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNavigationStart(long newNavigationStart) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__NAVIGATION_START, newNavigationStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getUnloadEventEnd() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__UNLOAD_EVENT_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnloadEventEnd(long newUnloadEventEnd) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__UNLOAD_EVENT_END, newUnloadEventEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getUnloadEventStart() {
		return (Long)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__UNLOAD_EVENT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnloadEventStart(long newUnloadEventStart) {
		eSet(PerformancePackage.Literals.NAVIGATION_TIMING__UNLOAD_EVENT_START, newUnloadEventStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TimingBase> getEntries() {
		return (EList<TimingBase>)eGet(PerformancePackage.Literals.NAVIGATION_TIMING__ENTRIES, true);
	}

} //NavigationTimingImpl
