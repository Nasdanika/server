package org.nasdanika.html;

public interface Accordion extends UIElement<Accordion> {
	
	Accordion item(String title, String body, Style style);

}
