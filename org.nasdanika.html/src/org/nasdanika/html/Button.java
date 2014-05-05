package org.nasdanika.html;

public interface Button extends UIElement<Button>, Dropdown<Button>, Container<Button> {
	
	enum Type { BUTTON, SUBMIT, RESET }
	
	Button type(Type type);
	
	Button style(Style style);
	
	Button size(Size size);
	
	Button block(boolean block);
	
	Button block();
	
	Button active(boolean active);
	
	Button active();
	
	Button disabled(boolean disabled);
	
	Button disabled();
	
	Button split(boolean split);
	
	Button split();
	
	Button dropup(boolean dropup);
	
	Button dropup();

}
