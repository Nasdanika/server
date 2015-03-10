package org.nasdanika.cdo;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;

public interface CDOTransactionContextCommand<CR, MC extends Context, T, R> extends Command<CDOTransactionContext<CR, MC>, T, R> {

}
