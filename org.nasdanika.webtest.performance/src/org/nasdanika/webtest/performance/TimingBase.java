/**
 */
package org.nasdanika.webtest.performance;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timing Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getConnectEnd <em>Connect End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getConnectStart <em>Connect Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getDomainLookupEnd <em>Domain Lookup End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getDomainLookupStart <em>Domain Lookup Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getFetchStart <em>Fetch Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getRedirectEnd <em>Redirect End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getRedirectStart <em>Redirect Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getRequestStart <em>Request Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getResponseEnd <em>Response End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getResponseStart <em>Response Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getSecureConnectionStart <em>Secure Connection Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.TimingBase#getRedirectCount <em>Redirect Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface TimingBase extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Connect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connect End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connect End</em>' attribute.
	 * @see #setConnectEnd(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_ConnectEnd()
	 * @model
	 * @generated
	 */
	long getConnectEnd();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getConnectEnd <em>Connect End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connect End</em>' attribute.
	 * @see #getConnectEnd()
	 * @generated
	 */
	void setConnectEnd(long value);

	/**
	 * Returns the value of the '<em><b>Connect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connect Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connect Start</em>' attribute.
	 * @see #setConnectStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_ConnectStart()
	 * @model
	 * @generated
	 */
	long getConnectStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getConnectStart <em>Connect Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connect Start</em>' attribute.
	 * @see #getConnectStart()
	 * @generated
	 */
	void setConnectStart(long value);

	/**
	 * Returns the value of the '<em><b>Domain Lookup End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Lookup End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Lookup End</em>' attribute.
	 * @see #setDomainLookupEnd(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_DomainLookupEnd()
	 * @model
	 * @generated
	 */
	long getDomainLookupEnd();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getDomainLookupEnd <em>Domain Lookup End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Lookup End</em>' attribute.
	 * @see #getDomainLookupEnd()
	 * @generated
	 */
	void setDomainLookupEnd(long value);

	/**
	 * Returns the value of the '<em><b>Domain Lookup Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Lookup Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Lookup Start</em>' attribute.
	 * @see #setDomainLookupStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_DomainLookupStart()
	 * @model
	 * @generated
	 */
	long getDomainLookupStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getDomainLookupStart <em>Domain Lookup Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Lookup Start</em>' attribute.
	 * @see #getDomainLookupStart()
	 * @generated
	 */
	void setDomainLookupStart(long value);

	/**
	 * Returns the value of the '<em><b>Fetch Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fetch Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fetch Start</em>' attribute.
	 * @see #setFetchStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_FetchStart()
	 * @model
	 * @generated
	 */
	long getFetchStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getFetchStart <em>Fetch Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fetch Start</em>' attribute.
	 * @see #getFetchStart()
	 * @generated
	 */
	void setFetchStart(long value);

	/**
	 * Returns the value of the '<em><b>Redirect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redirect End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redirect End</em>' attribute.
	 * @see #setRedirectEnd(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_RedirectEnd()
	 * @model
	 * @generated
	 */
	long getRedirectEnd();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getRedirectEnd <em>Redirect End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redirect End</em>' attribute.
	 * @see #getRedirectEnd()
	 * @generated
	 */
	void setRedirectEnd(long value);

	/**
	 * Returns the value of the '<em><b>Redirect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redirect Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redirect Start</em>' attribute.
	 * @see #setRedirectStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_RedirectStart()
	 * @model
	 * @generated
	 */
	long getRedirectStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getRedirectStart <em>Redirect Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redirect Start</em>' attribute.
	 * @see #getRedirectStart()
	 * @generated
	 */
	void setRedirectStart(long value);

	/**
	 * Returns the value of the '<em><b>Request Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Request Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request Start</em>' attribute.
	 * @see #setRequestStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_RequestStart()
	 * @model
	 * @generated
	 */
	long getRequestStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getRequestStart <em>Request Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request Start</em>' attribute.
	 * @see #getRequestStart()
	 * @generated
	 */
	void setRequestStart(long value);

	/**
	 * Returns the value of the '<em><b>Response End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response End</em>' attribute.
	 * @see #setResponseEnd(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_ResponseEnd()
	 * @model
	 * @generated
	 */
	long getResponseEnd();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getResponseEnd <em>Response End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response End</em>' attribute.
	 * @see #getResponseEnd()
	 * @generated
	 */
	void setResponseEnd(long value);

	/**
	 * Returns the value of the '<em><b>Response Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Start</em>' attribute.
	 * @see #setResponseStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_ResponseStart()
	 * @model
	 * @generated
	 */
	long getResponseStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getResponseStart <em>Response Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Start</em>' attribute.
	 * @see #getResponseStart()
	 * @generated
	 */
	void setResponseStart(long value);

	/**
	 * Returns the value of the '<em><b>Secure Connection Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secure Connection Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secure Connection Start</em>' attribute.
	 * @see #setSecureConnectionStart(long)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_SecureConnectionStart()
	 * @model
	 * @generated
	 */
	long getSecureConnectionStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getSecureConnectionStart <em>Secure Connection Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Connection Start</em>' attribute.
	 * @see #getSecureConnectionStart()
	 * @generated
	 */
	void setSecureConnectionStart(long value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Redirect Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redirect Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redirect Count</em>' attribute.
	 * @see #setRedirectCount(int)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getTimingBase_RedirectCount()
	 * @model
	 * @generated
	 */
	int getRedirectCount();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.TimingBase#getRedirectCount <em>Redirect Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redirect Count</em>' attribute.
	 * @see #getRedirectCount()
	 * @generated
	 */
	void setRedirectCount(int value);

} // TimingBase
