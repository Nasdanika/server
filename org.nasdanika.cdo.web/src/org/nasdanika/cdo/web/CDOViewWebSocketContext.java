package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;

public interface CDOViewWebSocketContext<V extends CDOView, CR> extends CDOViewContext<V, CR> {
	
	CDOObject getTargetObject();

}
