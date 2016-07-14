package org.nasdanika.cdo.web.doc.webtest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;
import org.nasdanika.cdo.web.doc.AbstractModelDocumentationGenerator;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.TestSuiteResult;

public class TestResultsDocumentationGenerator extends AbstractModelDocumentationGenerator {
			
	private final List<DocumentationGeneratorEntry> documentationGenerators;
	
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
	
	public TestResultsDocumentationGenerator(DocRoute docRoute, Collection<String> testResultsModels) {
		super(docRoute, testResultsModels);
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
	
}
