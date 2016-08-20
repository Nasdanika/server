package org.nasdanika.cdo.web.doc.story;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.story.Scenario;
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
	
	@Override
	protected void indexTabs(State obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		super.indexTabs(obj, context, baseURI, urlPrefix, path, tabs);
		List<Scenario> inboundScenarios = new ArrayList<>();
		List<Scenario> outboundScenarios = new ArrayList<>();
		List<State> subStates = new ArrayList<>();
		TreeIterator<Notifier> tit = obj.eResource().getResourceSet().getAllContents();
		while (tit.hasNext()) {
			Notifier next = tit.next();
			if (next instanceof State) {
				if (((State) next).getSuperStates().contains(obj)) {
					subStates.add((State) next);
				}
			} else if (next instanceof Scenario) {
				if (((Scenario) next).getOutcomeState() == obj && !inboundScenarios.contains(next)) {
					inboundScenarios.add((Scenario) next);
				}
				if (((Scenario) next).getContextStates().contains(obj) && !outboundScenarios.contains(next)) {
					outboundScenarios.add((Scenario) next);
				}
			}
		}
		Collections.sort(inboundScenarios, CATALOG_ELEMENT_NAME_COMPARATOR);
		Collections.sort(outboundScenarios, CATALOG_ELEMENT_NAME_COMPARATOR);
		Collections.sort(subStates, CATALOG_ELEMENT_NAME_COMPARATOR);
		List<State> superStates = new ArrayList<>(obj.getSuperStates());
		Collections.sort(superStates, CATALOG_ELEMENT_NAME_COMPARATOR);
		try {
			URI modelURI = storyDocumentationGenerator.getModelUri(obj);				
			Table inboundScenariosTable = scenariosTable(inboundScenarios, urlPrefix, modelURI, true, false);
			if (inboundScenariosTable != null) {
				tabs.item("Inbound Scenarios", inboundScenariosTable);
			}
			Table outboundScenariosTable = scenariosTable(outboundScenarios, urlPrefix, modelURI, false, true);
			if (outboundScenariosTable != null) {
				tabs.item("Outbound Scenarios", outboundScenariosTable);
			}
		} catch (URISyntaxException e) {
			tabs.item("Error", tabs.getFactory().alert(Style.DANGER, false, e));
		}
		
		if (!superStates.isEmpty()) {
			Table contentTable = HTMLFactory.INSTANCE.table().bordered();
			contentTable.header().headerRow("State", "Summary").style(Style.PRIMARY);
			for (State superState: superStates) {			
				contentTable.body().row(
						storyDocumentationGenerator.getDocRoute().findToc(superState).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
						storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(superState.getDescription()));
			}
			tabs.item("Super-states", contentTable);
		}
		
		if (!subStates.isEmpty()) {
			Table contentTable = HTMLFactory.INSTANCE.table().bordered();
			contentTable.header().headerRow("State", "Summary").style(Style.PRIMARY);
			for (State subState: subStates) {			
				contentTable.body().row(
						storyDocumentationGenerator.getDocRoute().findToc(subState).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
						storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(subState.getDescription()));
			}
			tabs.item("Sub-states", contentTable);
		}
		
		// inbound scenarios
		// outbound scenarios
		// sub-states
		// super-states
	}
	

}
