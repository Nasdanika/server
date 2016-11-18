package org.nasdanika.codegen;

/**
 * Provides configuration values.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface Provider<T> {
	
	/**
	 * Obtain configuration value for a given context.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	T get(Context context) throws Exception;

}
