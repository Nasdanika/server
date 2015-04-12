package org.nasdanika.cdo;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.ClassLoadingContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public abstract class CDOViewContextImpl<V extends CDOView, CR, MC> extends CDOViewContextBase<V, CR, MC> implements ClassLoadingContext {
	
	private V view;
	
	private SecurityPolicyManager securityPolicyManager;

	private Bundle bundle;

	private AccessDecision defaultAccessDecition;

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
			AccessDecision defaultAccessDecision) throws Exception {
		super(bundle.getBundleContext());
		this.bundle = bundle;
		this.securityPolicyManager = securityPolicyManager;
		this.masterContext = masterContext;
		view = openView();
		this.defaultAccessDecition = defaultAccessDecision;
	}
	
	@Override
	protected MC getMasterContext() {
		return masterContext;
	}
	
	@Override
	protected AccessDecision getDefaultAccessDecision() {
		return defaultAccessDecition;
	}

	protected abstract V openView();

	@Override
	public void close() throws Exception {
		view.close();
		super.close();
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
