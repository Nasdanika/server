package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.core.Context;

public interface CDOViewContextProvider<V extends CDOView, CR, C extends CDOViewContext<V, CR>> {
	
	C createContext(CDOViewContextSubject<V,CR> subject, Context... chain);

}
