package org.nasdanika.webtest;

/**
 * Actor represents a system user. Actor methods group simple page
 * interactions into steps, e.g. log-in step may include entering login id, password, and clicking
 * Log-in button.
 * @author Pavel Vlasov
 *
 */
public interface Actor {

	Page getCurrentPage();	
	
}
