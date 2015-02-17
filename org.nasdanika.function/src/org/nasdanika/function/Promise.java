package org.nasdanika.function;

import java.util.concurrent.TimeoutException;

public interface Promise {
		
	enum ThenMode { FULFILL, REJECT, NOTIFY }
	
	/**
	 * Single function which gets two arguments - a mode argument and value, error, or notification depending on the mode. 
	 * @param handler
	 * @return
	 */
	Promise then(ThenMode mode, Invocable handler);
	
	/**
	 * Three functions.
	 * @param onFulfill
	 * @param onReject
	 * @param onProgress
	 * @return
	 */
	Promise then(Invocable onFulfill, Invocable onReject, Invocable onProgress);

	/**
	 * Similar to then(), but reports unhandled exceptions.
	 * @param handler
	 * @throws Exception
	 */
	Promise done(ThenMode mode, Invocable handler) throws Exception;
	
	/**
	 * Similar to then(), but reports unhandled exceptions.
	 * @param onFulfill
	 * @param onReject
	 * @param onProgress
	 * @return
	 */
	Promise done(Invocable onFulfill, Invocable onReject, Invocable onProgress);
	
	/**
	 * Cancels promise indicating that there is no interest in the results
	 * and value computation can be cancelled if not yet performed. 
	 */
	boolean cancel();
	
	/**
	 * Sets promise timeout. Promise not resolved when timeout expires gets 
	 * rejected with {@link TimeoutException}
	 * @param timeout
	 */
	void setTimeout(long timeout);
	
	enum State { PENDING, FULFILLED, REJECTED }
	
	State getState();
	
	Object getFulfillmentValue();
	
	Object getRejectionReason();
	
}
