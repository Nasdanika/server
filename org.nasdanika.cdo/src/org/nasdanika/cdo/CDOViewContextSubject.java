package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;

/**
 * Subject allows to store the Principal identity and pass it between contexts.
 * It also allows to bridge other security systems with the Nasdanika CDO security model,
 * e.g. map Java principals to Nasdanika principals by login name. 
 * @author Pavel
 *
 */
public interface CDOViewContextSubject<V extends CDOView, CR> {

	Principal getPrincipal(CDOViewContext<V, CR> context);
	
	void setPrincipal(CDOViewContext<V, CR> context, Principal principal);
	                                                 
}
