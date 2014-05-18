package org.nasdanika.core;

public class NasdanikaException extends RuntimeException {

	public NasdanikaException(String message) {
		super(message);
	}

	public NasdanikaException(Throwable cause) {
		super(cause);
	}

	public NasdanikaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NasdanikaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
