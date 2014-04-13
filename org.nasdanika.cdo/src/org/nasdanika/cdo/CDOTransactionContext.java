package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.core.TransactionContext;

public interface CDOTransactionContext extends TransactionContext {
	
	CDOTransaction getTransaction();

}
