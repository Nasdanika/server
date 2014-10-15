package org.nasdanika.function;

import org.nasdanika.core.Context;

/**
 * Service interface for components participating in long-running asynchronous interactions. 
 * @author Pavel Vlasov
 *
 */
public interface Participant {
	
	/**
	 * Components receiving invocation results from participants shall 
	 * this service interface.
	 * @author Pavel Vlasov
	 *
	 */
	interface ResultSink {
		
		void resolve(Context context, String correlationId, Object result);
		
		void reject(Context context, String correlationId, Object reason);
		
		void notify(Context context, String correlationId, Object notification);
		
	}

	/**
	 * Posts invocation to the participant. When the participant completes processing or wants to send a progress notification
	 * it finds {@link ResultSink} service, possibly using filter if there is more than one result sink service in the system,
	 * and invokes one of sink's methods. 
	 * @param sinkFilter Filter for the sink service, if there is more than one sink in the system.
	 * @param correlationId Invocation correlationId
	 * @param operationName Operation name.
	 * @param arguments Arguments
	 * @throws Exception
	 */
	void invoke(Context context, String sinkFilter, String correlationId, String operationName, Object... arguments) throws Exception;

}
