package org.nasdanika.function.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;
import org.nasdanika.function.Command;

public interface CDOTransactionContextCommand<CR, MC extends Context, T, R> extends Command<CDOTransactionContext<CR,MC>, CDOTransactionContextFunctionFactory<CR,MC,?>, T, R> {

}
