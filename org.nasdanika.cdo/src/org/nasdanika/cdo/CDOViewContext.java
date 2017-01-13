package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.core.Context;

public interface CDOViewContext<V extends CDOView, CR> extends Context {

	V getView();
	
	/**
	 * Returns CDO principal. 
	 * @param masterContext Master or merged context, e.g. HttpContext merged with CDO View context. Master context can 
	 * be used to map a principal from the merged context (e.g. HTTP request principal) to CDO principal.
	 * @return
	 */
	Principal getPrincipal() throws Exception;
	
	/**
	 * Subject holds principal identity and can be used to obtain the principal from the context.
	 * @return
	 */
	CDOViewContextSubject<V,CR> getSubject() throws Exception;
	
	Realm<CR> getSecurityRealm();
	
	/**
	 * Authenticates user with provided credentials. 
	 * Associates user with context/session upon successfull authentication. 
	 * @param credentials
	 * @return authenticated principal if authentication was successful, or null.
	 */
	Principal authenticate(CR credentials) throws Exception;
	
}
