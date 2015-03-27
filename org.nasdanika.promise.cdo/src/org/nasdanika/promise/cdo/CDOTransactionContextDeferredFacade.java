package org.nasdanika.promise.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.promise.DeferredFacade;

public interface CDOTransactionContextDeferredFacade<CR, MC extends Context, F, R, N> extends DeferredFacade<CDOTransactionContext<CR,MC>, F, R, N>  {

}