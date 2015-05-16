package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.core.Converter;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.html.HTMLRenderer;

public class EReferenceClosureToHTMLRendererConverter implements Converter<EReferenceClosure<?>, HTMLRenderer, HttpServletRequestContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(final EReferenceClosure<?> source, Class<HTMLRenderer> target, HttpServletRequestContext context) throws Exception {
		return new HTMLRenderer() {
			
			@Override
			public String render(HttpServletRequestContext context, String profile, Map<String, Object> environment) throws Exception {
				if ("label".equals(profile)) {
					return StringEscapeUtils.escapeHtml4(source.getFeature().getName());
				}
				if (source.getFeature().isMany()) {
					List<Object> elements = new ArrayList<>();
					for (Object e: (Iterable<?>) source.getValue()) {
						elements.add(context.adapt(HTMLFactory.class).routeLink("main", "/"+context.getObjectPath(e)+".html", context.toHTML(e, "label", null)));						
					}
					return context.adapt(HTMLFactory.class).ol(elements).toString();
				}
				return context.toHTML(source.getValue(), null, null);
			}
			
		};
	}


}
