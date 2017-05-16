package org.nasdanika.cdo.web.doc;

import java.net.URISyntaxException;
import java.util.Collection;
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
import org.nasdanika.cdo.web.objectpathresolvers.EObjectPathResolver;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.web.Action;
import org.nasdanika.web.CompositeObjectPathResolver;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.ObjectPathResolver;

/**
 * Base class for documentation generators working on EMF models.
 * @author Pavel Vlasov
 *
 */
public abstract class AbstractModelDocumentationGenerator implements AutoCloseable, DocumentationContentProvider {
	
	protected static class DocumentationGeneratorEntry implements Comparable<DocumentationGeneratorEntry>, AutoCloseable {
		
		@Override
		public String toString() {
			return "DocumentationGeneratorEntry [eClass=" + eClass.getName() + ", documentationGenerator="
					+ documentationGenerator + "]";
		}

		private EClass eClass;
		private DocumentationGenerator<Object> documentationGenerator;

		@SuppressWarnings("unchecked")
		public DocumentationGeneratorEntry(EClass eClass, DocumentationGenerator<?> tocBuilderRoute) {
			this.eClass = eClass;
			this.documentationGenerator = (DocumentationGenerator<Object>) tocBuilderRoute;
		}

		@Override
		public int compareTo(DocumentationGeneratorEntry o) {
			if (eClass == o.eClass) {
				return 0;
			}
			
			if (eClass.isSuperTypeOf(o.eClass)) {
				return 1;
			}
			
			if (o.eClass.isSuperTypeOf(eClass)) {
				return -1;
			}
			
			return eClass.getName().compareTo(o.eClass.getName());
		}

		@Override
		public void close() throws Exception {
			if (documentationGenerator instanceof AutoCloseable) {
				((AutoCloseable) documentationGenerator).close();
			}			
		}
		
	}
		
	protected abstract List<DocumentationGeneratorEntry> getDocumentationGenerators();
		
	public DocumentationGenerator<Object> getDocumentationGenerator(EClass eClass) {
		for (DocumentationGeneratorEntry tcr: getDocumentationGenerators()) {
			if (tcr.eClass.isSuperTypeOf(eClass)) {
				return tcr.documentationGenerator;
			}
		}
		return null;
	}

	protected Map<String, Resource> modelResources;
	protected Map<EObject, String> modelElementToPathMap = new HashMap<>();
	protected ResourceSetImpl resourceSet;

	private DocRoute docRoute;
	
	public DocRoute getDocRoute() {
		return docRoute;
	}

	public AbstractModelDocumentationGenerator(DocRoute docRoute, Collection<String> modelLocations) {
		this.docRoute = docRoute;
		
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put(StoryPackage.eNS_URI, StoryPackage.eINSTANCE);

		modelResources = new HashMap<>();
		
		synchronized (modelLocations) {
			for (String modelLocation: modelLocations) {
				try {
					Resource model = resourceSet.getResource(URI.createPlatformPluginURI(modelLocation, true), true);
					modelResources.put(modelLocation, model);
					mapModelContent(modelLocation, model, docRoute);
				} catch (Exception e) {
					System.err.println("[ERROR] Could not load story model "+modelLocation+": "+e);
					e.printStackTrace();
				}
			}
		}
	}
	
	protected abstract String getModelPath();

	private void mapModelContent(final String modelLocation, final Resource model, DocRoute docRoute) {
		ObjectPathResolver<Resource> resourcePathResolver = new ObjectPathResolver<Resource>() {
			
			@Override
			public String resolve(Resource obj, ObjectPathResolver<Object> master, Context context) throws Exception {
				if (model == obj) {
					return getModelPath()+"/"+modelLocation;
				}
				return master.resolve(obj, master, context);
			}
			
		};
		
		Context context = new ContextImpl(docRoute.getBundleContext());
		CompositeObjectPathResolver objectPathResolver = new CompositeObjectPathResolver();
		objectPathResolver.addResolver(EObject.class, new EObjectPathResolver());
		objectPathResolver.addResolver(Resource.class, resourcePathResolver);		

		TreeIterator<EObject> cit = model.getAllContents();
		while (cit.hasNext()) {
			try {
				EObject obj = cit.next();
				String path = objectPathResolver.resolve(obj, null, context);
				modelElementToPathMap.put(obj, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected abstract String getTocRootName();

	public void createRootTocEntries(TocNode tocRoot) {
		TocNode modelToc = tocRoot.createChild(getTocRootName(), null, null, null, null, null, false);
		for (Resource storyResource: modelResources.values()) {
			for (EObject root: storyResource.getContents()) {
				DocumentationGenerator<Object> tocBuilderRoute = getDocumentationGenerator(root.eClass());
				if (tocBuilderRoute != null) {
					tocBuilderRoute.createToc(root, modelToc);
				}
			}
		}		
		if (modelToc.getChildren().isEmpty()) {
			tocRoot.getChildren().remove(modelToc);
		}
	}
		
	public String getObjectPath(EObject eObject) throws Exception {
		return modelElementToPathMap.get(eObject);		
	}
	
	public Object getContent(HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) {		
		if (path.startsWith(getModelPath()+"/")) {
			Entry<EObject, String> entry = null;
			for (Entry<EObject, String> candidate: modelElementToPathMap.entrySet()) {
				if (path.startsWith(candidate.getValue()+"/") && (entry == null || entry.getValue().length() < candidate.getValue().length())) {
					entry = candidate;
				}				
			}
			
			if (entry != null) {
				int offset = entry.getValue().split("/").length;
				DocumentationGenerator<Object> sedg = getDocumentationGenerator(entry.getKey().eClass());
				if (sedg != null) {
					try {
						// Maybe shift path as well.
						return sedg.getContent(
								entry.getKey(),
								context == null ? context : context.shift(offset), 
								baseURI, 
								urlPrefix, 
								path);
					} catch (Exception e) {
						e.printStackTrace();
						return Action.INTERNAL_SERVER_ERROR;
					}
				}				
			}
			return Action.NOT_FOUND;
		} 
		return Action.NOT_FOUND;
	}

	@Override
	public void close() throws Exception {
		for (DocumentationGeneratorEntry tbr: getDocumentationGenerators()) {			
			tbr.close();
		}
	}
	
	public java.net.URI getModelUri(EObject modelElement) throws URISyntaxException {
		String modelLocation = getModelLocation(modelElement);
		return modelLocation == null ? null : new java.net.URI(getDocRoute().getDocRoutePath()+DocRoute.BUNDLE_PATH+modelLocation); 
	}
	
	public String getModelLocation(EObject modelElement) {
		for (Entry<String, Resource> trre: modelResources.entrySet()) {
			if (modelElement.eResource() == trre.getValue()) {
				return trre.getKey(); 
			}
		}
		
		return null;		
	}

	
}
