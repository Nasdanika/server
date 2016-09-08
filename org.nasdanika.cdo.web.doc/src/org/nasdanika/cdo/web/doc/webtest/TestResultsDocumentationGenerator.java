package org.nasdanika.cdo.web.doc.webtest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.nasdanika.cdo.web.doc.AbstractModelDocumentationGenerator;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.doc.story.StoryDocumentationGenerator;
import org.nasdanika.cdo.web.doc.story.StoryDocumentationGenerator.Link;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Tag;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.TestSuiteResult;

public class TestResultsDocumentationGenerator extends AbstractModelDocumentationGenerator implements StoryDocumentationGenerator.LinkProvider {
			
	private final List<DocumentationGeneratorEntry> documentationGenerators;
	private StoryDocumentationGenerator storyDocumentationGenerator;
	
	{
		List<DocumentationGeneratorEntry> tocBuilderRoutes = new ArrayList<>();

		tocBuilderRoutes.add(new DocumentationGeneratorEntry(ModelPackage.eINSTANCE.getTestSession(), new TestSessionDocumentationGenerator(this)));		
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(ModelPackage.eINSTANCE.getActorResult(), new ActorResultDocumentationGenerator(this)));		
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(ModelPackage.eINSTANCE.getPageResult(), new PageResultDocumentationGenerator(this)));		
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(ModelPackage.eINSTANCE.getTestClassResult(), new TestClassResultDocumentationGenerator(this)));		
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(ModelPackage.eINSTANCE.getTestSuiteResult(), new TestSuiteResultDocumentationGenerator<TestSuiteResult>(this)));		
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(ModelPackage.eINSTANCE.getParameterizedTestResult(), new ParameterizedTestResultDocumentationGenerator(this)));
		tocBuilderRoutes.add(new DocumentationGeneratorEntry(ModelPackage.eINSTANCE.getTestMethodResult(), new TestMethodResultDocumentationGenerator(this)));		
				
		
		Collections.sort(tocBuilderRoutes);
		this.documentationGenerators = Collections.unmodifiableList(tocBuilderRoutes);
	}
	
	protected java.util.List<DocumentationGeneratorEntry> getDocumentationGenerators() {
		return documentationGenerators;
	};
	
	public TestResultsDocumentationGenerator(
			DocRoute docRoute, 
			Collection<String> testResultsModels,
			StoryDocumentationGenerator storyDocumentationGenerator) {
		super(docRoute, testResultsModels);
		this.storyDocumentationGenerator = storyDocumentationGenerator;
		if (storyDocumentationGenerator != null) {
			storyDocumentationGenerator.setLinkProvider(this);
		}
	}
	
	@Override
	protected String getModelPath() {
		return DocRoute.TEST_RESULTS_PATH+"model";
	}

	@Override
	protected String getTocRootName() {
		return "Test results";
	}
		
	String resolveScreenshotLocation(Screenshot screenshot) throws URISyntaxException {
		for (Entry<String, Resource> trre: modelResources.entrySet()) {
			if (screenshot.eResource() == trre.getValue()) {
				java.net.URI uri = new java.net.URI(getDocRoute().getDocRoutePath()+DocRoute.BUNDLE_PATH+trre.getKey()); 
				return uri.resolve(screenshot.getLocation()).toASCIIString();
			}
		}
		
		return null;		
	}
	
	private static boolean match(EClass eClass, String str) {
		if (CoreUtil.isBlank(str)) {
			return true;
		}
		
		String linkTypeStr = eClass.getName()+"@"+eClass.getEPackage().getNsURI();
		if (linkTypeStr.equals(str)) {
			return true;
		}
		
		for (EClass sc: eClass.getESuperTypes()) {
			if (match(sc, str)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<Link> getLinks(EClass linkType, String location) {
		List<Link> ret = new ArrayList<>();
		TreeIterator<Notifier> cit = resourceSet.getAllContents();
		while (cit.hasNext()) {
			Notifier next = cit.next();
			if (next instanceof Descriptor) {
				for (org.nasdanika.webtest.model.Link link: ((Descriptor) next).getLinks()) {
					if (link.getValue().equals(location) && match(linkType, link.getType())) {
						TocNode nextToc = getDocRoute().findToc(next);
						if (nextToc != null) {
							Tag ref = nextToc.getLink(getDocRoute().getDocRoutePath());
							
							ret.add(new Link() {
								
								@Override
								public Tag getLink() {
									return ref;
								}
	
								@Override
								public EClass getType() {
									return ((EObject) next).eClass();
								}
	
								@Override
								public String getComment() {
									return link.getComment();
								}
								
							});
						}
					}
				}
			}
		}
		return ret;
	}	
	
	EObject resolveLink(org.nasdanika.webtest.model.Link link) {
		return storyDocumentationGenerator == null ? null : storyDocumentationGenerator.resolveLink(link.getType(), link.getValue());
	}
	
	
}
