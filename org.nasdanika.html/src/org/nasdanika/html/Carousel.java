package org.nasdanika.html;

public interface Carousel extends UIElement<Carousel> {
	
	interface Slide {
		
		Slide active(boolean active);
		
		Slide active();
		
		Slide content(Object... content);
		
		Slide caption(Object... caption);
		
	}
	
	Carousel ride(boolean ride);
	
	Carousel indicatorsBackground(Color background);
	
	Slide slide();
		
}
