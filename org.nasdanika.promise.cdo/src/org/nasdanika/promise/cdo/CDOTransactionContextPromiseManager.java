package org.nasdanika.promise.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.promise.PromiseManager;

public interface CDOTransactionContextPromiseManager<CR, MC extends Context> extends PromiseManager<CDOTransactionContext<CR,MC>> {

}
