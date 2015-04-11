package org.nasdanika.cdo;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.core.Converter;
import org.nasdanika.core.CoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public abstract class CDOViewContextImpl<V extends CDOView, CR, MC> extends CDOViewContextBase<V, CR, MC> {
	
	private V view;
	
	private SecurityPolicyManager securityPolicyManager;

	private Converter<Object, Object, Context> converter;

	private Bundle bundle;

	private boolean deny;

	private MC masterContext;

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
	
	@Override
	protected MC getMasterContext() {
		return masterContext;
	}
	
	@Override
	protected AccessDecision getDefaultAccessDecision() {
		return deny ? AccessDecision.DENY : AccessDecision.ALLOW;
	}

	protected abstract V openView();

	@Override
	public void close() throws Exception {
		converter.close();
		view.close();
	}

	@Override
	public V getView() {
		return view;
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
		
		return super.adapt(targetType);
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
