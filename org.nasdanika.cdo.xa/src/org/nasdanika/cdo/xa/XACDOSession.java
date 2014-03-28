package org.nasdanika.cdo.xa;

import javax.transaction.xa.XAResource;

/**
 * Instances of this interface provide support for distributed transactions. 
 * An XACDOSession object may be enlisted in a distributed transaction by means of an XAResource object. 
 * A transaction manager manages an XACDOSession object through the XAResource object. 
 * 
 * Application programmers use object returned by <code>T getViews()</code>.
 * 
 * @author Pavel Vlasov
 *
 * @param <T> An object which provides access to CDO views and transactions associated with a distributed transaction. XACDOSession
 * can manage multiple CDO views/transactions backed by multiple CDOSession objects. 
 */
public interface XACDOSession<T> {
	
	/**
	 * @return an XAResource object that the transaction manager will use to manage this XAConnection object's participation in a distributed transaction.
	 * 
	 */
	XAResource getXAResource();

	/**
	 * @return Object providing access to CDOViews associated with the current distributed transaction or unmanaged views, if XAResource is not associated
	 * with a transaction.
	 */
	T getUserObject();

}
