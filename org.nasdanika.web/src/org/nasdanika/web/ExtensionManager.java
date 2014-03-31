package org.nasdanika.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Helper class for resolving and caching extensions and references.
 * @author Pavel
 *
 */
public class ExtensionManager implements AutoCloseable {
			
	public static final String ROUTE_ID = "org.nasdanika.web.route";			
	public static final String CONVERT_ID = "org.nasdanika.web.convert";				
	private static final String SECURITY_ID = "org.nasdanika.web.security";
	
	private Converter<Object, Object> converter;
	
	public synchronized Converter<Object, Object> getConverter() throws Exception {
		if (converter==null) {
			class ConverterEntry implements Comparable<ConverterEntry> {
				
				public ConverterEntry(Converter<Object,Object> converter) {
					this.converter = converter;
				}
				
				int priority;
				
				Class<?> source;
				Class<?> target;
				
				Converter<Object, Object> converter;

				@Override
				public int compareTo(ConverterEntry o) {
					if (source.isAssignableFrom(o.source) && !o.source.isAssignableFrom(source)) {
						return 1; // o is more specific.
					}
					if (o.priority != priority) {
						return o.priority - priority;
					}
					if (target.isAssignableFrom(o.target) && !o.target.isAssignableFrom(target)) {
						return -1; // o is more specific
					}
					return 0;
				}
				
			}
			final List<ConverterEntry> ceList = new ArrayList<>();
			IConfigurationElement[] actionConfigurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(CONVERT_ID);
			for (IConfigurationElement ce: actionConfigurationElements) {
				if ("converter".equals(ce.getName())) {					
					@SuppressWarnings("unchecked")
					ConverterEntry cEntry = new ConverterEntry((Converter<Object, Object>) ce.createExecutableExtension("class"));
					
					String priorityStr = ce.getAttribute("priority");
					if (!isBlank(priorityStr)) {
						cEntry.priority = Integer.parseInt(priorityStr);
					}
					
					IContributor contributor = ce.getContributor();		
					Bundle bundle = Platform.getBundle(contributor.getName());
					cEntry.source = (Class<?>) bundle.loadClass(ce.getAttribute("source").trim());
					cEntry.target = (Class<?>) bundle.loadClass(ce.getAttribute("target").trim());
					
					ceList.add(cEntry);
				}					
			}
			
			Collections.sort(ceList);
						
			converter = new Converter<Object, Object>() {
				
				@Override
				public Object convert(Object source, Class<Object> target, Context context) throws Exception {
					if (source == null) {
						return null;
					}
					if (target.isInstance(source)) {
						return source;
					}
					for (ConverterEntry ce: ceList) {
						if (ce.source.isInstance(source) && target.isAssignableFrom(ce.target)) {
							Object ret = ce.converter.convert(source, target, context);
							if (ret!=null) {
								return ret;
							}
						}
					}
					return null;
				}
			};
		}
		
		return converter;
	}
	
	private AuthorizationProvider authorizationProvider;
	
	public synchronized AuthorizationProvider getAuthorizationProvider() throws Exception {
		if (authorizationProvider == null) {
			class AuthorizationProviderEntry implements Comparable<AuthorizationProviderEntry> {
				
				public AuthorizationProviderEntry(AuthorizationProvider sm) {
					this.sm = sm;
				}
				
				int priority;
				
				AuthorizationProvider sm;

				@Override
				public int compareTo(AuthorizationProviderEntry o) {
					return o.priority - priority;
				}
				
			}
			final List<AuthorizationProviderEntry> smeList = new ArrayList<>();
			IConfigurationElement[] actionConfigurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(SECURITY_ID);
			for (IConfigurationElement ce: actionConfigurationElements) {
				if ("security_manager".equals(ce.getName())) {					
					AuthorizationProviderEntry sme = new AuthorizationProviderEntry((AuthorizationProvider) ce.createExecutableExtension("class"));
					
					String priorityStr = ce.getAttribute("priority");
					if (!isBlank(priorityStr)) {
						sme.priority = Integer.parseInt(priorityStr);
					}
					
					smeList.add(sme);
				}					
			}
			
			Collections.sort(smeList);
			
			authorizationProvider = new AuthorizationProvider() {
				
				@Override
				public Boolean authorize(Context context, Object target, String action) {
					for (AuthorizationProviderEntry sme: smeList) {
						Boolean result = sme.sm.authorize(context, target, action);
						if (result!=null) {
							return result;
						}
					}

					return Boolean.TRUE; // Allow by default.
				}
			};
		}
		return authorizationProvider;
	}
		
	public static boolean isBlank(String str) {
		return str==null || str.trim().length()==0;
	}
		
	public static String join(String[] sa, String separator) {
		StringBuilder sb = new StringBuilder();
		for (String pe: sa) {
			if (sb.length()>0) {
				sb.append(separator);
			}
			sb.append(pe);
		}
		return sb.toString();
	}

	public RouteRegistry getRouteRegistry() {
		return routeRegistry;
	}
	
	private RouteRegistry routeRegistry = new RouteRegistry() {
		
		@Override
		public List<Route> matchObjectRoutes(RequestMethod method, Object target, String[] path) throws Exception {
			List<Route> ret = new ArrayList<Route>();
			List<RouteEntry> methodActions = getRoutes(method);
			if (methodActions!=null) {
				for (RouteEntry ma: methodActions) {
					if (!ma.isRoot() && ma.match(target, path)) {
						ret.add(ma.getRoute());
					}
				}
			}
			
			if (target instanceof Route) {
				ret.add((Route) target);
			}
			
			if (target!=null) {
				final List<Method> actionMethods = new ArrayList<>();
				Z: for (Method actionMethod: target.getClass().getMethods()) {
					ActionMethod amAnnotation = actionMethod.getAnnotation(ActionMethod.class);
					if (amAnnotation!=null) {
						for (RequestMethod requestMethod: amAnnotation.value()) {
							if (method.equals(requestMethod)) {
								actionMethods.add(actionMethod);
								continue Z;
							}
						}
					}
				}
				
				Collections.sort(actionMethods, new Comparator<Method>() {

					@Override
					public int compare(Method o1, Method o2) {
						return o2.getAnnotation(ActionMethod.class).priority() - o1.getAnnotation(ActionMethod.class).priority();
					}
					
				});				
				
				if (!actionMethods.isEmpty()) {
					ret.add(new Route() {
						
						@Override
						public Action navigate(final Context context) throws Exception {
							if (context.getPath().length==0) {
								return null;
							}
							String pathStr = join(context.getPath(), "/");
							for (final Method actionMethod: actionMethods) {
								final ActionMethod amAnnotation = actionMethod.getAnnotation(ActionMethod.class);
								if (isBlank(amAnnotation.pattern())) {
									if (!actionMethod.getName().equals(context.getPath()[0])) {
										continue;
									}
								} else {
									if (!Pattern.matches(amAnnotation.pattern(), pathStr)) {
										continue;
									}
								}
								
								return new Action() {
									
									@Override
									public Object execute() throws Exception {
										
										Class<?>[] parameterTypes = actionMethod.getParameterTypes();
										Object[] args = new Object[parameterTypes.length];
										for (int i=0; i<parameterTypes.length; ++i) {
											if (args[i]==null && parameterTypes[i].isInstance(context)) {
												args[i] = context;
												break;
											}
										}
										if (!isBlank(amAnnotation.contentType()) && context instanceof HttpContext) {
											((HttpContext) context).getResponse().setContentType(amAnnotation.contentType());
										}
										return actionMethod.invoke(context.getTarget(), args);						
									}

									@Override
									public void close() throws Exception {
										// NOP			
									}

								};
								
							}
							return null;
						}
						
					});
				}
			}
				
			return ret;
		}
		
		@Override
		public List<Route> matchRootRoutes(RequestMethod method, String[] path) throws Exception {
			List<RouteEntry> methodRoutes = getRoutes(method);
			List<Route> ret = new ArrayList<>();
			if (methodRoutes!=null) {
				for (RouteEntry re: methodRoutes) {
					if (re.isRoot() && re.match(null, path)) {
						ret.add(re.getRoute());
					}
				}
			}

			return ret;
		}

	};
			
	protected interface RouteEntry extends Comparable<RouteEntry> {
		
		boolean match(Object obj, String[] path);
		
		Route getRoute();
		
		int getPriority();
		
		boolean isRoot();
		
	}	
	
	private Map<RequestMethod, List<RouteEntry>> routeMap;

	/**
	 * Registered actions
	 * @param method
	 * @return
	 * @throws Exception
	 */
	protected synchronized List<RouteEntry> getRoutes(RequestMethod method) throws Exception {
		if (routeMap == null) {
			routeMap = new HashMap<>();

			IConfigurationElement[] actionConfigurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(ExtensionManager.ROUTE_ID);
			for (IConfigurationElement ce: actionConfigurationElements) {
				if ("object_route".equals(ce.getName())) {					
					final Route route = (Route) ce.createExecutableExtension("class");		
					injectProperties(ce, route);
					String priorityStr = ce.getAttribute("priority");
					final int priority = ExtensionManager.isBlank(priorityStr) ? 0 : Integer.parseInt(priorityStr);
					String patternStr = ce.getAttribute("pattern");					
					final Pattern pattern = isBlank(patternStr) ? null : Pattern.compile(patternStr);					
					String targetClassName = ce.getAttribute("target");
					IContributor contributor = ce.getContributor();		
					Bundle bundle = Platform.getBundle(contributor.getName());
					final Class<?> target = (Class<?>) bundle.loadClass(targetClassName.trim());
					
					RouteEntry actionEntry = new RouteEntry() {

						@Override
						public int compareTo(RouteEntry o) {
							return o.getPriority() - getPriority();
						}

						@Override
						public boolean match(Object obj, String[] path) {
							if (!target.isInstance(obj)) {
								return false;
							}
							return pattern==null ? true : pattern.matcher(ExtensionManager.join(path, "/")).matches();
						}

						@Override
						public Route getRoute() {
							return route;
						}

						@Override
						public int getPriority() {
							return priority;
						}

						@Override
						public boolean isRoot() {
							return false;
						}
					};
					
					String methodStr = ce.getAttribute("method");					
					RequestMethod[] routeMethods = "*".equals(methodStr) ? RequestMethod.values() : new RequestMethod[] {RequestMethod.valueOf(methodStr)};
					for (RequestMethod actionMethod: routeMethods) {
						List<RouteEntry> methodRoutes = routeMap.get(actionMethod);
						if (methodRoutes == null) {
							methodRoutes = new ArrayList<>();
							routeMap.put(actionMethod, methodRoutes);
						}
						methodRoutes.add(actionEntry);
					}
				} else if ("object_resource_route".equals(ce.getName())) {					
					String priorityStr = ce.getAttribute("priority");
					final int priority = ExtensionManager.isBlank(priorityStr) ? 0 : Integer.parseInt(priorityStr);
					String patternStr = ce.getAttribute("pattern");					
					final Pattern pattern = isBlank(patternStr) ? null : Pattern.compile(patternStr);					
					String targetClassName = ce.getAttribute("target");					
					IContributor contributor = ce.getContributor();		
					Bundle bundle = Platform.getBundle(contributor.getName());
					final Class<?> target = (Class<?>) bundle.loadClass(targetClassName.trim());

					final String rName = ce.getAttribute("resource");			
					final URL baseURL = bundle.getResource(rName);
					
					final String contentType = ce.getAttribute("contentType");					
					
					final Route route = new Route() {
						
						@Override
						public Action navigate(final Context context) throws Exception {
							if (context.getPath().length==1) { // 0?
								return new Action() {
									
									@Override
									public Object execute() throws Exception {
										return baseURL;
									}

									@Override
									public void close() throws Exception {
										// NOP			
									}
								};
							}
							final String subPath = join(Arrays.copyOfRange(context.getPath(), 1, context.getPath().length), "/");
							return new Action() {
								
								@Override
								public Object execute() throws Exception {
									if (!isBlank(contentType) && context instanceof HttpContext) {
										HttpServletResponse resp = ((HttpContext) context).getResponse();
										if (isBlank(resp.getContentType())) {
											resp.setContentType(contentType);
										}
									}
									return new URL(baseURL, subPath);
								}

								@Override
								public void close() throws Exception {
									// NOP			
								}
								
							};
						}
					};
					
					RouteEntry actionEntry = new RouteEntry() {

						@Override
						public int compareTo(RouteEntry o) {
							return o.getPriority() - getPriority();
						}

						@Override
						public boolean match(Object obj, String[] path) {
							if (!target.isInstance(obj)) {
								return false;
							}
							return pattern==null ? true : pattern.matcher(ExtensionManager.join(path, "/")).matches();
						}

						@Override
						public Route getRoute() {
							return route;
						}

						@Override
						public int getPriority() {
							return priority;
						}

						@Override
						public boolean isRoot() {
							return false;
						}
					};
					
					String methodStr = ce.getAttribute("method");					
					RequestMethod[] routeMethods = "*".equals(methodStr) ? RequestMethod.values() : new RequestMethod[] {RequestMethod.valueOf(methodStr)};
					for (RequestMethod actionMethod: routeMethods) {
						List<RouteEntry> methodRoutes = routeMap.get(actionMethod);
						if (methodRoutes == null) {
							methodRoutes = new ArrayList<>();
							routeMap.put(actionMethod, methodRoutes);
						}
						methodRoutes.add(actionEntry);
					}
				} else if ("root_route".equals(ce.getName())) {					
					final Route route = (Route) ce.createExecutableExtension("class");			
					injectProperties(ce, route);
					String priorityStr = ce.getAttribute("priority");
					final int priority = ExtensionManager.isBlank(priorityStr) ? 0 : Integer.parseInt(priorityStr);
					String patternStr = ce.getAttribute("pattern");					
					final Pattern pattern = isBlank(patternStr) ? null : Pattern.compile(patternStr);					
					
					RouteEntry actionEntry = new RouteEntry() {

						@Override
						public int compareTo(RouteEntry o) {
							return o.getPriority() - getPriority();
						}

						@Override
						public boolean match(Object obj, String[] path) {
							return pattern==null ? true : pattern.matcher(ExtensionManager.join(path, "/")).matches();
						}

						@Override
						public Route getRoute() {
							return route;
						}

						@Override
						public int getPriority() {
							return priority;
						}

						@Override
						public boolean isRoot() {
							return true;
						}
					};
					
					String methodStr = ce.getAttribute("method");					
					RequestMethod[] routeMethods = "*".equals(methodStr) ? RequestMethod.values() : new RequestMethod[] {RequestMethod.valueOf(methodStr)};
					for (RequestMethod actionMethod: routeMethods) {
						List<RouteEntry> methodRoutes = routeMap.get(actionMethod);
						if (methodRoutes == null) {
							methodRoutes = new ArrayList<>();
							routeMap.put(actionMethod, methodRoutes);
						}
						methodRoutes.add(actionEntry);
					}
				} else if ("root_resource_route".equals(ce.getName())) {					
					String priorityStr = ce.getAttribute("priority");
					final int priority = ExtensionManager.isBlank(priorityStr) ? 0 : Integer.parseInt(priorityStr);
					String patternStr = ce.getAttribute("pattern");					
					final Pattern pattern = isBlank(patternStr) ? null : Pattern.compile(patternStr);					
					IContributor contributor = ce.getContributor();		
					Bundle bundle = Platform.getBundle(contributor.getName());

					final String rName = ce.getAttribute("resource");			
					final URL baseURL = bundle.getResource(rName);
					
					final String contentType = ce.getAttribute("contentType");					
					
					final Route route = new Route() {
						
						@Override
						public Action navigate(final Context context) throws Exception {
							if (context.getPath().length==1) { // 0?
								return new Action() {
									
									@Override
									public Object execute() throws Exception {
										return baseURL;
									}

									@Override
									public void close() throws Exception {
										// NOP			
									}
								};
							}
							final String subPath = join(Arrays.copyOfRange(context.getPath(), 1, context.getPath().length), "/");
							return new Action() {
								
								@Override
								public Object execute() throws Exception {
									if (!isBlank(contentType) && context instanceof HttpContext) {
										HttpServletResponse resp = ((HttpContext) context).getResponse();
										if (isBlank(resp.getContentType())) {
											resp.setContentType(contentType);
										}
									}
									return new URL(baseURL, subPath);
								}

								@Override
								public void close() throws Exception {
									// NOP			
								}
								
							};
						}
					};
					
					RouteEntry actionEntry = new RouteEntry() {

						@Override
						public int compareTo(RouteEntry o) {
							return o.getPriority() - getPriority();
						}

						@Override
						public boolean match(Object obj, String[] path) {
							return pattern==null ? true : pattern.matcher(ExtensionManager.join(path, "/")).matches();
						}

						@Override
						public Route getRoute() {
							return route;
						}

						@Override
						public int getPriority() {
							return priority;
						}

						@Override
						public boolean isRoot() {
							return true;
						}
					};
					
					String methodStr = ce.getAttribute("method");					
					RequestMethod[] routeMethods = "*".equals(methodStr) ? RequestMethod.values() : new RequestMethod[] {RequestMethod.valueOf(methodStr)};
					for (RequestMethod actionMethod: routeMethods) {
						List<RouteEntry> methodRoutes = routeMap.get(actionMethod);
						if (methodRoutes == null) {
							methodRoutes = new ArrayList<>();
							routeMap.put(actionMethod, methodRoutes);
						}
						methodRoutes.add(actionEntry);
					}
				} else if ("route_provider".equals(ce.getName())) {
					RouteProvider routeProvider = (RouteProvider) ce.createExecutableExtension("class");
					injectProperties(ce, routeProvider);
					for (final RouteDescriptor routeDescriptor: routeProvider.getRouteDescriptors()) {
						final Pattern pattern = isBlank(routeDescriptor.getPattern()) ? null : Pattern.compile(routeDescriptor.getPattern()); 
						
						RouteEntry actionEntry = new RouteEntry() {

							@Override
							public int compareTo(RouteEntry o) {
								return o.getPriority() - getPriority();
							}

							@Override
							public boolean match(Object obj, String[] path) {
								if (!routeDescriptor.isRoot() && routeDescriptor.getTarget()!=null && !routeDescriptor.getTarget().isInstance(obj)) {
									return false;
								}
								return pattern==null ? true : pattern.matcher(ExtensionManager.join(path, "/")).matches();
							}

							@Override
							public Route getRoute() {
								return routeDescriptor.getRoute();
							}

							@Override
							public int getPriority() {
								return routeDescriptor.getPriority();
							}

							@Override
							public boolean isRoot() {
								return routeDescriptor.isRoot();
							}
						};
																
						for (RequestMethod actionMethod: routeDescriptor.getMethods()) {
							List<RouteEntry> methodRoutes = routeMap.get(actionMethod);
							if (methodRoutes == null) {
								methodRoutes = new ArrayList<>();
								routeMap.put(actionMethod, methodRoutes);
							}
							methodRoutes.add(actionEntry);
						}
						
					}
					
				}
			}

			for (List<RouteEntry> ame: routeMap.values()) {
				Collections.sort(ame);
			}
		}
		
		List<RouteEntry> ret = routeMap.get(method);
		return ret == null ? Collections.<RouteEntry>emptyList() : ret;
	}

	public static void injectProperties(IConfigurationElement ce, final Object target) throws IllegalAccessException, InvocationTargetException {
		for (IConfigurationElement cce: ce.getChildren()) {
			if ("property".equals(cce.getName())) {
				injectProperty(target, cce.getAttribute("name").split("\\."), cce.getAttribute("value"));
			}
		}
	}

	private static void injectProperty(Object target, String[] propertyPath, String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (propertyPath.length==1) {
			String mName = "set"+propertyPath[0].substring(0, 1).toUpperCase()+propertyPath[0].substring(1);
			for (Method mth: target.getClass().getMethods()) {
				Class<?>[] pTypes = mth.getParameterTypes();
				if (pTypes.length==1 && mth.getName().equals(mName) && pTypes[0].isAssignableFrom(String.class)) {
					mth.invoke(target, value);
					return;
				}
			}
			throw new IllegalArgumentException("Method "+mName+"(String) not found in "+target.getClass().getName());
		} else if (propertyPath.length>1) {
			String mName = "get"+propertyPath[0].substring(0, 1).toUpperCase()+propertyPath[0].substring(1);
			for (Method mth: target.getClass().getMethods()) {
				if (mth.getParameterTypes().length==0 && mth.getName().equals(mName)) {
					Object nextTarget = mth.invoke(target);
					if (nextTarget == null) {
						throw new NullPointerException("Cannot set property: "+mth+" returned null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath, 1, propertyPath.length), value);
					return;
				}
			}
			throw new IllegalArgumentException("Method "+mName+"(String) not found in "+target.getClass().getName());			
		}
	}

	@Override
	public void close() throws Exception {
		// Closing routes.
		if (routeMap!=null) {
			for (List<RouteEntry> rl: routeMap.values()) {
				for (RouteEntry r: rl) {
					if (r instanceof AutoCloseable) {
						try {
							((AutoCloseable) r).close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}	
	
}
