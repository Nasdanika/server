package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;

public class EPackageResolver implements WikiLinkResolver {

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		String contextModelElementPath = (String) environment.get(DocRoute.CONTEXT_MODEL_ELEMENT_PATH_KEY);
		if (contextModelElementPath==null) {
			DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
			if (docRoute.isSessionRegistry()) {
				return docRoutePath+"/packages/session/"+Hex.encodeHexString(spec.trim().getBytes(/* UTF-8? */))+"/package-summary.html";
			}
			if (docRoute.isGlobalRegistry()) {
				return docRoutePath+"/packages/global/"+Hex.encodeHexString(spec.trim().getBytes(/* UTF-8? */))+"/package-summary.html";					
			}
			return spec;
		}
		String relativePath = "../"+Hex.encodeHexString(spec.trim().getBytes(/* UTF-8? */))+"/package-summary.html";
		return contextModelElementPath+"/"+relativePath;
	}

}
