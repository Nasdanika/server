package org.nasdanika.cdo.web.doc;

import java.net.URL;
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
import org.nasdanika.cdo.web.doc.DocRoute.PackageTocNodeFactoryEntry;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement.Style;

public class EPackageDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EPackageDocumentationGenerator(DocRoute docRoute) {
		super(docRoute);
	}

	public String generate(
			URL baseURL,
			String urlPrefix,
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EPackage ePackage) {
		
		// TODO - path?
		Tag packageIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EPackage.gif")
				.style("margin-right", "5px");
		
				
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EPackage "+ePackage.getName()));
		ret.content(htmlFactory.tag(TagName.h2, packageIcon, ePackage.getName()));
		ret.content(htmlFactory.div("<B>Namespace URI:</B> "+ePackage.getNsURI()));
		String doc = getModelDocumentation(baseURL, urlPrefix, ePackage);
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
			section(eDoc, -1, htmlFactory, docRoutePath, ret);
		}		
						
		EPackage eSuperPackage = ePackage.getESuperPackage();
		if (eSuperPackage!=null) {
			ret.content(htmlFactory.div("<B>Parent:</B> ", htmlFactory.link("#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(eSuperPackage.getNsURI().getBytes(/* UTF-8? */)), packageIcon, eSuperPackage.getName())));			
		}
		
		for (EAnnotation eAnnotation: ePackage.getEAnnotations()) {
			ret.content(documentAnnotation(htmlFactory, eAnnotation));
		}
		
		Tabs tabs = htmlFactory.tabs();
		ret.content(tabs);		

		Table subPackageTable = htmlFactory.table().bordered();
		Row subPackageTableHeaderRow = subPackageTable.row().style(Style.INFO);
		subPackageTableHeaderRow.header("Name");
		subPackageTableHeaderRow.header("Description");
		for (EPackage subPackage: ePackage.getESubpackages()) {
			Row row = subPackageTable.row();
			row.cell(htmlFactory.link("#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(subPackage.getNsURI().getBytes(/* UTF-8? */)), subPackage.getName()));
			row.cell(getFirstDocSentence(baseURL, urlPrefix, subPackage));			
		}
		
		if (subPackageTable.rows().size()>1) {
			tabs.item(packageIcon+" Sub-packages", subPackageTable);			
		}
		
		String packagePath = "#router/doc-content/"+registryPath+"/"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */));
		List<EClassifier> pClassifiers = new ArrayList<>(ePackage.getEClassifiers());
		Collections.sort(pClassifiers, new Comparator<EClassifier>() {

			@Override
			public int compare(EClassifier o1, EClassifier o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		Table classTable = htmlFactory.table().bordered();
		Row classTableHeaderRow = classTable.row().style(Style.INFO);
		classTableHeaderRow.header("Name");
		classTableHeaderRow.header("Description");
		
		Table dataTypeTable = htmlFactory.table().bordered();
		Row dataTypeTableHeaderRow = dataTypeTable.row().style(Style.INFO);
		dataTypeTableHeaderRow.header("Name");
		dataTypeTableHeaderRow.header("Instance Type Name");
		dataTypeTableHeaderRow.header("Description");
		
		Table enumTable = htmlFactory.table().bordered();
		Row enumTableHeaderRow = enumTable.row().style(Style.INFO);
		enumTableHeaderRow.header("Name");
		enumTableHeaderRow.header("Description");
		
		for (EClassifier eClassifier: pClassifiers) {
			if (eClassifier instanceof EClass) {
				Row row = classTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(getFirstDocSentence(baseURL, urlPrefix, eClassifier));
			} else if (eClassifier instanceof EEnum) {
				Row row = enumTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(getFirstDocSentence(baseURL, urlPrefix, eClassifier));
			} else {
				Row row = dataTypeTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(eClassifier.getInstanceTypeName());
				row.cell(getFirstDocSentence(baseURL, urlPrefix, eClassifier));
			}
		}
		
		if (classTable.rows().size()>1) {
			Tag classIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoutePath+"/resources/images/EClass.gif")
					.style("margin-right", "5px");
			
			tabs.item(classIcon+" Classes", classTable);
		}
		if (dataTypeTable.rows().size()>1) {
			Tag dataTypeIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoutePath+"/resources/images/EDataType.gif")
					.style("margin-right", "5px");
					
			tabs.item(dataTypeIcon+" Data types", dataTypeTable);			
		}
		if (enumTable.rows().size()>1) {
			Tag enumIcon = htmlFactory.tag(TagName.img)
					.attribute("src", docRoutePath+"/resources/images/EEnum.gif")
					.style("margin-right", "5px");
			
			tabs.item(enumIcon+" Enumerations", enumTable);
		}
		
		TocNode sections = new TocNode(null, null, null);
		
		synchronized (packageTocNodeFactories) {
			PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(ePackage.getNsURI());
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
				tabName = htmlFactory.tag(TagName.img).attribute("src", docRoutePath+section.getIcon()).style("margin-right", "5px") + tabName;
			}
			Fragment sectionFragment = htmlFactory.fragment();
			section(section, -1, htmlFactory, docRoutePath, sectionFragment);
			tabs.item(tabName, sectionFragment);
		}		
		
		return ret.toString();		
		
	}

}
