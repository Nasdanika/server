package org.nasdanika.cdo.web.doc;

import java.net.URI;

import org.nasdanika.web.HttpServletRequestContext;

public interface DocumentationContentProvider {
	
	Object getContent(HttpServletRequestContext context, URI baseURI, String urlPrefix, String path);

}
