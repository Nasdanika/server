package org.nasdanika.html;

public interface Accordion extends UIElement<Accordion>, NamedItemsContainer<Accordion> {
	
	Accordion item(Object title, Style style, boolean initial, Object content);
	
	Accordion ajaxItem(Object title, Style style, Object location);	
	
	/**
	 * Style to apply to items which don't explicitly set their own style.
	 * @param style
	 * @return
	 */
	Accordion style(Style style);

}
