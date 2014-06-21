package org.nasdanika.cdo.boxing;

import org.nasdanika.core.NasdanikaException;

public class BoxingException extends NasdanikaException {

	public BoxingException(String message) {
		super(message);
	}

	public BoxingException(Throwable cause) {
		super(cause);
	}

	public BoxingException(String message, Throwable cause) {
		super(message, cause);
	}

	public BoxingException(String message, Throwable cause,	boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
