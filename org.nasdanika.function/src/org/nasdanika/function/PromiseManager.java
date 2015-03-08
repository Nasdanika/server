package org.nasdanika.function;

import java.util.List;

public interface PromiseManager<C, F extends Function<C>, P extends Promise<C,F,P>, FC extends FunctionFactory<C, F, P>> {
	
	DeferredFacade<C,F,P,FC> deferAndStore(String owner);
	
	DeferredFacade<C,F,P,FC> store(String owner, Deferred<C,F,P> deferred);
	
	// TODO - cleanup methods.
	
	DeferredFacade<C,F,P,FC> findDeferred(String deferredId);
	
	PromiseFacade<C,F,FC> findPromise(String promiseId);
	
	<R, CMD extends Command<C, FC, List<Deferred<C,F,P>>, R>> R processDeferreds(String owner, CMD command) throws Exception;	

}
