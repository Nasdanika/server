package org.nasdanika.core;

/**
 * Provides values.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface Provider<C extends Context, V> {
	
	/**
	 * Obtain value in a given context.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	V get(C context) throws Exception;

}