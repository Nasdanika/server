package org.nasdanika.cdo.sca;

import org.nasdanika.core.Context;

public interface ServiceProviderContext extends Context {
	
	Object getProperty(String propertyName);
	
	<T> T getService(Class<T> serviceType, String serviceName);

}
