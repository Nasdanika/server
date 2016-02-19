package org.nasdanika.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * Tracker is a combination of extension tracker and service tracker for
 * a specific extension/service type. 
 * For extensions the tracker creates an extension and injects properties.
 * It also reads extension/service description from 'description' nested element(s) of extension and 'description' property of service.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public class Tracker<T> {
	
	T extension;
	String description;
		
	private ExtensionTracker extensionTracker;
	private ServiceTracker<T,Entry<T>> serviceTracker;
	
	/**
	 * Tracker entry
	 * @author Pavel Vlasov
	 *
	 * @param <T>
	 */
	public interface Entry<T> {
		
		/**
		 * Description - taken from either extension 'description' sub-elements or service 'description' property.
		 * @return
		 */
		String getDescription();
		
		/**
		 * 
		 * @return Description content type.
		 */
		String getDescriptionContentType();
		
		/**
		 * Service/extension instance.
		 * @return
		 */
		T getInstance();
		
		/**
		 * Entry properies map to service reference properties and configuration element attributes.
		 * @param name
		 * @return Property value.
		 */
		Object getProperty(String name);
		
	}
	
	protected void onEntryAdded(Entry<T> entry) {
		
	}
	
	protected void onEntryRemoved(Entry<T> entry) {
		
	}
	
	public Tracker(
			Class<T> clazz,
			final BundleContext bundleContext,
			String serviceFilter, 
			final String extensionPointID,
			final String configurationElementName,
			final String classAttribute) throws InvalidSyntaxException {

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		extensionTracker = new ExtensionTracker(extensionRegistry);
    	IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(extensionPointID);   
    	
    	IExtensionChangeHandler extensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
    		public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				try {
	    				if (ce.getName().equals(configurationElementName)) {
	    					final StringBuilder descriptionBuilder = new StringBuilder();
	    					final String[] descriptionContentType = {"text/markdown"};
	    					for (IConfigurationElement de: ce.getChildren("description")) {
	    						descriptionBuilder.append(de.getValue());
	    						String dct = ce.getAttribute("content-type");
	    						if (dct!=null) {
		    						if ("HTML".equalsIgnoreCase(dct.trim())) {
		    							descriptionContentType[0] = "text/html";
		    						} else if ("Markdown".equalsIgnoreCase(dct.trim())) {
		    							descriptionContentType[0] = "text/markdown";
		    						} else if ("Text".equalsIgnoreCase(dct.trim())) {
		    							descriptionContentType[0] = "text/plain";
		    						}	    						
	    						}
	    					}
	    					@SuppressWarnings("unchecked")
							final T instance = (T) CoreUtil.injectProperties(ce, ce.createExecutableExtension(classAttribute));
	    					final Map<String, Object> properties = new HashMap<>();
	    					for (String name: ce.getAttributeNames()) {
	    						properties.put(name, ce.getAttribute(name));
	    					}
	    					Entry<T> entry = new Entry<T>() {
	
								@Override
								public String getDescription() {
									return descriptionBuilder.toString();
								}
	
								@Override
								public T getInstance() {
									return instance;
								}

								@Override
								public Object getProperty(String name) {
									return properties.get(name);
								}

								@Override
								public String getDescriptionContentType() {									
									return descriptionContentType[0];
								}
	    						
	    					};
	    					
	    					tracker.registerObject(extension, entry, IExtensionTracker.REF_WEAK);
	    					synchronized (extensionEntries) {
	    						extensionEntries.add(entry);
	    					}
	    					onEntryAdded(entry);
	    				}
    				} catch (Exception e) {
    					// TODO - proper logging
    					System.err.println("Error adding extension "+extensionPointID+"/"+configurationElementName);
    					e.printStackTrace();
    				}
    			}
    		}
    		
    		@SuppressWarnings("unchecked")
			@Override
    		public void removeExtension(IExtension extension, Object[] objects) {
    			synchronized (extensionEntries) {
	    			for (Object obj: objects) {
	    				if (extensionEntries.remove(obj)) {
	    					onEntryRemoved((Entry<T>) obj);
	    				}
	    			}
    			}
			}
    		
    	};    	
    	
		extensionTracker.registerHandler(extensionChangeHandler, ExtensionTracker.createExtensionPointFilter(extensionPoint));
		for (IExtension ex: extensionPoint.getExtensions()) {
			extensionChangeHandler.addExtension(extensionTracker, ex);
		}
		
		if (bundleContext!=null) {
						
			ServiceTrackerCustomizer<T, Entry<T>> customizer = new ServiceTrackerCustomizer<T, Entry<T>>() {

				@Override
				public Entry<T> addingService(final ServiceReference<T> reference) {
					Entry<T> entry = new Entry<T>() {

						@Override
						public String getDescription() {
							Object descr = reference.getProperty("description");
							return descr == null ? null : descr.toString();
						}

						@Override
						public T getInstance() {
							return bundleContext.getService(reference);
						}

						@Override
						public Object getProperty(String name) {
							return reference.getProperty(name);
						}

						@Override
						public String getDescriptionContentType() {
	    					Object descriptionContentType = reference.getProperty("description-content-type");
    						if (descriptionContentType instanceof String) {
	    						if ("HTML".equalsIgnoreCase(((String) descriptionContentType).trim())) {
	    							return "text/html";
	    						} 
	    						if ("Markdown".equalsIgnoreCase(((String) descriptionContentType).trim())) {
	    							return "text/markdown";
	    						}
	    						if ("Text".equalsIgnoreCase(((String) descriptionContentType).trim())) {
	    							return "text/plain";
	    						}	    						
    						}
    						return "text/markdown";
						}
						
					};
					
					onEntryAdded(entry);
					return entry;
				}

				@Override
				public void modifiedService(ServiceReference<T> reference, Entry<T> service) {
					// NOP					
				}

				@Override
				public void removedService(ServiceReference<T> reference, Entry<T> service) {
					onEntryRemoved(service);					
				}
			};
			if (CoreUtil.isBlank(serviceFilter)) {
				serviceTracker = new ServiceTracker<>(bundleContext, clazz.getName(), customizer);
			} else {
				final Filter filter = bundleContext.createFilter("(&(" + Constants.OBJECTCLASS + "=" + clazz.getName() + ")"+serviceFilter+")");
				serviceTracker = new ServiceTracker<>(bundleContext, filter, customizer);
			}
			serviceTracker.open();
		}
		

	}
	
	private Collection<Entry<T>> extensionEntries = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public Collection<Entry<T>> getEntries() {
		Collection<Entry<T>> ret = new ArrayList<>();
		synchronized (extensionEntries) {
			ret.addAll(extensionEntries);
		}
		
		if (serviceTracker!=null) {
			Object[] services = serviceTracker.getServices();
			if (services!=null) {
				for (Object service: services) {
					ret.add((Entry<T>) service);
				}
			}
		}
		
		return ret;
	}
	
	public void close() {
		if (extensionTracker!=null) {
			extensionTracker.close();
			extensionTracker = null;
		}
		if (serviceTracker!=null) {
			serviceTracker.close();
			serviceTracker = null;
		}
	}

}
