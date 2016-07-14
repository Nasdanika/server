package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.ParameterizedTestResult;

class ParameterizedTestResultDocumentationGenerator extends TestSuiteResultDocumentationGenerator<ParameterizedTestResult> {

	protected ParameterizedTestResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}
	
	@Override
	public void createToc(ParameterizedTestResult obj, TocNode parent) {
		if (!obj.getChildren().isEmpty()) {
			super.createToc(obj, parent);
		}
	}
	
	@Override
	protected String getTitle(ParameterizedTestResult obj) {
		return obj.getChildren().get(0).getTitle();
	}
	
	@Override
	protected Fragment getIndex(ParameterizedTestResult obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Fragment ret = htmlFactory.fragment(header(obj));
		qualifiedName(obj, ret, context, baseURL, urlPrefix, path);		
		description(obj, ret, context, baseURL, urlPrefix);

		// Tabs
//		getParameterDescriptors()
		links(obj, ret, context, baseURL, urlPrefix);
		
		return ret;
	}
	
}
