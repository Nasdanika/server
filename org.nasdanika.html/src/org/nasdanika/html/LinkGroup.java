package org.nasdanika.html;

public interface LinkGroup extends UIElement<LinkGroup> {
	
	LinkGroup item(String content, String href, Style style, boolean active);

}
