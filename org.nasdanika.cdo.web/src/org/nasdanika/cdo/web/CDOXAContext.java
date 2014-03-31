package org.nasdanika.cdo.web;

import java.util.Map;

import org.eclipse.emf.cdo.transaction.CDOXATransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.web.Context;

/**
 * Context for multiple views participating in a CDO XA transaction.
 * @author Pavel
 *
 */
public interface CDOXAContext extends Context {
	
	CDOXATransaction getCDOXATransaction();
	
	/**
	 * @return Map of view aliases to views.
	 */
	Map<String, CDOView> getViews();

}
