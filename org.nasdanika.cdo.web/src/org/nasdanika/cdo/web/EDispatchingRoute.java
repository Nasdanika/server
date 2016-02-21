package org.nasdanika.cdo.web;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.web.BodyParameter;
import org.nasdanika.web.DispatchingRoute;
import org.nasdanika.web.HttpServletRequestContext;
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
public class EDispatchingRoute extends DispatchingRoute {

	private static final String PATH_KEY = "$path";
	private static final String ID_KEY = "$id";

	protected EDispatchingRoute(BundleContext bundleContext) throws Exception {
		super(bundleContext);
	}

	@Override
	protected RouteMethodCommand<HttpServletRequestContext, Object> createRouteMethodCommand(BundleContext bundleContext, Method method) throws Exception {
		return new RouteMethodCommand<HttpServletRequestContext, Object>(bundleContext, method) {

			@Override
			protected Object processBodyParameter(HttpServletRequestContext context, Class<?> parameterType) throws Exception {
				if (JSON_CONTENT_TYPE.equals(context.getRequest().getContentType())) {
					if (parameterType.isArray() && EObject.class.isAssignableFrom(parameterType.getComponentType())) {
						JSONArray jsonArray = new JSONArray(new JSONTokener(context.getRequest().getReader()));
						EClassifier eClassifier = resolveModelEClass(parameterType.getComponentType());
						if (eClassifier instanceof EClass) {
							Object ret = Array.newInstance(parameterType.getComponentType(), jsonArray.length());
							for (int i=0; i<jsonArray.length(); ++i) {
								Array.set(ret, i, convert(context, jsonArray.getJSONObject(i), (EClass) eClassifier));
							}
							return ret;
						}
					} else if (EObject.class.isAssignableFrom(parameterType)) {						
						JSONObject jsonObject = new JSONObject(new JSONTokener(context.getRequest().getReader()));
						EClassifier eClassifier = resolveModelEClass(parameterType);
						if (eClassifier instanceof EClass) {
							return convert(context, jsonObject, (EClass) eClassifier);
						}												
					}
				}
				return super.processBodyParameter(context, parameterType);
			}

			/**
			 * Converts EObject to JSONObject.
			 */
			@Override
			public Object execute(HttpServletRequestContext context, Object target, Object[] arguments)	throws Exception {
				Object ret = super.execute(context, target, arguments);
				if (JSON_CONTENT_TYPE.equals(context.getResponse().getContentType()) && ret instanceof EObject) {
					ResponseModel responseModel = method.getAnnotation(ResponseModel.class);
					String[] include = responseModel==null ? new String[0] : responseModel.include();
					String[] exclude = responseModel==null ? new String[0] : responseModel.exclude();
					String[] valueReferences = responseModel==null ? new String[0] : responseModel.valueReferences();
					String[] idReferences = responseModel==null ? new String[0] : responseModel.idReferences();
					String[] pathReferences = responseModel==null ? new String[0] : responseModel.pathReferences();
					
					return convert(
							context,
							(EObject) ret, 
							asSet(include), 
							asSet(exclude), 
							asSet(valueReferences), 
							asSet(idReferences), 
							asSet(pathReferences));
				}
				return ret;
			}
			
		};
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
			HttpServletRequestContext context,
			EObject eObject, 
			Set<String> include, 
			Set<String> exclude, 
			Set<String> valueReferences,
			Set<String> idReferences, 
			Set<String> pathReferences) throws Exception {
		
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
									CDOIDUtil.write(builder, ((CDOObject) eObject).cdoID());
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
											subSet(pathReferences, feature.getName())));
									break;							
								}							
							} else {
								fa.put(toJSON((EAttribute) feature, obj)); 
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
								CDOIDUtil.write(builder, ((CDOObject) eObject).cdoID());
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
											subSet(pathReferences, feature.getName())));
								break;							
							}							
						} else {
							ret.put(feature.getName(), toJSON((EAttribute) feature, obj)); 
						}
					}
				}
			}			
		}
		
		if (eObject instanceof CDOObject && ((CDOObject) eObject).cdoView()!=null) {
			if ((include.isEmpty() || include.contains(ID_KEY)) && !exclude.contains(ID_KEY)) {
				StringBuilder builder = new StringBuilder();
				CDOIDUtil.write(builder, ((CDOObject) eObject).cdoID());
				ret.put(ID_KEY, builder.toString());
			}
			if ((include.isEmpty() || include.contains(PATH_KEY)) && !exclude.contains(PATH_KEY)) {
				String objectPath = context.getObjectPath(eObject);
				if (objectPath!=null) {
					ret.put(PATH_KEY, objectPath);
				}
			}
		}
		return ret;
	}
	
	/**
	 * Allows to customize conversion to JSON in subclasses.
	 * @param attribute
	 * @param value
	 * @return
	 */
	protected Object toJSON(EAttribute attribute, Object value) throws Exception {
		return value;
	}
	
	/**
	 * Allows to customize conversion from JSON in subclasses.
	 * @param attribute
	 * @param value
	 * @return
	 */
	protected Object fromJSON(EAttribute attribute, Object value) throws Exception {
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
	 * @return
	 * @throws Exception
	 */
	protected EObject convert(HttpServletRequestContext context, JSONObject jsonObject, EClass eClass) throws Exception {		
		EObject ret;
		if (jsonObject.has(ID_KEY) && context instanceof CDOViewHttpServletRequestContext && ((CDOViewHttpServletRequestContext<?>) context).getView()!=null) {
			ret = ((CDOViewHttpServletRequestContext<?>) context).getView().getObject(CDOIDUtil.read(jsonObject.getString(ID_KEY)));
		} else {
			ret= eClass.getEPackage().getEFactoryInstance().create(eClass);
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
							featureValue.add(convert(context, ja.getJSONObject(i), ((EReference) feature).getEReferenceType()));
						} else {
							featureValue.add(fromJSON((EAttribute) feature, ja.get(i)));
						}
					}
				} else {
					if (feature instanceof EReference) {
						ret.eSet(feature, convert(context, jsonObject.getJSONObject(feature.getName()), ((EReference) feature).getEReferenceType()));
					} else {
						ret.eSet(feature, fromJSON((EAttribute) feature, jsonObject.get(feature.getName())));
					}					
				}
			}			
		}
		return ret;
	}		

	/**
	 * Generates classifier links for model classes.
	 */
	@Override
	protected String markdownModelName(Class<?> modelClass) {
		if (EObject.class.isAssignableFrom(modelClass)) {
			EClassifier eClassifier = resolveModelEClass(modelClass);
			if (eClassifier!=null) {
				return "[[classifier>"+eClassifier.getName()+"@"+eClassifier.getEPackage().getNsURI()+"]]";
			}
		} else if (modelClass.isArray() && EObject.class.isAssignableFrom(modelClass.getComponentType())) {
			EClassifier eClassifier = resolveModelEClass(modelClass.getComponentType());
			if (eClassifier!=null) {
				return "[[classifier>"+eClassifier.getName()+"@"+eClassifier.getEPackage().getNsURI()+"]]";
			}			
		}
		
		return super.markdownModelName(modelClass);
	}
	
	/**
	 * Finds EClass by Class in the global registry.
	 * @param modelClass
	 * @return
	 */
	private EClassifier resolveModelEClass(Class<?> modelClass) {
		Registry registry = EPackage.Registry.INSTANCE;
		for (String nsURI: registry.keySet()) {			
			EPackage ePackage = registry.getEPackage(nsURI);
			for (EClassifier c: ePackage.getEClassifiers()) {
				if (c.getInstanceClass() == modelClass) {
					return c;
				}
			}
		}
		return null;
	}
	

}
