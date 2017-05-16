package org.nasdanika.cdo.web.doc.webtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.ParameterizedTestResult;
import org.nasdanika.webtest.model.TestClassResult;
import org.nasdanika.webtest.model.TestResult;

class ParameterizedTestResultDocumentationGenerator extends TestSuiteResultDocumentationGenerator<ParameterizedTestResult> {
	
	private interface RowBuilder {
		
		void buildRow(Row row);
		
	}
	
	private class ParameterNode implements Comparable <ParameterNode> {
		
		private int pIdx;
		private String pValue;
		private ParameterizedTestResult parameterizedTestResult;

		private ParameterNode(int pIdx, String pValue) {
			this.pIdx = pIdx;
			this.pValue = pValue;
		}
		
		private ParameterNode(ParameterizedTestResult parameterizedTestResult) {
			this.parameterizedTestResult = parameterizedTestResult;
			for (TestResult child: parameterizedTestResult.getChildren()) {
				addTestResult((TestClassResult) child);
			}
		}				
		
		private List<ParameterNode> children = new ArrayList<>();
		
		private List<TestClassResult> results = new ArrayList<>();
		
		void addTestResult(TestClassResult testClassResult) {
			if (!testClassResult.getMethodResults().isEmpty()) {
				int nnpidx = -1;
				EList<String> parameters = testClassResult.getMethodResults().get(0).getParameters();
				for (int i = 0; i < parameters.size(); ++i) {
					if (parameters.get(i) != null) {
						nnpidx = i;
					}
				}
				
				if (nnpidx > pIdx) {
					String cpv = parameters.get(pIdx);
					for (ParameterNode child: children) {						
						if (child.pValue == cpv || child.pValue.equals(cpv)) {
							child.addTestResult(testClassResult);
							return;
						}
					}
					ParameterNode child = new ParameterNode(pIdx + 1, cpv);
					children.add(child);
					child.addTestResult(testClassResult);					
				} else {
					results.add(testClassResult);
				}
			}				
		}
		
		private Comparator<TestClassResult> resultsComparator = new Comparator<TestClassResult>() {

			@Override
			public int compare(TestClassResult o1, TestClassResult o2) {
				DocumentationGenerator<?> dg1 = testResultsDocumentationGenerator.getDocumentationGenerator(o1.eClass());
				DocumentationGenerator<?> dg2 = testResultsDocumentationGenerator.getDocumentationGenerator(o2.eClass());
				
				if (dg1 == null || dg2 == null) {
					return o1.hashCode() - o2.hashCode();
				}
				
				String t1 = ((TestClassResultDocumentationGenerator) dg1).getTitle(o1);
				String t2 = ((TestClassResultDocumentationGenerator) dg2).getTitle(o2);
				
				if (t1 == null) {
					return t2 == null ? o1.hashCode() - o2.hashCode() : 1;
				}
				
				if (t2 == null) {
					return -1;
				}
				
				int cmp = t1.compareTo(t2);
										
				return cmp == 0 ? o1.hashCode() - o2.hashCode() : cmp;
			}
			
		};
		
		
		void createToc(TocNode parent) {
			if (children.isEmpty() && results.isEmpty()) {
				return;
			}
			
			try {
				TocNode nodeToc; 				
				if (pIdx == 0) {
					nodeToc = parent.createChild(
							getTitle(parameterizedTestResult), 
							testResultsDocumentationGenerator.getObjectPath(parameterizedTestResult)+"/index.html",
							getIcon(parameterizedTestResult), 
							null, 
							null,
							obj -> obj == parameterizedTestResult, 
							false);					
				} else {
					nodeToc = parent.createChild(
							StringEscapeUtils.escapeHtml4(pValue), 
							null,
							"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/wrench.png", 
							null, 
							null,
							null, 
							false);					
					
				}
				Collections.sort(children);
				for (ParameterNode child: children) {
					child.createToc(nodeToc);
				}
				Collections.sort(results, resultsComparator);
				
				for (TestClassResult res: results) {
					DocumentationGenerator<Object> elTocBuilderRoute = testResultsDocumentationGenerator.getDocumentationGenerator(res.eClass());
					if (elTocBuilderRoute != null) {
						elTocBuilderRoute.createToc(res, nodeToc);
					}					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		int createRows(Table resultsTable, EMap<OperationStatus, Integer> suiteStats, int resultNumber, RowBuilder parentRowBuilder) {
			
			RowBuilder rowBuilder = new RowBuilder() {
				@Override
				public void buildRow(Row row) {
					if (parentRowBuilder != null) {
						parentRowBuilder.buildRow(row);
					}
					
					if (pIdx > 0) {
						row.cell(pValue == null ? "" : StringEscapeUtils.escapeHtml4(pValue)).rowspan(size());
					}										
				}
			};

			Collections.sort(children);
			for (ParameterNode child: children) {
				resultNumber = child.createRows(resultsTable, suiteStats, resultNumber, rowBuilder);
				rowBuilder = null;
			}
			
			Collections.sort(results, resultsComparator);
			for (TestResult tr: results) {
				Row childRow = resultsTable.body().row();
				try {
					String objectPath = testResultsDocumentationGenerator.getObjectPath(tr);
					String href = DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+testResultsDocumentationGenerator.getDocRoute().getDocRoutePath()+objectPath+"/index.html";
					childRow.cell(HTMLFactory.INSTANCE.link(href, ++resultNumber)).style().text().align().right();
				} catch (Exception e) {
					childRow.cell(++resultNumber, HTMLFactory.INSTANCE.alert(Style.DANGER, false, e)).style().text().align().right();					
				}
				
				if (rowBuilder != null) {
					rowBuilder.buildRow(childRow);
					rowBuilder = null;
				}
				
				EList<String> parameters = ((TestClassResult) tr).getMethodResults().get(0).getParameters();
				for (int i = pIdx; i< parameters.size(); ++i) {
					String pv = parameters.get(i);
					childRow.cell(pv == null ? "" : StringEscapeUtils.escapeHtml4(pv));
				}
				
				EMap<OperationStatus, Integer> trStats = testResultStats(tr);
				for (OperationStatus status: OperationStatus.values()) {
					if (suiteStats.containsKey(status)) {
						childRow.cell(trStats.containsKey(status) ? trStats.get(status) : "&nbsp;").attribute("align", "center");
					}
				}			
			}
			return resultNumber;
		}

		@Override
		public int compareTo(ParameterNode o) {
			return pValue.compareTo(o.pValue);
		}
		
		private int size() {
			int ret = 0; 
			for (ParameterNode child: children) {
				ret +=  child.size();
			}
			return ret + results.size();			
		}
		
		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder();
			for (int i=0; i<pIdx; ++i) {
				ret.append("\t");
			}
			ret.append(pValue == null ? "Root" : pValue).append(" ").append(pIdx).append(System.lineSeparator());			
			for (ParameterNode child: children) {
				ret.append(child);
			}
			for (TestClassResult tr: results) {
				for (int i=0; i<=pIdx; ++i) {
					ret.append("\t");
				}
				ret.append("[Test Result] ").append(tr).append(System.lineSeparator());
			}
			return ret.toString();
		}
	}

	protected ParameterizedTestResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}
	
	@Override
	public void createToc(ParameterizedTestResult obj, TocNode parent) {
		if (!obj.getChildren().isEmpty()) {
			new ParameterNode(obj).createToc(parent);
//			super.createToc(obj, parent);
		}
	}
	
	@Override
	protected String getTitle(ParameterizedTestResult obj) {
		return obj.getChildren().get(0).getTitle();
	}
	
	@Override
	protected Fragment getIndex(ParameterizedTestResult obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		HTMLFactory htmlFactory = testResultsDocumentationGenerator.getDocRoute().getHtmlFactory();
		Fragment ret = htmlFactory.fragment(header(obj));
		qualifiedName(obj, ret, context, baseURI, urlPrefix, path);		
		description(obj, ret, context, baseURI, urlPrefix);
		links(obj, ret, context, baseURI, urlPrefix);
		
		ret.content(htmlFactory.tag(Tag.TagName.h4, "Parameters"));
		Table parametersTable = htmlFactory.table().bordered();
		ret.content(parametersTable);
		parametersTable.header().headerRow("Title", "Description", "Field", "Type").style(Bootstrap.Style.INFO);
		RowContainer<?> parametersTableBody = parametersTable.body();
		for (Descriptor pd: obj.getParameterDescriptors()) {
			Row pRow = parametersTableBody.row(pd.getTitle());
			description(pd, pRow.cell(), context, baseURI, urlPrefix);
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
			
			ParameterNode rootParameterNode = new ParameterNode(obj);
			rootParameterNode.createRows(resultsTable, suiteStats, 0, null);
			Row totalsRow = resultsTable.row().style(Bootstrap.Style.INFO);
			totalsRow.cell("Total").colspan(obj.getParameterDescriptors().size()+1);
			for (OperationStatus status: OperationStatus.values()) {
				if (suiteStats.containsKey(status)) {
					totalsRow.cell(suiteStats.get(status)).attribute("align", "center");
				}
			}			
		}
		
		return ret;
	}
	
}
