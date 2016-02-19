package org.nasdanika.cdo.web.doc.extensions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocRoute.PackageTocNodeFactoryEntry;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.doc.TocNodeFactory;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class EPackageDocumentationGenerator extends EModelElementDocumentationGeneratorImpl<EPackage> {

	@Override
	public String generate(
			DocRoute docRoute, 
			URL baseURL,
			String urlPrefix,
			String registryPath,
			EPackage ePackage) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		
		// TODO - path?
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EPackage "+ePackage.getName()));
		ret.content(htmlFactory.tag(TagName.h2, getPackageIcon(docRoute), ePackage.getName()));
		ret.content(htmlFactory.div("<B>Namespace URI:</B> "+ePackage.getNsURI()));
		
		Tabs tabs = htmlFactory.tabs();
		ret.content(tabs);		
		
		tabs(docRoute, baseURL, urlPrefix, registryPath, ePackage, tabs);
		
		return ret.toString();				
	}

	protected void documentationTab(
			DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, 
			String registryPath,
			EPackage ePackage, 
			Tabs tabs) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		Fragment ret = htmlFactory.fragment();
		String doc = getModelDocumentation(docRoute, baseURL, urlPrefix, ePackage);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}	
		
		// Mounted doc - "#" section
		Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = docRoute.getPackageTocNodeFactories();		
		
		TocNode elementDoc = new TocNode(null, null, null);
		
		synchronized (packageTocNodeFactories) {
			PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(ePackage.getNsURI());
			if (pe!=null) {
				for (TocNodeFactory tnf: pe.tocNodeFactories) {
					if (tnf.isElementDoc() && tnf.isRoot(pe.tocNodeFactories)) {
						tnf.createTocNode(elementDoc, pe.tocNodeFactories, false);
					}
				}
			}
		}		
		
		for (TocNode eDoc: elementDoc.getChildren()) {
			section(docRoute, eDoc, -1,  ret);
		}		
						
		EPackage eSuperPackage = ePackage.getESuperPackage();
		if (eSuperPackage!=null) {
			ret.content(htmlFactory.div("<B>Parent:</B> ", htmlFactory.link("#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(eSuperPackage.getNsURI().getBytes(/* UTF-8? */)), getPackageIcon(docRoute), eSuperPackage.getName())));			
		}
		
		for (EAnnotation eAnnotation: ePackage.getEAnnotations()) {
			ret.content(documentAnnotation(docRoute, eAnnotation));
		}
		
		if (!ret.isEmpty()) {
			tabs.item("Documentation", ret);
		}
	}

	private Tag getPackageIcon(DocRoute docRoute) {
		return docRoute.getHtmlFactory().tag(TagName.img)
				.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EPackage.gif")
				.style().margin().right("5px");
	}			
	
	protected void tabs(
			DocRoute docRoute, 
			URL baseURL,
			String urlPrefix,
			String registryPath,
			EPackage ePackage, 
			Tabs tabs) {
		
		documentationTab(docRoute, baseURL, urlPrefix, registryPath, ePackage, tabs);		
		diagramTab(ePackage, tabs);
		subPackagesTab(docRoute, baseURL, urlPrefix, registryPath, ePackage, tabs);		
		classifierTabs(docRoute, baseURL, urlPrefix, registryPath, ePackage, tabs);	
		sectionsTabs(docRoute, ePackage, tabs);						
	}

	private void sectionsTabs(DocRoute docRoute, EPackage ePackage, Tabs tabs) {
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		TocNode sections = new TocNode(null, null, null);
		
		synchronized (docRoute.getPackageTocNodeFactories()) {
			PackageTocNodeFactoryEntry pe = docRoute.getPackageTocNodeFactories().get(ePackage.getNsURI());
			if (pe!=null) {
				for (TocNodeFactory tnf: pe.tocNodeFactories) {
					if (tnf.isSection() && tnf.isRoot(pe.tocNodeFactories)) {
						tnf.createTocNode(sections, pe.tocNodeFactories, false);
					}
				}
			}
		}		
		
		sections.sort(false);
		
		for (TocNode section: sections.getChildren()) {
			String tabName = StringEscapeUtils.escapeHtml4(section.getText().substring(1));
			if (section.getIcon()!=null) {
				tabName = htmlFactory.tag(TagName.img).attribute("src", docRoute.getDocRoutePath()+section.getIcon()).style("margin-right", "5px") + tabName;
			}
			Fragment sectionFragment = htmlFactory.fragment();
			section(docRoute, section, -1, sectionFragment);
			tabs.item(tabName, sectionFragment);
		}
	}

	protected void diagramTab(EPackage ePackage, Tabs tabs) {
		try {
			StringBuilder sb = new StringBuilder();
			PlantUmlTextGenerator gen = new PlantUmlTextGenerator(sb);
//			{
//				
//				@Override
//				protected Iterable<EClass> getSubTypes(EClass eClass) {
//					Set<EClassifierKey> subTypes = docRoute.getInheritanceMap().get(new EClassifierKey(eClass));
//					if (subTypes==null || subTypes.isEmpty()) {
//						return super.getSubTypes(eClass);
//					}
//					
//					Set<EClass> ret = new HashSet<EClass>();
//					for (EClassifierKey stKey: subTypes) {
//						EClassifier st = docRoute.getEClassifier(stKey);
//						if (st instanceof EClass) {
//							ret.add((EClass) st);
//						}
//					}
//					return ret;
//				}
//				
//			};
			gen.appendStartUml();
			gen.appendWithRelationships(ePackage.getEClassifiers());
			gen.appendEndUml();
			SourceStringReader reader = new SourceStringReader(sb.toString());
			try (final ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				// Write the first image to "os"
				reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
				os.close();
	
				// The XML is stored into svg
				final String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
				tabs.item("Diagram", svg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void classifierTabs(
			DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, 
			String registryPath,
			EPackage ePackage, 
			Tabs tabs) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		String packagePath = "#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */));
		List<EClassifier> pClassifiers = new ArrayList<>(ePackage.getEClassifiers());
		Collections.sort(pClassifiers, new Comparator<EClassifier>() {

			@Override
			public int compare(EClassifier o1, EClassifier o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		Table classTable = htmlFactory.table().bordered();
		Row classTableHeaderRow = classTable.row().style(Bootstrap.Style.INFO);
		classTableHeaderRow.header("Name");
		classTableHeaderRow.header("Description");
		
		Table dataTypeTable = htmlFactory.table().bordered();
		Row dataTypeTableHeaderRow = dataTypeTable.row().style(Bootstrap.Style.INFO);
		dataTypeTableHeaderRow.header("Name");
		dataTypeTableHeaderRow.header("Instance Type Name");
		dataTypeTableHeaderRow.header("Description");
		
		Table enumTable = htmlFactory.table().bordered();
		Row enumTableHeaderRow = enumTable.row().style(Bootstrap.Style.INFO);
		enumTableHeaderRow.header("Name");
		enumTableHeaderRow.header("Description");
		
		for (EClassifier eClassifier: pClassifiers) {
			if (eClassifier instanceof EClass) {
				Row row = classTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(getFirstDocSentence(docRoute, baseURL, urlPrefix, eClassifier));
			} else if (eClassifier instanceof EEnum) {
				Row row = enumTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(getFirstDocSentence(docRoute, baseURL, urlPrefix, eClassifier));
			} else {
				Row row = dataTypeTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(eClassifier.getInstanceTypeName());
				row.cell(getFirstDocSentence(docRoute, baseURL, urlPrefix, eClassifier));
			}
		}
		
		if (classTable.rows().size()>1) {
			Tag classIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EClass.gif")
					.style("margin-right", "5px");
			
			tabs.item(classIcon+" Classes", classTable);
		}
		if (dataTypeTable.rows().size()>1) {
			Tag dataTypeIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EDataType.gif")
					.style("margin-right", "5px");
					
			tabs.item(dataTypeIcon+" Data types", dataTypeTable);			
		}
		if (enumTable.rows().size()>1) {
			Tag enumIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoute.getDocRoutePath()+"/resources/images/EEnum.gif")
					.style("margin-right", "5px");
			
			tabs.item(enumIcon+" Enumerations", enumTable);
		}
	}

	protected void subPackagesTab(
			DocRoute docRoute, 
			URL baseURL, 
			String urlPrefix, String registryPath,
			EPackage ePackage, 
			Tabs tabs) {

		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		Table subPackageTable = htmlFactory.table().bordered();
		Row subPackageTableHeaderRow = subPackageTable.row().style(Bootstrap.Style.INFO);
		subPackageTableHeaderRow.header("Name");
		subPackageTableHeaderRow.header("Description");
		for (EPackage subPackage: ePackage.getESubpackages()) {
			Row row = subPackageTable.row();
			row.cell(htmlFactory.link("#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(subPackage.getNsURI().getBytes(/* UTF-8? */)), subPackage.getName()));
			row.cell(getFirstDocSentence(docRoute, baseURL, urlPrefix, subPackage));			
		}
		
		if (subPackageTable.rows().size()>1) {
			tabs.item(getPackageIcon(docRoute)+" Sub-packages", subPackageTable);			
		}
	}

	@Override
	public void close() {
		// NOP		
	}

}
