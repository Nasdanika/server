package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.story.System;

class SystemDocumentationGenerator extends ActorDocumentationGenerator<System> {

	SystemDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/server.png";
	}

}
