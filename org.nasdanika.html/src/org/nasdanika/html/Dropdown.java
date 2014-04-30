package org.nasdanika.html;

public interface Dropdown<T extends Dropdown<?>> extends UIElement<T> {

	T item(String item);
	
	T divider();
	
	T header(String header);
	
}
