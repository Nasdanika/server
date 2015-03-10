/**
 */
package org.nasdanika.promise.cdo;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.promise.Deferred;

/**
 * Binding of Deferred to CDOTransactionContext
 */
public interface CDOTransactionContextDeferred<CR, MC extends Context, F, R, N> extends CDOObject, Deferred<CDOTransactionContext<CR, MC>, F, R, N> {
	
} 
