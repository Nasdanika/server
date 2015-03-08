package org.nasdanika.function.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.function.PromiseManager;

public interface CDOTransactionContextPromiseManager<CR, MC extends Context> extends 
	PromiseManager<CDOTransactionContext<CR,MC>, CDOTransactionContextFunction<CR,MC>, CDOTransactionContextPromiseFacade<CR,MC>, CDOTransactionContextFunctionFactory<CR,MC,CDOTransactionContextPromiseFacade<CR,MC>>>,
	CDOTransactionContextFunctionFactory<CR, MC, CDOTransactionContextPromiseFacade<CR,MC>> {

}
