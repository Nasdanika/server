package org.nasdanika.cdo.web.routes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOObjectJsExtensionRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		CDOObject cdoObject = (CDOObject) context.getTarget();
		
//		Set<CDOObject> inSession = new HashSet<>();
//		HttpServletRequest httpRequest = ((HttpContext) context).getRequest();
//		if (httpRequest.getContentType()!=null && "application/json".equals(httpRequest.getContentType())) {
//			try (Reader reader = httpRequest.getReader()) {
//				JSONObject request = new JSONObject(new JSONTokener(reader));
//				if (request.has("sessionObjects")) {
//					JSONArray sessionObjects = request.getJSONArray("sessionObjects");
//					CDOView view = cdoObject.cdoView();
//					for (int i=0; i<sessionObjects.length(); ++i) {
//						CDOObject sessionObject = view.getObject(CDOIDUtil.read(sessionObjects.getString(i)));
//						if (sessionObject!=null) {
//							inSession.add(sessionObject);
//						}
//					}
//				}
//			}
//		}
		CDOLock readLock = cdoObject.cdoReadLock();
		if (readLock.tryLock(15, TimeUnit.SECONDS)) {
			try {				
				final String moduleStr = generateModule(context, cdoObject);
				
				return new Action() {

					@Override
					public Object execute() throws Exception {
						((HttpContext) context).getResponse().setContentType("application/javascript");
						return moduleStr;
					}

					@Override
					public void close() throws Exception {
						// NOP.					
					}
					
				};
			} finally {
				readLock.unlock();
			}
		} else {			
			return Action.INTERNAL_SERVER_ERROR; // Server overloaded
		}			
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}
	
	public static class ModuleGeneratorConfig {

		/**
		 * Marks a structural feature as server-side only, i.e. suppresses generation of JavaScript code for it.
		 */
		public static final String ANNOTATION_NO_JS = "org.nasdanika.cdo:no-js";
		
		/**
		 * Instructs to load references and objects eagerly before this object. It results in
		 * fewer larger requests and simple synchronous reference properties - an array of objects.
		 */
		public static final String ANNOTATION_EAGER_OBJ = "org.nasdanika.cdo:eager-obj";
		
		/**
		 * Eagerly loads a list of object id's for a reference. Objects themselves are pre-loaded asynchronously.
		 * Reference property is an array of promises for objects. 
		 */
		public static final String ANNOTATION_EAGER_REF = "org.nasdanika.cdo:eager-ref"; 
		
		/**
		 * Lazily loads a list of object ID's. Objects are pre-loaded when reference is retrieved. 
		 * Reference property is a promise for an array of promises for objects.
		 * This is a default strategy for many references.
		 */
		public static final String ANNOTATION_LAZY_REF = "org.nasdanika.cdo:lazy-ref"; // Default for many
				
		/**
		 * Lazily loads a list of object ID's. Objects are loaded when reference is retrieved. 
		 * Reference property is a promise for an array of objects.
		 * This is a default strategy for one references.
		 */		
		public static final String ANNOTATION_LAZY_OBJ = "org.nasdanika.cdo:lazy-obj"; // Default for one
		
		/**
		 * Loads a list of object ID's and referenced objects asynchronously when the object is loaded. 
		 * Reference property is a promise for an array of promises for objects.
		 */				
		public static final String ANNOTATION_PRELOAD_REF = "org.nasdanika.cdo:preload-ref";
		
		/**
		 * Loads a list of object ID's asynchronously, referenced objects are loaded eagerly once the reference is loaded. 
		 * Reference property is a promise for an array of objects.
		 */				
		public static final String ANNOTATION_PRELOAD_OBJ = "org.nasdanika.cdo:preload-obj";
		
		private CDOObject cdoObject;
		private WebContext context;

		public ModuleGeneratorConfig(WebContext context,CDOObject cdoObject) {
			this.context = context;
			this.cdoObject = cdoObject;
		}

		public String getObjectPath() throws Exception {
			return context.getObjectPath(cdoObject);
		}

		public String getSessionPath() throws Exception {
			return context.getObjectPath(cdoObject.cdoView());
		}

		public String getId() {
			StringBuilder builder = new StringBuilder();
			CDOIDUtil.write(builder, cdoObject.cdoID());
			return builder.toString();
		}

		/**
		 * @return Referenced objects to be eagerly/synchronously loaded before given object
		 */
		public Collection<CDOObject> getEager() {
			EClass eClass = cdoObject.eClass();
			Collection<CDOObject> ret = new ArrayList<>();
			for (EReference ref: eClass.getEAllReferences()) {
				if (ref.getEAnnotation(ANNOTATION_NO_JS)==null && ref.getEAnnotation(ANNOTATION_EAGER_OBJ)!=null) {
					if (ref.isMany()) {
						@SuppressWarnings("unchecked")
						Collection<CDOObject> cc = (Collection<CDOObject>) cdoObject.eGet(ref);
						for (CDOObject candidate: cc) { 
							ret.add(candidate);
						}						
					} else {
						ret.add((CDOObject) cdoObject.eGet(ref));
					}
				}
			}
			
			// TODO Auto-generated method stub
			return ret;
		}

		public Collection<String> getDataDefinitions() throws Exception {
			// someAttr: { initialValue: 33 }       
			Collection<String> ret = new ArrayList<>(); 
			EClass eClass = cdoObject.eClass();
			for (EAttribute attr: eClass.getEAllAttributes()) {
				if (attr.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateDataDefinition(attr);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			for (EReference ref: eClass.getEAllReferences()) {
				if (ref.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateDataDefinition(ref);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			return ret;
		}
		
		private String generateDataDefinition(EAttribute attr) throws Exception {
			if (context.authorize(cdoObject, "read", attr.getName(), null)) {
				JSONObject dd = new JSONObject();
				if (cdoObject.eIsSet(attr)) {
					if (attr.isMany()) {
						JSONArray da = new JSONArray();
						dd.put("initialValue", da);
						for (Object e: (Collection<?>) cdoObject.eGet(attr)) {
							da.put(e);
						}
					} else {
						dd.put("initialValue", cdoObject.eGet(attr));
					}
				}
				return attr.getName()+": "+dd;
			}
			return null;
		}

		private String generateDataDefinition(EReference ref) throws Exception {
			if (context.authorize(cdoObject, "read", ref.getName(), null) 
					&& (ref.getEAnnotation(ANNOTATION_EAGER_OBJ)!=null || ref.getEAnnotation(ANNOTATION_EAGER_REF)!=null || !ref.isMany())
					&& ref.getEAnnotation(ANNOTATION_LAZY_OBJ)==null
					&& ref.getEAnnotation(ANNOTATION_LAZY_REF)==null) {
				
				JSONObject dd = new JSONObject();
				Object value = cdoObject.eGet(ref);
				if (value!=null) {
					if (ref.isMany()) {
						JSONArray da = new JSONArray();
						dd.put("initialValue", da);
						for (Object e: (Collection<?>) value) {
							da.put(context.getObjectPath(e)+".js");
						}
					} else {
						dd.put("initialValue", context.getObjectPath(value)+".js");
					}
				}
				return ref.getName()+": "+dd;
			}
			return null;
		}
		
		public Collection<String> getSetDeltaEntries() {
//	        if (delta.hasOwnProperty("someAttr")) {
//	            data.someAttr.oldValue = delta.someAttr;
//	        }        
//
//	        delete data.someAttr.value;

			Collection<String> ret = new ArrayList<>(); 
			EClass eClass = cdoObject.eClass();
			for (EAttribute attr: eClass.getEAllAttributes()) {
				if (attr.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateSetDeltaEntry(attr);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			for (EReference ref: eClass.getEAllReferences()) {
				if (ref.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateSetDeltaEntry(ref);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			return ret;
		}

		private String generateSetDeltaEntry(EReference ref) {
			// TODO Auto-generated method stub
			return null;
		}

		private String generateSetDeltaEntry(EAttribute attr) {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<String> getGetDeltaEntries() {

			Collection<String> ret = new ArrayList<>(); 
			EClass eClass = cdoObject.eClass();
			for (EAttribute attr: eClass.getEAllAttributes()) {
				if (attr.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateGetDeltaEntry(attr);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			for (EReference ref: eClass.getEAllReferences()) {
				if (ref.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateGetDeltaEntry(ref);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			return ret;
		}
			    
		private String generateGetDeltaEntry(EReference ref) {
			// TODO Auto-generated method stub
			return null;
		}

		private String generateGetDeltaEntry(EAttribute attr) {
			// TODO Auto-generated method stub
			return null;
		}
				
		public Collection<String> getPreloadActions() {
			Collection<String> ret = new ArrayList<>(); 
			EClass eClass = cdoObject.eClass();
			for (EReference ref: eClass.getEAllReferences()) {
				if (ref.getEAnnotation(ANNOTATION_NO_JS)==null 
						&& context.authorize(cdoObject, "read", ref.getName(), null) 
						&& (ref.getEAnnotation(ANNOTATION_PRELOAD_OBJ)!=null || ref.getEAnnotation(ANNOTATION_PRELOAD_REF)!=null)) {
					StringBuilder sb = new StringBuilder("facade."+ref.getName()+"()");
					if (ref.getEAnnotation(ANNOTATION_PRELOAD_OBJ)!=null) {
						if (ref.isMany()) {
							sb.append(".then(function(fa) { for (f in fa) { fa[f](); } }");
						}
					}
					sb.append(";");
					ret.add(sb.toString());
				}
			}
			return ret;
		}	
		
		public WebContext getContext() {
			return context;
		}

		public Collection<String> getFacadeDefinitions() throws Exception {
//
//      // Operations

			Collection<String> ret = new ArrayList<>(); 
			EClass eClass = cdoObject.eClass();
			for (EAttribute attr: eClass.getEAllAttributes()) {
				if (attr.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateFacadeDefinition(attr);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			for (EReference ref: eClass.getEAllReferences()) {
				if (ref.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateFacadeDefinition(ref);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			for (EOperation op: eClass.getEAllOperations()) {
				if (op.getEAnnotation(ANNOTATION_NO_JS)==null) {
					String dd = generateFacadeDefinition(op);
					if (dd!=null) {
						ret.add(dd);
					}
				}
			}
			return ret;
		}
		
		private static final CDOObjectModuleAttributeFacadeDefinitionGenerator CDO_OBJECT_MODULE_ATTRIBUTE_FACADE_DEFINITION_GENERATOR = new CDOObjectModuleAttributeFacadeDefinitionGenerator();

		private String generateFacadeDefinition(EAttribute attr) throws Exception {
			if (context.authorize(cdoObject, "read", attr.getName(), null)) {	
				return CDO_OBJECT_MODULE_ATTRIBUTE_FACADE_DEFINITION_GENERATOR.generate(context, cdoObject, attr);
			}
			return null;
		}
		
		private static final CDOObjectModuleEagerObjectFacadeDefinitionGenerator CDO_OBJECT_MODULE_EAGER_OBJECT_FACADE_DEFINITION_GENERATOR = new CDOObjectModuleEagerObjectFacadeDefinitionGenerator();
		private static final CDOObjectModuleEagerReferenceFacadeDefinitionGenerator CDO_OBJECT_MODULE_EAGER_REFERENCE_FACADE_DEFINITION_GENERATOR = new CDOObjectModuleEagerReferenceFacadeDefinitionGenerator();
		private static final CDOObjectModuleLazyObjectFacadeDefinitionGenerator CDO_OBJECT_MODULE_LAZY_OBJECT_FACADE_DEFINITION_GENERATOR = new CDOObjectModuleLazyObjectFacadeDefinitionGenerator();
		private static final CDOObjectModuleLazyReferenceFacadeDefinitionGenerator CDO_OBJECT_MODULE_LAZY_REFERENCE_FACADE_DEFINITION_GENERATOR = new CDOObjectModuleLazyReferenceFacadeDefinitionGenerator();

		private String generateFacadeDefinition(EReference ref) throws Exception {
			if (context.authorize(cdoObject, "read", ref.getName(), null)) {
				Generator generator = ref.isMany() ? CDO_OBJECT_MODULE_LAZY_REFERENCE_FACADE_DEFINITION_GENERATOR : CDO_OBJECT_MODULE_EAGER_REFERENCE_FACADE_DEFINITION_GENERATOR;
				if (ref.getEAnnotation(ANNOTATION_EAGER_OBJ)!=null) {
					generator = CDO_OBJECT_MODULE_EAGER_OBJECT_FACADE_DEFINITION_GENERATOR;
				} else if (ref.getEAnnotation(ANNOTATION_EAGER_REF)!=null) {
					generator = CDO_OBJECT_MODULE_EAGER_REFERENCE_FACADE_DEFINITION_GENERATOR;
				} else if (ref.getEAnnotation(ANNOTATION_LAZY_OBJ)!=null || ref.getEAnnotation(ANNOTATION_PRELOAD_OBJ)!=null) {
					generator = CDO_OBJECT_MODULE_LAZY_OBJECT_FACADE_DEFINITION_GENERATOR;
				} else if (ref.getEAnnotation(ANNOTATION_LAZY_REF)!=null || ref.getEAnnotation(ANNOTATION_PRELOAD_REF)!=null) {
					generator = CDO_OBJECT_MODULE_LAZY_REFERENCE_FACADE_DEFINITION_GENERATOR;
				}
				String ret = generator.generate(context, cdoObject, ref);
				return ret.trim().length()==0 ? null : ret;
			}
			return null;
		}

		private String generateFacadeDefinition(EOperation op) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private static final CDOObjectModuleGenerator cdoObjectModuleGenerator = new CDOObjectModuleGenerator();
	
	/**
	 * Generates RequreJS module for the target object.
	 * @param context Web context.
	 * @param inSession Objects already on the client side or objects already generated to be sent to the client side.
	 * @param cdoObject Target object.
	 * @return Generated JavaScript
	 */
	public static String generateModule(final WebContext context, CDOObject cdoObject) throws Exception {
		ModuleGeneratorConfig config = new ModuleGeneratorConfig(context, cdoObject);	
		return cdoObjectModuleGenerator.generate(config);
	}

}
