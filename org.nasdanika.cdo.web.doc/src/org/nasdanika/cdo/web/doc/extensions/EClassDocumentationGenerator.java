package org.nasdanika.cdo.web.doc.extensions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
import org.jsoup.Jsoup;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.EClassifierKey;
import org.nasdanika.cdo.web.html.EOperationFormGenerator;
import org.nasdanika.cdo.web.html.FormGeneratorBase;
import org.nasdanika.cdo.web.routes.CDOWebUtil;
import org.nasdanika.cdo.web.routes.EObjectRouteTracker;
import org.nasdanika.cdo.web.routes.EObjectRouteTracker.RouteEntry;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.NasdanikaException;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.Button;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.RequestMethod;
import org.osgi.framework.InvalidSyntaxException;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class EClassDocumentationGenerator extends EModelElementDocumentationGeneratorImpl<EClass> {
	
	private EObjectRouteTracker routeTracker;
	
	@Override
	public String generate(
			DocRoute docRoute,
			URL baseURL,
			String urlPrefix,
			String registryPath,
			EClass eClass) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();

		synchronized (this) {
			if (routeTracker == null) {
				try {
					routeTracker = new EObjectRouteTracker(docRoute.getBundleContext());
				} catch (InvalidSyntaxException e) {
					throw new NasdanikaException(e);
				}
			}
		}
		
		// TODO - path?
		Tag classIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EClass.gif")
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
		
		ret.content(htmlFactory.div(docRoute.markdownToHtml(baseURL, urlPrefix, modifiers+" [[javadoc>"+eClass.getInstanceClassName()+"|"+eClass.getInstanceClassName()+"]]")).style("margin-bottom", "5px").style("font-family", "monospace"));
	
		Tabs tabs = htmlFactory.tabs();
		ret.content(tabs);
				
		tabs(docRoute, baseURL, urlPrefix, registryPath, eClass, tabs);
								
		return ret.toString();		
		
	}

	protected void documentationTab(
			DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, 
			EClass eClass,
			Tabs tabs) {
		
		Fragment ret = docRoute.getHtmlFactory().fragment();
		String doc = getModelDocumentation(docRoute, baseURL, urlPrefix, eClass);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(docRoute.getHtmlFactory().div(doc)
					.addClass("markdown-body")
					.style().margin().top("10px")
					.style().margin().bottom("10px"));
		}
		
		mountedModelElementDocumentation(docRoute, eClass, ret);

		for (EAnnotation eAnnotation: eClass.getEAnnotations()) {
			ret.content(documentAnnotation(docRoute, eAnnotation));
		}
		
		if (!ret.isEmpty()) {
			tabs.item("Documentation", ret);
		}
	}

	protected void subTypesTab(
			DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, 
			String registryPath, 
			EClass eClass,
			Tabs tabs) {
		
		Set<EClassifierKey> subTypes = docRoute.getInheritanceMap().get(new EClassifierKey(eClass));
		if (subTypes!=null && !subTypes.isEmpty()) {
			Table stTable = docRoute.getHtmlFactory().table().bordered();
			Row hr = stTable.row().style(Bootstrap.Style.INFO);
			hr.header("Name");
			hr.header("Description");
			for (EClassifierKey st: subTypes) {
				Row stRow = stTable.row();
				String packagePath = DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+registryPath+"/"+Hex.encodeHexString(st.getNsURI().getBytes(/* UTF-8? */));
				stRow.cell(docRoute.getHtmlFactory().link(packagePath+"/"+st.getName(), st.getName()));
				stRow.cell(getFirstDocSentence(docRoute, baseURL, urlPrefix, st.getDocumentation()));
			}
			tabs.item("Subtypes", stTable);
		}
	}

	protected void supertypesTab(
			DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, 
			String registryPath, 
			EClass eClass,
			Tabs tabs) {
		
		if (!eClass.getESuperTypes().isEmpty()) {
			Table stTable = docRoute.getHtmlFactory().table().bordered();
			Row hr = stTable.row().style(Bootstrap.Style.INFO);
			hr.header("Name");
			hr.header("Description");
			for (EClass st: eClass.getESuperTypes()) {
				Row stRow = stTable.row();
				stRow.cell(eClassifierLink(docRoute, st, registryPath, false));
				stRow.cell(getFirstDocSentence(docRoute, baseURL, urlPrefix, st));
			}
			tabs.item("Supertypes", stTable);
		}
	}

	protected void attributesTab(
			DocRoute docRoute,
			URL baseURL,
			String urlPrefix,
			String registryPath,
			EClass eClass, 
			Tabs tabs) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		
		Tag attributeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EAttribute.gif")
				.style("margin-right", "5px");
		
		List<EAttribute> eAllAttributes = new ArrayList<>(eClass.getEAllAttributes());
		if (!eAllAttributes.isEmpty()) {
			Collections.sort(eAllAttributes, NAMED_ELEMENT_COMPARATOR);
			Accordion attributesAccordion = htmlFactory.accordion();
			for (EAttribute attr: eAllAttributes) {
				String firstDocSentence = getFirstDocSentence(docRoute, baseURL, urlPrefix, attr);
				if (CoreUtil.isBlank(firstDocSentence)) {
					try {
						EClassifier type = attr.getEType();
						URL typeURL = new URL(baseURL, "../"+Hex.encodeHexString(type.getEPackage().getNsURI().getBytes(/* UTF-8? */))+"/"+type.getName());
						firstDocSentence = getFirstDocSentence(docRoute, typeURL, urlPrefix, type);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} 
				}
				String declaringType = attr.getEContainingClass()==eClass ? "" : " ("+attr.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();

				if (attr.getEContainingClass()!=eClass) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(docRoute, attr.getEContainingClass(), registryPath, true));
				}
				
				Row row = propTable.row();								
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(docRoute, attr.getEType(), registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(attr));
				
				String defaultValueLiteral = attr.getDefaultValueLiteral();
				row = propTable.row();				
				row.header("Default value").style("align", "left");
				row.cell(htmlFactory.div(CoreUtil.isBlank(defaultValueLiteral) ? "" : StringEscapeUtils.escapeHtml4(defaultValueLiteral))
						.style().whiteSpace().pre()
						.style().font().family("monospace"));

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

				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(docRoute, baseURL, urlPrefix, attr), propTable);				
								
				for (EAnnotation ann: attr.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(docRoute, ann));
				}
				
				attributesAccordion.item(
						"<b>"+attr.getName()+"</b> : "+attr.getEType().getName()+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						null,
						false,
						null,
						accordionFragment);
			}
			tabs.item(attributeIcon+" Attributes", attributesAccordion);			
		}
	}

	protected void referencesTab(
			DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, 
			String registryPath,
			EClass eClass, 
			Tabs tabs) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		
		Tag referenceIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EReference.gif")
				.style("margin-right", "5px");
		
		List<EReference> eAllReferences = new ArrayList<>(eClass.getEAllReferences());
		if (!eAllReferences.isEmpty()) {
			Collections.sort(eAllReferences, NAMED_ELEMENT_COMPARATOR);
			Accordion referencesAccordion = htmlFactory.accordion();
			for (EReference ref: eAllReferences) {
				String firstDocSentence = getFirstDocSentence(docRoute, baseURL, urlPrefix, ref);
				if (CoreUtil.isBlank(firstDocSentence)) {
					try {
						EClassifier type = ref.getEType();
						URL typeURL = new URL(baseURL, "../"+Hex.encodeHexString(type.getEPackage().getNsURI().getBytes(/* UTF-8? */))+"/"+type.getName());
						firstDocSentence = getFirstDocSentence(docRoute, typeURL, urlPrefix, type);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} 
				}
				String declaringType = ref.getEContainingClass()==eClass ? "" : " ("+ref.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();

				if (ref.getEContainingClass()!=eClass) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(docRoute, ref.getEContainingClass(), registryPath, true));
				}
				
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(docRoute, ref.getEType(), registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(ref));
				
				row = propTable.row();				
				row.header("Default value").style("align", "left");
				row.cell(htmlFactory.div(StringEscapeUtils.escapeHtml4(ref.getDefaultValueLiteral()))
						.style().whiteSpace().pre()
						.style().font().family("monospace"));

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
					row.cell(eClassifierLink(docRoute, eOpposite.getEContainingClass(), registryPath, false), ".", eOpposite.getName());
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

				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(docRoute, baseURL, urlPrefix, ref), propTable);				
				
				for (EAnnotation ann: ref.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(docRoute, ann));
				}
								
				referencesAccordion.item(
						"<b>"+ref.getName()+"</b> : "+ref.getEType().getName()+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
						null,
						false,
						null,
						accordionFragment);
			}
			tabs.item(referenceIcon+" References", referencesAccordion);			
		}
	}
	
	protected void operationsTab(
			DocRoute docRoute, 
			URL baseURL,
			String urlPrefix,
			String registryPath,
			EClass eClass, 
			Tabs tabs) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		
		List<EOperation> eOperations = new ArrayList<>();

		for (EOperation op : eClass.getEAllOperations()) {
			if (op.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE) != null	|| op.getEAnnotation(CDOWebUtil.ANNOTATION_HOME_ROUTE) != null) {
				continue; // route
			} 
			
			if (op.getEAnnotation(FormGeneratorBase.FORM_ANNOTATION_SOURCE) != null) {
				continue; // form
			}
			
			eOperations.add(op);
		}

		if (!eOperations.isEmpty()) {
			Collections.sort(eOperations, NAMED_ELEMENT_COMPARATOR);
			Accordion operationsAccordion = htmlFactory.accordion();
			for (EOperation operation: eOperations) {
				String firstDocSentence = getFirstDocSentence(docRoute, baseURL, urlPrefix, operation);
				String declaringType = operation.getEContainingClass()==eClass ? "" : " ("+operation.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();

				if (operation.getEContainingClass()!=eClass) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(docRoute, operation.getEContainingClass(), registryPath, true));
				}
				
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(docRoute, operation.getEType(), registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(operation));
				
				row = propTable.row();
				row.header("Exceptions").style("align", "left");
				Tag exceptionsList = htmlFactory.tag(TagName.ul);
				if (operation.getEExceptions().size()==1) {
					row.cell(eClassifierLink(docRoute, operation.getEExceptions().get(0), registryPath, true));
				} else {
					for (EClassifier ex: operation.getEExceptions()) {
						exceptionsList.content(htmlFactory.tag(TagName.li, eClassifierLink(docRoute, ex, registryPath, true)));
					}
					row.cell(exceptionsList);
				}
				
				row = propTable.row();
				row.header("Unique").style("align", "left");
				row.cell(operation.isUnique() ? htmlFactory.glyphicon(Glyphicon.ok) : "");								
				
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(docRoute, baseURL, urlPrefix, operation), propTable);
				
				for (EAnnotation ann: operation.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(docRoute, ann));
				}
				
				if (!operation.getEParameters().isEmpty()) {
					accordionFragment.content(htmlFactory.tag(TagName.h3, "Parameters"));
					for (EParameter param: operation.getEParameters()) {
						accordionFragment.content(htmlFactory.tag(TagName.h4, param.getName(), " : ", eClassifierLink(docRoute, param.getEType(), registryPath, true), " ", cardinality(param)));						
						String parameterDoc = getModelDocumentation(docRoute, baseURL, urlPrefix, param);
						if (!CoreUtil.isBlank(parameterDoc)) {
							accordionFragment.content(docRoute.getHtmlFactory().div(parameterDoc)
									.addClass("markdown-body")
									.style().margin().top("10px")
									.style().margin().bottom("20px"));
							
						}
						for (EAnnotation ann: param.getEAnnotations()) {
							accordionFragment.content(documentAnnotation(docRoute, ann));
						}						
					}
				}				
				
				operationsAccordion.item(
						"<b>"+operation.getName()+"</b> : "+(operation.getEType()==null ? "void" : operation.getEType().getName())+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
						null,
						false,
						null,
						accordionFragment);
			}
			
			Tag operationIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EOperation.gif")
					.style("margin-right", "5px");
			
			tabs.item(operationIcon+" Operations", operationsAccordion);						
		}		
	}
	
	@SuppressWarnings("resource")
	protected void routesTab(
			DocRoute docRoute,
			URL baseURL, 
			String urlPrefix, 
			String registryPath,
			EClass eClass, 
			Tabs tabs) {
		
		List<EOperation> routeOperations = new ArrayList<>();

		for (EOperation op : eClass.getEAllOperations()) {
			if (op.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE) != null || op.getEAnnotation(CDOWebUtil.ANNOTATION_HOME_ROUTE) != null) {
				routeOperations.add(op);
			}
		}
		
		List<RouteEntry> routeEntries = routeTracker.match(eClass);
				
		// TODO - Routes from extensions.
		if (!routeOperations.isEmpty() || !routeEntries.isEmpty()) {
			HTMLFactory htmlFactory = docRoute.getHtmlFactory();
			
			Collections.sort(routeOperations, NAMED_ELEMENT_COMPARATOR);
			Accordion routesAccordion = htmlFactory.accordion();
			for (EOperation route: routeOperations) {
				EAnnotation rAnn = route.getEAnnotation(CDOWebUtil.ANNOTATION_HOME_ROUTE);
				boolean isHome = rAnn!=null;
				if (!isHome) {
					rAnn = route.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE);
				}
				
				String firstDocSentence = getFirstDocSentence(docRoute, baseURL, urlPrefix, route);
				String declaringType = route.getEContainingClass()==eClass ? "" : " ("+route.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();

				if (route.getEContainingClass()!=eClass) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(docRoute, route.getEContainingClass(), registryPath, true));
				}
				
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(docRoute, route.getEType(), registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(route));
				
				row = propTable.row();
				row.header("Exceptions").style("align", "left");
				Tag exceptionsList = htmlFactory.tag(TagName.ul);
				if (route.getEExceptions().size()==1) {
					row.cell(eClassifierLink(docRoute, route.getEExceptions().get(0), registryPath, true));
				} else {
					for (EClassifier ex: route.getEExceptions()) {
						exceptionsList.content(htmlFactory.tag(TagName.li, eClassifierLink(docRoute, ex, registryPath, true)));
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
								
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(docRoute, baseURL, urlPrefix, route), propTable);
				
				for (EAnnotation ann: route.getEAnnotations()) {
					if (CDOWebUtil.ANNOTATION_ROUTE.equals(ann.getSource())) {
						continue;
					}
					if (CDOWebUtil.ANNOTATION_HOME_ROUTE.equals(ann.getSource())) {
						continue;
					}
					accordionFragment.content(documentAnnotation(docRoute, ann));
				}
				
				if (!route.getEParameters().isEmpty()) {
					accordionFragment.content(htmlFactory.tag(TagName.h3, "Parameters"));
					for (EParameter param: route.getEParameters()) {
						accordionFragment.content(htmlFactory.tag(TagName.h4, param.getName(), " : ", eClassifierLink(docRoute, param.getEType(), registryPath, true), " ", cardinality(param)));						
						getModelDocumentation(docRoute, baseURL, urlPrefix, param);
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
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("filter")))
										.style().whiteSpace().preWrap()
										.style().font().family("monospace");									
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
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("name")))
									.style().whiteSpace().preWrap()
									.style().font().family("monospace");									
								}
								if (ann.getDetails().containsKey("defaultValue")) {
									prmRow = prmPropTable.row();
									prmRow.header("Default value").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("defaultValue")))
										.style().whiteSpace().preWrap()
										.style().font().family("monospace");									
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
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("name")))
										.style().whiteSpace().preWrap()
										.style().font().family("monospace");									
								}
								if (ann.getDetails().containsKey("defaultValue")) {
									prmRow = prmPropTable.row();
									prmRow.header("Default value").style("align", "left");
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("defaultValue")))
										.style().whiteSpace().preWrap()
										.style().font().family("monospace");									
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
									prmRow.cell(StringEscapeUtils.escapeHtml4(ann.getDetails().get("name")))
										.style().whiteSpace().preWrap()
										.style().font().family("monospace");									
								}
								break;
							}							
							default:
								accordionFragment.content(documentAnnotation(docRoute, ann));									
							}
						}	
						
						if (!prmPropTable.rows().isEmpty()) {
							accordionFragment.content(prmPropTable);
						}
					}
				}				
				
				routesAccordion.item(
						htmlFactory.glyphicon(isHome ? Glyphicon.home : Glyphicon.cog).style("margin-right", "5px")+"<b>"+route.getName()+"</b> : "+(route.getEType()==null ? "void" : route.getEType().getName())+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
						null,
						false,
						null,
						accordionFragment);
			}
			
			Collections.sort(routeEntries, new Comparator<RouteEntry>() {

				@Override
				public int compare(RouteEntry o1, RouteEntry o2) {
					String p1 = CoreUtil.isBlank(o1.getPath()) ? o1.getPattern() : o1.getPath();
					String p2 = CoreUtil.isBlank(o2.getPath()) ? o2.getPattern() : o2.getPath();
					int cmp = p1.compareTo(p2);
					if (cmp!=0) {
						return cmp;
					}
					cmp = o2.getPriority() - o1.getPriority();
					if (cmp!=0) {
						return cmp;
					}
					cmp = o1.getDistance() - o2.getDistance();
					if (cmp!=0) {
						return cmp;
					}
					return o1.hashCode() - o2.hashCode();
				}
			});
			
			for (RouteEntry routeEntry: routeEntries) {
				Fragment accordionFragment = htmlFactory.fragment();
				String docText = "";
				if (!CoreUtil.isBlank(routeEntry.getDescription())) {
					if ("text/markdown".equalsIgnoreCase(routeEntry.getDescriptionContentType())) {
						String html = htmlFactory.div(docRoute.markdownToHtml(baseURL, urlPrefix, routeEntry.getDescription())).addClass("markdown-body").style().margin().bottom("5px").toString();
						accordionFragment.content(html);
						docText = Jsoup.parse(html).text();;
					} else if ("text/html".equalsIgnoreCase(routeEntry.getDescriptionContentType())) {
						docText = Jsoup.parse(routeEntry.getDescription()).text();
						accordionFragment.content(routeEntry.getDescription());
					} else {
						docText = routeEntry.getDescription();
						accordionFragment.content(preStyle(htmlFactory.div(docText)));
					}
				}
				
				String firstDocSentence = docRoute.firstSentence(docText);
				String declaringType = routeEntry.getEClass()==eClass ? "" : " ("+routeEntry.getEClass().getName()+") ";

				Table propTable = htmlFactory.table().bordered();
				accordionFragment.content(propTable);

				if (routeEntry.getEClass()!=eClass) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(docRoute, routeEntry.getEClass(), registryPath, true));
				}

				RequestMethod[] methods = routeEntry.getMethods();
				if (methods!=null) {
					Row row = propTable.row();								
					if (methods.length == 1) {
						row.header("Method").style("align", "left");
						row.cell(methods[0].name());
					} else {
						row.header("Methods").style("align", "left");
						Tag ul = htmlFactory.tag(TagName.ul);
						for (RequestMethod rm: methods) {
							ul.content(htmlFactory.tag(TagName.li, rm.name()));
						}
						row.cell(ul);						
					}
				}
				
				String[] consumes = routeEntry.getConsumes();
				if (consumes!=null) {
					Row row = propTable.row();								
					row.header("Consumes").style("align", "left");
					if (consumes.length == 1) {
						row.cell(consumes[0]);
					} else {
						Tag ul = htmlFactory.tag(TagName.ul);
						for (String c: consumes) {
							ul.content(htmlFactory.tag(TagName.li, c));
						}
						row.cell(ul);						
					}					
				}

				if (!CoreUtil.isBlank(routeEntry.getContentType())) {
					Row row = propTable.row();								
					row.header("Produces content type").style("align", "left");
					row.cell(routeEntry.getContentType());
				}
				
				if (!CoreUtil.isBlank(routeEntry.getPath())) {
					Row row = propTable.row();								
					row.header("Path").style("align", "left");
					row.cell(routeEntry.getPath());
				} else if (!CoreUtil.isBlank(routeEntry.getPattern())) {
					Row row = propTable.row();								
					row.header("Pattern").style("align", "left");
					row.cell(routeEntry.getPattern());
				}
				
				if (routeEntry.getPriority()!=0) {
					Row row = propTable.row();								
					row.header("Priority").style("align", "left");
					row.cell(routeEntry.getPriority());					
				}

				routesAccordion.item(
						"<b>"+(CoreUtil.isBlank(routeEntry.getPath()) ? routeEntry.getPattern() : routeEntry.getPath())+"</b> "+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
						null,
						false,
						null,
						accordionFragment);
			}

			Tag routeIcon = htmlFactory.glyphicon(Glyphicon.road).style("margin-right", "5px");
			
			tabs.item(routeIcon+" Routes", routesAccordion);						
		}		
	}

	protected void formsTab(
			DocRoute docRoute,
			URL baseURL, 
			String urlPrefix,
			EClass eClass, 
			String registryPath, 
			Tabs tabs) {
				
		List<EOperation> forms = new ArrayList<>();

		for (EOperation op : eClass.getEAllOperations()) {
			if (op.getEAnnotation(FormGeneratorBase.FORM_ANNOTATION_SOURCE) != null) {
				forms.add(op);
			}
		}
		if (!forms.isEmpty()) {
			Collections.sort(forms, NAMED_ELEMENT_COMPARATOR);
			
			HTMLFactory htmlFactory = docRoute.getHtmlFactory();			
			Accordion formsAccordion = htmlFactory.accordion();
			for (EOperation form: forms) {
				EAnnotation formAnn = form.getEAnnotation(FormGeneratorBase.FORM_ANNOTATION_SOURCE);
				
				String firstDocSentence = getFirstDocSentence(docRoute, baseURL, urlPrefix, form);
				String declaringType = form.getEContainingClass()==eClass ? "" : " ("+form.getEContainingClass().getName()+") ";
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(docRoute, baseURL, urlPrefix, form));

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
					accordionFragment.content(htmlFactory.panel(Bootstrap.Style.INFO, "Preview", formGenerator.generateForm(htmlFactory), null));
				} catch (Exception e) {
					accordionFragment.content(htmlFactory.alert(Bootstrap.Style.WARNING, false, "Failed to generate form preview: "+e));
				}
				
				Table propTable = htmlFactory.table().bordered();

				if (form.getEContainingClass()!=eClass) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(docRoute, form.getEContainingClass(), registryPath, true));
				}
				
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(docRoute, form.getEType(), registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(form));
				
				row = propTable.row();
				row.header("Exceptions").style("align", "left");
				Tag exceptionsList = htmlFactory.tag(TagName.ul);
				if (form.getEExceptions().size()==1) {
					row.cell(eClassifierLink(docRoute, form.getEExceptions().get(0), registryPath, true));
				} else {
					for (EClassifier ex: form.getEExceptions()) {
						exceptionsList.content(htmlFactory.tag(TagName.li, eClassifierLink(docRoute, ex, registryPath, true)));
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
					accordionFragment.content(documentAnnotation(docRoute, ann));
				}
				
				if (!form.getEParameters().isEmpty()) { 
					accordionFragment.content(htmlFactory.tag(TagName.h3, "Parameters"));
					for (EParameter param: form.getEParameters()) {
						accordionFragment.content(htmlFactory.tag(TagName.h4, param.getName(), " : ", eClassifierLink(docRoute, param.getEType(), registryPath, true), " ", cardinality(param)));						
						getModelDocumentation(docRoute, baseURL, urlPrefix, param);
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
								accordionFragment.content(documentAnnotation(docRoute, ann));									
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
							accordionFragment.content(htmlFactory.panel(Bootstrap.Style.INFO, "Attributes", attrTable, null));
						}
						
						if (!styles.isEmpty()) {
							Table styleTable = htmlFactory.table().bordered();
							for (Entry<String, String> se: styles.entrySet()) {
								Row styleRow = styleTable.row();
								styleRow.header(StringEscapeUtils.escapeHtml4(se.getKey())).style("align", "left");
								preStyle(styleRow.cell(StringEscapeUtils.escapeHtml4(se.getValue())));								
							}
							accordionFragment.content(htmlFactory.panel(Bootstrap.Style.INFO, "Styles", styleTable, null));
						}
						
						if (!groupAttributes.isEmpty()) {
							Table attrTable = htmlFactory.table().bordered();
							for (Entry<String, String> ae: groupAttributes.entrySet()) {
								Row attrRow = attrTable.row();
								attrRow.header(StringEscapeUtils.escapeHtml4(ae.getKey())).style("align", "left");
								preStyle(attrRow.cell(StringEscapeUtils.escapeHtml4(ae.getValue())));								
							}
							accordionFragment.content(htmlFactory.panel(Bootstrap.Style.INFO, "Attributes", attrTable, null));
						}
						
						if (!groupStyles.isEmpty()) {
							Table styleTable = htmlFactory.table().bordered();
							for (Entry<String, String> se: groupStyles.entrySet()) {
								Row styleRow = styleTable.row();
								styleRow.header(StringEscapeUtils.escapeHtml4(se.getKey())).style("align", "left");
								preStyle(styleRow.cell(StringEscapeUtils.escapeHtml4(se.getValue())));								
							}
							accordionFragment.content(htmlFactory.panel(Bootstrap.Style.INFO, "Styles", styleTable, null));
						}
					}
				}	
				
				formsAccordion.item(
						"<b>"+form.getName()+"</b> : "+(form.getEType()==null ? "void" : form.getEType().getName())+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
						null,
						false,
						null,
						accordionFragment);
			}
			
			
			Tag formIcon = htmlFactory.glyphicon(Glyphicon.list_alt).style("margin-right", "5px");
			
			tabs.item(formIcon+" Forms", formsAccordion);						
		}				
	}
	
	protected void tabs(
			final DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, 
			String registryPath, 
			EClass eClass,
			Tabs tabs) {
		
		documentationTab(docRoute, baseURL, urlPrefix, eClass, tabs);
		diagramTab(docRoute, eClass, tabs);
		attributesTab(docRoute, baseURL, urlPrefix, registryPath, eClass, tabs);
		referencesTab(docRoute, baseURL, urlPrefix, registryPath, eClass, tabs);
		operationsTab(docRoute, baseURL, urlPrefix, registryPath, eClass, tabs);
		routesTab(docRoute, baseURL, urlPrefix, registryPath, eClass, tabs);
		formsTab(docRoute, baseURL, urlPrefix, eClass, registryPath, tabs);
		supertypesTab(docRoute, baseURL, urlPrefix, registryPath, eClass, tabs);
		subTypesTab(docRoute, baseURL, urlPrefix, registryPath, eClass, tabs);
		sections(docRoute, eClass, tabs);
	}

	protected void diagramTab(final DocRoute docRoute, EClass modelElement, Tabs tabs) {
		try {
			StringBuilder sb = new StringBuilder();
			PlantUmlTextGenerator gen = new PlantUmlTextGenerator(sb) {
				
				@Override
				protected Iterable<EClass> getSubTypes(EClass eClass) {
					Set<EClassifierKey> subTypes = docRoute.getInheritanceMap().get(new EClassifierKey(eClass));
					if (subTypes==null || subTypes.isEmpty()) {
						return super.getSubTypes(eClass);
					}
					
					Set<EClass> ret = new HashSet<EClass>();
					for (EClassifierKey stKey: subTypes) {
						EClassifier st = docRoute.getEClassifier(stKey);
						if (st instanceof EClass) {
							ret.add((EClass) st);
						}
					}
					return ret;
				}
				
			};
			gen.appendStartUml();
			gen.appendWithRelationships(modelElement);
			gen.appendEndUml();
			SourceStringReader reader = new SourceStringReader(sb.toString());
			try (final ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				// Write the first image to "os"
				reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
				os.close();
		
				// The XML is stored into svg
				final String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
				tabs.item("Context diagram", svg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		if (routeTracker!=null) {
			routeTracker.close();
			routeTracker = null;
		}
		
	}

}
