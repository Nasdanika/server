package org.nasdanika.webtest;

import org.openqa.selenium.WebDriver;

/**
 * This interface shall be implemented and exposed by 
 * collector service components.
 * @author Pavel Vlasov
 *
 */
public interface CollectorFactory {

	Collector<WebDriver> createCollector();
	
}
