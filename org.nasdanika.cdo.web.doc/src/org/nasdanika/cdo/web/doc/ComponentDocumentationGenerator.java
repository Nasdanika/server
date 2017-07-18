package org.nasdanika.cdo.web.doc;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Select;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.dto.ServiceReferenceDTO;
import org.osgi.service.component.runtime.dto.ComponentConfigurationDTO;
import org.osgi.service.component.runtime.dto.SatisfiedReferenceDTO;

class ComponentDocumentationGenerator extends BundleAndComponentDocumentationGeneratorBase {

	ComponentDocumentationGenerator(DocRoute docRoute, String defaultIncludes, String defaultExcludes) {
		super(docRoute, defaultIncludes, defaultExcludes);
	}

	Action generateComponentContextDiagram(HttpServletRequestContext context, ComponentConfigurationDTO componentConfiguration) {
		try {
			context.getResponse().setContentType("image/png");
			generateContextDiagram(
					Collections.<Object>singleton(componentConfiguration), 
					Direction.valueOf(context.getRequest().getParameter("direction")), 
					Integer.parseInt(context.getRequest().getParameter("depth")), 
					false, 
					true, 
					true, 
					false,
					Types.valueOf(context.getRequest().getParameter("types")), 
					Boolean.TRUE.toString().equals(context.getRequest().getParameter("leftToRightDirection")),
					context.getRequest().getParameter("width"),
					context.getRequest().getParameter("includes"),
					context.getRequest().getParameter("excludes"),
					context.getResponse().getOutputStream());
			return Action.NOP;
		} catch (IOException | BundleException e) {
			e.printStackTrace();
			return Action.INTERNAL_SERVER_ERROR;
		}
	}
	
	String generateComponentInfo(ComponentConfigurationDTO componentConfiguration) {
		Fragment ret = getHtmlFactory().fragment();
		ret.content(getHtmlFactory().tag(TagName.h3, "Component "+StringEscapeUtils.escapeHtml4(componentConfiguration.description.name)));
		Tabs tabs = getHtmlFactory().tabs().style().margin().right("5px");
		ret.content(tabs);
		
		generateComponentOverviewTab(componentConfiguration, tabs);		
		generateComponentPropertiesTab(componentConfiguration, tabs);
		generateComponentSatisfiedReferencesTab(componentConfiguration, tabs);
		generateComponentReferencedByTab(componentConfiguration, tabs);
		generateComponentContextDiagramTab(componentConfiguration, tabs);
		
		docRoute.sections(docRoute.getBundleContext().getBundle(componentConfiguration.description.bundle.id), componentConfiguration.description.name, tabs);
		
		return ret.toString();
	}
	
	private void generateComponentPropertiesTab(ComponentConfigurationDTO componentConfiguration, Tabs tabs) {
		Map<String, Object> properties = componentConfiguration.properties;
		if (properties != null && !properties.isEmpty()) {
			Map<String, Object> cProperties = new TreeMap<>();
			for (String pKey: properties.keySet()) {
				cProperties.put(pKey, properties.get(pKey));
			}
			cProperties.remove("objectClass");
			cProperties.remove("component.name");
			cProperties.remove(COMPONENT_ID_PROPERTY);

			if (!cProperties.isEmpty()) {
				Table propertiesTable = getHtmlFactory().table().bordered();
				propertiesTable.headerRow("Name", "Type", "Value(s)").style(Style.PRIMARY);
				
				for (Entry<String, Object> pe: cProperties.entrySet()) {
					propertiesTable.row(StringEscapeUtils.escapeHtml4(pe.getKey()), valueTypeLink(pe.getValue()), renderValue(pe.getValue()));
				}
				tabs.item("Properties", propertiesTable);
			}
		}		
	}
	
	private void generateComponentContextDiagramTab(ComponentConfigurationDTO componentConfiguration, Tabs tabs) {
		String idBase = "componentContextDiagram-"+componentConfiguration.id+"-"+getHtmlFactory().nextId();
		Tag contextDiagramApp = getHtmlFactory().div().id(idBase + "-app");
		
		contextDiagramApp.content(getHtmlFactory().spinnerOverlay(Spinner.cog).id(idBase+"-overlay"));
		
		Form diagramConfigurationForm = getHtmlFactory().form()
				.inline(true, false)
				.style().border("1px silver solid")
				.style().border().top("none")
				.style().padding("3px")
				.style().margin().bottom("3px");
		
		contextDiagramApp.content(diagramConfigurationForm);
		
		Select directionSelect = getHtmlFactory().select().knockout().value("direction");
		directionSelect.option("in", false, false, "In");
		directionSelect.option("out", false, false, "Out");
		directionSelect.option("both", true, false, "Both");
		diagramConfigurationForm.formGroup("Direction", directionSelect, "Related elements to display")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");

		Select depthSelect = getHtmlFactory().select().knockout().value("depth");
		for (int i=1; i<10; ++i) {
			depthSelect.option(String.valueOf(i), i==1, false, String.valueOf(i));
		}
		depthSelect.option("-1", false, false, "&infin;");
		diagramConfigurationForm.formGroup("Depth", depthSelect, "Dependency depth")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");		
		
		Select typesSelect = getHtmlFactory().select().knockout().value("types");
		typesSelect.option("hide", false, false, "Hide");
		typesSelect.option("name", false, false, "Name");
		typesSelect.option("fullyQualifiedName", true, false, "Fully Qualified Name");
		diagramConfigurationForm.formGroup("Types", typesSelect, "How to display types")		
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");

		Input leftToRightDirectionCheckbox = getHtmlFactory().input(InputType.checkbox).knockout().checked("leftToRightDirection");
		diagramConfigurationForm.formGroup("Left to right", leftToRightDirectionCheckbox, "Diagram direction")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");
		
		Input fitWidthCheckbox = getHtmlFactory().input(InputType.checkbox).knockout().checked("fitWidth");
		diagramConfigurationForm.formGroup("Fit width", fitWidthCheckbox, "Scale diagram to fit width")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");
		
		diagramConfigurationForm.button(getHtmlFactory().fontAwesome().webApplication(WebApplication.filter))
			.knockout().click("showFilterModal");
				
		contextDiagramApp.content(createFilterModal().id(idBase+"-modal"));
				
		Tag img = getHtmlFactory().tag(TagName.img)
				.knockout().attr("diagramAttributes")
				.knockout().event("{ load : imageLoaded }");
		
		Tag diagramDiv = getHtmlFactory().div(img);
		
		contextDiagramApp.content(diagramDiv);
				
		Map<String, Object> scriptEnv = new HashMap<>();
		scriptEnv.put("docRoutePath", docRoute.getDocRoutePath());
		scriptEnv.put("id-base", idBase);
		scriptEnv.put("diagram-url", docRoute.getDocRoutePath()+DocRoute.COMPONENT_INFO_PATH+componentConfiguration.id+"/diagram.png");
		scriptEnv.put("default-includes", defaultIncludes);
		scriptEnv.put("default-excludes", defaultExcludes);
		
		String script = getHtmlFactory().interpolate(getClass().getResource("BundleContextDiagramAppLoader.js"), scriptEnv);
		tabs.item("Context Diagram", getHtmlFactory().fragment(contextDiagramApp, getHtmlFactory().tag(TagName.script, script)));		
	}
	
	// TODO Unsatisfied references
	
	private void generateComponentSatisfiedReferencesTab(ComponentConfigurationDTO componentConfiguration, Tabs tabs) {
		SatisfiedReferenceDTO[] satisfiedReferences = componentConfiguration.satisfiedReferences;
		if (satisfiedReferences != null && satisfiedReferences.length > 0) {
			Fragment referencesFragment = getHtmlFactory().fragment();
			for (SatisfiedReferenceDTO reference: satisfiedReferences) {
				Table referenceInfoTable = getHtmlFactory().table().bordered();				
				Fragment referenceInfoFragment = getHtmlFactory().fragment(referenceInfoTable);
								
				if (!CoreUtil.isBlank(reference.target)) {
					Row targetRow = referenceInfoTable.row();
					targetRow.header("Target");
					targetRow.cell(StringEscapeUtils.escapeHtml4(reference.target));
				}
				
				ServiceReferenceDTO[] boundServices = reference.boundServices;
				if (boundServices != null && boundServices.length > 0) {
					Table serviceReferencesTable = getHtmlFactory().table().bordered();
					Row hr1 = serviceReferencesTable.row().style(Style.PRIMARY);
//					hr1.header("Interface").rowspan(2);
					hr1.header("Class(es)").rowspan(2);
					hr1.header("Bundle").rowspan(2);
					hr1.header("Component").rowspan(2);
					hr1.header("Scope").rowspan(2).bootstrap().text().center();
					hr1.header("Properties").colspan(3).bootstrap().text().center();
					serviceReferencesTable.headerRow("Name", "Type", "Value(s)").style(Style.PRIMARY);
					
					for (ServiceReferenceDTO sr: boundServices) {
						Map<String, Object> properties = sr.properties;
						Map<String, Object> serviceProperties = new TreeMap<>();
						if (properties != null) {
							for (String pKey: properties.keySet()) {
								serviceProperties.put(pKey, properties.get(pKey));
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

						// Interface
//						serviceRow.cell(docRoute.javaDocLink(objectClass[0], true, false)).rowspan(rowSpan);	
						
						// Service class
						if (objectClass.length == 0) {
							serviceRow.cell().rowspan(rowSpan);
						} else if (objectClass.length == 1) {
							serviceRow.cell(docRoute.javaDocLink(objectClass[0], true, false)).rowspan(rowSpan);
						} else {
							Tag ul = getHtmlFactory().tag(TagName.ul);
							for (String oc: objectClass) {
								ul.content(getHtmlFactory().tag(TagName.li, docRoute.javaDocLink(oc, true, false)));
							}
							serviceRow.cell(ul).rowspan(rowSpan);
						}
						
						serviceRow.cell(docRoute.bundleLink(docRoute.getBundleContext().getBundle(sr.bundle))).rowspan(rowSpan); 					
						
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
					referenceInfoFragment.content(getHtmlFactory().panel(Style.PRIMARY, "Service references", serviceReferencesTable, null));
				}
				
				referencesFragment.content(getHtmlFactory().panel(Style.PRIMARY, StringEscapeUtils.escapeHtml4(reference.name), referenceInfoFragment, null));
			}
			tabs.item("Satisfied references", referencesFragment);
		}
	}
	
	private void generateComponentReferencedByTab(ComponentConfigurationDTO componentConfiguration, Tabs tabs) {
		// TODO - migrate to the new API
//		List<ServiceReference<?>> allReferences = new ArrayList<>();
//		for (Bundle bundle: docRoute.getBundleContext().getBundles()) {
//			ServiceReference<?>[] siu = bundle.getServicesInUse();
//			if (siu != null) {
//				for (ServiceReference<?> sr: siu) {
//					Object componentId = sr.getProperty(COMPONENT_ID_PROPERTY);
//					if (componentId instanceof Long && componentConfiguration.getId() == ((Long) componentId).longValue()) {
//						allReferences.add(sr);
//					}														
//				}
//			}
//		}
//		
//		List<Component> referencingComponents = new ArrayList<>();
//		for (Component cmp: docRoute.getServiceComponentRuntime().getComponents()) {
//			Reference[] refs = cmp.getReferences();
//			if (refs != null) {
//				for (Reference ref: refs) {
//					ServiceReference<?>[] svcs = ref.getServiceReferences();
//					if (svcs != null) {
//						for (ServiceReference<?> sr: svcs) {
//							Object componentId = sr.getProperty(COMPONENT_ID_PROPERTY);
//							if (componentId instanceof Long && componentConfiguration.getId() == ((Long) componentId).longValue()) {
//								referencingComponents.add(cmp);
//								allReferences.remove(sr); // Bound to component
//							}									
//						}
//					}
//				}
//			}
//		}
//		
		Fragment referencedByFragment = getHtmlFactory().fragment();
//		if (!referencingComponents.isEmpty()) {
//			Table referencedByTable = getHtmlFactory().table().bordered();
//			referencedByTable.headerRow("Bundle", "Bundle version", "Component").style(Style.PRIMARY);
//			for (Component cmp: referencingComponents) {
//				referencedByTable.row(docRoute.bundleLink(cmp.getBundle()), cmp.getBundle().getVersion(), docRoute.componentLink(cmp));
//			}
//			referencedByFragment.content(getHtmlFactory().tag(TagName.h4, "Components"), referencedByTable);
//		}
//				
//		List<Bundle> referencingBundles = new ArrayList<>();
//		for (ServiceReference<?> sr: allReferences) {
//			for (Bundle bundle: sr.getUsingBundles()) {
//				if (!referencingBundles.contains(bundle)) {
//					referencingBundles.add(bundle);
//				}
//			}
//		}
//
//		if (!referencingBundles.isEmpty()) {
//			Table referencedByTable = getHtmlFactory().table().bordered();
//			referencedByTable.headerRow("Bundle", "Bundle version").style(Style.PRIMARY);
//			for (Bundle bundle: referencingBundles) {
//				referencedByTable.row(docRoute.bundleLink(bundle), bundle.getVersion());
//			}
//			referencedByFragment.content(getHtmlFactory().tag(TagName.h4, "Bundles"), referencedByTable);
//		}		
		
		if (!referencedByFragment.isEmpty()) {
			tabs.item("Referenced by", referencedByFragment);
		}
	}
	
	
	private void generateComponentOverviewTab(ComponentConfigurationDTO componentConfiguration, Tabs tabs) {
		Fragment overviewContent = getHtmlFactory().fragment();		
		tabs.item("Overview", overviewContent);
		
		Table overviewTable = getHtmlFactory().table().bordered();
		overviewContent.content(overviewTable);
				
		Row stateRow = overviewTable.row();
		stateRow.header("State");
		
		switch (componentConfiguration.state) {
		
		case ComponentConfigurationDTO.ACTIVE:
			stateRow.cell("Active");
			break;
		case ComponentConfigurationDTO.SATISFIED:
			stateRow.cell("Satisfied");
			break;
		case ComponentConfigurationDTO.UNSATISFIED_CONFIGURATION:
			stateRow.cell("Unsatisfied configuration");
			break;
		case ComponentConfigurationDTO.UNSATISFIED_REFERENCE:
			stateRow.cell("Unsatisfied reference");
			break;
		default:
			stateRow.cell("Undefined: "+componentConfiguration.state);
			break;				
		}
		
		Row idRow = overviewTable.row();
		idRow.header("ID");
		idRow.cell(componentConfiguration.id);
		
		
		String[] svcs = componentConfiguration.description.serviceInterfaces;
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
		classRow.cell(docRoute.javaDocLink(componentConfiguration.description.implementationClass, true, false));
						
		docRoute.mountedDocumentation(docRoute.getBundleContext().getBundle(componentConfiguration.description.bundle.id), componentConfiguration.description.name, overviewContent);
	}	

}
