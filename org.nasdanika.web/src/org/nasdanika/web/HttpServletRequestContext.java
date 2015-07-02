package org.nasdanika.web;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.core.SecurityContext;

public interface HttpServletRequestContext extends Context, ExportingContext, ClassLoadingContext, SecurityContext {
	
	HttpServletRequest getRequest();
	
	HttpServletResponse getResponse();
	
	String getContextURL();
	
	RequestMethod getMethod();
	
	String[] getPath();
	
	/**
	 * Returns action for a given target object with current path offset to pathOffset. 
	 * @param target
	 * @param pathOffset
	 * @param chain Contexts to be added to the sub-context for the target object.
	 * @return
	 * @throws Exception
	 */
	Action getAction(Object target, int pathOffset, Context[] contextChain, Object... args) throws Exception;
	
	Action getExtensionAction(Object target, String extension) throws Exception;
		
	//Object getRequestData();
	
	Object getTarget();
	
	/**
	 * Renders object to HTML 
	 * @param obj Object to render
	 * @param profile Optional rendering profile, e.g. "link" profile instructs the renderer to render a link to the element.
	 * @param environment Additional rendering configuration.
	 * @return Object rendered to HTML
	 */
	String toHTML(Object obj, String profile, Map<String, Object> environment) throws Exception;
	
	/**
	 * Renders UI parts for the context object in a given category.
	 * @param category
	 * @param out Receiver of rendered parts.
	 * @param environment
	 * @throws Exception
	 */
	void buildUICategory(String category, Object out, Map<String, Object> environment) throws Exception;
	
	/**
	 * Resolves object path. Optional operation.
	 * @param object
	 * @return
	 */
	String getObjectPath(Object object) throws Exception;
	
	String getCharacterEncoding();
	
	Map<Object, String> getRootObjectsPaths();
	
	interface Store {
		
		Object get(String key);
		
		Object remove(String key);
		
		String put(Object obj);
		
	}
	
	Store getSessionStore();
	
	List<TraceEntry> getPathTrace();
	
	Collection<TraceEntry> getSessionTrace();
	
	void addPathTraceEntry(String path, String displayName);
	
	void addSessionTraceEntry(String path, String displayName);

}
