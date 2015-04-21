package org.nasdanika.promise;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;

/**
 * 
 * @author Pavel
 *
 * @param <C> Context type.
 * @param <F> Fulfillment type.
 * @param <R> Rejection type.
 * @param <N> Notification type.
 */
public interface Promise<C extends Context, F, R, N> {		
	
	enum State { PENDING, FULFILLED, REJECTED, CANCELLED }
	
	/**
	 * Cancels promise indicating that there is no interest in the results
	 * and value computation can be cancelled if not yet performed. 
	 */
	boolean cancel();
	
	State getState();
	
	F getFulfillmentValue();
	
	R getRejectionReason();
	
	/**
	 * Returns a promise which is resolved with the same values as this promise, but is rejected
	 * with <code>reason</code> if this promise is not resolved after the specified timeout. If reason is <code>null</code> 
	 * then the returned promise is rejected with {@link TimeoutException}.
	 * @param timeout
	 * @param reason
	 */
	<TR> Promise<C, F, TR, N> timeout(long timeout, TimeUnit timeUnit, TR reason);
	
	/**
	 * Returns a promise which is resolved with the same values as this promise, but after at least <code>delay</code> time units
	 * has passed.
	 * @param timeout
	 * @param reason
	 */
	Promise<C, F, R, N> delay(long timeout, TimeUnit timeUnit);
	
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
	<TF, TR, TN> Promise<C, TF, TR, TN> then(
			Command<C, ? super F, TF> onFulfill, 
			Command<C, ? super R, TF> onReject, 
			Command<C, ? super N, TN> onProgress);
	
	String getId();	
	
	///**
	// * Similar to then(), but reports unhandled exceptions.
	// * @param onFulfill
	// * @param onReject
	// * @param onProgress
	// * @return
	// */
	//Promise<C> done(Function<C> onFulfill, Function<C> onReject, Function<C> onProgress);

}
