package org.nasdanika.cdo.web.doc.extensions;

import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.cdo.web.doc.ContentFilter;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.core.CoreUtil;

public class TextContentFilter implements ContentFilter {

	@Override
	public Object filter(Object content, DocRoute docRoute, URL baseURL, String urlPrefix) throws Exception {
		return "<div style=\"white-space:pre-wrap; font-family:monospace\">"+StringEscapeUtils.escapeHtml4(CoreUtil.stringify(content))+"</div>";
	}

}
