package org.nasdanika.cdo.web.doc.extensions;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

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
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocRoute.PackageTocNodeFactoryEntry;
import org.nasdanika.cdo.web.doc.EAnnotationRenderer;
import org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.doc.TocNodeFactory;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement;

public abstract class EModelElementDocumentationGeneratorImpl<T extends EModelElement> implements EModelElementDocumentationGenerator<T> {
	
	public static Comparator<ENamedElement> NAMED_ELEMENT_COMPARATOR = new Comparator<ENamedElement>() {

		@Override
		public int compare(ENamedElement o1, ENamedElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	};
	
	public String getModelDocumentation(DocRoute docRoute, URI baseURI, String urlPrefix, EModelElement modelElement) {
		EAnnotation docAnn = modelElement.getEAnnotation(ECORE_DOC_ANNOTATION_SOURCE);
		if (docAnn==null) {
			return "";
		}
		String markdown = docAnn.getDetails().get("documentation");
		if (CoreUtil.isBlank(markdown)) {
			return null;
		}
		return docRoute.markdownToHtml(baseURI, urlPrefix, markdown);		
	}
	
	public void mountedModelElementDocumentation(DocRoute docRoute, EClassifier eClassifier, Fragment sink) {
		
		Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = docRoute.getPackageTocNodeFactories();
		TocNode elementDoc = new TocNode(null, null, null, null, false);
		
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
			sink.content(docRoute.section(eDoc, -1));
		}		
				
	}
	
	public String getFirstDocSentence(DocRoute docRoute, URI baseURI, String urlPrefix, EModelElement modelElement) {
		String html = getModelDocumentation(docRoute, baseURI, urlPrefix, modelElement);
		if (CoreUtil.isBlank(html)) {
			return "";
		}
		String text = Jsoup.parse(html).text();
		return docRoute.firstSentence(text);
	}
		
	public String getFirstDocSentence(DocRoute docRoute, URI baseURI, String urlPrefix, String markdown) {
		if (CoreUtil.isBlank(markdown)) {
			return "";
		}

		String text = Jsoup.parse(docRoute.markdownToHtml(baseURI, urlPrefix, markdown)).text();
		return docRoute.firstSentence(text);
	}
		
	protected String documentAnnotation(DocRoute docRoute,  EAnnotation eAnnotation) {
		if (ECORE_DOC_ANNOTATION_SOURCE.equals(eAnnotation.getSource())) {
			return ""; // Already generated as doc.
		}

		EAnnotationRenderer renderer = docRoute.getEAnnotationRenderers().get(eAnnotation.getSource());
		if (renderer!=null) {
			return renderer.render(eAnnotation, docRoute.getHtmlFactory());
		}
		
		// Default - table.
		Table detailsTable = docRoute.getHtmlFactory().table().bordered();
		for (String key: new TreeSet<String>(eAnnotation.getDetails().keySet())) {
			Row row = detailsTable.row();
			row.cell(StringEscapeUtils.escapeHtml4(key));
			row.cell(StringEscapeUtils.escapeHtml4(eAnnotation.getDetails().get(key)))
				.style().whiteSpace().preWrap()
				.style().font().family("monospace");
		}
		return docRoute.getHtmlFactory().panel(Bootstrap.Style.INFO, "Annotation " + StringEscapeUtils.escapeHtml4(eAnnotation.getSource()), detailsTable, null).toString();		
	}
	
	protected String eClassifierLink(
			DocRoute docRoute, 
			EClassifier eClassifier,
			String registryPath,			
			boolean withIcon) {
		if (eClassifier==null) {
			return "";
		}
		String packagePath = DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+registryPath+"/"+Hex.encodeHexString(eClassifier.getEPackage().getNsURI().getBytes(/* UTF-8? */));
		return docRoute.getHtmlFactory().link(docRoute.tocLink(packagePath+"/"+eClassifier.getName()+".html"), (withIcon ? eClassifierIcon(docRoute.getHtmlFactory(), eClassifier, docRoute.getDocRoutePath()) : ""), eClassifier.getName()).toString();		
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
	
	protected void sections(DocRoute docRoute, EClassifier eClassifier, Tabs tabs) {		
		Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = docRoute.getPackageTocNodeFactories();
		TocNode sections = new TocNode(null, null, null, null, false);
		
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
				tabName = docRoute.getHtmlFactory().tag(TagName.img).attribute("src", docRoute.getDocRoutePath()+section.getIcon()).style("margin-right", "5px") + tabName;
			}
			Fragment sectionFragment = docRoute.getHtmlFactory().fragment();
			sectionFragment.content(docRoute.section(section, -1));
			tabs.item(tabName, sectionFragment);
		}		
	}		
	
	public static UIElement<?> preStyle(UIElement<?> uiElement) {
		return uiElement.style().whiteSpace().preWrap().style().font().family("monospace");
	}
	
	// Generation of PlantUML text 
	
}
