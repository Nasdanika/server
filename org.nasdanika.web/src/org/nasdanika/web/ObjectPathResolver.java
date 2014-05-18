package org.nasdanika.web;

import org.nasdanika.core.Context;

/**
 * Resolves object path.
 * @author Pavel
 *
 * @param <T>
 */
public interface ObjectPathResolver<T> {
	
	/**
	 * Resolves object path.
	 * @param obj Object
	 * @param master Master resolver.
	 * @return
	 */
	String resolve(T obj, ObjectPathResolver<Object> master, Context context) throws Exception;

}
