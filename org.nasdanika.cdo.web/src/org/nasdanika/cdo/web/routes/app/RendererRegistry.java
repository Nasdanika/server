package org.nasdanika.cdo.web.routes.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.osgi.framework.Bundle;

class RendererRegistry {
	
	static final RendererRegistry INSTANCE = new RendererRegistry();
	
	Renderer<? extends Context, ? extends EObject> getRenderer(EClass eClass) {
		Map<Renderer<?, ?>, Integer> matched = match(eClass);
		int distance = -1;
		Renderer<?,?> matchedRenderer = null;
		for (Entry<Renderer<?, ?>, Integer> me: matched.entrySet()) {
			Integer md = me.getValue();
			if (md == 0) {
				return me.getKey();
			}
			if (matchedRenderer == null || md < distance) {
				matchedRenderer = me.getKey();
			}
		}
		return matchedRenderer == null ? Renderer.INSTANCE : matchedRenderer; 
	}
		
	private ExtensionTracker rendererExtensionTracker;
	
	private static final String NAMESPACE_URI_ATTRIBUTE  = "namespace-uri";
	private static final String ECLASS_NAME_ATTRIBUTE  = "eclass-name";
	
	private class RendererEntry implements Comparable<RendererEntry> {
		private Renderer<?,?> renderer;
		private String namespaceURI;
		private String eClassName;
		
		RendererEntry(
				Renderer<?,?> renderer,
				String namespaceURI,
				String eClassName) {
			
			super();
			this.renderer = renderer;
			this.namespaceURI = namespaceURI;
			this.eClassName = eClassName;
		}
		
		boolean match(EClass eClass) {
			if (CoreUtil.isBlank(eClassName) || eClass.getName().equals(eClassName)) {
				return eClass.getEPackage().getNsURI().equals(namespaceURI);
			}
			return false;
		}

		/**
		 * Entries without eClassName are evaluated after the ones with one.
		 */
		@Override
		public int compareTo(RendererEntry o) {
			if (CoreUtil.isBlank(eClassName)) {
				if (CoreUtil.isBlank(o.eClassName)) {
					return namespaceURI.compareTo(o.namespaceURI);
				}
				return 1;
			}
			if (CoreUtil.isBlank(o.eClassName)) {
				return -1; 
			}
						
			return (namespaceURI+"#"+eClassName).compareTo(o.namespaceURI+"#"+o.eClassName);
		}
						
	}
	
	private List<RendererEntry> renderers = new ArrayList<>();
	
	public RendererRegistry() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		rendererExtensionTracker = new ExtensionTracker(extensionRegistry);
    	IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.cdo.web.renderer");   
    	
    	IExtensionChangeHandler extensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
    		public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				try {
	    				if ("renderer".equals(ce.getName())) {
	    					IContributor contributor = ce.getContributor();
	    					Bundle bundle = Platform.getBundle(contributor.getName());
	    					Class<?> rc = (Class<?>) bundle.loadClass(ce.getAttribute("renderer").trim());
	    					// If renderer class is interface, then it must have INSTANCE field.
    						Renderer<?, ?> renderer = rc.isInterface() ? (Renderer<?, ?>) rc.getField("INSTANCE").get(null) : (Renderer<?, ?>) ce.createExecutableExtension("renderer");
							RendererEntry rendererEntry = new RendererEntry(
    								renderer,
    								ce.getAttribute(NAMESPACE_URI_ATTRIBUTE),
    								ce.getAttribute(ECLASS_NAME_ATTRIBUTE));
    						
	    					synchronized (renderers) {
								renderers.add(rendererEntry);
								Collections.sort(renderers);
	    					}

	    					tracker.registerObject(extension, rendererEntry, IExtensionTracker.REF_WEAK);
	    				}
    				} catch (Exception e) {    					
    					// TODO - proper logging
    					System.err.println("Error adding renderer extension");
    					e.printStackTrace();
    				}
    			}
    		}
    		
 			@Override
    		public void removeExtension(IExtension extension, Object[] objects) {
    			synchronized (renderers) {
	    			for (Object obj: objects) {
	    				renderers.remove(obj);
	    			}
    			}
			}
    		
    	};    	
    	
		rendererExtensionTracker.registerHandler(extensionChangeHandler, ExtensionTracker.createExtensionPointFilter(extensionPoint));
		for (IExtension ex: extensionPoint.getExtensions()) {
			extensionChangeHandler.addExtension(rendererExtensionTracker, ex);
		}
	}
	
	/**
	 * Collects route entries matching given EClass. 
	 * @param eClass
	 * @return A list of matched route entries. A new modifiable list is returned, so clients can, for example, sort it. 
	 */
	Map<Renderer<?,?>, Integer> match(EClass eClass) {
		Map<Renderer<?,?>, Integer> accumulator = new HashMap<>();
		synchronized (renderers) {
			match(eClass, accumulator, new HashSet<EClass>(), 0);
		}
		return accumulator;
	}
	
	private void match(EClass eClass, Map<Renderer<?,?>, Integer> accumulator, HashSet<EClass> traversed, final int distance) {
		if (traversed.add(eClass)) {
			for (RendererEntry rendererEntry: renderers) {
				if (rendererEntry.match(eClass)) {
					if (CoreUtil.isBlank(rendererEntry.eClassName)) {
						accumulator.put(rendererEntry.renderer, distance + 1000000);
					} else {
						accumulator.put(rendererEntry.renderer, distance);
						if (distance == 0) {
							return; // Exact match, no need to search further.
						}
					}
				}				
			}
			int offset = 0;
			for (EClass st: eClass.getESuperTypes()) {
				match(st, accumulator, traversed, distance + 1000 + (offset++)); 
			}
		}		
	}	

}
