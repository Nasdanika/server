package org.nasdanika.cdo.web.doc.story;

import java.net.URL;

import org.nasdanika.html.Fragment;
import org.nasdanika.story.Persona;
import org.nasdanika.web.HttpServletRequestContext;

class PersonaDocumentationGenerator extends UserDocumentationGenerator<Persona> {

	PersonaDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/user_gray.png";
	}
		
	@Override
	protected Fragment getIndex(Persona obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		// TODO - picture, tabs: Goals, links to stories realizing the goals, context diagram
//		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
//		ret.content(htmlFactory.tag(TagName.h4, "Contents"));
//		Table contentTable = htmlFactory.table().bordered();
//		ret.content(contentTable);
//		contentTable.header().headerRow("Element", "Type", "Summary").style(Style.PRIMARY);
//		for (CatalogElement catalogElement: obj.getElements()) {			
//			contentTable.body().row(
//					storyDocumentationGenerator.getDocRoute().findToc(catalogElement).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
//					catalogElement.eClass().getName(),
//					storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(catalogElement.getDescription()));
//		}
		return ret;
	}
	
	// TODO - context diagram
}
