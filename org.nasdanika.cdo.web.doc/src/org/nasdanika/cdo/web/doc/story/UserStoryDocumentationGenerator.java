package org.nasdanika.cdo.web.doc.story;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.nasdanika.html.TagName;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;
import org.nasdanika.story.Story;
import org.nasdanika.story.StoryBase;
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
		Collection<EObject> ret = new ArrayList<>(super.getTocChildren(story));
		ret.addAll(sortByName(story.getScenarios()));
		return ret;
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
		
		return ret;
	}
	
	@Override
	protected void indexTabs(Story obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		overviewTab(obj, context, baseURI, urlPrefix, path, tabs);
		super.indexTabs(obj, context, baseURI, urlPrefix, path, tabs);		
		scenariosTab(obj, context, baseURI, urlPrefix, path, tabs);
	
		// TODO - Parameters
		//		getDescription()
		//		getName()
		//		getType()
		
	}

	protected void overviewTab(Story obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		Fragment overviewTabContent = tabs.getFactory().fragment();
		try {
			URI modelURI = storyDocumentationGenerator.getModelUri(obj);
			
			List<Protagonist> protagonists = new ArrayList<>();
			for (EObject container = obj.eContainer(); container!=null; container = container.eContainer()) {
				if (container instanceof Protagonist) {
					protagonists.add((Protagonist) container);
					break;
				}
			}
			protagonists.addAll(obj.getProtagonists());
			
			if (!protagonists.isEmpty()) {
				overviewTabContent.content(tabs.getFactory().tag(TagName.h4, "As a (Protagonist/Role)"));
				Iterator<Protagonist> pit = protagonists.iterator();
				while (pit.hasNext()) {
					overviewTabContent.content(storyDocumentationGenerator.getDocRoute().findToc(pit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
					if (pit.hasNext()) {
						overviewTabContent.content(", ");
					}
				}
			}	
			
			if (!obj.getStartStates().isEmpty()) {
				overviewTabContent.content(tabs.getFactory().tag(TagName.h4, "Start states"));
				Iterator<State> sit = obj.getStartStates().iterator();
				while (sit.hasNext()) {
					overviewTabContent.content(storyDocumentationGenerator.getDocRoute().findToc(sit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
					if (sit.hasNext()) {
						overviewTabContent.content(", ");
					}
				}				
			}
			
			if (!CoreUtil.isBlank(obj.getGoal())) {
				overviewTabContent.content(tabs.getFactory().tag(TagName.h4, "I want (Goal)"));
				overviewTabContent.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getGoal()));
			}
			
			if (!CoreUtil.isBlank(obj.getBenefit())) {
				overviewTabContent.content(tabs.getFactory().tag(TagName.h4, "So that (Benefit)"));
				overviewTabContent.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getBenefit()));
			}

			if (!obj.getEndStates().isEmpty()) {
				overviewTabContent.content(tabs.getFactory().tag(TagName.h4, "End states"));
				Iterator<State> sit = obj.getEndStates().iterator();
				while (sit.hasNext()) {
					overviewTabContent.content(storyDocumentationGenerator.getDocRoute().findToc(sit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
					if (sit.hasNext()) {
						overviewTabContent.content(", ");
					}
				}				
			}
											
			if (!CoreUtil.isBlank(obj.getDescription())) {
				overviewTabContent.content(tabs.getFactory().tag(TagName.h4, "Description"));
				overviewTabContent.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(modelURI, urlPrefix, obj.getDescription()));
			}
			
		} catch (URISyntaxException e) {
			overviewTabContent.content(tabs.getFactory().alert(Style.DANGER, false, e));
		}	
		
		tabs.item("Overview", overviewTabContent);
	}

	protected void scenariosTab(Story obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		try {
			URI modelURI = storyDocumentationGenerator.getModelUri(obj);				
			Table scenariosTable = scenariosTable(obj.getScenarios(), urlPrefix, modelURI, true, true);
			if (scenariosTable != null) {
				tabs.item("Scenarios", scenariosTable);
			}
		} catch (URISyntaxException e) {
			tabs.item("Scenarios", tabs.getFactory().alert(Style.DANGER, false, e));
		}
	}
	
	@Override
	protected void descriptionTab(
			Story obj, 
			HttpServletRequestContext context, 
			URI baseURI, 
			String urlPrefix,
			String path, 
			Tabs tabs) {
		// NOP - description is in overview tab
	}

}
