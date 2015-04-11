package org.nasdanika.core;

import java.util.Map;

/**
 * Simple implementation of context
 * @author Pavel
 *
 */
public class ContextImpl implements Context {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		if (targetType.isInstance(this)) {
			return (T) this;
		}
		
		return null;
	}

	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return true;
	}
	
	private Converter<Object, Object, Context> converter;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		synchronized (this) {
			if (converter==null) {
				converter = CoreUtil.createConverter();
			}
		}
		return (T) converter.convert(source, (Class<Object>) targetType, this);
	}

	@Override
	public void close() throws Exception {
		if (converter!=null) {
			converter.close();
		}
	}

}
