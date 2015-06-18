package org.nasdanika.cdo.web.doc;

import org.apache.commons.lang3.StringEscapeUtils;

public class TextContentFilter implements ContentFilter {

	@Override
	public Object filter(Object content, String docRoutePath) {
		return "<div style=\"white-space:pre-wrap; font-family:monospace\">"+StringEscapeUtils.escapeHtml4(String.valueOf(content))+"</div>";
	}

}
