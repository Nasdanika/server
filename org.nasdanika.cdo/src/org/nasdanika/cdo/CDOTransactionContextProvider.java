package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;


public interface CDOTransactionContextProvider<CR> extends CDOViewContextProvider<CDOTransaction, CR, CDOTransactionContext<CR>> {

}
