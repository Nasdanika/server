/**
 */
package org.nasdanika.function.cdo;

import java.util.Map;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.function.Function;

/**
 * Binds Function to CDOTransactionContext
 */
public interface CDOTransactionContextFunction<CR, T, R> extends Function<CDOTransactionContext<CR>, T, R>, CDOTransactionContextCommand<CR, T, R> {
	
	@Override
	CDOTransactionContextFunction<CR, T, R> bind(CDOTransactionContext<CR> context, Object... bindings);

	@Override
	CDOTransactionContextFunction<CR, T, R> bind(CDOTransactionContext<CR> context, Map<Integer, Object> bindings);
	
} 
