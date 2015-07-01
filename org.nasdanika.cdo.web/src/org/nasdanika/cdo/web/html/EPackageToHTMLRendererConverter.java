package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.core.Converter;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement.BootstrapColor;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.html.HTMLRenderer;

public class EPackageToHTMLRendererConverter implements Converter<EPackage, HTMLRenderer, HttpServletRequestContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(
			final EPackage source, 
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
				breadcrumbs.item(null, StringEscapeUtils.escapeHtml4(source.getName()));
								
				Table classifiersTable = htmlFactory.table().bordered();
				
				List<EClassifier> classifiers = new ArrayList<>(source.getEClassifiers());
				Collections.sort(classifiers, new Comparator<EClassifier>() {

					@Override
					public int compare(EClassifier o1, EClassifier o2) {						
						return o1.getName().compareTo(o2.getName());
					}
					
				});
				
				if (!classifiers.isEmpty()) {
					Row headerRow = classifiersTable.row().background(BootstrapColor.GRAY_LIGHTER);
					headerRow.header("Name");
					headerRow.header("Type");
					headerRow.header("Description");
				}
				
				for (EClassifier ec: classifiers) {
					Row row = classifiersTable.row();
					Tag classifierLink = htmlFactory.routeLink("main", "/"+context.getObjectPath(ec)+".html", StringEscapeUtils.escapeHtml4(ec.getName()));
					row.cell(ec instanceof EClass && ((EClass) ec).isAbstract() ? htmlFactory.tag("i", classifierLink) : classifierLink);
					if (ec instanceof EClass) {
						row.cell(((EClass) ec).isInterface() ? "Interface" : "Class").attribute("align", "center");
					} else if (ec instanceof EEnum) {
						row.cell("Enum").attribute("align", "center");
					} else {
						row.cell("Data type").attribute("align", "center");						
					}
					
					row.cell(NasdanikaCDOUtil.getSummary(ec));
				}
				
				return htmlFactory.fragment(
						htmlFactory.title("EPackage " + StringEscapeUtils.escapeHtml4(source.getName())),
						breadcrumbs,
						htmlFactory.tag("h4", "EPackage ", StringEscapeUtils.escapeHtml4(source.getName())),
						htmlFactory.tag("p", NasdanikaCDOUtil.getDocumentation(source)),
						classifiersTable).toString();
			}
		};
	}

	
}
