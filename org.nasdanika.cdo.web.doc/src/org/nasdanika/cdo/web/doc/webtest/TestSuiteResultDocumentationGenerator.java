package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.html.Fragment;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.TestSuiteResult;

class TestSuiteResultDocumentationGenerator<T extends TestSuiteResult> extends TestResultDocumentationGenerator<T> {

	protected TestSuiteResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	protected Fragment getIndex(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		
		// getChildren()
		
		return ret;
	}
	
	@Override
	protected Collection<? extends EObject> getTocChildren(T testSuiteResult) {
		return testSuiteResult.getChildren();
	}

}
