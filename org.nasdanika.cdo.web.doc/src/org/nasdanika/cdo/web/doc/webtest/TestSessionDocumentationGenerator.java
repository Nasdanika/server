package org.nasdanika.cdo.web.doc.webtest;

import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EMap;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.PageResult;
import org.nasdanika.webtest.model.TestResult;
import org.nasdanika.webtest.model.TestSession;

class TestSessionDocumentationGenerator extends DescriptorDocumentationGenerator<TestSession> {

	protected TestSessionDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}

	@Override
	public void createToc(TestSession testSession, TocNode parent) {
		try {
			TocNode testSessionNode = parent.createChild(
					testSession.getTitle(), 
					testResultsDocumentationGenerator.getObjectPath(testSession)+"/index.html",
					getIcon(), 
					null,
					obj -> obj == testSession);
			
			if (!testSession.getActorResults().isEmpty()) {
				TocNode actorsNode = testSessionNode.createChild(
						"Actors", 
						null, 
						null, 
						null, 
						null);
				
				for (ActorResult ar: testSession.getActorResults()) {
					DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(ar.eClass());
					if (docGen != null) {
						docGen.createToc(ar, actorsNode);
					}
				}
				if (actorsNode.getChildren().isEmpty()) {
					testSessionNode.getChildren().remove(actorsNode);
				}				
			}
			if (!testSession.getPageResults().isEmpty()) {
				TocNode pagesNode = testSessionNode.createChild(
						"Pages", 
						null, 
						null, 
						null, 
						null);
				
				for (PageResult pr: testSession.getPageResults()) {
					DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(pr.eClass());
					if (docGen != null) {
						docGen.createToc(pr, pagesNode);
					}
				}
				if (pagesNode.getChildren().isEmpty()) {
					testSessionNode.getChildren().remove(pagesNode);
				}				
			}
			if (!testSession.getTestResults().isEmpty()) {
				TocNode testsNode = testSessionNode.createChild(
						"Tests", 
						null, 
						null, 
						null, 
						null);
				
				for (TestResult tr: testSession.getTestResults()) {
					DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(tr.eClass());
					if (docGen != null) {
						docGen.createToc(tr, testsNode);
					}
				}
				if (testsNode.getChildren().isEmpty()) {
					testSessionNode.getChildren().remove(testsNode);
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getIcon() {
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/zoom.png";
	}
			
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Fragment getIndex(TestSession obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		HTMLFactory htmlFactory = testResultsDocumentationGenerator.getDocRoute().getHtmlFactory();
		Fragment ret = htmlFactory.fragment(header(obj));

		qualifiedName(obj, ret, context, baseURI, urlPrefix, path);
		ret.content(htmlFactory.div("<b>Node:</b> ", StringEscapeUtils.escapeHtml4(obj.getNode())));
		ret.content(htmlFactory.div("<b>Time:</b> ", new Date(obj.getTimestamp())));
		description(obj, ret, context, baseURI, urlPrefix);
		links(obj, ret, context, baseURI, urlPrefix);
		
		Tabs tabs = htmlFactory.tabs().style().margin().top("5px");
		if (!obj.getTestResults().isEmpty()) {
			EMap<OperationStatus, Integer> sessionStats = testResultStats(obj);			
			Fragment testsTabContent = htmlFactory.fragment();
			
			statsChart(sessionStats, testsTabContent);	
			
			Table resultsTable = htmlFactory.table().bordered();
			testsTabContent.content(resultsTable);
			Row header = resultsTable.header().row().style(Bootstrap.Style.INFO);
			header.header(htmlFactory.glyphicon(Glyphicon.search), "&nbsp;Test(s)");
			header.header(htmlFactory.glyphicon(Glyphicon.file), "&nbsp;Description");
			for (OperationStatus status: OperationStatus.values()) {
				if (sessionStats.containsKey(status)) {
					header.header(operationStatusGlyph(status), "&nbsp;", status.getName()).style("text-align", "center").attribute("nowrap", "true");
				}
			}
			for (TestResult tr: obj.getTestResults()) {
				Row classRow = resultsTable.body().row();
				String objectPath = testResultsDocumentationGenerator.getObjectPath(tr);
				DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(tr.eClass());
				String title = docGen instanceof DescriptorDocumentationGenerator ? ((DescriptorDocumentationGenerator) docGen).getTitle(tr) : tr.getTitle(); 
				String href = DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+testResultsDocumentationGenerator.getDocRoute().getDocRoutePath()+objectPath+"/index.html";
				classRow.cell(htmlFactory.link(href, StringEscapeUtils.escapeHtml4(title)));				
				Cell descriptionCell = classRow.cell();
				if (docGen instanceof DescriptorDocumentationGenerator) {
					((DescriptorDocumentationGenerator) docGen).description(tr, descriptionCell, context, baseURI, urlPrefix);
				}
				
				EMap<OperationStatus, Integer> trStats = testResultStats(tr);
				if (sessionStats.containsKey(OperationStatus.PASS)) {
					classRow.cell(trStats.containsKey(OperationStatus.PASS) ? trStats.get(OperationStatus.PASS) : "&nbsp;").attribute("align", "center");
				}
				if (sessionStats.containsKey(OperationStatus.FAIL)) {
					classRow.cell(trStats.containsKey(OperationStatus.FAIL) ? trStats.get(OperationStatus.FAIL) : "&nbsp;").attribute("align", "center");
				}
				if (sessionStats.containsKey(OperationStatus.ERROR)) {
					classRow.cell(trStats.containsKey(OperationStatus.ERROR) ? trStats.get(OperationStatus.ERROR) : "&nbsp;").attribute("align", "center");
				}
				if (sessionStats.containsKey(OperationStatus.PENDING)) {
					classRow.cell(trStats.containsKey(OperationStatus.PENDING) ? trStats.get(OperationStatus.PENDING) : "&nbsp;").attribute("align", "center");
				}
			}
			Row totalsRow = resultsTable.row().style(Bootstrap.Style.INFO);
			totalsRow.cell("Total").colspan(2);
			for (OperationStatus status: OperationStatus.values()) {
				if (sessionStats.containsKey(status)) {
					totalsRow.cell(sessionStats.get(status)).attribute("align", "center");
				}
			}			
			tabs.item("Tests", testsTabContent);
		}
		if (!obj.getActorResults().isEmpty()) {
			tabs.item("Actors", "actors - TODO");
		}
		if (!obj.getPageResults().isEmpty()) {
			tabs.item("Pages", "pages - TODO");
		}
		ret.content(tabs);
		
		return ret;
	}

	@Override
	protected Type getType(Descriptor obj) {
		return Type.CLASS;
	}

}
