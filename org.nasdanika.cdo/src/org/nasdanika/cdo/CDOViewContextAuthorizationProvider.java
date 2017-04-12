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
			if (target instanceof EObject) {
				for (Principal principal: ((CDOViewContext<?,?>) context).getPrincipals()) {
					AccessDecision ad = principal.authorize(context, (EObject) target, action, qualifier, environment);
					if (ad != AccessDecision.ABSTAIN) {
						return ad;
					}
				}
			}
		}
		return AccessDecision.ABSTAIN;
	}

}