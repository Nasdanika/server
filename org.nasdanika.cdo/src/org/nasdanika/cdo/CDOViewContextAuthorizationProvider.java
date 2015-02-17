package org.nasdanika.cdo;

import java.util.Map;

import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.SecurityPolicy;
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
			@SuppressWarnings("unchecked")
			Principal principal = ((CDOViewContext<?,?,Context>) context).getPrincipal(context);
			if (principal!=null) {
				// TODO - cache CDOID,action -> AccessDecision in session.
				try {
					SecurityPolicy sp = context.adapt(SecurityPolicy.class);
					return sp==null ? AccessDecision.ABSTAIN : principal.authorize(sp, context, target, action, qualifier, environment);
				} catch (Exception e) {
					e.printStackTrace();
					return AccessDecision.DENY; // To be on the safe side.
				}
			}
		}
		return AccessDecision.ABSTAIN;
	}

}
