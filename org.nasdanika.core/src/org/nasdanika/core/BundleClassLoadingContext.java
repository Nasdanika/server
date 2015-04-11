package org.nasdanika.core;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.osgi.framework.Bundle;

public class BundleClassLoadingContext extends ContextImpl implements ClassLoadingContext {

	private Bundle bundle;

	public BundleClassLoadingContext(Bundle bundle) {
		this.bundle = bundle;
	}
	
	@Override
	public void close() throws Exception {
		// NOP				
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return bundle.loadClass(name);
	}
	
	@Override
	public Iterable<URL> getResources(String name) throws IOException {
		return Collections.<URL>list(bundle.getResources(name));
	}
	
	@Override
	public URL getResource(String name) {
		return bundle.getResource(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) {					
		return targetType.isInstance(this) ? (T) this : null;
	}

}
