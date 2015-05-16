package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Route;
import org.nasdanika.web.HttpServletRequestContext;

public class CDOResourceFolderHtmlExtensionRoute implements Route {

	@Override
	public Action execute(final HttpServletRequestContext context, Object... args) throws Exception {
		CDOView view;
		if (context instanceof CDOViewContext) {
			view = ((CDOViewContext<?,?>) context).getView();
		} else {
			return Action.INTERNAL_SERVER_ERROR;
		}
		
		// GET method is assumed by the parent route for CDOView - render to HTML
		final String html = context.toHTML(view, null, null);
		
		return new Action() {

			@Override
			public Object execute() throws Exception {
				((HttpServletRequestContext) context).getResponse().setContentType("text/html");
				return html;
			}

			@Override
			public void close() throws Exception {
				// NOP.					
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
