package org.nasdanika.cdo.web.doc;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.pegdown.LinkRenderer;

public class EEnumDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EEnumDocumentationGenerator(LinkRenderer linkRenderer) {
		super(linkRenderer);
	}

	public String generate(
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EEnum eEnum) {
		
		// TODO - path?
		Tag enumIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EEnum.gif")
				.style("margin-right", "5px");
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EEnum "+eEnum.getName()));
		ret.content(htmlFactory.tag(TagName.h2, enumIcon, eEnum.getName()));
		String doc = getModelDocumentation(eEnum);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}		

		// TODO - elements.
		
		for (EAnnotation eAnnotation: eEnum.getEAnnotations()) {
			ret.content(documentAnnotation(htmlFactory, eAnnotation));
		}
		
		return ret.toString();		
		
	}

}
