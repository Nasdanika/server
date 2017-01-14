package org.nasdanika.cdo;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.Context;

public class CDOViewContextAuthorizationProvider implements	AuthorizationProvider {

	@Override
	public AccessDecision authorize(
			Context context, 
			Object target, 
			String action, 
			String qualifier, 
			Map<String, Object> environment) throws Exception {
		
		if (context instanceof CDOViewContext) {
			Principal principal = ((CDOViewContext<?,?>) context).getPrincipal();
			if (principal!=null && target instanceof EObject) {
				// TODO - cache CDOID,action -> AccessDecision in session.
				try {
					return principal.authorize(context, (EObject) target, action, qualifier, environment);
				} catch (Exception e) {
					e.printStackTrace();
					return AccessDecision.DENY; // To be on the safe side.
				}
			}
		}
		return AccessDecision.ABSTAIN;
	}

}