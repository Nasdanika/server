package org.nasdanika.cdo.web.doc;

import java.net.URI;

import org.nasdanika.web.HttpServletRequestContext;

/**
 * A combination of a route and toc node factory.
 * @author Pavel Vlasov
 *
 */
public interface DocumentationGenerator<T> {
	
	void createToc(T obj, TocNode parent);
	
	Object getContent(T obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path) throws Exception;

}
