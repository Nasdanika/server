package org.nasdanika.cdo.web.doc.story;

import java.net.URI;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
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
	protected void indexTabs(T obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		super.indexTabs(obj, context, baseURI, urlPrefix, path, tabs);
		if (!obj.getStates().isEmpty()) {
			HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
			Table statesTable = htmlFactory.table().bordered();
			statesTable.header().headerRow("Name", "Summary").style(Style.PRIMARY);
			for (State state: obj.getStates()) {			
				statesTable.body().row(
						storyDocumentationGenerator.getDocRoute().findToc(state).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
						storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(state.getDescription()));
			}
			tabs.item("States", statesTable);
		}
	}

}
