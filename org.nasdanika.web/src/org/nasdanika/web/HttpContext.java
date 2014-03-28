package org.nasdanika.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpContext extends Context {
	
	HttpServletRequest getRequest();
	
	HttpServletResponse getResponse();

}
