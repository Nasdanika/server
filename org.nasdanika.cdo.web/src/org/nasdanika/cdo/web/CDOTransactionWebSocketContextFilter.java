package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.cdo.CDOTransactionContextFilter;

public class CDOTransactionWebSocketContextFilter<CR> extends CDOTransactionContextFilter<CR> implements CDOTransactionWebSocketContext<CR> {

	public CDOTransactionWebSocketContextFilter(CDOTransactionWebSocketContext<CR> target) {
		super(target);
	}

	@Override
	public CDOObject getTargetObject() {
		return ((CDOTransactionWebSocketContext<CR>) target).getTargetObject();
	}
	
}
