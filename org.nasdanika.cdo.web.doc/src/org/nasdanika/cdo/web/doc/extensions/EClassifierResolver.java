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
		if (idx==-1) {
			if (contextModelElementPath==null) {
				DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
				if (docRoute.isSessionRegistry()) {
					return docRoutePath+"/packages/session/"+Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim();
				}
				if (docRoute.isGlobalRegistry()) {
					return docRoutePath+"/packages/global/"+Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim();					
				}
				return spec;
			}
			int lastSlashIdx = contextModelElementPath.toString().lastIndexOf("/");
			return lastSlashIdx==-1 ? spec : contextModelElementPath.toString().substring(0, lastSlashIdx+1) + spec;
		}
		if (contextModelElementPath==null) {
			DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
			if (docRoute.isSessionRegistry()) {
				return docRoutePath+"/packages/session/"+Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim();
			}
			if (docRoute.isGlobalRegistry()) {
				return docRoutePath+"/packages/global/"+Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim();					
			}
		}
		String relativePath = "../"+Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim();
		return contextModelElementPath+"/"+relativePath;
	}

}