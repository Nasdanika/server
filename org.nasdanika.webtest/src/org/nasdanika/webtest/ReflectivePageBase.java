package org.nasdanika.webtest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Base class which calculates number of page elements using reflection.
 */
public abstract class ReflectivePageBase<D extends WebDriver> implements Page<D> {
	
	@Override
	public List<Field> webElements() {
		List<Field> ret = new ArrayList<>();
		for (Class<?> cls = this.getClass(); cls!=null; cls = cls.getSuperclass()) {
			for (Field field: cls.getDeclaredFields()) {
				if (WebElement.class.isAssignableFrom(field.getType())) {
					ret.add(field);
				} else if (Page.class.isAssignableFrom(field.getType())) {
					field.setAccessible(true);					
					try {
						Page<?> page = (Page<?>) field.get(this);
						if (page!=null) {
							ret.addAll(page.webElements());
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						System.err.println("Cannot access "+field);
					}
				}
			}
		}
		Collections.sort(ret, new Comparator<Field>() {

			@Override
			public int compare(Field o1, Field o2) {
				return o1.toString().compareTo(o2.toString());
			}
			
		});
		
		return ret;		
	}
	
}
