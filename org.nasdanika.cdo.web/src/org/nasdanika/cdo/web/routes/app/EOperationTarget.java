package org.nasdanika.cdo.web.routes.app;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.Part;

import org.apache.commons.jxpath.JXPathContext;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.AuthorizationProvider.StandardAction;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.DispatchingRoute.Target;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.WebMethodCommand;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Dispatching target invoking EOperation.
 * @author Pavel
 *
 */
public class EOperationTarget<C extends Context, T extends EObject> implements Target {
		
	private EOperation eOperation;
	private Map<String, Object> spec;
	private Map<EParameter, Object> parameterBindings;
	private Renderer<C, T> renderer;
	private BundleContext bundleContext;

	public EOperationTarget(BundleContext bundleContext, Renderer<C,T> renderer, EOperation eOperation, Map<String, Object> spec, Map<EParameter, Object> parameterBindings) {
		this.bundleContext = bundleContext;
		this.renderer = renderer;
		this.eOperation = eOperation;
		this.spec = spec;
		this.parameterBindings = parameterBindings;
	}

	@Override
	public RequestMethod[] getRequestMethods() {
		String method = (String) spec.get("method");
		return method == null ? new RequestMethod[] { RequestMethod.GET, RequestMethod.POST } : new RequestMethod[] { RequestMethod.valueOf(method) }; 
	}

	@Override
	public Pattern getPattern() {
		return null;
	}

	@Override
	public String getPath() {
		String path = (String) spec.get("path");
		return path == null ? eOperation.getName() : path;
	}

	@Override
	public String getProduces() {
		return (String) spec.get("produces");
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[] getConsumes() {
		Object consumes = spec.get("consumes");
		if (consumes instanceof String) {
			return new String[] { (String) consumes };
		}
		if (consumes instanceof Collection) {
			return ((Collection<Object>) consumes).stream().filter(e -> e instanceof String).collect(Collectors.toList()).toArray(new String[0]);			
		}
		return null;
	}

	@Override
	public String getAction() {
		String action = (String) spec.get("action");
		return action == null ? AuthorizationProvider.StandardAction.execute.name() : action;
	}

	@Override
	public String getQualifier() {
		String qualifier = (String) spec.get("qualifier");
		return qualifier == null ? eOperation.getName() : qualifier;
	}

	@Override
	public String getComment() {
		return "Invokes "+eOperation;
	}
	
	protected class Binding implements AutoCloseable {
		
		private Object value;

		public Binding(Object value) {
			this.value = value;
		}
		
		public Object getValue() {
			return value;
		}
		
		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	}

	@Override
	public Object execute(HttpServletRequestContext context, Map<String, String> pathParameters, Object[] arguments) throws Exception {
		// GET - form if there are form bindings/POST, validate, form
		
		// $arguments map and $argument for validation
		// validateEOperationArguments in Renderer
		
		EList<Binding> bindings = ECollections.newBasicEList();
		for (EParameter eParameter: eOperation.getEParameters()) {
			bindings.add(bind(context, pathParameters, eParameter));
		}
		
		
		
		// Lock
		// TODO Auto-generated method stub
		EList<Object> args = ECollections.newBasicEList();
		for (Binding binding: bindings) {
			args.add(binding.getValue());
		}
		
		String lockPath = null;
		String lockType = "imply-from-http-method";
		long lockTimeout = 60000;
		
		Object lockSpec = spec.get("lock");
		if (lockSpec instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, String> lockSpecMap = (Map<String,String>) lockSpec;
			lockPath = lockSpecMap.get("path");
			if (lockSpecMap.containsKey("type")) {
				lockType = lockSpecMap.get("type");
			}
			if (lockSpecMap.containsKey("timout")) {
				lockTimeout = Long.parseLong(lockSpecMap.get("timeout"));
			}			
		}
		
		try {
			CDOLock cdoLock = null;
			if (context.getTarget() instanceof CDOObject) {
				CDOObject lockTarget = (CDOObject) context.getTarget();
				if (!CoreUtil.isBlank(lockPath)) {
					lockTarget = (CDOObject) JXPathContext.newContext(lockTarget).getValue(lockPath);
				}
				switch (lockType) {
				case "read":
					cdoLock = lockTarget.cdoReadLock();
					break;
				case "write":
					cdoLock = lockTarget.cdoWriteLock();
					break;
				case "imply-from-http-method":
					switch (context.getMethod()) {
					case DELETE:
					case PATCH:
					case POST:
					case PUT:
						cdoLock = lockTarget.cdoWriteLock();
						break;
					default:
						cdoLock = lockTarget.cdoReadLock();							
						break;
					}
				default:
					break;					
				}
			}
			
			Object result;
			if (cdoLock == null) {
				result = ((EObject) context.getTarget()).eInvoke(eOperation, args);
			} else {
				if (cdoLock.tryLock(lockTimeout, TimeUnit.MILLISECONDS)) {
					try {
						result = ((EObject) context.getTarget()).eInvoke(eOperation, args);
					} finally {
						cdoLock.unlock();
					}						
				} else {
					return Action.SERVICE_UNAVAILABLE;
				}
			}					
			
			// TODO - result handling.
			return result; 
		} finally {
			for (Binding binding: bindings) {
				binding.close();
			}
		}
	}		

	@SuppressWarnings("unchecked")
	protected Binding bind(HttpServletRequestContext context, Map<String, String> pathParameters, EParameter eParameter) throws Exception {		
		Object binding = parameterBindings.get(eParameter);
		Class<?> parameterType = eParameter.isMany() ? EList.class : eParameter.getEType().getInstanceClass();
		if (binding == null) {
			binding = "form";
		}
		if (binding instanceof String) {
			switch ((String) binding) {
			case "body":
				if (WebMethodCommand.JSON_CONTENT_TYPE.equals(context.getRequest().getContentType())) {
					if (parameterType == JSONArray.class) {
						return new Binding(new JSONArray(new JSONTokener(context.getRequest().getReader())));
					}
					
					if (parameterType == JSONObject.class) {
						return new Binding(new JSONObject(new JSONTokener(context.getRequest().getReader())));
					}			
				}
				
				return new Binding(context.convert(context.getRequest().getInputStream(), parameterType));
			case "cookie":
			case "header":
			case "form":
			case "part":
			case "path":
			case "query":				
				binding = Collections.singletonMap((String) binding, eParameter.getName()); 
				break;
			case "null":
				return null;
			case "service":
				binding = Collections.singletonMap((String) binding, null); 
				break;				
			default:
				throw new IllegalArgumentException("Unsupported single-value parameter binding: "+binding);
			}
		} 
		
		if (binding instanceof Map) {
			for (Entry<String, Object> be: ((Map<String, Object>) binding).entrySet()) {
				switch (be.getKey()) {
				case "cookie":
					BasicEList<Object> cookieList = ECollections.newBasicEList();
					for (Cookie cookie: context.getRequest().getCookies()) {
						if (be.getValue().equals(cookie.getName())) {
							if (parameterType.isAssignableFrom(Cookie.class)) {
								if (eParameter.isMany()) {
									cookieList.add(cookie);									
								} else {
									return new Binding(cookie);
								}
							}
						} else {
							if (parameterType.isAssignableFrom(Cookie.class)) {
								if (eParameter.isMany()) {
									cookieList.add(renderer.parseTypedElementValue((C) context, eParameter, cookie.getValue()));									
								} else {
									return new Binding(renderer.parseTypedElementValue((C) context, eParameter, cookie.getValue()));
								}
							}							
						}
					}
					return new Binding(cookieList);
				case "expression":
					Object target = context.getTarget();
					if (target instanceof CDOObject) {
						JXPathContext jxPathContext = RenderUtil.newJXPathContext(context, (CDOObject) target);
						if (eParameter.isMany()) {
							BasicEList<Object> values = ECollections.newBasicEList();							
							Iterator<?> cit = jxPathContext.iterate((String) be.getValue());
							while (cit.hasNext()) {
								Object value = cit.next();
								if (!(value instanceof CDOObject) || context.authorize(value, StandardAction.read, null, null)) {
									values.add(value);
								}
							}
							return new Binding(values);
						}
						return new Binding(jxPathContext.getValue((String) be.getValue(), parameterType)); 
					}
					return null;
				case "extension":
					Map<String,String> extensionConfig = (Map<String,String>) be.getValue();
					BasicEList<Object> extensions = ECollections.newBasicEList();												
					for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor(extensionConfig.get("point"))) {
						if (extensionConfig.get("configuration-element").equals(ce.getName())) {	
							String classAttribute = extensionConfig.get("class-attribute");
							Object ev = ce.createExecutableExtension(classAttribute == null ? "class" : classAttribute);
							CoreUtil.injectProperties(ce, ev);
							if (eParameter.isMany()) {
								extensions.add(ev);
							} else {
								return new Binding(ev);
							}
						}					
					}
					return new Binding(extensions);
				case "header":
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();
						for (String str: Collections.list(context.getRequest().getHeaders((String) be.getValue()))) {
							ret.add(renderer.parseTypedElementValue((C) context, eParameter, str));
						}
						return new Binding(ret);
					}
					return new Binding(renderer.parseTypedElementValue((C) context, eParameter, context.getRequest().getHeader((String) be.getValue())));					
				case "part":
					if (!eParameter.isMany()) {
						Part part = context.getRequest().getPart((String) be.getValue());
						if (parameterType.isAssignableFrom(Part.class)) {
							return new Binding(part);
						}
						if (part == null) {
							return new Binding(part);
						}
						if (parameterType.isAssignableFrom(InputStream.class)) {
							return new Binding(part.getInputStream());
						}
						Object ret = context.convert(part.getInputStream(), parameterType);
						if (ret != null) {
							return new Binding(ret);
						}
					}
					throw new IllegalArgumentException("Parameter type "+parameterType+" is not assignable from "+Part.class);					
				case "path":
					return new Binding(pathParameters.get(be.getValue()));
				case "form":
					if (context.getMethod() != RequestMethod.POST) {
						break;
					}
				case "query":
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();
						for (String str: context.getRequest().getParameterValues((String) be.getValue())) {
							ret.add(renderer.parseTypedElementValue((C) context, eParameter, str));
						}
						return new Binding(ret);
					}
					return new Binding(renderer.parseTypedElementValue((C) context, eParameter, context.getRequest().getParameter((String) be.getValue())));
				case "service":
					Collection<ServiceReference<Object>> srs = bundleContext.getServiceReferences((Class<Object>) parameterType, (String) be.getValue());
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();
						for (ServiceReference<Object> sr: srs) {
							ret.add(bundleContext.getService(sr));
						}
						return new Binding(ret) {
							
							public void close() throws Exception {
								for (ServiceReference<Object> sr: srs) {
									bundleContext.ungetService(sr);
								}
							};
							
						};
					}
					ServiceReference<Object> sr = srs.isEmpty() ? null : srs.iterator().next();
					return new Binding(sr == null ? null : bundleContext.getService(sr)) {
						
						@Override
						public void close() throws Exception {
							if (sr != null) {
								bundleContext.ungetService(sr);
							}
						}
						
					};					
				case "value":
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();						
						if (be.getValue() instanceof Collection) {
							for (String bev: (Collection<String>) be.getValue()) {
								 ret.add(renderer.parseTypedElementValue((C) context, eParameter, bev));
							}
						} else {
							 ret.add(renderer.parseTypedElementValue((C) context, eParameter, (String) be.getValue()));
						}
						return new Binding(ret);
					}
					return new Binding(renderer.parseTypedElementValue((C) context, eParameter, (String) be.getValue()));
				default:
					throw new IllegalArgumentException("Unsupported parameter binding: "+be.getKey());
				}				
			}			
		}
		throw new IllegalArgumentException("Unsupported parameter binding type: "+binding);
	}

}
