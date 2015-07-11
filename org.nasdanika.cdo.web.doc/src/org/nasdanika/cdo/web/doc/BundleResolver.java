package org.nasdanika.cdo.web.doc;

public class BundleResolver implements WikiLinkResolver {

	@Override
	public String resolve(String spec, String docRoutePath) {
		return docRoutePath+"/bundle/"+spec.trim();
	}

}
