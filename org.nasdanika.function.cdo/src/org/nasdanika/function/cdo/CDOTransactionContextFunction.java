/**
 */
package org.nasdanika.function.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.function.Function;

/**
 * Binds Function to CDOTransactionContext
 */
public interface CDOTransactionContextFunction<CR, MC extends Context, T, R> extends Function<CDOTransactionContext<CR, MC>, T, R> {
	
//	@Override
//	public CDOTransactionContextFunction<CR, MC, T, R> bind(Map<Integer, Object> bindings);
//	
//	@Override
//	public CDOTransactionContextFunction<CR, MC, T, R> bind(Object... bindings);
	
} 
