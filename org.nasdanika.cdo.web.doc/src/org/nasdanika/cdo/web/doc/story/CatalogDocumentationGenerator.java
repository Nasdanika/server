package org.nasdanika.cdo.web.doc.story;

import java.net.URI;

import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
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
	protected void indexTabs(
			Catalog obj, 
			HttpServletRequestContext context, 
			URI baseURI, 
			String urlPrefix, 
			String path,
			Tabs tabs) {

		descriptionTab(obj, context, baseURI, urlPrefix, path, tabs);
		contentTab(obj, context, baseURI, urlPrefix, path, tabs);
		diagramTab(obj, tabs);
	}
	
	protected void contentTab(Catalog obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path, Tabs tabs) {
		if (!obj.getElements().isEmpty()) {
			Table contentTable = HTMLFactory.INSTANCE.table().bordered();
			contentTable.header().headerRow("Element", "Type", "Summary").style(Style.PRIMARY);
			for (CatalogElement catalogElement: obj.getElements()) {			
				contentTable.body().row(
						storyDocumentationGenerator.getDocRoute().findToc(catalogElement).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
						catalogElement.eClass().getName(),
						storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(catalogElement.getDescription()));
			}
			tabs.item("Content", contentTable);
		}
	}
	
	//getElements()

}
