package org.nasdanika.html;

public interface ListGroup extends UIElement<ListGroup> {
	
	ListGroup item(Object content, Style style);

	int length();

}
