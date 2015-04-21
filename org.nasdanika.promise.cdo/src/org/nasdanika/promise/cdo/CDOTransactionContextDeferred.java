/**
 */
package org.nasdanika.promise.cdo;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.promise.Deferred;

/**
 * Binding of Deferred to CDOTransactionContext
 */
public interface CDOTransactionContextDeferred<CR, F, R, N> extends CDOObject, Deferred<CDOTransactionContext<CR>, F, R, N, CDOTransactionContextPromise<CR, F, R, N>> {
	
	
	
} 
