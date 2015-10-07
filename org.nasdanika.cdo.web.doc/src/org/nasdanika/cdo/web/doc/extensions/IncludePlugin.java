package org.nasdanika.cdo.web.doc.extensions;

import java.net.URL;

import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.Plugin;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Resolver;

public class IncludePlugin implements Plugin {

	@Override
	public Object process(String config, String content, URL baseURL, String urlPrefix, Filter filter, DocRoute docRoute) {
		if (content == null || content.trim().length()==0) {
			return null;
		}
		
//		int idx = content.indexOf(':');
//		if (idx==-1) {
//			Resolver resolver = resolverRegistry.getResolver(href.substring(0, idx));
//			if (resolver!=null) {
//				String newHref = resolver.resolve(href.substring(idx+1));
//				if (newHref!=null) {
//					href = newHref;
//				}
//			}
//		}
		
		// TODO Auto-generated method stub
		return "I'm the include plugin under testing, config: "+config+", content: "+content;
	}

}
