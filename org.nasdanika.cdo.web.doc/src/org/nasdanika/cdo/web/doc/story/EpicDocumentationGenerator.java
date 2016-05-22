package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.story.Epic;

class EpicDocumentationGenerator extends StoryContainerDocumentationGenerator<Epic> {

	EpicDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/book.png";
	}

}
