package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.core.Converter;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.html.HTMLRenderer;

public class EClassToHTMLRendererConverter implements Converter<EClass, HTMLRenderer, HttpServletRequestContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(
			final EClass source, 
			Class<HTMLRenderer> target,
			HttpServletRequestContext context) throws Exception {
		
		return new HTMLRenderer() {
			
			@Override
			public String render(HttpServletRequestContext context, String profile, Map<String, Object> environment) throws Exception {
				if ("label".equals(profile)) {
					return StringEscapeUtils.escapeHtml4(source.getName());
				}
				
				HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
				Breadcrumbs breadcrumbs = htmlFactory.breadcrumbs();
				for (TraceEntry te: context.getPathTrace()) {
					breadcrumbs.item(te.getPath(), te.getDisplayName());
				}
				String sourceName = StringEscapeUtils.escapeHtml4(source.getName());
				breadcrumbs.item(null, sourceName);
				
				if (source.isInterface()) {
					sourceName = "interface "+sourceName;
				}
				
				Fragment body = htmlFactory.fragment(
						htmlFactory.title("EClass "+source.getName()),
						breadcrumbs,
						htmlFactory.tag("h4", "EClass ", source.isAbstract() ? htmlFactory.tag("i", sourceName) : sourceName),
						htmlFactory.tag("p", NasdanikaCDOUtil.getDocumentation(source)));
				
				if (!source.getESuperTypes().isEmpty()) {
					Table scTable = htmlFactory.table().bordered();
					Row hRow = scTable.row().style().background().color().bootstrapColor(Bootstrap.Color.GRAY_LIGHTER);
					hRow.header("Name");
					hRow.header("Description");
					for (EClass st: source.getESuperTypes()) {
						Row row = scTable.row();
						Tag classifierLink = htmlFactory.routeLink("main", "/"+context.getObjectPath(st)+".html", StringEscapeUtils.escapeHtml4(st.getName()));
						row.cell(st.isAbstract() ? htmlFactory.tag("i", classifierLink) : classifierLink);						
						row.cell(NasdanikaCDOUtil.getSummary(st));						
					}
					body.content(htmlFactory.panel(Bootstrap.Style.DEFAULT, "Supertypes", scTable, null));
				}
				
				// Known subtypes - scan package registry, name, package (rowspan with success highlighting), current package first
				
				// attributes
				if (!source.getEAttributes().isEmpty()) {
					Table aTable = htmlFactory.table().bordered();
					Row hRow = aTable.row().style().background().color().bootstrapColor(Bootstrap.Color.GRAY_LIGHTER);
					hRow.header("Name");
					hRow.header("Type");
					hRow.header("Many");
					hRow.header("Description");
					for (EAttribute a: source.getEAttributes()) {
						Row row = aTable.row();
						row.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(a)+".html", StringEscapeUtils.escapeHtml4(a.getName())));
						if (a.getEType()!=null) {
							row.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(a.getEType())+".html", StringEscapeUtils.escapeHtml4(a.getEType().getName())));
						} else {
							row.cell("&nbsp;"); // TODO - generic type.
						}
						row.cell(a.isMany() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
						row.cell(NasdanikaCDOUtil.getSummary(a));
					}
					body.content(htmlFactory.panel(Bootstrap.Style.DEFAULT, "Attributes", aTable, null));
				}
				
				// references
				if (!source.getEReferences().isEmpty()) {
					Table rTable = htmlFactory.table().bordered();
					Row hRow = rTable.row().style().background().color().bootstrapColor(Bootstrap.Color.GRAY_LIGHTER);
					hRow.header("Name");
					hRow.header("Type");
					hRow.header("Many");
					hRow.header("Container");
					hRow.header("Containment");
					hRow.header("Opposite");
					hRow.header("Description");
					for (EReference r: source.getEReferences()) {
						Row row = rTable.row();
						row.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(r)+".html", StringEscapeUtils.escapeHtml4(r.getName())));
						if (r.getEType()!=null) {
							row.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(r.getEType())+".html", StringEscapeUtils.escapeHtml4(r.getEType().getName())));
						} else {
							row.cell("&nbsp;"); // TODO - generic type.
						}
						row.cell(r.isMany() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
						row.cell(r.isContainer() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
						row.cell(r.isContainment() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
						if (r.getEOpposite()==null) {
							row.cell("&nbsp;");
						} else {
							row.cell(
									htmlFactory.routeLink("main", "/"+context.getObjectPath(r.getEOpposite().getEContainingClass())+".html", StringEscapeUtils.escapeHtml4(r.getEOpposite().getEContainingClass().getName())),
									".",
									htmlFactory.routeLink("main", "/"+context.getObjectPath(r.getEOpposite())+".html", StringEscapeUtils.escapeHtml4(r.getEOpposite().getName())));
						}
						row.cell(NasdanikaCDOUtil.getSummary(r));
					}
					body.content("<p/>", htmlFactory.panel(Bootstrap.Style.DEFAULT, "References", rTable, null));
				}
				
				// operations
				if (!source.getEOperations().isEmpty()) {
					Table oTable = htmlFactory.table().bordered();
					Row hRow = oTable.row().style().background().color().bootstrapColor(Bootstrap.Color.GRAY_LIGHTER);
					hRow.header("Name");
					hRow.header("Return type");
					hRow.header("Many");
					hRow.header("Parameters");
					hRow.header("Exceptions");
					hRow.header("Description");
					for (EOperation op: source.getEOperations()) {
						Row row = oTable.row();
						row.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(op)+".html", StringEscapeUtils.escapeHtml4(op.getName())));
						if (op.getEType()!=null) {
							row.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(op.getEType())+".html", StringEscapeUtils.escapeHtml4(op.getEType().getName())));
						} else {
							row.cell("&nbsp;"); // TODO - generic type.
						}
						row.cell(op.isMany() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
						
						List<Object> params = new ArrayList<>();
						for (EParameter p: op.getEParameters()) {
							params.add(htmlFactory.fragment(
									htmlFactory.routeLink("main", "/"+context.getObjectPath(p)+".html", StringEscapeUtils.escapeHtml4(p.getName())),
									" : ",
									p.getEType()==null ? "void" : "/"+htmlFactory.routeLink("main", context.getObjectPath(p.getEType())+".html", StringEscapeUtils.escapeHtml4(p.getEType().getName())),
									p.isMany() ? " *" : ""));
						}
						row.cell(htmlFactory.ol(params));						
						
						List<Object> exs = new ArrayList<>();
						for (EClassifier ex: op.getEExceptions()) {
							params.add(htmlFactory.routeLink("main", "/"+context.getObjectPath(ex)+".html", StringEscapeUtils.escapeHtml4(ex.getName())));
						}
						row.cell(htmlFactory.ul(exs));
						
						row.cell(NasdanikaCDOUtil.getSummary(op));
					}
					body.content("<p/>", htmlFactory.panel(Bootstrap.Style.DEFAULT, "Operations", oTable, null));
				}
				
				return body.toString();
			}
		};
	}

	
}
