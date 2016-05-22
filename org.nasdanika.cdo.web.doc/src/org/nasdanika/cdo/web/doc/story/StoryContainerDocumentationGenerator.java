package org.nasdanika.cdo.web.doc.story;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.story.StoryContainer;

abstract class StoryContainerDocumentationGenerator<T extends StoryContainer> extends CatalogElementDocumentationGenerator<T> {

	StoryContainerDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected Collection<? extends EObject> getTocChildren(T storyContainer) {
		return storyContainer.getStories();
	}

}
