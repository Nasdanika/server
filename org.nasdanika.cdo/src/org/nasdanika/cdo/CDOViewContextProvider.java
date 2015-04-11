package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.core.Context;

public interface CDOViewContextProvider<V extends CDOView, CR, MC extends Context, C extends CDOViewContext<V, CR, MC>> {

	C createContext(MC masterContext);

}
