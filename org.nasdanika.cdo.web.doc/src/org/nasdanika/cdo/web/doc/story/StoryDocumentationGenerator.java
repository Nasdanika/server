package org.nasdanika.cdo.web.doc.story;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.nasdanika.cdo.web.doc.AbstractModelDocumentationGenerator;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Step;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.User;

public class StoryDocumentationGenerator extends AbstractModelDocumentationGenerator {

	public interface Link {
		
		/**
		 * HTML link (anchor)
		 * @return
		 */
		Object getLink();
		
		EClass getType();
		
		String getComment();
		
	}
	
	public interface LinkProvider {
				
		List<Link> getLinks(EClass linkType, String location);
		
	}
	
	private LinkProvider linkProvider;
	
	public void setLinkProvider(LinkProvider linkProvider) {
		this.linkProvider = linkProvider;
	}
	
	List<Link> getLinks(EObject storyElement) {
		if (linkProvider == null) {
			return Collections.emptyList();
		}
		String id = resolveModelElementID(storyElement);
		if (CoreUtil.isBlank(id)) {
			return Collections.emptyList();			
		}
		
		for (Entry<String, Resource> mre: modelResources.entrySet()) {
			if (storyElement.eResource() == mre.getValue()) {
				return linkProvider.getLinks(storyElement.eClass(), mre.getKey()+"#"+id);
			}
		}
				
		return Collections.emptyList();
	}
			
	private final List<DocumentationGeneratorEntry> documentationGenerators;
	private final List<DiagramSpecGenerator> diagramSpecGenerators;
	
	{
		List<DocumentationGeneratorEntry> tocBuilderRoutes = new ArrayList<>();
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getCatalog(), new CatalogDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getEpic(), new EpicDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getPersona(), new PersonaDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getRole(), new RoleDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getScenario(), new ScenarioDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getStory(), new UserStoryDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getSystem(), new SystemDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getTheme(), new ThemeDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.eINSTANCE.getUser(), new UserDocumentationGenerator<User>(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(StoryPackage.Literals.STATE, new StateDocumentationGenerator(this)));
		
		Collections.sort(tocBuilderRoutes);
		this.documentationGenerators = Collections.unmodifiableList(tocBuilderRoutes);
		
		List<DiagramSpecGenerator> dsgl = new ArrayList<>();
		dsgl.add(new ActivityDiagramSpecGenerator(this));
		dsgl.add(new StateHierarchyDiagramSpecGenerator(this));
		dsgl.add(new StateTransitionDiagramSpecGenerator(this));
		dsgl.add(new UseCaseDiagramSpecGenerator(this));
		
		this.diagramSpecGenerators = Collections.unmodifiableList(dsgl);
		
	}
	
	List<DiagramSpecGenerator> getDiagramSpecGenerators() {
		return diagramSpecGenerators;
	}
	
	protected java.util.List<DocumentationGeneratorEntry> getDocumentationGenerators() {
		return documentationGenerators;
	};
	
	public StoryDocumentationGenerator(DocRoute docRoute, Collection<String> storyModels) {
		super(docRoute, storyModels);
	}
	
	@Override
	protected String getModelPath() {
		return DocRoute.STORY_PATH+"model";
	}

	@Override
	protected String getTocRootName() {
		return "Stories";
	}
	
	private static final Pattern PARENT_ID_TOKEN_PATTERN = Pattern.compile("\\$\\{parent\\}");		
	
	static String resolveModelElementID(EObject modelElement) {
		if (modelElement == null) {
			return null;
		}
		String id = null;
		if (modelElement instanceof CatalogElement) {
			id = ((CatalogElement) modelElement).getId();
		} else if (modelElement instanceof Step) {
			id = ((Step) modelElement).getId();			
		}
		if (CoreUtil.isBlank(id)) {
			return null;
		}
		Matcher matcher = PARENT_ID_TOKEN_PATTERN.matcher(id);
		StringBuilder output = new StringBuilder();
		int i = 0;
		while (matcher.find()) {
			EObject container = modelElement.eContainer();
			if (!(container instanceof CatalogElement)) {
				return null;
			}
			String parentID = resolveModelElementID((CatalogElement) container);
			if (CoreUtil.isBlank(parentID)) {
				return null;
			}
		    output.append(id.substring(i, matcher.start())).append(parentID);			    
		    i = matcher.end();
		}
		output.append(id.substring(i, id.length()));
		return output.toString();
	}
	
	/**
	 * Finds model element by ID and type.
	 * @param location Model location.
	 * @param type Model element type in the form <code>Classifier name@package namespace URI</code>. If null, any type matches.
	 * Type can specify a sub-type of the actual element type, e.g. Protagonist would match Actor or User.
	 * @param id Model element ID.
	 * @return Model element path.
	 */
	public String findModelElement(
			String location,
			String type,
			String id) {
		Resource res = modelResources.get(location);
		if (res != null) {
			TreeIterator<EObject> cit = res.getAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				String modelElementID = resolveModelElementID(next);
				if (id.equals(modelElementID)) {
					String path = modelElementToPathMap.get(next);
					if (CoreUtil.isBlank(type)) {
						return path;
					}
					
					int atIdx = type.indexOf("@");
					if (atIdx == -1) {
						return null; // Invalid format
					}
					String classifierName = type.substring(0, atIdx);
					String namespaceURI = type.substring(atIdx+1);
					EClass eClass = next.eClass();
					if (eClass.getName().equals(classifierName) && eClass.getEPackage().getNsURI().equals(namespaceURI)) {
						return path; 
					}
					
					for (EClass sc: eClass.getEAllSuperTypes()) {
						if (sc.getName().equals(classifierName) && sc.getEPackage().getNsURI().equals(namespaceURI)) {
							return path; 
						}						
					}					
				}
			}
		}
		return null;
	}
	
	public void createEClassTocEntries(EClass eClass, TocNode cToc) {
		for (Resource sr: modelResources.values()) {
			TreeIterator<EObject> cit = sr.getAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				if (next instanceof Protagonist && ((Protagonist) next).getLinkTo() != null) { // superclass relationship?
					EClass linkedTo = ((Protagonist) next).getLinkTo();
					if (linkedTo.getName().equals(eClass.getName()) && linkedTo.getEPackage().getNsURI().equals(eClass.getEPackage().getNsURI())) {
						DocumentationGenerator<Object> ptbr = getDocumentationGenerator(((Protagonist) next).eClass());
						if (ptbr != null) {
							ptbr.createToc(next, cToc);
						}
					}
				}				
			}
		}
	}	
	
	public EObject resolveLink(String type, String location) {
		int idx = location.indexOf("#");
		if (idx != -1) {
			Resource res = modelResources.get(location.substring(0, idx));
			if (res != null) {
				EClass eType = null;
				if (!CoreUtil.isBlank(type)) {
					int atIdx = type.indexOf("@");
					if (atIdx == -1) {
						return null;
					}
					EPackage pkg = res.getResourceSet().getPackageRegistry().getEPackage(type.substring(atIdx+1));
					if (pkg == null) {
						return null;
					}
					EClassifier classifier = pkg.getEClassifier(type.substring(0, atIdx));
					if (classifier instanceof EClass) {
						eType = (EClass) classifier;
					} else {
						return null;
					}
				}
				TreeIterator<EObject> rit = res.getAllContents();
				while (rit.hasNext()) {
					EObject next = rit.next();
					String id = resolveModelElementID(next);
					if (!CoreUtil.isBlank(id) && id.equals(location.substring(idx+1)) && (eType == null || eType.isInstance(next))) {
						return next;
					}
				}
			}
		}
		return null;
	}
	
}
