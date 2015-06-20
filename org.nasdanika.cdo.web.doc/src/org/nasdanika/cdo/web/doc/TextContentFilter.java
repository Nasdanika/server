package org.nasdanika.cdo.web.doc;

import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

public class TextContentFilter implements ContentFilter {

	@Override
	public Object filter(Object content, Map<Object, Object> env) throws Exception {
		return "<div style=\"white-space:pre-wrap; font-family:monospace\">"+StringEscapeUtils.escapeHtml4(DocRoute.stringify(content))+"</div>";
	}

}
