package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.core.Converter;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement.BootstrapColor;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.html.HTMLRenderer;

public class EObjectToHTMLRendererConverter<T extends EObject> implements Converter<T, HTMLRenderer, HttpServletRequestContext> {

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
			HttpServletRequestContext context) throws Exception {
		
		return new HTMLRenderer() {
			
			@Override
			public String render(HttpServletRequestContext context, String profile, Map<String, Object> environment) throws Exception {
				
				if ("label".equals(profile)) {
					return label(source);
				}				
				HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
				
				Breadcrumbs breadcrumbs = htmlFactory.breadcrumbs();
				for (TraceEntry te: context.getPathTrace()) {
					breadcrumbs.item(te.getPath(), te.getDisplayName());
				}
				breadcrumbs.item(null, label(source));				
				
				Tag header = htmlFactory.tag("h4", htmlFactory.routeLink("main", "/"+context.getObjectPath(source.eClass())+".html", StringEscapeUtils.escapeHtml4(source.eClass().getName())));
				
				for (EAttribute attr: source.eClass().getEAllAttributes()) {
					if (attr.isID()) {
						header.content(" ", StringEscapeUtils.escapeHtml4(String.valueOf(source.eGet(attr))));
					}
				}
				
				Object features = renderFeatures(source, context);
				Object operations = renderOperations(source, context);
				Object body;
				if (features==null) {
					if (operations==null) {
						body = "";
					} else {
						body = htmlFactory.fragment(htmlFactory.tag("h4", "Operations"), operations);
					}
				} else {
					if (operations==null) {
						body = htmlFactory.fragment(htmlFactory.tag("h4", "Features"), features);
					} else {
						Tabs featuresOperationsTabs = htmlFactory.tabs();
						body = featuresOperationsTabs;
						featuresOperationsTabs.item("Features", features);
						featuresOperationsTabs.item("Operations", operations);
					}
				}				
				
				// TODO - edit/add/delete buttons if there are permissions.
				
				return htmlFactory.fragment(
						htmlFactory.title(label(source)), 
						breadcrumbs, 
						header, 
						source instanceof EModelElement ? htmlFactory.tag("p", NasdanikaCDOUtil.getDocumentation((EModelElement) source)) : "", 
						htmlFactory.button(htmlFactory.glyphicon(Glyphicon.save), "&nbsp;Export to XML").on(Event.click, "window.location.href='"+context.getObjectPath(source)+".xml'"),
						"<p/>",
						body).toString();
			}
		};
	}
	
	private Object renderFeatures(T source, HttpServletRequestContext context) throws Exception {
		HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
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
			String sfLabel = NasdanikaCDOUtil.nameToLabel(sf.getName());
			Object value = source.eGet(sf);
			if (sf.isMany()) {
				if (!((Collection<?>) source.eGet(sf)).isEmpty() /* || can edit */) {
					String fPath = context.getObjectPath(source)+"/"+sf.getName()+".html";
					listsAndContainmentsTabs.ajaxItem(sfLabel, fPath);
				}
			} else {
				if (sf instanceof EReference && ((EReference) sf).isContainment() && (source.eIsSet(sf) /* || can edit */)) {
					String valuePath = context.getObjectPath(value);
					listsAndContainmentsTabs.ajaxItem(sfLabel, valuePath+".html");
				} else if (source.eIsSet(sf)) {							
					Row row = scalarsTable.row();
					row.header(sfLabel);
					if (Boolean.TRUE.equals(value)) {
						row.cell(htmlFactory.glyphicon(Glyphicon.ok));
					} else if (Boolean.FALSE.equals(value) || value==null) {
						row.cell("&nbsp;");
					} else if (sf instanceof EAttribute) {
						row.cell(context.toHTML(value, null, null));
					} else {
						row.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(value)+".html", context.toHTML(value, "label", null)));
					}
				}
			}
		}
		
		context.buildUICategory("tabs", listsAndContainmentsTabs, null);
		
		if (scalarsTable.rows().isEmpty()) {
			if (listsAndContainmentsTabs.isEmpty()) {
				return null;
			}
			return listsAndContainmentsTabs;
		}
		
		if (listsAndContainmentsTabs.isEmpty()) {
			return scalarsTable;
		}
		
		return htmlFactory.fragment(scalarsTable, listsAndContainmentsTabs);
	}

	private Object renderOperations(T source, HttpServletRequestContext context) throws Exception {
		List<EOperation> allOperations = new ArrayList<>(source.eClass().getEAllOperations());
		if (allOperations.isEmpty()) {
			return null;
		}
		HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
		Collections.sort(allOperations, new Comparator<EOperation>() {

			@Override
			public int compare(EOperation o1, EOperation o2) {						
				return o1.getName().compareTo(o2.getName());
			}
			
		});
										
		Table operationsTable = htmlFactory.table().bordered();
		Row hr1 = operationsTable.row().background(BootstrapColor.GRAY_LIGHTER);
		hr1.header("Name").rowspan(2);
		hr1.header("Parameters").colspan(2).style("text-align", "center");
		hr1.header("Return type").rowspan(2);
		hr1.header("Description").rowspan(2);
		Row hr2 = operationsTable.row().background(BootstrapColor.GRAY_LIGHTER);
		hr2.header("Name");
		hr2.header("Type");
		for (EOperation op: allOperations) {
			Row oRow = operationsTable.row();
			oRow.cell(op.getName()); // TODO - rowSpan equal to number of parameters, if more than 1
			oRow.cell("&nbsp;"); // TODO - Return type with link
			oRow.cell("&nbsp;"); // TODO - Parameters with links to types
			oRow.cell("&nbsp;"); // TODO
			oRow.cell(NasdanikaCDOUtil.getSummary(op));
		}
		
		return operationsTable;
	}
	
}
