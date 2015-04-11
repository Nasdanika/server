package org.nasdanika.cdo;

import org.nasdanika.core.Context;

public interface CDOViewContextProvider<CR, C extends CDOViewContext<?, CR>> {

	<MC> C createContext(MC masterContext);

}
