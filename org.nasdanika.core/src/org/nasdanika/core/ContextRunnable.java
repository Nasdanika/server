package org.nasdanika.core;

/**
 * Runnable in a context.
 * @author Pavel Vlasov
 *
 * @param <C>
 */
public interface ContextRunnable<C extends Context> {
	
	/**
	 * Runs in context.
	 * @param context
	 */
	void run(C context) throws Exception;
	
}
