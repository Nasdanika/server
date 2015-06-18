package org.nasdanika.cdo.web.doc;

/**
 * Converts content from one format to another.
 * @author Pavel
 *
 */
public interface ContentFilter {
	
	Object filter(Object content, String docRoutePath);

}
