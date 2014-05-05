package org.nasdanika.web;

import java.util.Map;

import org.nasdanika.core.ConverterContext;
import org.nasdanika.html.HTMLFactory;


public interface WebContext extends ConverterContext {
	
	/**
	 * Checks whether given extensionManager has a permission to execute
	 * an action on the ojbect
	 * @param target Target object
	 * @param action Action ID.
	 * @return true if action is allowed, false if denied.
	 */
	boolean authorize(Object target, String action);	
		
	RequestMethod getMethod();
	
	String[] getPath();
	
	/**
	 * Returns action for a given target object with current path offset to pathOffset. 
	 * @param target
	 * @param pathOffset
	 * @return
	 * @throws Exception
	 */
	Action getAction(Object target, int pathOffset) throws Exception;
	
	Action getExtensionAction(Object target, String extension) throws Exception;
		
	//Object getRequestData();
	
	Object getTarget();
	
	Object getPrincipal();
	
	/**
	 * Renders object to HTML 
	 * @param obj Object to render
	 * @param profile Optional rendering profile, e.g. "link" profile instructs the renderer to render a link to the element.
	 * @param environment Additional rendering configuration.
	 * @return Object rendered to HTML
	 */
	String toHTML(Object obj, String profile, Map<String, Object> environment) throws Exception;

	HTMLFactory getHTMLFactory();
	
}
