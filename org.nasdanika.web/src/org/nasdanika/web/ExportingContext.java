package org.nasdanika.web;

import org.nasdanika.core.Context;

public interface ExportingContext extends Context {
	
	/**
	 * Exports object making it URL-addressable. Exports have session scope.  
	 * @param obj Object to export.
	 * @return Object path.
	 */
	String exportObject(Object obj);
	
	/**
	 * Exports route making it URL-addressable. Exports have session scope.
	 * @param route Route to export.
	 * @param method Method to bind route to. If not provided then route is bound to all methods.
	 * @return
	 */
	String exportRoute(Route route, RequestMethod... method);
	
	/**
	 * Unexports object/route at given path.
	 * @param path Path to unexport.
	 * @return Object/route at path, or null if there was no object/route exported at the given path.
	 */
	Object unexport(String path);
	

	// TODO - access to exports for matching.
}
