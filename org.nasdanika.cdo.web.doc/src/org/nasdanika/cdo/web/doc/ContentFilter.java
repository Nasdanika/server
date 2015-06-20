package org.nasdanika.cdo.web.doc;

import java.util.Map;

/**
 * Converts content from one format to another.
 * @author Pavel
 *
 */
public interface ContentFilter {
	
	Object filter(Object content, Map<Object, Object> env) throws Exception;

}
