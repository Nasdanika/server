package org.nasdanika.cdo.web.doc;

import java.util.Map;

public class BundleResolver implements WikiLinkResolver {

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		return docRoutePath+"/bundle/"+spec.trim();
	}

}
