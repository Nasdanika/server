package org.nasdanika.cdo.sca;

import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.promise.Promise;
import org.nasdanika.core.Context;

public interface ServiceProviderContext extends Context {
	
	Object getProperty(String propertyName);
	
	<T> ServiceReference<T> getServiceReference(Class<T> serviceType, String serviceName);
	
	/**
	 * Synchronously invokes activator
	 * @param activatorName
	 * @param args
	 * @return
	 * @throws Exception
	 */
	Object invoke(String activatorName, Object... args) throws Exception;
	
	/**
	 * Submits invocation to be executed at a later time according to the wire
	 * configuration - as soon as possible, delayed, with fixed delay or with fixed rate.
	 * @param activatorName
	 * @param args
	 * @return
	 */
	Promise<?, Object, Exception, Object> submit(String activatorName, Object... args);

}
