/**
 */
package org.nasdanika.webtest.performance.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.json.JSONObject;
import org.nasdanika.webtest.performance.DocumentTiming;
import org.nasdanika.webtest.performance.NavigationTiming;
import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.TimingBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Timing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getDomComplete <em>Dom Complete</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getDomContentLoadedEventEnd <em>Dom Content Loaded Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getDomContentLoadedEventStart <em>Dom Content Loaded Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getDomInteractive <em>Dom Interactive</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getDomLoading <em>Dom Loading</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getLoadEventEnd <em>Load Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getLoadEventStart <em>Load Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getNavigationStart <em>Navigation Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getUnloadEventEnd <em>Unload Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getUnloadEventStart <em>Unload Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentTimingImpl extends ResourceTimingImpl implements DocumentTiming {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TimingBase merge(JSONObject navigationTiming) {
		throw new UnsupportedOperationException("Applicable only to 'true' navigation timing");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NavigationTiming.class) {
			switch (derivedFeatureID) {
				case PerformancePackage.DOCUMENT_TIMING__DOM_COMPLETE: return PerformancePackage.NAVIGATION_TIMING__DOM_COMPLETE;
				case PerformancePackage.DOCUMENT_TIMING__DOM_CONTENT_LOADED_EVENT_END: return PerformancePackage.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END;
				case PerformancePackage.DOCUMENT_TIMING__DOM_CONTENT_LOADED_EVENT_START: return PerformancePackage.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START;
				case PerformancePackage.DOCUMENT_TIMING__DOM_INTERACTIVE: return PerformancePackage.NAVIGATION_TIMING__DOM_INTERACTIVE;
				case PerformancePackage.DOCUMENT_TIMING__DOM_LOADING: return PerformancePackage.NAVIGATION_TIMING__DOM_LOADING;
				case PerformancePackage.DOCUMENT_TIMING__LOAD_EVENT_END: return PerformancePackage.NAVIGATION_TIMING__LOAD_EVENT_END;
				case PerformancePackage.DOCUMENT_TIMING__LOAD_EVENT_START: return PerformancePackage.NAVIGATION_TIMING__LOAD_EVENT_START;
				case PerformancePackage.DOCUMENT_TIMING__NAVIGATION_START: return PerformancePackage.NAVIGATION_TIMING__NAVIGATION_START;
				case PerformancePackage.DOCUMENT_TIMING__UNLOAD_EVENT_END: return PerformancePackage.NAVIGATION_TIMING__UNLOAD_EVENT_END;
				case PerformancePackage.DOCUMENT_TIMING__UNLOAD_EVENT_START: return PerformancePackage.NAVIGATION_TIMING__UNLOAD_EVENT_START;
				case PerformancePackage.DOCUMENT_TIMING__ENTRIES: return PerformancePackage.NAVIGATION_TIMING__ENTRIES;
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
		if (baseClass == NavigationTiming.class) {
			switch (baseFeatureID) {
				case PerformancePackage.NAVIGATION_TIMING__DOM_COMPLETE: return PerformancePackage.DOCUMENT_TIMING__DOM_COMPLETE;
				case PerformancePackage.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END: return PerformancePackage.DOCUMENT_TIMING__DOM_CONTENT_LOADED_EVENT_END;
				case PerformancePackage.NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START: return PerformancePackage.DOCUMENT_TIMING__DOM_CONTENT_LOADED_EVENT_START;
				case PerformancePackage.NAVIGATION_TIMING__DOM_INTERACTIVE: return PerformancePackage.DOCUMENT_TIMING__DOM_INTERACTIVE;
				case PerformancePackage.NAVIGATION_TIMING__DOM_LOADING: return PerformancePackage.DOCUMENT_TIMING__DOM_LOADING;
				case PerformancePackage.NAVIGATION_TIMING__LOAD_EVENT_END: return PerformancePackage.DOCUMENT_TIMING__LOAD_EVENT_END;
				case PerformancePackage.NAVIGATION_TIMING__LOAD_EVENT_START: return PerformancePackage.DOCUMENT_TIMING__LOAD_EVENT_START;
				case PerformancePackage.NAVIGATION_TIMING__NAVIGATION_START: return PerformancePackage.DOCUMENT_TIMING__NAVIGATION_START;
				case PerformancePackage.NAVIGATION_TIMING__UNLOAD_EVENT_END: return PerformancePackage.DOCUMENT_TIMING__UNLOAD_EVENT_END;
				case PerformancePackage.NAVIGATION_TIMING__UNLOAD_EVENT_START: return PerformancePackage.DOCUMENT_TIMING__UNLOAD_EVENT_START;
				case PerformancePackage.NAVIGATION_TIMING__ENTRIES: return PerformancePackage.DOCUMENT_TIMING__ENTRIES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == NavigationTiming.class) {
			switch (baseOperationID) {
				case PerformancePackage.NAVIGATION_TIMING___MERGE__JSONOBJECT: return PerformancePackage.DOCUMENT_TIMING___MERGE__JSONOBJECT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PerformancePackage.DOCUMENT_TIMING___MERGE__JSONOBJECT:
				return merge((JSONObject)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //DocumentTimingImpl
