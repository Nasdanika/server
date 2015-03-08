package org.nasdanika.function;

/**
 * A wrapper exception to pass exception reason, if it is not an exception, from handler functions.
 * @author Pavel
 *
 */
@SuppressWarnings("serial")
public class RejectionReasonException extends FunctionException {
	
	private Object rejectionReason;
	
	public RejectionReasonException(Object rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
	
	public Object getRejectionReason() {
		return rejectionReason;
	}

}
