/**
 */
package org.nasdanika.webtest.performance.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.core.ConverterContext;
import org.nasdanika.webtest.performance.DocumentTiming;
import org.nasdanika.webtest.performance.NavigationTiming;
import org.nasdanika.webtest.performance.PerformanceFactory;
import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.ResourceTiming;
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
	
	@Override
	public boolean match(JSONObject json) throws Exception {
		if (!getName().equals(json.getString("href"))) {
			return false;
		}
		return super.match(json.getJSONObject("timing"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TimingBase merge(JSONObject navigationTiming) throws Exception {
		if (match(navigationTiming)) {
			TimingBase ret = this;
			if (navigationTiming.has("entries")) {
				JSONArray entries = navigationTiming.getJSONArray("entries");
				if (entries.length()<getEntries().size()) {
					throw new IllegalStateException("Navigation timing being merged matches, but has fewer entries");
				}
				for (int i=0; i<entries.length(); ++i) {
					JSONObject entry = entries.getJSONObject(i);
					if (i<getEntries().size()) {
						// Validate that existing entries match
						ret = getEntries().get(i);
						if (!ret.match(entry)) {
							throw new IllegalArgumentException("Partial match");
						}
					} else if (entry.has("navigationStart")) {
						DocumentTiming timing = PerformanceFactory.eINSTANCE.createDocumentTiming();
						getEntries().add(timing);
						timing.loadJSON(entry, null);
					} else {
						ResourceTiming timing = PerformanceFactory.eINSTANCE.createResourceTiming();
						getEntries().add(timing);
						timing.loadJSON(entry, null);				
					}
				}
			} else if (!getEntries().isEmpty()) {
				throw new IllegalStateException("Navigation timing being merged matches, but has no entries");
			}
			
			return ret;
		}
		return null;
	}
	
	@Override
	public void loadJSON(JSONObject json, ConverterContext context)	throws Exception {
		super.loadJSON(json.getJSONObject("timing"), context);
		setName(json.getString("href"));
		JSONArray entries = json.getJSONArray("entries");
		for (int i=0; i<entries.length(); ++i) {
			JSONObject entry = entries.getJSONObject(i);
			if (entry.has("navigationStart")) {
				DocumentTiming timing = PerformanceFactory.eINSTANCE.createDocumentTiming();
				getEntries().add(timing);
				timing.loadJSON(entry, context);
			} else {
				ResourceTiming timing = PerformanceFactory.eINSTANCE.createResourceTiming();
				getEntries().add(timing);
				timing.loadJSON(entry, context);				
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PerformancePackage.NAVIGATION_TIMING___MERGE__JSONOBJECT:
			try {
				return merge((JSONObject)arguments.get(0));
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
		}
		return super.eInvoke(operationID, arguments);
	}

} //NavigationTimingImpl
