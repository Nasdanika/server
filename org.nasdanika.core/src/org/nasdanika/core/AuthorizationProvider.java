package org.nasdanika.core;

import java.util.Map;

public interface AuthorizationProvider {
	
	enum AccessDecision {
		DENY,
		ALLOW,
		ABSTAIN
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
}
