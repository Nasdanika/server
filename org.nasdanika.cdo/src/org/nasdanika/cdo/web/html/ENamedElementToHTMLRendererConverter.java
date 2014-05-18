package org.nasdanika.cdo.web.html;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.ENamedElement;

public class ENamedElementToHTMLRendererConverter extends EObjectToHTMLRendererConverter<ENamedElement> {

	@Override
	protected String label(ENamedElement source) {
		return StringEscapeUtils.escapeHtml4(source.getName());
	}
	
}
