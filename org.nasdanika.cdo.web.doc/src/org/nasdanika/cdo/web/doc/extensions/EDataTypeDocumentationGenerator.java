package org.nasdanika.cdo.web.doc.extensions;

import java.net.URI;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.TagName;
import org.nasdanika.web.HttpServletRequestContext;

public class EDataTypeDocumentationGenerator extends EModelElementDocumentationGeneratorImpl<EDataType> {

	@Override
	public String generate(
			DocRoute docRoute, 
			HttpServletRequestContext context, 
			URI baseURI, 
			String urlPrefix,
			String registryPath,
			EDataType eDataType) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		
		Tag dataTypeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EDataType.gif")
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
			icDiv.content(docRoute.markdownToHtml(baseURI, urlPrefix, "[[javadoc>"+eDataType.getInstanceClassName()+"|"+eDataType.getInstanceClassName()+"]]"));
		}
		if (isArray) {
			icDiv.content("[]");
		}
		String doc = getModelDocumentation(docRoute, baseURI, urlPrefix, eDataType);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}	
		
		mountedModelElementDocumentation(docRoute, eDataType, ret);
		
		for (EAnnotation eAnnotation: eDataType.getEAnnotations()) {
			ret.content(documentAnnotation(docRoute, eAnnotation));
		}
		
		// sections?
		//tabs(docRoute, eClass, tabs);
		
		return ret.toString();		
		
	}

	@Override
	public void close() {
		// NOP		
	}

}
