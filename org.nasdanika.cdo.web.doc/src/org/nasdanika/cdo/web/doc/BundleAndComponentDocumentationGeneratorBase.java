package org.nasdanika.cdo.web.doc;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.ECollections;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Modal;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.TextArea;
import org.nasdanika.osgi.model.Element;
import org.nasdanika.osgi.model.ModelFactory;
import org.nasdanika.osgi.model.Runtime;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.service.component.runtime.dto.ComponentConfigurationDTO;

import net.sourceforge.plantuml.SourceStringReader;

class BundleAndComponentDocumentationGeneratorBase {
	protected static final String COMPONENT_ID_PROPERTY = "component.id";
	
	protected final DocRoute docRoute;
	protected final String defaultIncludes;
	protected final String defaultExcludes;
	
	protected BundleAndComponentDocumentationGeneratorBase(DocRoute docRoute, String defaultIncludes, String defaultExcludes) {
		this.docRoute = docRoute;
		this.defaultIncludes = defaultIncludes;
		this.defaultExcludes = defaultExcludes;
	}
	
	protected enum Direction { in, out, both }
	protected enum Types { hide, name, fullyQualifiedName }
	
	protected void generateContextDiagram(
			Collection<Object> contextObjects, 
			Direction direction,
			int depth,
			boolean dependencies,
			boolean services,
			boolean components,
			boolean allBundleComponents,
			Types types,
			boolean leftToRightDirection,
			String width,
			String includes,
			String excludes,
			OutputStream out) throws IOException, BundleException {
				
		Runtime runtime = ModelFactory.eINSTANCE.createRuntime();
		runtime.load(ECollections.newBasicEList(docRoute.getBundleContext().getBundles()), docRoute.getServiceComponentRuntime());
		
		Collection<Pattern> includePatterns = new ArrayList<>();
		if (!CoreUtil.isBlank(includes)) {
			for (String ie: includes.split("\\R")) {
				if (!CoreUtil.isBlank(ie)) {
					includePatterns.add(Pattern.compile(ie));
				}
			}				
		}
		
		Collection<Pattern> excludePatterns = new ArrayList<>();
		if (!CoreUtil.isBlank(excludes)) {
			for (String ee: excludes.split("\\R")) {
				if (!CoreUtil.isBlank(ee)) {
					excludePatterns.add(Pattern.compile(ee));
				}
			}				
		}
				
		Set<Element> diagramElements = new HashSet<>();
		Set<Element> contextElements = new HashSet<>();
		
		for (Object contextObject: contextObjects) {
			Element contextElement = null;
			for (org.nasdanika.osgi.model.Bundle mBundle: runtime.getBundles()) {
				if (contextObject instanceof Bundle) {
					if (((Bundle) contextObject).getBundleId() == mBundle.getId()) {
						contextElement = mBundle;
						contextElements.add(contextElement);
						break;
					}
				} else {
					for (org.nasdanika.osgi.model.Component mComponent: mBundle.getComponents()) {
						if (((ComponentConfigurationDTO) contextObject).id == mComponent.getId()) {
							contextElement = mComponent;
							contextElements.add(contextElement);
							break;
						}
					}
				}
			}
			
			Set<Element> coInDiagramElements = new HashSet<>();
			Set<Element> coOutDiagramElements = new HashSet<>();
			collectDiagramElements(contextElement, direction, depth, dependencies, services, includePatterns, excludePatterns, coInDiagramElements, coOutDiagramElements);
			if (contextElement instanceof org.nasdanika.osgi.model.Bundle) {
				for (org.nasdanika.osgi.model.Component cmp: ((org.nasdanika.osgi.model.Bundle) contextElement).getComponents()) {
					Set<Element> cdeIn = new HashSet<>();
					Set<Element> cdeOut = new HashSet<>();
					collectDiagramElements(cmp, direction, depth, dependencies, services, includePatterns, excludePatterns, cdeIn, cdeOut);
					coInDiagramElements.addAll(cdeIn);
					coOutDiagramElements.addAll(cdeOut);
					contextElements.add(cmp);
				}
			} else {
				// Component
				contextElements.add((org.nasdanika.osgi.model.Bundle) contextElement.eContainer());
			}
			
			diagramElements.addAll(coInDiagramElements);
			diagramElements.addAll(coOutDiagramElements);
		}
				
		StringBuilder specBuilder = new StringBuilder("@startuml").append(System.lineSeparator());
		if (leftToRightDirection) {
			specBuilder.append("left to right direction").append(System.lineSeparator());
		}
		
		if (width != null) {
			specBuilder.append("scale ").append(width).append(" width").append(System.lineSeparator());
		}
		
		if (diagramElements.isEmpty()) { 
			specBuilder.append("note \"No matching elements\" as NO_MATCHING_ELEMENTS_NOTE").append(System.lineSeparator());
		} else {
			
			// Adding component containers			
			for (Element de: new ArrayList<>(diagramElements)) {
				if (de instanceof org.nasdanika.osgi.model.Component) {
					diagramElements.add((Element) de.eContainer());
				}
			}
			
			// Element definitions
			for (Element de: diagramElements) {
				if (de instanceof org.nasdanika.osgi.model.Bundle) {
					org.nasdanika.osgi.model.Bundle bundle = (org.nasdanika.osgi.model.Bundle) de;
					if (components) {
						List<org.nasdanika.osgi.model.Component> bundleComponents = new ArrayList<>();
						for (org.nasdanika.osgi.model.Component component: bundle.getComponents()) {
							if (allBundleComponents || diagramElements.contains(component)) {
								bundleComponents.add(component);
							}
						}
						
						if (bundleComponents.isEmpty()) {
							specBuilder.append("component \""+bundle.getSymbolicName()+" ("+bundle.getVersion()+")\" <<Bundle>> as "+bundle.eClass().getName()+"_"+bundle.getId());
							if (!contextElements.contains(bundle)) {
								specBuilder.append(" #DDDDDD");
							}		
							specBuilder.append(System.lineSeparator());						
						} else {
							specBuilder.append("package \""+bundle.getSymbolicName()+" "+bundle.getVersion()+"\" as "+bundle.eClass().getName()+"_"+bundle.getId());
							if (!contextElements.contains(bundle)) {
								specBuilder.append(" #DDDDDD");
							}								
							specBuilder.append(" {"+System.lineSeparator());
							
							for (org.nasdanika.osgi.model.Component component: bundleComponents) {
								String componentAlias = component.eClass().getName()+"_"+component.getId();
								specBuilder.append("\tcomponent \""+component.getName()+"\" as "+componentAlias+" <<Component>>");
								if (!contextElements.contains(component)) {
									specBuilder.append(" #DDDDDD");
								}		
								specBuilder.append(System.lineSeparator());														
								for (String svc: component.getServices()) {
									specBuilder.append("\tinterface \"");
									if (types == Types.name) {
										specBuilder.append(svc.substring(svc.lastIndexOf('.')+1));
									} else {
										specBuilder.append(svc);										
									}
									specBuilder.append("\" as "+componentAlias+"_"+svc);
									if (!contextElements.contains(component)) {
										specBuilder.append(" #DDDDDD");
									}											
									specBuilder.append(System.lineSeparator());
									specBuilder.append("\t"+componentAlias+"_"+svc+" -d- ["+componentAlias+"]");
									specBuilder.append(System.lineSeparator());
								}
							}
							specBuilder.append("}").append(System.lineSeparator());
						}						
					} else {
						specBuilder.append("component \""+bundle.getSymbolicName()+"\" <<"+bundle.getVersion()+">> as "+bundle.eClass().getName()+"_"+bundle.getId());
						if (!contextElements.contains(de)) {
							specBuilder.append(" #DDDDDD");
						}		
						specBuilder.append(System.lineSeparator());						
					}
				}
			}
						
			// Relationships
			for (Element source: diagramElements) {
				//System.out.println(source.eClass().getName());
				// Require bundle
				String sourceAlias = source.eClass().getName()+"_"+source.getId();
				if (dependencies && source instanceof org.nasdanika.osgi.model.Bundle && (!components || ((org.nasdanika.osgi.model.Bundle) source).getComponents().isEmpty()) ) { // references from packages are not supported - hiding.
					for (org.nasdanika.osgi.model.Bundle rb: ((org.nasdanika.osgi.model.Bundle) source).getRequires()) {
						if (diagramElements.contains(rb)) {
							specBuilder.append(sourceAlias+" .d.> "+rb.eClass().getName()+"_"+rb.getId()).append(System.lineSeparator());
						}
					}					
				}
				
				// References
				if (services) {
					if (source instanceof org.nasdanika.osgi.model.Bundle) {		
						if (!components || ((org.nasdanika.osgi.model.Bundle) source).getComponents().isEmpty()) { // No support for references from packages - hiding.
							for (org.nasdanika.osgi.model.ServiceReference ref: source.getOutboundReferences()) {
								Element trg = ref.getReferenceTarget();							
								if (trg instanceof org.nasdanika.osgi.model.Component && !components) {
									trg = (Element) trg.eContainer();
								}
								if (trg != source && diagramElements.contains(trg)) {
									specBuilder.append("["+sourceAlias+"] -d-> ");
									String targetAlias = trg.eClass().getName()+"_"+trg.getId();
									boolean serviceMatched = false;
									if (trg instanceof org.nasdanika.osgi.model.Component) {
										for (String svc: ((org.nasdanika.osgi.model.Component) trg).getServices()) {
											if (svc.equals(ref.getInterfaceName())) {
												specBuilder.append(targetAlias+"_"+svc);
												serviceMatched = true;
												break;
											}
										}
									}
									
									if (!serviceMatched) {
										specBuilder.append("["+targetAlias+"]");
										if (types != Types.hide) {
											for (int i=0; i < ref.getObjectClass().size(); ++i) {
												specBuilder.append(i == 0 ? " : " : ", ");
												String oc = ref.getObjectClass().get(i);
												specBuilder.append(types == Types.fullyQualifiedName ? oc : oc.substring(oc.lastIndexOf('.')+1));
											}
										}
									}
									specBuilder.append(System.lineSeparator());	
								}
							}
							if (!components) {
								for (org.nasdanika.osgi.model.Component cmp: ((org.nasdanika.osgi.model.Bundle) source).getComponents()) {
									for (org.nasdanika.osgi.model.ServiceReference ref: cmp.getOutboundReferences()) {
										Element trg = ref.getReferenceTarget();							
										if (trg instanceof org.nasdanika.osgi.model.Component && !components) {
											trg = (Element) trg.eContainer();
										}
										if (trg != source && diagramElements.contains(trg)) {
											String targetAlias = trg.eClass().getName()+"_"+trg.getId();
											specBuilder.append("["+sourceAlias+"] -d-> ["+targetAlias+"]");
											if (types != Types.hide) {
												for (int i=0; i < ref.getObjectClass().size(); ++i) {
													specBuilder.append(i == 0 ? " : " : ", ");
													String oc = ref.getObjectClass().get(i);
													specBuilder.append(types == Types.fullyQualifiedName ? oc : oc.substring(oc.lastIndexOf('.')+1));
												}
											}																		
											specBuilder.append(System.lineSeparator());
										}
									}
								}
							}
						}
					} else if (components) { 
						for (org.nasdanika.osgi.model.ServiceReference ref: source.getOutboundReferences()) {
							Element trg = ref.getReferenceTarget();
							if (diagramElements.contains(trg)) {
								String targetAlias = trg.eClass().getName()+"_"+trg.getId();
								specBuilder.append("["+sourceAlias+"] -d-> ");
								boolean serviceMatched = false;
								if (trg instanceof org.nasdanika.osgi.model.Component) {
									for (String svc: ((org.nasdanika.osgi.model.Component) trg).getServices()) {
										if (svc.equals(ref.getInterfaceName())) {
											specBuilder.append(targetAlias+"_"+svc);
											if (ref.getName() != null) {
												specBuilder.append(" : ").append(ref.getName());
											}											
											serviceMatched = true;
											break;
										}
									}
								}
								
								if (!serviceMatched) {								
									specBuilder.append("["+targetAlias+"] : ");
									if (types != Types.hide) {
										for (int i=0; i < ref.getObjectClass().size(); ++i) {
											if (i > 0) {
												specBuilder.append(", ");
											}
											String oc = ref.getObjectClass().get(i);
											specBuilder.append(types == Types.fullyQualifiedName ? oc : oc.substring(oc.lastIndexOf('.')+1));
										}
									}						
									
									if (ref.getName() != null) {
										specBuilder.append(" (").append(ref.getName()).append(")");
									}
								}
								
								specBuilder.append(System.lineSeparator());
							}
						}
					}
				}								
			}						
		}		
		
		specBuilder.append("@enduml").append(System.lineSeparator());
//		System.out.println(specBuilder);
		SourceStringReader reader = new SourceStringReader(specBuilder.toString());
		reader.generateImage(out);		
				
	}
	
	private void collectDiagramElements(
			Element candidate, 
			Direction direction,
			int depth,
			boolean dependencies,
			boolean services,
			Collection<Pattern> includes,
			Collection<Pattern> excludes,
			Set<Element> inDiagramElements,
			Set<Element> outDiagramElements) {
		
		if (!excludes.isEmpty() || !includes.isEmpty()) {
			String symbolicName = ((org.nasdanika.osgi.model.Bundle) (candidate instanceof org.nasdanika.osgi.model.Bundle ? candidate : candidate.eContainer())).getSymbolicName();
			boolean matched = includes.isEmpty();
			for (Pattern includePattern: includes) {
				if (includePattern.matcher(symbolicName).matches()) {
					matched = true;
					break;
				}
			}
			if (!matched) {
				return;
			}
			for (Pattern excludePattern: excludes) {
				if (excludePattern.matcher(symbolicName).matches()) {
					return;
				}
			}
		}			

		if (direction == Direction.in || direction == Direction.both) {
			if (inDiagramElements.add(candidate) && depth != 0) {			
				if (services) {
					for (org.nasdanika.osgi.model.ServiceReference ir: candidate.getInboundReferences()) {
						collectDiagramElements(
								(Element) ir.eContainer(), 
								Direction.in, 
								depth-1, 
								dependencies, 
								services, 
								includes, 
								excludes, 
								inDiagramElements,
								null);
					}
				}
				if (dependencies && candidate instanceof org.nasdanika.osgi.model.Bundle) {
					for (org.nasdanika.osgi.model.Bundle rb: ((org.nasdanika.osgi.model.Bundle) candidate).getRequiredBy()) {
						collectDiagramElements(
								rb, 
								Direction.in, 
								depth-1, 
								dependencies, 
								services, 
								includes, 
								excludes, 
								inDiagramElements, 
								null);
					}
				}
			}
		} 
			
		if (direction == Direction.out || direction == Direction.both) {
			if (outDiagramElements.add(candidate) && depth != 0) {			
				if (services) {
					for (org.nasdanika.osgi.model.ServiceReference ir: candidate.getOutboundReferences()) {
						collectDiagramElements(
								ir.getReferenceTarget(), 
								Direction.out, 
								depth-1, 
								dependencies, 
								services, 
								includes, 
								excludes, 
								null,
								outDiagramElements);
					}
				}
				if (dependencies && candidate instanceof org.nasdanika.osgi.model.Bundle) {
					for (org.nasdanika.osgi.model.Bundle rb: ((org.nasdanika.osgi.model.Bundle) candidate).getRequires()) {
						collectDiagramElements(
								rb, 
								Direction.out, 
								depth-1, 
								dependencies, 
								services, 
								includes, 
								excludes, 
								null,
								outDiagramElements);
					}
				}
			}
		}
	}
	
	protected String valueTypeLink(Object value) {
		if (value == null) {
			return "";
		}
		if (value.getClass().isArray()) {
			return docRoute.javaDocLink(value.getClass().getComponentType().getName(), true, true);
		}
		return docRoute.javaDocLink(value.getClass().getName(), true, false);
	}
	
	protected Object renderValue(Object value) {
		if (value == null) {
			return "";
		}
		if (value.getClass().isArray()) {
			Tag ul = getHtmlFactory().tag(TagName.ul);
			for (int i = 0; i < Array.getLength(value); ++i) {
				ul.content(getHtmlFactory().tag(TagName.li, renderValue(Array.get(value, i))));
			}
			return ul;
		}
		return StringEscapeUtils.escapeHtml4(value.toString());
		
	}

	protected HTMLFactory getHtmlFactory() {
		return docRoute.getHtmlFactory();
	}

	protected Modal createFilterModal() {
		Modal filterModal = getHtmlFactory().modal();
		filterModal.title("Filter bundles");
		Form filterForm = getHtmlFactory().form();
		TextArea formIncludes = getHtmlFactory().textArea().rows(4).knockout().value("formIncludes");
		filterForm.formGroup("Includes", formIncludes, "Include bundles regex patterns");
		TextArea formExcludes = getHtmlFactory().textArea().rows(4).knockout().value("formExcludes");
		filterForm.formGroup("Excludes", formExcludes, "Exclude bundles regex patterns");
		filterModal.body(filterForm);
		filterModal.footer(
				getHtmlFactory().button("Filter")
					.style(Style.PRIMARY)
					.knockout().click("filter")
					.style().margin().right("10px"),
				getHtmlFactory().button("Close").attribute("data-dismiss", "modal"));
		return filterModal;
	}

}
