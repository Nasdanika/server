package org.nasdanika.cdo.web.doc;

import java.util.Map;

public class TocWikiLinkResolver implements WikiLinkResolver {
	
	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
		TocNode tocRoot = docRoute.getTocRoot();
		if (tocRoot==null) {
			return null;
		}
		TocNode toc = tocRoot.findByTocId(spec);
		if (toc==null) {
			return null;
		}
		return docRoutePath+toc.getHref();
	}

}
