package org.nasdanika.webtest;

/**
 * Pending exception can be thrown by test/actor/page methods which are not implemented yet to indicate that implementation
 * is pending. While {@link Pending} annotation prevents test method execution, throwing the exception allows to 
 * gradually work on a test method implementation. 
 * @author Pavel Vlasov
 *
 */
public class PendingException extends RuntimeException {

	public PendingException() {
		
	}

	public PendingException(String message) {
		super(message);
	}

}
