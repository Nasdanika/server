package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;

public class ECoreGlobalResolver implements WikiLinkResolver {

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		int idx = spec.indexOf("@");
		if (idx==-1) {
			return docRoutePath+"/packages/global/"+Hex.encodeHexString(spec.trim().getBytes(/* UTF-8? */))+"/"+DocRoute.PACKAGE_SUMMARY_HTML;			
		}
		return docRoutePath+"/packages/global/"+Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim()+".html";
	}

}
