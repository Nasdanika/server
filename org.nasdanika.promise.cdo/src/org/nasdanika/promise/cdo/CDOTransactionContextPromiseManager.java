package org.nasdanika.promise.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.promise.PromiseManager;

public interface CDOTransactionContextPromiseManager<CR,F,R,N> extends PromiseManager<CDOTransactionContext<CR>,F,R,N,CDOTransactionContextPromise<CR, F, R, N>> {
	
	@Override
	CDOTransactionContextDeferred<CR, F, R, N> getDeferred(String deferredId);
	
}
