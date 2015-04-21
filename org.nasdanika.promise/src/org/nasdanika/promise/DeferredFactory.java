package org.nasdanika.promise;

import org.nasdanika.core.Context;

public interface DeferredFactory<C extends Context, F, R, N, P extends Promise<C,F,R,N>> {
	
	Deferred<C,F,R,N,P> defer();

}
