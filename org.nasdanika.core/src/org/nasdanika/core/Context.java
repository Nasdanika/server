package org.nasdanika.core;

import java.util.Map;

/**
 * Base interface for command contexts.
 * @author Pavel
 *
 */
public interface Context extends AutoCloseable, Adaptable {
		
	/**
	 * Checks whether given context has a permission to execute
	 * an action on the target object
	 * @param target Target object
	 * @param action Action ID.
	 * @return true if action is allowed, false if denied.
	 */
	boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception;		
		
	/**
	 * Converts source to target type.
	 * @param source
	 * @param targetType
	 * @return source converted to target type or null if conversion is not possible.
	 * @throws Exception
	 */
	<T> T convert(Object source, Class<T> targetType) throws Exception;
	
}
