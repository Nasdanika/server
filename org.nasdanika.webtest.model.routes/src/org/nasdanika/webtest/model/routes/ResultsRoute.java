package org.nasdanika.webtest.model.routes;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Route;
import org.nasdanika.webtest.model.ModelPackage;


/**
 * Resolves registered results resource from the path. Path shall be in the form <code>bundle symbolic name/path in the bundle</code>
 * @author Pavel Vlasov
 *
 */
public class ResultsRoute implements Route {
	
	private ResourceSet resourceSet;
	private Map<String, Resource> resultsMap = new ConcurrentHashMap<>();
	private ExtensionTracker extensionTracker;
	
	public ResultsRoute() {
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		extensionTracker = new ExtensionTracker(extensionRegistry);
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.webtest.model.results");  
    	
    	IExtensionChangeHandler extensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
    		public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				if ("result".equals(ce.getName())) {
    					IContributor contributor = ce.getContributor();		
    					String path = contributor.getName()+"/"+ce.getAttribute("location");
						URI uri = URI.createPlatformPluginURI("/"+path, true);
    					Resource resource = resourceSet.getResource(uri, true);
    					resultsMap.put(path, resource);
    					tracker.registerObject(extension, path, IExtensionTracker.REF_WEAK);
    				}
    			}
    		}
    		
 			@Override
    		public void removeExtension(IExtension extension, Object[] objects) {
    			for (Object obj: objects) {
    				resultsMap.remove(obj);
    			}
			}
    		
    	};    	
    	
		extensionTracker.registerHandler(extensionChangeHandler, ExtensionTracker.createExtensionPointFilter(extensionPoint));
		for (IExtension ex: extensionPoint.getExtensions()) {
			extensionChangeHandler.addExtension(extensionTracker, ex);
		}		
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		String[] requestPath = context.getPath();
		String jrp = CoreUtil.join(requestPath, "/");
		for (Entry<String, Resource> re: resultsMap.entrySet()) {
			if (jrp.startsWith(re.getKey()+"/")) {
				return context.getAction(re.getValue(), re.getKey().split("/").length-1, null, args);
			}
		}
		return Action.NOT_FOUND;
	}

	@Override
	public boolean canExecute() {
		return !resultsMap.isEmpty();
	}

	@Override
	public void close() throws Exception {
		extensionTracker.close();
	}

}
