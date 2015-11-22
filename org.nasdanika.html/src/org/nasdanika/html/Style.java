package org.nasdanika.html;

/**
 * Java bindings for frequently used CSS styles. 
 * @author Pavel Vlasov
 *
 */
public interface Style<T extends UIElement<T>> {
	
	T width(Object width);
	T height(Object height);
	
	interface Font<T> {
		
		T size(Object size);
		
		T family(Object family);
		
	};
	
	Font<T> font();

}
