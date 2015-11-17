package org.nasdanika.html;

public interface Accordion extends UIElement<Accordion>, NamedItemsContainer<UIElement<?>, Accordion> {
	
	UIElement<?> item(Object title, Bootstrap.Style style, boolean initial, Object content);
	
	UIElement<?> ajaxItem(Object title, Bootstrap.Style style, Object location);	
	
	/**
	 * Style to apply to items which don't explicitly set their own style.
	 * @param style
	 * @return
	 */
	Accordion style(Bootstrap.Style style);

}
