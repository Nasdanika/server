package org.nasdanika.core;

import java.io.IOException;
import java.net.URL;

public interface ClassLoadingContext extends Context {

	Class<?> loadClass(String name) throws ClassNotFoundException;

	URL getResource(String name);
	
	Iterable<URL> getResources(String name) throws IOException;

}
