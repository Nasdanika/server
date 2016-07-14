package org.nasdanika.web.routes;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.ValueAction;
import org.osgi.framework.Bundle;

/**
 * This route serves resources from bundles.
 * @author Pavel Vlasov
 *
 */
public class BundleResourceRoute implements Route {
	
	private int offset;
	
	/**
	 * Path offset for bundle name. E.g. if the route is bound to <code>bundle/.+</code> pattern, then
	 * offset is 1.
	 * @param offset
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		if (context.getMethod() == RequestMethod.GET && context.getPath().length>offset+1) {
			Bundle bundle = Platform.getBundle(context.getPath()[offset]);
			if (bundle != null) {
				URL res = bundle.getEntry(CoreUtil.join(context.getPath(), "/", offset+1));
				if (res != null) {
					return new ValueAction(res);
				}
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
