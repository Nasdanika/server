package org.nasdanika.html;

public interface LinkGroup extends UIElement<LinkGroup> {
	
	LinkGroup item(Object content, Object href, Style style, boolean active);
	
	/**
	 * Creates an item and returns it for further configuration.
	 * @param content
	 * @param style
	 * @param active
	 * @return
	 */
	Tag item(Object content, Style style, boolean active);
	
	int length();

}
