package org.nasdanika.promise;

import org.nasdanika.core.Context;

public interface DeferredFacade<C extends Context, F, R, N> extends Facade<C, Deferred<C,F,R,N>> {
	
	PromiseFacade<C,F,R,N> getPromise();
	
	void resolve(F value);
	
	void reject(R reason);
	
	void notify(N notification);
	
}
