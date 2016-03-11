package org.nasdanika.cdo.web.routes;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.Tracker;
import org.nasdanika.core.Tracker.Entry;
import org.nasdanika.web.Action;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.ValueAction;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

/**
 * Tracks route services with "eobject" type property, and 
 * "eobject-route" and "eobject-resource-route" extensions.
 * 
 * @author Pavel Vlasov
 *
 */
public class EObjectRouteTracker {
	
	private Tracker<Route> routeTracker;
	private ExtensionTracker routeExtensionTracker;
	
	private static final String TARGET_NAMESPACE_URI_ATTRIBUTE  = "target-namespace-uri";
	private static final String TARGET_ATTRIBUTE  = "target";
	private static final String RESOURCE_ATTRIBUTE  = "resource";
	private static final String CONTENT_TYPE_ATTRIBUTE  = "content-type";
	private static final String PRIORITY_ATTRIBUTE  = "priority";
	private static final String METHOD_ATTRIBUTE  = "method";
	private static final String PATH_ATTRIBUTE  = "path";
	private static final String PATTERN_ATTRIBUTE  = "pattern";
	private static final String CONSUMES_ATTRIBUTE  = "consumes";
	private static final String PRODUCES_ATTRIBUTE  = "produces";
	
	private class ResourceRouteEntry {
		private String contributor;
		private String resource;
		private String targetNamespaceUri;
		private String target;
		private String priority;
		private String path;
		private String pattern;
		private String contentType;
		private String description;
		private String descriptionContentType;
		
		ResourceRouteEntry(
				String contributor,
				String resource, 
				String targetNamespaceUri, 
				String target, 
				String priority,
				String path, 
				String pattern, 
				String contentType,
				String description,
				String descriptionContenType) {
			
			super();
			this.contributor = contributor;
			this.resource = resource;
			this.targetNamespaceUri = targetNamespaceUri;
			this.target = target;
			this.priority = priority;
			this.path = path;
			this.pattern = pattern;
			this.contentType = contentType;
			this.description = description;
			this.descriptionContentType = descriptionContenType;
		}
						
	}
	
	private Collection<ResourceRouteEntry> resourceRoutes = new ArrayList<>();
	
	public EObjectRouteTracker(BundleContext bundleContext) throws InvalidSyntaxException {
		routeTracker = new Tracker<Route>(
				Route.class, 
				bundleContext,
				"(type=eobject)",
				ExtensionManager.ROUTE_ID,
				"eobject-route",
				"class");
		
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		routeExtensionTracker = new ExtensionTracker(extensionRegistry);
    	IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(ExtensionManager.ROUTE_ID);   
    	
    	IExtensionChangeHandler extensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
    		public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				try {
	    				if ("eobject-resource-route".equals(ce.getName())) {
	    					String description = null;
	    					String descriptionContentType = "text/markdown";
	    					String descriptionAttribute = ce.getAttribute("description");
							if (!CoreUtil.isBlank(descriptionAttribute)) {
	    						URL descriptionResource = Platform.getBundle(ce.getContributor().getName()).getEntry(descriptionAttribute);
	    						if (descriptionResource!=null) {
	    							description = CoreUtil.stringify(descriptionResource);
	    							if (descriptionAttribute.toLowerCase().endsWith(".txt")) {
	    								descriptionContentType = "text/plain";
	    							} else if (descriptionAttribute.toLowerCase().endsWith(".html") || descriptionAttribute.toLowerCase().endsWith(".htm")) {
	    								descriptionContentType = "text/html";
	    							}
	    						}
	    					}
	    						    					
    						ResourceRouteEntry resourceEntry = new ResourceRouteEntry(
    								ce.getContributor().getName(), 
    								ce.getAttribute(RESOURCE_ATTRIBUTE), 
    								ce.getAttribute(TARGET_NAMESPACE_URI_ATTRIBUTE), 
    								ce.getAttribute(TARGET_ATTRIBUTE), 
    								ce.getAttribute(PRIORITY_ATTRIBUTE), 
    								ce.getAttribute(PATH_ATTRIBUTE), 
    								ce.getAttribute(PATTERN_ATTRIBUTE), 
    								ce.getAttribute(CONTENT_TYPE_ATTRIBUTE),
    								description,
    								descriptionContentType);
    						
	    					synchronized (resourceRoutes) {
								resourceRoutes.add(resourceEntry);
	    					}

	    					tracker.registerObject(extension, resourceEntry, IExtensionTracker.REF_WEAK);
	    				}
    				} catch (Exception e) {
    					// TODO - proper logging
    					System.err.println("Error adding resource route");
    					e.printStackTrace();
    				}
    			}
    		}
    		
 			@Override
    		public void removeExtension(IExtension extension, Object[] objects) {
    			synchronized (resourceRoutes) {
	    			for (Object obj: objects) {
	    				resourceRoutes.remove(obj);
	    			}
    			}
			}
    		
    	};    	
    	
		routeExtensionTracker.registerHandler(extensionChangeHandler, ExtensionTracker.createExtensionPointFilter(extensionPoint));
		for (IExtension ex: extensionPoint.getExtensions()) {
			extensionChangeHandler.addExtension(routeExtensionTracker, ex);
		}
	}
		
	public interface RouteEntry {
		
		/**
		 * @return EClass this route entry matches.
		 */
		EClass getEClass();
		
		String getDescription();
		
		String getDescriptionContentType();
		
		Route getRoute();
		
		RequestMethod[] getMethods();
		
		/**
		 * @return Content type which the route produces.
		 */
		String getContentType();
		
		/**
		 * @return Request content types which this route consumes or null if it consumes any content type.
		 * Content types can have wildcards, e.g. <code>text/*</code>
		 */
		String[] getConsumes();
		
		String getPath();
		
		String getPattern();
		
		int getPriority();
		
		/**
		 * @return Inheritance distance between the EClass for which route entry was requested and the EClass for
		 * which service/extension was defined.
		 */
		int getDistance();
		
	}
	
	/**
	 * Collects route entries matching given EClass. 
	 * @param eClass
	 * @return A list of matched route entries. A new modifiable list is returned, so clients can, for example, sort it. 
	 */
	public List<RouteEntry> match(EClass eClass) {
		ArrayList<RouteEntry> accumulator = new ArrayList<RouteEntry>();
		match(eClass, accumulator, new HashSet<EClass>(), 0);
		return accumulator;
	}
	
	private void match(final EClass eClass, ArrayList<RouteEntry> accumulator, HashSet<EClass> traversed, final int distance) {
		if (traversed.add(eClass)) {
			// service/ext
			for (final Entry<Route> rte: routeTracker.getEntries()) {
				if (eClass.getEPackage().getNsURI().equals(rte.getProperty(TARGET_NAMESPACE_URI_ATTRIBUTE)) && eClass.getName().equals(rte.getProperty(TARGET_ATTRIBUTE))) {
					accumulator.add(new RouteEntry() {
						
						@Override
						public Route getRoute() {
							return rte.getInstance();
						}
						
						@Override
						public int getPriority() {
							Object priorityProp = rte.getProperty(PRIORITY_ATTRIBUTE);
							if (priorityProp==null) {
								return 0;
							}
							
							if (priorityProp instanceof Number) {
								return ((Number) priorityProp).intValue();
							}
							
							return Integer.parseInt(priorityProp.toString());
						}
						
						@Override
						public String getPattern() {
							Object patternProp = rte.getProperty(PATTERN_ATTRIBUTE);
							return patternProp instanceof String ? (String) patternProp : null;
						}
						
						@Override
						public String getPath() {
							Object pathProp = rte.getProperty(PATH_ATTRIBUTE);
							return pathProp instanceof String ? (String) pathProp : null;
						}
						
						@Override
						public RequestMethod[] getMethods() {
							Object methodProp = rte.getProperty(METHOD_ATTRIBUTE);
							if (methodProp instanceof String) {
								if ("*".equals(methodProp.toString().trim())) {
									return RequestMethod.values();
								}
								return new RequestMethod[] {RequestMethod.valueOf(methodProp.toString())};
							}
							if (methodProp instanceof String[]) {
								String[] ma = (String[]) methodProp; 
								RequestMethod[] ret = new RequestMethod[ma.length];
								for (int i = 0; i<ma.length; ++i) {
									ret[i] = RequestMethod.valueOf(ma[i]);
								}
								return ret;
							}
							return RequestMethod.values();
						}
						
						@Override
						public EClass getEClass() {
							return eClass;
						}
						
						@Override
						public String getDescriptionContentType() {
							return rte.getDescriptionContentType();
						}
						
						@Override
						public String getDescription() {
							return rte.getDescription();
						}
						
						@Override
						public String getContentType() {
							Object ctProp = rte.getProperty(PRODUCES_ATTRIBUTE);
							return ctProp instanceof String ? (String) ctProp : null;
						}

						@Override
						public String[] getConsumes() {
							Object cProp = rte.getProperty(CONSUMES_ATTRIBUTE);
							if (cProp instanceof String[]) {
								return (String[]) cProp;
							}
							if (cProp instanceof String && !CoreUtil.isBlank(cProp.toString())) {
								return ((String) cProp).split(",");
							}
							return null;
						}

						@Override
						public int getDistance() {
							return distance;
						}
					});
				}
			}
			
			// resource
			synchronized (resourceRoutes) {
				for (final ResourceRouteEntry rre: resourceRoutes) {
					if (eClass.getEPackage().getNsURI().equals(rre.targetNamespaceUri) && eClass.getName().equals(rre.target)) {
						accumulator.add(new RouteEntry() {
							
							@Override
							public Route getRoute() {
								return new Route() {

									@Override
									public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
										Bundle bundle = Platform.getBundle(rre.contributor);
										if (bundle==null) {
											return Action.NOT_FOUND;
										}
										// Path is supposed to be consumed by the matcher, remaining path is added to "resource"
										// TODO - refine the algorithm
										String joinedPath = CoreUtil.join(context.getPath(), "/");
										if (!CoreUtil.isBlank(rre.resource)) {
											joinedPath = rre.resource+"/"+joinedPath;
										}
										URL res = bundle.getEntry(joinedPath);
										if (res == null) {
											return Action.NOT_FOUND;
										}
										return new ValueAction(res);
									}

									@Override
									public boolean canExecute() {
										return true;
									}

									@Override
									public void close() throws Exception {
										// NOP
									}
									
								};
							}
							
							@Override
							public int getPriority() {
								return CoreUtil.isBlank(rre.priority) ? 0 : Integer.parseInt(rre.priority);
							}
							
							@Override
							public String getPattern() {
								return rre.pattern;
							}
							
							@Override
							public String getPath() {
								return rre.path;
							}
							
							@Override
							public RequestMethod[] getMethods() {
								return new RequestMethod[] {RequestMethod.GET};
							}
							
							@Override
							public EClass getEClass() {
								return eClass;
							}
							
							@Override
							public String getDescriptionContentType() {
								return rre.descriptionContentType;
							}
							
							@Override
							public String getDescription() {
								return rre.description;
							}
							
							@Override
							public String getContentType() {
								return rre.contentType;
							}

							@Override
							public String[] getConsumes() {
								return null; // Doesn't matter for resources.
							}

							@Override
							public int getDistance() {
								return distance;
							}
						});
					}
				}
			}			
			
			for (EClass sc: eClass.getESuperTypes()) {
				match(sc, accumulator, traversed, distance+1);
			}
		}		
	}

	public void close() {
		if (routeTracker!=null) {
			routeTracker.close();
			routeTracker = null;
		}
		if (routeExtensionTracker!=null) {
			routeExtensionTracker.close();
			routeExtensionTracker = null;
		}
	}
}
