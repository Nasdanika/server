package org.nasdanika.cdo.sca;

import org.nasdanika.core.Context;

public interface ServiceProviderContext extends Context {
	
	Object getProperty(String propertyName);
	
	<T> ServiceReference<T> getServiceReference(Class<T> serviceType, String serviceName);

}
