package org.nasdanika.cdo.web.doc.story;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.nasdanika.cdo.web.doc.AbstractModelDocumentationGenerator;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.User;

public class StoryDocumentationGenerator extends AbstractModelDocumentationGenerator {
			
	private final List<DocumentationGeneratorEntry> documentationGenerators;
	
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
		
		Collections.sort(tocBuilderRoutes);
		this.documentationGenerators = Collections.unmodifiableList(tocBuilderRoutes);
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
		Resource res = modelResources.get(location);
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
	
}
