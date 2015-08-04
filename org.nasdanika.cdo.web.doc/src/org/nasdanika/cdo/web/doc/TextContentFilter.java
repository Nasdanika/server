package org.nasdanika.cdo.web.doc;

import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.core.CoreUtil;

public class TextContentFilter implements ContentFilter {

	@Override
	public Object filter(Object content, DocRoute docRoute, URL baseURL, String urlPrefix) throws Exception {
		return "<div style=\"white-space:pre-wrap; font-family:monospace\">"+StringEscapeUtils.escapeHtml4(CoreUtil.stringify(content))+"</div>";
	}

}
