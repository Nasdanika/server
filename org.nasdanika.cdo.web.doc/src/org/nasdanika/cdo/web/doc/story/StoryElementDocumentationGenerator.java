package org.nasdanika.cdo.web.doc.story;

import java.net.URL;

import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.web.HttpServletRequestContext;

/**
 * A combination of a route and toc node factory.
 * @author Pavel Vlasov
 *
 */
public interface StoryElementDocumentationGenerator<T> {
	
	void createToc(T obj, TocNode parent);
	
	Object getContent(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path);

}
