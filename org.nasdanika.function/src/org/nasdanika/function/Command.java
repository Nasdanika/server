package org.nasdanika.function;


public interface Command<C, FC, T, R> {

	/**
	 * Executes command in context against target.
	 * @param context
	 * @param factory
	 * @param target
	 * @throws Exception
	 */
	R execute(C context, FC factory, T target) throws Exception;

}
