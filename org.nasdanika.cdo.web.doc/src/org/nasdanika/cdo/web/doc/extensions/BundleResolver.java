package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;

import org.nasdanika.cdo.web.doc.WikiLinkResolver;

public class BundleResolver implements WikiLinkResolver {

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		return docRoutePath+"/bundle/"+spec.trim();
	}

}
