package org.nasdanika.cdo.web.routes;

import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class HtmlExtensionGetRoute implements Route {

	@Override
	public Action execute(final WebContext context, Object... args) throws Exception {
	
		if (RequestMethod.GET.equals(context.getMethod())) {
			final String html = context.toHTML(context.getTarget(), null, null);
			
			return new Action() {
	
				@Override
				public Object execute() throws Exception {
					((HttpContext) context).getResponse().setContentType("text/html");
					return html;
				}
	
				@Override
				public void close() throws Exception {
					// NOP.					
				}
				
			};
		}
		
		return Action.NOT_FOUND;
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
