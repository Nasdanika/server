package org.nasdanika.cdo.web.doc;

import java.util.Map;

import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.pegdown.LinkRenderer.Rendering;

public class DokuWikiResolver implements WikiLinkResolver, Renderer {
	
	private String icon;
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	private String location;
	
	public void setLocation(String location) {
		this.location = location.endsWith("/") ? location : location + "/";		
	}

	@Override
	public Rendering render(String href, String content, String config, boolean isMissing) {
		if (icon!=null) {
			content = "<img src='"+icon+"'/> "+content;
		}
		Rendering ret = new Rendering(href, content);
		if (isMissing) {
			ret.withAttribute("style", "color:red;border-bottom:1px dashed");
		}
		return ret;
	}

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		return spec==null ? null : location+"doku.php?id="+spec;
	}

}
