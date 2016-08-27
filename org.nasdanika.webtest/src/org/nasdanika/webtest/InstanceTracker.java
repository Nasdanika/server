package org.nasdanika.webtest;

/**
 * Keeps mapping of result object to instances for resolving references.
 * @author Pavel Vlasov
 *
 */
interface InstanceTracker {
	
	/**
	 * @param obj
	 * @return true if <code>obj</obj> is an instance of test result represented by this object.
	 */
	boolean isInstance(Object obj);

}
