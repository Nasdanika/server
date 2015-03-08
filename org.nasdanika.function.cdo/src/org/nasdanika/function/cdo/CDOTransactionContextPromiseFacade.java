package org.nasdanika.function.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.function.Facade;

public interface CDOTransactionContextPromiseFacade<CR, MC extends Context> extends CDOTransactionContextPromise<CR, MC, CDOTransactionContextPromiseFacade<CR,MC>>, Facade<CDOTransactionContext<CR,MC>, CDOTransactionContextFunctionFactory<CR,MC, CDOTransactionContextPromiseFacade<CR,MC>>, CDOTransactionContextPromiseFacade<CR,MC>> {

}
