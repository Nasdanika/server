package org.nasdanika.function;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public interface Promise<C, F extends Function<C>, P extends Promise<C,F,P>> {		
	
	enum State { PENDING, FULFILLED, REJECTED, CANCELLED }
		
	/**
	 * Three functions.
	 * @param onFulfill
	 * @param onReject
	 * @param onProgress
	 * @return
	 */
	P then(F onFulfill, F onReject, F onProgress);
	
//	/**
//	 * Similar to then(), but reports unhandled exceptions.
//	 * @param onFulfill
//	 * @param onReject
//	 * @param onProgress
//	 * @return
//	 */
//	Promise<C> done(Function<C> onFulfill, Function<C> onReject, Function<C> onProgress);
	
	/**
	 * Cancels promise indicating that there is no interest in the results
	 * and value computation can be cancelled if not yet performed. 
	 */
	boolean cancel();
	
	State getState();
	
	Object getFulfillmentValue();
	
	Object getRejectionReason();
	
	/**
	 * Returns a promise which is resolved with the same values as this promise, but is rejected
	 * with <code>reason</code> if this promise is not resolved after the specified timeout. If reason is <code>null</code> 
	 * then the returned promise is rejected with {@link TimeoutException}.
	 * @param timeout
	 * @param reason
	 */
	P timeout(long timeout, TimeUnit timeUnit, Object reason);
	
	/**
	 * Returns a promise which is resolved with the same values as this promise, but after at least <code>delay</code> time units
	 * has passed.
	 * @param timeout
	 * @param reason
	 */
	P delay(long timeout, TimeUnit timeUnit);
	
}
