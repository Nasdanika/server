/**
 */
package org.nasdanika.promise.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.promise.Promise;

/**
 * Binding of Promise to CDOTransactionContext.
 */
public interface CDOTransactionContextPromise<CR, MC extends Context, F, R, N> extends Promise<CDOTransactionContext<CR, MC>, F, R, N> {
	
} 
