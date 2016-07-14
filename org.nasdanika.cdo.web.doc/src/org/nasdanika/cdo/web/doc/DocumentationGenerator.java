package org.nasdanika.cdo.web.doc;

import java.net.URL;

import org.nasdanika.web.HttpServletRequestContext;

/**
 * A combination of a route and toc node factory.
 * @author Pavel Vlasov
 *
 */
public interface DocumentationGenerator<T> {
	
	void createToc(T obj, TocNode parent);
	
	Object getContent(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception;

}
