package org.nasdanika.core;

import java.util.Map;

import org.nasdanika.core.AuthorizationProvider.StandardAction;

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
	 * Calls <code>authorize(Object target, String action, String qualifier, Map<String, Object> environment)</code> with
	 * action name as argument.
	 * @param target
	 * @param action
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default boolean authorize(Object target, StandardAction action, String qualifier, Map<String, Object> environment) throws Exception {
		return authorize(target, action.name(), qualifier, environment);
	}

	/**
	 * Calls <code>authorize(Object target, StandardAction action, String qualifier, Map<String, Object> environment)</code> with {@link StandardAction}.create as argument.
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default boolean authorizeCreate(Object target, String qualifier, Map<String, Object> environment) throws Exception {
		return authorize(target, StandardAction.create, qualifier, environment);
	}

	/**
	 * Calls <code>authorize(Object target, StandardAction action, String qualifier, Map<String, Object> environment)</code> with {@link StandardAction}.read as argument.
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default boolean authorizeRead(Object target, String qualifier, Map<String, Object> environment) throws Exception {
		return authorize(target, StandardAction.read, qualifier, environment);
	}

	/**
	 * Calls <code>authorize(Object target, StandardAction action, String qualifier, Map<String, Object> environment)</code> with {@link StandardAction}.update as argument.
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default boolean authorizeUpdate(Object target, String qualifier, Map<String, Object> environment) throws Exception {
		return authorize(target, StandardAction.update, qualifier, environment);
	}

	/**
	 * Calls <code>authorize(Object target, StandardAction action, String qualifier, Map<String, Object> environment)</code> with {@link StandardAction}.delete as argument.
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default boolean authorizeDelete(Object target, String qualifier, Map<String, Object> environment) throws Exception {
		return authorize(target, StandardAction.delete, qualifier, environment);
	}

	/**
	 * Calls <code>authorize(Object target, StandardAction action, String qualifier, Map<String, Object> environment)</code> with {@link StandardAction}.execute as argument.
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default boolean authorizeExecute(Object target, String qualifier, Map<String, Object> environment) throws Exception {
		return authorize(target, StandardAction.execute, qualifier, environment);
	}
	

	/**
	 * Converts source to target type.
	 * @param source
	 * @param targetType
	 * @return source converted to target type or null if conversion is not possible.
	 * @throws Exception
	 */
	<T> T convert(Object source, Class<T> targetType) throws Exception;
	
}
