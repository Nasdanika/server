package org.nasdanika.cdo.web.doc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.felix.scr.Component;
import org.apache.felix.scr.Reference;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.Input;
import org.nasdanika.html.Select;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

class ComponentDocumentationGenerator extends BundleAndComponentDocumentationGeneratorBase {

	ComponentDocumentationGenerator(DocRoute docRoute) {
		super(docRoute);
	}

	Action generateComponentContextDiagram(HttpServletRequestContext context, Component component) {
		try {
			context.getResponse().setContentType("image/png");
			generateContextDiagram(
					component, 
					Direction.valueOf(context.getRequest().getParameter("direction")), 
					Integer.parseInt(context.getRequest().getParameter("depth")), 
					false, 
					true, 
					true, 
					false,
					Types.valueOf(context.getRequest().getParameter("types")), 
					Boolean.TRUE.toString().equals(context.getRequest().getParameter("leftToRightDirection")),
					context.getRequest().getParameter("width"),
					context.getResponse().getOutputStream());
			return Action.NOP;
		} catch (IOException | BundleException e) {
			e.printStackTrace();
			return Action.INTERNAL_SERVER_ERROR;
		}
	}
	
	String generateComponentInfo(Component component) {
		Fragment ret = htmlFactory.fragment();
		ret.content(htmlFactory.tag(TagName.h3, "Component "+StringEscapeUtils.escapeHtml4(component.getName())));
		Tabs tabs = htmlFactory.tabs().style().margin().right("5px");
		ret.content(tabs);
		
		generateComponentOverviewTab(component, tabs);		
		generateComponentPropertiesTab(component, tabs);
		generateComponentReferencesTab(component, tabs);
		generateComponentReferencedByTab(component, tabs);
		generateComponentContextDiagramTab(component, tabs);
		
		docRoute.sections(component.getBundle(), component.getName(), tabs);
		
		return ret.toString();
	}
	
	private void generateComponentPropertiesTab(Component component, Tabs tabs) {
		@SuppressWarnings("unchecked")
		Dictionary<String, Object> properties = component.getProperties();
		if (properties != null && !properties.isEmpty()) {
			Map<String, Object> cProperties = new TreeMap<>();
			for (String pKey: Collections.list(properties.keys())) {
				cProperties.put(pKey, properties.get(pKey));
			}
			cProperties.remove("objectClass");
			cProperties.remove("component.name");
			cProperties.remove(COMPONENT_ID_PROPERTY);

			if (!cProperties.isEmpty()) {
				Table propertiesTable = htmlFactory.table().bordered();
				propertiesTable.headerRow("Name", "Type", "Value(s)").style(Style.PRIMARY);
				
				for (Entry<String, Object> pe: cProperties.entrySet()) {
					propertiesTable.row(StringEscapeUtils.escapeHtml4(pe.getKey()), valueTypeLink(pe.getValue()), renderValue(pe.getValue()));
				}
				tabs.item("Properties", propertiesTable);
			}
		}		
	}
	
	private void generateComponentContextDiagramTab(Component component, Tabs tabs) {
		String idBase = "componentContextDiagram-"+component.getId()+"-"+htmlFactory.nextId();
		Tag contextDiagramApp = htmlFactory.div().id(idBase + "-app");
		
		contextDiagramApp.content(htmlFactory.spinnerOverlay(Spinner.cog).id(idBase+"-overlay"));
		
		Form diagramConfigurationForm = htmlFactory.form()
				.inline(true, false)
				.style().border("1px silver solid")
				.style().border().top("none")
				.style().padding("3px")
				.style().margin().bottom("3px");
		
		contextDiagramApp.content(diagramConfigurationForm);
		
		Select directionSelect = htmlFactory.select().knockout().value("direction");
		directionSelect.option("in", false, false, "In");
		directionSelect.option("out", false, false, "Out");
		directionSelect.option("both", true, false, "Both");
		diagramConfigurationForm.formGroup("Direction", directionSelect, "Related elements to display")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");

		Select depthSelect = htmlFactory.select().knockout().value("depth");
		for (int i=1; i<10; ++i) {
			depthSelect.option(String.valueOf(i), i==1, false, String.valueOf(i));
		}
		depthSelect.option("-1", false, false, "&infin;");
		diagramConfigurationForm.formGroup("Depth", depthSelect, "Dependency depth")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");		
		
		Select typesSelect = htmlFactory.select().knockout().value("types");
		typesSelect.option("hide", false, false, "Hide");
		typesSelect.option("name", false, false, "Name");
		typesSelect.option("fullyQualifiedName", true, false, "Fully Qualified Name");
		diagramConfigurationForm.formGroup("Types", typesSelect, "How to display types")		
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");

		Input leftToRightDirectionCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("leftToRightDirection");
		diagramConfigurationForm.formGroup("Left to right", leftToRightDirectionCheckbox, "Diagram direction")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");
		
		Input fitWidthCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("fitWidth");
		diagramConfigurationForm.formGroup("Fit width", fitWidthCheckbox, "Scale diagram to fit width");
				
		Tag img = htmlFactory.tag(TagName.img)
				.knockout().attr("diagramAttributes")
				.knockout().event("{ load : imageLoaded }");
		
		Tag diagramDiv = htmlFactory.div(img);
		
		contextDiagramApp.content(diagramDiv);
				
		Map<String, Object> scriptEnv = new HashMap<>();
		scriptEnv.put("docRoutePath", docRoute.getDocRoutePath());
		scriptEnv.put("id-base", idBase);
		scriptEnv.put("diagram-url", docRoute.getDocRoutePath()+DocRoute.COMPONENT_INFO_PATH+component.getId()+"/diagram.png");
		
		String script = htmlFactory.interpolate(getClass().getResource("BundleContextDiagramAppLoader.js"), scriptEnv);
		tabs.item("Context Diagram", htmlFactory.fragment(contextDiagramApp, htmlFactory.tag(TagName.script, script)));		
	}
	
	private void generateComponentReferencesTab(Component component, Tabs tabs) {
		Reference[] references = component.getReferences();
		if (references != null && references.length > 0) {
			Fragment referencesFragment = htmlFactory.fragment();
			for (Reference reference: references) {
				Table referenceInfoTable = htmlFactory.table().bordered();				
				Fragment referenceInfoFragment = htmlFactory.fragment(referenceInfoTable);
				
				Row svcRow = referenceInfoTable.row();
				svcRow.header("Service name");
				svcRow.cell(docRoute.javaDocLink(reference.getServiceName(), true, false));
				
				if (!CoreUtil.isBlank(reference.getTarget())) {
					Row targetRow = referenceInfoTable.row();
					targetRow.header("Target");
					targetRow.cell(StringEscapeUtils.escapeHtml4(reference.getTarget()));
				}
				
				Row multipleRow = referenceInfoTable.row();
				multipleRow.header("Multiple");
				multipleRow.cell(reference.isMultiple() ? htmlFactory.fontAwesome().webApplication(WebApplication.check) : "");
				
				Row optionalRow = referenceInfoTable.row();
				optionalRow.header("Optional");
				optionalRow.cell(reference.isOptional() ? htmlFactory.fontAwesome().webApplication(WebApplication.check) : "");
								
				Row satisfiedRow = referenceInfoTable.row();
				satisfiedRow.header("Satisfied");
				satisfiedRow.cell(reference.isSatisfied() ? htmlFactory.fontAwesome().webApplication(WebApplication.check) : "");
				
				Row staticRow = referenceInfoTable.row();
				staticRow.header("Static");
				staticRow.cell(reference.isStatic() ? htmlFactory.fontAwesome().webApplication(WebApplication.check) : "");				
				
				ServiceReference<?>[] serviceReferences = reference.getServiceReferences();
				if (serviceReferences != null && serviceReferences.length > 0) {
					Table serviceReferencesTable = htmlFactory.table().bordered();
					Row hr1 = serviceReferencesTable.row().style(Style.PRIMARY);
					hr1.header("Class(es)").rowspan(2);
					hr1.header("Bundle").rowspan(2);
					hr1.header("Component").rowspan(2);
					hr1.header("Scope").rowspan(2).bootstrap().text().center();
					hr1.header("Properties").colspan(3).bootstrap().text().center();
					serviceReferencesTable.headerRow("Name", "Type", "Value(s)").style(Style.PRIMARY);
					
					for (ServiceReference<?> sr: serviceReferences) {
						String[] propertyKeys = sr.getPropertyKeys();
						Map<String, Object> serviceProperties = new TreeMap<>();
						if (propertyKeys != null) {
							for (String pKey: propertyKeys) {
								serviceProperties.put(pKey, sr.getProperty(pKey));
							}
						}
						String[] objectClass = (String[]) serviceProperties.remove("objectClass");
						String componentName = (String) serviceProperties.remove("component.name");
						Long componentId = (Long) serviceProperties.remove(COMPONENT_ID_PROPERTY);
						
						// Not used, but no need to display either
						serviceProperties.remove("service.id");
						serviceProperties.remove("service.bundleid");
						
						String serviceScope = (String) serviceProperties.remove("service.scope");
						
						int rowSpan = serviceProperties.isEmpty() ? 1 : serviceProperties.size();
						
						Row serviceRow = serviceReferencesTable.row();
						
						// Service class
						if (objectClass.length == 0) {
							serviceRow.cell().rowspan(rowSpan);
						} else if (objectClass.length == 1) {
							serviceRow.cell(docRoute.javaDocLink(objectClass[0], true, false)).rowspan(rowSpan);
						} else {
							Tag ul = htmlFactory.tag(TagName.ul);
							for (String oc: objectClass) {
								ul.content(htmlFactory.tag(TagName.li, docRoute.javaDocLink(oc, true, false)));
							}
							serviceRow.cell(ul).rowspan(rowSpan);
						}
						
						serviceRow.cell(docRoute.bundleLink(sr.getBundle())).rowspan(rowSpan); 					
						
						// Component
						if (CoreUtil.isBlank(componentName) || componentId == null) {
							serviceRow.cell().rowspan(rowSpan);					
						} else {
							serviceRow.cell(docRoute.componentLink(componentName, componentId)).rowspan(rowSpan); 
						}
						
						// Scope
						serviceRow.cell(serviceScope == null ? "" : serviceScope).rowspan(rowSpan);										
						
						if (serviceProperties.isEmpty()) {
							serviceRow.cell("").colspan(3);
						} else {
							Iterator<Entry<String, Object>> pit = serviceProperties.entrySet().iterator();
							Entry<String, Object> firstEntry = pit.next();
							serviceRow.cell(StringEscapeUtils.escapeHtml4(firstEntry.getKey()));
							serviceRow.cell(valueTypeLink(firstEntry.getValue()));
							serviceRow.cell(renderValue(firstEntry.getValue()));
							while (pit.hasNext()) {
								Entry<String, Object> entry = pit.next();
								serviceReferencesTable.row(StringEscapeUtils.escapeHtml4(entry.getKey()), valueTypeLink(entry.getValue()), renderValue(entry.getValue()));
							}
						}
					}					
					referenceInfoFragment.content(htmlFactory.panel(Style.PRIMARY, "Service references", serviceReferencesTable, null));
				}
				
				referencesFragment.content(htmlFactory.panel(Style.PRIMARY, StringEscapeUtils.escapeHtml4(reference.getName()), referenceInfoFragment, null));
			}
			tabs.item("References", referencesFragment);
		}
	}
	
	private void generateComponentReferencedByTab(Component component, Tabs tabs) {
		List<ServiceReference<?>> allReferences = new ArrayList<>();
		for (Bundle bundle: docRoute.getBundleContext().getBundles()) {
			ServiceReference<?>[] siu = bundle.getServicesInUse();
			if (siu != null) {
				for (ServiceReference<?> sr: siu) {
					Object componentId = sr.getProperty(COMPONENT_ID_PROPERTY);
					if (componentId instanceof Long && component.getId() == ((Long) componentId).longValue()) {
						allReferences.add(sr);
					}														
				}
			}
		}
		
		List<Component> referencingComponents = new ArrayList<>();
		for (Component cmp: docRoute.getScrService().getComponents()) {
			Reference[] refs = cmp.getReferences();
			if (refs != null) {
				for (Reference ref: refs) {
					ServiceReference<?>[] svcs = ref.getServiceReferences();
					if (svcs != null) {
						for (ServiceReference<?> sr: svcs) {
							Object componentId = sr.getProperty(COMPONENT_ID_PROPERTY);
							if (componentId instanceof Long && component.getId() == ((Long) componentId).longValue()) {
								referencingComponents.add(cmp);
								allReferences.remove(sr); // Bound to component
							}									
						}
					}
				}
			}
		}
		
		Fragment referencedByFragment = htmlFactory.fragment();
		if (!referencingComponents.isEmpty()) {
			Table referencedByTable = htmlFactory.table().bordered();
			referencedByTable.headerRow("Bundle", "Bundle version", "Component").style(Style.PRIMARY);
			for (Component cmp: referencingComponents) {
				referencedByTable.row(docRoute.bundleLink(cmp.getBundle()), cmp.getBundle().getVersion(), docRoute.componentLink(cmp));
			}
			referencedByFragment.content(htmlFactory.tag(TagName.h4, "Components"), referencedByTable);
		}
				
		List<Bundle> referencingBundles = new ArrayList<>();
		for (ServiceReference<?> sr: allReferences) {
			for (Bundle bundle: sr.getUsingBundles()) {
				if (!referencingBundles.contains(bundle)) {
					referencingBundles.add(bundle);
				}
			}
		}

		if (!referencingBundles.isEmpty()) {
			Table referencedByTable = htmlFactory.table().bordered();
			referencedByTable.headerRow("Bundle", "Bundle version").style(Style.PRIMARY);
			for (Bundle bundle: referencingBundles) {
				referencedByTable.row(docRoute.bundleLink(bundle), bundle.getVersion());
			}
			referencedByFragment.content(htmlFactory.tag(TagName.h4, "Bundles"), referencedByTable);
		}		
		
		if (!referencedByFragment.isEmpty()) {
			tabs.item("Referenced by", referencedByFragment);
		}
	}
	
	
	private void generateComponentOverviewTab(Component component, Tabs tabs) {
		Fragment overviewContent = htmlFactory.fragment();		
		tabs.item("Overview", overviewContent);
		
		Table overviewTable = htmlFactory.table().bordered();
		overviewContent.content(overviewTable);
				
		Row stateRow = overviewTable.row();
		stateRow.header("State");
		
		switch (component.getState()) {
		
		case Component.STATE_DISABLED:
			stateRow.cell("Disabled");
			break;
		case Component.STATE_ENABLING:
			stateRow.cell("Enabling");
			break;
		case Component.STATE_UNSATISFIED:
			stateRow.cell("Unsatisfied");
			break;
		case Component.STATE_ACTIVATING:
			stateRow.cell("Activating");
			break;
		case Component.STATE_ACTIVE:
			stateRow.cell("Active");
			break;
		case Component.STATE_REGISTERED:
			stateRow.cell("Registered");
			break;
		case Component.STATE_FACTORY:
			stateRow.cell("Factory");
			break;
		case Component.STATE_DEACTIVATING:
			stateRow.cell("Deactivating");
			break;
		case Component.STATE_DISABLING:
			stateRow.cell("Disabling");
			break;
		case Component.STATE_DISPOSING:
			stateRow.cell("Disposing");
			break;
		case Component.STATE_DISPOSED:		
			stateRow.cell("Disposed");
			break;
		default:
			stateRow.cell("Undefined: "+component.getState());
			break;				
		}
		
		Row idRow = overviewTable.row();
		idRow.header("ID");
		idRow.cell(component.getId());
		
		
		String[] svcs = component.getServices();
		if (svcs != null && svcs.length > 0) {
			Row servicesRow = overviewTable.row();
			servicesRow.header("Services").rowspan(svcs.length);
			servicesRow.cell(docRoute.javaDocLink(svcs[0], true, false));
			for (int i = 1; i < svcs.length; ++i) {
				overviewTable.row(docRoute.javaDocLink(svcs[i], true, false));
			}
		}
		
		Row classRow = overviewTable.row();
		classRow.header("Class");
		classRow.cell(docRoute.javaDocLink(component.getClassName(), true, false));
						
		docRoute.mountedDocumentation(component.getBundle(), component.getName(), overviewContent);
	}	

}
