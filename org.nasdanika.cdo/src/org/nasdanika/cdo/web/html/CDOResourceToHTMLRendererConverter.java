package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Converter;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class CDOResourceToHTMLRendererConverter implements Converter<CDOResource, HTMLRenderer, WebContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(
			final CDOResource source, 
			Class<HTMLRenderer> target,
			WebContext context) throws Exception {
		
		return new HTMLRenderer() {
			
			@Override
			public String render(WebContext context, String profile, Map<String, Object> environment) throws Exception {				
				HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
				Breadcrumbs breadcrumbs = htmlFactory.breadcrumbs();
				for (TraceEntry te: context.getPathTrace()) {
					breadcrumbs.item(te.getPath(), te.getDisplayName());
				}
				breadcrumbs.item(null, StringEscapeUtils.escapeHtml4(source.getName()));		
				
				List<String> contents = new ArrayList<>();				
				for (EObject e: source.eContents()) {
					String pe = context.getPath()[0];
					int didx = pe.lastIndexOf('.');
					if (didx!=-1) {
						pe = pe.substring(0, didx);
					}
					if (context instanceof HttpContext) {
						contents.add(htmlFactory.routeLink(null, "/"+((HttpContext) context).getObjectPath(e)+".html", context.toHTML(e, "label", null)).toString());
					}
				}
								
				return breadcrumbs.toString()+htmlFactory.ul(contents).toString();
			}
		};
	}

	
}
