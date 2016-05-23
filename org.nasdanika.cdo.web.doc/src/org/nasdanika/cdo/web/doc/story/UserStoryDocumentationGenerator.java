package org.nasdanika.cdo.web.doc.story;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.story.Story;

class UserStoryDocumentationGenerator extends CatalogElementDocumentationGenerator<Story> {

	UserStoryDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/document_notes.png";
	}

	@Override
	protected Collection<? extends EObject> getTocChildren(Story story) {
		return story.getScenarios();
	}

}
