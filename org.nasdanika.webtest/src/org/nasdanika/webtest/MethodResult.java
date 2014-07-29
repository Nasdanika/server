package org.nasdanika.webtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Table.Row.Cell;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement.Color;
import org.nasdanika.html.UIElement.Style;

class MethodResult {

	final Method method;

	final MethodResult parent;

	final String id;

	MethodResult(String id, Method method, MethodResult parent) {
		this.id = id;
		this.method = method;
		this.parent = parent;
		if (parent!=null) {
			parent.childResults.add(this);
		}
	}
	
	@Override
	public String toString() {
		return getClass().getName()+ 
				" [method=" + method + 
				", start=" + start + 
				", finish=" + finish + 
				", failure=" + failure + "]";
	}

	long start = System.currentTimeMillis();
	
	ScreenshotEntry beforeScreenshot;
	
	long finish;
	
	ScreenshotEntry afterScreenshot;

	Throwable failure;
	
	List<MethodResult> childResults = new ArrayList<>();
	
	List<ScreenshotEntry> allScreenshots() {
		return collectAllScreenshots( new LinkedList<ScreenshotEntry>()); 
	}
	
	private LinkedList<ScreenshotEntry> collectAllScreenshots(LinkedList<ScreenshotEntry> collector) {
		if (beforeScreenshot!=null && (collector.isEmpty() || beforeScreenshot.getMaster()!=collector.getLast())) {
			collector.add(beforeScreenshot.getMaster());
		}
		
		for (MethodResult mr: childResults) {
			mr.collectAllScreenshots(collector);
		}
		
		if (afterScreenshot!=null && (collector.isEmpty() || afterScreenshot.getMaster()!=collector.getLast())) {
			collector.add(afterScreenshot.getMaster());
		}
		return collector;
	};
	
	Glyphicon getGlyphicon() {
		return HTMLFactory.Glyphicon.asterisk;
	}
	
	void genRow(HTMLFactory htmlFactory, Table methodTable) {
		Row row = methodTable.row();
		if (failure!=null) {
			row.style(Style.DANGER);
		} else if (isPending()) {
			row.style(Style.DEFAULT);
		} else {
			row.style(Style.SUCCESS);
		}
		row.cell(routeLink(htmlFactory, false));
		genDescriptionAndDurationCells(htmlFactory, row);
	}
	
	Object routeLink(HTMLFactory htmlFactory, boolean doStyle) {
		String name = "";
		Title mTitle = method.getAnnotation(Title.class);
		if (mTitle == null) {
			name = ReportGenerator.title(method.getName());
		} else {
			name = mTitle.value();
		}
		
		String methodDetailsLocation = "content/method_"	+ id + ".html";
		if (failure==null) {
			if (isPending()) { // Only the first screenshot or no calls to actor/page methods.
				Tag routeLink = htmlFactory.span(
						htmlFactory.glyphicon(Glyphicon.time), 
						"&nbsp;", 
						name);				
				return doStyle ? routeLink.style("color", Color.GRAY.code) : routeLink;
				
			}
			
			Tag routeLink = htmlFactory.routeLink(
					"main", 
					methodDetailsLocation, 
					htmlFactory.glyphicon(Glyphicon.ok), 
					"&nbsp;", 
					name);
			return doStyle ? routeLink.style("color", Color.SUCCESS.code) : routeLink;
		}
		
		Tag routeLink = htmlFactory.routeLink(
					"main", 
					methodDetailsLocation, 
					htmlFactory.glyphicon(Glyphicon.remove), 
					"&nbsp;", 
					name);
		return doStyle ? routeLink.style("color", Color.DANGER.code) : routeLink;
	}

	boolean isPending() {
		return allScreenshots().size()==1 || childResults.isEmpty();
	}
	
	
	void genRows(HTMLFactory htmlFactory, Table methodTable, int indent) {
		Row row = methodTable.row();
		if (failure!=null) {
			row.style(Style.DANGER);
		}
		
		row.cell(getHTMLCaption(htmlFactory)).style("padding-left", (indent*30+5)+"px");
		
		genDescriptionAndDurationCells(htmlFactory, row);
		
		for (MethodResult ch: childResults) {
			ch.genRows(htmlFactory, methodTable, indent+1);
		}
	}

	private void genDescriptionAndDurationCells(HTMLFactory htmlFactory, Row row) {
		Cell descriptionCell = row.cell();
		Description description = method.getAnnotation(Description.class);
		if (description==null) {
			if (failure==null) {
				descriptionCell.content("&nbsp;");
			}
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
		
		if (failure!=null) {
			StringWriter sw = new StringWriter();
			failure.printStackTrace(new PrintWriter(sw));
			try {
				sw.close();
				descriptionCell.content(htmlFactory.collapsible(Style.DANGER, failure, true, "<pre style='color:red'>", sw, "</pre>"));
			} catch (IOException e) {
				// Should never happen.
				e.printStackTrace();
			}
		}
		
		long duration = finish - start;
		if (duration<1000) {
			row.cell(duration, " ms");
		} else {
			row.cell(MessageFormat.format("{0,number,#.###} sec", new Object[] {duration/1000.0}));
		}
	}
	
	String getHTMLCaption(HTMLFactory htmlFactory) {
		StringBuilder caption = new StringBuilder();
		caption.append(htmlFactory.glyphicon(getGlyphicon()));
		caption.append(" <b>");
		Class<?> dc = method.getDeclaringClass();
		Title classTitle = dc.getAnnotation(Title.class);
		if (classTitle==null) {
			caption.append(ReportGenerator.classTitle(dc));
		} else {
			caption.append(classTitle.value());
		}
		caption.append("</b> <i>");
		Title mTitle = method.getAnnotation(Title.class);
		if (mTitle==null) {
			caption.append(ReportGenerator.title(method.getName()));
		} else {
			caption.append(mTitle.value());
		}
		caption.append("</i>");
		return caption.toString();
	}
	
}
