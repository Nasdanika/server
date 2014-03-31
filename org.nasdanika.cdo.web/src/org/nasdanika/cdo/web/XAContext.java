package org.nasdanika.cdo.web;

import java.util.Map;

import javax.transaction.Transaction;

import org.nasdanika.cdo.xa.MapXACDOSession.XAViews;
import org.nasdanika.web.Context;

/**
 * Context for multiple CDO View providers and other resources
 * participating in a JTA transaction.
 * @author Pavel
 *
 */
public interface XAContext extends Context {
	
	/**
	 * Map of view provider aliases to xa views.
	 * @return
	 */
	Map<String, XAViews<String>> getViews();
	

	Transaction getTransaction();
	
}
