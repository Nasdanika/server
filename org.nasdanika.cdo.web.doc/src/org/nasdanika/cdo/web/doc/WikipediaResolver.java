package org.nasdanika.cdo.web.doc;

import java.util.Map;

import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.pegdown.LinkRenderer.Rendering;

public class WikipediaResolver implements WikiLinkResolver, Renderer {

	@Override
	public Rendering render(String href, String content, String config, boolean isMissing) {
		Rendering ret = new Rendering(href, "<i class=\"fa fa-wikipedia-w\"></i> "+content);
		if (isMissing) {
			ret.withAttribute("style", "color:red;border-bottom:1px dashed");
		}
		return ret;
	}

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		return spec==null ? null : "https://en.wikipedia.org/wiki/"+spec.replace(' ', '_');
	}

}
