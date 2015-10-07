package org.nasdanika.cdo.web.doc.extensions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor;

import org.pegdown.LinkRenderer.Rendering;

public class LightboxWikiLinkRenderer implements WikiLinkProcessor.Renderer {
	
	private AtomicInteger counter = new AtomicInteger();
	private Map<String, String> idMap = new ConcurrentHashMap<>();

	@Override
	public Rendering render(
			String href, 
			String content, 
			String config,
			boolean isMissing) {
		Rendering ret = new Rendering(href, "<span class=\"glyphicon glyphicon-picture\"></span> "+content);
		ret.withAttribute("data-title", content);
		String id = idMap.get(href);
		if (id==null) {
			id = "image-"+Integer.toString(counter.incrementAndGet(), Character.MAX_RADIX);
			idMap.put(href, id);
		}
		ret.withAttribute("data-lightbox", id);
		if (isMissing) {
			ret.withAttribute("style", "color:red;border-bottom:1px dashed");
		}
		return ret;
	}

}
