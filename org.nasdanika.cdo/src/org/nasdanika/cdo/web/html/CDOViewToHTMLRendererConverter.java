package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.core.Converter;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tabs;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class CDOViewToHTMLRendererConverter implements Converter<CDOView, HTMLRenderer, WebContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(
			final CDOView source, 
			Class<HTMLRenderer> target,
			WebContext context) throws Exception {
		
		return new HTMLRenderer() {
			
			@Override
			public String render(WebContext context, String profile, Map<String, Object> environment) throws Exception {				
				List<String> elements = new ArrayList<>();				
				HTMLFactory htmlFactory = context.getHTMLFactory();
				for (CDOResourceNode e: source.getElements()) {
					String pe = context.getPath()[0];
					int didx = pe.lastIndexOf('.');
					if (didx!=-1) {
						pe = pe.substring(0, didx);
					}
					elements.add(htmlFactory.routeLink(null, pe+"/"+e.getName()+".html", e.getName()).toString()); // TODO - escape names
				}
				
				Tabs tabs = htmlFactory.tabs();
				tabs.tab("Elements", null, htmlFactory.ul(elements));
				tabs.ajaxTab("Packages",  null,  "test.html");
				return htmlFactory.fragment(htmlFactory.tag("h4", "CDO View"), tabs).toString();
			}
		};
	}

	
}
