package org.nasdanika.webtest;

import org.openqa.selenium.WebDriver;

/**
 * Represents UI page/screen. Page methods shall correspond to interactions with individual page elements, 
 * grouping of interactions into steps is recommended to implement in Actor methods.
 * @author Pavel Vlasov
 *
 */
public interface Page<D extends WebDriver> extends PageFragment<D> {

	
}
