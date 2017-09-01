package org.nasdanika.cdo.web;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.AbstractCDOViewContextSubject;
import org.nasdanika.cdo.security.Principal;

/**
 * This subject keeps principal CDOID in the HTTP session and principal name in the instance.
 * @author Pavel Vlasov
 *
 * @param <V>
 * @param <CR>
 */
public class HttpSessionCDOViewContextSubject<V extends CDOView, CR> extends AbstractCDOViewContextSubject<V, CR> {
	
	private static final String PRINCIPAL_ID_KEY = Principal.class.getName()+":id";
	private static final String TIMESTAMP_KEY = HttpSessionCDOViewContextSubject.class.getName()+":timestamp";

	private HttpSession session;
	private List<String> principalNames;

	public HttpSessionCDOViewContextSubject(HttpSession session, List<String> principalNames) {			
		this.session = session;
		this.principalNames = principalNames;
	}
	
	@Override
	protected void setPrincipalIDs(List<CDOID> principalIDs) {
		session.setAttribute(PRINCIPAL_ID_KEY, principalIDs);
		session.setAttribute(TIMESTAMP_KEY, System.currentTimeMillis());
	}
	
	@Override
	public long getTimestamp() {
		Object timestamp = session.getAttribute(TIMESTAMP_KEY);
		return timestamp instanceof Long ? (long) timestamp : -1;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected List<CDOID> getPrincipalIDs() {
		Object pincipalIDs = session.getAttribute(PRINCIPAL_ID_KEY);
		return pincipalIDs instanceof List ? (List<CDOID>) pincipalIDs : Collections.emptyList();
	}
	
	@Override
	protected List<String> getPrincipalNames() {
		return principalNames;
	}

	@Override
	public String toString() {
		return "HttpSessionCDOViewContextSubject " + getPrincipalIDs() + " " + new Date(getTimestamp());
	}
		
}

