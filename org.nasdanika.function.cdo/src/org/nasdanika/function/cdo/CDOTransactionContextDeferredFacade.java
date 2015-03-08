package org.nasdanika.function.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.function.DeferredFacade;

public interface CDOTransactionContextDeferredFacade<CR, MC extends Context, P extends CDOTransactionContextPromise<CR,MC,P>> extends DeferredFacade<CDOTransactionContext<CR,MC>, CDOTransactionContextFunction<CR,MC>, P, CDOTransactionContextFunctionFactory<CR,MC,P>>  {

}
