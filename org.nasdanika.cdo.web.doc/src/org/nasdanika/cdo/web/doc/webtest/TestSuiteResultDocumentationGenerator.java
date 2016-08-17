package org.nasdanika.cdo.web.doc.webtest;

import java.util.Collection;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Table;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.TestResult;
import org.nasdanika.webtest.model.TestSuiteResult;

class TestSuiteResultDocumentationGenerator<T extends TestSuiteResult> extends TestResultDocumentationGenerator<T> {

	protected TestSuiteResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Fragment getIndex(T obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURI, urlPrefix, path);
		
		if (!obj.getChildren().isEmpty()) {
			EMap<OperationStatus, Integer> suiteStats = testResultStats(obj);			
			HTMLFactory htmlFactory = testResultsDocumentationGenerator.getDocRoute().getHtmlFactory();
			
			statsChart(suiteStats, ret);	
			
			Table resultsTable = htmlFactory.table().bordered();
			ret.content(resultsTable);
			Row header = resultsTable.row().style(Bootstrap.Style.INFO);
			header.header(htmlFactory.glyphicon(Glyphicon.search), "&nbsp;Test(s)");
			header.header(htmlFactory.glyphicon(Glyphicon.file), "&nbsp;Description");
			for (OperationStatus status: OperationStatus.values()) {
				if (suiteStats.containsKey(status)) {
					header.header(operationStatusGlyph(status), "&nbsp;", status.getName()).style("text-align", "center").attribute("nowrap", "true");
				}
			}
			for (TestResult tr: obj.getChildren()) {
				Row childRow = resultsTable.row();
				String objectPath = testResultsDocumentationGenerator.getObjectPath(tr);
				DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(tr.eClass());
				String title = docGen instanceof DescriptorDocumentationGenerator ? ((DescriptorDocumentationGenerator) docGen).getTitle(tr) : tr.getTitle(); 
				String href = DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+testResultsDocumentationGenerator.getDocRoute().getDocRoutePath()+objectPath+"/index.html";
				childRow.cell(htmlFactory.link(href, StringEscapeUtils.escapeHtml4(title)));				
				Cell descriptionCell = childRow.cell();
				if (docGen instanceof DescriptorDocumentationGenerator) {
					((DescriptorDocumentationGenerator) docGen).description(tr, descriptionCell, context, baseURI, urlPrefix);
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
	
	@Override
	protected Collection<? extends EObject> getTocChildren(T testSuiteResult) {
		return testSuiteResult.getChildren();
	}

}
