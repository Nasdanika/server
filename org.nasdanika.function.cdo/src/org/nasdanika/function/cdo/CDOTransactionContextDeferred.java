/**
 */
package org.nasdanika.function.cdo;

import org.eclipse.emf.cdo.CDOObject;

import org.nasdanika.cdo.CDOTransactionContext;

import org.nasdanika.core.Context;

import org.nasdanika.function.Deferred;

/**
 * Binding of Deferred to CDOTransactionContext
 */
public interface CDOTransactionContextDeferred<CR, MC extends Context, P extends CDOTransactionContextPromise<CR, MC, P>> extends CDOObject, Deferred<CDOTransactionContext<CR, MC>, CDOTransactionContextFunction<CR, MC>, P> {
	
} 
