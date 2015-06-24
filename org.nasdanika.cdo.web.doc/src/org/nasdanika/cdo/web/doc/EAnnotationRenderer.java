package org.nasdanika.cdo.web.doc;

import org.eclipse.emf.ecore.EAnnotation;
import org.nasdanika.html.HTMLFactory;

public interface EAnnotationRenderer {
	
	String render(EAnnotation eAnnotation, HTMLFactory htmlFactory);

}
