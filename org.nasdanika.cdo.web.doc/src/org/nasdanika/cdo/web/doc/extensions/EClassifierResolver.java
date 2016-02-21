package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;

public class EClassifierResolver implements WikiLinkResolver {

	private static final String PACKAGES_GLOBAL = "/packages/global/";
	private static final String PACKAGES_SESSION = "/packages/session/";

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		int idx = spec.indexOf("@");
		String contextModelElementPath = (String) environment.get(DocRoute.CONTEXT_MODEL_ELEMENT_PATH_KEY);
		String classifierPath = Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim();
		if (idx!=-1) { 
			if (contextModelElementPath==null) {
				DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
				if (docRoute.isSessionRegistry()) {
					return docRoutePath+PACKAGES_SESSION+classifierPath;
				}
				if (docRoute.isGlobalRegistry()) {
					return docRoutePath+PACKAGES_GLOBAL+classifierPath;					
				}
			} else {
				int packagesIdx = contextModelElementPath.lastIndexOf(PACKAGES_SESSION);
				if (packagesIdx!=-1) {
					return contextModelElementPath.substring(0, packagesIdx+PACKAGES_SESSION.length())+classifierPath; 
				}
				packagesIdx = contextModelElementPath.lastIndexOf(PACKAGES_GLOBAL);
				if (packagesIdx!=-1) {
					return contextModelElementPath.substring(0, packagesIdx+PACKAGES_GLOBAL.length())+classifierPath; 
				}
			}
		}
		
		if (contextModelElementPath==null) {
			DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
			if (docRoute.isSessionRegistry()) {
				return docRoutePath+PACKAGES_SESSION+classifierPath;
			}
			if (docRoute.isGlobalRegistry()) {
				return docRoutePath+PACKAGES_GLOBAL+classifierPath;					
			}
			return spec;
		}
		int lastSlashIdx = contextModelElementPath.toString().lastIndexOf("/");
		return lastSlashIdx==-1 ? spec : contextModelElementPath.toString().substring(0, lastSlashIdx+1) + spec;		
	}

}
