package org.nasdanika.webtest;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Base class which calculates number of page elements using reflection.
 */
public abstract class ReflectivePageBase<D extends WebDriver> implements Page<D> {

	@Override
	public int size() {
		int size = 0;
		for (Class<?> cls = this.getClass(); cls!=null; cls = cls.getSuperclass()) {
			for (Field field: cls.getDeclaredFields()) {
				if (WebElement.class.isAssignableFrom(field.getType())) {
					++size;
				} else if (Page.class.isAssignableFrom(field.getType())) {
					field.setAccessible(true);					
					try {
						Page<?> page = (Page<?>) field.get(this);
						if (page!=null) {
							size += page.size();
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						System.err.println("Cannot access "+field);
					}
				}
			}
		}
		return size;
	}
	
}
