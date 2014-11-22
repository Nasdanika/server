package org.nasdanika.webtest;

public class PublishException extends Exception {

	public PublishException(String message) {
		super(message);
	}

	public PublishException(Throwable cause) {
		super(cause);
	}

	public PublishException(String message, Throwable cause) {
		super(message, cause);
	}

	public PublishException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
