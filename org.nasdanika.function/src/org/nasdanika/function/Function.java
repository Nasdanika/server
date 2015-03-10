package org.nasdanika.function;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;


/**
 * @author Pavel Vlasov
 *
 */
public interface Function<C extends Context, T, R> extends Command<C, T, R> {
	
	Class<?>[] getParameterTypes();
	
	Class<?> getReturnType();

	/**
	 * Binds values to parameters.
	 * @param bindings Bindings.
	 * @return Function with bound parameters.
	 */
	Function<C,T,R> bind(Object... bindings);

	/**
	 * Binds specified parameters.
	 * @param indexes Indexes of parameters to bind.
	 * @param bindings Bindings.
	 * @return Function with bound parameters.
	 */
	Function<C,T,R> bind(int[] indexes, Object... bindings);
	
}
