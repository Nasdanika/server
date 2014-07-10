package org.nasdanika.core;

/**
 * Generic transaction context.
 * @author Pavel
 *
 */
public interface TransactionContext extends Context {

	/**
	 * Marks transaction for rollback.
	 */
	void setRollbackOnly();
	
	boolean isRollbackOnly();
	
}
