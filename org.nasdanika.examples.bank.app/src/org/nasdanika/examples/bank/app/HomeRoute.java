package org.nasdanika.examples.bank.app;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.Action;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

/**
 * Route for testing
 * @author Pavel
 *
 */
public class HomeRoute implements Route {

	@Override
	public Action execute(WebContext context) throws Exception {
		final HTMLFactory htmlFactory = context.getHTMLFactory();
				
		final AutoCloseable app = 
			htmlFactory.routerApplication(
				"My Application", 
				"main/router/ccview.html", 
				null, 
				htmlFactory.div("").id("main"));
		
		// TODO Auto-generated method stub
		return new Action() {
			
			@Override
			public void close() throws Exception {
				app.close();				
			}
			
			@Override
			public Object execute() throws Exception {
				return app.toString();
			}
		};
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

}
