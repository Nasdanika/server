package org.nasdanika.cdo;

import org.nasdanika.core.Context;
import org.nasdanika.core.ContextProvider;

public interface CDOTransactionContextProvider<CR, MC extends Context> extends ContextProvider<CDOTransactionContext<CR, MC>> {

}
