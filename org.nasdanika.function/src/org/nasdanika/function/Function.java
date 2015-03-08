package org.nasdanika.function;


/**
 * @author Pavel Vlasov
 *
 */
public interface Function<C> {
	
	Object apply(C context, Object... args) throws Exception;
	
	Class<?>[] getParameterTypes();
	
	Class<?> getReturnType();

	/**
	 * Binds values to parameters.
	 * @param bindings Bindings.
	 * @return Function with bound parameters.
	 */
	Function<C> bind(Object... bindings);

	/**
	 * Binds specified parameters.
	 * @param indexes Indexes of parameters to bind.
	 * @param bindings Bindings.
	 * @return Function with bound parameters.
	 */
	Function<C> bind(int[] indexes, Object... bindings);
	
}
