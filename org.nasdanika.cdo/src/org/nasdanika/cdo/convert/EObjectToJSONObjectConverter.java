package org.nasdanika.cdo.convert;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.core.Converter;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.WebContext;

public class EObjectToJSONObjectConverter implements Converter<EObject, JSONObject, WebContext> {
	
	private static final String REF_KEY = "$ref";
	private static final String REF_ID_KEY = "$refID";
	private static final String CDO_ID_KEY = "$cdoID";
	private static final String META_KEY = "$meta";

	@Override
	public JSONObject convert(EObject source, Class<JSONObject> target,	WebContext context) throws Exception {
		int depth = 0;
		if (context instanceof HttpContext) {
			String depthPrm = ((HttpContext) context).getRequest().getParameter("depth");
			if (depthPrm != null) {
				depth = Integer.parseInt(depthPrm);
			}
		}		
		return toJSON(source, depth, context, "", new IdentityHashMap<Object, String>());
	}

	@SuppressWarnings("unchecked")
	public JSONObject toJSON(
			EObject obj, 
			int depth, 
			WebContext context, 
			String path, 
			Map<Object, String> pathMap) throws Exception {
		
		EObject eObj = (EObject) obj;
		String ref = pathMap.get(eObj);
		JSONObject jsonObject = new JSONObject();
		if (ref==null) {
			pathMap.put(eObj, path);
			if (eObj instanceof CDOObject) {
				CDOID id = ((CDOObject) eObj).cdoID();
				StringBuilder idBuilder = new StringBuilder();
				CDOIDUtil.write(idBuilder, id);
				jsonObject.put(CDO_ID_KEY, idBuilder.toString());
			}
			if (context.authorize(obj, "meta", null, null)) {
				JSONObject meta = new JSONObject();
				meta.put("namespace", eObj.eClass().getEPackage().getNsURI());
				meta.put("class", eObj.eClass().getName());
				if (depth==0) {
					EList<EReference> allRefs = eObj.eClass().getEAllReferences();
					if (!allRefs.isEmpty()) {
						JSONObject jRefs = new JSONObject();
						for (EReference r: allRefs) {
							JSONObject rInfo = new JSONObject();
							rInfo.put("many", r.isMany());
							rInfo.put("containment", r.isContainment());
							jRefs.put(r.getName(), rInfo);
						}
						meta.put("references", jRefs);
					}
				}
				if (obj.eContainer()!=null) {
					CDOID id = ((CDOObject) eObj.eContainer()).cdoID();
					StringBuilder idBuilder = new StringBuilder();
					CDOIDUtil.write(idBuilder, id);
					meta.put("container", idBuilder.toString());
					meta.put("containingFeature", obj.eContainingFeature().getName());
				}
				jsonObject.put(META_KEY, meta);
			}
			
			// Attributes
			for (EAttribute attr: eObj.eClass().getEAllAttributes()) {
				if (context.authorize(obj, "read", attr.getName(), null)) {
					Object val = ((EObject) obj).eGet(attr);
					if (val!=null) {
						Object jVal = context.convert(val, JSONObject.class);
						if (jVal==null) {
							jVal = context.convert(val, JSONArray.class);
						} 
						if (jVal!=null) {
							jsonObject.put(attr.getName(), jVal);
						}
					}
				}
			}
			
			// References, depth. - containment first.
			if (depth!=0) {
				for (EReference rf: eObj.eClass().getEAllContainments()) {
					if (context.authorize(obj, "read", rf.getName(), null)) {
						if (rf.isMany()) {
							JSONArray output = new JSONArray();
							for (Object val: (Collection<Object>) eObj.eGet(rf)) {
								output.put(toJSON((EObject) val, depth-1, context, path+"/"+rf.getName()+"["+output.length()+"]", pathMap));
							}		
							jsonObject.put(rf.getName(), output);
						} else {
							Object val = eObj.eGet(rf);
							if (val!=null) {
								jsonObject.put(rf.getName(), toJSON((EObject) val, depth-1, context, path+"/"+rf.getName(), pathMap));
							}
						}
					}
				}
				
				for (EReference rf: eObj.eClass().getEAllReferences()) {
					if (!rf.isContainment()) {
						if (context.authorize(obj, "read", rf.getName(), null)) {
							if (rf.isMany()) {
								JSONArray output = new JSONArray();
								for (Object val: (Collection<Object>) eObj.eGet(rf)) {
									output.put(toJSON((EObject) val, depth-1, context, path+"/"+rf.getName()+"["+output.length()+"]", pathMap));
								}		
								jsonObject.put(rf.getName(), output);
							} else {
								Object val = eObj.eGet(rf);
								if (val!=null) {
									jsonObject.put(rf.getName(), toJSON((EObject) val, depth-1, context, path+"/"+rf.getName(), pathMap));
								}
							}
						}
					}
				}
			}
		} else {
			String fragment = eObj.eResource().getURIFragment(eObj);
			if (fragment!=null) {
				jsonObject.put(REF_ID_KEY, fragment);				
			} else {
				jsonObject.put(REF_KEY, ref);
			}				
		}
		
		return jsonObject;
	}

	@Override
	public void close() throws Exception {
		// NOP		
	}

}
