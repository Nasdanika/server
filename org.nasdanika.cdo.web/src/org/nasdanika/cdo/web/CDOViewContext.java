package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.web.Context;

/**
 * Context for a single view.
 * @author Pavel
 *
 */
public interface CDOViewContext extends Context {
	
	CDOView getView();

}
