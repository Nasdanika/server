package org.nasdanika.core;

import java.util.Map;

import org.osgi.framework.BundleContext;

/**
 * Simple implementation of context
 * @author Pavel
 *
 */
public class ContextImpl implements Context {
	
	private BundleContext bundleContext;
	private Context[] chain;

	public ContextImpl(BundleContext bundleContext, Context... chain) {
		this.bundleContext = bundleContext;
		this.chain = chain;
	}
	
	private AdapterManager adapterManager;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		if (targetType.isInstance(this)) {
			return (T) this;
		}
		
		for (Context ch: chain) {
			if (ch!=null) {
				if (targetType.isInstance(ch)) {
					return (T) ch;
				}
				T ret = ch.adapt(targetType);
				if (ret!=null) {
					return ret;
				}
			}
		}
		
		synchronized (this) {
			if (adapterManager==null) {
				adapterManager = new AdapterManager(this, bundleContext, null);
			}
		}
		
		return adapterManager.adapt(targetType);
	}

	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return true;
	}
	
	private Converter<Object, Object, Context> converter;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		for (Context ch: chain) {
			if (ch!=null) {
				T ret = ch.convert(source, targetType);
				if (ret!=null) {
					return ret;
				}
			}
		}		
		
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
