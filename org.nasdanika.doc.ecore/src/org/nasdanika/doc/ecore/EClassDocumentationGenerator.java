package org.nasdanika.doc.ecore;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

import net.sourceforge.plantuml.SourceStringReader;

public class EClassDocumentationGenerator extends EModelElementDocumentationGenerator<EClass> {
	
	public EClassDocumentationGenerator(EClass modelElement) {
		super(modelElement);
	}

	/**
	 * Generates PNG diagram.
	 * @return
	 * @throws IOException 
	 */
	public String generateDiagram(
			boolean leftToRightDirection, 
			String width, 
			int depth, 
			PlantUmlTextGenerator.RelationshipDirection relationshipDirection,
			boolean appendAttributes,
			boolean appendOperations,
			OutputStream out) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		PlantUmlTextGenerator gen = new PlantUmlTextGenerator(sb, this::getEClassifierLocation, this::getFirstDocSentence) {
			
			@Override
			protected Collection<EClass> getSubTypes(EClass eClass) {
				return EClassDocumentationGenerator.this.getSubTypes(eClass);
			}
			
			@Override
			protected Collection<EClass> getReferrers(EClass eClass) {
				return EClassDocumentationGenerator.this.getReferrers(eClass);
			}
			
			@Override
			protected boolean isAppendAttributes(EClass eClass) {
				return appendAttributes;
			}
			
			@Override
			protected boolean isAppendOperations(EClass eClass) {
				return appendOperations;
			}
			
		};
		gen.appendStartUml();
		
		if (leftToRightDirection) {
			sb.append("left to right direction").append(System.lineSeparator());
		}
		
		if (width != null) {
			sb.append("scale ").append(width).append(" width").append(System.lineSeparator());
		}
						
		gen.appendWithRelationships(Collections.singleton(getModelElement()), relationshipDirection, depth);
		
		gen.appendEndUml();
		SourceStringReader reader = new SourceStringReader(sb.toString());
		return reader.generateDiagramDescription(out).getCmapData();
	}
		
	@Override
	public String generateDocumentation(String diagramCMap) {
		HTMLFactory htmlFactory = getHtmlFactory();
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EClass "+getModelElement().getName()));
		ret.content(htmlFactory.tag(TagName.h2, eClassifierIcon(getModelElement()), getModelElement().isAbstract() ? "<I>"+getModelElement().getName()+"</I>" : getModelElement().getName()));
		StringBuilder modifiers = new StringBuilder();
		if (getModelElement().isInterface()) {
			modifiers.append("interface ");
		} else {
			if (getModelElement().isAbstract()) {
				modifiers.append("abstract ");
			}
			modifiers.append("class ");
		}
		
		ret.content(htmlFactory.div(javaDocLink(getModelElement().getInstanceClassName())).style("margin-bottom", "5px").style("font-family", "monospace"));
	
		Tabs tabs = htmlFactory.tabs();
		ret.content(tabs);
		tabs(tabs, diagramCMap);
		return ret.toString();		
	}

	protected void documentationTab(Tabs tabs) {
		Fragment ret = getHtmlFactory().fragment();
		String doc = getModelDocumentation(getModelElement());
		if (!isBlank(doc)) {
			ret.content(getHtmlFactory().div(doc)
					.addClass("markdown-body")
					.style().margin().top("10px")
					.style().margin().bottom("10px"));
		}
		
		for (EAnnotation eAnnotation: getModelElement().getEAnnotations()) {
			ret.content(documentAnnotation(eAnnotation));
		}
		
		if (!ret.isEmpty()) {
			tabs.item("Documentation", ret);
		}
	}
	

	/**
	 * Override to return a list of sub-types of given EClass. 
	 * This implementation returns all sub-types found in the EClass' current package. 
	 * @param eClass
	 * @return
	 */
	protected Collection<EClass> getSubTypes(EClass eClass) {
		Collection<EClass> ret = new ArrayList<>();
		for (EClassifier ec: getModelElement().getEPackage().getEClassifiers()) {
			if (eClass != ec && ec instanceof EClass && eClass.isSuperTypeOf((EClass) ec)) {
				ret.add((EClass) ec);
			}
		}
		return ret;
	}
	
	protected void subTypesTab(Tabs tabs) {
		
		Collection<EClass> subTypes = getSubTypes(getModelElement());
		if (subTypes!=null && !subTypes.isEmpty()) {
			Table stTable = getHtmlFactory().table().bordered();
			Row hr = stTable.row().style(Bootstrap.Style.INFO);
			hr.header("Name");
			hr.header("Description");
			for (EClass st: subTypes) {
				Row stRow = stTable.row();
				stRow.cell(eClassifierLink(st, false));
				stRow.cell(getFirstDocSentence(st));
			}
			tabs.item("Subtypes", stTable);
		}
	}

	protected void supertypesTab(Tabs tabs) {
		if (!getModelElement().getESuperTypes().isEmpty()) {
			Table stTable = getHtmlFactory().table().bordered();
			Row hr = stTable.row().style(Bootstrap.Style.INFO);
			hr.header("Name");
			hr.header("Description");
			for (EClass st: getModelElement().getESuperTypes()) {
				Row stRow = stTable.row();
				stRow.cell(eClassifierLink(st, false));
				stRow.cell(getFirstDocSentence(st));
			}
			tabs.item("Supertypes", stTable);
		}
	}

	protected void attributesTab(Tabs tabs) {
		
		HTMLFactory htmlFactory = getHtmlFactory();
		
		Tag attributeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", getIconsBaseLocation()+"EAttribute.gif")
				.style("margin-right", "5px");
		
		List<EAttribute> eAllAttributes = new ArrayList<>(getModelElement().getEAllAttributes());
		if (!eAllAttributes.isEmpty()) {
			Collections.sort(eAllAttributes, NAMED_ELEMENT_COMPARATOR);
			Accordion attributesAccordion = htmlFactory.accordion();
			for (EAttribute attr: eAllAttributes) {
				String firstDocSentence = getFirstDocSentence(attr);
				if (isBlank(firstDocSentence)) {
					EClassifier type = attr.getEType();
					firstDocSentence = getFirstDocSentence(type);
				}
				String declaringType = attr.getEContainingClass()==getModelElement() ? "" : " ("+attr.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();

				if (attr.getEContainingClass() != getModelElement()) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(attr.getEContainingClass(), true));
				}
				
				Row row = propTable.row();								
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(attr.getEType(), true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(attr));
				
				String defaultValueLiteral = attr.getDefaultValueLiteral();
				row = propTable.row();				
				row.header("Default value").style("align", "left");
				row.cell(htmlFactory.div(isBlank(defaultValueLiteral) ? "" : StringEscapeUtils.escapeHtml4(defaultValueLiteral))
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

				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(attr), propTable);				
								
				for (EAnnotation ann: attr.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(ann));
				}
				
				attributesAccordion.item(
						"<b>"+attr.getName()+"</b> : "+attr.getEType().getName()+declaringType+(isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
						null,
						false,
						null,
						accordionFragment);
			}
			tabs.item(attributeIcon+" Attributes", attributesAccordion);			
		}
	}

	protected void referencesTab(Tabs tabs) {
		
		HTMLFactory htmlFactory = getHtmlFactory();
		
		Tag referenceIcon = htmlFactory.tag(TagName.img)
				.attribute("src", getIconsBaseLocation()+"EReference.gif")
				.style("margin-right", "5px");
		
		List<EReference> eAllReferences = new ArrayList<>(getModelElement().getEAllReferences());
		if (!eAllReferences.isEmpty()) {
			Collections.sort(eAllReferences, NAMED_ELEMENT_COMPARATOR);
			Accordion referencesAccordion = htmlFactory.accordion();
			for (EReference ref: eAllReferences) {
				String firstDocSentence = getFirstDocSentence(ref);
				if (isBlank(firstDocSentence)) {
					EClassifier type = ref.getEType();
					firstDocSentence = getFirstDocSentence(type);
				}
				String declaringType = ref.getEContainingClass()==getModelElement() ? "" : " ("+ref.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();

				if (ref.getEContainingClass()!=getModelElement()) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(ref.getEContainingClass(), true));
				}
				
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(ref.getEType(), true));
				
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
					row.cell(eClassifierLink(eOpposite.getEContainingClass(), false), ".", eOpposite.getName());
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

				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(ref), propTable);				
				
				for (EAnnotation ann: ref.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(ann));
				}
								
				referencesAccordion.item(
						"<b>"+ref.getName()+"</b> : "+ref.getEType().getName()+declaringType+(isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
						null,
						false,
						null,
						accordionFragment);
			}
			tabs.item(referenceIcon+" References", referencesAccordion);			
		}
	}
	
	protected void operationsTab(Tabs tabs) {
		
		HTMLFactory htmlFactory = getHtmlFactory();
		List<EOperation> eOperations = new ArrayList<>(getModelElement().getEAllOperations());

		if (!eOperations.isEmpty()) {
			Collections.sort(eOperations, NAMED_ELEMENT_COMPARATOR);
			Accordion operationsAccordion = htmlFactory.accordion();
			for (EOperation operation: eOperations) {
				String firstDocSentence = getFirstDocSentence(operation);
				String declaringType = operation.getEContainingClass()==getModelElement() ? "" : " ("+operation.getEContainingClass().getName()+") ";
				
				Table propTable = htmlFactory.table().bordered();

				if (operation.getEContainingClass()!=getModelElement()) {
					Row row = propTable.row();								
					row.header("Declaring Type").style("align", "left");
					row.cell(eClassifierLink(operation.getEContainingClass(), true));
				}
				
				Row row = propTable.row();
				row.header("Type").style("align", "left");
				row.cell(eClassifierLink(operation.getEType(), true));
				
				row = propTable.row();
				row.header("Cardinality").style("align", "left");
				row.cell(cardinality(operation));
				
				row = propTable.row();
				row.header("Exceptions").style("align", "left");
				Tag exceptionsList = htmlFactory.tag(TagName.ul);
				if (operation.getEExceptions().size()==1) {
					row.cell(eClassifierLink(operation.getEExceptions().get(0), true));
				} else {
					for (EClassifier ex: operation.getEExceptions()) {
						exceptionsList.content(htmlFactory.tag(TagName.li, eClassifierLink(ex, true)));
					}
					row.cell(exceptionsList);
				}
				
				row = propTable.row();
				row.header("Unique").style("align", "left");
				row.cell(operation.isUnique() ? htmlFactory.glyphicon(Glyphicon.ok) : "");								
				
				Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(operation), propTable);
				
				for (EAnnotation ann: operation.getEAnnotations()) {
					accordionFragment.content(documentAnnotation(ann));
				}
				
				if (!operation.getEParameters().isEmpty()) {
					accordionFragment.content(htmlFactory.tag(TagName.h3, "Parameters"));
					for (EParameter param: operation.getEParameters()) {
						accordionFragment.content(htmlFactory.tag(TagName.h4, param.getName(), " : ", eClassifierLink(param.getEType(), true), " ", cardinality(param)));						
						String parameterDoc = getModelDocumentation(param);
						if (!isBlank(parameterDoc)) {
							accordionFragment.content(getHtmlFactory().div(parameterDoc)
									.addClass("markdown-body")
									.style().margin().top("10px")
									.style().margin().bottom("20px"));
							
						}
						for (EAnnotation ann: param.getEAnnotations()) {
							accordionFragment.content(documentAnnotation(ann));
						}						
					}
				}				
				
				operationsAccordion.item(
						"<b>"+operation.getName()+"</b> : "+(operation.getEType()==null ? "void" : operation.getEType().getName())+declaringType+(isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
						null,
						false,
						null,
						accordionFragment);
			}
			
			Tag operationIcon = htmlFactory.tag(TagName.img)
					.attribute("src", getIconsBaseLocation()+"EOperation.gif")
					.style("margin-right", "5px");
			
			tabs.item(operationIcon+" Operations", operationsAccordion);						
		}		
	}

	protected void tabs(Tabs tabs, String diagramCMap) {
		documentationTab(tabs);
		diagramTab(tabs, diagramCMap);
		attributesTab(tabs);
		referencesTab(tabs);
		operationsTab(tabs);
		supertypesTab(tabs);
		subTypesTab(tabs);
	}

	protected void diagramTab(Tabs tabs, String diagramCMap) {
		HTMLFactory htmlFactory = getHtmlFactory();
		tabs.item("Diagram", htmlFactory.fragment(htmlFactory.tag(TagName.img).attribute("src", getDiagramImageLocation()).attribute("usemap", "#plantuml_map"), diagramCMap));
	}

	protected String getDiagramImageLocation() {
		return getNamedElementFileName(getModelElement())+".png";
	}

}
