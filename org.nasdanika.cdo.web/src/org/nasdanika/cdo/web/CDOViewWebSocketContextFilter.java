package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContextFilter;

public class CDOViewWebSocketContextFilter<V extends CDOView, CR> extends CDOViewContextFilter<V, CR> implements CDOViewWebSocketContext<V,CR> {

	public CDOViewWebSocketContextFilter(CDOViewWebSocketContext<V,CR> target) {
		super(target);
	}

	@Override
	public CDOObject getTargetObject() {
		return ((CDOViewWebSocketContext<V,CR>) target).getTargetObject();
	}
	
}
