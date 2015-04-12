package org.nasdanika.core;

public interface FacadeContextProvider<C extends Context> {
	
	<MC> C createContext(MC masterContext);

}
