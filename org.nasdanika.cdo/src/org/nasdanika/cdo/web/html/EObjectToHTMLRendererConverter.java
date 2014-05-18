package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.core.Converter;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class EObjectToHTMLRendererConverter<T extends EObject> implements Converter<T, HTMLRenderer, WebContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}
	
	protected String label(T source) {
		for (EAttribute attr: source.eClass().getEAllAttributes()) {
			if (attr.isID()) {
				return StringEscapeUtils.escapeHtml4(String.valueOf(source.eGet(attr)))+" ["+source.eClass().getName()+"]";
			}
		}
		return StringEscapeUtils.escapeHtml4(source.eClass().getName());		
	}

	@Override
	public HTMLRenderer convert(
			final T source, 
			Class<HTMLRenderer> target,
			WebContext context) throws Exception {
		
		return new HTMLRenderer() {
			
			@Override
			public String render(WebContext context, String profile, Map<String, Object> environment) throws Exception {
				
				if ("label".equals(profile)) {
					return label(source);
				}				
				HTMLFactory htmlFactory = context.getHTMLFactory();
				
				Breadcrumbs breadcrumbs = htmlFactory.breadcrumbs();
				for (TraceEntry te: context.getPathTrace()) {
					breadcrumbs.item(te.getPath(), te.getDisplayName());
				}
				breadcrumbs.item(null, label(source));				
				
				Tag header = htmlFactory.tag("h4", htmlFactory.routeLink("main", context.getObjectPath(source.eClass())+".html", StringEscapeUtils.escapeHtml4(source.eClass().getName())));
				
				for (EAttribute attr: source.eClass().getEAllAttributes()) {
					if (attr.isID()) {
						header.content(" ", StringEscapeUtils.escapeHtml4(String.valueOf(source.eGet(attr))));
					}
				}
				
				List<EStructuralFeature> allStructuralFeatures = new ArrayList<>(source.eClass().getEAllStructuralFeatures());
				Collections.sort(allStructuralFeatures, new Comparator<EStructuralFeature>() {

					@Override
					public int compare(EStructuralFeature o1, EStructuralFeature o2) {						
						return o1.getName().compareTo(o2.getName());
					}
					
				});
												
				Table scalarsTable = htmlFactory.table().bordered();
				Tabs listsAndContainmentsTabs = htmlFactory.tabs();
				for (EStructuralFeature sf: allStructuralFeatures) {
					// TODO - security checks
					String sfName = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(StringUtils.capitalize(sf.getName())), " ");
					Object value = source.eGet(sf);
					if (sf.isMany()) {
						if (!((Collection<?>) source.eGet(sf)).isEmpty() /* || can edit */) {
							String fPath = context.getObjectPath(source)+"/"+sf.getName()+".html";
							listsAndContainmentsTabs.ajaxTab(sfName, null, fPath);
						}
					} else {
						if (sf instanceof EReference && ((EReference) sf).isContainment() && (source.eIsSet(sf) /* || can edit */)) {
							String valuePath = context.getObjectPath(value);
							listsAndContainmentsTabs.ajaxTab(sfName, null, valuePath+".html");
						} else if (source.eIsSet(sf)) {							
							Row row = scalarsTable.row();
							row.header(sfName);
							if (Boolean.TRUE.equals(value)) {
								row.cell(htmlFactory.glyphicon(Glyphicon.ok));
							} else if (Boolean.FALSE.equals(value) || value==null) {
								row.cell("&nbsp;");
							} else if (sf instanceof EAttribute) {
								row.cell(context.toHTML(value, null, null));
							} else {
								row.cell(htmlFactory.routeLink("main", context.getObjectPath(value)+".html", context.toHTML(value, "label", null)));
							}
						}
					}
				}
				
				// TODO - edit/add/delete buttons if there are permissions.
				
				return htmlFactory.fragment(
						htmlFactory.title(label(source)), 
						breadcrumbs, 
						header, 
						source instanceof EModelElement ? htmlFactory.tag("p", NasdanikaCDOUtil.getDocumentation((EModelElement) source)) : "", 
						scalarsTable,
						htmlFactory.button(htmlFactory.glyphicon(Glyphicon.save), "&nbsp;Export to XML").on(Event.click, "window.location.href='"+context.getObjectPath(source)+".xml'"),
						"<p/>", 
						listsAndContainmentsTabs).toString();
			}
		};
	}

	
}
