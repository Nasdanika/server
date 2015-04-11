package org.nasdanika.promise;

import org.nasdanika.core.Context;

public interface PromiseManager<C extends Context> {
	
	// TODO - provider, two flavors - in context, out of context.
	
	<F,R,N> Deferred<C,F,R,N> defer(String owner);
	
	// TODO - cleanup methods.
	
	<F,R,N> Deferred<C,F,R,N> findDeferred(String deferredId);
	
	<F,R,N> Promise<C,F,R,N> findPromise(String promiseId);
	
}
