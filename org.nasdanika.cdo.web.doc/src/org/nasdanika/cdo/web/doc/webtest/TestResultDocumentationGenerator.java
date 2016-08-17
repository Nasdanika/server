package org.nasdanika.cdo.web.doc.webtest;

import org.nasdanika.html.Fragment;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.TestResult;

class TestResultDocumentationGenerator<T extends TestResult> extends DescriptorDocumentationGenerator<T> {

	protected TestResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}
			
	@Override
	protected Fragment getIndex(T obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURI, urlPrefix, path);
		
//		getActorResults()
//		getPageResults()		
		
		return ret;
	}
		

	@Override
	protected Type getType(Descriptor obj) {
		return Type.CLASS;
	}

}
