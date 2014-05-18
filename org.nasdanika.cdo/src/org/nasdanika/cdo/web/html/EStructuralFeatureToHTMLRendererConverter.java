package org.nasdanika.cdo.web.html;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EStructuralFeatureToHTMLRendererConverter extends EObjectToHTMLRendererConverter<EStructuralFeature> {

	@Override
	protected String label(EStructuralFeature source) {
		return StringEscapeUtils.escapeHtml4(source.getName());
	}

}
