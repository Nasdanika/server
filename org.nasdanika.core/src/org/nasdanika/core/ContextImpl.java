package org.nasdanika.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.osgi.framework.BundleContext;

/**
 * Simple implementation of context
 * @author Pavel
 *
 */
public class ContextImpl implements Context {
	
	private BundleContext bundleContext;
	private Context[] chain;
	private AccessDecision defaultAccessDecision = AccessDecision.ALLOW;

	public ContextImpl(BundleContext bundleContext, Context... chain) {
		this.bundleContext = bundleContext;
		this.chain = chain;
		if (chain == null) {
			System.out.print("SHIT");
		}
	}
	
	public AccessDecision getDefaultAccessDecision() {
		return defaultAccessDecision;
	}
	
	public void setDefaultAccessDecision(AccessDecision defaultAccessDecision) {
		this.defaultAccessDecision = defaultAccessDecision;
	}
	
	private AdapterManager adapterManager;
	private AuthorizationProvider authorizationProvider;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		if (targetType.isInstance(this)) {
			return (T) this;
		}
		
		for (Context ch: chain) {
			if (ch!=null) {
				if (targetType.isInstance(ch)) {
					return (T) ch;
				}
				T ret = ch.adapt(targetType);
				if (ret!=null) {
					return ret;
				}
			}
		}
		
		synchronized (this) {
			if (adapterManager==null) {
				adapterManager = new AdapterManager(this, bundleContext, null);
			}
		}
		
		return adapterManager.adapt(targetType);
	}
	
	private static final String SECURITY_ID = "org.nasdanika.core.security";
	
	public synchronized AuthorizationProvider getAuthorizationProvider() throws Exception {
		if (authorizationProvider == null) {
			class AuthorizationProviderEntry implements Comparable<AuthorizationProviderEntry> {
				
				public AuthorizationProviderEntry(AuthorizationProvider sm) {
					this.sm = sm;
				}
				
				int priority;
				
				AuthorizationProvider sm;

				@Override
				public int compareTo(AuthorizationProviderEntry o) {
					return o.priority - priority;
				}
				
			}
			final List<AuthorizationProviderEntry> smeList = new ArrayList<>();
			for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor(SECURITY_ID)) {
				if ("authorization_provider".equals(ce.getName())) {					
					AuthorizationProvider ap = (AuthorizationProvider) ce.createExecutableExtension("class");
					CoreUtil.injectProperties(ce, ap);
					AuthorizationProviderEntry sme = new AuthorizationProviderEntry(ap);
					
					String priorityStr = ce.getAttribute("priority");
					if (!CoreUtil.isBlank(priorityStr)) {
						sme.priority = Integer.parseInt(priorityStr);
					}
					
					smeList.add(sme);
				}					
			}
			
			Collections.sort(smeList);
			
			authorizationProvider = new AuthorizationProvider() {
				
				@Override
				public AccessDecision authorize(Context context, Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
					for (AuthorizationProviderEntry sme: smeList) {
						AccessDecision result = sme.sm.authorize(context, target, action, qualifier, environment);
						if (AccessDecision.ALLOW.equals(result) || AccessDecision.DENY.equals(result)) {
							return result;
						}
					}

					return defaultAccessDecision;
				}
			};
		}
		return authorizationProvider;
	}
	
	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return AccessDecision.ALLOW.equals(getAuthorizationProvider().authorize(this, target, action, qualifier, environment));
	}
	
	private Converter<Object, Object, Context> converter;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		if (chain!=null) {
			for (Context ch: chain) {
				if (ch!=null) {
					T ret = ch.convert(source, targetType);
					if (ret!=null) {
						return ret;
					}
				}
			}
		}
		
		synchronized (this) {
			if (converter==null) {
				converter = CoreUtil.createConverter();
			}
		}
		return (T) converter.convert(source, (Class<Object>) targetType, this);
	}

	@Override
	public void close() throws Exception {
		if (converter!=null) {
			converter.close();
		}
	}

}
