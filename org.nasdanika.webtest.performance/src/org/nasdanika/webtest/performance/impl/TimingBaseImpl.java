/**
 */
package org.nasdanika.webtest.performance.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.TimingBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timing Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getConnectEnd <em>Connect End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getConnectStart <em>Connect Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getDomainLookupEnd <em>Domain Lookup End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getDomainLookupStart <em>Domain Lookup Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getFetchStart <em>Fetch Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getRedirectEnd <em>Redirect End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getRedirectStart <em>Redirect Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getRequestStart <em>Request Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getResponseEnd <em>Response End</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getResponseStart <em>Response Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getSecureConnectionStart <em>Secure Connection Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl#getRedirectCount <em>Redirect Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimingBaseImpl extends CDOObjectImpl implements TimingBase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimingBaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PerformancePackage.Literals.TIMING_BASE;
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
	public long getConnectEnd() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__CONNECT_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectEnd(long newConnectEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__CONNECT_END, newConnectEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getConnectStart() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__CONNECT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectStart(long newConnectStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__CONNECT_START, newConnectStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDomainLookupEnd() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainLookupEnd(long newDomainLookupEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_END, newDomainLookupEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDomainLookupStart() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainLookupStart(long newDomainLookupStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_START, newDomainLookupStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getFetchStart() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__FETCH_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFetchStart(long newFetchStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__FETCH_START, newFetchStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRedirectEnd() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedirectEnd(long newRedirectEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_END, newRedirectEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRedirectStart() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedirectStart(long newRedirectStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_START, newRedirectStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRequestStart() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__REQUEST_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequestStart(long newRequestStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__REQUEST_START, newRequestStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getResponseEnd() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseEnd(long newResponseEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_END, newResponseEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getResponseStart() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseStart(long newResponseStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_START, newResponseStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSecureConnectionStart() {
		return (Long)eGet(PerformancePackage.Literals.TIMING_BASE__SECURE_CONNECTION_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecureConnectionStart(long newSecureConnectionStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__SECURE_CONNECTION_START, newSecureConnectionStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(PerformancePackage.Literals.TIMING_BASE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(PerformancePackage.Literals.TIMING_BASE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRedirectCount() {
		return (Integer)eGet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedirectCount(int newRedirectCount) {
		eSet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_COUNT, newRedirectCount);
	}

} //TimingBaseImpl
