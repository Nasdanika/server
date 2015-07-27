package org.nasdanika.cdo.web.doc;

import java.net.URL;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

public class EDataTypeDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EDataTypeDocumentationGenerator(DocRoute docRoute) {
		super(docRoute);
	}

	public String generate(
			URL baseURL, 
			String urlPrefix,
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EDataType eDataType) {
		
		Tag dataTypeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EDataType.gif")
				.style("margin-right", "5px");
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EDataType "+eDataType.getName()));
		ret.content(htmlFactory.tag(TagName.h2, dataTypeIcon, eDataType.getName()));
		
		Class<?> instanceClass = eDataType.getInstanceClass();
		boolean isArray = instanceClass.isArray();
		if (isArray) {
			instanceClass = instanceClass.getComponentType();
		}
		Tag icDiv = htmlFactory.div().style("margin-bottom", "5px").style("font-family", "monospace");
		ret.content(icDiv);
		if (instanceClass.isPrimitive()) {
			icDiv.content(instanceClass.getName());
		} else {
			icDiv.content(markdownToHtml(baseURL, urlPrefix, "[[javadoc>"+eDataType.getInstanceClassName()+"|"+eDataType.getInstanceClassName()+"]]"));
		}
		if (isArray) {
			icDiv.content("[]");
		}
		String doc = getModelDocumentation(baseURL, urlPrefix, eDataType);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}		
		
		for (EAnnotation eAnnotation: eDataType.getEAnnotations()) {
			ret.content(documentAnnotation(htmlFactory, eAnnotation));
		}
		
		// sections?
		
		return ret.toString();		
		
	}

}
