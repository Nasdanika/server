package org.nasdanika.webtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.ApplicationPanel.ContentPanel;
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
				.width(DeviceSize.SMALL, 3)
				.width(DeviceSize.MEDIUM, 2)
				.width(DeviceSize.LARGE, 1);
		
		leftPanel.content(htmlFactory.routeLink("main", "content/summary.html", "Summary"), htmlFactory.tag("p"));
		
		
		File contentDir = new File(outputDir, "content");
		contentDir.mkdir();
		
//		Tag testsList = htmlFactory.tag("OL");
//		for (TestMethodResult tmr: testMethodResults) {
//			String name;
//			Title mTitle = tmr.method.getAnnotation(Title.class);
//			if (mTitle==null) {
//				name = tmr.method.getName();
//			} else {
//				name = mTitle.value();
//			}
//			testsList.content(htmlFactory.tag("li", htmlFactory.routeLink("main", "content/method_"+tmr.id+".html", name)));
//			
//			try (FileWriter methodWriter = new FileWriter(new File(contentDir, "method_"+tmr.id+".html"))) {
//				methodWriter.write("TODO - method results and carousel");
//			}
//			
//		}
		
		leftPanel.content(htmlFactory.panel(Style.INFO, "Tests", "testsList", null));
		
		// TODO - Actors, pages.
		
		ContentPanel mainPanel = reportPanel.contentPanel()
			.id("main")
			.width(DeviceSize.SMALL, 9)
			.width(DeviceSize.MEDIUM, 10)
			.width(DeviceSize.LARGE, 11);
		
		mainPanel.content("He-He");
						
		try (FileWriter indexWriter = new FileWriter(new File(outputDir, "index.html"))) {
			indexWriter.write(htmlFactory.routerApplication(
					title, 
					"main/content/summary.html", 
					null, 
					reportPanel).toString());
		}
		
		try (FileWriter summaryWriter = new FileWriter(new File(contentDir, "summary.html"))) {
			summaryWriter.write("TODO - I'm the SUMMARY!");
		}
		
		System.out.println("Nasdanika Web Test Report generated in "+outputDir.getAbsolutePath());		
	}

}
