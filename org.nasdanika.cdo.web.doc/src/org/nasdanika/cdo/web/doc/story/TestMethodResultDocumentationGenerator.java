package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.webtest.model.TestMethodResult;

public class TestMethodResultDocumentationGenerator extends OperationResultDocumentationGenerator<TestMethodResult> {

	protected TestMethodResultDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/flask.png";
	}

}
