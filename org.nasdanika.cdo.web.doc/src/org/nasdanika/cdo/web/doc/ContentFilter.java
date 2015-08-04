package org.nasdanika.cdo.web.doc;

import java.net.URL;

/**
 * Converts content from one format to another.
 * @author Pavel
 *
 */
public interface ContentFilter {
	
	Object filter(Object content, DocRoute docRoute, URL baseURL, String urlPrefix) throws Exception;

}
