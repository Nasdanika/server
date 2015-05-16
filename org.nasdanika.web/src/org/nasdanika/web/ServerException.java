package org.nasdanika.web;

import javax.servlet.http.HttpServletResponse;

import org.nasdanika.core.NasdanikaException;

/**
 * This exception is handled by the routing servlet by passing its message to the
 * client side as response 500 message.
 * @author Pavel
 *
 */
@SuppressWarnings("serial")
public class ServerException extends NasdanikaException {
	
	private int statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	
	public int getStatusCode() {
		return statusCode;
	}

	public ServerException(String message) {
		super(message);		
	}

	public ServerException(Throwable cause) {
		super(cause);		
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerException(
			String message, 
			Throwable cause,
			boolean enableSuppression, 
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public ServerException(int statusCode) {
		super("Status: "+statusCode);
		this.statusCode = statusCode;
	}

	public ServerException(String message, int statusCode) {
		this(message);		
		this.statusCode = statusCode;
	}

	public ServerException(Throwable cause, int statusCode) {
		this(cause);		
		this.statusCode = statusCode;
	}

	public ServerException(String message, Throwable cause, int statusCode) {
		this(message, cause);
		this.statusCode = statusCode;
	}

	public ServerException(
			String message, 
			Throwable cause,
			boolean enableSuppression, 
			boolean writableStackTrace, 
			int statusCode) {
		this(message, cause, enableSuppression, writableStackTrace);
		this.statusCode = statusCode;		
	}
	

}
