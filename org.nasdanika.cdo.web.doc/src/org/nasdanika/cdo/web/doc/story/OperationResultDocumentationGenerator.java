package org.nasdanika.cdo.web.doc.story;

import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Carousel;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.OperationResult;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.ScreenshotEntry;

class OperationResultDocumentationGenerator<T extends OperationResult> implements StoryElementDocumentationGenerator<T> {

	protected StoryDocumentationGenerator storyDocumentationGenerator;

	protected OperationResultDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public void createToc(T operationResult, TocNode parent) {
		try {
			parent.createChild(
					operationResult.getTitle(), 
					storyDocumentationGenerator.getObjectPath(operationResult)+"/index.html",
					getIcon(), 
					null,
					obj -> obj == operationResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getIcon() {
		return null;
	}
			
	@Override
	public Object getContent(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		if (path.endsWith("/index.html")) {
			return getIndex(obj, context, baseURL, urlPrefix, path).toString();
		}
		
		return Action.NOT_FOUND;
	}

	protected Fragment getIndex(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Fragment ret = htmlFactory.fragment(
			htmlFactory.tag(
					TagName.h3, 
					htmlFactory.tag(TagName.img).attribute("src", storyDocumentationGenerator.getDocRoute().getDocRoutePath()+getIcon()).style().margin().right("5px"),
					StringEscapeUtils.escapeHtml4(obj.getTitle())));
		
		ret.content(htmlFactory.div("<B>Status: </B>", StringEscapeUtils.escapeHtml4(obj.getStatus().name())).style().margin().bottom("10px"));

		String resultID = htmlFactory.nextId();
		
		// TODO - description
//		if (!CoreUtil.isBlank(obj.getDescription())) {
//			ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(baseURL, urlPrefix, obj.getDescription()).style().margin().top("10px").style().margin().bottom("10px"));
//		}
		
		// Tab
		// Screenshots
		Carousel screenshotCarousel = htmlFactory.carousel()
				.ride(false)
				.indicatorsBackground(Bootstrap.Color.GRAY)
				.attribute("data-interval", "false")
				.id(resultID+"_screenshotCarousel");
		
		try {
			Screenshot prev = null;
			for (ScreenshotEntry screenshotEntry: obj.allScreenshots()) {
				Screenshot screenshot = screenshotEntry.getScreenshot();
				if (prev != screenshot) {
					prev = screenshot;
					String imageLocation = storyDocumentationGenerator.resolveScreenshotLocation(screenshot);
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
					screenshotCarousel.slide()
						.content(link);
	//					.caption(htmlFactory.label(Bootstrap.Style.INFO, se.getComment()).style("opacity", "0.7"));
				}
			}
			
	//		testMethodResultWriter.write("<a name='carousel_"+screenshotCarousel.getId()+"'/>");
			ret.content(screenshotCarousel);
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
