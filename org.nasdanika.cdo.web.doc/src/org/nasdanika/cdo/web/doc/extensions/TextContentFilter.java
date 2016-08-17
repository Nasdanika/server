package org.nasdanika.cdo.web.doc.extensions;

import java.net.URI;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.cdo.web.doc.ContentFilter;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.core.CoreUtil;

public class TextContentFilter implements ContentFilter {

	@Override
	public Object filter(Object content, DocRoute docRoute, URI baseURI, String urlPrefix) throws Exception {
		return docRoute.getHtmlFactory().div(StringEscapeUtils.escapeHtml4(CoreUtil.stringify(content)))
				.style().whiteSpace().preWrap()
				.style().font().family("monospace");
	}

}
