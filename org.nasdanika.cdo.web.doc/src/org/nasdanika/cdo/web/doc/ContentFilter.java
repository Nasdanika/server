package org.nasdanika.cdo.web.doc;

import java.net.URI;

/**
 * Converts content from one format to another.
 * @author Pavel
 *
 */
public interface ContentFilter {
	
	Object filter(Object content, DocRoute docRoute, URI baseURI, String urlPrefix) throws Exception;

}
