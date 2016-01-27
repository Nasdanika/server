package org.nasdanika.web;

/**
 * Dispatches requests to target's methods with {@link RouteMethod} annotation.
 * @author Pavel Vlasov
 *
 */
public class DispatchingRoute implements Route {
	
	private Object target;
	
	public DispatchingRoute(Object target) {
		this.target = target;
	}
	
	/**
	 * Dispatches to self 
	 */
	protected DispatchingRoute() {
		this.target = this;
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canExecute() {
		return target!=null;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
	
	// TODO

}
