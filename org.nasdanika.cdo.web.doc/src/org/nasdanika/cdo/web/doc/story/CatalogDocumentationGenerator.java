package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.story.Catalog;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;

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
					null);
			
			for (CatalogElement el: catalog.getElements()) {
				if (el instanceof Protagonist && ((Protagonist) el).getLinkTo() != null) {
					continue;
				}
				StoryElementDocumentationGenerator<Object> elTocBuilderRoute = storyDocumentationGenerator.getStoryElementDocumentationGenerator(el.eClass());
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

}
