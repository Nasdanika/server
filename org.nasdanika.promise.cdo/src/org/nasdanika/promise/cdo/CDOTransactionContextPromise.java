/**
 */
package org.nasdanika.promise.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.promise.Promise;

/**
 * Binding of Promise to CDOTransactionContext.
 */
public interface CDOTransactionContextPromise<CR, F, R, N> extends Promise<CDOTransactionContext<CR>, F, R, N> {
	
} 
