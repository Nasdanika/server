package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.Arrays;

import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Persona;
import org.nasdanika.story.Protagonist;
import org.nasdanika.web.HttpServletRequestContext;

class PersonaDocumentationGenerator extends UserDocumentationGenerator<Persona> {

	PersonaDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/user_gray.png";
	}

}
