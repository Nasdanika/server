package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.core.Context;

public interface CDOTransactionContextProvider<CR, MC extends Context> extends CDOViewContextProvider<CDOTransaction, CR, MC, CDOTransactionContext<CR, MC>> {

}
