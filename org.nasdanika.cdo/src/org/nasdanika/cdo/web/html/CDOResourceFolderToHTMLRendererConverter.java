package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.nasdanika.core.Converter;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class CDOResourceFolderToHTMLRendererConverter implements Converter<CDOResourceFolder, HTMLRenderer, WebContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(
			final CDOResourceFolder source, 
			Class<HTMLRenderer> target,
			WebContext context) throws Exception {
		
		return new HTMLRenderer() {
			
			@Override
			public String render(WebContext context, String profile, Map<String, Object> environment) throws Exception {				
				List<String> nodes = new ArrayList<>();				
				HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
				for (CDOResourceNode e: source.getNodes()) {
					String pe = context.getPath()[0];
					int didx = pe.lastIndexOf('.');
					if (didx!=-1) {
						pe = pe.substring(0, didx);
					}
					if (context instanceof HttpContext) {
						nodes.add(htmlFactory.routeLink(null, "/"+((HttpContext) context).getObjectPath(e)+".html", StringEscapeUtils.escapeHtml4(e.getName())).toString());
					}
				}				
				
				return htmlFactory.ul(nodes).toString();
			}
		};
	}

	
}
