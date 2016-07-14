package org.nasdanika.cdo.web.doc.webtest;

import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.MethodResult;

class MethodResultDocumentationGenerator<T extends MethodResult> extends OperationResultDocumentationGenerator<T> {

	protected MethodResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	protected Type getType(Descriptor obj) {
		return Type.METHOD; // Constructor ??? if <init>
	}
	
}
