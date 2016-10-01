package org.nasdanika.cdo.web.doc.webtest;

import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.PageMethodResult;

class PageMethodResultDocumentationGenerator extends OperationResultDocumentationGenerator<PageMethodResult> {

	protected PageMethodResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	protected Type getType(Descriptor obj) {
		return Type.METHOD; // Constructor ??? if <init>
	}
	
}
