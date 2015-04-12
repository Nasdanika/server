package org.nasdanika.core;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Helper class which loads adapters from extensions and services.
 * @author Pavel
 *
 */
public class AdapterManager implements AutoCloseable, Adaptable {
	
	private ServiceTracker<AdapterProvider<?,?>, AdapterProvider<?,?>> adapterProviderServiceTracker;
	
	private Map<Class<?>, Object> adapterMap = new ConcurrentHashMap<>();

	private Object target;
	
	public AdapterManager(Object target, BundleContext context, String adapterProviderServiceFilter) throws Exception {
		this.target = target;
		if (context==null) {
			context = FrameworkUtil.getBundle(target.getClass()).getBundleContext();
		}
		if (context!=null) {
			if (adapterProviderServiceFilter==null || adapterProviderServiceFilter.trim().length()==0) {
				adapterProviderServiceTracker = new ServiceTracker<>(context, AdapterProvider.class.getName(), null);
			} else {
				String apServiceFilter = "(&(" + Constants.OBJECTCLASS + "=" + AdapterProvider.class.getName() + ")"+adapterProviderServiceFilter+")";
				adapterProviderServiceTracker = new ServiceTracker<>(context, context.createFilter(apServiceFilter), null);
			}
			adapterProviderServiceTracker.open();
		}
	}
	
	/**
	 * Adapts target object passed to the constructor to given type.
	 * @param targetType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		Object adapter = adapterMap.get(targetType);
		if (adapter != null) {
			return (T) adapter;
		}
	
		// Extensions first.			
		for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor(ADAPTER_ID)) {
			if ("adapter".equals(ce.getName())) {
				IContributor contributor = ce.getContributor();		
				Bundle bundle = Platform.getBundle(contributor.getName());
				String typeStr = ce.getAttribute("type");
				if (CoreUtil.isBlank(typeStr)) {
					typeStr = ce.getAttribute("class");
				}
				Class<Object> type = (Class<Object>) bundle.loadClass(typeStr.trim());
				if (targetType.isAssignableFrom(type)) {
					Class<Object> adapterClass = (Class<Object>) bundle.loadClass(ce.getAttribute("class").trim());
					// Look for a single argument constructor first
					for (Constructor<?> c: adapterClass.getConstructors()) {
						Class<?>[] pt = c.getParameterTypes();
						if (pt.length==1) {
							if (pt[0].isInstance(target)) {
								adapter = CoreUtil.injectProperties(ce, (T) c.newInstance(target));
								adapterMap.put(targetType, adapter);
								return (T) adapter;
							}
							
							// Potential for infinite loops if there is a cycle in constructor parameter types and adapter types.
							if (target instanceof Adaptable) {
								Object adaptedTarget = ((Adaptable) target).adapt(pt[0]);  
								if (adaptedTarget!=null) {
									adapter = CoreUtil.injectProperties(ce, (T) c.newInstance(adaptedTarget));
									adapterMap.put(targetType, adapter);
									return (T) adapter;
								}
							}
						}
					}
					
					// Default constructor
					for (Constructor<?> c: adapterClass.getConstructors()) {
						if (c.getParameterTypes().length==0) {
							adapter = CoreUtil.injectProperties(ce, (T) c.newInstance());
							adapterMap.put(targetType, adapter);
							return (T) adapter;
						}
					}
				}
			}
		}
		
		if (adapterProviderServiceTracker != null) {
			// TODO - iterate over the getTracked(), match profiles.
			for (Object c : adapterProviderServiceTracker.getServices()) {
				AdapterProvider<Object, Object> provider = (AdapterProvider<Object, Object>) c;
				if (targetType.isAssignableFrom(provider.getAdapterType())
						&& provider.getTargetType() != null
						&& provider.getTargetType().isInstance(target)) {
					adapter = provider.createAdapter(target);
					if (adapter != null) {
						adapterMap.put(targetType, adapter);
						return (T) adapter;
					}
				}
			}
		}
		
		return (T) adapter;
	}
			
	public static final String ADAPTER_ID = "org.nasdanika.core.adapter";
	
	@Override
	public void close() throws Exception {
		for (Object a: adapterMap.values()) {
			if (a instanceof AutoCloseable) {
				try {
					((AutoCloseable) a).close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			adapterProviderServiceTracker.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
}
