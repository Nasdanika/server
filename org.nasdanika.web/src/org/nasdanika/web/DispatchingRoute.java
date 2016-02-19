package org.nasdanika.web;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.routes.ObjectRoute;
import org.osgi.framework.BundleContext;

/**
 * Dispatches requests to target's methods with {@link RouteMethod} annotation.
 * @author Pavel Vlasov
 *
 */
public class DispatchingRoute implements Route {
	
	private Object target;
	private List<WebMethodCommand<HttpServletRequestContext, Object>> webMethodCommands = new ArrayList<>();
	
	private Object getTarget() {
		return target==null ? this : target;
	}
	
	public DispatchingRoute(BundleContext bundleContext, Object target) throws Exception {
		this.target = target;
		for (Method method: (target==null ? getClass() : target.getClass()).getMethods()) {
			final RouteMethod routeMethod = method.getAnnotation(RouteMethod.class);
			if (routeMethod!=null) {
				webMethodCommands.add(new WebMethodCommand<HttpServletRequestContext, Object>(bundleContext, method) {
					
					@Override
					protected ArgumentResolver<HttpServletRequestContext> createArgumentResolver(final Class<?> parameterType, Annotation[] parameterAnnotations) throws Exception {
						
						// A trick to shift context passed as a method argument and still be able to get access to path parameters.
						for (Annotation a: parameterAnnotations) {
							// Context parameter
							if (ContextParameter.class.isInstance(a) && !CoreUtil.isBlank(routeMethod.path())) {
								return new ArgumentResolver<HttpServletRequestContext>() {
									
									@Override
									public Object getValue(HttpServletRequestContext context, Object[] args) throws Exception {
										HttpServletRequestContext shiftedContext = context.shift(routeMethod.path().split("/").length);
										if (parameterType.isInstance(shiftedContext)) {
											return shiftedContext;
										}
										
										return shiftedContext.adapt(parameterType);
									}
									
									@Override
									public void close() {
										// NOP						
									}
								};
							}
						}						
						return super.createArgumentResolver(parameterType, parameterAnnotations);
					}
					
				});
			}
		}
		
		Collections.sort(webMethodCommands, new Comparator<WebMethodCommand<HttpServletRequestContext, Object>>() {

			@Override
			public int compare(WebMethodCommand<HttpServletRequestContext, Object> o1, WebMethodCommand<HttpServletRequestContext, Object> o2) {
				RouteMethod rm1 = o1.getMethod().getAnnotation(RouteMethod.class);
				RouteMethod rm2 = o2.getMethod().getAnnotation(RouteMethod.class);
				
				// The route with higher priority takes precedence.
				int cmp = rm2.priority() - rm1.priority();
				if (cmp!=0) {
					return cmp;
				}
				
				// If priorities are equal, then route defined in a sub-class or a class with shortest inheritance distance to the context model element’s EClass takes precedence.
				Class<?> dc1 = o1.getMethod().getDeclaringClass();
				Class<?> dc2 = o2.getMethod().getDeclaringClass();
				if (dc1!=dc2) {
					return dc1.isAssignableFrom(dc2) ? 1 : -1;
				}
				
				// If the routes have the same inheritance distance then a route with path takes precedence over a route with pattern.
				if (!CoreUtil.isBlank(rm1.path())) {
					if (CoreUtil.isBlank(rm2.path())) {
						return -1; 
					}
				}
				
				if (!CoreUtil.isBlank(rm2.path())) {
					if (CoreUtil.isBlank(rm1.path())) {
						return 1; 
					}
				}
				
				// A route with the longest path/pattern takes precedence over the other if both use path or pattern.				
				String p1 = CoreUtil.isBlank(rm1.path()) ? rm1.pattern() : rm1.path();
				String p2 = CoreUtil.isBlank(rm2.path()) ? rm2.pattern() : rm2.path();
				cmp = p2.length() - p1.length();
				if (cmp!=0) {
					return cmp;
				}
				
				return o1.hashCode() - o2.hashCode();
			}
		});
		
	}
	
	/**
	 * Dispatches to self 
	 * @throws Exception 
	 */
	protected DispatchingRoute(BundleContext bundleContext) throws Exception {
		this(bundleContext, null);
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		String[] path = context.getPath();
		W: for (WebMethodCommand<HttpServletRequestContext, Object> webMethodCommand: webMethodCommands) {
			RouteMethod routeMethod = webMethodCommand.getMethod().getAnnotation(RouteMethod.class);
			
			RequestMethod[] methods = routeMethod.value();
			if (methods.length>0) {
				boolean methodMatch = false;
				for (RequestMethod method: methods) {
					if (context.getMethod().equals(method)) {
						methodMatch = true;
						break;
					}
				}
				if (!methodMatch) {
					continue;
				}
			}
			
			if (!ObjectRoute.matchProduces(context, routeMethod.produces())) {
				continue;
			}
			
			if (!ObjectRoute.matchConsumes(context, routeMethod.consumes())) {
				continue;
			}
			
			String routePath = routeMethod.path();
			if (!CoreUtil.isBlank(routePath)) {
				String[] splitRoutePath = routePath.split("/");
				if (routePath.endsWith("/")) {
					if (splitRoutePath.length>=path.length) {
						continue;
					}
				} else {
					if (splitRoutePath.length!=path.length) {
						continue;
					}
				}
				
				for (int i=0; i<splitRoutePath.length; ++i) {
					boolean isPathParameter = splitRoutePath[i].startsWith("{") && splitRoutePath[i].endsWith("}");
					if (!isPathParameter && !splitRoutePath[i].equals(path[i])) {
						continue W;
					}
				}
				
				if (context.authorize(target, routeMethod.action().length()==0 ? context.getMethod().name() : routeMethod.action(), routeMethod.qualifier(), null)) {
					Object result = webMethodCommand.execute(context, getTarget(), args);
					if (result==null && webMethodCommand.getMethod().getReturnType() == void.class) {
						return Action.NOP;				
					}
					return ValueAction.wrap(result);
				}
				
				return Action.FORBIDDEN;
			} else if (path.length > 1) {			
				String routePattern = routeMethod.pattern();			
				if (!CoreUtil.isBlank(routePattern) && Pattern.matches(routePattern, CoreUtil.join(path, "/"))) {
					if (context.authorize(target, routeMethod.action().length()==0 ? context.getMethod().name() : routeMethod.action(), routeMethod.qualifier(), null)) {
						Object result = webMethodCommand.execute(context, getTarget(), args);
						if (result==null && webMethodCommand.getMethod().getReturnType() == void.class) {
							return Action.NOP;				
						}
						return ValueAction.wrap(result);
					}
					
					return Action.FORBIDDEN;
				}				
			}						
		}		
		return Action.NOT_FOUND;
	}

	@Override
	public boolean canExecute() {
		return target!=null;
	}

	@Override
	public void close() throws Exception {
		for (WebMethodCommand<HttpServletRequestContext, Object> wmc: webMethodCommands) {
			wmc.close();
		}
	}

}
