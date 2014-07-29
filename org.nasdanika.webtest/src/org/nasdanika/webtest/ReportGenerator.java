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
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Table.Row.Cell;
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
						.attribute("data-title", StringEscapeUtils.escapeHtml4(se.getTextCaption()));
				screenshotCarousel.slide()
					.content(link)
					.caption(htmlFactory.label(Style.INFO, se.getHTMLCaption()).style("opacity", "0.7"));
			}
			testMethodResultWriter.write(htmlFactory.div(screenshotCarousel).addClass("container").toString());
			
			Table methodTable = htmlFactory.table().bordered();
			Row headerRow = methodTable.row().style(Style.INFO);
			headerRow.header(htmlFactory.glyphicon(Glyphicon.cog), " Method");
			headerRow.header(htmlFactory.glyphicon(Glyphicon.file), " Description");
			headerRow.header(htmlFactory.glyphicon(Glyphicon.time), " Duration");
			testMethodResult.genRows(htmlFactory, methodTable, 0);
			testMethodResultWriter.write("<P>"+methodTable.toString());			
		}
	}

	protected void generateTestResultDetails(TestResult testResult, DefaultHTMLFactory htmlFactory, File contentDir) throws IOException {
		try (FileWriter testResultWriter = new FileWriter(new File(contentDir, "class_"+testResult.id+".html"))) {
			testResultWriter.write("<H3>");
			testResultWriter.write(classTitle(testResult.klass));
			testResultWriter.write("</H3>");
			
			Description description = testResult.klass.getAnnotation(Description.class);
			if (description!=null) {
				if (description.html()) {
					for (String str: description.value()) {
						testResultWriter.write(str);
						testResultWriter.write(" ");
					}
				} else {
					testResultWriter.write("<pre>");
					int idx = 0;
					for (String str: description.value()) {
						if (idx++>0) {
							testResultWriter.write(System.lineSeparator());
						}
						testResultWriter.write(StringEscapeUtils.escapeHtml4(str));
					}
					testResultWriter.write("</pre>");			
				}
			}
			
			Table methodTable = htmlFactory.table().bordered();
			Row headerRow = methodTable.row().style(Style.INFO);
			headerRow.header(htmlFactory.glyphicon(Glyphicon.cog), " Method");
			headerRow.header(htmlFactory.glyphicon(Glyphicon.file), " Description");
			headerRow.header(htmlFactory.glyphicon(Glyphicon.time), " Duration");
			for (TestMethodResult tmr: testResult.testMethodResults) {
				tmr.genRow(htmlFactory, methodTable);
			}
			
			testResultWriter.write("<P>"+methodTable.toString());			

		}
	}
	
	static String classTitle(Class<?> klass) {
		return title(klass.getName().substring(klass.getName().lastIndexOf('.')+1));		
	}
	
	static String title(String name) {
		StringBuilder titleBuilder = new StringBuilder();
		String[] scna = StringUtils.splitByCharacterTypeCamelCase(name);
		for (int i=0; i<scna.length; ++i) {
			if (i==0) {
				titleBuilder.append(StringUtils.capitalize(scna[i]));
			} else {
				titleBuilder.append(" ");
				if (scna[i].length()>1 && Character.isUpperCase(scna[i].charAt(1))) {
					titleBuilder.append(scna[i]);
				} else {
					titleBuilder.append(StringUtils.uncapitalize(scna[i]));
				}
			}
		}
		return titleBuilder.toString();
	}

	protected Tag generateTestsLeftPanel(HTMLFactory htmlFactory, File contentDir, boolean includeMetodResults) throws IOException {
		// TODO - categorize, sort alphabetically
		
		Tag testsDL = htmlFactory.tag("dl");		
		for (TestResult testResult: testResults) {
			StringBuilder nameBuilder = new StringBuilder();
			Title testTitle = testResult.klass.getAnnotation(Title.class);
			if (testTitle==null) {
				nameBuilder.append(classTitle(klass));
			} else {
				nameBuilder.append(testTitle.value());
			}
			
			Tag testNameDD = htmlFactory.tag("dd", htmlFactory.routeLink("main", "content/class_"+testResult.id+".html", nameBuilder)).style("font-weight", "bold");
			testsDL.content(testNameDD); // TODO - Link to test class summary
			
			if (includeMetodResults) {
				for (TestMethodResult tmr : testResult.testMethodResults) {
					testsDL.content(htmlFactory.tag("dt", tmr.routeLink(htmlFactory, true)).style("padding-left", "15px"));
				}
			}
		}
		return testsDL;
	}

	protected void generateSummary(HTMLFactory htmlFactory, File contentDir) throws IOException {
		try (FileWriter summaryWriter = new FileWriter(new File(contentDir, "summary.html"))) {
			summaryWriter.write("<H3>Summary</H3>");
			Table classTable = htmlFactory.table().bordered();
			Row header = classTable.row().background(Color.PRIMARY);
			int[] totals = {0, 0, 0};
			header.header(htmlFactory.glyphicon(Glyphicon.search), "&nbsp;Test class");
			header.header(htmlFactory.glyphicon(Glyphicon.file), "&nbsp;Description");
			header.header(htmlFactory.glyphicon(Glyphicon.ok), "&nbsp;Success");
			header.header(htmlFactory.glyphicon(Glyphicon.remove), "&nbsp;Fail");
			header.header(htmlFactory.glyphicon(Glyphicon.time), "&nbsp;Pending");
			for (TestResult tr: testResults) {
				Row classRow = classTable.row();
				classRow.cell(htmlFactory.routeLink("main", "content/class_"+tr.id+".html", classTitle(tr.klass)));
				Cell descriptionCell = classRow.cell();
				Description description = tr.klass.getAnnotation(Description.class);
				if (description==null) {
					descriptionCell.content("&nbsp;");
				} else if (description.html()) {
					for (String str: description.value()) {
						descriptionCell.content(str, " ");
					}
				} else {
					descriptionCell.content("<pre>");
					int idx = 0;
					for (String str: description.value()) {
						if (idx++>0) {
							descriptionCell.content(System.lineSeparator());
						}
						descriptionCell.content(StringEscapeUtils.escapeHtml4(str));
					}
					descriptionCell.content("</pre>");			
				}
				int[] stats = tr.getStats();
				classRow.cell(stats[0]).attribute("align", "center");
				classRow.cell(stats[1]).attribute("align", "center");
				classRow.cell(stats[2]).attribute("align", "center");
				for (int i=0; i<totals.length; ++i) {
					totals[i]+=stats[i];
				}
			}
			Row totalsRow = classTable.row().style(Style.INFO);
			totalsRow.cell("Total").colspan(2);
			totalsRow.cell(totals[0]).attribute("align", "center");
			totalsRow.cell(totals[1]).attribute("align", "center");
			totalsRow.cell(totals[2]).attribute("align", "center");
			
			summaryWriter.write(classTable.toString());
		}
	}
	
}
