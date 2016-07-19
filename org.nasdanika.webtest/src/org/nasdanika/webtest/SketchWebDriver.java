package org.nasdanika.webtest;

import org.openqa.selenium.WebDriver;

/**
 * A marker interface which instructs the framework to use sketches from the {@link Sketch} annotation as 
 * screenshots. Instances of SketchWebDriver can be created with {@link WebTestUtil}.createSketchWebDriver() method.
 * One of possible use patterns - define a constant field of SketchWebDriver type in the page factory interface.
 * Then have the page factory implementation return page implementations which use Sketch annotations instead of
 * real logic when that sketch web driver instance is passed as a parameter. Also it is possible to have several
 * constants, e.g. for browser sketches and mobile sketches or for different screen sizes.
 * @author Pavel Vlasov
 *
 */
public interface SketchWebDriver extends WebDriver {

}
