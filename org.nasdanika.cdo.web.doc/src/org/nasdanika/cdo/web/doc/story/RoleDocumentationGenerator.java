package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.html.Fragment;
import org.nasdanika.story.Role;
import org.nasdanika.web.HttpServletRequestContext;

class RoleDocumentationGenerator extends StoryContainerDocumentationGenerator<Role> {

	RoleDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/user_silhouette.png";
	}
	
	// TODO - tabs: actors in roles, sub-roles, super-roles, context diagram
//	HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
//	ret.content(htmlFactory.tag(TagName.h4, "Contents"));
//	Table contentTable = htmlFactory.table().bordered();
//	ret.content(contentTable);
//	contentTable.header().headerRow("Element", "Type", "Summary").style(Style.PRIMARY);
//	for (CatalogElement catalogElement: obj.getElements()) {			
//		contentTable.body().row(
//				storyDocumentationGenerator.getDocRoute().findToc(catalogElement).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
//				catalogElement.eClass().getName(),
//				storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(catalogElement.getDescription()));
//	}

	// linkTo, sub-roles, super-roles
	
	// TODO - context diagram
}
