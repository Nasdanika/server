package org.nasdanika.cdo.web.doc;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.jsoup.Jsoup;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Style;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

public class EModelElementDocumentationGenerator {
	
	private static final String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	private Pattern sentencePattern;
	private int maxFirstSentenceLength = 250;
	private LinkRenderer linkRenderer;

	public EModelElementDocumentationGenerator(LinkRenderer linkRenderer) {
		this.linkRenderer = linkRenderer;
		sentencePattern = Pattern.compile("[^\\.?!]+[\\.?!]+");
	}
	
	public void setMaxFirstSentenceLength(int maxFirstSentenceLength) {
		this.maxFirstSentenceLength = maxFirstSentenceLength;
	}
	
	public int getMaxFirstSentenceLength() {
		return maxFirstSentenceLength;
	}
	
	public String markdownToHtml(String markdownSource) {
		PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL);
		return pegDownProcessor.markdownToHtml(markdownSource, linkRenderer);
	}
	
	public String getModelDocumentation(EModelElement modelElement) {
		EAnnotation docAnn = modelElement.getEAnnotation(ECORE_DOC_ANNOTATION_SOURCE);
		if (docAnn==null) {
			return null;
		}
		String markdown = docAnn.getDetails().get("documentation");
		if (CoreUtil.isBlank(markdown)) {
			return null;
		}
		return markdownToHtml(markdown);		
	}
	
	public String getFirstDocSentence(EModelElement modelElement) {
		String html = getModelDocumentation(modelElement);
		if (CoreUtil.isBlank(html)) {
			return "";
		}
		String text = Jsoup.parse(html).text();
		Matcher matcher = sentencePattern.matcher(text);
		if (matcher.find()) {
			String group = matcher.group();
			if (group.length()<maxFirstSentenceLength) {
				return group;
			}
		}
		
		return "";
	}
	
	protected String documentAnnotation(HTMLFactory htmlFactory, EAnnotation eAnnotation) {
		if (ECORE_DOC_ANNOTATION_SOURCE.equals(eAnnotation.getSource())) {
			return ""; // Already generated as doc.
		}
		
		// TODO - extensions
		
		
		// Forms, routes, form controls - in sub-classes.
		
		// Default - table.
		Table detailsTable = htmlFactory.table().bordered();
		for (String key: new TreeSet<String>(eAnnotation.getDetails().keySet())) {
			Row row = detailsTable.row();
			row.cell(StringEscapeUtils.escapeHtml4(key));
			row.cell(StringEscapeUtils.escapeHtml4(eAnnotation.getDetails().get(key))).style("white-space", "pre-wrap").style("font-family", "monospace");
		}
		return htmlFactory.panel(Style.INFO, "Annotation " + StringEscapeUtils.escapeHtml4(eAnnotation.getSource()), detailsTable, null).toString();		
	}

}
