package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.Arrays;

import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Theme;
import org.nasdanika.web.HttpServletRequestContext;

class ThemeDocumentationGenerator extends CatalogElementDocumentationGenerator<Theme> {

	ThemeDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
}
