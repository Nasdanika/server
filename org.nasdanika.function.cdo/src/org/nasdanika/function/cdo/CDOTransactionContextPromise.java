/**
 */
package org.nasdanika.function.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.function.Promise;

/**
 * Binding of Promise to CDOTransactionContext.
 */
public interface CDOTransactionContextPromise<CR, MC extends Context, P extends CDOTransactionContextPromise<CR, MC, P>> extends Promise<CDOTransactionContext<CR, MC>, CDOTransactionContextFunction<CR, MC>, P> {
	
} 
