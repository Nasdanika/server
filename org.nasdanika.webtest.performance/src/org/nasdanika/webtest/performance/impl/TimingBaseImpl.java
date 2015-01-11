/**
 */
package org.nasdanika.webtest.performance.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.core.ConverterContext;
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
	public double getConnectEnd() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__CONNECT_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectEnd(double newConnectEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__CONNECT_END, newConnectEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConnectStart() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__CONNECT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectStart(double newConnectStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__CONNECT_START, newConnectStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDomainLookupEnd() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainLookupEnd(double newDomainLookupEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_END, newDomainLookupEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDomainLookupStart() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainLookupStart(double newDomainLookupStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__DOMAIN_LOOKUP_START, newDomainLookupStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFetchStart() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__FETCH_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFetchStart(double newFetchStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__FETCH_START, newFetchStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRedirectEnd() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedirectEnd(double newRedirectEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_END, newRedirectEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRedirectStart() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedirectStart(double newRedirectStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__REDIRECT_START, newRedirectStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRequestStart() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__REQUEST_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequestStart(double newRequestStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__REQUEST_START, newRequestStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getResponseEnd() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseEnd(double newResponseEnd) {
		eSet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_END, newResponseEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getResponseStart() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseStart(double newResponseStart) {
		eSet(PerformancePackage.Literals.TIMING_BASE__RESPONSE_START, newResponseStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSecureConnectionStart() {
		return (Double)eGet(PerformancePackage.Literals.TIMING_BASE__SECURE_CONNECTION_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecureConnectionStart(double newSecureConnectionStart) {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public TimingBase next() {
		EStructuralFeature cf = eContainingFeature();
		if (cf!=null && cf.isMany()) {
			Object cfv = eContainer().eGet(cf);
			if (cfv instanceof List) {
				int idx = ((List<?>) cfv).indexOf(this);
				if (idx==-1) {
					throw new IllegalStateException("Should not happen");
				}
				if (idx==((List<?>) cfv).size()-1) {
					// Last item
					if (eContainer() instanceof TimingBase) {
						return ((TimingBase) eContainer()).next();
					}
					return null;
				}
				
				return ((List<TimingBase>) cfv).get(idx+1);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean match(JSONObject json) throws Exception {
		// reflective implementation
		for (EAttribute attr: eClass().getEAllAttributes()) {
			if (json.has(attr.getName())) {
				if (!match(attr, json)) {
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean match(EAttribute attr, JSONObject json) throws Exception {
		Object attrValue = eGet(attr);
		if (json.has(attr.getName())) {
			if (attrValue==null) {
				return false;
			}
			switch (attr.getEType().getInstanceClassName()) {
			case "boolean":
				return attrValue.equals(json.getBoolean(attr.getName()));
			case "double":
				return attrValue.equals(json.getDouble(attr.getName()));
			case "int":
				return attrValue.equals(json.getInt(attr.getName()));
			case "long":
				return attrValue.equals(json.getLong(attr.getName()));
			case "java.lang.String":
				return attrValue.equals(json.getString(attr.getName()));
			default:
				return attrValue.equals(json.get(attr.getName()));
			}
		}
		return attrValue==null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PerformancePackage.TIMING_BASE___NEXT:
				return next();
			case PerformancePackage.TIMING_BASE___MATCH__JSONOBJECT:
			try {
				return match((JSONObject)arguments.get(0));
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public void loadJSON(JSONObject json, ConverterContext context)	throws Exception {
		// Reflective implementation
		for (EAttribute attr: eClass().getEAllAttributes()) {
			set(attr, json);
		}		
	}
		
	protected void set(EAttribute attr, JSONObject json) throws JSONException {
		if (json.has(attr.getName())) {
			switch (attr.getEType().getInstanceClassName()) {
			case "boolean":
				eSet(attr, json.getBoolean(attr.getName()));
				break;
			case "double":
				eSet(attr, json.getDouble(attr.getName()));
				break;
			case "int":
				eSet(attr, json.getInt(attr.getName()));
				break;
			case "long":
				eSet(attr, json.getLong(attr.getName()));
				break;
			case "java.lang.String":
				eSet(attr, json.getString(attr.getName()));
				break;				
			default:
				eSet(attr, json.get(attr.getName()));				
			}
		}			
	}
	

} //TimingBaseImpl
