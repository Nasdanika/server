package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.web.HttpServletRequestContext;

abstract class CatalogElementDocumentationGenerator<T extends CatalogElement> implements StoryElementDocumentationGenerator<T> {

	protected StoryDocumentationGenerator storyDocumentationGenerator;

	protected CatalogElementDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public void createToc(T catalogElement, TocNode parent) {
		try {
			TocNode catalogElementToc = parent.createChild(
					catalogElement.getName(), 
					storyDocumentationGenerator.getObjectPath(catalogElement)+"/index.html",
					getIcon(), 
					null);

			for (EObject el: getTocChildren(catalogElement)) {
				StoryElementDocumentationGenerator<Object> elTocBuilderRoute = storyDocumentationGenerator.getStoryElementDocumentationGenerator(el.eClass());
				if (elTocBuilderRoute != null) {
					elTocBuilderRoute.createToc(el, catalogElementToc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Collection<? extends EObject> getTocChildren(T catalogElement) {
		return Collections.emptyList();		
	}

	protected String getIcon() {
		return null;
	}
	
	@Override
	public Object getContent(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		// TODO - name, description.
		return obj.eClass().getName()+" documentation "+path+" "+(context==null ? "" : Arrays.toString(context.getPath()))+" "+baseURL+" "+urlPrefix;
	}

}
