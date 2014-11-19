package org.nasdanika.webtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONObject;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Table.Row.Cell;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement.Color;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.html.UIElement.Style;
import org.openqa.selenium.WebDriverException;

/**
 * Result of an operation such as constructor or method invocation.
 * @author Pavel Vlasov
 *
 */
public class OperationResult<O extends AnnotatedElement> {

	final O operation;
	
	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	public Object getTarget() {
		return target;
	}

	final OperationResult<?> parent;

	final String id;

	private Object[] arguments;
	
	public Object[] getArguments() {
		return arguments;
	}
	
	public O getOperation() {
		return operation;
	}
	
	public OperationResult<?> getParent() {
		return parent;
	}
	
	public String getId() {
		return id;
	}

	OperationResult(String id, O operation, Object[] arguments, OperationResult<?> parent) {
		this.id = id;
		this.operation = operation;
		this.arguments = arguments;
		this.parent = parent;
		if (parent!=null) {
			parent.childResults.add(this);
		}
	}
	
	@Override
	public String toString() {
		return getClass().getName()+ 
				" [operation=" + operation + 
				", start=" + start + 
				", finish=" + finish + 
				", failure=" + failure + "]";
	}

	private long start = System.currentTimeMillis();
	
	public long getStart() {
		return start;
	}
	
	ScreenshotEntry beforeScreenshot;
	
	JSONObject beforePerformance;
	
	public ScreenshotEntry getBeforeScreenshot() {
		return beforeScreenshot;
	}
	
	long finish;
	
	public long getFinish() {
		return finish;
	}
	
	ScreenshotEntry afterScreenshot;
	
	JSONObject afterPerformance;

	Throwable failure;
	
	public Throwable getFailure() {
		return failure;
	}
	
	boolean hasOwnFailure() {
		if (failure==null) {
			return false;
		}
		
		Throwable rootCause = getRootCause();
		for (OperationResult<?> cor: childResults) {
			if (isSameRootCause(cor, rootCause)) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isSameRootCause(OperationResult<?> or, Throwable rootCause) {
		if (rootCause.equals(or.getRootCause())) {
			return true;
		}
		for (OperationResult<?> cor: or.childResults) {
			if (isSameRootCause(cor, rootCause)) {
				return true;
			}
		}
		return false;
	}
	
	public Throwable getRootCause() {
		for (Throwable th = failure; th!=null; th = th.getCause()) {
			if (th.getCause()==null) {
				return th;
			}
		}
		return failure;
	}
	
	public boolean isFailure() {
		Throwable rootCause = getRootCause();
		// Maybe need to refine which subclasses of WebDriverException shall be treated as failures,
		// maybe make configurable through @Report annotation
		return rootCause instanceof AssertionError 
				|| rootCause instanceof WebDriverException; 
	}
	
	List<OperationResult<?>> childResults = new ArrayList<>();
	
	public List<OperationResult<?>> getChildren() {
		return childResults;
	}
	
	public List<ScreenshotEntry> allScreenshots() {
		return collectAllScreenshots( new LinkedList<ScreenshotEntry>()); 
	}
	
	private LinkedList<ScreenshotEntry> collectAllScreenshots(LinkedList<ScreenshotEntry> collector) {
		if (beforeScreenshot!=null && (collector.isEmpty() || beforeScreenshot.getMaster()!=collector.getLast())) {
			collector.add(beforeScreenshot.getMaster());
		}
		
		for (OperationResult<?> or: childResults) {
			or.collectAllScreenshots(collector);
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
		if (isFailure()) {
			row.style(Style.DANGER);
		} else if (failure!=null) {
			row.style(Style.WARNING);
		} else if (isPending()) {
			row.style(Style.DEFAULT);
		} else {
			row.style(Style.SUCCESS);
		}
		row.cell(routeLink(htmlFactory, false));
		genDescriptionAndDurationCells(htmlFactory, row);
	}
	
	protected String getOperationName() {
		return String.valueOf(operation);
	}
	
	Object routeLink(HTMLFactory htmlFactory, boolean doStyle) {
		String name = "";
		Title mTitle = operation.getAnnotation(Title.class);
		if (mTitle == null) {
			name = ReportGenerator.title(getOperationName());
		} else {
			name = format(mTitle.value());
		}
		
		String methodDetailsLocation = "content/operation_"	+ id + ".html";
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
		
		if (isFailure()) {
			Tag routeLink = htmlFactory.routeLink(
					"main", 
					methodDetailsLocation, 
					htmlFactory.glyphicon(Glyphicon.remove), 
					"&nbsp;", 
					name);
			
			return doStyle ? routeLink.style("color", Color.DANGER.code) : routeLink;
		}
		
		Tag routeLink = htmlFactory.routeLink(
					"main", 
					methodDetailsLocation, 
					htmlFactory.glyphicon(Glyphicon.warning_sign), 
					"&nbsp;", 
					name);
		return doStyle ? routeLink.style("color", Color.WARNING.code) : routeLink;
	}

	public boolean isPending() {
		Screenshot screenshot = getOperation().getAnnotation(Screenshot.class);
		int expectedScreenshots = screenshot==null || Arrays.asList(screenshot.value()).contains(Screenshot.When.BEFORE) ? 2 : 1;
		return allScreenshots().size()<expectedScreenshots && childResults.isEmpty();
	}
		
	void genRows(HTMLFactory htmlFactory, Table methodTable, Object carouselId, List<ScreenshotEntry> screenshots, int indent) {
		Row row = methodTable.row();
		if (isFailure()) {
			row.style(Style.DANGER);
		} else if (failure!=null) {
			row.style(Style.WARNING);
		}
		
		Object caption = getHTMLCaption(htmlFactory);
		int slideIdx = -1;
		if (beforeScreenshot!=null) {
			slideIdx = screenshots.indexOf(beforeScreenshot.getMaster()); 
		}
		if (slideIdx==-1 && afterScreenshot!=null) {
			slideIdx = screenshots.indexOf(afterScreenshot.getMaster());
		}
		if (slideIdx!=-1) {
			caption = htmlFactory.link("#carousel_"+carouselId, caption)
					.on(Event.click, "jQuery('#"+carouselId+"').carousel("+slideIdx+"); return true;");
		}
		row.cell(caption).style("padding-left", (indent*30+5)+"px");
		
		genDescriptionAndDurationCells(htmlFactory, row);
		
		for (OperationResult<?> ch: childResults) {
			ch.genRows(htmlFactory, methodTable, carouselId, screenshots, indent+1);
		}
	}
	
	String getDescriptionHTML() {
		Description description = operation.getAnnotation(Description.class);
		if (description==null) {
			return null;
		}			
		
		StringBuilder ret = new StringBuilder();
			
		if (description.html()) {
			for (String str: description.value()) {
				ret.append(format(str)).append(" ");
			}
		} else {
			ret.append("<pre>");
			int idx = 0;
			for (String str: description.value()) {
				if (idx++>0) {
					ret.append(System.lineSeparator());
				}
				ret.append(StringEscapeUtils.escapeHtml4(format(str)));
			}
			ret.append("</pre>");			
		}
		return ret.toString();
	}
	
	protected String format(String str) {
		if (str==null || arguments==null || arguments.length==0) {
			return str;
		}
		return MessageFormat.format(str, arguments);
	}

	private void genDescriptionAndDurationCells(HTMLFactory htmlFactory, Row row) {
		Cell descriptionCell = row.cell();
		String description = getDescriptionHTML();
		boolean hasOwnFailure = hasOwnFailure();
		if (description==null) {
			if (!hasOwnFailure) {
				descriptionCell.content("&nbsp;");
			}
		} else {
			descriptionCell.content(description);
		}
		
		if (hasOwnFailure) {
			StringWriter sw = new StringWriter();
			Throwable rootCause = getRootCause();
			rootCause.printStackTrace(new PrintWriter(sw));
			try {
				sw.close();
				descriptionCell.content(htmlFactory.collapsible(isFailure() ? Style.DANGER : Style.WARNING, "<pre>"+StringEscapeUtils.escapeHtml4(rootCause.toString())+"</pre>", true, "<pre style='color:red'>", sw, "</pre>"));
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
		Class<?> dc = operation instanceof Member ? ((Member) operation).getDeclaringClass() : null;
		caption.append(ReportGenerator.classTitle(dc));
		caption.append("</b> <i>");
		Title mTitle = operation.getAnnotation(Title.class);
		if (mTitle==null) {
			caption.append(ReportGenerator.title(getOperationName()));
		} else {
			caption.append(format(mTitle.value()));
		}
		caption.append("</i>");
		return caption.toString();
	}
		
	public String getName() {
		StringBuilder caption = new StringBuilder();
		Class<?> dc = operation instanceof Member ? ((Member) operation).getDeclaringClass() : null;
		caption.append(ReportGenerator.classTitle(dc));
		caption.append(" : ");
		Title mTitle = operation.getAnnotation(Title.class);
		if (mTitle==null) {
			caption.append(ReportGenerator.title(getOperationName()));
		} else {
			caption.append(mTitle.value());
		}
		return format(caption.toString());
	}
	
}
