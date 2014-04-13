package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.core.Context;

public interface CDOViewContext extends Context {

	CDOView getView();
	
}
