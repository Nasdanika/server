package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.story.Persona;

class PersonaDocumentationGenerator extends UserDocumentationGenerator<Persona> {

	PersonaDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/user_gray.png";
	}

}
