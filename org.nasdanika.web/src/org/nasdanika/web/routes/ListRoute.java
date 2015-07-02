package org.nasdanika.web.routes;

import java.util.List;

import org.nasdanika.web.Action;
import org.nasdanika.web.Route;
import org.nasdanika.web.HttpServletRequestContext;

/**
 * Route for lists.
 * @author Pavel Vlasov
 *
 */
public class ListRoute implements Route {

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		// TODO - POST, PUT, and DELETE support
		if (context.getPath().length>1) {
			return context.getAction(((List<?>) context.getTarget()).get(Integer.parseInt(context.getPath()[1])), 1, null);
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
