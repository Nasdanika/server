package org.nasdanika.core;

import java.security.Principal;

/**
 * Context for bridging Java and NFS/CDO security.
 * @author Pavel
 *
 */
public interface SecurityContext extends Context {
	
	Principal getSecurityPrincipal();

}
