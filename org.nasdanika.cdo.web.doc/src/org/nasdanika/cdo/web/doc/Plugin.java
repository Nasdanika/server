package org.nasdanika.cdo.web.doc;

import java.net.URL;

/**
 * Plugins expand tokens in the form of <code>{{plugin name(config)>content}}</code>, e.g. <code>{{youtube(large)>qfvr6HWo_Ok}}</code>
 * Only the plugin name is mandatory.
 * @author Pavel
 *
 */
public interface Plugin {
	
	/**
	 * Can be used by the plugin to process sub-plugins.
	 * @author Pavel
	 *
	 */
	interface Filter {
		
		/**
		 * Passes content through plugin expansion.
		 * @param content
		 * @return Markdown without plugin tags.
		 */
		String filter(Object content);
		
	}
	
	
	Object process(String config, String content, URL baseURL, String urlPrefix, Filter filter, DocRoute docRoute);
	

}
