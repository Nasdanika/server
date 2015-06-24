package org.nasdanika.cdo.web.doc;

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.pegdown.LinkRenderer;

public class EDataTypeDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EDataTypeDocumentationGenerator(LinkRenderer linkRenderer, Map<String, EAnnotationRenderer> eAnnotationRenderers) {
		super(linkRenderer, eAnnotationRenderers);
	}

	public String generate(
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EDataType eDataType) {
		
		// TODO - path?
		Tag dataTypeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EDataType.gif")
				.style("margin-right", "5px");
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EDataType "+eDataType.getName()));
		ret.content(htmlFactory.tag(TagName.h2, dataTypeIcon, eDataType.getName()));
		String doc = getModelDocumentation(eDataType);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}		

		// TODO - other things.
		
		
		for (EAnnotation eAnnotation: eDataType.getEAnnotations()) {
			ret.content(documentAnnotation(htmlFactory, eAnnotation));
		}
		return ret.toString();		
		
	}

}
