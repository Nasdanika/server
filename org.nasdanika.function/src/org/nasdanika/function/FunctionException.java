package org.nasdanika.function;

/**
 * Wrapper exception
 * @author Pavel
 *
 */
@SuppressWarnings("serial")
public class FunctionException extends RuntimeException {

	protected FunctionException() {
	}

	public FunctionException(String message) {
		super(message);
	}

	public FunctionException(Throwable cause) {
		super(cause);
	}

	public FunctionException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionException(
			String message, 
			Throwable cause,
			boolean enableSuppression, 
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
