package org.nasdanika.web;

import javax.servlet.http.HttpServletResponse;

public class ProcessingError {
	
	public static final ProcessingError NOT_FOUND = new ProcessingError(HttpServletResponse.SC_NOT_FOUND);
	public static final ProcessingError FORBIDDEN = new ProcessingError(HttpServletResponse.SC_FORBIDDEN);
	public static final ProcessingError INTERNAL_SERVER_ERROR = new ProcessingError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	public static final ProcessingError BAD_REQUEST = new ProcessingError(HttpServletResponse.SC_BAD_REQUEST);
	
	private int code;
	private String message;

	public ProcessingError(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ProcessingError(int code) {
		this(code, null);
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

}
