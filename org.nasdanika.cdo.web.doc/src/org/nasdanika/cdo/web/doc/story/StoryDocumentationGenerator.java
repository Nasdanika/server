package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.objectpathresolvers.EObjectPathResolver;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.web.CompositeObjectPathResolver;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.ObjectPathResolver;

public class StoryDocumentationGenerator implements AutoCloseable {
	
	private static final String MODEL_PATH = "model";

	private static class TocBuilderRouteEntry implements Comparable<TocBuilderRouteEntry> {
		
		private EClass eClass;
		private TocBuilderRoute<Object> tocBuilderRoute;

		@SuppressWarnings("unchecked")
		public TocBuilderRouteEntry(EClass eClass, TocBuilderRoute<?> tocBuilderRoute) {
			this.eClass = eClass;
			this.tocBuilderRoute = (TocBuilderRoute<Object>) tocBuilderRoute;
		}

		@Override
		public int compareTo(TocBuilderRouteEntry o) {
			if (eClass == o.eClass) {
				return 0;
			}
			
			if (eClass.isSuperTypeOf(o.eClass)) {
				return 1;
			}
			
			if (o.eClass.isSuperTypeOf(eClass)) {
				return -1;
			}
			
			return eClass.hashCode() - o.eClass.hashCode();
		}
		
	}
	
	private ObjectPathResolver<Resource> resourcePathResolver = new ObjectPathResolver<Resource>() {
		
		@Override
		public String resolve(Resource obj, ObjectPathResolver<Object> master, Context context) throws Exception {
			for (Entry<String, Resource> sre: storyResources.entrySet()) {
				if (sre.getValue() == obj) {
					return DocRoute.STORY_PATH+MODEL_PATH+"/"+sre.getKey();
				}
			}
			return master.resolve(obj, master, context);
		}
		
	};
	
	private EObjectPathResolver eObjectPathResolver = new EObjectPathResolver();
	
	private CompositeObjectPathResolver objectPathResolver = new CompositeObjectPathResolver();
	
	private final List<TocBuilderRouteEntry> tocBuilderRoutes;
	
	{
		List<TocBuilderRouteEntry> tocBuilderRoutes = new ArrayList<>();
		tocBuilderRoutes.add(new TocBuilderRouteEntry(StoryPackage.eINSTANCE.getCatalog(), new CatalogTocBuilderRoute(this)));
		
		Collections.sort(tocBuilderRoutes);
		this.tocBuilderRoutes = Collections.unmodifiableList(tocBuilderRoutes);

		objectPathResolver.addResolver(EObject.class, eObjectPathResolver);
		objectPathResolver.addResolver(Resource.class, resourcePathResolver);
	}
	
	TocBuilderRoute<Object> getTocBuilderRoute(EClass eClass) {
		for (TocBuilderRouteEntry tcr: tocBuilderRoutes) {
			if (tcr.eClass.isSuperTypeOf(eClass)) {
				return tcr.tocBuilderRoute;
			}
		}
		return null;
	}

	private Map<String, Resource> storyResources;
	private Map<String, Resource> testResultResources;
	private ResourceSetImpl resourceSet;

	private DocRoute docRoute;

	public StoryDocumentationGenerator(DocRoute docRoute, Collection<String> storyModels, Collection<String> testResultModels) {
		this.docRoute = docRoute;
		
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
				TocBuilderRoute<Object> tocBuilderRoute = getTocBuilderRoute(root.eClass());
				if (tocBuilderRoute != null) {
					tocBuilderRoute.createToc(root, storyToc);
				}
			}
		}		
		if (storyToc.getChildren().isEmpty()) {
			tocRoot.getChildren().remove(storyToc);
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
	
	public void createEClassTocEntries(EClass eClass, TocNode cToc) {
		for (Resource sr: storyResources.values()) {
			TreeIterator<EObject> cit = sr.getAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				if (next instanceof Protagonist && ((Protagonist) next).getLinkTo() == eClass) { // superclass relationship?
					TocBuilderRoute<Object> ptbr = getTocBuilderRoute(((Protagonist) next).eClass());
					if (ptbr != null) {
						ptbr.createToc(next, cToc);
					}
				}				
			}
		}
	}	
	
	String getObjectPath(EObject eObject) throws Exception {
		return objectPathResolver.resolve(eObject, null, new ContextImpl(docRoute.getBundleContext()));		
	}
	
	public Object getContent(HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
//		String[] path = context.getPath();
//		System.out.println(Arrays.toString(path));
//		if (path.length > 1) {
//			
//		}
		// TODO Auto-generated method stub
		return path;
	}

	@Override
	public void close() throws Exception {
		for (TocBuilderRouteEntry tbr: tocBuilderRoutes) {
			tbr.tocBuilderRoute.close();
		}
	}

}
