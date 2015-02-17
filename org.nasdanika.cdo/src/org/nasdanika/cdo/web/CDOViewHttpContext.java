package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.web.HttpContext;

public interface CDOViewHttpContext<CR> extends CDOViewContext<CDOView, CR, CDOViewHttpContext<?>>, HttpContext {

}
