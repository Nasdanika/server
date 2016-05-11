package org.nasdanika.cdo.web.doc;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.felix.scr.Component;
import org.eclipse.emf.common.util.ECollections;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.osgi.model.Element;
import org.nasdanika.osgi.model.ModelFactory;
import org.nasdanika.osgi.model.Runtime;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import net.sourceforge.plantuml.SourceStringReader;

class BundleAndComponentDocumentationGeneratorBase {
	protected static final String COMPONENT_ID_PROPERTY = "component.id";
	
	protected final DocRoute docRoute;
	protected final HTMLFactory htmlFactory;

	protected BundleAndComponentDocumentationGeneratorBase(DocRoute docRoute) {
		this.docRoute = docRoute;
		this.htmlFactory = docRoute.getHtmlFactory(); 
	}
	
	protected enum Direction { in, out, both }
	protected enum Types { hide, name, fullyQualifiedName }
	
	protected void generateContextDiagram(
			Object contextObject, 
			Direction direction,
			int depth,
			boolean dependencies,
			boolean services,
			boolean components,
			boolean allBundleComponents,
			Types types,
			boolean leftToRightDirection,
			String width,
			OutputStream out) throws IOException, BundleException {
		
		Runtime runtime = ModelFactory.eINSTANCE.createRuntime();
		runtime.load(ECollections.newBasicEList(docRoute.getBundleContext().getBundles()), docRoute.getScrService());
				
		Element contextElement = null;
		for (org.nasdanika.osgi.model.Bundle mBundle: runtime.getBundles()) {
			if (contextObject instanceof Bundle) {
				if (((Bundle) contextObject).getBundleId() == mBundle.getId()) {
					contextElement = mBundle;
					break;
				}
			} else {
				for (org.nasdanika.osgi.model.Component mComponent: mBundle.getComponents()) {
					if (((Component) contextObject).getId() == mComponent.getId()) {
						contextElement = mComponent;
						break;
					}
				}
			}
		}
		
		StringBuilder specBuilder = new StringBuilder("@startuml").append(System.lineSeparator());
		if (leftToRightDirection) {
			specBuilder.append("left to right direction").append(System.lineSeparator());
		}
		
		if (width != null) {
			specBuilder.append("scale ").append(width).append(" width").append(System.lineSeparator());
		}
		
		if (contextElement == null) { // Shall not happen
			specBuilder.append("note \"Context element not found\" as NOT_FOUND_NOTE").append(System.lineSeparator());
		} else {
			Set<Element> diagramElements = new HashSet<>();
			collectDiagramElements(contextElement, direction, depth, dependencies, services, diagramElements);
			if (contextElement instanceof org.nasdanika.osgi.model.Bundle) {
				for (org.nasdanika.osgi.model.Component cmp: ((org.nasdanika.osgi.model.Bundle) contextElement).getComponents()) {
					Set<Element> cde = new HashSet<>();
					collectDiagramElements(cmp, direction, depth, dependencies, services, cde);
					diagramElements.addAll(cde);
				}
			}
			
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
							if (bundle != contextElement) {
								specBuilder.append(" #DDDDDD");
							}		
							specBuilder.append(System.lineSeparator());						
						} else {
							specBuilder.append("package \""+bundle.getSymbolicName()+" "+bundle.getVersion()+"\" as "+bundle.eClass().getName()+"_"+bundle.getId());
							if (bundle != contextElement && bundle != contextElement.eContainer()) {
								specBuilder.append(" #DDDDDD");
							}								
							specBuilder.append(" {"+System.lineSeparator());
							
							for (org.nasdanika.osgi.model.Component component: bundleComponents) {
								specBuilder.append("\tcomponent \""+component.getName()+"\" as "+component.eClass().getName()+"_"+component.getId()+"<<Component>>");
								if (component != contextElement && component.eContainer() != contextElement) {
									specBuilder.append(" #DDDDDD");
								}		
								specBuilder.append(System.lineSeparator());														
							}
							specBuilder.append("}").append(System.lineSeparator());
						}						
					} else {
						specBuilder.append("component \""+bundle.getSymbolicName()+"\" <<"+bundle.getVersion()+">> as "+bundle.eClass().getName()+"_"+bundle.getId());
						if (de != contextElement && de != contextElement.eContainer()) {
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
				if (dependencies && source instanceof org.nasdanika.osgi.model.Bundle) {
					for (org.nasdanika.osgi.model.Bundle rb: ((org.nasdanika.osgi.model.Bundle) source).getRequires()) {
						if (diagramElements.contains(rb)) {
							specBuilder.append(source.eClass().getName()+"_"+source.getId()+" ..> "+rb.eClass().getName()+"_"+rb.getId()).append(System.lineSeparator());
						}
					}					
				}
				
				// References
				if (services) {
					if (source instanceof org.nasdanika.osgi.model.Bundle) {						
						for (org.nasdanika.osgi.model.ServiceReference ref: source.getOutboundReferences()) {
							Element trg = ref.getReferenceTarget();							
							if (trg instanceof org.nasdanika.osgi.model.Component && !components) {
								trg = (Element) trg.eContainer();
							}
							if (trg != source && diagramElements.contains(trg)) {
								specBuilder.append(source.eClass().getName()+"_"+source.getId()+" --> "+trg.eClass().getName()+"_"+trg.getId());
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
						if (!components) {
							for (org.nasdanika.osgi.model.Component cmp: ((org.nasdanika.osgi.model.Bundle) source).getComponents()) {
								for (org.nasdanika.osgi.model.ServiceReference ref: cmp.getOutboundReferences()) {
									Element trg = ref.getReferenceTarget();							
									if (trg instanceof org.nasdanika.osgi.model.Component && !components) {
										trg = (Element) trg.eContainer();
									}
									if (trg != source && diagramElements.contains(trg)) {
										specBuilder.append(source.eClass().getName()+"_"+source.getId()+" --> "+trg.eClass().getName()+"_"+trg.getId());
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
					} else if (components) { 
						for (org.nasdanika.osgi.model.ServiceReference ref: source.getOutboundReferences()) {
							Element trg = ref.getReferenceTarget();
							if (diagramElements.contains(trg)) {
								specBuilder.append(source.eClass().getName()+"_"+source.getId()+" --> "+trg.eClass().getName()+"_"+trg.getId());
								specBuilder.append(" : ");
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
								
								specBuilder.append(System.lineSeparator());
							}
						}
					}
				}								
			}
			
			
//			for (org.nasdanika.osgi.model.Bundle mb: runtime.getBundles()) {
//				if (diagramElements.contains(mb)) {
//					for (org.nasdanika.osgi.model.ServiceReference ref: mb.getOutboundReferences()) {
//						System.out.println(mb.getSymbolicName()+" --> "+diagramElements.contains(ref.getReferenceTarget()));
//					}
//				}
//				
//				for (org.nasdanika.osgi.model.Component mc: mb.getComponents()) {
//					if (diagramElements.contains(mc)) {
//						for (org.nasdanika.osgi.model.ServiceReference ref: mc.getOutboundReferences()) {
//							System.out.println("\t"+mc.getName()+" --> "+diagramElements.contains(ref.getReferenceTarget()));
//						}
//					}
//				}
//			}
			
			
			
		}		
		
		specBuilder.append("@enduml").append(System.lineSeparator());
		//System.out.println(specBuilder);
		SourceStringReader reader = new SourceStringReader(specBuilder.toString());
		reader.generateImage(out);		
				
	}
	
	private void collectDiagramElements(
			Element candidate, 
			Direction direction,
			int depth,
			boolean dependencies,
			boolean services,
			Set<Element> diagramElements) {
		
		//System.out.println("Collecting for: "+candidate);
		if (diagramElements.add(candidate) && depth != 0) {
			if (direction == Direction.in || direction == Direction.both) {
				if (services) {
					for (org.nasdanika.osgi.model.ServiceReference ir: candidate.getInboundReferences()) {
						collectDiagramElements((Element) ir.eContainer(), direction, depth-1, dependencies, services, diagramElements);
					}
				}
				if (dependencies && candidate instanceof org.nasdanika.osgi.model.Bundle) {
					for (org.nasdanika.osgi.model.Bundle rb: ((org.nasdanika.osgi.model.Bundle) candidate).getRequiredBy()) {
						collectDiagramElements(rb, direction, depth-1, dependencies, services, diagramElements);
					}
				}
			} 
			
			if (direction == Direction.out || direction == Direction.both) {
				if (services) {
					for (org.nasdanika.osgi.model.ServiceReference ir: candidate.getOutboundReferences()) {
						collectDiagramElements(ir.getReferenceTarget(), direction, depth-1, dependencies, services, diagramElements);
					}
				}
				if (dependencies && candidate instanceof org.nasdanika.osgi.model.Bundle) {
					for (org.nasdanika.osgi.model.Bundle rb: ((org.nasdanika.osgi.model.Bundle) candidate).getRequires()) {
						collectDiagramElements(rb, direction, depth-1, dependencies, services, diagramElements);
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
			Tag ul = htmlFactory.tag(TagName.ul);
			for (int i = 0; i < Array.getLength(value); ++i) {
				ul.content(htmlFactory.tag(TagName.li, renderValue(Array.get(value, i))));
			}
			return ul;
		}
		return StringEscapeUtils.escapeHtml4(value.toString());
		
	}

}
