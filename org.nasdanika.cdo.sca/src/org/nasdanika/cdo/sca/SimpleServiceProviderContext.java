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
	
	private static class ServiceKey {

		Class<?> type;
		String name;
		
		ServiceKey(Class<?> type, String name) {
			super();
			this.type = type;
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ServiceKey other = (ServiceKey) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		
	}
	
	private Map<ServiceKey, Object> serviceMap = new HashMap<>();

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getService(Class<T> serviceType, String serviceName) {
		return (T) serviceMap.get(new ServiceKey(serviceType, serviceName));
	}
	
	public void setProperty(String name, Object value) {
		properties.put(name, value);
	}
	
	public <T> void registerService(Class<T> serviceType, String serviceName, T service) {
		serviceMap.put(new ServiceKey(serviceType, serviceName), service);
	}

}
