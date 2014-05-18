package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.web.CDOTransactionHttpContext;
import org.nasdanika.cdo.web.CDOViewHttpContext;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOResourceFolderHtmlExtensionRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		CDOView view;
		if (context instanceof CDOViewHttpContext) {
			view = ((CDOViewHttpContext) context).getView();
		} else if (context instanceof CDOTransactionHttpContext) {
			view = ((CDOTransactionHttpContext) context).getTransaction();
		} else {
			return Action.INTERNAL_SERVER_ERROR;
		}
		
		// GET method is assumed by the parent route for CDOView - render to HTML
		final String html = context.toHTML(view, null, null);
		
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

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

}
