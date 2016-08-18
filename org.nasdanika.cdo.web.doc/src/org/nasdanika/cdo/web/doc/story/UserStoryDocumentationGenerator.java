package org.nasdanika.cdo.web.doc.story;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;
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
		
	@Override
	protected Fragment indexHeader(Story obj, HttpServletRequestContext context, URI baseURI, String urlPrefix,	String path) {
		Fragment ret = super.indexHeader(obj, context, baseURI, urlPrefix, path);
		HTMLFactory htmlFactory = ret.getFactory();
		if (obj.isCompleted()) {
			ret.content(htmlFactory.div("<B>Status: </B>", htmlFactory.fontAwesome().webApplication(WebApplication.check), " Completed").style().margin().bottom("15px"));
		} else {
			ret.content(htmlFactory.div("<B>Status: </B>", htmlFactory.fontAwesome().webApplication(WebApplication.hourglass), " Pending").style().margin().bottom("15px"));
		}
		
		try {
			URI modelURI = storyDocumentationGenerator.getModelUri(obj);
			
			List<Protagonist> protagonists = new ArrayList<>();
			if (obj.eContainer() instanceof Protagonist) {
				protagonists.add((Protagonist) obj.eContainer());
			}
			protagonists.addAll(obj.getProtagonists());
			
			if (!protagonists.isEmpty()) {
				ret.content(htmlFactory.tag(TagName.h4, "As a (Protagonist/Role)"));
				Iterator<Protagonist> pit = protagonists.iterator();
				while (pit.hasNext()) {
					ret.content(storyDocumentationGenerator.getDocRoute().findToc(pit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
					if (pit.hasNext()) {
						ret.content(", ");
					}
				}
			}						
			
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
			
		} catch (URISyntaxException e) {
			ret.content(htmlFactory.alert(Style.DANGER, false, e));
		}			
		return ret;
	}
	
	@Override
	protected void indexTabs(Story obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		super.indexTabs(obj, context, baseURI, urlPrefix, path, tabs);
		HTMLFactory htmlFactory = tabs.getFactory();
		if (!obj.getScenarios().isEmpty()) {
			try {
				List<Object[]> rows = new ArrayList<>();
				boolean hasContextStates = false;
				boolean hasContexts = false;
				boolean hasOutcomeStates = false;
				boolean hasOutcomes = false;
				
				URI modelURI = storyDocumentationGenerator.getModelUri(obj);
				for (Scenario scenario: obj.getScenarios()) {			
					Fragment contextStatesFragment = tabs.getFactory().fragment();
					Iterator<State> sit = scenario.getContextStates().iterator();
					while (sit.hasNext()) {
						hasContextStates = true;
						contextStatesFragment.content(storyDocumentationGenerator.getDocRoute().findToc(sit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
						if (sit.hasNext()) {
							contextStatesFragment.content(", ");
						}
					}
					
					String scenarioContext = scenario.getContext();
					hasContexts = hasContexts || !CoreUtil.isBlank(scenarioContext);
					String scenarioOutcome = scenario.getOutcome();
					hasOutcomes = hasOutcomes || !CoreUtil.isBlank(scenarioOutcome);
					hasOutcomeStates = hasOutcomeStates || scenario.getOutcomeState() != null;
					rows.add(new Object[] {
							storyDocumentationGenerator.getDocRoute().findToc(scenario).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
							contextStatesFragment,
							storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, scenarioContext),
							storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, scenario.getAction()),
							scenario.getOutcomeState() == null ? "" : storyDocumentationGenerator.getDocRoute().findToc(scenario.getOutcomeState()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
							storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, scenarioOutcome)
					});
				}
				
				Table scenariosTable = htmlFactory.table().bordered();
				Row headerRow = scenariosTable.header().headerRow("Name").style(Style.PRIMARY);
				if (hasContextStates) {
					headerRow.header("Context state(s)");
				}
				if (hasContexts) {
					headerRow.header("Given (Context)");
				}
				headerRow.header("When (Action)");
				if (hasOutcomeStates) {
					headerRow.header("Outcome state");
				}
				if (hasOutcomes) {
					headerRow.header("Then (Outcome)");
				}
				
				for (Object[] ra: rows) {			
					Row scenarioRow = scenariosTable.body().row(ra[0]);
					if (hasContextStates) {
						scenarioRow.cell(ra[1]);
					}
					if (hasContexts) {
						scenarioRow.cell(ra[2]);
					}
					scenarioRow.cell(ra[3]);
					if (hasOutcomeStates) {
						scenarioRow.cell(ra[4]);
					}
					if (hasOutcomes) {
						scenarioRow.cell(ra[5]);
					}					
				}
				tabs.item("Scenarios", scenariosTable);
			} catch (URISyntaxException e) {
				tabs.item("Scenarios", htmlFactory.alert(Style.DANGER, false, e));
			}
		}	
	
		// TODO - Parameters
		//		getDescription()
		//		getName()
		//		getType()
		
	}	
}
