package org.nasdanika.doc.ecore;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

import net.sourceforge.plantuml.SourceStringReader;

public class EPackageDocumentationGenerator extends EModelElementDocumentationGenerator<EPackage> {
	
	public static final String PACKAGE_SUMMARY_PNG = "package-summary.png";
	
	public EPackageDocumentationGenerator(EPackage ePackage) {
		super(ePackage);
	}

	/**
	 * Generates PNG diagram.
	 * @return Image map for the diagram
	 * @throws IOException 
	 */
	public String generateDiagram(
			boolean leftToRightDirection, 
			String width, 
			int depth, 
			PlantUmlTextGenerator.RelationshipDirection relationshipDirection,
			boolean appendAttributes,
			boolean appendOperations,
			OutputStream out) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		PlantUmlTextGenerator gen = new PlantUmlTextGenerator(sb, this::getEClassifierLocation) {
			
			@Override
			protected Collection<EClass> getSubTypes(EClass eClass) {
				return EPackageDocumentationGenerator.this.getSubTypes(eClass);
			}
			
			@Override
			protected Collection<EClass> getReferrers(EClass eClass) {
				return EPackageDocumentationGenerator.this.getReferrers(eClass);
			}
			
			@Override
			protected boolean isAppendAttributes(EClass eClass) {
				return appendAttributes;
			}
			
			@Override
			protected boolean isAppendOperations(EClass eClass) {
				return appendOperations;				
			}
								
		};
		gen.appendStartUml();
		
		if (leftToRightDirection) {
			sb.append("left to right direction").append(System.lineSeparator());
		}
		
		if (width != null) {
			sb.append("scale ").append(width).append(" width").append(System.lineSeparator());
		}
										
		gen.appendWithRelationships(
				getModelElement().getEClassifiers(),
				relationshipDirection,						
				depth);		
		
		gen.appendEndUml();
		SourceStringReader reader = new SourceStringReader(sb.toString());
		return reader.generateDiagramDescription(out).getCmapData();
	}

	/**
	 * Override to return a list of sub-types of given EClass. 
	 * This implementation returns all sub-types found in the current package. 
	 * @param eClass
	 * @return
	 */
	protected Collection<EClass> getSubTypes(EClass eClass) {
		Collection<EClass> ret = new ArrayList<>();
		for (EClassifier ec: getModelElement().getEClassifiers()) {
			if (eClass != ec && ec instanceof EClass && eClass.isSuperTypeOf((EClass) ec)) {
				ret.add((EClass) ec);
			}
		}
		return ret;
	}

	@Override
	public String generateDocumentation(String diagramCMap) {
		HTMLFactory htmlFactory = getHtmlFactory();
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EPackage "+getModelElement().getName()));
		ret.content(htmlFactory.tag(TagName.h2, getPackageIcon(), getModelElement().getName()));
		ret.content(htmlFactory.div("<B>Namespace URI:</B> "+getModelElement().getNsURI()));
		
		Tabs tabs = htmlFactory.tabs();
		ret.content(tabs);		
		
		tabs(tabs, diagramCMap);
		
		return ret.toString();				
	}

	protected void documentationTab(Tabs tabs) {
		HTMLFactory htmlFactory = getHtmlFactory();
		Fragment ret = htmlFactory.fragment();
		String doc = getModelDocumentation(getModelElement());
		if (!isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}	
		
		EPackage eSuperPackage = getModelElement().getESuperPackage();
		if (eSuperPackage!=null) {
			ret.content(htmlFactory.div("<B>Parent:</B> ", htmlFactory.link(getEPackageLocation(getModelElement())+PACKAGE_SUMMARY_HTML, eSuperPackage.getName())));			
		}
		
		for (EAnnotation eAnnotation: getModelElement().getEAnnotations()) {
			ret.content(documentAnnotation(eAnnotation));
		}
		
		if (!ret.isEmpty()) {
			tabs.item("Documentation", ret);
		}
	}

	private Tag getPackageIcon() {
		return getHtmlFactory().tag(TagName.img)
				.attribute("src", getIconsBaseLocation()+"EPackage.gif")
				.style().margin().right("5px");
	}			
	
	protected void tabs(Tabs tabs, String diagramCMap) {
		documentationTab(tabs);		
		diagramTab(tabs, diagramCMap);
		subPackagesTab(tabs);		
		eClassifiersTab(tabs);	
	}

	protected void diagramTab(Tabs tabs, String diagramCMap) {
		HTMLFactory htmlFactory = getHtmlFactory();
		Tag diagramImage = htmlFactory.tag(TagName.img).attribute("src", getDiagramImageLocation()).attribute("usemap", "#plantuml_map");
		tabs.item("Diagram", htmlFactory.fragment(diagramImage, diagramCMap));
	}

	protected String getDiagramImageLocation() {
		return PACKAGE_SUMMARY_PNG;
	}

	protected void eClassifiersTab(Tabs tabs) {		
		HTMLFactory htmlFactory = getHtmlFactory();
//		String packagePath = getEPackageLocation(getModelElement());
		List<EClassifier> pClassifiers = new ArrayList<>(getModelElement().getEClassifiers());
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
				row.cell(eClassifierLink(eClassifier, false));
				row.cell(getFirstDocSentence(eClassifier));
			} else if (eClassifier instanceof EEnum) {
				Row row = enumTable.row();
				row.cell(eClassifierLink(eClassifier, false));
				row.cell(getFirstDocSentence(eClassifier));
			} else {
				Row row = dataTypeTable.row();
				row.cell(eClassifierLink(eClassifier, false));
				row.cell(eClassifier.getInstanceTypeName());
				row.cell(getFirstDocSentence(eClassifier));
			}
		}
		
		if (classTable.rows().size()>1) {
			Tag classIcon = htmlFactory.tag(TagName.img)
					.attribute("src", getIconsBaseLocation()+"EClass.gif")
					.style("margin-right", "5px");
			
			tabs.item(classIcon+" Classes", classTable);
		}
		if (dataTypeTable.rows().size()>1) {
			Tag dataTypeIcon = htmlFactory.tag(TagName.img)
					.attribute("src", getIconsBaseLocation()+"EDataType.gif")
					.style("margin-right", "5px");
					
			tabs.item(dataTypeIcon+" Data types", dataTypeTable);			
		}
		if (enumTable.rows().size()>1) {
			Tag enumIcon = htmlFactory.tag(TagName.img)
					.attribute("src", getIconsBaseLocation()+"EEnum.gif")
					.style("margin-right", "5px");
			
			tabs.item(enumIcon+" Enumerations", enumTable);
		}
	}

	protected void subPackagesTab(Tabs tabs) {
		HTMLFactory htmlFactory = getHtmlFactory();
		Table subPackageTable = htmlFactory.table().bordered();
		Row subPackageTableHeaderRow = subPackageTable.row().style(Bootstrap.Style.INFO);
		subPackageTableHeaderRow.header("Name");
		subPackageTableHeaderRow.header("Description");
		for (EPackage subPackage: getModelElement().getESubpackages()) {
			Row row = subPackageTable.row();
			row.cell(htmlFactory.link(getEPackageLocation(subPackage)+PACKAGE_SUMMARY_HTML, subPackage.getName()));
			row.cell(getFirstDocSentence(subPackage));			
		}
		
		if (subPackageTable.rows().size()>1) {
			tabs.item(getPackageIcon()+" Sub-packages", subPackageTable);			
		}
	}

}
