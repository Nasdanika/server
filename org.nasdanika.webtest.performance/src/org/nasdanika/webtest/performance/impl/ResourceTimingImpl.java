
/**
 */
package org.nasdanika.webtest.performance.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RouteMethod;
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
	
	@RouteMethod(pattern="L?[\\d]+\\.html")
	public String home(HttpServletRequestContext context) throws Exception {
		HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
		if (!context.authorize(this, "read", null, null)) {
			return htmlFactory.alert(Bootstrap.Style.DANGER, false, "Access Denied!").toString(); 
		}
		
		Fragment content = htmlFactory.fragment(htmlFactory.tag("h3", StringEscapeUtils.escapeHtml4(getName())));	
		content.content("Initiator: "+getInitiatorType());
				
		CDOLock readLock = cdoReadLock();
		if (readLock.tryLock(5, TimeUnit.SECONDS)) {
			try {
				Table timingsTable = htmlFactory.table().bordered();
				content.content(timingsTable);
				
				Row hRow = timingsTable.row().style(Bootstrap.Style.INFO);
				hRow.header("Interval");
				hRow.header("Time (ms)");
				
				NavigationTimingImpl.positiveRow("<B>Start</B>", getStartTime(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>Duration</B>", getDuration(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>Redirect</B> (redirectStart ~ redirectEnd)", getRedirectStart()<getStartTime() ? 0 : getRedirectEnd()-getRedirectStart(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>Cache</B> (fetchStart ~ domainLookupStart)", getFetchStart()<getStartTime() ? 0 : getDomainLookupStart()-getFetchStart(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>DNS</B> (domainLookupStart ~ domainLookupEnd)", getDomainLookupStart()<getStartTime() ? 0 : getDomainLookupEnd()-getDomainLookupStart(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>Connect</B> (connectStart ~ connectEnd)", getConnectStart()<getStartTime() ? 0 : getConnectEnd()-getConnectStart(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>SSL</B> (connectStart ~ secureConnectionStart)", getSecureConnectionStart()<getStartTime() ? 0 : getSecureConnectionStart()-getConnectStart(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>Request</B> (requestStart ~ responseStart)", getRequestStart()<getStartTime() ? 0 : getResponseStart() - getRequestStart(), timingsTable);
				NavigationTimingImpl.positiveRow("<B>Response</B> (responseStart ~ responseEnd)", getResponseStart()<getStartTime() ? 0 : getResponseEnd() - getResponseStart(), timingsTable);
			} finally {
				readLock.unlock();
			}
		} else {
			return htmlFactory.alert(Bootstrap.Style.WARNING, false, "The system is overloaded, please try again later.").toString(); 			
		}
						
		return content.toString();
	}
	

} //ResourceTimingImpl
