package org.nasdanika.cdo;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.core.Converter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.SecurityContext;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public abstract class CDOViewContextImpl<V extends CDOView, CR, MC extends Context> implements CDOViewContext<V, CR, MC>, ClassLoadingContext {
	
	private V view;
	
	private SecurityPolicyManager securityPolicyManager;

	private Converter<Object, Object, Context> converter;

	private Bundle bundle;

	public CDOViewContextImpl(Bundle bundle, SecurityPolicyManager securityPolicyManager) throws Exception {
		this.bundle = bundle;
		this.securityPolicyManager = securityPolicyManager;
		this.converter = CoreUtil.createConverter();
		view = openView();
	}

	protected abstract V openView();
	
	private Principal authenticatedPrincipal;

	@Override
	public void close() throws Exception {
		converter.close();
		view.close();
	}

	@Override
	public V getView() {
		return view;
	}

	@Override
	public Principal getPrincipal(MC masterContext) throws Exception {
		if (authenticatedPrincipal != null) {
			return authenticatedPrincipal;
		}

		authenticatedPrincipal = masterContext.adapt(Principal.class);
		if (authenticatedPrincipal != null) {
			return authenticatedPrincipal;
		}

		java.security.Principal securityPrincipal = null;
		// Mapping Java security principal to protection domain principal.
		// Principal name shall match user login.
		if (masterContext instanceof SecurityContext) {
			securityPrincipal = ((SecurityContext) masterContext).getSecurityPrincipal();
		} else {
			SecurityContext sc = masterContext.adapt(SecurityContext.class);
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
	public Principal authenticate(CR credentials) {
		ProtectionDomain<CR> pd = getProtectionDomain();
		if (pd == null) {
			return null;
		}
		authenticatedPrincipal = pd.authenticate(credentials);
		return authenticatedPrincipal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) {
		if (SecurityPolicy.class.equals(targetType)) {
			return (T) securityPolicyManager;
		}
		if (targetType.isInstance(bundle)) {
			return (T) bundle;
		}
		BundleContext bc = bundle.getBundleContext();
		if (targetType.isInstance(bc)) {
			return (T) bc;
		}
		return targetType.isInstance(this) ? (T) this : null;
	}

	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		@SuppressWarnings("unchecked")
		Principal principal = getPrincipal(context);
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

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		return (T) converter.convert(source, (Class<Object>) targetType, this);
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return bundle.loadClass(name);
	}
	
	@Override
	public Iterable<URL> getResources(String name) throws IOException {
		return Collections.<URL>list(bundle.getResources(name));
	}
	
	@Override
	public URL getResource(String name) {
		return bundle.getResource(name);
	}
}
