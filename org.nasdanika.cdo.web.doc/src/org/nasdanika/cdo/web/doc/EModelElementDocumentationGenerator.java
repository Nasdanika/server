package org.nasdanika.cdo.web.doc;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
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
import org.nasdanika.cdo.web.doc.DocRoute.PackageTocNodeFactoryEntry;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement;
import org.nasdanika.html.UIElement.Style;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

public class EModelElementDocumentationGenerator {
	
	private static Pattern SENTENCE_PATTERN = Pattern.compile(".+?[\\.?!]+\\s+");	
	
	private static String[] ABBREVIATIONS = { "e.g.", "i.e." }; // TODO - load from extensions?
	
	public static Comparator<ENamedElement> NAMED_ELEMENT_COMPARATOR = new Comparator<ENamedElement>() {

		@Override
		public int compare(ENamedElement o1, ENamedElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	};
		
	static final String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	private int maxFirstSentenceLength = 250;

	protected DocRoute docRoute;

	public EModelElementDocumentationGenerator(DocRoute docRoute) {
		this.docRoute = docRoute;
	}
	
	public void setMaxFirstSentenceLength(int maxFirstSentenceLength) {
		this.maxFirstSentenceLength = maxFirstSentenceLength;
	}
	
	public int getMaxFirstSentenceLength() {
		return maxFirstSentenceLength;
	}
	
	public String markdownToHtml(URL baseURL, String urlPrefix, String markdownSource) {
		PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL ^ Extensions.HARDWRAPS);
		return pegDownProcessor.markdownToHtml(docRoute.expand(markdownSource, baseURL, urlPrefix), docRoute.createMarkdownLinkRenderer(baseURL, urlPrefix));
	}
	
	public String getModelDocumentation(URL baseURL, String urlPrefix, EModelElement modelElement) {
		EAnnotation docAnn = modelElement.getEAnnotation(ECORE_DOC_ANNOTATION_SOURCE);
		if (docAnn==null) {
			return "";
		}
		String markdown = docAnn.getDetails().get("documentation");
		if (CoreUtil.isBlank(markdown)) {
			return null;
		}
		return markdownToHtml(baseURL, urlPrefix, markdown);		
	}
	
	public void mountedModelElementDocumentation(HTMLFactory htmlFactory, String docRoutePath, EClassifier eClassifier, Fragment sink) {
		
		Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = docRoute.getPackageTocNodeFactories();
		TocNode elementDoc = new TocNode(null, null, null);
		
		synchronized (packageTocNodeFactories) {
			PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(eClassifier.getEPackage().getNsURI());
			if (pe!=null) {
				List<TocNodeFactory> ctnfl = pe.classifierTocNodeFactories.get(eClassifier.getName());
				if (ctnfl!=null) {
					for (TocNodeFactory tnf: ctnfl) {
						if (tnf.isElementDoc() && tnf.isRoot(ctnfl)) {
							tnf.createTocNode(elementDoc, ctnfl, false);
						}
					}
				}
			}
		}
		
		for (TocNode eDoc: elementDoc.getChildren()) {
			section(eDoc, -1, htmlFactory, docRoutePath, sink);
		}		
				
	}
	
	public String getFirstDocSentence(URL baseURL, String urlPrefix, EModelElement modelElement) {
		String html = getModelDocumentation(baseURL, urlPrefix, modelElement);
		if (CoreUtil.isBlank(html)) {
			return "";
		}
		String text = Jsoup.parse(html).text();
		return firstSentence(text);
	}

	private String firstSentence(String text) {
		Matcher matcher = SENTENCE_PATTERN.matcher(text);		
		Z: while (matcher.find()) {
			String group = matcher.group();
			for (String abbr: ABBREVIATIONS) {
				if (group.trim().endsWith(abbr)) {
					continue Z;
				}
			}
			if (matcher.end()<maxFirstSentenceLength) {
				return text.substring(0, matcher.end());
			}
		}
		
		return text.length()<maxFirstSentenceLength ? text : text.substring(0, maxFirstSentenceLength)+"...";
	}
		
	public String getFirstDocSentence(URL baseURL, String urlPrefix, String markdown) {
		if (CoreUtil.isBlank(markdown)) {
			return "";
		}

		String text = Jsoup.parse(markdownToHtml(baseURL, urlPrefix, markdown)).text();
		return firstSentence(text);
	}
		
	protected String documentAnnotation(HTMLFactory htmlFactory, EAnnotation eAnnotation) {
		if (ECORE_DOC_ANNOTATION_SOURCE.equals(eAnnotation.getSource())) {
			return ""; // Already generated as doc.
		}

		EAnnotationRenderer renderer = docRoute.geteAnnotationRenderers().get(eAnnotation.getSource());
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
	
	protected void sections(EClassifier eClassifier, String docRoutePath, HTMLFactory htmlFactory, Tabs tabs) {		
		Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = docRoute.getPackageTocNodeFactories();
		TocNode sections = new TocNode(null, null, null);
		
		synchronized (packageTocNodeFactories) {
			PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(eClassifier.getEPackage().getNsURI());
			if (pe!=null) {
				List<TocNodeFactory> ctnfl = pe.classifierTocNodeFactories.get(eClassifier.getName());
				if (ctnfl!=null) {
					for (TocNodeFactory tnf: ctnfl) {
						if (tnf.isSection() && tnf.isRoot(ctnfl)) {
							tnf.createTocNode(sections, ctnfl, false);
						}
					}
				}
			}
		}
		
		sections.sort(false);
		
		for (TocNode section: sections.getChildren()) {
			String tabName = StringEscapeUtils.escapeHtml4(section.getText().substring(1));
			if (section.getIcon()!=null) {
				tabName = htmlFactory.tag(TagName.img).attribute("src", docRoutePath+section.getIcon()).style("margin-right", "5px") + tabName;
			}
			Fragment sectionFragment = htmlFactory.fragment();
			section(section, -1, htmlFactory, docRoutePath, sectionFragment);
			tabs.item(tabName, sectionFragment);
		}		
	}
	
	protected static void section(
			TocNode section, 
			int level, 
			HTMLFactory htmlFactory, 
			String docRoutePath, 
			Fragment sectionFragment) {
		
		if (level!=-1) {
			String header = StringEscapeUtils.escapeHtml4(section.getText().substring(1));
			if (section.getIcon()!=null) {
				header = htmlFactory.tag(TagName.img).attribute("src", docRoutePath+section.getIcon()).style("margin-right", "5px") + header;
			}
			sectionFragment.content(htmlFactory.tag("h"+level, header));
		}		
		
		String content = section.getContent();
		if (content==null) {
			String sectionId = "section_"+htmlFactory.nextId();
			String script = htmlFactory.tag(TagName.script, "nsdLoad('#"+sectionId+"','"+docRoutePath+section.getHref()+"');").toString();
			sectionFragment.content(htmlFactory.div("").id(sectionId), script); 
		} else {
			sectionFragment.content(content); 
		}
		
		for (TocNode subSection: section.getChildren()) {
			section(subSection, level==-1 ? 3 : Math.min(6, level+1), htmlFactory, docRoutePath, sectionFragment);
		}
		
	}

	public static void preStyle(UIElement<?> uiElement) {
		uiElement.style("white-space", "pre-wrap").style("font-family", "monospace");
	}
}
