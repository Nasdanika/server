package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationContentProvider;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.objectpathresolvers.EObjectPathResolver;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.User;
import org.nasdanika.web.Action;
import org.nasdanika.web.CompositeObjectPathResolver;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.ObjectPathResolver;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.Link;
import org.nasdanika.webtest.model.ModelPackage;

public class StoryDocumentationGenerator implements AutoCloseable, DocumentationContentProvider {
	
	private static final String MODEL_PATH = "model";

	private static class StoryElementDocumentationGeneratorEntry implements Comparable<StoryElementDocumentationGeneratorEntry>, AutoCloseable {
		
		private EClass eClass;
		private StoryElementDocumentationGenerator<Object> storyElementDocumentationGenerator;

		@SuppressWarnings("unchecked")
		public StoryElementDocumentationGeneratorEntry(EClass eClass, StoryElementDocumentationGenerator<?> tocBuilderRoute) {
			this.eClass = eClass;
			this.storyElementDocumentationGenerator = (StoryElementDocumentationGenerator<Object>) tocBuilderRoute;
		}

		@Override
		public int compareTo(StoryElementDocumentationGeneratorEntry o) {
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

		@Override
		public void close() throws Exception {
			if (storyElementDocumentationGenerator instanceof AutoCloseable) {
				((AutoCloseable) storyElementDocumentationGenerator).close();
			}			
		}
		
	}
		
	private final List<StoryElementDocumentationGeneratorEntry> storyElementDocumentationGenerators;
	
	{
		List<StoryElementDocumentationGeneratorEntry> tocBuilderRoutes = new ArrayList<>();
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getCatalog(), new CatalogDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getEpic(), new EpicDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getPersona(), new PersonaDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getRole(), new RoleDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getScenario(), new ScenarioDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getStory(), new UserStoryDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getSystem(), new SystemDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getTheme(), new ThemeDocumentationGenerator(this)));
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(StoryPackage.eINSTANCE.getUser(), new UserDocumentationGenerator<User>(this)));
		
		tocBuilderRoutes.add(new StoryElementDocumentationGeneratorEntry(ModelPackage.eINSTANCE.getTestMethodResult(), new TestMethodResultDocumentationGenerator(this)));
		
		
		Collections.sort(tocBuilderRoutes);
		this.storyElementDocumentationGenerators = Collections.unmodifiableList(tocBuilderRoutes);
	}
	
	StoryElementDocumentationGenerator<Object> getStoryElementDocumentationGenerator(EClass eClass) {
		for (StoryElementDocumentationGeneratorEntry tcr: storyElementDocumentationGenerators) {
			if (tcr.eClass.isSuperTypeOf(eClass)) {
				return tcr.storyElementDocumentationGenerator;
			}
		}
		return null;
	}

	private Map<String, Resource> storyResources;
	private Map<String, Resource> testResultResources;
	private Map<EObject, String> modelElementToPathMap = new HashMap<>();
	private ResourceSetImpl resourceSet;

	private DocRoute docRoute;
	
	DocRoute getDocRoute() {
		return docRoute;
	}

	public StoryDocumentationGenerator(DocRoute docRoute, Collection<String> storyModels, Collection<String> testResultModels) {
		this.docRoute = docRoute;
		
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put(StoryPackage.eNS_URI, StoryPackage.eINSTANCE);

		storyResources = new HashMap<>();
		
		synchronized (storyModels) {
			for (String modelLocation: storyModels) {
				Resource model = resourceSet.getResource(URI.createPlatformPluginURI(modelLocation, true), true);
				storyResources.put(modelLocation, model);
				mapModelContent(modelLocation, model, docRoute);
			}
		}
		
		testResultResources = new HashMap<>();
		
		synchronized (testResultModels) {
			for (String modelLocation: testResultModels) {
				Resource model = resourceSet.getResource(URI.createPlatformPluginURI(modelLocation, true), true);
				testResultResources.put(modelLocation, model);
				mapModelContent(modelLocation, model, docRoute);
			}
		}		
	}

	private void mapModelContent(final String modelLocation, final Resource model, DocRoute docRoute) {
		ObjectPathResolver<Resource> resourcePathResolver = new ObjectPathResolver<Resource>() {
			
			@Override
			public String resolve(Resource obj, ObjectPathResolver<Object> master, Context context) throws Exception {
				if (model == obj) {
					return DocRoute.STORY_PATH+MODEL_PATH+"/"+modelLocation;
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

	public void createRootTocEntries(TocNode tocRoot) {
		TocNode storyToc = tocRoot.createChild("Stories", null, null, null, null);
		for (Resource storyResource: storyResources.values()) {
			for (EObject root: storyResource.getContents()) {
				StoryElementDocumentationGenerator<Object> tocBuilderRoute = getStoryElementDocumentationGenerator(root.eClass());
				if (tocBuilderRoute != null) {
					tocBuilderRoute.createToc(root, storyToc);
				}
			}
		}		
		if (storyToc.getChildren().isEmpty()) {
			tocRoot.getChildren().remove(storyToc);
		}
		
		// TODO - Test results.
	}
	
	private static final Pattern PARENT_ID_TOKEN_PATTERN = Pattern.compile("\\$\\{parent\\}");		
	
	static String resolveCatalogElementID(CatalogElement catalogElement) {
		if (catalogElement == null) {
			return null;
		}
		String id = catalogElement.getId();
		if (CoreUtil.isBlank(id)) {
			return null;
		}
		Matcher matcher = PARENT_ID_TOKEN_PATTERN.matcher(id);
		StringBuilder output = new StringBuilder();
		int i = 0;
		while (matcher.find()) {
			EObject container = catalogElement.eContainer();
			if (!(container instanceof CatalogElement)) {
				return null;
			}
			String parentID = resolveCatalogElementID((CatalogElement) container);
			if (CoreUtil.isBlank(parentID)) {
				return null;
			}
		    output.append(id.substring(i, matcher.start())).append(parentID);			    
		    i = matcher.end();
		}
		output.append(id.substring(i, id.length()));
		return output.toString();
	}
	
	public String findCatalogElement(String location, String id) {
		Resource res = storyResources.get(location);
		if (res != null) {
			TreeIterator<EObject> cit = res.getAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				if (next instanceof CatalogElement && id.equals(resolveCatalogElementID((CatalogElement) next))) {
					return modelElementToPathMap.get(next);
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
				if (next instanceof Protagonist && ((Protagonist) next).getLinkTo() != null) { // superclass relationship?
					EClass linkedTo = ((Protagonist) next).getLinkTo();
					if (linkedTo.getName().equals(eClass.getName()) && linkedTo.getEPackage().getNsURI().equals(eClass.getEPackage().getNsURI())) {
						StoryElementDocumentationGenerator<Object> ptbr = getStoryElementDocumentationGenerator(((Protagonist) next).eClass());
						if (ptbr != null) {
							ptbr.createToc(next, cToc);
						}
					}
				}				
			}
		}
	}	
	
	String getObjectPath(EObject eObject) throws Exception {
		return modelElementToPathMap.get(eObject);		
	}
	
	public Object getContent(HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {		
		if (path.startsWith(DocRoute.STORY_PATH+MODEL_PATH+"/")) {
			Entry<EObject, String> entry = null;
			for (Entry<EObject, String> candidate: modelElementToPathMap.entrySet()) {
				if (path.startsWith(candidate.getValue()+"/") && (entry == null || entry.getValue().length() < candidate.getValue().length())) {
					entry = candidate;
				}				
			}
			
			if (entry != null) {
				int offset = entry.getValue().split("/").length;
				StoryElementDocumentationGenerator<Object> sedg = getStoryElementDocumentationGenerator(entry.getKey().eClass());
				if (sedg != null) {
					try {
						// Maybe shift path as well.
						return sedg.getContent(
								entry.getKey(),
								context == null ? context : context.shift(offset), 
								baseURL, 
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
		for (StoryElementDocumentationGeneratorEntry tbr: storyElementDocumentationGenerators) {			
			tbr.close();
		}
	}

	/**
	 * Finds test results linked to this catalog element
	 * @param 
	 * @return
	 */
	Collection<? extends EObject> findLinkedTestResults(CatalogElement catalogElement) {
		String id = resolveCatalogElementID(catalogElement);
		if (id == null) {
			return Collections.emptyList();
		}
		
		Collection<EObject> ret = new ArrayList<>();
		for (Entry<String, Resource> sre: storyResources.entrySet()) {
			if (catalogElement.eResource() == sre.getValue()) {
				String qualifiedID = sre.getKey()+"#"+id;
				for (Entry<String, Resource> trre: testResultResources.entrySet()) {
					TreeIterator<EObject> trit = trre.getValue().getAllContents();
					while (trit.hasNext()) {
						EObject next = trit.next();
						if (next instanceof Descriptor) {
							for (Link link: ((Descriptor) next).getLinks()) {
								if (catalogElement.eClass().getName().equals(link.getType()) && qualifiedID.equals(link.getValue())) {
									ret.add(next);
								}
							}
						}				
					}			
				}
				
				break;
			}
		}
		
		return ret;
	}

}
