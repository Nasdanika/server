package org.nasdanika.html;

public interface Pills extends UIElement<Pills>, NamedItemsContainer<Pills> {
	
	Pills stacked();
	
	Pills stacked(boolean stacked);
	
	/**
	 * Width of the pills column.
	 * @param deviceSize
	 * @param width
	 * @return
	 */
	Pills pillsWidth(UIElement.DeviceSize deviceSize, int width);
	
	
}
