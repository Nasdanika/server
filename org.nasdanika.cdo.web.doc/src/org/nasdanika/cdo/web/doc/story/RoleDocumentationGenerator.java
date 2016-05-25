package org.nasdanika.cdo.web.doc.story;

import java.net.URL;

import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.Catalog;
import org.nasdanika.story.CatalogElement;
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
	
	@Override
	protected Fragment getIndex(Role obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		// TODO - tabs: actors in roles, sub-roles, super-roles, context diagram
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
