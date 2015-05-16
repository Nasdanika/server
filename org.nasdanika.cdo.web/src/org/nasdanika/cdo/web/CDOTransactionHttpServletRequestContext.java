package org.nasdanika.cdo.web;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.web.HttpServletRequestContext;

public interface CDOTransactionHttpServletRequestContext<CR> extends CDOTransactionContext<CR>, HttpServletRequestContext {

}
