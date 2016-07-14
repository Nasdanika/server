package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;

import org.nasdanika.html.Fragment;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.Descriptor;

class ActorResultDocumentationGenerator extends DescriptorDocumentationGenerator<ActorResult> {

	ActorResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	protected String getIcon(ActorResult operationResult) {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/user.png";
	}

	protected Fragment getIndex(ActorResult obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);		
		
//		getCoverage()
//		getResults()
//		isProxy()		
		
		return ret;
	}

	@Override
	protected Type getType(Descriptor obj) {
		return Type.CLASS;
	}

}
