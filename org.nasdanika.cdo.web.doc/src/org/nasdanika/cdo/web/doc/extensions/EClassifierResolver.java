package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;

public class EClassifierResolver implements WikiLinkResolver {

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		int idx = spec.indexOf("@");
		String contextModelElementPath = (String) environment.get(DocRoute.CONTEXT_MODEL_ELEMENT_PATH_KEY);
		if (idx!=-1) { 
			String classifierPath = Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim()+".html";
			if (contextModelElementPath==null) {
				DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
				if (docRoute.isSessionRegistry()) {
					return docRoutePath+DocRoute.PACKAGES_SESSION_PATH+classifierPath;
				}
				if (docRoute.isGlobalRegistry()) {
					return docRoutePath+DocRoute.PACKAGES_GLOBAL_PATH+classifierPath;					
				}
			} else {
				int packagesIdx = contextModelElementPath.lastIndexOf(DocRoute.PACKAGES_SESSION_PATH);
				if (packagesIdx!=-1) {
					return contextModelElementPath.substring(0, packagesIdx+DocRoute.PACKAGES_SESSION_PATH.length())+classifierPath; 
				}
				packagesIdx = contextModelElementPath.lastIndexOf(DocRoute.PACKAGES_GLOBAL_PATH);
				if (packagesIdx!=-1) {
					return contextModelElementPath.substring(0, packagesIdx+DocRoute.PACKAGES_GLOBAL_PATH.length())+classifierPath; 
				}
			}
		}
		
//		if (contextModelElementPath==null) {
//			DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
//			if (docRoute.isSessionRegistry()) {
//				return docRoutePath+PACKAGES_SESSION+classifierPath;
//			}
//			if (docRoute.isGlobalRegistry()) {
//				return docRoutePath+PACKAGES_GLOBAL+classifierPath;					
//			}
//			return spec;
//		}
		int lastSlashIdx = contextModelElementPath.toString().lastIndexOf("/");
		return (lastSlashIdx==-1 ? spec : contextModelElementPath.toString().substring(0, lastSlashIdx+1) + spec) + ".html";		
	}

}
