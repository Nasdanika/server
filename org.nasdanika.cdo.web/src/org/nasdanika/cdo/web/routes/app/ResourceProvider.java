package org.nasdanika.cdo.web.routes.app;

import java.net.URL;

import org.nasdanika.core.Context;

public interface ResourceProvider<C extends Context> {
	
	
	/**
	 * 
	 * @param context
	 * @param obj
	 * @param key
	 * @return Resource for a given key. This implementation uses resource bundle. If property with given key is not found in the resource bundle, then
	 * this implementation reads ``<key>@`` property (property reference), e.g. ``documentation@`` for documentation. If such property is present, then a classloader
	 * resource ({@link URL}) with the name equal to the property value is returned, if present.  
	 * @throws Exception
	 */
	Object getResource(C context, String key) throws Exception;
	
	/**
	 * Retrieves resource string for a named element. This method calls getResourceString() with ``<element type>.<element name>.<key>`` key. E.g. ``class.MyClass.myKey``.
	 */
	String getResourceString(C context, String key) throws Exception;
	

}
