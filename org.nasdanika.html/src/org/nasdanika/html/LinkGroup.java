package org.nasdanika.html;

public interface LinkGroup extends UIElement<LinkGroup> {
	
	LinkGroup item(Object content, Object href, Style style, boolean active);

}
