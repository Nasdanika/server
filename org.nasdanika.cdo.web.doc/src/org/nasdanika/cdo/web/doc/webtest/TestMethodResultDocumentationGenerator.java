package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;

import org.nasdanika.html.Fragment;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.ParameterizedTestResult;
import org.nasdanika.webtest.model.TestMethodResult;

public class TestMethodResultDocumentationGenerator extends MethodResultDocumentationGenerator<TestMethodResult> {

	protected TestMethodResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}
	
	@Override
	protected String getIcon(TestMethodResult result) {
		switch (result.getStatus()) {
		case ERROR:
			return "/bundle/org.nasdanika.cdo.web.doc/images/flask_red.png";
		case FAIL:
			return "/bundle/org.nasdanika.cdo.web.doc/images/flask_orange.png";
		case PASS:
			return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/flask.png";		
		case PENDING:
			return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/flask_empty.png";
		}
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/flask.png";		
	}
	
	@Override
	protected Fragment getIndex(TestMethodResult obj, HttpServletRequestContext context, URL baseURL, String urlPrefix,	String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		
		// getParameters()
		
		return ret;
	}

}
