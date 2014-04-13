package org.nasdanika.core;

public interface ContextProvider<C extends Context> {
	
	C createContext();

}
