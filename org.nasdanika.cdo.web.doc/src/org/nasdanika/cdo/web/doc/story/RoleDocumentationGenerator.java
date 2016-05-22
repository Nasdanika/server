package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.story.Role;

class RoleDocumentationGenerator extends StoryContainerDocumentationGenerator<Role> {

	RoleDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/user_silhouette.png";
	}

}
