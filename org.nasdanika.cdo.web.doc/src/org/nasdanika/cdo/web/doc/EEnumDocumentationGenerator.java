package org.nasdanika.cdo.web.doc;

import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

public class EEnumDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EEnumDocumentationGenerator(DocRoute docRoute) {
		super(docRoute);
	}

	public String generate(
			URL baseURL, 
			String urlPrefix,
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EEnum eEnum) {
		
		Tag enumIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EEnum.gif")
				.style("margin-right", "5px");
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EEnum "+eEnum.getName()));
		ret.content(htmlFactory.tag(TagName.h2, enumIcon, eEnum.getName()));
		
		ret.content(htmlFactory.div(markdownToHtml(baseURL, urlPrefix, "enum [[javadoc>"+eEnum.getInstanceClassName()+"|"+eEnum.getInstanceClassName()+"]]")).style("margin-bottom", "5px").style("font-family", "monospace"));
		String doc = getModelDocumentation(baseURL, urlPrefix, eEnum);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}		

		for (EAnnotation eAnnotation: eEnum.getEAnnotations()) {
			ret.content(documentAnnotation(htmlFactory, eAnnotation));
		}
		
		Accordion literalsAccordion = htmlFactory.accordion();
		ret.content(literalsAccordion);
		
		for (EEnumLiteral literal: eEnum.getELiterals()) {			
			Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(baseURL, urlPrefix, literal));
			Table propTable = htmlFactory.table().bordered();
			accordionFragment.content(propTable);
			
			Row row = propTable.row();
			row.header("Literal").style("align", "left");
			preStyle(row.cell(StringEscapeUtils.escapeHtml4(literal.getLiteral())));
			
			row = propTable.row();
			row.header("Value").style("align", "left");
			row.cell(String.valueOf(literal.getValue()));
			
			for (EAnnotation ann: literal.getEAnnotations()) {
				accordionFragment.content(documentAnnotation(htmlFactory, ann));
			}
			String firstDocSentence = getFirstDocSentence(baseURL, urlPrefix, literal);
			literalsAccordion.item(
					"<b>"+literal.getName()+"</b> "+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"), 
					accordionFragment);
		}
		
		// sections ?
		
		return ret.toString();		
		
	}

}
