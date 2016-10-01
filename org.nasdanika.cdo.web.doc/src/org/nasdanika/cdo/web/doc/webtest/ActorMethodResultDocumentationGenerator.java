package org.nasdanika.cdo.web.doc.webtest;

import org.nasdanika.webtest.model.ActorMethodResult;
import org.nasdanika.webtest.model.Descriptor;

class ActorMethodResultDocumentationGenerator extends OperationResultDocumentationGenerator<ActorMethodResult> {

	protected ActorMethodResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	protected Type getType(Descriptor obj) {
		return Type.METHOD; // Constructor ??? if <init>
	}
	
}
