package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.StoryBase;
import org.nasdanika.story.StoryContainer;
import org.nasdanika.web.HttpServletRequestContext;

abstract class StoryContainerDocumentationGenerator<T extends StoryContainer> extends CatalogElementDocumentationGenerator<T> {

	StoryContainerDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected Collection<? extends EObject> getTocChildren(T storyContainer) {
		return storyContainer.getStories();
	}
	
	@Override
	protected Fragment getIndex(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		ret.content(htmlFactory.tag(TagName.h4, "Stories"));
		Table contentTable = htmlFactory.table().bordered();
		ret.content(contentTable);
		contentTable.header().headerRow("Element", "Type", "Summary").style(Style.PRIMARY);
		for (StoryBase storyBase: obj.getStories()) {			
			contentTable.body().row(
					storyDocumentationGenerator.getDocRoute().findToc(storyBase).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
					storyBase.eClass().getName(),
					storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(storyBase.getDescription()));
		}
		return ret;
	}

}
