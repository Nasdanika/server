package org.nasdanika.cdo.sca;

import java.util.HashMap;
import java.util.Map;

import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.osgi.framework.BundleContext;

/**
 * Simple implementation of service provider context.
 * @author Pavel
 *
 */
public class SimpleServiceProviderContext extends ContextImpl implements ServiceProviderContext {

	public SimpleServiceProviderContext(BundleContext bundleContext, Context... chain) {
		super(bundleContext, chain);
	}
	
	private Map<String, Object> properties = new HashMap<>();

	@Override
	public Object getProperty(String name) {
		return properties.get(name);
	}
	
	private Map<ServiceKey, ServiceReference<Object>> serviceMap = new HashMap<>();

	@SuppressWarnings("unchecked")
	@Override
	public <T> ServiceReference<T> getServiceReference(Class<T> serviceType, String serviceName) {
		return (ServiceReference<T>) serviceMap.get(new ServiceKey(serviceType, serviceName));
	}
	
	public void setProperty(String name, Object value) {
		properties.put(name, value);
	}
	
	public <T> void registerService(Class<T> serviceType, String serviceName, final T service) {
		serviceMap.put(new ServiceKey(serviceType, serviceName), new ServiceReference<Object>() {

			@Override
			public void close() throws Exception {
				// NOP				
			}

			@Override
			public Object getService() {
				return service;
			}
			
		});
	}

}
