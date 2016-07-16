package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EMap;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.ParameterizedTestResult;
import org.nasdanika.webtest.model.TestClassResult;
import org.nasdanika.webtest.model.TestResult;

class ParameterizedTestResultDocumentationGenerator extends TestSuiteResultDocumentationGenerator<ParameterizedTestResult> {

	protected ParameterizedTestResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}
	
	@Override
	public void createToc(ParameterizedTestResult obj, TocNode parent) {
		if (!obj.getChildren().isEmpty()) {
			super.createToc(obj, parent);
		}
	}
	
	@Override
	protected String getTitle(ParameterizedTestResult obj) {
		return obj.getChildren().get(0).getTitle();
	}
	
	@Override
	protected Fragment getIndex(ParameterizedTestResult obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		HTMLFactory htmlFactory = testResultsDocumentationGenerator.getDocRoute().getHtmlFactory();
		Fragment ret = htmlFactory.fragment(header(obj));
		qualifiedName(obj, ret, context, baseURL, urlPrefix, path);		
		description(obj, ret, context, baseURL, urlPrefix);

//		links(obj, ret, context, baseURL, urlPrefix);		
		
		ret.content(htmlFactory.tag(Tag.TagName.h4, "Parameters"));
		Table parametersTable = htmlFactory.table().bordered();
		ret.content(parametersTable);
		parametersTable.header().headerRow("Title", "Description", "Field", "Type").style(Bootstrap.Style.INFO);
		RowContainer<?> parametersTableBody = parametersTable.body();
		for (Descriptor pd: obj.getParameterDescriptors()) {
			Row pRow = parametersTableBody.row(pd.getTitle());
			description(pd, pRow.cell(), context, baseURL, urlPrefix);
			String pqn = pd.getQualifiedName();
			int cIdx = pqn.indexOf(":");
			int lsIdx = pqn.substring(cIdx+1).lastIndexOf(' ');
			pRow.cell(pqn.substring(0, cIdx));
			String className = pqn.substring(lsIdx+cIdx+2);
			pRow.cell(testResultsDocumentationGenerator.getDocRoute().javaDocLink(className, false, false));
		}
		
		if (!obj.getChildren().isEmpty()) {
			ret.content(htmlFactory.tag(Tag.TagName.h4, "Tests"));
			EMap<OperationStatus, Integer> suiteStats = testResultStats(obj);						
			statsChart(suiteStats, ret);	
			
			Table resultsTable = htmlFactory.table().bordered();
			ret.content(resultsTable);
			Row header = resultsTable.header().row().style(Bootstrap.Style.INFO);
			header.header("#").rowspan(2).style().text().align().right();
			header.header("Parameters").colspan(obj.getParameterDescriptors().size());
			for (OperationStatus status: OperationStatus.values()) {
				if (suiteStats.containsKey(status)) {
					header.header(operationStatusGlyph(status), "&nbsp;", status.getName()).style("text-align", "center").attribute("nowrap", "true").rowspan(2);
				}
			}

			Row pRow = resultsTable.header().row().style(Bootstrap.Style.INFO);
			for (Descriptor pd: obj.getParameterDescriptors()) {
				pRow.header(pd.getTitle());
			}
			
			int resNum = 0;
			for (TestResult tr: obj.getChildren()) {
				Row childRow = resultsTable.body().row();
				String objectPath = testResultsDocumentationGenerator.getObjectPath(tr);
				String href = DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+testResultsDocumentationGenerator.getDocRoute().getDocRoutePath()+objectPath+"/index.html";
				childRow.cell(htmlFactory.link(href, ++resNum)).style().text().align().right();		
				
				for (String pv: ((TestClassResult) tr).getMethodResults().get(0).getParameters()) {
					childRow.cell(StringEscapeUtils.escapeHtml4(pv));
				}
				
				EMap<OperationStatus, Integer> trStats = testResultStats(tr);
				for (OperationStatus status: OperationStatus.values()) {
					if (suiteStats.containsKey(status)) {
						childRow.cell(trStats.containsKey(status) ? trStats.get(status) : "&nbsp;").attribute("align", "center");
					}
				}			
			}
			Row totalsRow = resultsTable.row().style(Bootstrap.Style.INFO);
			totalsRow.cell("Total").colspan(2);
			for (OperationStatus status: OperationStatus.values()) {
				if (suiteStats.containsKey(status)) {
					totalsRow.cell(suiteStats.get(status)).attribute("align", "center");
				}
			}			
		}
		
		return ret;
	}
	
}
