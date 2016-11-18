package org.nasdanika.codegen;

/**
 * Provides services.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface ServiceProvider<T> {
	
	/**
	 * Obtain service for a given context.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	T getService(Context context) throws Exception;

}
