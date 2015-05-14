package org.nasdanika.web.html;

import java.util.Map;

import org.nasdanika.web.HttpServletRequestContext;

/**
 * Implementations of this interface contribute to UI construction.
 * @author Pavel
 *
 */
public interface UIPart<C extends HttpServletRequestContext, T> {

	/**
	 * Renders HTML 
	 * @param context Context
	 * @param out Object to add rendered content to.
	 * @param environment Additional rendering configuration.
	 */
	 void create(C context, T out, Map<String, Object> environment) throws Exception;
	
}
