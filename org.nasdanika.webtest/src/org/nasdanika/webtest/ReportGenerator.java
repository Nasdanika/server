package org.nasdanika.webtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.runners.Parameterized.Parameter;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.ApplicationPanel.ContentPanel;
import org.nasdanika.html.Carousel;
import org.nasdanika.html.Container;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.HTMLFactory.Placement;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Table.Row.Cell;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement.Color;
import org.nasdanika.html.UIElement.DeviceSize;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.html.impl.DefaultHTMLFactory;
import org.nasdanika.webtest.TestResult.TestStatus;

class ReportGenerator {

	private Class<?> klass;
	private Collection<? extends TestResult> testResults;
	private File outputDir;

	ReportGenerator(Class<?> klass, File outputDir, Collection<? extends TestResult> testResults) {
		this.klass = klass;
		this.outputDir = outputDir;
		this.testResults = testResults;
	}
	
	void generate() throws Exception {
		
		try (InputStream resourcesZipStream = new BufferedInputStream(TestClassResult.class.getResourceAsStream("WebContent.zip"))) {
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
		
		Report reportAnnotation = klass.getAnnotation(Report.class);
		int slideWidth = reportAnnotation==null ? 800 : reportAnnotation.slideWidth();
		
		int width = (int) ((slideWidth+32)*12.0/9.0);
		ApplicationPanel reportPanel = htmlFactory.applicationPanel()
				.style(Style.INFO) 
				.header(title)
				.headerLink("index.html")
				.footer("Generated "+new Date())
				.width(width); // Assuming large device
		
//		Navbar navBar = htmlFactory.navbar("Welcome!", objectPath+".html");
		
		int leftPanelWidth = (int) Math.round(250.0*12.0/width);

		ContentPanel leftPanel = reportPanel.contentPanel().width(DeviceSize.LARGE, leftPanelWidth);
		
		leftPanel.content(htmlFactory.routeLink("main", "content/summary.html", "<b>Summary</b>"), htmlFactory.tag("p"));
		
		
		File contentDir = new File(outputDir, "content");
		contentDir.mkdir();
		
		// TODO - test class methods threshold 
		leftPanel.content(htmlFactory.panel(Style.INFO, "Tests", generateTestsLeftPanel(htmlFactory, contentDir, true), null));
		
		// TODO - Actors, pages.
		
		reportPanel.contentPanel().id("main").width(DeviceSize.LARGE, 12 - leftPanelWidth);
		
		try (FileWriter indexWriter = new FileWriter(new File(outputDir, "index.html"))) {
			indexWriter.write(htmlFactory.routerApplication(
					title, 
					"main/content/summary.html", 
					null, 
					reportPanel).toString());
		}
		
		generateSummary(htmlFactory, contentDir);
		
		for (TestResult testResult: testResults) {
			generateTestResultDetails(testResult, htmlFactory, contentDir, slideWidth);
		}
		
		System.out.println("Nasdanika Web Test Report generated in "+outputDir.getAbsolutePath());		
	}
	
	protected void generateTestResultDetails(
			TestResult testResult, 
			DefaultHTMLFactory htmlFactory, 
			File contentDir, 
			int slideWidth) throws IOException {
		
		try (FileWriter testResultWriter = new FileWriter(new File(contentDir, "class_"+testResult.getId()+".html"))) {
			writeTitleAndDescription(testResult.getTestClass(), testResultWriter);
			if (testResult instanceof TestClassResult) {
				generateTestClassResultDetails((TestClassResult) testResult, htmlFactory, testResultWriter, contentDir, slideWidth);
			} else {
				generateTestSuiteResultDetails((TestSuiteResult) testResult, htmlFactory, testResultWriter, contentDir, slideWidth);
			}
		}
	}
	
	protected void generateTestSuiteResultDetails(
			TestSuiteResult testSuiteResult, 
			DefaultHTMLFactory htmlFactory, 
			Writer testResultWriter, 
			File contentDir, 
			int slideWidth) throws IOException {

		if (testSuiteResult instanceof ParameterizedTestResult) {
			testResultWriter.write(genParameterizedTestResultTable(htmlFactory, testSuiteResult).toString());
		} else {
			testResultWriter.write(genTestResultTable(htmlFactory, testSuiteResult.getChildren()).toString());
		}
		for (TestResult tr: testSuiteResult.getChildren()) {
			generateTestResultDetails(tr, htmlFactory, contentDir, slideWidth);
		}
	}

	protected void generateTestClassResultDetails(
			TestClassResult testClassResult, 
			DefaultHTMLFactory htmlFactory, 
			Writer testResultWriter, 
			File contentDir, 
			int slideWidth) throws IOException {
		
		Table methodTable = htmlFactory.table().bordered();
		Row headerRow = methodTable.row().style(Style.INFO);
		headerRow.header(htmlFactory.glyphicon(Glyphicon.cog), " Method");
		headerRow.header(htmlFactory.glyphicon(Glyphicon.file), " Description");
		headerRow.header(htmlFactory.glyphicon(Glyphicon.time), " Duration");
		for (TestMethodResult tmr: testClassResult.getTestMethodResults()) {
			tmr.genRow(htmlFactory, methodTable);
		}
		
		testResultWriter.write("<P>"+methodTable.toString());			
		
		for (TestMethodResult tmr: testClassResult.getTestMethodResults()) {
			generateTestMethodResultDetails(tmr, htmlFactory, contentDir, slideWidth);
		}		
	}

	private void writeTitleAndDescription(Class<?> klass, FileWriter testResultWriter) throws IOException {
		testResultWriter.write("<H3>");
		Title title = klass.getAnnotation(Title.class);
		if (title==null) {
			testResultWriter.write(classTitle(klass));
		} else {
			testResultWriter.write(title.value()); // TODO - format for parameterized
		}
		testResultWriter.write("</H3>");
		
		Description description = klass.getAnnotation(Description.class);
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
	}
	

	protected void generateTestMethodResultDetails(
			TestMethodResult testMethodResult, 
			DefaultHTMLFactory htmlFactory, 
			File contentDir, 
			int slideWidth) throws IOException {
		
		try (FileWriter testMethodResultWriter = new FileWriter(new File(contentDir, "method_"+testMethodResult.id+".html"))) {
			StringBuilder initScript = new StringBuilder();
			Carousel screenshotCarousel = htmlFactory.carousel()
					.ride(false)
					.indicatorsBackground(Color.GRAY)
					.attribute("data-interval", "false")
					.id(htmlFactory.nextId()+"_screenshotCarousel");
			List<ScreenshotEntry> allScreenshots = testMethodResult.allScreenshots();
			for (ScreenshotEntry se: allScreenshots) {
				String imageLocation = "screenshots/screenshot_"+se.id+".png";
				Tag imageTag = htmlFactory.tag("img").attribute("src", imageLocation);
				Tag link = htmlFactory.link(imageLocation, imageTag)
						.attribute("data-lightbox", "test-"+testMethodResult.id)
						.attribute("data-title", StringEscapeUtils.escapeHtml4(se.getTextCaption()));
				String caption = se.getHTMLCaption();
				if (se.methodResult!=null) {
					String descr = se.methodResult.getDescriptionHTML();
					if (descr!=null) {
						Tag comment = htmlFactory.glyphicon(Glyphicon.comment);
						comment.id(htmlFactory.nextId()+"_slide_comment");
						htmlFactory.tooltip(comment, Placement.TOP, descr);
						initScript.append("jQuery('#"+comment.getId()+"').tooltip({html:true});");
						caption+="&nbsp;";
						caption+=comment;		
					}
				}
				screenshotCarousel.slide()
					.content(link)
					.caption(htmlFactory.label(Style.INFO, caption).style("opacity", "0.7"));
			}
			testMethodResultWriter.write("<a name='carousel_"+screenshotCarousel.getId()+"'/>");
			testMethodResultWriter.write(screenshotCarousel.toString());
			
			Table methodTable = htmlFactory.table().bordered();
			Row headerRow = methodTable.row().style(Style.INFO);
			headerRow.header(htmlFactory.glyphicon(Glyphicon.cog), " Method");
			headerRow.header(htmlFactory.glyphicon(Glyphicon.file), " Description");
			headerRow.header(htmlFactory.glyphicon(Glyphicon.time), " Duration");
			testMethodResult.genRows(htmlFactory, methodTable, screenshotCarousel.getId(), allScreenshots, 0);
			testMethodResultWriter.write("<P>"+methodTable.toString());			
			if (initScript.length()>0) {
				testMethodResultWriter.write("<script>");
				testMethodResultWriter.write(initScript.toString());
				testMethodResultWriter.write("</script>");				
			}
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

	protected Tag generateTestsLeftPanel(HTMLFactory htmlFactory, File contentDir, boolean secondLevel) throws IOException {
		// TODO - categorize, sort alphabetically
		
		Tag container = htmlFactory.tag("dl");		
		for (TestResult testResult: testResults) {
			if (testResult instanceof TestClassResult) {
				generateTestClassResultLeftPanelEntry(
						(TestClassResult) testResult, 
						htmlFactory, 
						container,
						contentDir, 
						secondLevel);
			} else {
				generateTestSuiteResultLeftPanelEntry(
						(TestSuiteResult) testResult, 
						htmlFactory,
						container,
						contentDir, 
						secondLevel);				
			}
		}
		return container;
	}
	
	protected void generateTestClassResultLeftPanelEntry(
			TestClassResult testClassResult, 
			HTMLFactory htmlFactory, 
			Container<?> container, 
			File contentDir, 
			boolean secondLevel) {
		Tag testNameDD = htmlFactory.tag("dd", routeLink(testClassResult, htmlFactory)).style("font-weight", "bold");
		container.content(testNameDD); // TODO - Link to test class summary
		
		if (secondLevel) {
			for (TestMethodResult tmr : testClassResult.getTestMethodResults()) {
				container.content(htmlFactory.tag("dt", tmr.routeLink(htmlFactory, true)).style("padding-left", "15px"));
			}
		}
		
	}
	
	protected void generateTestSuiteResultLeftPanelEntry(
			TestSuiteResult testSuiteResult, 
			HTMLFactory htmlFactory, 
			Container<?> container, 
			File contentDir, 
			boolean secondLevel) {
		
		Tag testNameDD = htmlFactory.tag("dd", routeLink(testSuiteResult, htmlFactory)).style("font-weight", "bold");
		container.content(testNameDD); // TODO - Link to test class summary
		
		if (secondLevel && !(testSuiteResult instanceof ParameterizedTestResult)) {
			for (TestResult tr : testSuiteResult.getChildren()) {
				container.content(htmlFactory.tag("dt", routeLink(tr, htmlFactory)).style("padding-left", "15px"));
			}
		}
	}
	
	private Object routeLink(TestResult testResult, HTMLFactory htmlFactory) {
		StringBuilder nameBuilder = new StringBuilder();
		if (testResult instanceof TestClassResult) {
			nameBuilder.append(htmlFactory.glyphicon(Glyphicon.search));
		} else if (testResult instanceof ParameterizedTestResult) {
			nameBuilder.append(htmlFactory.glyphicon(Glyphicon.tasks));			
		} else {
			nameBuilder.append(htmlFactory.glyphicon(Glyphicon.folder_open));
		}
		
		nameBuilder.append("&nbsp;");			
			
		Title testTitle = testResult.getTestClass().getAnnotation(Title.class);
		if (testTitle==null) {
			nameBuilder.append(ReportGenerator.classTitle(testResult.getTestClass()));
		} else {
			nameBuilder.append(testTitle.value());
		}
		
		return htmlFactory.routeLink("main", "content/class_"+testResult.getId()+".html", nameBuilder);
	}	

	protected void generateSummary(HTMLFactory htmlFactory, File contentDir) throws IOException {
		try (FileWriter summaryWriter = new FileWriter(new File(contentDir, "summary.html"))) {
			summaryWriter.write("<H3>Summary</H3>");
			Table classTable = genTestResultTable(htmlFactory, testResults);			
			summaryWriter.write(classTable.toString());
		}
	}

	private Table genTestResultTable(HTMLFactory htmlFactory, Collection<? extends TestResult> testResults) {
		Table classTable = htmlFactory.table().bordered();
		Row header = classTable.row().style(Style.INFO);
		int[] totals = {0, 0, 0, 0};
		header.header(htmlFactory.glyphicon(Glyphicon.search), "&nbsp;Test class");
		header.header(htmlFactory.glyphicon(Glyphicon.file), "&nbsp;Description");
		header.header(htmlFactory.glyphicon(Glyphicon.ok), "&nbsp;Pass");
		header.header(htmlFactory.glyphicon(Glyphicon.remove), "&nbsp;Fail");
		header.header(htmlFactory.glyphicon(Glyphicon.warning_sign), "&nbsp;Error");
		header.header(htmlFactory.glyphicon(Glyphicon.time), "&nbsp;Pending");
		for (TestResult tr: testResults) {
			Row classRow = classTable.row();
			classRow.cell(routeLink(tr, htmlFactory));
			Cell descriptionCell = classRow.cell();
			Description description = tr.getTestClass().getAnnotation(Description.class);
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
			Map<TestStatus, Integer> stats = tr.getStats();
			classRow.cell(stats.get(TestStatus.Pass)).attribute("align", "center");
			classRow.cell(stats.get(TestStatus.Fail)).attribute("align", "center");
			classRow.cell(stats.get(TestStatus.Error)).attribute("align", "center");
			classRow.cell(stats.get(TestStatus.Pending)).attribute("align", "center");
			for (int i=0; i<totals.length; ++i) {
				totals[i]+=stats.get(TestStatus.values()[i]);
			}
		}
		Row totalsRow = classTable.row().style(Style.INFO);
		totalsRow.cell("Total").colspan(2);
		totalsRow.cell(totals[0]).attribute("align", "center");
		totalsRow.cell(totals[1]).attribute("align", "center");
		totalsRow.cell(totals[2]).attribute("align", "center");
		totalsRow.cell(totals[3]).attribute("align", "center");
		return classTable;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends Annotation> T getParameterAnnotation(Annotation[] panns, Class<T> annType) {
		for (Annotation a: panns) {
			if (annType.isInstance(a)) {
				return (T) a;
			}
		}
		
		return null;
	}
	
	private Object genParameterizedTestResultTable(HTMLFactory htmlFactory, TestSuiteResult testSuiteResult) {
		Table classTable = htmlFactory.table().bordered();
		Row header = classTable.row().style(Style.INFO);
		int[] totals = {0, 0, 0, 0};
		
		List<Field> paramFields = new ArrayList<>();
		for (Field f: testSuiteResult.getTestClass().getFields()) {
			if (f.getAnnotation(Parameter.class)!=null) {
				paramFields.add(f);
			}
		}
		
		// { title, description}
		List<String[]> paramInfo = new ArrayList<>();
		
		if (paramFields.isEmpty()) {
			Constructor<?> constructor = testSuiteResult.getTestClass().getConstructors()[0];
			Annotation[][] pann = constructor.getParameterAnnotations();
			Class<?>[] pt = constructor.getParameterTypes();
			for (int i=0; i<pt.length; ++i) {
				 paramInfo.add(createParamInfo(String.valueOf(i), getParameterAnnotation(pann[i], Title.class), getParameterAnnotation(pann[i], Description.class)));
			}
		} else {
			Collections.sort(paramFields, new Comparator<Field>() {

				@Override
				public int compare(Field o1, Field o2) {
					return o1.getAnnotation(Parameter.class).value() - o2.getAnnotation(Parameter.class).value();
				}
				
			});
			
			for (Field f: paramFields) {
				 paramInfo.add(createParamInfo(f.getName(), f.getAnnotation(Title.class), f.getAnnotation(Description.class)));
			}
		}
		
		header.header("#").rowspan(2);
		
		header.header("Parameters").colspan(paramInfo.size());
		
		header.header(htmlFactory.glyphicon(Glyphicon.ok), "&nbsp;Pass").rowspan(2);
		header.header(htmlFactory.glyphicon(Glyphicon.remove), "&nbsp;Fail").rowspan(2);
		header.header(htmlFactory.glyphicon(Glyphicon.warning_sign), "&nbsp;Error").rowspan(2);
		header.header(htmlFactory.glyphicon(Glyphicon.time), "&nbsp;Pending").rowspan(2);
		
		StringBuilder tooltipInitializers = new StringBuilder();
		
		Row paramNamesRow = classTable.row().style(Style.INFO);
		for (String[] pi: paramInfo) {
			Object prmHeader = pi[0];
			if (pi[1] != null && pi[1].trim().length()!=0) {
				prmHeader = htmlFactory.span(prmHeader);
				htmlFactory.tooltip((Tag) prmHeader, Placement.TOP, pi[1]);
				((Tag) prmHeader).id("parameterHeader_"+htmlFactory.nextId());
				tooltipInitializers.append("$('#"+((Tag) prmHeader).getId()+"').tooltip();");
			}
			paramNamesRow.header(prmHeader);
		}
		int testIdx = 1;
		for (TestResult tr: testSuiteResult.getChildren()) {
			@SuppressWarnings("resource")
			TestClassResult tcr = (TestClassResult) tr;
			if (!tcr.getTestMethodResults().isEmpty()) {
				Row classRow = classTable.row();
				classRow.cell(htmlFactory.routeLink("main", "content/class_"+tr.getId()+".html", testIdx++));

				TestMethodResult firstTest = tcr.getTestMethodResults().get(0);
				int idx = 0;
				for (Object prm: firstTest.getParameters()) {
					if (firstTest.getTarget() instanceof ParameterRenderer) {
						prm = ((ParameterRenderer) firstTest.getTarget()).renderParameter(idx, prm, outputDir);
					}
					classRow.cell(prm);
					idx++;
				}
				
				Map<TestStatus, Integer> stats = tr.getStats();
				// TODO - parameter values, render to HTML.
				classRow.cell(stats.get(TestStatus.Pass)).attribute("align", "center");
				classRow.cell(stats.get(TestStatus.Fail)).attribute("align", "center");
				classRow.cell(stats.get(TestStatus.Error)).attribute("align", "center");
				classRow.cell(stats.get(TestStatus.Pending)).attribute("align", "center");
				for (int i=0; i<totals.length; ++i) {
					totals[i]+=stats.get(TestStatus.values()[i]);
				}
			}
		}
		Row totalsRow = classTable.row().style(Style.INFO);
		totalsRow.cell("Total").colspan(paramInfo.size()+1);
		totalsRow.cell(totals[0]).attribute("align", "center");
		totalsRow.cell(totals[1]).attribute("align", "center");
		totalsRow.cell(totals[2]).attribute("align", "center");
		totalsRow.cell(totals[3]).attribute("align", "center");
		
		if (tooltipInitializers.length()==0) {
			return classTable;
		}
		
		return classTable+" "+htmlFactory.tag("script", tooltipInitializers);
	}

	private String[] createParamInfo(String name, Title title, Description description) {
		String[] pi = { null, null };
		if (title==null) {
			pi[0] = title(name);
		} else {
			pi[0] = title.value();
		}
		
		if (description!=null) {
			StringBuilder descriptionBuilder = new StringBuilder();
			if (description.html()) {
				for (String str: description.value()) {
					descriptionBuilder.append(str);
					descriptionBuilder.append(" ");
				}
			} else {
				descriptionBuilder.append("<pre>");
				int idx = 0;
				for (String str: description.value()) {
					if (idx++>0) {
						descriptionBuilder.append(System.lineSeparator());
					}
					descriptionBuilder.append(StringEscapeUtils.escapeHtml4(str));
				}
				descriptionBuilder.append("</pre>");			
			}
			pi[1] = descriptionBuilder.toString();
		}
		return pi;
	}
}
