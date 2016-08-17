package org.nasdanika.cdo.web.doc.story;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.Story;
import org.nasdanika.web.HttpServletRequestContext;

class UserStoryDocumentationGenerator extends StateContainerDocumentationGenerator<Story> {

	UserStoryDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/document_notes.png";
	}

	@Override
	protected Collection<? extends EObject> getTocChildren(Story story) {
		return story.getScenarios();
	}
	
	
	protected Fragment getIndex(Story obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) {
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
		
		if (obj.isCompleted()) {
			ret.content(htmlFactory.div("<B>Status: </B>", htmlFactory.fontAwesome().webApplication(WebApplication.check), " Completed"));
		} else {
			ret.content(htmlFactory.div("<B>Status: </B>", htmlFactory.fontAwesome().webApplication(WebApplication.hourglass), " Pending"));
		}
		
		try {
			URI modelURI = storyDocumentationGenerator.getModelUri(obj);
			
			if (!CoreUtil.isBlank(obj.getGoal())) {
				ret.content(htmlFactory.tag(TagName.h4, "I want (Goal)"));
				ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getGoal()));
			}
			
			if (!CoreUtil.isBlank(obj.getBenefit())) {
				ret.content(htmlFactory.tag(TagName.h4, "So that (Benefit)"));
				ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getBenefit()));
			}
					
			if (!CoreUtil.isBlank(obj.getDescription())) {
				ret.content(htmlFactory.tag(TagName.h4, "Description"));
				ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getDescription()));
			}
			
			if (!obj.getScenarios().isEmpty()) {
				ret.content(htmlFactory.tag(TagName.h4, "Scenarios"));
				Table scenariosTable = htmlFactory.table().bordered();
				ret.content(scenariosTable);
				scenariosTable.header().headerRow("Name", "Given (Context)", "When (Action)", "Then (Outcome)").style(Style.PRIMARY);
				for (Scenario scenario: obj.getScenarios()) {			
					scenariosTable.body().row(
							storyDocumentationGenerator.getDocRoute().findToc(scenario).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
							storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, scenario.getContext()),
							storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, scenario.getAction()),
							storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, scenario.getOutcome()));
				}
			}
		} catch (URISyntaxException e) {
			ret.content(htmlFactory.alert(Style.DANGER, false, e));
		}			
		
		// TODO - themes (tags), dependencies, realized goals, context diagram, protagonists 
		
		return ret;
	}
	
	// Parameter
//	getDescription()
//	getName()
//	getType()
}
