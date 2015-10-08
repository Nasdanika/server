package org.nasdanika.cdo.web.doc.extensions;

import java.net.MalformedURLException;
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
		
		int idx = content.indexOf(':');
		if (idx!=-1) {
			Resolver resolver = docRoute.getResolverRegistry(baseURL, urlPrefix).getResolver(content.substring(0, idx));
			if (resolver!=null) {
				String href = resolver.resolve(content.substring(idx+1));
				if (href!=null) {
					content = href;
				}
			}
		}
		
		try {
			URL contentURL = new URL(baseURL, content);
			String contentURLStr = contentURL.toString();
			String absDocRoutePath = urlPrefix+docRoute.getDocRoutePath();	
			if (contentURLStr.startsWith(absDocRoutePath)) {
				return docRoute.getContent(contentURL, urlPrefix, contentURLStr.substring(absDocRoutePath.length()));
			}
			return contentURL;
		} catch (MalformedURLException e) {
			return "(Include exception: "+e+")";
		}
	}

}
