package org.nasdanika.function;

import java.util.Map;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;


/**
 * @author Pavel Vlasov
 *
 */
public interface Function<C extends Context, T, R> extends Command<C, T, R> {
	
	Class<?>[] getParameterTypes(C context);
	
	Class<?> getReturnType(C context);

	/**
	 * Binds values to parameters.
	 * @param bindings Bindings.
	 * @return Function with bound parameters.
	 */
	Function<C,T,R> bind(C context, Object... bindings);

	/**
	 * Binds specified parameters.
	 * @param bindings Mapping of parameter indexes to arguments to bind. 
	 * @return Function with bound parameters.
	 */
	Function<C,T,R> bind(C context, Map<Integer, Object> bindings);
	
}
