package org.nasdanika.html;

public interface Navbar extends UIElement<Navbar> {

	Navbar item(String item, boolean active);
	
	Dropdown<?> dropdown(String name);
	
	// TODO - forms
	
}
