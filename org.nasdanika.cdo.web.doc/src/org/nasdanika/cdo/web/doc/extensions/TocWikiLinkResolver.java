package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;

import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;

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
