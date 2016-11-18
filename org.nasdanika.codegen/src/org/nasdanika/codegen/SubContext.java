package org.nasdanika.codegen;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SubContext implements Context {
		
	private Map<Class<?>, Object> services = new HashMap<>();
	private Map<String, Object> properties = new HashMap<>();
	private Context[] parents;
	private ClassLoader classLoader;
	
	public SubContext(Context... parents) {
		this.parents = parents;
	}

	public SubContext set(String name, Object value) {
		if (value == null) {
			properties.remove(name);
		} else {
			properties.put(name, value);
		}
		return this;		
	}
	
	public <T> SubContext set(Class<T> type, T service) {
		if (service == null) {
			services.remove(type);
		} else {
			services.put(type, service);
		}
		return this;				
	}

	@Override
	public Object get(String name) {
		Object ret =  properties.get(name);
		if (ret != null) {
			return ret;
		}
		
		for (Context parent: parents) {
			ret = parent == null ? null : parent.get(name);
			if (ret != null) {
				return ret;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> type) {
		T ret = (T) services.get(type);
		if (ret != null) {
			return ret;
		}
		
		for (Entry<Class<?>, Object> e: services.entrySet()) {
			if (type.isAssignableFrom(e.getKey())) {
				return (T) e.getValue();
			}
		}
		
		for (Context parent: parents) {
			ret = parent == null ? null : parent.get(type);
			if (ret != null) {
				return ret;
			}
		}
		return null;
	}

	@Override
	public ClassLoader getClassLoader() {
		if (classLoader != null) {
			return classLoader;
		}
		
		for (Context parent: parents) {
			ClassLoader ret = parent == null ? null : parent.getClassLoader();
			if (ret != null) {
				return ret;
			}
		}
		return null;
	}
	
	public SubContext setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
		return this;
	}
			
	/**
	 * @return New instance of {@link SubContext} with context as parent.
	 */
	public SubContext createSubContext() {
		return new SubContext(this);
	}
	
	// TODO - Autocloseable - cascade-close sub-contexts (track them) and properties/services.
	
}
