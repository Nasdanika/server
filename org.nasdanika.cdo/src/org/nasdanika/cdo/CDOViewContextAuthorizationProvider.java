package org.nasdanika.cdo;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.Context;

public class CDOViewContextAuthorizationProvider implements	AuthorizationProvider {

	@Override
	public AccessDecision authorize(Context context, Object target,	String action, String qualifier, Map<String, Object> environment) {
		if (context instanceof CDOViewContext && target instanceof EObject) {
			Principal principal = ((CDOViewContext<?,?>) context).getPrincipal();
			if (principal!=null) {
				// TODO - cache CDOID,action -> AccessDecision in session.
				return principal.authorize(context, (EObject) target, action, qualifier, environment);
			}
		}
		return AccessDecision.ABSTAIN;
	}

}
