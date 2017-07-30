package org.nasdanika.doc.ecore;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.jsoup.Jsoup;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

/**
 * Base class for documentation generators.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public abstract class EModelElementDocumentationGenerator<T extends EModelElement> {
	
	public static final String PACKAGE_SUMMARY_HTML = "package-summary.html";
	
	public static final Comparator<ENamedElement> NAMED_ELEMENT_COMPARATOR = new Comparator<ENamedElement>() {

		@Override
		public int compare(ENamedElement o1, ENamedElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	};
			
	private T modelElement;
	
	public T getModelElement() {
		return modelElement;
	}
	
	public EModelElementDocumentationGenerator(T modelElement) {
		this.modelElement = modelElement;
	}
	
	public static final String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";	
	
	protected int getMarkdownOptions() {
		return Extensions.ALL ^ Extensions.HARDWRAPS ^ Extensions.SUPPRESS_HTML_BLOCKS ^ Extensions.SUPPRESS_ALL_HTML;
	}
	
	protected String preProcessMarkdown(String markdown) {
		return markdown;
	}
	
	protected LinkRenderer createMarkdownLinkRenderer() {
		return new LinkRenderer();
	}
	
	protected String markdownToHtml(String markdown) {
		return new PegDownProcessor(getMarkdownOptions()).markdownToHtml(preProcessMarkdown(markdown), createMarkdownLinkRenderer());
	}
	
	static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	private static Pattern SENTENCE_PATTERN = Pattern.compile(".+?[\\.?!]+\\s+");
	
	protected int minFirstSentenceLength = 20;
	protected int maxFirstSentenceLength = 250;
	
	private static String[] ABBREVIATIONS = { "e.g.", "i.e." }; 

	protected String[] getAbbreviations() {
		return ABBREVIATIONS;
	}
	
	protected HTMLFactory getHtmlFactory() {
		return HTMLFactory.INSTANCE;
	}
	
	protected String firstSentence(String text) {
		if (text == null || text.length() < minFirstSentenceLength) {
			return text;
		}
		Matcher matcher = SENTENCE_PATTERN.matcher(text);		
		Z: while (matcher.find()) {
			String group = matcher.group();
			for (String abbr: getAbbreviations()) {
				if (group.trim().endsWith(abbr)) {
					continue Z;
				}
			}
			if (matcher.end() > minFirstSentenceLength && matcher.end() < maxFirstSentenceLength) {
				return text.substring(0, matcher.end());
			}
		}
		
		return text.length()<maxFirstSentenceLength ? text : text.substring(0, maxFirstSentenceLength)+"...";
	}
		
	/**
	 * Generates HTML documentation for a model element.
	 * @param docRoute
	 * @param baseURI
	 * @param urlPrefix
	 * @param modelElement
	 * @return
	 */
	public String getModelDocumentation(EModelElement modelElement) {
		EAnnotation docAnn = modelElement.getEAnnotation(ECORE_DOC_ANNOTATION_SOURCE);
		if (docAnn==null) {
			return null;
		}
		String markdown = docAnn.getDetails().get("documentation");
		if (isBlank(markdown)) {
			return null;
		}
		return markdownToHtml(markdown);		
	}
	
	public String getFirstDocSentence(EModelElement modelElement) {
		String html = getModelDocumentation(modelElement);
		if (isBlank(html)) {
			return "";
		}
		String text = Jsoup.parse(html).text();
		return firstSentence(text);
	}
		
	public String getFirstDocSentence(String markdown) {
		if (isBlank(markdown)) {
			return "";
		}

		String text = Jsoup.parse(markdownToHtml(markdown)).text();
		return firstSentence(text);
	}
		
	protected String documentAnnotation(EAnnotation eAnnotation) {
		if (ECORE_DOC_ANNOTATION_SOURCE.equals(eAnnotation.getSource())) {
			return ""; // Already generated as doc.
		}

		Table detailsTable = getHtmlFactory().table().bordered();
		for (String key: new TreeSet<String>(eAnnotation.getDetails().keySet())) {
			Row row = detailsTable.row();
			row.cell(StringEscapeUtils.escapeHtml4(key));
			row.cell(StringEscapeUtils.escapeHtml4(eAnnotation.getDetails().get(key)))
				.style().whiteSpace().preWrap()
				.style().font().family("monospace");
		}
		return getHtmlFactory().panel(Bootstrap.Style.INFO, "Annotation " + StringEscapeUtils.escapeHtml4(eAnnotation.getSource()), detailsTable, null).toString();		
	}
	
	/**
	 * @return Base location of EClassifier icons.
	 * This implementation returns "http://www.nasdanika.org/eclassifier-images/".
	 */
	protected String getIconsBaseLocation() {
		return "http://www.nasdanika.org/eclassifier-images/";
	}
	
	protected String eClassifierIcon(EClassifier eClassifier) {
		if (eClassifier instanceof EClass) {
			return getHtmlFactory().tag(TagName.img)
					.attribute("src", getIconsBaseLocation()+"EClass.gif")
					.style("margin-right", "5px")
					.toString();			
		}
		
		if (eClassifier instanceof EEnum) {
			return getHtmlFactory().tag(TagName.img)
					.attribute("src", getIconsBaseLocation()+"EEnum.gif")
					.style("margin-right", "5px")
					.toString();
		}
		
		return getHtmlFactory().tag(TagName.img)
				.attribute("src", getIconsBaseLocation()+"EDataType.gif")
				.style("margin-right", "5px")
				.toString();
	}
	
	/**
	 * @param ePackage
	 * @return Base URL for {@link EPackage} documentation.
	 */
	protected String getEPackageLocation(EPackage ePackage) {
		if (modelElement instanceof EClassifier && ((EClassifier) modelElement).getEPackage() == ePackage) {
			return ""; // Same package.
		}
		return "../"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */))+"/";
	}
		
	protected String eClassifierLink(EClassifier eClassifier, boolean withIcon) {
		if (eClassifier==null) {
			return "";
		}
		String packageLocation = getEPackageLocation(eClassifier.getEPackage()); 
		String eClassifierIcon = withIcon ? eClassifierIcon(eClassifier) : "";
		return getHtmlFactory().link(packageLocation+"/"+eClassifier.getName()+".html", eClassifierIcon, eClassifier.getName()).toString();		
	}
	
	/**
	 * Renders JavaDoc link or a class name.
	 * @param className
	 * @return
	 */
	protected String javaDocLink(String className) {
		return className;
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
	
	public static UIElement<?> preStyle(UIElement<?> uiElement) {
		return uiElement.style().whiteSpace().preWrap().style().font().family("monospace");
	}
	
	public abstract String generateDocumentation();
	
	/**
	 * In situations where classes referencing this class are known this method can be overridden. 
	 * @return
	 */	
	protected Collection<EClass> getReferrers(EClass eClass) {
		return Collections.emptyList();
	}
	
}
