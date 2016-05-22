package org.nasdanika.cdo.web.doc;

import java.net.URL;

import org.nasdanika.web.HttpServletRequestContext;

public interface DocumentationContentProvider {
	
	Object getContent(HttpServletRequestContext context, URL baseURL, String urlPrefix, String path);

}
