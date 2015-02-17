package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextProvider;

public interface CDOViewContextProvider<CR, MC extends Context> extends ContextProvider<CDOViewContext<CDOView, CR, MC>> {

}
