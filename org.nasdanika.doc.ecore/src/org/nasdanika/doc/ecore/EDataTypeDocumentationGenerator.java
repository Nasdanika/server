package org.nasdanika.doc.ecore;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

public class EDataTypeDocumentationGenerator extends EModelElementDocumentationGenerator<EDataType> {
	
	public EDataTypeDocumentationGenerator(EDataType dataType) {
		super(dataType);
	}

	@Override
	public String generateDocumentation(String diagramCMap) {		
		HTMLFactory htmlFactory = getHtmlFactory();		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EDataType "+getModelElement().getName()));
		ret.content(htmlFactory.tag(TagName.h2, eClassifierIcon(getModelElement()), getModelElement().getName()));
		
		Class<?> instanceClass = getModelElement().getInstanceClass();
		if (instanceClass != null) {
			boolean isArray = instanceClass.isArray();
			if (isArray) {
				instanceClass = instanceClass.getComponentType();
			}
			Tag icDiv = htmlFactory.div().style("margin-bottom", "5px").style("font-family", "monospace");
			ret.content(icDiv);
			if (instanceClass.isPrimitive()) {
				icDiv.content(instanceClass.getName());
			} else {
				icDiv.content(javaDocLink(getModelElement().getInstanceClassName()));
			}
			if (isArray) {
				icDiv.content("[]");
			}
		}
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
		
		return ret.toString();				
	}

}
