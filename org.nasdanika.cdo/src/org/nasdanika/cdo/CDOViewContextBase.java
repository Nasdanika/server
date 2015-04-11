package org.nasdanika.cdo;

import java.util.Map;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.Adaptable;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.ContextImpl;
import org.nasdanika.core.SecurityContext;

public abstract class CDOViewContextBase<V extends CDOView, CR, MC> extends ContextImpl implements CDOViewContext<V, CR>, ClassLoadingContext {
	
	protected abstract MC getMasterContext();
	
	protected abstract AuthorizationProvider.AccessDecision getDefaultAccessDecision();
	
	private Principal authenticatedPrincipal;

	@Override
	public final Principal getPrincipal() throws Exception {
		if (authenticatedPrincipal != null) {
			return authenticatedPrincipal;
		}

		MC masterContext = getMasterContext();
		
		if (masterContext instanceof Principal) {
			authenticatedPrincipal = (Principal) masterContext;
			if (authenticatedPrincipal != null) {
				return authenticatedPrincipal;
			}
		}

		if (masterContext instanceof Adaptable) {
			authenticatedPrincipal = ((Adaptable) masterContext).adapt(Principal.class);
			if (authenticatedPrincipal != null) {
				return authenticatedPrincipal;
			}
		}

		java.security.Principal securityPrincipal = null;
		// Mapping Java security principal to protection domain principal.
		// Principal name shall match user login.
		if (masterContext instanceof java.security.Principal) {
			securityPrincipal = (java.security.Principal) masterContext;
		} else if (masterContext instanceof SecurityContext) {
			securityPrincipal = ((SecurityContext) masterContext).getSecurityPrincipal();
		} else if (masterContext instanceof Adaptable) {
			SecurityContext sc = ((Adaptable) masterContext).adapt(SecurityContext.class);
			if (sc != null) {
				securityPrincipal = sc.getSecurityPrincipal();
			}
		}

		if (securityPrincipal != null) {
			for (User pdu : getProtectionDomain().getAllUsers()) { 
				// TODO - find(login) to optimize search in large user populations
				if (pdu instanceof LoginUser && ((LoginUser) pdu).getLogin().equalsIgnoreCase(securityPrincipal.getName())) {
					if (((LoginUser) pdu).isDisabled() || (pdu instanceof LoginPasswordHashUser && ((LoginPasswordHashUser) pdu).getPasswordHash() != null)) {
						break;
					} else {
						return pdu;
					}
				}
			}
		}
		ProtectionDomain<CR> pd = getProtectionDomain();
		return pd == null ? null : pd.getUnauthenticatedPrincipal();
	}

	@Override
	public final Principal authenticate(CR credentials) throws Exception {
		ProtectionDomain<CR> pd = getProtectionDomain();
		if (pd == null) {
			return null;
		}
		authenticatedPrincipal = pd.authenticate(credentials);
		return authenticatedPrincipal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		MC masterContext = getMasterContext();
		
		if (targetType.isInstance(masterContext)) {
			return (T) masterContext;
		}
		
		if (masterContext instanceof Adaptable) {
			T ret = ((Adaptable) masterContext).adapt(targetType);
			if (ret!=null) {
				return ret;
			}
		}
		
		return super.adapt(targetType);
	}

	@Override
	public final boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		Principal principal = getPrincipal();
		if (principal!=null) {
			SecurityPolicy sp = adapt(SecurityPolicy.class);
			if (sp!=null) {
				AccessDecision.ALLOW.equals(principal.authorize(sp, this, target, action, qualifier, environment));
			}
		}
		return AccessDecision.ALLOW.equals(getDefaultAccessDecision());
	}

}
