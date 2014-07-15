package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.core.Context;

public interface CDOViewContext<V extends CDOView, CR> extends Context {

	V getView();
	
	Principal getPrincipal();
	
	ProtectionDomain<CR> getProtectionDomain();
	
	/**
	 * Authenticates user with provided credentials. 
	 * Associates user with context/session upon successfull authentication. 
	 * @param credentials
	 * @return authenticated principal if authentication was successful, or null.
	 */
	Principal authenticate(CR credentials) throws Exception;
	
}
