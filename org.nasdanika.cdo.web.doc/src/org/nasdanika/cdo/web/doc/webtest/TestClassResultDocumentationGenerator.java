package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.ParameterizedTestResult;
import org.nasdanika.webtest.model.TestClassResult;
import org.nasdanika.webtest.model.TestMethodResult;

class TestClassResultDocumentationGenerator extends TestResultDocumentationGenerator<TestClassResult> {

	protected TestClassResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	public void createToc(TestClassResult obj, TocNode parent) {
		if (!obj.getMethodResults().isEmpty()) {
			super.createToc(obj, parent);
		}
	}
	
	@Override
	protected String getTitle(TestClassResult obj) {
		EList<String> parameters = obj.getMethodResults().get(0).getParameters();
		if (obj.eContainer() instanceof ParameterizedTestResult && !parameters.isEmpty()) {
			StringBuilder titleBuilder = new StringBuilder();
			for (String prm: parameters) {
				if (titleBuilder.length() > 0) {
					titleBuilder.append(", ");
				}
				titleBuilder.append(prm);
			}
			return titleBuilder.toString();
		}
		return super.getTitle(obj);
	}		

	@Override
	protected Fragment getIndex(TestClassResult obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		EList<String> parameters = obj.getMethodResults().get(0).getParameters();
		if (obj.eContainer() instanceof ParameterizedTestResult && !parameters.isEmpty()) {
			HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
			Fragment ret = htmlFactory.fragment(header(obj));
	
			// Tabs
	//		Parameters
			links(obj, ret, context, baseURL, urlPrefix);			
			
	//		getMethodResults()
	//		getStats()		
			
			return ret;
		}
		
		//		getMethodResults()
		//		getStats()		
		
		return super.getIndex(obj, context, baseURL, urlPrefix, path);
	}
	
	
	@Override
	protected Collection<? extends EObject> getTocChildren(TestClassResult testResult) {
		return testResult.getMethodResults();
	}

}
