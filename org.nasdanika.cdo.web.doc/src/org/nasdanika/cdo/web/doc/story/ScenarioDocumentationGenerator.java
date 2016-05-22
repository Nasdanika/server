package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.story.Scenario;

class ScenarioDocumentationGenerator extends CatalogElementDocumentationGenerator<Scenario> {

	ScenarioDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/document_todo.png";
	}

	// TODO - link test results.
	
}
