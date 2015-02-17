package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.core.Context;

public interface CDOViewContext<V extends CDOView, CR, MC extends Context> extends Context {

	V getView();
	
	/**
	 * Returns CDO principal. 
	 * @param masterContext Master or merged context, e.g. HttpContext merged with CDO View context. Master context can 
	 * be used to map a principal from the merged context (e.g. HTTP request principal) to CDO principal.
	 * @return
	 */
	Principal getPrincipal(MC masterContext) throws Exception;
	
	ProtectionDomain<CR> getProtectionDomain();
	
	/**
	 * Authenticates user with provided credentials. 
	 * Associates user with context/session upon successfull authentication. 
	 * @param credentials
	 * @return authenticated principal if authentication was successful, or null.
	 */
	Principal authenticate(CR credentials) throws Exception;
	
}
