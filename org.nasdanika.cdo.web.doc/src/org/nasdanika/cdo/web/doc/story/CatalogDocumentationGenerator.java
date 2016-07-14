package org.nasdanika.cdo.web.doc.story;

import java.net.URL;

import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.Catalog;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.web.HttpServletRequestContext;

class CatalogDocumentationGenerator extends CatalogElementDocumentationGenerator<Catalog> {

	CatalogDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	public void createToc(Catalog catalog, TocNode parent) {
		try {
			TocNode catalogToc = parent.createChild(
					catalog.getName(), 
					storyDocumentationGenerator.getObjectPath(catalog)+"/index.html",
					getIcon(), 
					null,
					obj->obj == catalog);
			
			for (CatalogElement el: catalog.getElements()) {
				if (el instanceof Protagonist && ((Protagonist) el).getLinkTo() != null) {
					continue;
				}
				DocumentationGenerator<Object> elTocBuilderRoute = storyDocumentationGenerator.getDocumentationGenerator(el.eClass());
				if (elTocBuilderRoute != null) {
					elTocBuilderRoute.createToc(el, catalogToc);
				}
			}
			if (catalogToc.getChildren().isEmpty()) {
				parent.getChildren().remove(catalogToc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/drawer.png";
	}
	
	@Override
	protected Fragment getIndex(Catalog obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		ret.content(htmlFactory.tag(TagName.h4, "Contents"));
		Table contentTable = htmlFactory.table().bordered();
		ret.content(contentTable);
		contentTable.header().headerRow("Element", "Type", "Summary").style(Style.PRIMARY);
		for (CatalogElement catalogElement: obj.getElements()) {			
			contentTable.body().row(
					storyDocumentationGenerator.getDocRoute().findToc(catalogElement).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
					catalogElement.eClass().getName(),
					storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(catalogElement.getDescription()));
		}
		return ret;
	}

}
