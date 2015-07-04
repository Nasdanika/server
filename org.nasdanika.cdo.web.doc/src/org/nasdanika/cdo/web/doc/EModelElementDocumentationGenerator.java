package org.nasdanika.cdo.web.doc;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.ETypedElement;
import org.jsoup.Jsoup;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement;
import org.nasdanika.html.UIElement.Style;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

public class EModelElementDocumentationGenerator {
	
	private static Pattern SENTENCE_PATTERN = Pattern.compile("[^\\.?!]+[\\.?!]+");	
	
	public static Comparator<ENamedElement> NAMED_ELEMENT_COMPARATOR = new Comparator<ENamedElement>() {

		@Override
		public int compare(ENamedElement o1, ENamedElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	};
		
	static final String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	private int maxFirstSentenceLength = 250;
	private LinkRenderer linkRenderer;
	private Map<String, EAnnotationRenderer> eAnnotationRenderers;

	private TocNode rootToc;

	private DocRoute docRoute;

	public EModelElementDocumentationGenerator(
			DocRoute docRoute, 
			LinkRenderer linkRenderer, 
			Map<String, EAnnotationRenderer> eAnnotationRenderers) {
		this.docRoute = docRoute;
		this.linkRenderer = linkRenderer;
		this.eAnnotationRenderers = eAnnotationRenderers;
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
			return "";
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
		Matcher matcher = SENTENCE_PATTERN.matcher(text);
		if (matcher.find()) {
			String group = matcher.group();
			if (group.length()<maxFirstSentenceLength) {
				return group;
			}
		}
		
		return text.length()<maxFirstSentenceLength ? text : "";
	}
		
	public String getFirstDocSentence(String markdown) {
		if (CoreUtil.isBlank(markdown)) {
			return "";
		}

		String text = Jsoup.parse(markdownToHtml(markdown)).text();
		Matcher matcher = SENTENCE_PATTERN.matcher(text);
		if (matcher.find()) {
			String group = matcher.group();
			if (group.length()<maxFirstSentenceLength) {
				return group;
			}
		}
		
		return text.length()<maxFirstSentenceLength ? text : "";
	}
		
	protected String documentAnnotation(HTMLFactory htmlFactory, EAnnotation eAnnotation) {
		if (ECORE_DOC_ANNOTATION_SOURCE.equals(eAnnotation.getSource())) {
			return ""; // Already generated as doc.
		}

		EAnnotationRenderer renderer = eAnnotationRenderers.get(eAnnotation.getSource());
		if (renderer!=null) {
			return renderer.render(eAnnotation, htmlFactory);
		}
		
		// Default - table.
		Table detailsTable = htmlFactory.table().bordered();
		for (String key: new TreeSet<String>(eAnnotation.getDetails().keySet())) {
			Row row = detailsTable.row();
			row.cell(StringEscapeUtils.escapeHtml4(key));
			row.cell(StringEscapeUtils.escapeHtml4(eAnnotation.getDetails().get(key))).style("white-space", "pre-wrap").style("font-family", "monospace");
		}
		return htmlFactory.panel(Style.INFO, "Annotation " + StringEscapeUtils.escapeHtml4(eAnnotation.getSource()), detailsTable, null).toString();		
	}
	
	protected String eClassifierLink(
			HTMLFactory htmlFactory,
			EClassifier eClassifier,
			String docRoutePath,
			String registryPath,			
			boolean withIcon) {
		if (eClassifier==null) {
			return "";
		}
		String packagePath = "#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(eClassifier.getEPackage().getNsURI().getBytes(/* UTF-8? */));
		return htmlFactory.link(docRoute.tocLink(packagePath+"/"+eClassifier.getName()), (withIcon ? eClassifierIcon(htmlFactory, eClassifier, docRoutePath) : ""), eClassifier.getName()).toString();		
	}

	protected static String eClassifierIcon(HTMLFactory htmlFactory, EClassifier eClassifier, String docRoutePath) {
		if (eClassifier instanceof EClass) {
			return htmlFactory.tag(TagName.img)
					.attribute("src", docRoutePath+"/resources/images/EClass.gif")
					.style("margin-right", "5px")
					.toString();
			
		}
		
		if (eClassifier instanceof EEnum) {
			return htmlFactory.tag(TagName.img)
					.attribute("src", docRoutePath+"/resources/images/EEnum.gif")
					.style("margin-right", "5px")
					.toString();
		}
		
		return htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EDataType.gif")
				.style("margin-right", "5px")
				.toString();
	}
	
	public static String cardinality(ETypedElement typedElement) {
		if (typedElement.getLowerBound()==0 && typedElement.getUpperBound()==-1) {
			return "*";
		} 
		
		if (typedElement.getLowerBound()==typedElement.getUpperBound()) {
			return String.valueOf(typedElement.getLowerBound());
		}
		
		return typedElement.getLowerBound() + ".." + (typedElement.getUpperBound()==-1 ? "*" : String.valueOf(typedElement.getUpperBound()));
	}

	public static void preStyle(UIElement<?> uiElement) {
		uiElement.style("white-space", "pre-wrap").style("font-family", "monospace");
	}
}
