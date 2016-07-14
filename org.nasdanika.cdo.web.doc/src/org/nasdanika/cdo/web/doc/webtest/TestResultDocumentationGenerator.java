package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;

import org.nasdanika.html.Fragment;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.TestResult;

class TestResultDocumentationGenerator<T extends TestResult> extends DescriptorDocumentationGenerator<T> {

	protected TestResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}
			
	protected Fragment getIndex(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		
//		getActorResults()
//		getPageResults()		
		
		return ret;
	}
		

	@Override
	protected Type getType(Descriptor obj) {
		return Type.CLASS;
	}

}
