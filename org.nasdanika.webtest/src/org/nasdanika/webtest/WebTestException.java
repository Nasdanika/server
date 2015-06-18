package org.nasdanika.webtest;

public class WebTestException extends RuntimeException {

	public WebTestException() {

	}

	public WebTestException(String message) {
		super(message);
	}

	public WebTestException(Throwable cause) {
		super(cause);
	}

	public WebTestException(String message, Throwable cause) {
		super(message, cause);

	}

	public WebTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
