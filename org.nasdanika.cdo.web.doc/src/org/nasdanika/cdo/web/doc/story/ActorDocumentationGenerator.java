package org.nasdanika.cdo.web.doc.story;

import java.net.URI;

import org.nasdanika.html.Fragment;
import org.nasdanika.html.Tabs;
import org.nasdanika.story.Actor;
import org.nasdanika.web.HttpServletRequestContext;

abstract class ActorDocumentationGenerator<T extends Actor> extends StoryContainerDocumentationGenerator<T> {

	ActorDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected Fragment indexHeader(
			T obj, 
			HttpServletRequestContext context, 
			java.net.URI baseURI, 
			String urlPrefix, 
			String path) {
		Fragment ret = super.indexHeader(obj, context, baseURI, urlPrefix, path);
		// TODO - Protagonist.linkTo()	
		
		return ret;
	}
	
	@Override
	protected void indexTabs(T obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		super.indexTabs(obj, context, baseURI, urlPrefix, path, tabs);
		// TODO - getRoles()
		// TODO - getSubActors() - mapping in the story documentation generator.
		// TODO - getSuperActors()
	}	

}
