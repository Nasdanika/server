package org.nasdanika.cdo.web.routes;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOObjectJsExtensionRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		CDOObject cdoObject = (CDOObject) context.getTarget();
		
		Set<CDOObject> inSession = new HashSet<>();
		HttpServletRequest httpRequest = ((HttpContext) context).getRequest();
		if (httpRequest.getContentType()!=null && "application/json".equals(httpRequest.getContentType())) {
			try (Reader reader = httpRequest.getReader()) {
				JSONObject request = new JSONObject(new JSONTokener(reader));
				if (request.has("sessionObjects")) {
					JSONArray sessionObjects = request.getJSONArray("sessionObjects");
					CDOView view = cdoObject.cdoView();
					for (int i=0; i<sessionObjects.length(); ++i) {
						CDOObject sessionObject = view.getObject(CDOIDUtil.read(sessionObjects.getString(i)));
						if (sessionObject!=null) {
							inSession.add(sessionObject);
						}
					}
				}
			}
		}

		final String moduleStr = generateModule(context, inSession, cdoObject);
		
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
		private Set<CDOObject> inSession;

		public ModuleGeneratorConfig(WebContext context, Set<CDOObject> inSession, CDOObject cdoObject) {
			this.context = context;
			this.inSession = inSession;
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
							if (inSession.add(candidate)) {
								ret.add(candidate);
							}
						}						
					} else {
						CDOObject candidate = (CDOObject) cdoObject.eGet(ref);
						if (inSession.add(candidate)) {
							ret.add(candidate);
						}
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
					dd.put("initialValue", cdoObject.eGet(attr));
				}
				return attr.getName()+": "+dd;
			}
			return null;
		}

		private String generateDataDefinition(EReference ref) {
			// TODO Auto-generated method stub
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

		public Collection<String> getFacadeDefinitions() {
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

		private String generateFacadeDefinition(EAttribute attr) {
			if (context.authorize(cdoObject, "read", attr.getName(), null)) {
				StringBuilder ret = new StringBuilder();
		        ret.append("get ").append(attr.getName()).append("() {").append(System.lineSeparator());
		        ret.append("        if (data.").append(attr.getName()).append(".hasOwnProperty('value')) {").append(System.lineSeparator());
		        ret.append("            return data.").append(attr.getName()).append(".value").append(System.lineSeparator());
		        ret.append("        }").append(System.lineSeparator());
		        ret.append("    if (data.").append(attr.getName()).append(".hasOwnProperty('initialValue')) {").append(System.lineSeparator());
		        ret.append("        return data.").append(attr.getName()).append(".initialValue").append(System.lineSeparator());
		        ret.append("    }").append(System.lineSeparator());
		        ret.append("    return ").append(attr.getDefaultValue()==null ? "undefined" : attr.getDefaultValueLiteral()).append(";").append(System.lineSeparator());
		        ret.append("}");
		        
		        if (attr.isChangeable() && context.authorize(cdoObject, "write", attr.getName(), null)) {
			        ret.append(",").append(System.lineSeparator());
			        ret.append("set ").append(attr.getName()).append("(newValue) {").append(System.lineSeparator());
			        ret.append("    if (data.").append(attr.getName()).append(".hasOwnProperty('initialValue')) {").append(System.lineSeparator());
			        ret.append("	    if (data.").append(attr.getName()).append(".initialValue!==newValue) {").append(System.lineSeparator());
			        ret.append("		    data.").append(attr.getName()).append(".value = newValue;").append(System.lineSeparator());
			        ret.append("		    dirty = true;").append(System.lineSeparator());
			        ret.append("    	}").append(System.lineSeparator());
			        ret.append("    } else if (newValue!==").append(attr.getDefaultValue()==null ? "undefined" : attr.getDefaultValueLiteral()).append(") {").append(System.lineSeparator());
			        ret.append("		data.").append(attr.getName()).append(".value = newValue;").append(System.lineSeparator());
			        ret.append("		dirty = true;").append(System.lineSeparator());
			        ret.append("    }").append(System.lineSeparator());
			        ret.append("}").append(System.lineSeparator());
		        	
		        }
		        ret.append(System.lineSeparator());		        
				return ret.toString();
			}
			return null;
		}

		private String generateFacadeDefinition(EReference ref) {
			// TODO Auto-generated method stub
			return null;
		}

		private String generateFacadeDefinition(EOperation op) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * Generates RequreJS module for the target object.
	 * @param context Web context.
	 * @param inSession Objects already on the client side or objects already generated to be sent to the client side.
	 * @param cdoObject Target object.
	 * @return Generated JavaScript
	 */
	public static String generateModule(final WebContext context, Set<CDOObject> inSession, CDOObject cdoObject) throws Exception {
		ModuleGeneratorConfig config = new ModuleGeneratorConfig(context, inSession, cdoObject);	
		StringBuilder ret = new StringBuilder();
		for (CDOObject eager: config.getEager()) {
			ret.append(generateModule(context, inSession, eager));
			ret.append(System.lineSeparator());
		}
		ret.append(new CDOObjectModuleRenderer().generate(config));
		return ret.toString();
	}

}
