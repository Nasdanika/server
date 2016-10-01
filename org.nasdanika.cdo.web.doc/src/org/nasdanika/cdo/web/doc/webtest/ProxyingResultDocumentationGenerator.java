package org.nasdanika.cdo.web.doc.webtest;

import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.ProxyingResult;

class ProxyingResultDocumentationGenerator extends OperationResultDocumentationGenerator<ProxyingResult> {

	protected ProxyingResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	protected Type getType(Descriptor obj) {
		return Type.CLASS; 
	}
	
}
