package org.nasdanika.cdo.web.html;

import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.cdo.EOperationClosure;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.core.Converter;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class EOperationClosureToHTMLRendererConverter implements Converter<EOperationClosure<?>, HTMLRenderer, WebContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(final EOperationClosure<?> source, Class<HTMLRenderer> target, WebContext context) throws Exception {
		return new HTMLRenderer() {
			
			@Override
			public String render(WebContext context, String profile, Map<String, Object> environment) throws Exception {
				if ("label".equals(profile)) {
					return StringEscapeUtils.escapeHtml4(source.getOperation().getName());
				}
				
				HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
				Form form = htmlFactory.form().attribute("method", "post");
				for (EParameter p: source.getOperation().getEParameters()) {
					String inputId = htmlFactory.nextId()+"_"+p.getName();
					// TODO - different input types depending on parameter type, text for now.
					Input input = htmlFactory.input(InputType.text)
							.name(p.getName()) 
							.id(inputId) 
							.placeholder(p.getEType().getName());
					
					form.formInputGroup(
							NasdanikaCDOUtil.nameToLabel(p.getName()), 
							inputId, 
							input, 
							NasdanikaCDOUtil.getSummary(p));
				}
				
				form.formInputGroup(
						null, 
						null, 
						htmlFactory.button("Invoke").style(Style.PRIMARY), 
						"Invoke EOperation");
				
				return htmlFactory.fragment(
						htmlFactory.tag("h4", "EOperation "+StringEscapeUtils.escapeHtml4(source.getOperation().getName())),
						NasdanikaCDOUtil.getDocumentation(source.getOperation()),
						"<p/>",
						form).toString();
			}
			
		};
	}


}
