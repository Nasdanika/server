package org.nasdanika.html;

/**
 * Used to construct an application with header, navbar, one or more content columns,
 * and a footer. 
 * @author Pavel
 *
 */
public interface ApplicationPanel extends UIElement<ApplicationPanel> {
	
	interface ContentPanel extends UIElement<ContentPanel> {
		
		/**
		 * Sets panel width for a given device size
		 * @param deviceSize
		 * @param width
		 * @return
		 */
		ContentPanel width(DeviceSize deviceSize, int width);
		
	}
	
	ApplicationPanel header(String header);
	
	/**
	 * If this URL is set then header text is rendered as a link.
	 * @param url
	 * @return
	 */
	ApplicationPanel headerLink(String url);
	
	ApplicationPanel navigation(String navigation);
	
	/**
	 * Adds a content column
	 * @param content column content
	 * @return
	 */
	ContentPanel content(String content);
	
	ApplicationPanel footer(String footer);
	
	ApplicationPanel style(Style style);
	
	/**
	 * Sets panel width. If not set the width is 100%
	 * @param width
	 * @return
	 */
	ApplicationPanel width(int width);
	
	/**
	 * Minimal application height.
	 * @param minHeight
	 * @return
	 */
	ApplicationPanel minHeight(int minHeight);

}
