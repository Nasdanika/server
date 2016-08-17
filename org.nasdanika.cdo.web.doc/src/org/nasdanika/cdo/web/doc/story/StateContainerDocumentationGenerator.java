package org.nasdanika.cdo.web.doc.story;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.State;
import org.nasdanika.story.StateContainer;
import org.nasdanika.web.HttpServletRequestContext;

abstract class StateContainerDocumentationGenerator<T extends StateContainer> extends CatalogElementDocumentationGenerator<T> {

	StateContainerDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected Collection<? extends EObject> getTocChildren(T storyContainer) {
		return storyContainer.getStates();
	}
	
	@Override
	protected Fragment getIndex(T obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) {
		Fragment ret = super.getIndex(obj, context, baseURI, urlPrefix, path);
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		ret.content(htmlFactory.tag(TagName.h4, "Stories"));
		Table contentTable = htmlFactory.table().bordered();
		ret.content(contentTable);
		contentTable.header().headerRow("Name", "Summary").style(Style.PRIMARY);
		for (State state: obj.getStates()) {			
			contentTable.body().row(
					storyDocumentationGenerator.getDocRoute().findToc(state).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
					storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(state.getDescription()));
		}
		return ret;
	}

}
