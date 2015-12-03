package org.nasdanika.webtest;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.WebDriver;

/**
 * Represents UI page/screen. Page methods shall correspond to interactions with individual page elements, 
 * grouping of interactions into steps is recommended to implement in Actor methods.
 * @author Pavel Vlasov
 *
 */
public interface Page<D extends WebDriver> {

	D getWebDriver();
	
	/**
	 * @return Web elements on the page and page fragments sorted by name.
	 */
	List<Field> webElements();	
	
	// TODO - isFragment()? or PageFragment annotation?
	
}
