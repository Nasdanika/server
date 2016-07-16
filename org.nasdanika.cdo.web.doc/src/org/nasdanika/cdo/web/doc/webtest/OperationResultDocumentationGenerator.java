package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Carousel;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
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

	protected Fragment getIndex(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURL, urlPrefix, path);
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		
		ret.content(htmlFactory.div("<B>Status: </B>", operationStatusGlyph(obj.getStatus()), "&nbsp;", StringEscapeUtils.escapeHtml4(obj.getStatus().name())).style().margin().bottom("10px"));

		String resultID = htmlFactory.nextId();
		
//		allScreenshots()
//		getArguments()
//		getChildren()
//		getError()
//		getFailure()
//		getFinish()
//		getInstanceAlias()
//		getOperationName()
//		getResult()
//		getScreenshots()
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
				ret.content(screenshotCarousel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Video
		
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
		
		
		return ret;
	}

}
