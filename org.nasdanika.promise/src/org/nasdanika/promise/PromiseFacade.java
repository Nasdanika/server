package org.nasdanika.promise;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;
import org.nasdanika.promise.Promise.State;

/**
 * PromiseFacade parallels Promise API. The facade creates a context for each method invocation, executes
 * promise method in the context and then closes the context.
 * @author Pavel
 *
 * @param <C>
 * @param <F>
 * @param <R>
 * @param <N>
 */
public interface PromiseFacade<C extends Context, F, R, N> extends Facade<C, Promise<C,F,R,N>> {
	/**
	 * 
	 * @param <TF> Fulfillment type of returned promise.
	 * @param <TR> Rejection type of returned promise.
	 * @param <TN> Notification type of returned promise.
	 * @param onFulfill
	 * @param onReject
	 * @param onProgress
	 * @return
	 */
	<TF, TR, TN> PromiseFacade<C, TF, TR, TN> then(
			Command<C, ? super F, TF> onFulfill, 
			Command<C, ? super R, TF> onReject, 
			Command<C, ? super N, TN> onProgress);
		
	/**
	 * Cancels promise indicating that there is no interest in the results
	 * and value computation can be cancelled if not yet performed. 
	 */
	boolean cancel();
	
	State getState();
	
	F getFulfillmentValue();
	
	R getRejectionReason();
	
	/**
	 * Returns a promise facade which is resolved with the same values as this promise, but is rejected
	 * with <code>reason</code> if this promise is not resolved after the specified timeout. If reason is <code>null</code> 
	 * then the returned promise is rejected with {@link TimeoutException}.
	 * @param timeout
	 * @param reason
	 */
	<TR> PromiseFacade<C, F, TR, N> timeout(long timeout, TimeUnit timeUnit, TR reason);
	
	/**
	 * Returns a promise which is resolved with the same values as this promise, but after at least <code>delay</code> time units
	 * has passed.
	 * @param timeout
	 * @param reason
	 */
	PromiseFacade<C, F, R, N> delay(long timeout, TimeUnit timeUnit);

}
