package org.nasdanika.cdo.web.doc;


/**
 * Resolves indexable content (text or HTML) by path.
 * @author Pavel
 *
 */
public interface SearchableContentProvider {
	
	interface ContentEntry {
		/**
		 * @return Content string if searchable, null if present but not searchable (e.g. a binary file).
		 */
		String getContent();
		boolean isHTML();
	}
	
	/**
	 * @param path
	 * @return content for valid paths, null for invalid paths (broken links).
	 */
	ContentEntry get(String path);

}
