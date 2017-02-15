package org.nasdanika.core;

import java.util.Map;

public interface AuthorizationProvider {
	
	enum AccessDecision {
		DENY,
		ALLOW,
		ABSTAIN
	}
	
	/**
	 * Standard actions.
	 * @author Pavel
	 *
	 */
	enum StandardAction {
		
		create,
		read,
		update,
		delete,
		execute
		
	}

	/**
	 * Checks whether given context has a permission to execute an action on the ojbect
	 * @param context Authorization context.
	 * @param target Target object.
	 * @param action Action name, e.g. <code>read</code>
	 * @param qualifier Additional action qualifier, e.g. <code>accountBalance</code>
	 * @param environment Environment for conditional actions. E.g. for action
	 * <code>debit</code> on target of type <code>Account</code> environment map
	 * may contain transaction amount and action condition may be 
	 * <code>transactionAmount < actionProperties.transactionAmountThreshold</code>
	 * @return Access decision, ABSTAIN is used for chaining/stacking of
	 * security providers.
	 */
	AccessDecision authorize(
			Context context, 
			Object target, 
			String action, 
			String qualifier,
			Map<String, Object> environment) throws Exception;
	
	/**
	 * Calls authorize(Context, Object, String, String, Map) with action name argument.
	 * @param context
	 * @param target
	 * @param action
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default AccessDecision authorize(
			Context context, 
			Object target, 
			StandardAction action, 
			String qualifier,
			Map<String, Object> environment) throws Exception {
		
		return authorize(context, target, action.name(), qualifier, environment);
	};	

	/**
	 * Calls authorize() with {@link StandardAction}.create argument.
	 * @param context
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default AccessDecision authorizeCreate(
			Context context, 
			Object target, 
			String qualifier,
			Map<String, Object> environment) throws Exception {
		
		return authorize(context, target, StandardAction.create, qualifier, environment);
	};	
	

	/**
	 * Calls authorize() with {@link StandardAction}.read argument.
	 * @param context
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default AccessDecision authorizeRead(
			Context context, 
			Object target, 
			String qualifier,
			Map<String, Object> environment) throws Exception {
		
		return authorize(context, target, StandardAction.read, qualifier, environment);
	};	

	/**
	 * Calls authorize() with {@link StandardAction}.update argument.
	 * @param context
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default AccessDecision authorizeUpdate(
			Context context, 
			Object target, 
			String qualifier,
			Map<String, Object> environment) throws Exception {
		
		return authorize(context, target, StandardAction.update, qualifier, environment);
	};	

	/**
	 * Calls authorize() with {@link StandardAction}.delete argument.
	 * @param context
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default AccessDecision authorizeDelete(
			Context context, 
			Object target, 
			String qualifier,
			Map<String, Object> environment) throws Exception {
		
		return authorize(context, target, StandardAction.delete, qualifier, environment);
	};	

	/**
	 * Calls authorize() with {@link StandardAction}.execute argument.
	 * @param context
	 * @param target
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	default AccessDecision authorizeExecute(
			Context context, 
			Object target, 
			String qualifier,
			Map<String, Object> environment) throws Exception {
		
		return authorize(context, target, StandardAction.execute, qualifier, environment);
	};	
	
}
