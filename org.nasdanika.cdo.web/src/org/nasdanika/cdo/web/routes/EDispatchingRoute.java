package org.nasdanika.cdo.web.routes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.web.CDOIDCodec;
import org.nasdanika.cdo.xpath.CDOObjectPointerFactory;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.BodyParameter;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.MethodDispatchingRoute;
import org.nasdanika.web.RouteMethodCommand;
import org.osgi.framework.BundleContext;

/**
 * This route handles conversion between request body with content type <code>application/json</code> and {@link BodyParameter} annotated parameter(s) if its type is a subclass of {@link EObject}. If input JSON has <code>$id</code> key and 
 * there is a context {@link CDOView}, then argument is looked up in the view by id. Otherwise it is created using corresponding factory, if it is found in the global registry.
 * <P/>
 * The route also handles conversion of responses to JSON if response content type is set to <code>application/json</code> and route method return type is a subclass of {@link EObject}. 
 * Response conversion can be customized by adding {@link ResponseModel} annotation to a route method.
 * <P/>
 * Conversion of attribute values to and from JSON can be customized by overriding <code>toJSON</code> and <code>fromJSON</code> mehtods respectively.
 * @author Pavel Vlasov
 *
 */
public class EDispatchingRoute extends MethodDispatchingRoute {
		
	/**
	 * If servlet context contains {@link ReadWriteLock} under this attribute then this lock is used
	 * by getLock(). It might be useful if there is a single JVM accessing the CDO server and 
	 * all access is performed through the web ui.
	 */
	public static final String APPLICATION_LOCK_KEY = "org.nasdanika.web:application-lock";	
	
	static {
		JXPathContextReferenceImpl.addNodePointerFactory(new CDOObjectPointerFactory());
	}			

	public EDispatchingRoute(BundleContext bundleContext, Object... targets) throws Exception {
		super(bundleContext, targets);
	}

	private static final String PATH_KEY = "$path";
	private static final String TYPE_KEY = "$type";
	private static final String ID_KEY = "$id";
	
	@Override
	protected RouteMethodCommand<HttpServletRequestContext, Object> createRouteMethodCommand(BundleContext bundleContext, Method method) throws Exception {
		return new DelegatingRouteMethodCommand(bundleContext, method) {
			
			@Override
			protected Object processBodyParameter(HttpServletRequestContext context, Class<?> parameterType, Annotation[] parameterAnnotations) throws Exception {
				if (JSON_CONTENT_TYPE.equals(context.getRequest().getContentType())) {
					Map<String,String> formats = Collections.emptyMap();
					for (Annotation ann: parameterAnnotations) {
						if (ann instanceof Format) {
							formats = asMap(((Format) ann).value());
							break;
						}
					}
					Registry registry = context instanceof CDOViewContext ? ((CDOViewContext<?,?>) context).getView().getSession().getPackageRegistry() : EPackage.Registry.INSTANCE;
					if (parameterType.isArray() && EObject.class.isAssignableFrom(parameterType.getComponentType())) {
						JSONArray jsonArray = new JSONArray(new JSONTokener(context.getRequest().getReader()));
						EClassifier eClassifier = resolveModelEClassifier(registry, parameterType.getComponentType());
						if (eClassifier instanceof EClass) {
							Object ret = Array.newInstance(parameterType.getComponentType(), jsonArray.length());
							for (int i=0; i<jsonArray.length(); ++i) {
								Array.set(ret, i, convert(context, jsonArray.getJSONObject(i), (EClass) eClassifier, formats));
							}
							return ret;
						}
					} else if (EObject.class.isAssignableFrom(parameterType)) {						
//						try (Reader reader = context.getRequest().getReader()) {
//							int ch;
//							while ((ch=reader.read())!=-1) {
//								System.out.print((char) ch);
//							}
//						}
						JSONObject jsonObject = new JSONObject(new JSONTokener(context.getRequest().getReader()));
						EClassifier eClassifier = resolveModelEClassifier(registry, parameterType);
						if (eClassifier instanceof EClass) {
							return convert(context, jsonObject, (EClass) eClassifier, formats);
						}												
					}
				}
				return super.processBodyParameter(context, parameterType, parameterAnnotations);
			}
			
			@Override
			protected Object processModelParameter(HttpServletRequestContext context, Class<?> parameterType) throws Exception {				
				if (EObject.class.isAssignableFrom(parameterType) && context instanceof CDOViewContext) {
					CDOView view = ((CDOViewContext<?,?>) context).getView();
					String idParameter = context.getRequest().getParameter(ID_KEY);
					if (CoreUtil.isBlank(idParameter)) {
						CDOPackageRegistry packageRegistry = view.getSession().getPackageRegistry();										
						EClassifier eClassifier = resolveModelEClassifier(packageRegistry, parameterType);
						if (eClassifier instanceof EClass) {
							EObject model = EcoreUtil.create((EClass) eClassifier);
							inject(context, context.getRequest().getParameterMap(), model);
							return model;
						}						
					} else {
						CDOObject model = ((CDOViewContext<?,?>) context).getView().getObject(CDOIDCodec.INSTANCE.decode(context, idParameter));
						inject(context, context.getRequest().getParameterMap(), model);
						return model;						
					}					
				}
				return super.processModelParameter(context, parameterType);
			}
			
			/**
			 * Converts EObject to JSONObject.
			 */
			@Override
			public Object execute(HttpServletRequestContext context, Object target, Object[] arguments)	throws Exception {
				Object ret = super.execute(context, target, arguments);
				
				HttpServletResponse response = context.getResponse();
				if (response!=null && JSON_CONTENT_TYPE.equals(response.getContentType())) {
					ResponseModel responseModel = method.getAnnotation(ResponseModel.class);
					String[] include = responseModel==null ? new String[0] : responseModel.include();
					String[] exclude = responseModel==null ? new String[0] : responseModel.exclude();
					String[] valueReferences = responseModel==null ? new String[0] : responseModel.valueReferences();
					String[] idReferences = responseModel==null ? new String[0] : responseModel.idReferences();
					String[] pathReferences = responseModel==null ? new String[0] : responseModel.pathReferences();
					Format format = method.getAnnotation(Format.class);
					String[] formats = format == null ? new String[0] : format.value();
					
					if (ret instanceof EObject) {					
						return convert(
								context,
								(EObject) ret, 
								asSet(include), 
								asSet(exclude), 
								asSet(valueReferences), 
								asSet(idReferences), 
								asSet(pathReferences),
								asMap(formats));
					} else if (ret instanceof Collection) {
						// If all are e-objects then convert
						JSONArray ja = new JSONArray();
						for (Object re: (Collection<?>) ret) {
							if (re instanceof EObject) {
								ja.put(convert(
								context,
								(EObject) re, 
								asSet(include), 
								asSet(exclude), 
								asSet(valueReferences), 
								asSet(idReferences), 
								asSet(pathReferences),
								asMap(formats)));
							} else {
								return ret; // Not EObject element
							}
						}
						return ja;
					}					
				}
				return ret;
			}
			
		};
	}
	
	/**
	 * Uses view last update time as last modified or session creation time, whatever is the latest.
	 */
	@Override
	protected long getLastModified(HttpServletRequestContext context, Object target, Method method, Object[] arguments) throws Exception {
		if (context instanceof CDOViewContext) {
			long subjectTime = ((CDOViewContext<?,?>) context).getSubject().getTimestamp();
			long viewLastUpdateTime = ((CDOViewContext<?,?>) context).getView().getLastUpdateTime();
			return viewLastUpdateTime > subjectTime ? viewLastUpdateTime : subjectTime;
		}
		return super.getLastModified(context, target, method, arguments);
	}
	
	/**
	 * Adds ETag - timestamp and principal specific.
	 */
	@Override
	protected void preProcess(HttpServletRequestContext context, Object target, Method method, Object[] arguments) throws Exception {
		super.preProcess(context, target, method, arguments);
		if (context instanceof CDOViewContext) {
			long lastModified = getLastModified(context, target, method, arguments);
			if (lastModified != -1) {
				StringBuilder eTagBuilder = new StringBuilder(Long.toString(lastModified, Character.MAX_RADIX));
				for (Principal p: ((CDOViewContext<?,?>) context).getPrincipals()) {
					eTagBuilder.append("-").append(CDOIDCodec.INSTANCE.encode(context, p));
				}
				context.getResponse().setHeader("ETag", eTagBuilder.toString());
			}
		}
	}
	
	/**
	 * Converts array of key=value to map.
	 * @param array
	 * @return
	 */
	private Map<String, String> asMap(String[] array) {
		Map<String, String> ret = new HashMap<>();
		if (array!=null) {
			for (String s: array) {
				int idx = s.indexOf("=");
				if (idx!=-1) {
					ret.put(s.substring(0, idx), s.substring(idx+1));
				}
			}
		}
		return ret;
	}
		
	private Map<String, String> subMap(Map<String,String> map, String namespace) {
		Map<String,String> ret = new HashMap<>();
		String prefix = namespace+".";
		for (Entry<String, String> s: map.entrySet()) {
			if (s.getKey().startsWith(namespace)) {
				ret.put(s.getKey().substring(prefix.length()), s.getValue());
			}
		}
		return ret;		
	}	

	private Set<String> asSet(String[] array) {
		Set<String> ret = new HashSet<>();
		if (array!=null) {
			for (String s: array) {
				ret.add(s);
			}
		}
		return ret;
	}
	
	private Set<String> subSet(Set<String> set, String namespace) {
		Set<String> ret = new HashSet<>();
		String prefix = namespace+".";
		for (String s: set) {
			if (s.startsWith(namespace)) {
				ret.add(s.substring(prefix.length()));
			}
		}
		return ret;		
	}
	
	private enum ReferenceMode { VALUE, PATH, ID }
			
	@SuppressWarnings("unchecked")
	protected Object convert(
			final HttpServletRequestContext context,
			final EObject eObject, 
			Set<String> include, 
			Set<String> exclude, 
			Set<String> valueReferences,
			Set<String> idReferences, 
			Set<String> pathReferences,
			Map<String,String> formats) throws Exception {
		
		JSONObject ret = new JSONObject();
		for (EStructuralFeature feature: eObject.eClass().getEAllStructuralFeatures()) {
			if ((include.isEmpty() || include.contains(feature.getName())) && !exclude.contains(feature.getName())) {
				if (feature.isMany()) {
					Collection<Object> values = (Collection<Object>) eObject.eGet(feature);
					if (!values.isEmpty()) {
						JSONArray fa = new JSONArray();
						ret.put(feature.getName(), fa);
						for (Object obj: values) {
							if (feature instanceof EReference) {
								switch (referenceMode((EReference) feature, valueReferences, idReferences, pathReferences)) {
								case ID:
									StringBuilder builder = new StringBuilder();
									builder.append(CDOIDCodec.INSTANCE.encode(context, ((CDOObject) eObject).cdoID()));
									fa.put(builder.toString());								
									break;
								case PATH:
									fa.put(context.getObjectPath(obj));
									break;
								case VALUE:
									fa.put(convert(
											context, 
											(EObject) obj, 
											subSet(include, feature.getName()),
											subSet(exclude, feature.getName()),
											subSet(valueReferences, feature.getName()),
											subSet(idReferences, feature.getName()),
											subSet(pathReferences, feature.getName()),
											subMap(formats, feature.getName())));
									break;							
								}							
							} else {
								fa.put(toJSON(context, (EAttribute) feature, obj, formats.get(feature.getName()))); 
							}
						}
					}
				} else {
					Object obj = eObject.eGet(feature);
					if (obj!=null) {
						if (feature instanceof EReference) {
							switch (referenceMode((EReference) feature, valueReferences, idReferences, pathReferences)) {
							case ID:
								StringBuilder builder = new StringBuilder();
								builder.append(CDOIDCodec.INSTANCE.encode(context, ((CDOObject) eObject).cdoID()));
								ret.put(feature.getName(), builder.toString());								
								break;
							case PATH:
								ret.put(feature.getName(), context.getObjectPath(obj));
								break;
							case VALUE:
								ret.put(
										feature.getName(),
										convert(
											context, 
											(EObject) obj, 
											subSet(include, feature.getName()),
											subSet(exclude, feature.getName()),
											subSet(valueReferences, feature.getName()),
											subSet(idReferences, feature.getName()),
											subSet(pathReferences, feature.getName()),
											subMap(formats, feature.getName())));
								break;							
							}							
						} else {
							ret.put(feature.getName(), toJSON(context, (EAttribute) feature, obj, formats.get(feature.getName()))); 
						}
					}
				}
			}			
		}
		
		if (eObject instanceof CDOObject && ((CDOObject) eObject).cdoView()!=null) {
			if ((include.isEmpty() || include.contains(ID_KEY)) && !exclude.contains(ID_KEY)) {
				ret.put(ID_KEY, new Object() {
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						try {
							builder.append(CDOIDCodec.INSTANCE.encode(context, ((CDOObject) eObject).cdoID()));
						} catch (Exception e) {
							e.printStackTrace();
						}
						return builder.toString();
					}
					
				});
			}
			if ((include.isEmpty() || include.contains(PATH_KEY)) && !exclude.contains(PATH_KEY)) {
				ret.put(PATH_KEY, new Object() {
				
					@Override
					public String toString() {
						try {
							String objectPath = context.getObjectPath(eObject);
							return objectPath==null ? "" : objectPath;
						} catch (Exception e) {
							return e.toString();
						}
					}
					
				});
			}
			if ((include.isEmpty() || include.contains(TYPE_KEY)) && !exclude.contains(TYPE_KEY)) {
				JSONObject type = new JSONObject();
				EClass eClass = eObject.eClass();
				type.put("name", eClass.getName());
				type.put("nsURI", eClass.getEPackage().getNsURI());
				ret.put(TYPE_KEY, type);
			}
		}
		return ret;
	}
	
	/**
	 * Allows to customize conversion to JSON in subclasses. This implementation simply returns value attribute.
	 * @param attribute
	 * @param value
	 * @param format 
	 * @return
	 */
	protected Object toJSON(Context context, EAttribute attribute, Object value, String format) throws Exception {
		if (format == null) {
			return value;
		}
		if (value instanceof Number) {
			DecimalFormat theFormat = new DecimalFormat(format);
			return theFormat.format(value);
		}
		if (value instanceof Date) {
			SimpleDateFormat theFormat = new SimpleDateFormat(format);
			return theFormat.format(value);
		}
		
		return MessageFormat.format(format, value);		
	}
	
	/**
	 * Converts JSON value to attribute type. This implementation delegates to context.convert();
	 * Override to customize conversion from JSON.
	 * @param attribute
	 * @param value
	 * @param string 
	 * @return
	 */
	protected Object fromJSON(Context context, EAttribute attribute, Object value, String format) throws Exception {
		if (value==null) {
			return null;
		}
		
		Class<?> instanceClass = attribute.getEType().getInstanceClass();
		if (instanceClass.isPrimitive()) {
			instanceClass = CoreUtil.PRIMITIVES_TO_BOXES_MAP.get(instanceClass);
		}
		if (format != null) {
			if (Number.class.isAssignableFrom(instanceClass)) {
				DecimalFormat theFormat = new DecimalFormat(format);
				value = theFormat.parse(String.valueOf(value));
			} else if (Date.class.isAssignableFrom(instanceClass)) {
				SimpleDateFormat theFormat = new SimpleDateFormat(format);
				value = theFormat.parse(String.valueOf(value));
			} else {		
				MessageFormat theFormat = new MessageFormat(format);
				value = theFormat.parse(String.valueOf(value))[0];
			}
		}
		
		if (instanceClass!=null) {
			if (instanceClass.isInstance(value)) {
				return value;
			}
			Object convertedValue = context.convert(value, instanceClass);
			if (convertedValue == null) {
				throw new IllegalArgumentException("Cannot convert "+value+"("+value.getClass().getName()+") to "+instanceClass.getName());
			}
			return convertedValue;
		}
		return value;
	}
	
	
	/**
	 * Converts String value to attribute type. This implementation delegates to context.convert();
	 * Override to customize.
	 * @param attribute
	 * @param value
	 * @return
	 */
	protected Object fromString(Context context, EAttribute attribute, String value) throws Exception {
		if (value==null) {
			return null;
		}
		Class<?> instanceClass = attribute.getEType().getInstanceClass();
		if (instanceClass!=null) {
			if (instanceClass.isInstance(value)) {
				return value;
			}
			Object convertedValue = context.convert(value, instanceClass);
			if (convertedValue == null) {
				throw new IllegalArgumentException("Cannot convert "+value+"("+value.getClass().getName()+") to "+instanceClass.getName());
			}
			return convertedValue;
		}
		return value;
	}	
	

	protected ReferenceMode referenceMode(
			EReference reference, 
			Set<String> valueReferences, 
			Set<String> idReferences,
			Set<String> pathReferences) {
		
		ReferenceMode mode = reference.isContainment() ? ReferenceMode.VALUE : ReferenceMode.PATH;
		if (valueReferences.contains(reference.getName())) {
			mode = ReferenceMode.VALUE;
		} else if (idReferences.contains(reference.getName())) {
			mode = ReferenceMode.ID;
		} else if (pathReferences.contains(reference.getName())) {
			mode = ReferenceMode.PATH;
		}
		return mode;
	}

	/**
	 * Converts JSON object to EObject. Looks up object in a CDOView by CDOID if json object has <code>$id</code> key.
	 * @param context
	 * @param jsonObject
	 * @param eClass
	 * @param formats 
	 * @return
	 * @throws Exception
	 */
	protected EObject convert(Context context, JSONObject jsonObject, EClass eClass, Map<String, String> formats) throws Exception {		
		EObject ret;
		if (jsonObject.has(ID_KEY) && context instanceof CDOViewContext && ((CDOViewContext<?,?>) context).getView()!=null) {
			ret = ((CDOViewContext<?,?>) context).getView().getObject(CDOIDCodec.INSTANCE.decode(context, jsonObject.getString(ID_KEY)));
		} else {
			ret=  EcoreUtil.create(eClass);
		}
		for (EStructuralFeature feature: eClass.getEAllStructuralFeatures()) {
			if (jsonObject.has(feature.getName())) {
				if (feature.isMany()) {
					@SuppressWarnings("unchecked")
					Collection<Object> featureValue = (Collection<Object>) ret.eGet(feature);
					featureValue.clear();
					JSONArray ja = jsonObject.getJSONArray(feature.getName());
					for (int i=0; i<ja.length(); ++i) {
						if (feature instanceof EReference) {
							featureValue.add(convert(context, ja.getJSONObject(i), ((EReference) feature).getEReferenceType(), subMap(formats, feature.getName())));
						} else {							
							featureValue.add(fromJSON(context, (EAttribute) feature, ja.get(i), formats.get(feature.getName())));
						}
					}
				} else {
					if (feature instanceof EReference) {
						ret.eSet(feature, convert(context, jsonObject.getJSONObject(feature.getName()), ((EReference) feature).getEReferenceType(), subMap(formats, feature.getName())));
					} else {
						ret.eSet(feature, fromJSON(context, (EAttribute) feature, jsonObject.get(feature.getName()), formats.get(feature.getName())));
					}					
				}
			}			
		}
		return ret;
	}	
		
	@SuppressWarnings("unchecked")
	protected void inject(Context context, Map<String, String[]> parameterMap, EObject model) throws Exception {
		for (EStructuralFeature feature: model.eClass().getEAllStructuralFeatures()) {
			String[] values = parameterMap.get(feature.getName());
			if (values==null) {
				Map<String, String[]> subMap = new HashMap<>();
				String dotPrefix = feature.getName()+".";
				int maxSize = -1;
				for (Entry<String, String[]> e: parameterMap.entrySet()) {
					if (e.getKey().startsWith(dotPrefix)) {
						String[] value = e.getValue();
						if (value.length > maxSize) {
							maxSize = value.length;
						}
						subMap.put(e.getKey().substring(dotPrefix.length()), value);
					}					
				}
				
				if (!subMap.isEmpty() && feature instanceof EAttribute) {
					throw new IllegalArgumentException("Hierarhical parameter names are not supported for attributes: "+feature.getName()+" "+subMap);
				}				
				
				for (int i=0; i<maxSize; ++i) {
					Map<String, String[]> entryMap = new HashMap<>();
					for (Entry<String, String[]> e: subMap.entrySet()) {
						if (e.getKey().startsWith(dotPrefix)) {
							String[] value = e.getValue();
							if (i < value.length) {
								entryMap.put(e.getKey(), new String[] {value[i]});
							}
						}					
					}
					EObject subModel = EcoreUtil.create(((EReference) feature).getEReferenceType());
					inject(context, entryMap, subModel);
					if (feature.isMany()) {
						((Collection<EObject>) model.eGet(feature)).add(subModel);
					} else {
						if (i == 0) {
							model.eSet(feature, subModel);
						} else {
							throw new IllegalArgumentException("Cannot inject multi-value into a single-value reference: "+feature.getName()+" "+i+" "+entryMap);
						}
					}
				}
			} else {
				if (feature.isMany()) {
					Collection<Object> featureValue = (Collection<Object>) model.eGet(feature);
					featureValue.clear();					
					for (int i=0; i<values.length; ++i) {
						if (feature instanceof EReference) {
							// Got to be a CDOID
							CDOObject value = ((CDOViewContext<?,?>) context).getView().getObject(CDOIDCodec.INSTANCE.decode(context, values[i]));
							featureValue.add(value);
						} else {
							featureValue.add(fromString(context, (EAttribute) feature, values[i]));
						}
					}
				} else {
					if (values.length>1) {
						throw new IllegalArgumentException("Multiple values for "+feature.getName()+": "+Arrays.toString(values));
					} else if (values.length == 1) {
						if (feature instanceof EReference) {
							// Got to be a CDOID
							CDOObject value = ((CDOViewContext<?,?>) context).getView().getObject(CDOIDCodec.INSTANCE.decode(context, values[0]));
							model.eSet(feature, value);
						} else {
							model.eSet(feature, fromString(context, (EAttribute) feature, values[0]));
						}
					}
				}
			}			
		}
	}	

	/**
	 * Generates classifier links for model classes.
	 */
	@Override
	protected String markdownModelName(Class<?> modelClass) {
		if (EObject.class.isAssignableFrom(modelClass)) {
			EClassifier eClassifier = resolveModelEClassifier(EPackage.Registry.INSTANCE, modelClass);
			if (eClassifier!=null) {
				return "[[classifier>"+eClassifier.getName()+"@"+eClassifier.getEPackage().getNsURI()+"]]";
			}
		} else if (modelClass.isArray() && EObject.class.isAssignableFrom(modelClass.getComponentType())) {
			EClassifier eClassifier = resolveModelEClassifier(EPackage.Registry.INSTANCE, modelClass.getComponentType());
			if (eClassifier!=null) {
				return "[[classifier>"+eClassifier.getName()+"@"+eClassifier.getEPackage().getNsURI()+"]]";
			}			
		}
		
		return super.markdownModelName(modelClass);
	}

	
	private Map<Registry, Map<Class<?>, EClassifier>> modelTypeMap = new ConcurrentHashMap<>();
	
	/**
	 * Finds EClass by Class in the global registry.
	 * @param modelClass
	 * @return
	 */
	private EClassifier resolveModelEClassifier(Registry registry, Class<?> modelClass) {
		Map<Class<?>, EClassifier> typeMap = modelTypeMap.get(registry);
		if (typeMap == null) {
			typeMap = new ConcurrentHashMap<>();
			modelTypeMap.put(registry, typeMap);
		}
		EClassifier ret = typeMap.get(modelClass);
		if (ret==null) {
			//Registry registry = EPackage.Registry.INSTANCE;
			for (String nsURI: registry.keySet()) {			
				EPackage ePackage = registry.getEPackage(nsURI);
				for (EClassifier c: ePackage.getEClassifiers()) {
					if (c.getInstanceClass() == modelClass) {
						ret = c;
						typeMap.put(modelClass, ret);
						return ret;
					}
				}
			}
		}
		return ret;
	}

}
