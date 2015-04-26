package org.nasdanika.cdo.sca;

import java.util.Map;

/**
 * @author Pavel
 *
 */
public interface ServiceProvider extends AutoCloseable {

	<T> ServiceReference<T> getServiceReference(Class<T> serviceType, String name, Map<String, Object> properties);
	
}
