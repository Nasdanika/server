package org.nasdanika.cdo;

import org.nasdanika.core.Command;

public interface CDOTransactionCommand<CR, C extends CDOTransactionContext<CR, ?>, R> extends Command<C, R> {

}
