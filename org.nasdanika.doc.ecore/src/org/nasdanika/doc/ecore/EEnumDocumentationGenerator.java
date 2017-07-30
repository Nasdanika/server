package org.nasdanika.doc.ecore;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag.TagName;

public class EEnumDocumentationGenerator extends EModelElementDocumentationGenerator<EEnum> {

	public EEnumDocumentationGenerator(EEnum modelElement) {
		super(modelElement);
	}

	@Override
	public String generateDocumentation() {		
		HTMLFactory htmlFactory = getHtmlFactory();		
		String enumIcon = eClassifierIcon(getModelElement());
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EEnum "+getModelElement().getName()));
		ret.content(htmlFactory.tag(TagName.h2, enumIcon, getModelElement().getName()));
		
		ret.content("enum "+javaDocLink(getModelElement().getInstanceClassName()));
		String doc = getModelDocumentation(getModelElement());
		if (!isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}		
		
		for (EAnnotation eAnnotation: getModelElement().getEAnnotations()) {
			ret.content(documentAnnotation(eAnnotation));
		}
		
		Accordion literalsAccordion = htmlFactory.accordion();
		ret.content(literalsAccordion);
		
		for (EEnumLiteral literal: getModelElement().getELiterals()) {			
			Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(literal));
			Table propTable = htmlFactory.table().bordered();
			accordionFragment.content(propTable);
			
			Row row = propTable.row();
			row.header("Literal").style("align", "left");
			preStyle(row.cell(StringEscapeUtils.escapeHtml4(literal.getLiteral())));
			
			row = propTable.row();
			row.header("Value").style("align", "left");
			row.cell(String.valueOf(literal.getValue()));
			
			for (EAnnotation ann: literal.getEAnnotations()) {
				accordionFragment.content(documentAnnotation(ann));
			}
			String firstDocSentence = getFirstDocSentence(literal);
			literalsAccordion.item(
					"<b>"+literal.getName()+"</b> "+(isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
					null,
					false,
					null,
					accordionFragment);
		}
		
		return ret.toString();		
		
	}

}
