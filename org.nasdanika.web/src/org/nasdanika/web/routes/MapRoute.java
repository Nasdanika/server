package org.nasdanika.web.routes;

import java.util.Map;

import org.nasdanika.web.Action;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

/**
 * Route for maps with string keys.
 * @author Pavel Vlasov
 *
 */
public class MapRoute implements Route {

	@Override
	public Action execute(WebContext context, Object... args) throws Exception {
		// TODO - POST and DELETE support
		if (context.getPath().length>1) {
			Object val = ((Map<?,?>) context.getTarget()).get(context.getPath()[1]);
			if (val!=null) {
				return context.getAction(val, 1);
			}
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
