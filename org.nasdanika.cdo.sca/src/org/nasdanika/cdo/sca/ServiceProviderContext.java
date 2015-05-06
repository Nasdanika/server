package org.nasdanika.cdo.sca;

import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.promise.Promise;
import org.nasdanika.core.Context;

public interface ServiceProviderContext extends Context {
	
	Object getProperty(String propertyName);
	
	<T> ServiceReference<T> getServiceReference(Class<T> serviceType, String serviceName);
	
	CDOTransactionContextCommand<?, ?, ?> getActivator(String name);
	
	<CR> CDOTransactionContextCommand<CR, ?, Promise<CR, ?, ?, ?>> getAsyncActivator(String name);

}
