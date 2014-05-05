package org.nasdanika.html;

import org.nasdanika.html.HTMLFactory.Placement;

public interface InputGroup<T extends InputGroup<?>> extends UIElement<T> {

	/**
	 * Sets left add-on
	 * @param addOn
	 * @return
	 * @throws IllegalStateException if left button has already been created.
	 */
	T leftAddOn(Object... addOn);
	
	T size(Size size);
	
	/**
	 * Creates left button.
	 * @param text
	 * @return
	 * @throws IllegalStateException if left add-on has already been set. 
	 */
	Button leftButton(Object... content);
	
	/**
	 * Creates left popover help button
	 * @param text
	 * @return
	 * @throws IllegalStateException if left add-on has already been set. 
	 */
	Button leftPopoverHelpButton(Placement placement, String title, String body);
	
	/**
	 * Sets right add-on
	 * @param addOn
	 * @return
	 * @throws IllegalStateException if right button has already been created.
	 */
	T rightAddOn(Object... addOn);
	
	/**
	 * Creates rigth button.
	 * @param text
	 * @return
	 * @throws IllegalStateException if right add-on has already been set. 
	 */
	Button rightButton(Object... content);
	
	/**
	 * Creates right popover help button
	 * @param text
	 * @return
	 * @throws IllegalStateException if left add-on has already been set. 
	 */
	Button rightPopoverHelpButton(Placement placement, String title, String body);
		
}
