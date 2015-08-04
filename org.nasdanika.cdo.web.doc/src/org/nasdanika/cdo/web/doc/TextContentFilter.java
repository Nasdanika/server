package org.nasdanika.cdo.web.doc;

import java.net.URL;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

public class TextContentFilter implements ContentFilter {

	@Override
	public Object filter(Object content, DocRoute docRoute, URL baseURL, String urlPrefix) throws Exception {
		return "<div style=\"white-space:pre-wrap; font-family:monospace\">"+StringEscapeUtils.escapeHtml4(DocRoute.stringify(content))+"</div>";
	}

}
