package org.nasdanika.cdo.web.doc.story;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.story.Catalog;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Route;

public class StoryDocumentationGenerator implements Route {

	private Map<String, Resource> storyResources;
	private Map<String, Resource> testResultResources;
	private ResourceSetImpl resourceSet;

	public StoryDocumentationGenerator(Collection<String> storyModels, Collection<String> testResultModels) {
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put(StoryPackage.eNS_URI, StoryPackage.eINSTANCE);

		storyResources = new HashMap<>();
		
		synchronized (storyModels) {
			for (String modelLocation: storyModels) {
				storyResources.put(modelLocation, resourceSet.getResource(URI.createPlatformPluginURI(modelLocation, true), true));
			}
		}
		
		testResultResources = new HashMap<>();
		
		synchronized (testResultModels) {
			for (String modelLocation: testResultModels) {
				testResultResources.put(modelLocation, resourceSet.getResource(URI.createPlatformPluginURI(modelLocation, true), true));
			}
		}		
	}

	public void createRootTocEntries(TocNode tocRoot) {
		TocNode storyToc = tocRoot.createChild("Stories", null, null, null);
		for (Resource storyResource: storyResources.values()) {
			for (EObject root: storyResource.getContents()) {
				if (root instanceof CatalogElement) {
					createCatalogElementToc((CatalogElement) root, storyToc);					
				}
			}
		}		
		if (storyToc.getChildren().isEmpty()) {
			tocRoot.getChildren().remove(storyToc);
		}
	}
	
	private void createCatalogElementToc(CatalogElement catalogElement, TocNode parent) {
		if (catalogElement instanceof Catalog) {
			createCatalogToc((Catalog) catalogElement, parent);
		}		
	}
	
	public String findCatalogElement(String location, String id) {
		Resource res = storyResources.get(location);
		if (res != null) {
			TreeIterator<EObject> cit = res.getAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				if (next instanceof CatalogElement) {
					
				}
			}
		}
		return null;
	}
	
	private void createCatalogToc(Catalog catalog, TocNode parent) {
		TocNode catalogToc = parent.createChild(
				catalog.getName(), 
				null, // TODO
				"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/drawer.png", 
				null);
		
		// TODO - hijos
		
		if (catalogToc.getChildren().isEmpty()) {
			parent.getChildren().remove(catalogToc);
		}
	}	

	public void createEClassTocEntries(EClass eClassifier, TocNode cToc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
