package org.nasdanika.webtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.ApplicationPanel.ContentPanel;
import org.nasdanika.html.Carousel;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement.Color;
import org.nasdanika.html.UIElement.DeviceSize;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.html.impl.DefaultHTMLFactory;

class ReportGenerator {

	private Class<?> klass;
	private Collection<TestResult> testResults;
	private File outputDir;

	ReportGenerator(Class<?> klass, File outputDir, Collection<TestResult> testResults) {
		this.klass = klass;
		this.outputDir = outputDir;
		this.testResults = testResults;
	}
	
	void generate() throws Exception {
		
		try (InputStream resourcesZipStream = new BufferedInputStream(TestResult.class.getResourceAsStream("WebContent.zip"))) {
			if (resourcesZipStream!=null) {
				try (ZipInputStream resourceStream = new ZipInputStream(resourcesZipStream)) {
					ZipEntry entry;
					while ((entry = resourceStream.getNextEntry())!=null) {
						File rOutFile = new File(outputDir, entry.getName().replace('/', File.separatorChar));
						if (entry.isDirectory()) {
							rOutFile.mkdirs();
						} else {
							try (OutputStream rOut = new BufferedOutputStream(new FileOutputStream(rOutFile))) {
								for (int data = resourceStream.read(); data!=-1; data = resourceStream.read()) {
									rOut.write(data);
								}
							}
						}
					}
				}
			}
		}
		
		DefaultHTMLFactory htmlFactory = new DefaultHTMLFactory();
		
		htmlFactory.getStylesheets().add("bootstrap/css/bootstrap.min.css");
		htmlFactory.getStylesheets().add("bootstrap/css/bootstrap-theme.min.css");
		htmlFactory.getStylesheets().add("css/lightbox.css");
		
		htmlFactory.getScripts().add("js/jquery-2.1.0.min.js");
		htmlFactory.getScripts().add("js/underscore-min.js");
		htmlFactory.getScripts().add("js/backbone-min.js");
		htmlFactory.getScripts().add("bootstrap/js/bootstrap.min.js");
		htmlFactory.getScripts().add("js/require.js");
		htmlFactory.getScripts().add("js/lightbox.min.js");
		
		Title titleAnnotation = klass.getAnnotation(Title.class);
		String title;
		if (titleAnnotation==null) {
			String className = klass.getName();
			title = "Test report: "+className.substring(className.lastIndexOf('.')+1);
		} else {
			title = titleAnnotation.value();
		}
		
		ApplicationPanel reportPanel = htmlFactory.applicationPanel()
				.style(Style.INFO) 
				.header(title)
				.headerLink("index.html")
				.footer("Generated "+new Date());
		
//		Navbar navBar = htmlFactory.navbar("Welcome!", objectPath+".html"); 

		ContentPanel leftPanel = reportPanel.contentPanel()
				.width(DeviceSize.SMALL, 4)
				.width(DeviceSize.MEDIUM, 3)
				.width(DeviceSize.LARGE, 2);
		
		leftPanel.content(htmlFactory.routeLink("main", "content/summary.html", "<b>Summary</b>"), htmlFactory.tag("p"));
		
		
		File contentDir = new File(outputDir, "content");
		contentDir.mkdir();
		
		// TODO - test class methods threshold 
		leftPanel.content(htmlFactory.panel(Style.INFO, "Tests", generateTestsLeftPanel(htmlFactory, contentDir, true), null));
		
		// TODO - Actors, pages.
		
		reportPanel.contentPanel()
			.id("main")
			.width(DeviceSize.SMALL, 8)
			.width(DeviceSize.MEDIUM, 9)
			.width(DeviceSize.LARGE, 10);
		
		try (FileWriter indexWriter = new FileWriter(new File(outputDir, "index.html"))) {
			indexWriter.write(htmlFactory.routerApplication(
					title, 
					"main/content/summary.html", 
					null, 
					reportPanel).toString());
		}
		
		generateSummary(htmlFactory, contentDir);
		
		Report reportAnnotation = klass.getAnnotation(Report.class);
		int slideWidth = reportAnnotation==null ? 800 : reportAnnotation.slideWidth(); 
		
		for (TestResult testResult: testResults) {
			generateTestResultDetails(testResult, htmlFactory, contentDir);
			for (TestMethodResult tmr: testResult.testMethodResults) {
				generateTestMethodResultDetails(tmr, htmlFactory, contentDir, slideWidth);
			}
		}
		
		System.out.println("Nasdanika Web Test Report generated in "+outputDir.getAbsolutePath());		
	}

	protected void generateTestMethodResultDetails(
			TestMethodResult testMethodResult, 
			DefaultHTMLFactory htmlFactory, 
			File contentDir, 
			int slideWidth) throws IOException {
		
		try (FileWriter testMethodResultWriter = new FileWriter(new File(contentDir, "method_"+testMethodResult.id+".html"))) {
			Carousel screenshotCarousel = htmlFactory.carousel()
					.ride(false)
					.indicatorsBackground(Color.GRAY).style("width", slideWidth+"px")
					.attribute("data-interval", "false");
			for (ScreenshotEntry se: testMethodResult.allScreenshots()) {
				String imageLocation = "screenshots/screenshot_"+se.id+".png";
				Tag imageTag = htmlFactory.tag("img").attribute("src", imageLocation);
				Tag link = htmlFactory.link(imageLocation, imageTag)
						.attribute("data-lightbox", "test-"+testMethodResult.id)
						.attribute("data-title", StringEscapeUtils.escapeHtml4(se.getCaption()));
				screenshotCarousel.slide()
					.content(link)
					.caption(htmlFactory.label(Style.INFO, se.getCaption()).style("opacity", "0.7"));
			}
			testMethodResultWriter.write(htmlFactory.div(screenshotCarousel).addClass("container").toString());
			//testMethodResultWriter.write("<script>jQuery('#"+slideCarousel.getId()+"').carousel();</script>");
		}
	}

	protected void generateTestResultDetails(TestResult testResult, DefaultHTMLFactory htmlFactory, File contentDir) throws IOException {
		try (FileWriter testMethodResultWriter = new FileWriter(new File(contentDir, "class_"+testResult.id+".html"))) {
			testMethodResultWriter.write("TODO - Test result - "+testResult);
		}
	}

	protected Tag generateTestsLeftPanel(HTMLFactory htmlFactory, File contentDir, boolean includeMetodResults) throws IOException {
		// TODO - categorize, sort alphabetically
		
		Tag testsDL = htmlFactory.tag("dl");		
		for (TestResult testResult: testResults) {
			StringBuilder nameBuilder = new StringBuilder();
			Title testTitle = testResult.klass.getAnnotation(Title.class);
			if (testTitle==null) {
				String shortClassName = testResult.klass.getName().substring(testResult.klass.getName().lastIndexOf('.')+1);
				String[] scna = StringUtils.splitByCharacterTypeCamelCase(shortClassName);
				for (int i=0; i<scna.length; ++i) {
					if (i==0) {
						nameBuilder.append(StringUtils.capitalize(scna[i]));
					} else {
						nameBuilder.append(" ");
						if (scna[i].length()>1 && Character.isUpperCase(scna[i].charAt(1))) {
							nameBuilder.append(scna[i]);
						} else {
							nameBuilder.append(StringUtils.uncapitalize(scna[i]));
						}
					}
				}
			} else {
				nameBuilder.append(testTitle.value());
			}
			
			Tag testNameDD = htmlFactory.tag("dd", htmlFactory.routeLink("main", "content/class_"+testResult.id+".html", nameBuilder)).style("font-weight", "bold");
			testsDL.content(testNameDD); // TODO - Link to test class summary
			
			if (includeMetodResults) {
				for (TestMethodResult tmr : testResult.testMethodResults) {
					String name = "";
					Title mTitle = tmr.method.getAnnotation(Title.class);
					if (mTitle == null) {
						String[] na = StringUtils.splitByCharacterTypeCamelCase(tmr.method.getName());
						for (int i=0; i<na.length; ++i) {
							if (i==0) {
								name = StringUtils.capitalize(na[i]);
							} else {
								name += " ";
								if (na[i].length()>1 && Character.isUpperCase(na[i].charAt(1))) {
									name += na[i];
								} else {
									name += StringUtils.uncapitalize(na[i]);
								}
							}
						}					
					} else {
						name = mTitle.value();
					}
					
					Object methodLabel;
					String methodDetailsLocation = "content/method_"	+ tmr.id + ".html";
					if (tmr.failure==null) {
						if (tmr.allScreenshots().size()==1 || tmr.childResults.isEmpty()) { // Only the first screenshot or no calls to actor/page methods.
							methodLabel = htmlFactory.span(
									htmlFactory.glyphicon(Glyphicon.time), 
									"&nbsp;", 
									name).style("color", Color.GRAY.code);
							
						} else {
							methodLabel = htmlFactory.routeLink(
									"main", 
									methodDetailsLocation, 
									htmlFactory.glyphicon(Glyphicon.ok), 
									"&nbsp;", 
									name).style("color", Color.SUCCESS.code);
							
						}
					} else {
						methodLabel = htmlFactory.routeLink(
								"main", 
								methodDetailsLocation, 
								htmlFactory.glyphicon(Glyphicon.remove), 
								"&nbsp;", 
								name).style("color", Color.DANGER.code);
						
					}
					testsDL.content(htmlFactory.tag("dt", methodLabel).style("padding-left", "15px"));
	
					try (FileWriter methodWriter = new FileWriter(new File(contentDir, "method_" + tmr.id + ".html"))) {
						methodWriter.write("TODO - method results and carousel");
					}
	
				}
			}
		}
		return testsDL;
	}

	protected void generateSummary(HTMLFactory htmlFactory, File contentDir) throws IOException {
		try (FileWriter summaryWriter = new FileWriter(new File(contentDir, "summary.html"))) {
			summaryWriter.write("TODO - I'm the SUMMARY!");
		}
	}
	
}
