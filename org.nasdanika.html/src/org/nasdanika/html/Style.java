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
	
	interface Box<T> {
		
		T left(Object spec);
		T right(Object spec);
		T top(Object spec);
		T bottom(Object spec);
		
	}
	
	T margin(Object spec);
	
	Box<T> margin();
	
	T padding(Object spec);
	
	Box<T> padding();
	
	T border(Object spec);
	
	Box<T> border();

}
