package org.nasdanika.cdo.web.routes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.EAttributeClosure;
import org.nasdanika.cdo.EOperationClosure;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.ServerException;
import org.nasdanika.web.ValueAction;
import org.nasdanika.web.routes.ObjectRoute;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class EObjectRoute extends ObjectRoute {
	
	/**
	 * EObject route. Has feature, operation, resource, and code sub-routes.
	 */
	@Override
	public Action execute(final HttpServletRequestContext context, Object... args) throws Exception {
		final EObject eObject = (EObject) context.getTarget();
		String[] path = context.getPath();
		
		Z: for (EOperation op: eObject.eClass().getEAllOperations()) {						
			EAnnotation routeAnnotation = op.getEAnnotation(CDOWebUtil.ANNOTATION_HOME_ROUTE); 
			boolean isHomeRoute = routeAnnotation!=null && eObject instanceof CDOObject;
			if (!isHomeRoute) {
				routeAnnotation = op.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE);
			}
			if (routeAnnotation==null) {
				continue;
			}
			
			// Match content type to consumes
			String consumes = routeAnnotation.getDetails().get("consumes");			
			if (consumes!=null) {
				String contentType = context.getRequest().getContentType();
				if (contentType==null) {
					continue;
				}
				boolean consumeMatches = false;
				for (String consumesEntry: consumes.split(",")) {
					String contentTypeLowerCase = contentType.trim().toLowerCase();
					String ceLowerCase = consumesEntry.trim().toLowerCase();
					if (ceLowerCase.equals("*/*") || ceLowerCase.equals(contentTypeLowerCase)) {
						 consumeMatches = true;
						 break;
					 }
					 if (consumesEntry.endsWith("/*") && contentTypeLowerCase.startsWith(ceLowerCase.substring(0, ceLowerCase.length()-1))) {
						 consumeMatches = true;
						 break;						 
					 }
				}					
				
				if (!consumeMatches) {
					continue;
				}
			}
			
			// Match accept to produces
			String produces = routeAnnotation.getDetails().get("produces");			
			String accept = context.getRequest().getHeader("Accept");
			if (produces!=null && accept!=null) {
				String plc = produces.toLowerCase().trim();
				boolean producesMatches = false;
				for (String acceptEntry: accept.split(",")) {
					String acceptEntryLowerCase = acceptEntry.trim().toLowerCase();
					int idx = acceptEntryLowerCase.indexOf(";");
					if (idx!=-1) {
						acceptEntryLowerCase = acceptEntryLowerCase.substring(0, idx).trim();
					}
					// Ignoring q and level for now or forever
					if (acceptEntryLowerCase.equals("*/*") || acceptEntryLowerCase.equals(plc)) {
						 producesMatches = true;
						 break;
					 }
					 if (acceptEntryLowerCase.endsWith("/*") && plc.startsWith(acceptEntryLowerCase.substring(0, acceptEntryLowerCase.length()-1))) {
						 producesMatches = true;
						 break;						 
					 }
				}					
				
				if (!producesMatches) {
					continue;
				}
			}
			
			String methods = routeAnnotation.getDetails().get("method");
			String pathStr = routeAnnotation.getDetails().get("path");
			Map<String, Object> pathParameters = new HashMap<>();
			if (isHomeRoute) {
				if (path.length!=1) {
					continue;
				}
				if (!path[0].endsWith(".html")) {
					continue; // Home route only matches .html extension.
				}
				
				if (!path[0].equals(args[0])) {
					continue; 
				}
			} else if (pathStr==null) {
				String patternStr = routeAnnotation.getDetails().get("pattern");
				if (patternStr==null) {
					if (path.length!=2) {
						continue;
					}
					
					if (methods==null) {
						boolean isRequestMethodPrefix = false;
						String[] opCamelCase = StringUtils.splitByCharacterTypeCamelCase(op.getName());
						if (opCamelCase.length>1) {
							for (RequestMethod rm: RequestMethod.values()) {
								if (rm.name().toLowerCase().equals(opCamelCase[0])) {
									isRequestMethodPrefix = true;
									break;
								}
							}
							if (isRequestMethodPrefix) {
								if (!opCamelCase[0].equalsIgnoreCase(context.getRequest().getMethod())) {
									continue;
								}
								String opName = StringUtils.uncapitalize(op.getName().substring(opCamelCase[0].length()));
								if (!opName.equals(path[1])) {
									continue;
								}
							} else if (!op.getName().equals(path[1])) {
								continue;
							}							
						}
					} else if (!op.getName().equals(path[1])) {
						continue;
					}
				} else {
					if (!Pattern.matches(patternStr, CoreUtil.join(path, "/", 1))) {
						continue;
					}
				}
			} else {				
				String[] segments = pathStr.split("/");				
				for (int i=0; i<path.length-1; ++i) {
					if (segments.length<=i) {
						continue Z; 
					}
					String segment = segments[i].trim();
					if (segment.startsWith("{") && segment.endsWith("}")) {
						String pathParameterName = segment.substring(1, segment.length()-1).trim();
						if (i==segments.length-1) {
							if (segments.length==path.length-1) {
								pathParameters.put(pathParameterName, path[i+1]);
							} else {
								List<String> sList = new ArrayList<>();
								for (int j=i+1; j<path.length; ++j) {
									sList.add(path[j]);
								}
								pathParameters.put(pathParameterName, sList);
							}
							break;
						} else {
							pathParameters.put(pathParameterName, path[i+1]);
						}
					} else if (!path[i+1].equals(segment)) {
						continue Z;
					}
				}
			}
			
			if (methods!=null) {
				boolean methodMatch = false;
				for (String method: methods.split(",")) {
					if (context.getMethod().name().equalsIgnoreCase(method.trim())) {
						methodMatch = true;
						break;
					}
				}
				if (!methodMatch) {
					continue;
				}
			}
			
			Map<String,Object> argMap = new HashMap<>();
			List<ServiceReference<?>> toUnget = new ArrayList<>();
			EList<Object> opArgs = new BasicEList<>();
			BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
			for (EParameter p: op.getEParameters()) {
				Object arg = null;
				Class<?> parameterType = p.getEType().getInstanceClass();
				if (p.getEAnnotation(CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER)!=null) {
					arg = context.adapt(parameterType);
				} else if (p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER)!=null) {
					String serviceFilter = p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER).getDetails().get("filter");
					for (ServiceReference<?> ref: bundleContext.getServiceReferences(parameterType, serviceFilter)) {
						Object service = bundleContext.getService(ref);
						if (service!=null) {
							arg = service;
							toUnget.add(ref);
							break;
						}
					}
				} else if (p.getEAnnotation(CDOWebUtil.ANNOTATION_COOKIE_PARAMETER)!=null) {
					String cookieName = p.getEAnnotation(CDOWebUtil.ANNOTATION_COOKIE_PARAMETER).getDetails().get("name");
					List<Cookie> cookies = new ArrayList<>(); 
					for (Cookie cookie: context.getRequest().getCookies()) {
						if (CoreUtil.isBlank(cookieName) || cookieName.trim().equals(cookie.getName())) {
							cookies.add(cookie);
						}
					}
					arg = convert(context, cookies, parameterType);					
				} else if (p.getEAnnotation(CDOWebUtil.ANNOTATION_QUERY_PARAMETER)!=null) {
					EAnnotation queryParameterAnnotation = p.getEAnnotation(CDOWebUtil.ANNOTATION_QUERY_PARAMETER);
					String parameterName = queryParameterAnnotation.getDetails().get("name");
					if (CoreUtil.isBlank(parameterName)) {
						throw new ServerException("Missing parameter name in annotation", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}
					String[] pv = context.getRequest().getParameterValues(parameterName.trim());
					if (pv==null || pv.length==0) {
						arg = convert(context, queryParameterAnnotation.getDetails().get("defaultValue"), parameterType);
					} else {
						arg = convert(context, pv, parameterType);
					}
				} else if (p.getEAnnotation(CDOWebUtil.ANNOTATION_PATH_PARAMETER)!=null) {
					EAnnotation pathParameterAnnotation = p.getEAnnotation(CDOWebUtil.ANNOTATION_PATH_PARAMETER);
					String parameterName = pathParameterAnnotation.getDetails().get("name");
					if (CoreUtil.isBlank(parameterName)) {
						throw new ServerException("Missing parameter name in annotation", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}
					Object pathParameter = pathParameters.get(parameterName.trim());
					if (pathParameter==null) {
						arg = convert(context, pathParameterAnnotation.getDetails().get("defaultValue"), parameterType);
					} else {					
						arg = convert(context, pathParameter, parameterType);
					}
				} else {
					throw new ServerException("Unassigned parameter "+p.getName()+" in route operation "+op.getEContainingClass().getName()+"."+op.getName()); // More detailed message, op signature?
				}
				opArgs.add(arg);
				if (arg!=null) {
					argMap.put(p.getName(), arg);
				}
			}

			try {				
				String action = routeAnnotation.getDetails().get("action");
				if (action==null) {
					action = context.getMethod().name();
				}
				String qualifier = routeAnnotation.getDetails().get("qualifier");
				if (qualifier==null) {
					qualifier = op.getName();
				}
							
				if (!context.authorize(eObject, action, qualifier, null)) {
					return Action.FORBIDDEN;
				}
				
				if (produces!=null) {
					context.getResponse().setContentType(produces);
				}

				return new ValueAction(eObject.eInvoke(op, opArgs));
			} finally {
				for (ServiceReference<?> sr: toUnget) {
					bundleContext.ungetService(sr);
				}													
			}
		}		
										
		if (path.length>=2 && ("container".equals(path[1]) || path[1].startsWith("container.")) ) {
			return context.getAction(eObject.eContainer(), 1, null);
		}
		
		if (path.length>2) {
			switch (path[1]) {			
			case "feature":
				String featureName = path[2];
				int idx = featureName.lastIndexOf('.');
				if (idx!=-1) {
					featureName = featureName.substring(0, idx);
				}
		
				EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
				if (feature instanceof EReference) {
					return context.getAction(new EReferenceClosure<EObject>(eObject, (EReference) feature), 2, null);
				}
				if (feature instanceof EAttribute) {
					return context.getAction(new EAttributeClosure<EObject>(eObject, (EAttribute) feature), 2, null);
				}
				return Action.NOT_FOUND;
			case "operation":
				String operationName = path[2];
				for (EOperation op: eObject.eClass().getEAllOperations()) {
					if (operationName.equals(op.getName()) && op.getEParameters().size()<=path.length-3) {
						return context.getAction(new EOperationClosure<EObject>(eObject, op), 2, null);
					}
				}
				return Action.NOT_FOUND;
			}			
		}
		return super.execute(context);
	}

	private Object convert(HttpServletRequestContext context, Object obj, Class<?> target) throws Exception {
		if (obj==null) {
			return null;
		}
		if (target.isInstance(obj)) {
			return obj;
		}
		// Array, list, singleton manipulations first, delegation to context next
		if (target.isAssignableFrom(List.class)) {
			return Collections.singletonList(obj);
		}
		if (target.isArray()) {
			Object ret = Array.newInstance(target.getComponentType(), 1);
			Array.set(ret, 0, context.convert(obj, target.getComponentType()));
			return ret;
		}
		if (obj instanceof Collection && ((Collection<?>) obj).size()==1) {
			return context.convert(((Collection<?>) obj).iterator().next(), target);
		}
		if (obj.getClass().isArray() && Array.getLength(obj)==1) {
			return context.convert(Array.get(obj, 0), target);
		}
		
		Object ret = context.convert(obj, target);
		if (ret==null) {
			throw new IllegalArgumentException("Cannot convert "+obj+" to "+target);
		}
		return ret;
	}

}
