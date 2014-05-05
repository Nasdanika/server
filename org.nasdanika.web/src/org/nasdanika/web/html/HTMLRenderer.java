package org.nasdanika.web.html;

import java.util.Map;

import org.nasdanika.web.WebContext;

/**
 * Target type to convert other objects to for HTML rendering.
 * @author Pavel
 *
 */
public interface HTMLRenderer {

	/**
	 * Renders HTML 
	 * @param context Context
	 * @param profile Optional rendering profile, e.g. "link" profile instructs the renderer to render a link to the element.
	 * @param environment Additional rendering configuration.
	 * @return Object rendered to HTML
	 */
	String render(WebContext context, String profile, Map<String, Object> environment) throws Exception;
	
}
