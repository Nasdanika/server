package org.nasdanika.promise;

import org.nasdanika.core.Context;

public interface PromiseManager<C extends Context,F,R,N,P extends Promise<C,F,R,N>> extends DeferredFactory<C,F,R,N,P> {
	
	Deferred<C,F,R,N,P> getDeferred(String deferredId);
	
	P getPromise(String promiseId);

}
