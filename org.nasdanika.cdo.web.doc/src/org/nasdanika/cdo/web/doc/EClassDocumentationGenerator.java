package org.nasdanika.cdo.web.doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.cdo.web.doc.DocRoute.EClassKey;
import org.nasdanika.cdo.web.html.EOperationFormGenerator;
import org.nasdanika.cdo.web.html.FormGeneratorBase;
import org.nasdanika.cdo.web.routes.CDOWebUtil;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.Button;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement.Style;

public class EClassDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EClassDocumentationGenerator(DocRoute docRoute) {
		super(docRoute);
	}

	public String generate(
			URL baseURL,
			String urlPrefix,
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EClass eClass) {
		
		// TODO - path?
		Tag classIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EClass.gif")
				.style("margin-right", "5px");
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EClass "+eClass.getName()));
		ret.content(htmlFactory.tag(TagName.h2, classIcon, eClass.isAbstract() ? "<I>"+eClass.getName()+"</I>" : eClass.getName()));
		StringBuilder modifiers = new StringBuilder();
		if (eClass.isInterface()) {
			modifiers.append("interface ");
		} else {
			if (eClass.isAbstract()) {
				modifiers.append("abstract ");
			}
			modifiers.append("class ");
		}
		
		ret.content(htmlFactory.div(markdownToHtml(baseURL, urlPrefix, modifiers+" [[javadoc>"+eClass.getInstanceClassName()+"|"+eClass.getInstanceClassName()+"]]")).style("margin-bottom", "5px").style("font-family", "monospace"));
		String doc = getModelDocumentation(baseURL, urlPrefix, eClass);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}

		for (EAnnotation eAnnotation: eClass.getEAnnotations()) {
			ret.content(documentAnnotation(htmlFactory, eAnnotation));
		}
	
		Tabs tabs = htmlFactory.tabs();
		ret.content(tabs);
						
		generateAttributesTab(baseURL, urlPrefix, eClass, htmlFactory, docRoutePath, tabs, registryPath);
		generateReferencesTab(baseURL, urlPrefix, eClass, htmlFactory, docRoutePath, tabs, registryPath);
		
		List<EOperation> eOperations = new ArrayList<>();
		List<EOperation> routes = new ArrayList<>();
		List<EOperation> forms = new ArrayList<>();
		
		for (EOperation op: eClass.getEAllOperations()) {
			if (op.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE)!=null || op.getEAnnotation(CDOWebUtil.ANNOTATION_HOME_ROUTE)!=null) {
				routes.add(op);
			} else if (op.getEAnnotation(FormGeneratorBase.FORM_ANNOTATION_SOURCE)!=null) {
				forms.add(op);
			} else {
				eOperations.add(op);
			}
		}
		
		generateOperationsTab(baseURL, urlPrefix, eClass, eOperations, htmlFactory, docRoutePath, tabs, registryPath);
		generateRoutesTab(baseURL, urlPrefix, eClass, routes, htmlFactory, docRoutePath, tabs, registryPath);
		generateFormsTab(baseURL, urlPrefix, eClass, forms, htmlFactory, docRoutePath, tabs, registryPath);
		
		if (!eClass.getESuperTypes().isEmpty()) {
			Table stTable = htmlFactory.table().bordered();
			Row hr = stTable.row().style(Style.INFO);
			hr.header("Name");
			hr.header("Description");
			for (EClass st: eClass.getESuperTypes()) {
				Row stRow = stTable.row();
				stRow.cell(eClassifierLink(htmlFactory, st, docRoutePath, registryPath, false));
				stRow.cell(getFirstDocSentence(baseURL, urlPrefix, st));
			}
			tabs.item("Supertypes", stTable);
		}
		
		Set<EClassKey> subTypes = docRoute.getInheritanceMap().get(new EClassKey(eClass));
		if (subTypes!=null && !subTypes.isEmpty()) {
			Table stTable = htmlFactory.table().bordered();
			Row hr = stTable.row().style(Style.INFO);
			hr.header("Name");
			hr.header("Description");
			for (EClassKey st: subTypes) {
				Row stRow = stTable.row();
				String packagePath = "#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(st.getNsURI().getBytes(/* UTF-8? */));
				stRow.cell(htmlFactory.link(packagePath+"/"+st.getName(), st.getName()));
				stRow.cell(getFirstDocSentence(baseURL, urlPrefix, st.getDocumentation()));
			}
			tabs.item("Subtypes", stTable);
		}
								
		return ret.toString();		
		
	}

	private void generateAttributesTab(
			URL baseURL,
			String urlPrefix,
			EClass eClass, 
			HTMLFactory htmlFactory, 
			String docRoutePath, 
			Tabs tabs, 
			String registryPath) {
		Tag attributeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EAttribute.gif")
				.style("margin-right", "5px");
		
		List<EAttribute> eAllAttributes = new ArrayList<>(eClass.getEAllAttributes());
		if (!eAllAttributes.isEmpty()) {
			Collections.sort(eAllAttributes, NAMED_ELEMENT_COMPARATOR);
			Accordion attributesAccordion = htmlFactory.accordion();
			for (EAttribute attr: eAllAttributes) {
				String firstDocSentence = getFirstDocSentence(baseURL, urlPrefix, attr);
				String declaringType = attr.getEContainingClass()==eClass ? "" : " ("+attr.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(htmlFactory, attr.getEType(), docRoutePath, registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(attr));
				
				row = propTable.row();				
				row.header("Default value").style("align", "left");
				row.cell(htmlFactory.div(StringEscapeUtils.escapeHtml4(attr.getDefaultValueLiteral())).style("white-space", "pre").style("font-family", "monospace"));

				row = propTable.row();
				row.header("Changeable").style("align", "left");
				row.cell(attr.isChangeable() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Derived").style("align", "left");
				row.cell(attr.isDerived() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("ID").style("align", "left");
				row.cell(attr.isID() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Ordered").style("align", "left");
				row.cell(attr.isOrdered() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Transient").style("align", "left");
				row.cell(attr.isTransient() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Unique").style("align", "left");
				row.cell(attr.isUnique() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Unsettable").style("align", "left");
				row.cell(attr.isUnsettable() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Volatile").style("align", "left");
				row.cell(attr.isVolatile() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(baseURL, urlPrefix, attr), propTable);				
								
				for (EAnnotation ann: attr.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(htmlFactory, ann));
				}
				
				attributesAccordion.item(
						"<b>"+attr.getName()+"</b> : "+attr.getEType().getName()+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						accordionFragment);
			}
			tabs.item(attributeIcon+" Attributes", attributesAccordion);			
		}
	}

	private void generateReferencesTab(
			URL baseURL, 
			String urlPrefix,
			EClass eClass, 
			HTMLFactory htmlFactory, 
			String docRoutePath, 
			Tabs tabs, 
			String registryPath) {
		
		Tag referenceIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EReference.gif")
				.style("margin-right", "5px");
		
		List<EReference> eAllReferences = new ArrayList<>(eClass.getEAllReferences());
		if (!eAllReferences.isEmpty()) {
			Collections.sort(eAllReferences, NAMED_ELEMENT_COMPARATOR);
			Accordion referencesAccordion = htmlFactory.accordion();
			for (EReference ref: eAllReferences) {
				String firstDocSentence = getFirstDocSentence(baseURL, urlPrefix, ref);
				String declaringType = ref.getEContainingClass()==eClass ? "" : " ("+ref.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(htmlFactory, ref.getEType(), docRoutePath, registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(ref));
				
				row = propTable.row();				
				row.header("Default value").style("align", "left");
				row.cell(htmlFactory.div(StringEscapeUtils.escapeHtml4(ref.getDefaultValueLiteral())).style("white-space", "pre").style("font-family", "monospace"));

				row = propTable.row();
				row.header("Changeable").style("align", "left");
				row.cell(ref.isChangeable() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Container").style("align", "left");
				row.cell(ref.isContainer() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Containment").style("align", "left");
				row.cell(ref.isContainment() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Derived").style("align", "left");
				row.cell(ref.isDerived() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("EKeys").style("align", "left");
				List<String> eKeys = new ArrayList<>();
				for (EAttribute eKey: ref.getEKeys()) {
					eKeys.add(eKey.getName());
				}
				row.cell(htmlFactory.ol(eKeys));
				
				row = propTable.row();
				row.header("Opposite").style("align", "left");
				EReference eOpposite = ref.getEOpposite();
				if (eOpposite==null) {
					row.cell("");
				} else {
					row.cell(eClassifierLink(htmlFactory, eOpposite.getEContainingClass(), docRoutePath, registryPath, false), ".", eOpposite.getName());
				}

				row = propTable.row();
				row.header("Ordered").style("align", "left");
				row.cell(ref.isOrdered() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Resolve proxies").style("align", "left");
				row.cell(ref.isResolveProxies() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Transient").style("align", "left");
				row.cell(ref.isTransient() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Unique").style("align", "left");
				row.cell(ref.isUnique() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Unsettable").style("align", "left");
				row.cell(ref.isUnsettable() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				row = propTable.row();
				row.header("Volatile").style("align", "left");
				row.cell(ref.isVolatile() ? htmlFactory.glyphicon(Glyphicon.ok) : "");

				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(baseURL, urlPrefix, ref), propTable);				
				
				for (EAnnotation ann: ref.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(htmlFactory, ann));
				}
								
				referencesAccordion.item(
						"<b>"+ref.getName()+"</b> : "+ref.getEType().getName()+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						accordionFragment);
			}
			tabs.item(referenceIcon+" References", referencesAccordion);			
		}
	}
	
	private void generateOperationsTab(
			URL baseURL,
			String urlPrefix,
			EClass eClass, 
			List<EOperation> operations, 
			HTMLFactory htmlFactory, 
			String docRoutePath, 
			Tabs tabs, 
			String registryPath) {
		
		if (!operations.isEmpty()) {
			Collections.sort(operations, NAMED_ELEMENT_COMPARATOR);
			Accordion operationsAccordion = htmlFactory.accordion();
			for (EOperation operation: operations) {
				String firstDocSentence = getFirstDocSentence(baseURL, urlPrefix, operation);
				String declaringType = operation.getEContainingClass()==eClass ? "" : " ("+operation.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(htmlFactory, operation.getEType(), docRoutePath, registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(operation));
				
				row = propTable.row();
				row.header("Exceptions").style("align", "left");
				Tag exceptionsList = htmlFactory.tag(TagName.ul);
				if (operation.getEExceptions().size()==1) {
					row.cell(eClassifierLink(htmlFactory, operation.getEExceptions().get(0), docRoutePath, registryPath, true));
				} else {
					for (EClassifier ex: operation.getEExceptions()) {
						exceptionsList.content(htmlFactory.tag(TagName.li, eClassifierLink(htmlFactory, ex, docRoutePath, registryPath, true)));
					}
					row.cell(exceptionsList);
				}
				
				row = propTable.row();
				row.header("Unique").style("align", "left");
				row.cell(operation.isUnique() ? htmlFactory.glyphicon(Glyphicon.ok) : "");								
				
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(baseURL, urlPrefix, operation), propTable);
				
				for (EAnnotation ann: operation.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(htmlFactory, ann));
				}
				
				if (!operation.getEParameters().isEmpty()) {
					accordionFragment.content(htmlFactory.tag(TagName.h3, "Parameters"));
					for (EParameter param: operation.getEParameters()) {
						accordionFragment.content(htmlFactory.tag(TagName.h4, param.getName(), " : ", eClassifierLink(htmlFactory, param.getEType(), docRoutePath, registryPath, true), " ", cardinality(param)));						
						getModelDocumentation(baseURL, urlPrefix, param);
						for (EAnnotation ann: param.getEAnnotations()) {
							accordionFragment.content(documentAnnotation(htmlFactory, ann));
						}						
					}
				}				
				
				operationsAccordion.item(
						"<b>"+operation.getName()+"</b> : "+(operation.getEType()==null ? "void" : operation.getEType().getName())+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						accordionFragment);
			}
			
			Tag operationIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoutePath+"/resources/images/EOperation.gif")
					.style("margin-right", "5px");
			
			tabs.item(operationIcon+" Operations", operationsAccordion);						
		}		
	}
	
	private void generateRoutesTab(
			URL baseURL, 
			String urlPrefix,
			EClass eClass, 
			List<EOperation> routes, 
			HTMLFactory htmlFactory, 
			String docRoutePath, 
			Tabs tabs, 
			String registryPath) {
		
		// TODO - Routes from extensions.
		if (!routes.isEmpty()) {
			Collections.sort(routes, NAMED_ELEMENT_COMPARATOR);
			Accordion routesAccordion = htmlFactory.accordion();
			for (EOperation route: routes) {
				EAnnotation rAnn = route.getEAnnotation(CDOWebUtil.ANNOTATION_HOME_ROUTE);
				boolean isHome = rAnn!=null;
				if (!isHome) {
					rAnn = route.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE);
				}
				
				String firstDocSentence = getFirstDocSentence(baseURL, urlPrefix, route);
				String declaringType = route.getEContainingClass()==eClass ? "" : " ("+route.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(htmlFactory, route.getEType(), docRoutePath, registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(route));
				
				row = propTable.row();
				row.header("Exceptions").style("align", "left");
				Tag exceptionsList = htmlFactory.tag(TagName.ul);
				if (route.getEExceptions().size()==1) {
					row.cell(eClassifierLink(htmlFactory, route.getEExceptions().get(0), docRoutePath, registryPath, true));
				} else {
					for (EClassifier ex: route.getEExceptions()) {
						exceptionsList.content(htmlFactory.tag(TagName.li, eClassifierLink(htmlFactory, ex, docRoutePath, registryPath, true)));
					}
					row.cell(exceptionsList);
				}
				
				if (rAnn.getDetails().containsKey("action")) {
					row = propTable.row();
					row.header("Action").style("align", "left");
					row.cell(StringEscapeUtils.escapeHtml4(rAnn.getDetails().get("action")));
				}
				
				if (rAnn.getDetails().containsKey("qualifier")) {
					row = propTable.row();
					row.header("Qualifier").style("align", "left");
					row.cell(StringEscapeUtils.escapeHtml4(rAnn.getDetails().get("qualifier")));
				}
				
				if (rAnn.getDetails().containsKey("method")) {
					row = propTable.row();
					row.header("Method").style("align", "left");
					row.cell(StringEscapeUtils.escapeHtml4(rAnn.getDetails().get("method")));
				}
				
				if (!isHome) {
					if (rAnn.getDetails().containsKey("path")) {
						row = propTable.row();
						row.header("Path").style("align", "left");
						row.cell(StringEscapeUtils.escapeHtml4(rAnn.getDetails().get("path")));
					} else if (rAnn.getDetails().containsKey("pattern")) {
						row = propTable.row();
						row.header("Pattern").style("align", "left");
						row.cell(StringEscapeUtils.escapeHtml4(rAnn.getDetails().get("pattern")));
					}					
				}
				
				if (rAnn.getDetails().containsKey("consumes")) {
					row = propTable.row();
					row.header("Consumes").style("align", "left");
					row.cell(StringEscapeUtils.escapeHtml4(rAnn.getDetails().get("consumes")));
				}
				
				if (rAnn.getDetails().containsKey("produces")) {
					row = propTable.row();
					row.header("Produces").style("align", "left");
					row.cell(StringEscapeUtils.escapeHtml4(rAnn.getDetails().get("produces")));
				}
				
				row = propTable.row();
				row.header("Unique").style("align", "left");
				row.cell(route.isUnique() ? htmlFactory.glyphicon(Glyphicon.ok) : "");								
								
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(baseURL, urlPrefix, route), propTable);
				
				for (EAnnotation ann: route.getEAnnotations()) {
					if (CDOWebUtil.ANNOTATION_ROUTE.equals(ann.getSource())) {
						continue;
					}
					if (CDOWebUtil.ANNOTATION_HOME_ROUTE.equals(ann.getSource())) {
						continue;
					}
					accordionFragment.content(documentAnnotation(htmlFactory, ann));
				}
				
				if (!route.getEParameters().isEmpty()) {
					accordionFragment.content(htmlFactory.tag(TagName.h3, "Parameters"));
					for (EParameter param: route.getEParameters()) {
						accordionFragment.content(htmlFactory.tag(TagName.h4, param.getName(), " : ", eClassifierLink(htmlFactory, param.getEType(), docRoutePath, registryPath, true), " ", cardinality(param)));						
						getModelDocumentation(baseURL, urlPrefix, param);
						Table prmPropTable = htmlFactory.table().bordered();
						
						for (EAnnotation ann: param.getEAnnotations()) {							
							switch (ann.getSource()) {
							case CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER: {
								Row prmRow = prmPropTable.row();
								prmRow.header("Type").style("align", "left");
								prmRow.cell("Context");
								break;
							}
							case CDOWebUtil.ANNOTATION_SERVICE_PARAMETER: {
								Row prmRow = prmPropTable.row();
								prmRow.header("Type").style("align", "left");
								prmRow.cell("Service");
								if (ann.getDetails().containsKey("filter")) {
									prmRow = prmPropTable.row();
									prmRow.header("Filter").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("filter"))).style("white-space", "pre-wrap").style("font-family", "monospace");									
								}
								break;
							}
							case CDOWebUtil.ANNOTATION_QUERY_PARAMETER: {
								Row prmRow = prmPropTable.row();
								prmRow.header("Type").style("align", "left");
								prmRow.cell("Query");
								if (ann.getDetails().containsKey("name")) {
									prmRow = prmPropTable.row();
									prmRow.header("Name").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("name"))).style("white-space", "pre-wrap").style("font-family", "monospace");									
								}
								if (ann.getDetails().containsKey("defaultValue")) {
									prmRow = prmPropTable.row();
									prmRow.header("Default value").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("defaultValue"))).style("white-space", "pre-wrap").style("font-family", "monospace");									
								}
								break;
							}
							case CDOWebUtil.ANNOTATION_PATH_PARAMETER: {
								Row prmRow = prmPropTable.row();
								prmRow.header("Type").style("align", "left");
								prmRow.cell("Path");
								if (ann.getDetails().containsKey("name")) {
									prmRow = prmPropTable.row();
									prmRow.header("Name").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("name"))).style("white-space", "pre-wrap").style("font-family", "monospace");									
								}
								if (ann.getDetails().containsKey("defaultValue")) {
									prmRow = prmPropTable.row();
									prmRow.header("Default value").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("defaultValue"))).style("white-space", "pre-wrap").style("font-family", "monospace");									
								}
								break;
							}
							case CDOWebUtil.ANNOTATION_COOKIE_PARAMETER: {
								Row prmRow = prmPropTable.row();
								prmRow.header("Type").style("align", "left");
								prmRow.cell("Cookie");
								if (ann.getDetails().containsKey("name")) {
									prmRow = prmPropTable.row();
									prmRow.header("Name").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("name"))).style("white-space", "pre-wrap").style("font-family", "monospace");									
								}
								break;
							}							
							default:
								accordionFragment.content(documentAnnotation(htmlFactory, ann));									
							}
						}	
						
						if (!prmPropTable.rows().isEmpty()) {
							accordionFragment.content(prmPropTable);
						}
					}
				}				
				
				routesAccordion.item(
						(isHome ? htmlFactory.glyphicon(Glyphicon.home).style("margin-right", "5px") : "")+"<b>"+route.getName()+"</b> : "+(route.getEType()==null ? "void" : route.getEType().getName())+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						accordionFragment);
			}

			Tag routeIcon = htmlFactory.glyphicon(Glyphicon.road).style("margin-right", "5px");
			
			tabs.item(routeIcon+" Routes", routesAccordion);						
		}		
	}

	private void generateFormsTab(
			URL baseURL, 
			String urlPrefix,
			EClass eClass, 
			List<EOperation> forms, 
			HTMLFactory htmlFactory, 
			String docRoutePath, 
			Tabs tabs, 
			String registryPath) {
		
		if (!forms.isEmpty()) {
			Collections.sort(forms, NAMED_ELEMENT_COMPARATOR);
			
			Accordion formsAccordion = htmlFactory.accordion();
			for (EOperation form: forms) {
				EAnnotation formAnn = form.getEAnnotation(FormGeneratorBase.FORM_ANNOTATION_SOURCE);
				
				String firstDocSentence = getFirstDocSentence(baseURL, urlPrefix, form);
				String declaringType = form.getEContainingClass()==eClass ? "" : " ("+form.getEContainingClass().getName()+") ";
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(baseURL, urlPrefix, form));

				EOperationFormGenerator formGenerator = new EOperationFormGenerator(form) {
					@Override
					protected Button createCancelButton(HTMLFactory htmlFactory, Form form) {
						return null;
					}
					
					@Override
					protected Button createSubmitButton(HTMLFactory htmlFactory, Form form) {
						return null;
					}
					
				};
				try {
					accordionFragment.content(htmlFactory.panel(Style.INFO, "Preview", formGenerator.generateForm(htmlFactory), null));
				} catch (Exception e) {
					accordionFragment.content(htmlFactory.alert(Style.WARNING, false, "Failed to generate form preview: "+e));
				}
				
				Table propTable = htmlFactory.table().bordered();
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(htmlFactory, form.getEType(), docRoutePath, registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(form));
				
				row = propTable.row();
				row.header("Exceptions").style("align", "left");
				Tag exceptionsList = htmlFactory.tag(TagName.ul);
				if (form.getEExceptions().size()==1) {
					row.cell(eClassifierLink(htmlFactory, form.getEExceptions().get(0), docRoutePath, registryPath, true));
				} else {
					for (EClassifier ex: form.getEExceptions()) {
						exceptionsList.content(htmlFactory.tag(TagName.li, eClassifierLink(htmlFactory, ex, docRoutePath, registryPath, true)));
					}
					row.cell(exceptionsList);
				}
				
				if (formAnn.getDetails().containsKey("model")) {
					row = propTable.row();
					row.header("Model").style("align", "left");
					preStyle(row.cell(StringEscapeUtils.escapeHtml4(formAnn.getDetails().get("model"))));
				}
				
				row = propTable.row();
				row.header("Inline").style("align", "left");
				row.cell(formAnn.getDetails().containsKey("inline") && "true".equalsIgnoreCase(formAnn.getDetails().get("inline")) ? htmlFactory.glyphicon(Glyphicon.ok) : "");								
				
				if (formAnn.getDetails().containsKey("horizontal")) {
					row = propTable.row();
					row.header("Horizontal").style("align", "left");
					row.cell(StringEscapeUtils.escapeHtml4(formAnn.getDetails().get("horizontal")));
				}
								
				if (formAnn.getDetails().containsKey("validator")) {
					row = propTable.row();
					row.header("Validator").style("align", "left");
					preStyle(row.cell(StringEscapeUtils.escapeHtml4(formAnn.getDetails().get("validator"))));
				}
												
				for (EAnnotation ann: form.getEAnnotations()) {
					if (FormGeneratorBase.FORM_ANNOTATION_SOURCE.equals(ann.getSource())) {
						continue;
					}
					accordionFragment.content(documentAnnotation(htmlFactory, ann));
				}
				
				if (!form.getEParameters().isEmpty()) { 
					accordionFragment.content(htmlFactory.tag(TagName.h3, "Parameters"));
					for (EParameter param: form.getEParameters()) {
						accordionFragment.content(htmlFactory.tag(TagName.h4, param.getName(), " : ", eClassifierLink(htmlFactory, param.getEType(), docRoutePath, registryPath, true), " ", cardinality(param)));						
						getModelDocumentation(baseURL, urlPrefix, param);
						Table prmPropTable = htmlFactory.table().bordered();
						Map<String, String> attributes = new TreeMap<>();
						Map<String, String> groupAttributes = new TreeMap<>();
						Map<String, String> styles = new TreeMap<>();
						Map<String, String> groupStyles = new TreeMap<>();
						
						for (EAnnotation ann: param.getEAnnotations()) {
							if (FormGeneratorBase.FORM_CONTROL_ANNOTATION_SOURCE.equals(ann.getSource())) {
								if (ann.getDetails().containsKey("input-type")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Input type").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("input-type")));
								}
								if (ann.getDetails().containsKey("control-id")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Control ID").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("control-id")));
								}
								if (ann.getDetails().containsKey("default")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Default value").style("align", "left");
									preStyle(prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("default"))));
								}
								if (ann.getDetails().containsKey("help-text")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Help text").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("help-text")));
								}
								if (ann.getDetails().containsKey("inline") && "true".equalsIgnoreCase(ann.getDetails().get("inline").trim())) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Inline").style("align", "left");
									prmRow.cell(htmlFactory.glyphicon(Glyphicon.ok));
								}
								if (ann.getDetails().containsKey("label")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Label").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("label")));
								}
								if (ann.getDetails().containsKey("placeholder")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Placeholder").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("placeholder")));
								}
								if (ann.getDetails().containsKey("private") && "true".equalsIgnoreCase(ann.getDetails().get("private").trim())) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Private").style("align", "left");
									prmRow.cell(htmlFactory.glyphicon(Glyphicon.ok));
								}
								if (ann.getDetails().containsKey("required") && "true".equalsIgnoreCase(ann.getDetails().get("required").trim())) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Required").style("align", "left");
									prmRow.cell(htmlFactory.glyphicon(Glyphicon.ok));
								}
								if (ann.getDetails().containsKey("validator")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Validator").style("align", "left");
									preStyle(prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("validator"))));
								}
								
								for (Entry<String, String> de: ann.getDetails().entrySet()) {
									if (de.getKey().startsWith("attribute:")) {
										attributes.put(de.getKey().substring("attribute:".length()), de.getValue());
									} else if (de.getKey().startsWith("group-attribute:")) {
										groupAttributes.put(de.getKey().substring("group-attribute:".length()), de.getValue());										
									} else if (de.getKey().startsWith("style:")) {
										styles.put(de.getKey().substring("style:".length()), de.getValue());										
									} else if (de.getKey().startsWith("group-style:")) {
										groupStyles.put(de.getKey().substring("group-style:".length()), de.getValue());									
									}
								}
							} else if (CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER.equals(ann.getSource())) {
								Row prmRow = prmPropTable.row();
								prmRow.header("Type").style("align", "left");
								prmRow.cell("Context");																
							} else if (CDOWebUtil.ANNOTATION_SERVICE_PARAMETER.equals(ann.getSource())) {
								Row prmRow = prmPropTable.row();
								prmRow.header("Type").style("align", "left");
								prmRow.cell("Service");
								if (ann.getDetails().containsKey("filter")) {
									prmRow = prmPropTable.row();
									prmRow.header("Service filter").style("align", "left");
									preStyle(prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("filter"))));									
								}																
							} else if (CDOWebUtil.ANNOTATION_VALIDATOR.equals(ann.getSource())) {
								if (ann.getDetails().containsKey("server")) {
									Row prmRow = prmPropTable.row();
									prmRow.header("Server-side validator").style("align", "left");
									preStyle(prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("server"))));
								}
							} else {
								accordionFragment.content(documentAnnotation(htmlFactory, ann));									
							}
						}	
						
						if (!prmPropTable.rows().isEmpty()) {
							accordionFragment.content(prmPropTable);
						}
						
						if (!attributes.isEmpty()) {
							Table attrTable = htmlFactory.table().bordered();
							for (Entry<String, String> ae: attributes.entrySet()) {
								Row attrRow = attrTable.row();
								attrRow.header(StringEscapeUtils.escapeHtml4(ae.getKey())).style("align", "left");
								preStyle(attrRow.cell(StringEscapeUtils.escapeHtml4(ae.getValue())));								
							}
							accordionFragment.content(htmlFactory.panel(Style.INFO, "Attributes", attrTable, null));
						}
						
						if (!styles.isEmpty()) {
							Table styleTable = htmlFactory.table().bordered();
							for (Entry<String, String> se: styles.entrySet()) {
								Row styleRow = styleTable.row();
								styleRow.header(StringEscapeUtils.escapeHtml4(se.getKey())).style("align", "left");
								preStyle(styleRow.cell(StringEscapeUtils.escapeHtml4(se.getValue())));								
							}
							accordionFragment.content(htmlFactory.panel(Style.INFO, "Styles", styleTable, null));
						}
						
						if (!groupAttributes.isEmpty()) {
							Table attrTable = htmlFactory.table().bordered();
							for (Entry<String, String> ae: groupAttributes.entrySet()) {
								Row attrRow = attrTable.row();
								attrRow.header(StringEscapeUtils.escapeHtml4(ae.getKey())).style("align", "left");
								preStyle(attrRow.cell(StringEscapeUtils.escapeHtml4(ae.getValue())));								
							}
							accordionFragment.content(htmlFactory.panel(Style.INFO, "Attributes", attrTable, null));
						}
						
						if (!groupStyles.isEmpty()) {
							Table styleTable = htmlFactory.table().bordered();
							for (Entry<String, String> se: groupStyles.entrySet()) {
								Row styleRow = styleTable.row();
								styleRow.header(StringEscapeUtils.escapeHtml4(se.getKey())).style("align", "left");
								preStyle(styleRow.cell(StringEscapeUtils.escapeHtml4(se.getValue())));								
							}
							accordionFragment.content(htmlFactory.panel(Style.INFO, "Styles", styleTable, null));
						}
					}
				}				
								
				formsAccordion.item(
						"<b>"+form.getName()+"</b> : "+(form.getEType()==null ? "void" : form.getEType().getName())+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						accordionFragment);
			}
			
			
			Tag formIcon = htmlFactory.glyphicon(Glyphicon.list_alt).style("margin-right", "5px");
			
			tabs.item(formIcon+" Forms", formsAccordion);						
		}				
	}

}
