package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.Collection;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.Scenario;
import org.nasdanika.web.HttpServletRequestContext;

class ScenarioDocumentationGenerator extends CatalogElementDocumentationGenerator<Scenario> {

	ScenarioDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/document_todo.png";
	}
	
	protected Fragment getIndex(Scenario obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Fragment ret = htmlFactory.fragment(
			htmlFactory.tag(
					TagName.h3, 
					htmlFactory.tag(TagName.img).attribute("src", storyDocumentationGenerator.getDocRoute().getDocRoutePath()+getIcon()).style().margin().right("5px"),
					StringEscapeUtils.escapeHtml4(obj.getName()),
					" (", obj.eClass().getName(), ")"));
		
		String resolvedID = StoryDocumentationGenerator.resolveCatalogElementID(obj);
		if (!CoreUtil.isBlank(resolvedID)) {
			ret.content(htmlFactory.div("<B>ID: </B>", StringEscapeUtils.escapeHtml4(resolvedID)).style().margin().bottom("10px"));
		}
		
		if (!CoreUtil.isBlank(obj.getContext())) {
			ret.content(htmlFactory.tag(TagName.h4, "Given (Context)"));
			ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(baseURL, urlPrefix, obj.getContext()));
		}
		
		if (!CoreUtil.isBlank(obj.getAction())) {
			ret.content(htmlFactory.tag(TagName.h4, "When (Action)"));
			ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(baseURL, urlPrefix, obj.getAction()));
		}
		
		if (!CoreUtil.isBlank(obj.getOutcome())) {
			ret.content(htmlFactory.tag(TagName.h4, "Then (Outcome)"));
			ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(baseURL, urlPrefix, obj.getOutcome()));
		}
				
		if (!CoreUtil.isBlank(obj.getDescription())) {
			ret.content(htmlFactory.tag(TagName.h4, "Description"));
			ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(baseURL, urlPrefix, obj.getDescription()));
		}
		
		return ret;
	}
	
	@Override
	protected Collection<? extends EObject> getTocChildren(Scenario scenario) {
		return storyDocumentationGenerator.findLinkedTestResults(scenario);
	}

	// TODO - link test results.
	
}
