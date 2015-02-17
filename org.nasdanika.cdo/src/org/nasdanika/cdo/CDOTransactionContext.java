package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.core.Context;
import org.nasdanika.core.TransactionContext;

public interface CDOTransactionContext<CR, MC extends Context> extends TransactionContext, CDOViewContext<CDOTransaction, CR, MC> {
	
}
