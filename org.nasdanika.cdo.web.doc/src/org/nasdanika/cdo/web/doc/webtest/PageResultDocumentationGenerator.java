package org.nasdanika.cdo.web.doc.webtest;

import org.nasdanika.html.Fragment;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.PageResult;

class PageResultDocumentationGenerator extends DescriptorDocumentationGenerator<PageResult> {

	PageResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	protected String getIcon(PageResult pageResult) {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/page.png";
	}

	@Override
	protected Fragment getIndex(PageResult obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURI, urlPrefix, path);		
		
//		getCoverage()
//		getResults()
//		getWebElements()
//		isProxy()		
		
		return ret;
	}
	
	@Override
	protected Type getType(Descriptor obj) {
		return Type.CLASS;
	}

}
