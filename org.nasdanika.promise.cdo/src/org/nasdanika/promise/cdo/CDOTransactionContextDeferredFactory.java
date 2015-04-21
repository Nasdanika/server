package org.nasdanika.promise.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.promise.DeferredFactory;

public interface CDOTransactionContextDeferredFactory<CR,F,R,N> extends DeferredFactory<CDOTransactionContext<CR>, F, R, N, CDOTransactionContextPromise<CR, F, R, N>> {
	
	@Override
	CDOTransactionContextDeferred<CR,F,R,N> defer();

}
