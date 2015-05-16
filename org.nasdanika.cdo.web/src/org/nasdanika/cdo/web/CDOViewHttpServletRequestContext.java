package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.web.HttpServletRequestContext;

public interface CDOViewHttpServletRequestContext<CR> extends CDOViewContext<CDOView, CR>, HttpServletRequestContext {

}
