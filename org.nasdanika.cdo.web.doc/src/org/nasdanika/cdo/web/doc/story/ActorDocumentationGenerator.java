package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.story.Actor;

abstract class ActorDocumentationGenerator<T extends Actor> extends StoryContainerDocumentationGenerator<T> {

	ActorDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

}
