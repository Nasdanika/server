package org.nasdanika.webtest;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.WebDriver;

/**
 * Represents UI page/screen. Page methods shall correspond to interactions with individual page elements, 
 * grouping of interactions into steps shall be implemented by Actor methods.
 * @author Pavel Vlasov
 *
 */
public interface PageFragment<D extends WebDriver> {

	D getWebDriver();
	
	/**
	 * @return Web elements on the page and page fragments sorted by name.
	 */
	List<Field> webElements();	
	
}
