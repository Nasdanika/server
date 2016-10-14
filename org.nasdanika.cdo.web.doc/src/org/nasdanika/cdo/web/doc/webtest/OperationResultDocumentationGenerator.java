package org.nasdanika.cdo.web.doc.webtest;

import java.util.Collection;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Carousel;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.OperationResult;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.ScreenshotEntry;

abstract class OperationResultDocumentationGenerator<T extends OperationResult> extends DescriptorDocumentationGenerator<T> {

	protected OperationResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}		

	@Override
	protected Fragment getIndex(T obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURI, urlPrefix, path);
		HTMLFactory htmlFactory = ret.getFactory();
		
		ret.content(htmlFactory.div("<B>Status: </B>", operationStatusGlyph(obj.getStatus()), "&nbsp;", StringEscapeUtils.escapeHtml4(obj.getStatus().name())).style().margin().bottom("10px"));

		String resultID = htmlFactory.nextId();
		
		Tabs tabs = htmlFactory.tabs();
		
//		allScreenshots()
//		getArguments()
//		getChildren()
//		getError()
//		getFailure()
//		getFinish()
//		getInstanceAlias()
//		getOperationName()
//		getResult()
//		getStart()
				
		
		// Tab
		// Screenshots
		Carousel screenshotCarousel = htmlFactory.carousel()
				.ride(false)
				.indicatorsBackground(Bootstrap.Color.GRAY)
				.attribute("data-interval", "false")
				.id(resultID+"_screenshotCarousel");
		
		try {
			Screenshot prev = null;
			boolean hasSlides = false;
			for (ScreenshotEntry screenshotEntry: obj.allScreenshots()) {
				Screenshot screenshot = screenshotEntry.getScreenshot();
				if (prev != screenshot) {
					prev = screenshot;
					String imageLocation = testResultsDocumentationGenerator.resolveScreenshotLocation(screenshot);
					Tag imageTag = htmlFactory.tag(TagName.img).attribute("src", imageLocation).style("margin", "auto");
					Tag link = htmlFactory.link(imageLocation, imageTag)
							.attribute("data-lightbox", "test-"+resultID);
	//						.attribute("data-title", StringEscapeUtils.escapeHtml4(se.getComment())); // TODO 
		//			String caption = se.getHTMLCaption();
		//			if (se.operationResult!=null) {
		//				String descr = se.operationResult.getDescriptionHTML();
		//				if (descr!=null) {
		//					Tag comment = htmlFactory.glyphicon(Glyphicon.comment);
		//					comment.id(htmlFactory.nextId()+"_slide_comment");
		//					htmlFactory.tooltip(comment, Placement.TOP, descr);
		//					initScript.append("jQuery('#"+comment.getId()+"').tooltip({html:true});");
		//					caption+="&nbsp;";
		//					caption+=comment;		
		//				}
		//			}
					hasSlides = true;
					screenshotCarousel.slide()
						.content(link);
	//					.caption(htmlFactory.label(Bootstrap.Style.INFO, se.getComment()).style("opacity", "0.7"));
				}
			}
			
	//		testMethodResultWriter.write("<a name='carousel_"+screenshotCarousel.getId()+"'/>");
			if (hasSlides) {
				tabs.item("Screenshots", screenshotCarousel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!obj.getChildren().isEmpty()) {
			Table childrenTable = htmlFactory.table().bordered();
			childrenTable.header().headerRow("Instance", "Method", "Duration").style(Bootstrap.Style.INFO);
			for (OperationResult ch: obj.getChildren()) {
				generateCallsRows(ch, 0, childrenTable.body());
			}
			tabs.item("Calls", childrenTable);						
		}
		
		// Video
//		getScreenshots() -> SWF, speech generation (Mary TTS)
		
		// Tab
		// Calls
				
		// Seq diag
		
//		StringBuilder initScript = new StringBuilder();
//		Carousel screenshotCarousel = htmlFactory.carousel()
//				.ride(false)
//				.indicatorsBackground(Bootstrap.Color.GRAY)
//				.attribute("data-interval", "false")
//				.id(htmlFactory.nextId()+"_screenshotCarousel");
//		List<ScreenshotEntry> allScreenshots = testMethodResult.allScreenshots();
//		for (ScreenshotEntry se: allScreenshots) {
//			String imageLocation = "screenshots/screenshot_"+se.getId()+".png";
//			Tag imageTag = htmlFactory.tag(TagName.img).attribute("src", imageLocation).style("margin", "auto");
//			Tag link = htmlFactory.link(imageLocation, imageTag)
//					.attribute("data-lightbox", "test-"+testMethodResult.getId())
//					.attribute("data-title", StringEscapeUtils.escapeHtml4(se.getTextCaption()));
//			String caption = se.getHTMLCaption();
//			if (se.operationResult!=null) {
//				String descr = se.operationResult.getDescriptionHTML();
//				if (descr!=null) {
//					Tag comment = htmlFactory.glyphicon(Glyphicon.comment);
//					comment.id(htmlFactory.nextId()+"_slide_comment");
//					htmlFactory.tooltip(comment, Placement.TOP, descr);
//					initScript.append("jQuery('#"+comment.getId()+"').tooltip({html:true});");
//					caption+="&nbsp;";
//					caption+=comment;		
//				}
//			}
//			screenshotCarousel.slide()
//				.content(link)
//				.caption(htmlFactory.label(Bootstrap.Style.INFO, caption).style("opacity", "0.7"));
//		}
//		testMethodResultWriter.write("<a name='carousel_"+screenshotCarousel.getId()+"'/>");
//		testMethodResultWriter.write(screenshotCarousel.toString());
//		
//		Table methodTable = htmlFactory.table().bordered();
//		Row headerRow = methodTable.row().style(Bootstrap.Style.INFO);
//		headerRow.header(htmlFactory.glyphicon(Glyphicon.cog), " Method");
//		headerRow.header(htmlFactory.glyphicon(Glyphicon.file), " Description");
//		headerRow.header(htmlFactory.glyphicon(Glyphicon.time), " Duration");
//		testMethodResult.genRows(htmlFactory, methodTable, screenshotCarousel.getId(), allScreenshots, 0);
//		testMethodResultWriter.write("<P>"+methodTable.toString());			
//		if (initScript.length()>0) {
//			testMethodResultWriter.write("<script>");
//			testMethodResultWriter.write(initScript.toString());
//			testMethodResultWriter.write("</script>");				
//		}
		
		if (!tabs.isEmpty()) {
			ret.content(tabs);
		}
		
		return ret;
	}
	
	protected void generateCallsRows(OperationResult operationResult, int indent, RowContainer<?> rowContainer) {
		StringBuilder ib = new StringBuilder();
		for (int i=0; i<indent*4; ++i) {
			ib.append("&nbsp");
		}
		Row row = rowContainer.row();
		StringBuilder aliasPathBuilder = new StringBuilder();
		for (String ape: operationResult.getInstanceAliasPath()) {
			if (aliasPathBuilder.length() > 0) {
				aliasPathBuilder.append(" / ");
			}
			aliasPathBuilder.append(ape);
		}
		row.cell(aliasPathBuilder).style().text().align().center();
		TocNode toc = testResultsDocumentationGenerator.getDocRoute().findToc(operationResult);
		row.cell(ib, toc == null ? operationResult.getTitle() : toc.getLink(testResultsDocumentationGenerator.getDocRoute().getDocRoutePath()));
		row.cell(operationResult.getFinish() - operationResult.getStart()).style().text().align().right();
		
		for (OperationResult child: operationResult.getChildren()) {
			generateCallsRows(child, indent+1, rowContainer);
		}
	}
	
	@Override
	protected Collection<? extends EObject> getTocChildren(T operationResult) {
		return operationResult.getChildren();
	}
	
	@Override
	protected boolean isTocHidden(T operationResult) {
		return true;
	}

}
