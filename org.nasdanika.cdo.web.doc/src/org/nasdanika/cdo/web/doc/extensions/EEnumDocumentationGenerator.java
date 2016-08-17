package org.nasdanika.cdo.web.doc.extensions;

import java.net.URI;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

public class EEnumDocumentationGenerator extends EModelElementDocumentationGeneratorImpl<EEnum> {

	@Override
	public String generate(
			DocRoute docRoute,
			URI baseURI, 
			String urlPrefix,
			String registryPath,
			EEnum eEnum) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		
		Tag enumIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EEnum.gif")
				.style("margin-right", "5px");
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EEnum "+eEnum.getName()));
		ret.content(htmlFactory.tag(TagName.h2, enumIcon, eEnum.getName()));
		
		ret.content(htmlFactory.div(docRoute.markdownToHtml(baseURI, urlPrefix, "enum [[javadoc>"+eEnum.getInstanceClassName()+"|"+eEnum.getInstanceClassName()+"]]")).style("margin-bottom", "5px").style("font-family", "monospace"));
		String doc = getModelDocumentation(docRoute, baseURI, urlPrefix, eEnum);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}		
		
		mountedModelElementDocumentation(docRoute, eEnum, ret);

		for (EAnnotation eAnnotation: eEnum.getEAnnotations()) {
			ret.content(documentAnnotation(docRoute, eAnnotation));
		}
		
		Accordion literalsAccordion = htmlFactory.accordion();
		ret.content(literalsAccordion);
		
		for (EEnumLiteral literal: eEnum.getELiterals()) {			
			Fragment accordionFragment = htmlFactory.fragment(getModelDocumentation(docRoute, baseURI, urlPrefix, literal));
			Table propTable = htmlFactory.table().bordered();
			accordionFragment.content(propTable);
			
			Row row = propTable.row();
			row.header("Literal").style("align", "left");
			preStyle(row.cell(StringEscapeUtils.escapeHtml4(literal.getLiteral())));
			
			row = propTable.row();
			row.header("Value").style("align", "left");
			row.cell(String.valueOf(literal.getValue()));
			
			for (EAnnotation ann: literal.getEAnnotations()) {
				accordionFragment.content(documentAnnotation(docRoute, ann));
			}
			String firstDocSentence = getFirstDocSentence(docRoute, baseURI, urlPrefix, literal);
			literalsAccordion.item(
					"<b>"+literal.getName()+"</b> "+(CoreUtil.isBlank(firstDocSentence) ? "" : " - <I>"+firstDocSentence+"</I>"),
					null,
					false,
					null,
					accordionFragment);
		}
		
		// sections ?
		//tabs(docRoute, eClass, tabs);
		
		return ret.toString();		
		
	}

	@Override
	public void close() {
		// NOP		
	}

}
