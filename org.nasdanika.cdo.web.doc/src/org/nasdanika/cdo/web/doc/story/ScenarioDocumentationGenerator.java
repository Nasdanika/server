package org.nasdanika.cdo.web.doc.story;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;
import org.nasdanika.story.Step;
import org.nasdanika.web.HttpServletRequestContext;

class ScenarioDocumentationGenerator extends StateContainerDocumentationGenerator<Scenario> {

	ScenarioDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}
	
	@Override
	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/document_todo.png";
	}
	
	@Override
	protected void indexTabs(Scenario obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		
		try {
			URI modelURI = storyDocumentationGenerator.getModelUri(obj);

			Fragment overview = tabs.getFactory().fragment();
			if (!obj.getContextStates().isEmpty()) {
				overview.content(overview.getFactory().tag(TagName.h4, "Context state(s)"));
				Iterator<State> sit = obj.getContextStates().iterator();
				while (sit.hasNext()) {
					overview.content(storyDocumentationGenerator.getDocRoute().findToc(sit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
					if (sit.hasNext()) {
						overview.content(", ");
					}
				}				
			}
			
			if (!CoreUtil.isBlank(obj.getContext())) {
				overview.content(overview.getFactory().tag(TagName.h4, "Given (Context)"));
				overview.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getContext()));
			}
			
			if (!CoreUtil.isBlank(obj.getAction())) {
				overview.content(overview.getFactory().tag(TagName.h4, "When (Action)"));
				overview.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getAction()));
			}
			
			if (obj.getOutcomeState() != null) {
				overview.content(overview.getFactory().tag(TagName.h4, "Outcome state"));
				overview.content(storyDocumentationGenerator.getDocRoute().findToc(obj.getOutcomeState()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
			}
			
			if (!CoreUtil.isBlank(obj.getOutcome())) {
				overview.content(overview.getFactory().tag(TagName.h4, "Then (Outcome)"));
				overview.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getOutcome()));
			}
			
			if (!CoreUtil.isBlank(obj.getDescription())) {
				overview.content(overview.getFactory().tag(TagName.h4, "Description"));
				overview.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getDescription()));
			}
			tabs.item("Overview", overview);
		} catch (URISyntaxException e) {
			tabs.item("Overview", tabs.getFactory().alert(Style.DANGER, false, e));
		}
		
		super.indexTabs(obj, context, baseURI, urlPrefix, path, tabs);
		
		if (!obj.getSteps().isEmpty()) {
			try {
				URI modelURI = storyDocumentationGenerator.getModelUri(obj);
				Table stepsTable = tabs.getFactory().table().bordered();
				stepsTable.header().headerRow("Name", "ID", "From state", "Condition", "To state", "Description").style(Style.PRIMARY);
				for (Step step: obj.getSteps()) {
					String resolvedID = StoryDocumentationGenerator.resolveModelElementID(step);
					stepsTable.row(
							StringEscapeUtils.escapeHtml4(step.getName()),
							CoreUtil.isBlank(resolvedID) ? "" : StringEscapeUtils.escapeHtml4(resolvedID),
							step.getFromState() == null ? "" : storyDocumentationGenerator.getDocRoute().findToc(step.getFromState()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
							StringEscapeUtils.escapeHtml4(step.getCondition()),
							step.getToState() == null ? "" : storyDocumentationGenerator.getDocRoute().findToc(step.getToState()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
							storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getOutcome()));
				}
				tabs.item("Steps", stepsTable);
			} catch (URISyntaxException e) {
				tabs.item("Steps", tabs.getFactory().alert(Style.DANGER, false, e));
			}				
		}
		// TODO - Linked test results - storyDocumentationGenerator.findLinkedTestResults(scenario), or links in general.
	}
	
}
