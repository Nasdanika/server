package org.nasdanika.cdo.web.doc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement.Style;
import org.pegdown.LinkRenderer;

public class EPackageDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EPackageDocumentationGenerator(LinkRenderer linkRenderer) {
		super(linkRenderer);
	}

	public String generate(
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
		String doc = getModelDocumentation(ePackage);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
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
			row.cell(getFirstDocSentence(subPackage));			
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
				row.cell(getFirstDocSentence(eClassifier));
			} else if (eClassifier instanceof EEnum) {
				Row row = enumTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(getFirstDocSentence(eClassifier));
			} else {
				Row row = dataTypeTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName(), eClassifier.getName()));
				row.cell(eClassifier.getInstanceTypeName());
				row.cell(getFirstDocSentence(eClassifier));
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
		
		return ret.toString();		
		
	}

}
