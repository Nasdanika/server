package org.nasdanika.function.cdo;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Context;

public interface CDOTransactionContextFunctionFactory<CR, MC extends Context, P extends CDOTransactionContextPromise<CR, MC, P>> extends org.nasdanika.function.FunctionFactory<CDOTransactionContext<CR,MC>, CDOTransactionContextFunction<CR,MC>, P> {
	
}
