package org.nasdanika.cdo.web.doc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.cdo.web.html.FormGeneratorBase;
import org.nasdanika.cdo.web.routes.CDOWebUtil;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement.Style;
import org.pegdown.LinkRenderer;

public class EClassDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EClassDocumentationGenerator(LinkRenderer linkRenderer, Map<String, EAnnotationRenderer> eAnnotationRenderers) {
		super(linkRenderer, eAnnotationRenderers);
	}

	public String generate(
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EClass eClass) {
		
		// TODO - path?
		Tag classIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EClass.gif")
				.style("margin-right", "5px");
		
		Tag referenceIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EReference.gif")
				.style("margin-right", "5px");
		
		Tag operationIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EOperation.gif")
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
		
//		if (eClass.getName().endsWith("ProtectionDomain")) {
//			System.out.println("--- "+eClass.getName());
//			System.out.println("\t"+eClass.getETypeParameters());
//			System.out.println("\t"+eClass.getEGenericSuperTypes());
//		}
		
		ret.content(htmlFactory.div(modifiers, eClass.getInstanceClassName()).style("margin-bottom", "5px").style("font-family", "monospace"));
		String doc = getModelDocumentation(eClass);
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
						
		generateAttributesTab(eClass, htmlFactory, docRoutePath, tabs, registryPath);
		
		List<EReference> eReferences = new ArrayList<>(eClass.getEReferences());
		if (!eReferences.isEmpty()) {
			Collections.sort(eReferences, NAMED_ELEMENT_COMPARATOR);
			tabs.item(referenceIcon+" References", "TODO");
		}
		
		List<EOperation> eOperations = new ArrayList<>();
		List<EOperation> routes = new ArrayList<>();
		List<EOperation> forms = new ArrayList<>();
		
		for (EOperation op: eClass.getEOperations()) {
			if (op.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE)!=null) {
				routes.add(op);
			} else if (op.getEAnnotation(FormGeneratorBase.FORM_ANNOTATION_SOURCE)!=null) {
				forms.add(op);
			} else {
				eOperations.add(op);
			}
		}
		
		if (!eOperations.isEmpty()) {
			Collections.sort(eOperations, NAMED_ELEMENT_COMPARATOR);
			tabs.item(operationIcon+" Operations", "TODO");
		}
		if (!routes.isEmpty()) {
			Collections.sort(routes, NAMED_ELEMENT_COMPARATOR);
			tabs.item(htmlFactory.glyphicon(Glyphicon.road)+" Routes", "TODO");
		}
		if (!forms.isEmpty()) {
			Collections.sort(forms, NAMED_ELEMENT_COMPARATOR);
			tabs.item(htmlFactory.glyphicon(Glyphicon.list_alt)+" Forms", "TODO");
		}
		
		if (!eClass.getESuperTypes().isEmpty()) {
			Table stTable = htmlFactory.table().bordered();
			Row hr = stTable.row().style(Style.INFO);
			hr.header("Name");
			hr.header("Description");
			for (EClass st: eClass.getESuperTypes()) {
				Row stRow = stTable.row();
				stRow.cell(eClassifierLink(htmlFactory, st, docRoutePath, registryPath, false));
				stRow.cell(getFirstDocSentence(st));
			}
			tabs.item("Supertypes", stTable);
		}
		
		// TODO - subtypes - collect from other classes present in the repo.
								
		return ret.toString();		
		
	}

	void generateAttributesTab(EClass eClass, HTMLFactory htmlFactory, String docRoutePath, Tabs tabs, String registryPath) {
		Tag attributeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EAttribute.gif")
				.style("margin-right", "5px");
		
		List<EAttribute> eAllAttributes = new ArrayList<>(eClass.getEAllAttributes());
		if (!eAllAttributes.isEmpty()) {
			Collections.sort(eAllAttributes, NAMED_ELEMENT_COMPARATOR);
			Accordion attributesAccordion = htmlFactory.accordion();
			for (EAttribute attr: eAllAttributes) {
				String firstDocSentence = getFirstDocSentence(attr);
				String declaringType = attr.getEContainingClass()==eClass ? "" : " ("+attr.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(htmlFactory, attr.getEType(), docRoutePath, registryPath, true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				if (attr.getLowerBound()==attr.getUpperBound()) {
					row.cell(attr.getLowerBound());
				} else {
					row.cell(attr.getLowerBound(), "..", attr.getUpperBound()==-1 ? "*" : String.valueOf(attr.getUpperBound()));
				}
				
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

				
				for (EAnnotation ann: attr.getEAnnotations()) {
					documentAnnotation(htmlFactory, ann);
				}
				
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(attr), propTable);				
				
				attributesAccordion.item(
						"<b>"+attr.getName()+"</b> : "+attr.getEType().getName()+declaringType+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						accordionFragment);
			}
			tabs.item(attributeIcon+" Attributes", attributesAccordion);			
		}
	}

}
