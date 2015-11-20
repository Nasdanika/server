package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.common.model.CDOPackageInfo;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.core.Converter;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.html.HTMLRenderer;

public class CDOViewToHTMLRendererConverter implements Converter<CDOView, HTMLRenderer, HttpServletRequestContext> {

	@Override
	public void close() throws Exception {
		// NOP
		
	}

	@Override
	public HTMLRenderer convert(
			final CDOView source, 
			Class<HTMLRenderer> target,
			HttpServletRequestContext context) throws Exception {
		
		return new HTMLRenderer() {
			
			@Override
			public String render(HttpServletRequestContext context, String profile, Map<String, Object> environment) throws Exception {				
				List<String> elements = new ArrayList<>();				
				HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
				for (CDOResourceNode e: source.getElements()) {
					String pe = context.getPath()[0];
					int didx = pe.lastIndexOf('.');
					if (didx!=-1) {
						pe = pe.substring(0, didx);
					}
					if (context instanceof HttpServletRequestContext) {
						elements.add(htmlFactory.routeLink(null, "/"+((HttpServletRequestContext) context).getObjectPath(e)+".html", e.getName()).toString()); // TODO - escape names
					}
				}
				
				Tabs tabs = htmlFactory.tabs();
				tabs.item("Elements", htmlFactory.ul(elements));
				List<CDOPackageInfo> packageInfos = new ArrayList<>();
				for (CDOPackageInfo pi: source.getSession().getPackageRegistry().getPackageInfos()) {
					packageInfos.add(pi);
				}
				
				List<CDOPackageInfo> sortedPackageInfos = new ArrayList<>(packageInfos);				
				Collections.sort(sortedPackageInfos, new Comparator<CDOPackageInfo>() {

					@Override
					public int compare(CDOPackageInfo o1, CDOPackageInfo o2) {
						if (o1==o2) {
							return 0;
						}
						int ncmp = o1.getEPackage().getName().compareTo(o2.getEPackage().getName());						
						return ncmp==0 ? o1.getEPackage().getNsURI().compareTo(o2.getEPackage().getNsURI()) : ncmp;
					}
				});
				
				Table packageTable = htmlFactory.table().bordered();
				Row headerRow = packageTable.row().background(Bootstrap.Color.GRAY_LIGHTER);
				headerRow.header("Name");
				headerRow.header("Namespace URI");
				headerRow.header("Documentation");
				headerRow.header("Core");
				headerRow.header("Res");
				headerRow.header("System");
				headerRow.header("Type");
				for (CDOPackageInfo pi: sortedPackageInfos) {
					Row packageRow = packageTable.row();
					EPackage ePackage = pi.getEPackage();
					packageRow.cell(htmlFactory.routeLink("main", "/"+context.getObjectPath(ePackage)+".html", StringEscapeUtils.escapeHtml4(ePackage.getName()))); // TODO - link
					packageRow.cell(StringEscapeUtils.escapeHtml4(ePackage.getNsURI()));
					packageRow.cell(NasdanikaCDOUtil.getSummary(ePackage));
					packageRow.cell(pi.isCorePackage() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
					packageRow.cell(pi.isResourcePackage() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
					packageRow.cell(pi.isSystemPackage() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
					packageRow.cell(pi.isTypePackage() ? htmlFactory.glyphicon(Glyphicon.ok) : "&nbsp;").attribute("align", "center");
				}
				tabs.item("Packages", packageTable); // TODO
				
				return htmlFactory.fragment(htmlFactory.tag("h4", "CDO View"), tabs, htmlFactory.title("CDO View")).toString();
			}
		};
	}

	
}
