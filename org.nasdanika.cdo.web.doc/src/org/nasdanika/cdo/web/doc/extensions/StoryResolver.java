package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;

import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;

/**
 * Resolves story element in the form of <code>bundle-symbolic-name/path#id</code>
 * @author Pavel Vlasov
 *
 */
public class StoryResolver implements WikiLinkResolver {
	
	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
		String storyElementPath = docRoute.findStoryElement(spec);
		if (storyElementPath == null) {
			return null;
		}
		return docRoutePath+storyElementPath+"/index.html";
	}

}
