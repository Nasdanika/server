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

}
