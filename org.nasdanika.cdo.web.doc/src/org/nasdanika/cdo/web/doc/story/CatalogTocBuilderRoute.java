package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.story.Catalog;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;

class CatalogTocBuilderRoute implements TocBuilderRoute<Catalog> {

	private StoryDocumentationGenerator storyDocumentationGenerator;

	public CatalogTocBuilderRoute(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canExecute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createToc(Catalog catalog, TocNode parent) {
		try {
			TocNode catalogToc = parent.createChild(
					catalog.getName(), 
					storyDocumentationGenerator.getObjectPath(catalog)+"/index.html",
					"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/drawer.png", 
					null);
			
			for (CatalogElement el: catalog.getElements()) {
				if (el instanceof Protagonist && ((Protagonist) el).getLinkTo() != null) {
					continue;
				}
				TocBuilderRoute<Object> elTocBuilderRoute = storyDocumentationGenerator.getTocBuilderRoute(el.eClass());
				if (elTocBuilderRoute != null) {
					elTocBuilderRoute.createToc(el, catalogToc);
				}
			}
// For testing purposes			
//			if (catalogToc.getChildren().isEmpty()) {
//				parent.getChildren().remove(catalogToc);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
