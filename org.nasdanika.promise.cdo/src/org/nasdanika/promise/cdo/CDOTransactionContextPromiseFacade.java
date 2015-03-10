package org.nasdanika.promise.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.promise.PromiseFacade;

public interface CDOTransactionContextPromiseFacade<CR, MC extends Context, F, R, N> extends PromiseFacade<CDOTransactionContext<CR,MC>, F, R, N> {

}
