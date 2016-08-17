package org.nasdanika.cdo.web.doc.story;

import org.nasdanika.html.Fragment;
import org.nasdanika.story.State;
import org.nasdanika.web.HttpServletRequestContext;

class StateDocumentationGenerator extends CatalogElementDocumentationGenerator<State> {

	StateDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/page.png";
	}

	protected Fragment getIndex(State obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) {
		Fragment ret = super.getIndex(obj, context, baseURI, urlPrefix, path);
		// TODO - sub-states, super-states.
		return ret;
	}
	

}
