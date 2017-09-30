package org.nasdanika.cdo;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;

/**
 * Subject allows to store principal identities and pass it between contexts.
 * It also allows to bridge other security systems with the Nasdanika CDO security model,
 * e.g. map Java principals and/or (LDAP) roles to Nasdanika CDO principals by login name 
 * @author Pavel
 *
 */
public interface CDOViewContextSubject<V extends CDOView, CR> {

	List<Principal> getPrincipals(CDOViewContext<V, CR> context);
	
	void setPrincipals(CDOViewContext<V, CR> context, List<Principal> principals);
	
	/**
	 * @return Time when subject was associated with principals.
	 */
	long getTimestamp();
	
	/**
	 * Subject may configure authorization environment, e.g. add contextual entries.
	 * @param environment
	 * @return
	 */
	default Map<String, Object> configureAuthorizationEnvironment(Map<String, Object> environment) {
		return environment;
	}
	                                                 
}
