package org.nasdanika.web;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.MethodCommand;
import org.nasdanika.core.NasdanikaException;
import org.osgi.framework.BundleContext;

/**
 * Method command which handles {@link QueryParameter}, {@link CookieParameter}, {@link BodyParameter}, and {@link PathParameter} annotated parameters.
 * @author Pavel Vlasov
 *
 * @param <C>
 * @param <R>
 */
public class WebMethodCommand<C extends HttpServletRequestContext, R> extends MethodCommand<C, R> {
	
	public static final String JSON_CONTENT_TYPE = "application/json";

	public WebMethodCommand(BundleContext bundleContext, Method method) throws Exception {
		super(bundleContext, method);
	}
	
	@Override
	protected ArgumentResolver<C> createArgumentResolver(final Class<?> parameterType, final Annotation[] parameterAnnotations) throws Exception {
		for (Annotation a: parameterAnnotations) {
			if (QueryParameter.class.isInstance(a)) {
				final QueryParameter queryParameter = (QueryParameter) a;
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] arguments) throws Exception {
						if (parameterType.isArray()) {
							Object[] values = context.getRequest().getParameterValues(queryParameter.value());
							return values==null ? queryParameter.defaultValue() : values;
						}
						
						String parameterValue = context.getRequest().getParameter(queryParameter.value());
						if (parameterValue!=null) {
							return parameterValue;
						}
						return queryParameter.defaultValue().length==0 ? null : queryParameter.defaultValue()[0];
					}
					
					@Override
					public void close() {
						// NOP						
					}
				};
			}
			if (HeaderParameter.class.isInstance(a)) {
				final HeaderParameter headerParameter = (HeaderParameter) a;
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] arguments) throws Exception {
						if (parameterType.isArray()) {
							return Collections.list(context.getRequest().getHeaders(headerParameter.value()));
						}
						
						return context.getRequest().getHeader(headerParameter.value());
					}
					
					@Override
					public void close() {
						// NOP						
					}
				};
			}
			if (PartParameter.class.isInstance(a)) {
				final PartParameter partParameter = (PartParameter) a;
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] arguments) throws Exception {
						Part part = context.getRequest().getPart(partParameter.value());
						if (parameterType.isAssignableFrom(Part.class)) {
							return part;
						}
						if (parameterType.isAssignableFrom(InputStream.class)) {
							return part==null ? null : part.getInputStream();
						}
						throw new NasdanikaException("Parameter type "+parameterType+" is not assignable from "+Part.class);
					}
					
					@Override
					public void close() {
						// NOP						
					}
				};
			}
			if (TargetParameter.class.isInstance(a)) {
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] arguments) throws Exception {
						return context.getTarget();
					}
					
					@Override
					public void close() {
						// NOP						
					}
				};
			}
			if (BodyParameter.class.isInstance(a)) {
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] arguments) throws Exception {
						return processBodyParameter(context, parameterType);
					}
					
					@Override
					public void close() {
						// NOP						
					}
				};
			}
			if (CookieParameter.class.isInstance(a)) {
				final CookieParameter cookieParameter = (CookieParameter) a;
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] arguments) throws Exception {
						List<Cookie> cookies = new ArrayList<>();
						for (Cookie cookie: context.getRequest().getCookies()) {
							if (cookieParameter.value().equals(cookie.getName())) {
								cookies.add(cookie);
							}
						}
						if (parameterType.isArray()) {
							Object ret = Array.newInstance(parameterType.getComponentType(), cookies.size());
							for (int i=0; i<cookies.size(); ++i) {
								Array.set(ret, i, parameterType.getComponentType() == Cookie.class ? cookies.get(i) : cookies.get(i).getValue());
							}
							return ret;							
						}
						
						if (cookies.isEmpty()) {
							return null;
						}
						return parameterType == Cookie.class ? cookies.get(0) : cookies.get(0).getValue(); 
					}
					
					@Override
					public void close() {
						// NOP						
					}
				};
			}
			if (PathParameter.class.isInstance(a)) {
				RouteMethod rm = method.getAnnotation(RouteMethod.class);
				if (rm==null) {
					throw new IllegalArgumentException("@PathParameter cannot be used if there is no @RouteMethod annotation on "+method);
				}
				
				String path = rm.path();
				if (CoreUtil.isBlank(path)) {
					throw new IllegalArgumentException("@PathParameter cannot be used if @RouteMethod.path attribute is blank: "+method);
				}
				
				String pathElement = "{"+((PathParameter) a).value()+"}";
				String[] pathElements = path.split("/");
				final int[] idx = {-1};				
				for (int i = 0; i<pathElements.length; ++i) {
					if (pathElement.equals(pathElements[i])) {
						idx[0] = i;
						break;
					}
				}
				
				if (idx[0] == -1) {
					throw new IllegalArgumentException("Path element "+pathElement+" specified in @PathParameter annotation not found in @RouteMethod annotation: "+method);					
				}
				
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] arguments) throws Exception {
						return context.getPath()[idx[0]];
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
	
	/**
	 * Converts request body to parameter type. This implementation delegates to the conversion framework.
	 * @param context
	 * @param parameterType
	 * @return
	 * @throws Exception
	 */
	protected Object processBodyParameter(C context, Class<?> parameterType) throws Exception {
		// Explicit JSON conversion
		if (JSON_CONTENT_TYPE.equals(context.getResponse().getContentType())) {
			if (parameterType == JSONArray.class) {
				return new JSONArray(new JSONTokener(context.getRequest().getReader()));
			}
			
			if (parameterType == JSONObject.class) {
				return new JSONObject(new JSONTokener(context.getRequest().getReader()));
			}			
		}
		
		return context.convert(context.getRequest().getInputStream(), parameterType);
	}

}
