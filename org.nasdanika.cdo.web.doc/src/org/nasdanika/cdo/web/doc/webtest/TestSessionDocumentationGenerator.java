package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;

import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Fragment;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.PageResult;
import org.nasdanika.webtest.model.TestResult;
import org.nasdanika.webtest.model.TestSession;

class TestSessionDocumentationGenerator extends DescriptorDocumentationGenerator<TestSession> {

	protected TestSessionDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	public void createToc(TestSession testSession, TocNode parent) {
		try {
			TocNode testSessionNode = parent.createChild(
					testSession.getTitle(), 
					testResultsDocumentationGenerator.getObjectPath(testSession)+"/index.html",
					getIcon(), 
					null,
					obj -> obj == testSession);
			
			if (!testSession.getActorResults().isEmpty()) {
				TocNode actorsNode = testSessionNode.createChild(
						"Actors", 
						null, 
						null, 
						null, 
						null);
				
				for (ActorResult ar: testSession.getActorResults()) {
					DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(ar.eClass());
					if (docGen != null) {
						docGen.createToc(ar, actorsNode);
					}
				}
				if (actorsNode.getChildren().isEmpty()) {
					testSessionNode.getChildren().remove(actorsNode);
				}				
			}
			if (!testSession.getPageResults().isEmpty()) {
				TocNode pagesNode = testSessionNode.createChild(
						"Pages", 
						null, 
						null, 
						null, 
						null);
				
				for (PageResult pr: testSession.getPageResults()) {
					DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(pr.eClass());
					if (docGen != null) {
						docGen.createToc(pr, pagesNode);
					}
				}
				if (pagesNode.getChildren().isEmpty()) {
					testSessionNode.getChildren().remove(pagesNode);
				}				
			}
			if (!testSession.getTestResults().isEmpty()) {
				TocNode testsNode = testSessionNode.createChild(
						"Tests", 
						null, 
						null, 
						null, 
						null);
				
				for (TestResult tr: testSession.getTestResults()) {
					DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(tr.eClass());
					if (docGen != null) {
						docGen.createToc(tr, testsNode);
					}
				}
				if (testsNode.getChildren().isEmpty()) {
					testSessionNode.getChildren().remove(testsNode);
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/zoom.png";
	}
			
	protected Fragment getIndex(TestSession obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		
		ret.content("TODO - node, date, actor results, page results, test results");
		
		return ret;
	}

	@Override
	protected Type getType(Descriptor obj) {
		return Type.CLASS;
	}

}
