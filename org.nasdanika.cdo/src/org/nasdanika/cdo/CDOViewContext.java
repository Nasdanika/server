package org.nasdanika.cdo;

import java.util.List;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.core.Context;

public interface CDOViewContext<V extends CDOView, CR> extends Context {

	V getView();
	
	/**
	 * Returns Nasdanika CDO security principals. 
	 * @param masterContext Master or merged context, e.g. HttpContext merged with CDO View context. Master context can 
	 * be used to map a principal from the merged context (e.g. HTTP request principal) to Nasdanika CDO security principals.
	 * @return
	 */
	List<Principal> getPrincipals() throws Exception;
	
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
	 * @return authenticated principals if authentication was successful, or empty list.
	 */
	List<Principal> authenticate(CR credentials) throws Exception;
	
}
