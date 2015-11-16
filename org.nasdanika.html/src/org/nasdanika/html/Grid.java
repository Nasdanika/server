package org.nasdanika.html;

/**
 * Bootstrap grid interface.
 * @author Pavel Vlasov
 *
 */
public interface Grid<T> extends AutoCloseable {
	
	T container();
	T fluidContainer();
	T row();
	T col(UIElement.DeviceSize deviceSize, int width);
	
	/**
	 * Sets width for all device sizes
	 * @param width
	 * @return
	 */
	T col(int width);
	
	T colOffset(UIElement.DeviceSize deviceSize, int width);
	T colOffset(int width);

	T colPush(UIElement.DeviceSize deviceSize, int width);
	T colPush(int width);

	T colPull(UIElement.DeviceSize deviceSize, int width);
	T colPull(int width);

}
