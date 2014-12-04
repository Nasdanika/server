/**
 */
package org.nasdanika.webtest.performance;

import java.lang.Exception;
import org.eclipse.emf.common.util.EList;
import org.json.JSONObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Timing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getDomComplete <em>Dom Complete</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventEnd <em>Dom Content Loaded Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventStart <em>Dom Content Loaded Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getDomInteractive <em>Dom Interactive</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getDomLoading <em>Dom Loading</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getLoadEventEnd <em>Load Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getLoadEventStart <em>Load Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getNavigationStart <em>Navigation Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventEnd <em>Unload Event End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventStart <em>Unload Event Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.NavigationTiming#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming()
 * @model
 * @generated
 */
public interface NavigationTiming extends TimingBase {
	/**
	 * Returns the value of the '<em><b>Dom Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dom Complete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dom Complete</em>' attribute.
	 * @see #setDomComplete(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_DomComplete()
	 * @model
	 * @generated
	 */
	long getDomComplete();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomComplete <em>Dom Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dom Complete</em>' attribute.
	 * @see #getDomComplete()
	 * @generated
	 */
	void setDomComplete(long value);

	/**
	 * Returns the value of the '<em><b>Dom Content Loaded Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dom Content Loaded Event End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dom Content Loaded Event End</em>' attribute.
	 * @see #setDomContentLoadedEventEnd(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_DomContentLoadedEventEnd()
	 * @model
	 * @generated
	 */
	long getDomContentLoadedEventEnd();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventEnd <em>Dom Content Loaded Event End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dom Content Loaded Event End</em>' attribute.
	 * @see #getDomContentLoadedEventEnd()
	 * @generated
	 */
	void setDomContentLoadedEventEnd(long value);

	/**
	 * Returns the value of the '<em><b>Dom Content Loaded Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dom Content Loaded Event Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dom Content Loaded Event Start</em>' attribute.
	 * @see #setDomContentLoadedEventStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_DomContentLoadedEventStart()
	 * @model
	 * @generated
	 */
	long getDomContentLoadedEventStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventStart <em>Dom Content Loaded Event Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dom Content Loaded Event Start</em>' attribute.
	 * @see #getDomContentLoadedEventStart()
	 * @generated
	 */
	void setDomContentLoadedEventStart(long value);

	/**
	 * Returns the value of the '<em><b>Dom Interactive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dom Interactive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dom Interactive</em>' attribute.
	 * @see #setDomInteractive(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_DomInteractive()
	 * @model
	 * @generated
	 */
	long getDomInteractive();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomInteractive <em>Dom Interactive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dom Interactive</em>' attribute.
	 * @see #getDomInteractive()
	 * @generated
	 */
	void setDomInteractive(long value);

	/**
	 * Returns the value of the '<em><b>Dom Loading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dom Loading</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dom Loading</em>' attribute.
	 * @see #setDomLoading(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_DomLoading()
	 * @model
	 * @generated
	 */
	long getDomLoading();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomLoading <em>Dom Loading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dom Loading</em>' attribute.
	 * @see #getDomLoading()
	 * @generated
	 */
	void setDomLoading(long value);

	/**
	 * Returns the value of the '<em><b>Load Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Event End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Event End</em>' attribute.
	 * @see #setLoadEventEnd(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_LoadEventEnd()
	 * @model
	 * @generated
	 */
	long getLoadEventEnd();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getLoadEventEnd <em>Load Event End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Event End</em>' attribute.
	 * @see #getLoadEventEnd()
	 * @generated
	 */
	void setLoadEventEnd(long value);

	/**
	 * Returns the value of the '<em><b>Load Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Event Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Event Start</em>' attribute.
	 * @see #setLoadEventStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_LoadEventStart()
	 * @model
	 * @generated
	 */
	long getLoadEventStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getLoadEventStart <em>Load Event Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Event Start</em>' attribute.
	 * @see #getLoadEventStart()
	 * @generated
	 */
	void setLoadEventStart(long value);

	/**
	 * Returns the value of the '<em><b>Navigation Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigation Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigation Start</em>' attribute.
	 * @see #setNavigationStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_NavigationStart()
	 * @model
	 * @generated
	 */
	long getNavigationStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getNavigationStart <em>Navigation Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigation Start</em>' attribute.
	 * @see #getNavigationStart()
	 * @generated
	 */
	void setNavigationStart(long value);

	/**
	 * Returns the value of the '<em><b>Unload Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unload Event End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unload Event End</em>' attribute.
	 * @see #setUnloadEventEnd(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_UnloadEventEnd()
	 * @model
	 * @generated
	 */
	long getUnloadEventEnd();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventEnd <em>Unload Event End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unload Event End</em>' attribute.
	 * @see #getUnloadEventEnd()
	 * @generated
	 */
	void setUnloadEventEnd(long value);

	/**
	 * Returns the value of the '<em><b>Unload Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unload Event Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unload Event Start</em>' attribute.
	 * @see #setUnloadEventStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_UnloadEventStart()
	 * @model
	 * @generated
	 */
	long getUnloadEventStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventStart <em>Unload Event Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unload Event Start</em>' attribute.
	 * @see #getUnloadEventStart()
	 * @generated
	 */
	void setUnloadEventStart(long value);

	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.performance.TimingBase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getNavigationTiming_Entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<TimingBase> getEntries();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model navigationTimingDataType="org.nasdanika.webtest.performance.JSONObject"
	 * @generated
	 */
	TimingBase merge(JSONObject navigationTiming) throws Exception;

} // NavigationTiming
