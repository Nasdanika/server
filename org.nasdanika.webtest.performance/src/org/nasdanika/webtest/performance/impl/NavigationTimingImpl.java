/**
 */
package org.nasdanika.webtest.performance.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.core.Context;
import org.nasdanika.html.FontAwesome.FileType;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RouteMethod;
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
		String myName = getName();
		int hashIdx = myName.indexOf("#");
		if (hashIdx!=-1) {
			myName = myName.substring(0, hashIdx);
		}
		String jName = json.getString("href");
		hashIdx = jName.indexOf("#");
		if (hashIdx!=-1) {
			jName = jName.substring(0, hashIdx);
		}
		if (!myName.equals(jName)) {
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
	public void loadJSON(JSONObject json, Context context)	throws Exception {
		super.loadJSON(json.getJSONObject("timing"), context);
		setName(json.getString("href"));
		if (json.has("entries")) {
			Object entries = json.get("entries");
			if (entries instanceof JSONArray) {
				for (int i=0; i<((JSONArray) entries).length(); ++i) {
					JSONObject entry = ((JSONArray) entries).getJSONObject(i);
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

	@RouteMethod(pattern="L?[\\d]+/resourcesTable")
	public String resourcesTable(HttpServletRequestContext context) throws Exception {
		HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
		if (!context.authorize(this, "read", null, null)) {
			return htmlFactory.alert(Style.DANGER, false, "Access Denied!").toString(); 
		}
						
		CDOLock readLock = cdoReadLock();
		if (readLock.tryLock(5, TimeUnit.SECONDS)) {
			try {
				List<ResourceTiming> rtl = new ArrayList<>();
				boolean redirect = false; 
				boolean cache = false; 
				boolean dns = false; 
				boolean connect = false; 
				boolean ssl = false; 
				boolean request = false; 
				boolean response = false; 
				for (TimingBase e: getEntries()) {
					if (e instanceof ResourceTiming) {
						ResourceTiming rt = (ResourceTiming) e;
						rtl.add(rt);
						redirect = redirect || rt.getRedirectEnd() > rt.getRedirectStart() + 0.5;
						cache = cache || rt.getDomainLookupStart() > rt.getFetchStart() + 0.5;
						dns = dns || rt.getDomainLookupEnd() > rt.getDomainLookupStart() + 0.5;
						connect = connect || rt.getConnectEnd() > rt.getConnectStart() + 0.5;
						ssl = ssl || rt.getSecureConnectionStart() > rt.getConnectStart() + 0.5;
						request = request || rt.getResponseStart() > rt.getRequestStart() + 0.5;
						response = response || rt.getResponseEnd() > rt.getResponseStart() + 0.5;
					}
				}				
				
				Table resourcesTable = htmlFactory.table().bordered();
				
				Row hRow = resourcesTable.row().style(Style.INFO);
				hRow.header("#");
				hRow.header("Name").style("text-align", "center");
				hRow.header("Initiator").style("text-align", "center");
				hRow.header("Start").style("text-align", "center");
				hRow.header("Duration").style("text-align", "center");
				if (redirect) {
					hRow.header("Redirect").style("text-align", "center");
				}
				if (cache) {
					hRow.header("Cache").style("text-align", "center");
				}
				if (dns) {
					hRow.header("DNS").style("text-align", "center");
				}
				if (connect) {
					hRow.header("Connect").style("text-align", "center");
				}
				if (ssl) {
					hRow.header("SSL").style("text-align", "center");
				}
				if (request) {
					hRow.header("Request").style("text-align", "center");
				}
				if (response) {
					hRow.header("Response").style("text-align", "center");
				}

				int counter = 0;
				for (TimingBase e: getEntries()) {
					if (e instanceof ResourceTiming) {
						ResourceTiming rt = (ResourceTiming) e;
						Row rRow = resourcesTable.row();
						rRow.cell(++counter).style("text-align", "right");
						String name = rt.getName();
						if (name.length()>70) {
							name = htmlFactory.span(StringEscapeUtils.escapeHtml4(name.substring(0, 70)+" ...")).attribute("title", StringEscapeUtils.escapeHtml4(name)).toString();
						} else {
							name = StringEscapeUtils.escapeHtml4(name);
						}
						rRow.cell(htmlFactory.routeLink(
								"main", 
								"/"+context.getObjectPath(rt)+".html", 
								name));
						
						rRow.cell(rt.getInitiatorType()).style("text-align", "center");
						positiveCell(rt.getStartTime(), rRow);
						positiveCell(rt.getDuration(), rRow);
						if (redirect) {
							positiveCell(rt.getRedirectEnd() - rt.getRedirectStart(), rRow);
						}
						if (cache) {
							positiveCell(rt.getDomainLookupStart() - rt.getFetchStart(), rRow);
						}
						if (dns) {
							positiveCell(rt.getDomainLookupEnd() - rt.getDomainLookupStart(), rRow);
						}
						if (connect) {
							positiveCell(rt.getConnectEnd() - rt.getConnectStart(), rRow);
						}
						if (ssl) {
							positiveCell(rt.getSecureConnectionStart() - rt.getConnectStart(), rRow);
						}
						if (request) {
							positiveCell(rt.getResponseStart() - rt.getRequestStart(), rRow);
						}
						if (response) {
							positiveCell(rt.getResponseEnd() - rt.getResponseStart(), rRow);
						}
					}
				}
				
				return resourcesTable.toString();
			} finally {
				readLock.unlock();
			}
		} else {
			return htmlFactory.alert(Style.WARNING, false, "The system is overloaded, please try again later.").toString(); 			
		}
	}
		
	@RouteMethod(pattern="L?[\\d]+\\.html")
	public String home(HttpServletRequestContext context) throws Exception {
		HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
		if (!context.authorize(this, "read", null, null)) {
			return htmlFactory.alert(Style.DANGER, false, "Access Denied!").toString(); 
		}
		
		Fragment content = htmlFactory.fragment(htmlFactory.tag("h3", StringEscapeUtils.escapeHtml4(getName())));		
		
		Tabs tabs = htmlFactory.tabs();
		content.content(tabs);
				
		CDOLock readLock = cdoReadLock();
		if (readLock.tryLock(5, TimeUnit.SECONDS)) {
			try {
				Table timingsTable = htmlFactory.table().bordered();
				tabs.item(htmlFactory.fontAwesome().webApplication(WebApplication.clock_o)+"&nbsp;Timings", timingsTable);
				
				Row hRow = timingsTable.row().style(Style.INFO);
				hRow.header("Interval");
				hRow.header("Time (ms)");
				
				positiveRow("<B>Redirect</B> (redirectStart ~ redirectEnd)", getRedirectStart()<getNavigationStart() ? 0 : getRedirectEnd()-getRedirectStart(), timingsTable);
				positiveRow("<B>Cache</B> (fetchStart ~ domainLookupStart)", getFetchStart()<getNavigationStart() ? 0 : getDomainLookupStart()-getFetchStart(), timingsTable);
				positiveRow("<B>DNS</B> (domainLookupStart ~ domainLookupEnd)", getDomainLookupStart()<getNavigationStart() ? 0 : getDomainLookupEnd()-getDomainLookupStart(), timingsTable);
				positiveRow("<B>Connect</B> (connectStart ~ connectEnd)", getConnectStart()<getNavigationStart() ? 0 : getConnectEnd()-getConnectStart(), timingsTable);
				positiveRow("<B>SSL</B> (connectStart ~ secureConnectionStart)", getConnectStart()<getNavigationStart() ? 0 : getSecureConnectionStart()-getConnectStart(), timingsTable);
				positiveRow("<B>Request</B> (requestStart ~ responseStart)", getRequestStart()<getNavigationStart() ? 0 : getResponseStart() - getRequestStart(), timingsTable);
				positiveRow("<B>Response</B> (responseStart ~ responseEnd)", getResponseStart()<getNavigationStart() ? 0 : getResponseEnd() - getResponseStart(), timingsTable);
				positiveRow("<B>DOM Interactive</B> (fetchStart ~ domInteractive)", getFetchStart()<getNavigationStart() ? 0 : getDomInteractive()-getFetchStart(), timingsTable);
				positiveRow("<B>DOM Complete</B> (fetchStart ~ domComplete)", getFetchStart()<getNavigationStart() ? 0 : getDomComplete()-getFetchStart(), timingsTable);
				positiveRow("<B>Loaded</B> (fetchStart ~ loadEventEnd)", getFetchStart()<getNavigationStart() ? 0 : getLoadEventEnd()-getFetchStart(), timingsTable);

				if (!getEntries().isEmpty()) {
					tabs.ajaxItem(htmlFactory.fontAwesome().fileType(FileType.file_o)+"&nbsp;Resources", context.getObjectPath(this)+"/resourcesTable");
				}				
			} finally {
				readLock.unlock();
			}
		} else {
			return htmlFactory.alert(Style.WARNING, false, "The system is overloaded, please try again later.").toString(); 			
		}
						
		return content.toString();
	}
	
	static void positiveRow(String name, double value, Table table) {
		if (value>0) {
			Row row = table.row();
			row.cell(name);
			row.cell((long) value).style("text-align", "right");
		}
	}
	
	static void positiveCell(double value, Row row) {
		row.cell(value > 1 ? (long) value : "").style("text-align", "right");
	}

} //NavigationTimingImpl
