package org.nasdanika.cdo.web;

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

	private HttpSession session;
	private String principalName;

	public HttpSessionCDOViewContextSubject(HttpSession session, String principalName) {			
		this.session = session;
		this.principalName = principalName;
	}
	
	protected void setPrincipalID(CDOID cdoID) {
		if (cdoID==null) {
			session.removeAttribute(PRINCIPAL_ID_KEY);		
		} else {
			session.setAttribute(PRINCIPAL_ID_KEY, cdoID);
		}
	}

	protected CDOID getPrincipalID() {
		return (CDOID) session.getAttribute(PRINCIPAL_ID_KEY);
	}
	
	@Override
	protected String getPrincipalName() {
		return principalName;
	}
		
}

