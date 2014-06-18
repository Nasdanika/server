package org.nasdanika.html;

public interface NamedItemsContainer<T extends NamedItemsContainer<?>> {

	T item(Object name, Object... content);
	
	T ajaxItem(Object name, Object location);
	
	boolean isEmpty();
	
}
