package org.nasdanika.sca;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.ComponentFactory;
import org.nasdanika.core.Context;
import org.osgi.service.component.ComponentContext;

public class BundleResourceComponentFactory implements ComponentFactory {
	
	private ComponentContext componentContext;

	public void activate(org.osgi.service.component.ComponentContext componentContext) {
		this.componentContext = componentContext;
	}

	@Override
	public Component createComponent(Context context, String componentId) throws Exception {
		URL componentURL = componentContext.getBundleContext().getBundle().getResource(componentId+".nasdanikasca");
		if (componentURL==null) {
			return null;
		}
				
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, 
				new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put(ScaPackage.eNS_URI, ScaPackage.eINSTANCE);
		
		URI componentURI = URI.createURI(componentURL.toString());
		Resource resource = resourceSet.getResource(componentURI, true);
		org.nasdanika.sca.AbstractComponent abstractComponent = (AbstractComponent) resource.getContents().get(0);
		return abstractComponent.createRuntimeComponent(componentContext.getBundleContext(), context);
	}

}
