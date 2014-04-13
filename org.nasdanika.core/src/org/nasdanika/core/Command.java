package org.nasdanika.core;

/**
 * Generic command.
 * @author Pavel
 *
 * @param <C>
 * @param <R>
 */
public interface Command<C extends Context, R> extends AutoCloseable {
	
	/**
	 * Executes command in context.
	 * @param context
	 * @return
	 */
	R execute(C context) throws Exception;
	
	boolean canExecute();
	
}
