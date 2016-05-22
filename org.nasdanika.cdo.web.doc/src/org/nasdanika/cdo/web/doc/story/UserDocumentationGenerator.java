package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.story.User;

class UserDocumentationGenerator<T extends User> extends ActorDocumentationGenerator<T> {

	UserDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/user.png";
	}

}
