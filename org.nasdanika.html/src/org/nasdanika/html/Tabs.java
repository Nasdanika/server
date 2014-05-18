package org.nasdanika.html;

public interface Tabs extends UIElement<Tabs> {
	
	Tabs tab(Object name, Object hint, Object... content);
	
	Tabs ajaxTab(Object name, Object hint, Object location);
	
	boolean isEmpty();

}
