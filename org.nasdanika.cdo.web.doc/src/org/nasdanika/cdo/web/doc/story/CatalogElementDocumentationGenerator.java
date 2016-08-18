package org.nasdanika.cdo.web.doc.story;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.Select;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;

import net.sourceforge.plantuml.SourceStringReader;

abstract class CatalogElementDocumentationGenerator<T extends CatalogElement> implements DocumentationGenerator<T> {

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
					obj -> obj == catalogElement);

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
					" (", obj.eClass().getName(), ")"));
		
		String resolvedID = StoryDocumentationGenerator.resolveCatalogElementID(obj);
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
		// TODO - links, e.g. test results, pages, actors, ...
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
			
			diagramSpecGenerator.diagramSpec(obj, specBuilder);
			
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
				
				Select directionSelect = htmlFactory.select().knockout().value("direction");
				directionSelect.option("in", false, false, "In");
				directionSelect.option("out", false, false, "Out");
				directionSelect.option("both", true, false, "Both");
				diagramConfigurationForm.formGroup("Direction", directionSelect, "Related elements to display")
					.style().border().right("dashed 1px silver")
					.style().padding().right("5px");
		
				Select depthSelect = htmlFactory.select().knockout().value("depth");
				for (int i=0; i<10; ++i) {
					depthSelect.option(String.valueOf(i), i==1, false, String.valueOf(i));
				}
				depthSelect.option("-1", false, false, "&infin;");
				diagramConfigurationForm.formGroup("Depth", depthSelect, "Dependency depth")
					.style().border().right("dashed 1px silver")
					.style().padding().right("5px");		
					
				Input leftToRightDirectionCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("leftToRightDirection");
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
		
}
