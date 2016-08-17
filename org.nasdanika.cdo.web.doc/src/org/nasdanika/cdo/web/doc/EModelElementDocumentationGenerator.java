package org.nasdanika.cdo.web.doc;

import java.net.URI;

import org.eclipse.emf.ecore.EModelElement;

public interface EModelElementDocumentationGenerator<T extends EModelElement> {
	
	String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	String generate(
			DocRoute docRoute,
			URI baseURI,
			String urlPrefix,
			String registryPath,
			T modelElement);	
	
	void close();

}
