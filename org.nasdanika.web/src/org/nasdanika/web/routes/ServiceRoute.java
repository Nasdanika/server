package org.nasdanika.web.routes;

import org.nasdanika.web.Action;
import org.nasdanika.web.Route;
import org.nasdanika.web.HttpServletRequestContext;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * This root route looks up OSGi service given in the first path element with a filter
 * provided in the second path element (use 'null' for no filter)
 * @author Pavel Vlasov
 *
 */
public class ServiceRoute implements Route {
	
	private int offset;
	
	/**
	 * Path offset for service type. E.g. if the route is bound to <code>services/.+</code> pattern, then
	 * offset is 1.
	 * @param offset
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		if (context.getPath().length>offset+1) {
			final BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
			String filter = "null".equals(context.getPath()[offset+1]) ? null : context.getPath()[offset+1];
			ServiceReference<?>[] refs = bundleContext.getServiceReferences(context.getPath()[offset], filter);
			if (refs!=null) {
				for (final ServiceReference<?> ref: refs) {
					final Object service = bundleContext.getService(ref);
					if (service!=null) {
						final Action serviceAction = context.getAction(service, offset+1);
						if (serviceAction!=null) {
							return new Action() {
	
								@Override
								public void close() throws Exception {
									bundleContext.ungetService(ref);									
								}
	
								@Override
								public Object execute() throws Exception {									
									return serviceAction.execute();
								}
								
							};
						}
						bundleContext.ungetService(ref);
					}
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
