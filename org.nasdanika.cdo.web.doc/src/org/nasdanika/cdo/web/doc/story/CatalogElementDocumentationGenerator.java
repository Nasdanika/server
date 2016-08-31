package org.nasdanika.cdo.web.doc.story;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.doc.story.StoryDocumentationGenerator.Link;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Input;
import org.nasdanika.html.Select;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;

import net.sourceforge.plantuml.SourceStringReader;

abstract class CatalogElementDocumentationGenerator<T extends CatalogElement> implements DocumentationGenerator<T> {
	
	static final Comparator<CatalogElement> CATALOG_ELEMENT_NAME_COMPARATOR = new Comparator<CatalogElement>() {

		@Override
		public int compare(CatalogElement o1, CatalogElement o2) {
			if (o1 == o2) {
				return 0;
			}
			if (o1.getName() == null) {
				return o2.getName() == null ? o1.hashCode()-o2.hashCode() : 1;
			}
			
			if (o2.getName() == null) {
				return -1;
			}
			
			int cmp = o1.getName().compareTo(o2.getName());
			return cmp == 0 ? o1.hashCode() - o2.hashCode() : cmp;
		}
	};
		
	static <T extends CatalogElement> List<T> sortByName(Collection<T> toSort) {
		List<T> ret = new ArrayList<T>(toSort);
		Collections.sort(ret, CATALOG_ELEMENT_NAME_COMPARATOR);
		return ret;
	}	

	protected StoryDocumentationGenerator storyDocumentationGenerator;

	protected CatalogElementDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public void createToc(T catalogElement, TocNode parent) {
		try {
			TocNode catalogElementToc = parent.createChild(
					catalogElement.getName(), 
					storyDocumentationGenerator.getObjectPath(catalogElement)+"/index.html",
					getIcon(), 
					null,
					obj -> obj == catalogElement, 
					false);

			for (EObject el: getTocChildren(catalogElement)) {
				DocumentationGenerator<Object> elTocBuilderRoute = storyDocumentationGenerator.getDocumentationGenerator(el.eClass());
				if (elTocBuilderRoute != null) {
					elTocBuilderRoute.createToc(el, catalogElementToc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Collection<? extends EObject> getTocChildren(T catalogElement) {
		return Collections.emptyList();		
	}

	protected String getIcon() {
		return null;
	}
			
	@Override
	public Object getContent(T obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) {		
		if (path.endsWith("/index.html")) {
			return getIndex(obj, context, baseURI, urlPrefix, path).toString();
		} 
		
		for (DiagramSpecGenerator dsg: storyDocumentationGenerator.getDiagramSpecGenerators()) {			
			if (path.endsWith("/"+dsg.getName()+".png")) {
				return generateDiagram(obj, dsg, context, baseURI, urlPrefix, path);
			}
		}
		
		return Action.NOT_FOUND;
	}
	
	protected Fragment getIndex(
			T obj, 
			HttpServletRequestContext context, 
			java.net.URI baseURI, 
			String urlPrefix, 
			String path) {
		
		Fragment ret = indexHeader(obj, context, baseURI, urlPrefix, path);		
		Tabs tabs = ret.getFactory().tabs().style().margin().top("15px");
		indexTabs(obj, context, baseURI, urlPrefix, path, tabs);
		ret.content(tabs);
		return ret;
	}

	protected Fragment indexHeader(
			T obj, 
			HttpServletRequestContext context, 
			java.net.URI baseURI, 
			String urlPrefix, 
			String path) {

		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Fragment ret = htmlFactory.fragment(
			htmlFactory.tag(
					TagName.h3, 
					htmlFactory.tag(TagName.img).attribute("src", storyDocumentationGenerator.getDocRoute().getDocRoutePath()+getIcon()).style().margin().right("5px"),
					StringEscapeUtils.escapeHtml4(obj.getName()),
					" (", eClassLink(obj.eClass()).toString().trim(), ")"));
		
		String resolvedID = StoryDocumentationGenerator.resolveModelElementID(obj);
		if (!CoreUtil.isBlank(resolvedID)) {
			ret.content(htmlFactory.div("<B>ID: </B>", StringEscapeUtils.escapeHtml4(resolvedID)).style().margin().bottom("10px"));
		}
		return ret;
	}
	
	protected void indexTabs(
			T obj, 
			HttpServletRequestContext context, 
			java.net.URI baseURI, 
			String urlPrefix, 
			String path, 
			Tabs tabs) {
		
		descriptionTab(obj, context, baseURI, urlPrefix, path, tabs);
		diagramTab(obj, tabs);
		linksTab(obj, context, baseURI, urlPrefix, path, tabs);
	}
	
	protected void descriptionTab(
			T obj, 
			HttpServletRequestContext context, 
			java.net.URI baseURI, 
			String urlPrefix, 
			String path, 
			Tabs tabs) {
		
		if (!CoreUtil.isBlank(obj.getDescription())) {
			try {
				tabs.item("Description", storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(storyDocumentationGenerator.getModelUri(obj), urlPrefix, obj.getDescription()).style().margin().top("10px").style().margin().bottom("10px"));
			} catch (URISyntaxException e) {
				tabs.item("Description", tabs.item("Description", HTMLFactory.INSTANCE.alert(Style.DANGER, false, e)));
			}
		}
	}
	
	protected void linksTab(
			T obj, 
			HttpServletRequestContext context, 
			java.net.URI baseURI, 
			String urlPrefix, 
			String path, 
			Tabs tabs) {
		
		List<Link> links = storyDocumentationGenerator.getLinks(obj);
		if (!links.isEmpty()) {
			Table linksTable = HTMLFactory.INSTANCE.table().bordered();
			linksTable.header().headerRow("Source", "Type", "Comment").style(Style.PRIMARY);
			// TODO - sort
			for (Link link: links) {			
				linksTable.body().row(
						link.getLink(),
						eClassLink(link.getType()),
						StringEscapeUtils.escapeHtml4(link.getComment()));
			}
			
			tabs.item("Links", linksTable);
		}
	}	
		
	protected Action generateDiagram(
			T obj,
			DiagramSpecGenerator diagramSpecGenerator,
			HttpServletRequestContext context, 
			java.net.URI baseURI, 
			String urlPrefix, 
			String path) {
		try {
			StringBuilder specBuilder = new StringBuilder("@startuml").append(System.lineSeparator());
			
			if (Boolean.TRUE.toString().equals(context.getRequest().getParameter("leftToRightDirection"))) {
				specBuilder.append("left to right direction").append(System.lineSeparator());
			}
			
			String width = context.getRequest().getParameter("width");
			if (width != null) {
				specBuilder.append("scale ").append(width).append(" width").append(System.lineSeparator());
			}
			
			diagramSpecGenerator.diagramSpec(
					obj,
					Integer.parseInt(context.getRequest().getParameter("depth")),					
					DiagramSpecGenerator.Direction.valueOf(context.getRequest().getParameter("direction")), 
					specBuilder);
			
			specBuilder.append("@enduml").append(System.lineSeparator());
	//		System.out.println(specBuilder);
			SourceStringReader reader = new SourceStringReader(specBuilder.toString());
	
			context.getResponse().setContentType("image/png");
			reader.generateImage(context.getResponse().getOutputStream());
			return Action.NOP;
		} catch (IOException e) {
			e.printStackTrace();
			return Action.INTERNAL_SERVER_ERROR;
		}
	}
	
	protected void diagramTab(T obj, Tabs tabs) {
		List<DiagramSpecGenerator> matchingDiagramSpecGenerators = new ArrayList<>();
		for (DiagramSpecGenerator dsg: storyDocumentationGenerator.getDiagramSpecGenerators()) {
			if (dsg.hasDiagram(obj)) {
				matchingDiagramSpecGenerators.add(dsg);
			}
		}
		if (!matchingDiagramSpecGenerators.isEmpty()) {
			try {
				DocRoute docRoute = storyDocumentationGenerator.getDocRoute();
				HTMLFactory htmlFactory = docRoute.getHtmlFactory();
				String idBase = obj.eClass().getName()+"-diagram-"+htmlFactory.nextId();
				Tag contextDiagramApp = htmlFactory.div().id(idBase + "-app");
				
				contextDiagramApp.content(htmlFactory.spinnerOverlay(Spinner.cog).id(idBase+"-overlay"));
				
				Form diagramConfigurationForm = htmlFactory.form()
						.inline(true, false)
						.style().border("1px silver solid")
						.style().border().top("none")
						.style().padding("3px")
						.style().margin().bottom("3px");
				
				contextDiagramApp.content(diagramConfigurationForm);
		
				if (matchingDiagramSpecGenerators.size() == 1) {
					for (DiagramSpecGenerator dsg: matchingDiagramSpecGenerators) {
						Input viewInput = htmlFactory.input(InputType.hidden).knockout().value("view", "\""+dsg.getName()+"\"");
						diagramConfigurationForm.content(viewInput);
					}
				} else {
					Select viewSelect = htmlFactory.select().knockout().value("view");
					for (DiagramSpecGenerator dsg: matchingDiagramSpecGenerators) {
						viewSelect.option(dsg.getName(), false, false, dsg.getLabel());
					}
					diagramConfigurationForm.formGroup("View", viewSelect, "Story model view")
						.style().border().right("dashed 1px silver")
						.style().padding().right("5px");
				}			
				
				Select directionSelect = htmlFactory.select()
						.knockout().value("direction")
						.knockout().disable("view() == 'activity'");
						
				directionSelect.option("in", false, false, "In");
				directionSelect.option("out", false, false, "Out");
				directionSelect.option("both", true, false, "Both");
				diagramConfigurationForm.formGroup("Direction", directionSelect, "Related elements to display")
					.style().border().right("dashed 1px silver")
					.style().padding().right("5px");
		
				Select depthSelect = htmlFactory.select()
						.knockout().value("depth", 0)
						.knockout().disable("view() == 'activity'");
				
				for (int i=0; i<10; ++i) {
					depthSelect.option(String.valueOf(i), i==0, false, String.valueOf(i));
				}
				depthSelect.option("-1", false, false, "&infin;");
				diagramConfigurationForm.formGroup("Depth", depthSelect, "Dependency depth")
					.style().border().right("dashed 1px silver")
					.style().padding().right("5px");		
					
				Input leftToRightDirectionCheckbox = htmlFactory.input(InputType.checkbox)
						.knockout().checked("leftToRightDirection")
						.knockout().disable("view() == 'activity'");
				
				diagramConfigurationForm.formGroup("Left to right", leftToRightDirectionCheckbox, "Diagram direction")				
					.style().border().right("dashed 1px silver")
					.style().padding().right("5px");
				
				Input fitWidthCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("fitWidth");
				diagramConfigurationForm.formGroup("Fit width", fitWidthCheckbox, "Scale diagram to fit width")
					.style().border().right("dashed 1px silver")
					.style().padding().right("5px");
				
				Tag img = htmlFactory.tag(TagName.img)
						.knockout().attr("diagramAttributes")
						.knockout().event("{ load : imageLoaded }");
				
				Tag diagramDiv = htmlFactory.div(img);
				
				contextDiagramApp.content(diagramDiv);
						
				Map<String, Object> scriptEnv = new HashMap<>();
				scriptEnv.put("docRoutePath", docRoute.getDocRoutePath());
				scriptEnv.put("id-base", idBase);
				scriptEnv.put("view", matchingDiagramSpecGenerators.get(0).getName());
				scriptEnv.put("object-url", docRoute.getDocRoutePath()+storyDocumentationGenerator.getObjectPath(obj));
				
				String script = htmlFactory.interpolate(getClass().getResource("DiagramAppLoader.js"), scriptEnv);
				tabs.item("Diagram", htmlFactory.fragment(contextDiagramApp, htmlFactory.tag(TagName.script, script)));
			} catch (Exception e) {
				tabs.item("Diagram", "Error generating diagram tab: "+e);				
			}
		}
	}
	
	protected Table scenariosTable(
			Collection<Scenario> scenarios, 
			String urlPrefix,
			URI modelURI,
			boolean contextStatesColumn,
			boolean outcomeStatesColumn) {
		
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		if (scenarios.isEmpty()) {
			return null;
		}
		
		List<Object[]> rows = new ArrayList<>();
		boolean hasContextStates = false;
		boolean hasContexts = false;
		boolean hasOutcomeStates = false;
		boolean hasOutcomes = false;
		
		for (Scenario scenario: sortByName(scenarios)) {			
			Fragment contextStatesFragment = htmlFactory.fragment();
			Iterator<State> sit = scenario.getContextStates().iterator();
			while (sit.hasNext()) {
				hasContextStates = contextStatesColumn;
				contextStatesFragment.content(storyDocumentationGenerator.getDocRoute().findToc(sit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
				if (sit.hasNext()) {
					contextStatesFragment.content(", ");
				}
			}
			
			String scenarioContext = scenario.getContext();
			hasContexts = hasContexts || !CoreUtil.isBlank(scenarioContext);
			String scenarioOutcome = scenario.getOutcome();
			hasOutcomes = hasOutcomes || !CoreUtil.isBlank(scenarioOutcome);
			hasOutcomeStates = hasOutcomeStates || (scenario.getOutcomeState() != null && outcomeStatesColumn);
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
		return scenariosTable;
	}	
	
	protected Object eClassLink(EClass eClass) {
		String classifierPath = Hex.encodeHexString(eClass.getEPackage().getNsURI().getBytes(/* UTF-8? */))+"/"+eClass.getName();
		return HTMLFactory.INSTANCE.link(DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+storyDocumentationGenerator.getDocRoute().getDocRoutePath()+DocRoute.PACKAGES_GLOBAL_PATH+classifierPath, eClass.getName());		
	}
		
}
