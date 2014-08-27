package org.nasdanika.webtest;

import org.openqa.selenium.WebDriver;

/**
 * Tests shall implement this interface in order for the runner to take
 * screenshots before and after test method invocation.
 * 
 * WebDriver shall be typically initialized in Before method and closed in After method. 
 * 
 * @author Pavel Vlasov
 *
 */
public interface WebTest<D extends WebDriver> {
	
	D getWebDriver();

}
