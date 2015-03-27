package org.nasdanika.promise;

import java.util.List;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;

public interface PromiseManagerFacade<C extends Context> {
	
	// TODO - provider, two flavors - in context, out of context.
	
	<F,R,N> DeferredFacade<C,F,R,N> deferAndStore(String owner);
	
	<F,R,N> DeferredFacade<C,F,R,N> store(String owner, Deferred<C,F,R,N> deferred);
	
	// TODO - cleanup methods.
	
	<F,R,N> DeferredFacade<C,F,R,N> findDeferred(String deferredId);
	
	<F,R,N> PromiseFacade<C,F,R,N> findPromise(String promiseId);
	
	<R, DCMD extends Command<C, List<Deferred<C, ?,?,?>>, R>> R processDeferreds(String owner, DCMD command) throws Exception;	

}
