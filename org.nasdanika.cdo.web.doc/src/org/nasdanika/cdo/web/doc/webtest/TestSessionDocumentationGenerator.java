package org.nasdanika.cdo.web.doc.webtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Color;
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
					null,
					obj -> obj == testSession, 
					false);
			
			if (!testSession.getActorResults().isEmpty()) {
				TocNode actorsNode = testSessionNode.createChild(
						"Actors", 
						null,
						null, 
						null, 
						null, 
						null, 
						false);
				
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
						null, 
						null, 
						false);
				
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
				
				class Category {
					String name;
					Map<String, Category> subCategories = new TreeMap<>();
					List<TestResult> testResults = new ArrayList<>();
					
					int depth;
					
					void createToc(TocNode parent) {
						TocNode categoryNode = parent.createChild(
								name, 
								null,
								null, 
								null, 
								null, 
								null, 
								false);
						
						for (Category sc: subCategories.values()) {
							sc.createToc(categoryNode);
						}
						
						Collections.sort(testResults, new Comparator<TestResult>() {

							@Override
							public int compare(TestResult o1, TestResult o2) {
								int cmp = o1.getTitle().compareTo(o2.getTitle());								
								return cmp == 0 ? o1.getQualifiedName().compareTo(o2.getQualifiedName()) : cmp;
							}
							
						});
						
						for (TestResult tr: testResults) {
							DocumentationGenerator<Object> docGen = testResultsDocumentationGenerator.getDocumentationGenerator(tr.eClass());
							if (docGen != null) {
								docGen.createToc(tr, categoryNode);
							}
						}
						
						if (categoryNode.getChildren().isEmpty()) {
							testSessionNode.getChildren().remove(categoryNode);
						}				
					}
					
					void addTestResult(TestResult tr) {
						if (tr.getCategory().size() == depth) {
							testResults.add(tr);
						} else {
							String scName = tr.getCategory().get(depth);
							Category sc = subCategories.get(scName);
							if (sc == null) {
								sc = new Category();
								sc.name = scName;
								sc.depth = depth + 1;
								subCategories.put(scName, sc);
							}
							sc.addTestResult(tr);
						}
					}
				}
				
				Category root = new Category();
				root.name = "Tests";
				
				for (TestResult tr: testSession.getTestResults()) {
					root.addTestResult(tr);
				}
				
				root.createToc(testSessionNode);
				
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
		List<TestResult> testResults = new ArrayList<>(obj.getTestResults());
		if (!testResults.isEmpty()) {
			EMap<OperationStatus, Integer> sessionStats = testResultStats(obj);			
			Fragment testsTabContent = htmlFactory.fragment();
			
			statsChart(sessionStats, testsTabContent);	
			
			Collections.sort(testResults, new Comparator<TestResult>() {

				@Override
				public int compare(TestResult o1, TestResult o2) {
					EList<String> c1 = o1.getCategory();
					EList<String> c2 = o2.getCategory();
					
					for (int i = 0; i < Math.min(c1.size(), c2.size()); ++i) {
						int cmp = c1.get(i).compareTo(c2.get(i));
						if (cmp != 0) {
							return cmp;
						}
					}
					
					int cmp = c1.size() - c2.size();
					if (cmp != 0) {
						return cmp;
					}
					
					cmp = o1.getTitle().compareTo(o2.getTitle());								
					return cmp == 0 ? o1.getQualifiedName().compareTo(o2.getQualifiedName()) : cmp;
				}
				
			});
			
			String prevCategoryStr = null;

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
			for (TestResult tr: testResults) {
				StringBuilder categoryStrBuilder = new StringBuilder();
				for (String ce: tr.getCategory()) {
					if (categoryStrBuilder.length() > 0) {
						categoryStrBuilder.append(" / ");
					}
					categoryStrBuilder.append(ce);
				}
				
				if (prevCategoryStr == null || !categoryStrBuilder.toString().equals(prevCategoryStr)) {
					prevCategoryStr = categoryStrBuilder.toString();
					if (!CoreUtil.isBlank(prevCategoryStr)) {
						resultsTable.body().row().header(StringEscapeUtils.escapeHtml4(prevCategoryStr)).colspan(4).style().background().color().bootstrapColor(Color.GRAY_LIGHTER);
					}
				}
				
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
