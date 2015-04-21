package org.nasdanika.cdo.sca;

import org.nasdanika.core.Context;

public interface ComponentContext extends Context {
	
	Object getProperty(String propertyName);
	
	<T> T getServiceReference(Class<T> serviceType);
	
	Object getServiceReference(String serviceName);

}
