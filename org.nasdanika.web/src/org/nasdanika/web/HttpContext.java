package org.nasdanika.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nasdanika.core.SecurityContext;

public interface HttpContext extends WebContext, SecurityContext {
	
	HttpServletRequest getRequest();
	
	HttpServletResponse getResponse();
	
	String getContextURL();

}
