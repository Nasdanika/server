package org.nasdanika.html;

public interface Accordion extends UIElement<Accordion> {
	
	Accordion item(Object title, Object body, Style style);

}
