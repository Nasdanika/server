package org.nasdanika.cdo.web.doc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.osgi.util.ManifestElement;
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
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.VersionRange;

class BundleDocumentationGenerator extends BundleAndComponentDocumentationGeneratorBase {
	protected static final String REQUIRE_BUNDLE_MANIFEST_HEADER = "Require-Bundle";

	BundleDocumentationGenerator(DocRoute docRoute) {
		super(docRoute);
	}

	Action generateBundleContextDiagram(HttpServletRequestContext context, Bundle bundle) {
		try {
			context.getResponse().setContentType("image/png");
			generateContextDiagram(
					bundle, 
					Direction.valueOf(context.getRequest().getParameter("direction")), 
					Integer.parseInt(context.getRequest().getParameter("depth")), 
					Boolean.TRUE.toString().equals(context.getRequest().getParameter("dependencies")), 
					Boolean.TRUE.toString().equals(context.getRequest().getParameter("services")), 
					Boolean.TRUE.toString().equals(context.getRequest().getParameter("components")), 
					true,
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
		
	String generateBundleInfo(Bundle bundle) {
		Fragment ret = htmlFactory.fragment();
		ret.content(htmlFactory.tag(TagName.h3, "Bundle "+StringEscapeUtils.escapeHtml4(bundle.getSymbolicName())));
		Tabs tabs = htmlFactory.tabs().style().margin().right("5px");
		ret.content(tabs);
		
		generateBundleOverviewTab(bundle, tabs);		
		generateBundleHeadersTab(bundle, tabs);		
		generateBundleRequiredByTab(bundle, tabs);				
		generateBundleRegisteredServicesTab(bundle, tabs);
		generateServicesInUseTab(bundle, tabs);
		generateBundleContextDiagramTab(bundle, tabs);
		
		docRoute.sections(bundle, null, tabs);
		return ret.toString();
	}

	private void generateBundleContextDiagramTab(Bundle bundle, Tabs tabs) {
		String idBase = "bundleContextDiagram-"+bundle.getBundleId()+"-"+htmlFactory.nextId();
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
		for (int i=0; i<10; ++i) {
			depthSelect.option(String.valueOf(i), i==1, false, String.valueOf(i));
		}
		depthSelect.option("-1", false, false, "&infin;");
		diagramConfigurationForm.formGroup("Depth", depthSelect, "Dependency depth")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");		
		
		Input dependenciesCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("dependencies");
		diagramConfigurationForm.formGroup("Dependencies", dependenciesCheckbox, "Show dependencies (Require-Bundle)")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");

		Input servicesCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("services");
		diagramConfigurationForm.formGroup("Services", servicesCheckbox, "Show service references")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");
		
		if (docRoute.getScrService() != null && docRoute.getScrService().getComponents() != null) {
			Input componentsCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("components");
			diagramConfigurationForm.formGroup("Components", componentsCheckbox, "Show components in bundles")
				.style().border().right("dashed 1px silver")
				.style().padding().right("5px");
		}
		
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
		scriptEnv.put("diagram-url", docRoute.getDocRoutePath()+DocRoute.BUNDLE_INFO_PATH+bundle.getBundleId()+"/diagram.png");
		
		String script = htmlFactory.interpolate(getClass().getResource("BundleContextDiagramAppLoader.js"), scriptEnv);
		tabs.item("Context Diagram", htmlFactory.fragment(contextDiagramApp, htmlFactory.tag(TagName.script, script)));		
	}

	private void generateServicesInUseTab(Bundle bundle, Tabs tabs) {
		ServiceReference<?>[] servicesInUse = bundle.getServicesInUse();
		if (servicesInUse!=null) {
			Table servicesInUseTable = htmlFactory.table().bordered();
			Row hr1 = servicesInUseTable.row().style(Style.PRIMARY);
			hr1.header("Class(es)").rowspan(2);
			hr1.header("Bundle").rowspan(2);
			hr1.header("Component").rowspan(2);
			hr1.header("Scope").rowspan(2).bootstrap().text().center();
			hr1.header("Properties").colspan(3).bootstrap().text().center();
			servicesInUseTable.headerRow("Name", "Type", "Value(s)").style(Style.PRIMARY);
			
			for (ServiceReference<?> sr: servicesInUse) {
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
				
				Row serviceRow = servicesInUseTable.row();
				
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
						servicesInUseTable.row(StringEscapeUtils.escapeHtml4(entry.getKey()), valueTypeLink(entry.getValue()), renderValue(entry.getValue()));
					}
				}
			}
			tabs.item("Services In Use", servicesInUseTable);
		}
	}

	private void generateBundleRegisteredServicesTab(Bundle bundle, Tabs tabs) {
		ServiceReference<?>[] registeredServices = bundle.getRegisteredServices();
		if (registeredServices!=null) {
			Table registeredServicesTable = htmlFactory.table().bordered();
			Row hr1 = registeredServicesTable.row().style(Style.PRIMARY);
			hr1.header("Class(es)").rowspan(2);
			hr1.header("Component").rowspan(2);
			hr1.header("Scope").rowspan(2).bootstrap().text().center();
			hr1.header("Using bundle(s)").rowspan(2);
			hr1.header("Properties").colspan(3).bootstrap().text().center();
			registeredServicesTable.headerRow("Name", "Type", "Value(s)").style(Style.PRIMARY);
			
			for (ServiceReference<?> sr: registeredServices) {
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
				
				Row serviceRow = registeredServicesTable.row();
				
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
				
				// Component
				if (CoreUtil.isBlank(componentName) || componentId == null) {
					serviceRow.cell().rowspan(rowSpan);					
				} else {
					serviceRow.cell(docRoute.componentLink(componentName, componentId)).rowspan(rowSpan); 
				}
				
				// Scope
				serviceRow.cell(serviceScope == null ? "" : serviceScope).rowspan(rowSpan);										
								
				Bundle[] usingBundles = sr.getUsingBundles();
				if (usingBundles == null) {
					serviceRow.cell().rowspan(rowSpan);
				} else if (usingBundles.length == 1) {
					serviceRow.cell(docRoute.bundleLink(usingBundles[0])).rowspan(rowSpan); 					
				} else {
					Tag ul = htmlFactory.tag(TagName.ul);
					for (Bundle ub: usingBundles) {
						ul.content(htmlFactory.tag(TagName.li, docRoute.bundleLink(ub)));
					}
					serviceRow.cell(ul).rowspan(rowSpan);					
				}
				
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
						registeredServicesTable.row(StringEscapeUtils.escapeHtml4(entry.getKey()), valueTypeLink(entry.getValue()), renderValue(entry.getValue()));
					}
				}
			}
			tabs.item("Registered Services", registeredServicesTable);
		}
	}
	
	private void generateBundleRequiredByTab(Bundle bundle, Tabs tabs) {
		// Required by
		List<Bundle> siblings = new ArrayList<>();
		for (Bundle b: docRoute.getBundleContext().getBundles()) {
			if (b != bundle 
					&& b.getSymbolicName().equals(bundle.getSymbolicName()) 
					&& b.getVersion().compareTo(bundle.getVersion()) > 0) {
				siblings.add(b);
			}
		}
		
		List<Bundle> requiredBy = new ArrayList<>();
		
		RB: for (Bundle b: docRoute.getBundleContext().getBundles()) {
			if (b != bundle) {
				String requireBundle = b.getHeaders().get(REQUIRE_BUNDLE_MANIFEST_HEADER);
				if (!CoreUtil.isBlank(requireBundle)) {
					try {
						ManifestElement[] mea = ManifestElement.parseHeader(REQUIRE_BUNDLE_MANIFEST_HEADER, requireBundle);
						for (ManifestElement me: mea) {
							if (bundle.getSymbolicName().equals(me.getValue())) {
								String versionRange = me.getAttribute(DocRoute.BUNDLE_VERSION);
								VersionRange vr = versionRange == null ? null : new VersionRange(versionRange);
								if (vr == null || vr.includes(bundle.getVersion())) {
									for (Bundle sibling: siblings) {
										if (vr == null || vr.includes(sibling.getVersion())) {
											continue RB;
										}
									}
									requiredBy.add(b);
								}
							}
						}
					} catch (BundleException e) {
						System.err.println("Could not parse require bundle header for "+b);
						e.printStackTrace();
					}
				}
			}
		}
		
		if (!requiredBy.isEmpty()) {		
			Collections.sort(requiredBy, new Comparator<Bundle>() {
	
				@Override
				public int compare(Bundle o1, Bundle o2) {
					int cmp = o1.getSymbolicName().compareTo(o2.getSymbolicName());
					return cmp == 0 ? o1.getVersion().compareTo(o2.getVersion()) : cmp;
				}
				
			});
			
			Table requiredByTable = htmlFactory.table().bordered();
			requiredByTable.headerRow("Symbolic name", "Version").style(Style.PRIMARY);
			for (Bundle rb: requiredBy) {
				requiredByTable.row(docRoute.bundleLink(rb),	rb.getVersion());
			}
			tabs.item("Required by", requiredByTable);
		}
	}

	private void generateBundleOverviewTab(Bundle bundle, Tabs tabs) {
		Fragment overviewContent = htmlFactory.fragment();		
		tabs.item("Overview", overviewContent);
		
		Table overviewTable = htmlFactory.table().bordered();
		overviewContent.content(overviewTable);
		
		Row versionRow = overviewTable.row();
		versionRow.header("Version");
		versionRow.cell(bundle.getVersion());
		
		Row stateRow = overviewTable.row();
		stateRow.header("State");
		
		switch (bundle.getState()) {
		case Bundle.ACTIVE:
			stateRow.cell("Active");
			break;
		case Bundle.INSTALLED:
			stateRow.cell("Installed");
			break;
		case Bundle.RESOLVED:
			stateRow.cell("Resolved");
			break;
		case Bundle.STARTING:
			stateRow.cell("Starting");
			break;
		case Bundle.STOPPING:
			stateRow.cell("Stopping");
			break;
		case Bundle.UNINSTALLED:
			stateRow.cell("Uninstalled");
			break;				
		default:
			stateRow.cell("Undefined: "+bundle.getState());
			break;				
		}
		
		Row idRow = overviewTable.row();
		idRow.header("ID");
		idRow.cell(bundle.getBundleId());
		
		docRoute.mountedDocumentation(bundle, null, overviewContent);
	}

	private void generateBundleHeadersTab(Bundle bundle, Tabs tabs) {
		Table headersTable = htmlFactory.table().bordered();
		headersTable.headerRow("Name", "Value").style(Style.PRIMARY);
		for (String header: Collections.list(bundle.getHeaders().keys())) {
			try {
				ManifestElement[] manifestElements = ManifestElement.parseHeader(header, bundle.getHeaders().get(header));
				if (manifestElements != null) {
					if (REQUIRE_BUNDLE_MANIFEST_HEADER.equals(header)) {
						Table requireBundlesTable = htmlFactory.table().bordered();
						requireBundlesTable.headerRow("Symbolic name", "Version").style(Style.PRIMARY);
						for (ManifestElement me: manifestElements) {
							String symbolicName = me.getValue();
							String versionRange = me.getAttribute(DocRoute.BUNDLE_VERSION);
							VersionRange vr = versionRange == null ? null : new VersionRange(versionRange);
							Bundle targetBundle = null;
							for (Bundle rb: docRoute.getBundleContext().getBundles()) {
								if (rb.getSymbolicName().equals(symbolicName) && (vr == null || vr.includes(rb.getVersion()))) {
									if (targetBundle == null || targetBundle.getVersion().compareTo(rb.getVersion()) < 0) {
										targetBundle = rb;
									}
								}
							}
							requireBundlesTable.row(
									targetBundle == null ? symbolicName : docRoute.bundleLink(targetBundle), 
									versionRange == null ? "" : versionRange);
						}
						tabs.item("Required bundles", requireBundlesTable);
					} else {
						if (manifestElements.length == 1) {
							headersTable.row(StringEscapeUtils.escapeHtml4(header), StringEscapeUtils.escapeHtml4(manifestElements[0].toString()));
						} else {								
							Tag list = htmlFactory.tag(TagName.ul);
							for (ManifestElement me: manifestElements) {
								list.content(htmlFactory.tag(TagName.li, StringEscapeUtils.escapeHtml4(me.toString())));
							}	
							headersTable.row(StringEscapeUtils.escapeHtml4(header), list);
						}
					}
				}
			} catch (BundleException e) {
				headersTable.row(header, "Exception: "+e.toString());
				e.printStackTrace();
			}
		}
		tabs.item("Headers", headersTable);
	}

}
