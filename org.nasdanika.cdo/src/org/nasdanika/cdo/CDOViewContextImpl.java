package org.nasdanika.cdo;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.Adaptable;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.nasdanika.core.Converter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.SecurityContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public abstract class CDOViewContextImpl<V extends CDOView, CR, MC> extends ContextImpl implements CDOViewContext<V, CR>, ClassLoadingContext {
	
	private V view;
	
	private SecurityPolicyManager securityPolicyManager;

	private Converter<Object, Object, Context> converter;

	private Bundle bundle;

	private MC masterContext;

	private boolean deny;

	/**
	 * 
	 * @param bundle
	 * @param securityPolicyManager
	 * @param masterContext
	 * @param deny If true then default authorization action is DENY (high security).
	 * @throws Exception
	 */
	public CDOViewContextImpl(
			Bundle bundle, 
			SecurityPolicyManager securityPolicyManager,
			MC masterContext,
			boolean deny) throws Exception {
		this.bundle = bundle;
		this.securityPolicyManager = securityPolicyManager;
		this.masterContext = masterContext;
		this.converter = CoreUtil.createConverter();
		view = openView();
		this.deny = deny;
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
	public Principal getPrincipal() throws Exception {
		if (authenticatedPrincipal != null) {
			return authenticatedPrincipal;
		}

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
		if (masterContext instanceof SecurityContext) {
			securityPrincipal = ((SecurityContext) masterContext).getSecurityPrincipal();
		} else {
			SecurityContext sc = null;
			if (masterContext instanceof SecurityContext) {
				sc = (SecurityContext) masterContext;
			} else if (masterContext instanceof Adaptable) {				
				sc = ((Adaptable) masterContext).adapt(SecurityContext.class);
			}
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
	public <T> T adapt(Class<T> targetType) throws Exception {
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
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		Principal principal = getPrincipal();
		if (principal!=null) {
			SecurityPolicy sp = adapt(SecurityPolicy.class);
			if (sp!=null) {
				AccessDecision.ALLOW.equals(principal.authorize(sp, this, target, action, qualifier, environment));
			}
		}
		return !deny;
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
