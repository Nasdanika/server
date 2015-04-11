package org.nasdanika.cdo.web;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.web.HttpContext;

public interface CDOTransactionHttpContext<CR> extends CDOTransactionContext<CR>, HttpContext {

}
