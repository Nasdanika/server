package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.CDOTransactionContext;

public interface CDOTransactionWebSocketContext<CR> extends CDOTransactionContext<CR>, CDOViewWebSocketContext<CDOTransaction, CR> {
	
}
