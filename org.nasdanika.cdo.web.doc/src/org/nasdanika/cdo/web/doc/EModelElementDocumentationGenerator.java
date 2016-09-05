package org.nasdanika.cdo.web.doc;

import java.net.URI;

import org.eclipse.emf.ecore.EModelElement;
import org.nasdanika.web.HttpServletRequestContext;

public interface EModelElementDocumentationGenerator<T extends EModelElement> {
	
	String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	Object generate(
			DocRoute docRoute,
			HttpServletRequestContext context, 
			URI baseURI,
			String urlPrefix,
			String registryPath,
			T modelElement);	
	
	void close();

}
