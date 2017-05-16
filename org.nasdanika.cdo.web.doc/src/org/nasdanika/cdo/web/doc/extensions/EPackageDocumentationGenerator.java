package org.nasdanika.cdo.web.doc.extensions;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocRoute.PackageTocNodeFactoryEntry;
import org.nasdanika.cdo.web.doc.EClassifierKey;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.cdo.web.doc.TocNodeFactory;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Select;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;

import net.sourceforge.plantuml.SourceStringReader;

public class EPackageDocumentationGenerator extends EModelElementDocumentationGeneratorImpl<EPackage> {

	@Override
	public Object generate(
			DocRoute docRoute, 
			HttpServletRequestContext context, 
			URI baseURI,
			String urlPrefix,
			String registryPath,
			EPackage ePackage) {
		
		String uriStr = baseURI.toString();
		
		if (uriStr.endsWith(".html")) {
			return generatePage(docRoute, baseURI, urlPrefix, registryPath, ePackage);
		}
		
		if (uriStr.endsWith(".png")) {
			try {
				StringBuilder sb = new StringBuilder();
				PlantUmlTextGenerator gen = new PlantUmlTextGenerator(sb) {
					
					@Override
					protected Collection<EClass> getSubTypes(EClass eClass) {
						Set<EClassifierKey> subTypes = docRoute.getInheritanceMap().get(new EClassifierKey(eClass));
						if (subTypes==null || subTypes.isEmpty()) {
							return super.getSubTypes(eClass);
						}
						
						Set<EClass> ret = new HashSet<EClass>();
						for (EClassifierKey stKey: subTypes) {
							EClassifier st = docRoute.getEClassifier(stKey);
							if (st instanceof EClass) {
								ret.add((EClass) st);
							}
						}
						return ret;
					}
					
					@Override
					protected Collection<EClass> getReferrers(EClass eClass) {
						Set<EClassifierKey> referrers = docRoute.getReferrersMap().get(new EClassifierKey(eClass));
						if (referrers==null || referrers.isEmpty()) {
							return super.getSubTypes(eClass);
						}
						
						Set<EClass> ret = new HashSet<EClass>();
						for (EClassifierKey refKey: referrers) {
							EClassifier ref = docRoute.getEClassifier(refKey);
							if (ref instanceof EClass) {
								ret.add((EClass) ref);
							}
						}
						return ret;
					}
					
					@Override
					protected boolean isAppendAttributes(EClass eClass) {
						return Boolean.parseBoolean(context.getRequest().getParameter("members"));
					}
					
					@Override
					protected boolean isAppendOperations(EClass eClass) {
						return Boolean.parseBoolean(context.getRequest().getParameter("members"));
					}
										
				};
				gen.appendStartUml();
				
				if (Boolean.TRUE.toString().equals(context.getRequest().getParameter("leftToRightDirection"))) {
					sb.append("left to right direction").append(System.lineSeparator());
				}
				
				String width = context.getRequest().getParameter("width");
				if (width != null) {
					sb.append("scale ").append(width).append(" width").append(System.lineSeparator());
				}
												
				gen.appendWithRelationships(
						ePackage.getEClassifiers(),
						PlantUmlTextGenerator.RelationshipDirection.valueOf(context.getRequest().getParameter("direction")),						
						Integer.parseInt(context.getRequest().getParameter("depth")));
				
				
				gen.appendEndUml();
				SourceStringReader reader = new SourceStringReader(sb.toString());
				context.getResponse().setContentType("image/png");
				reader.generateImage(context.getResponse().getOutputStream());
				return Action.NOP;
			} catch (Exception e) {
				e.printStackTrace();
				return Action.INTERNAL_SERVER_ERROR;
			}			
		}
		
		return Action.NOT_FOUND;
	}
		
	private Object generatePage(
			DocRoute docRoute, 
			URI baseURI,
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
		
		tabs(docRoute, baseURI, urlPrefix, registryPath, ePackage, tabs);
		
		return ret.toString();				
	}

	protected void documentationTab(
			DocRoute docRoute, 
			URI baseURI, 
			String urlPrefix, 
			String registryPath,
			EPackage ePackage, 
			Tabs tabs) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		Fragment ret = htmlFactory.fragment();
		String doc = getModelDocumentation(docRoute, baseURI, urlPrefix, ePackage);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}	
		
		// Mounted doc - "#" section
		Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = docRoute.getPackageTocNodeFactories();		
		
		TocNode elementDoc = new TocNode(null, null, null, null, null, false);
		
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
			ret.content(docRoute.section(eDoc, -1));
		}		
						
		EPackage eSuperPackage = ePackage.getESuperPackage();
		if (eSuperPackage!=null) {
			ret.content(htmlFactory.div("<B>Parent:</B> ", htmlFactory.link(DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+registryPath+"/"+Hex.encodeHexString(eSuperPackage.getNsURI().getBytes(/* UTF-8? */))+"/"+DocRoute.PACKAGE_SUMMARY_HTML, getPackageIcon(docRoute), eSuperPackage.getName())));			
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
			URI baseURI,
			String urlPrefix,
			String registryPath,
			EPackage ePackage, 
			Tabs tabs) {
		
		documentationTab(docRoute, baseURI, urlPrefix, registryPath, ePackage, tabs);		
		diagramTab(docRoute, baseURI, urlPrefix, registryPath, ePackage, tabs);
		subPackagesTab(docRoute, baseURI, urlPrefix, registryPath, ePackage, tabs);		
		classifierTabs(docRoute, baseURI, urlPrefix, registryPath, ePackage, tabs);	
		sectionsTabs(docRoute, ePackage, tabs);						
	}

	protected void sectionsTabs(DocRoute docRoute, EPackage ePackage, Tabs tabs) {
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		TocNode sections = new TocNode(null, null, null, null, null, false);
		
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
			sectionFragment.content(docRoute.section(section, -1));
			tabs.item(tabName, sectionFragment);
		}
	}

	protected void diagramTab(
			DocRoute docRoute, 
			URI baseURI, 
			String urlPrefix, 
			String registryPath, 
			EPackage ePackage,
			Tabs tabs) {

		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		String idBase = ePackage.getName()+"-diagram-"+htmlFactory.nextId();
		Tag contextDiagramApp = htmlFactory.div().id(idBase + "-app");
		
		contextDiagramApp.content(htmlFactory.spinnerOverlay(Spinner.cog).id(idBase+"-overlay"));
		
		Form diagramConfigurationForm = htmlFactory.form()
				.inline(true, false)
				.style().border("1px silver solid")
				.style().border().top("none")
				.style().padding("3px")
				.style().margin().bottom("3px");
		
		contextDiagramApp.content(diagramConfigurationForm);

		Select directionSelect = htmlFactory.select().knockout().value("direction");
				
		directionSelect.option("in", false, false, "In");
		directionSelect.option("out", false, false, "Out");
		directionSelect.option("both", true, false, "Both");
		diagramConfigurationForm.formGroup("Direction", directionSelect, "Related elements to display")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");

		Select depthSelect = htmlFactory.select().knockout().value("depth");
		
		for (int i=0; i<10; ++i) {
			depthSelect.option(String.valueOf(i), i==0, false, String.valueOf(i));
		}
		depthSelect.option("-1", false, false, "&infin;");
		diagramConfigurationForm.formGroup("Depth", depthSelect, "Dependency depth")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");
		
		Input membersCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("members");
		diagramConfigurationForm.formGroup("Members", membersCheckbox, "Show class references")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");		
					
		Input leftToRightDirectionCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("leftToRightDirection");
		
		diagramConfigurationForm.formGroup("Left to right", leftToRightDirectionCheckbox, "Diagram direction")				
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");
		
		Input fitWidthCheckbox = htmlFactory.input(InputType.checkbox).knockout().checked("fitWidth");
		diagramConfigurationForm.formGroup("Fit width", fitWidthCheckbox, "Scale diagram to fit width")
			.style().border().right("dashed 1px silver")
			.style().padding().right("5px");
		
		Tag img = htmlFactory.tag(TagName.img)
				.knockout().attr("diagramAttributes")
				.knockout().event("{ load : imageLoaded }");
		
		Tag diagramDiv = htmlFactory.div(img);
		
		contextDiagramApp.content(diagramDiv);
				
		Map<String, Object> scriptEnv = new HashMap<>();
		scriptEnv.put("docRoutePath", docRoute.getDocRoutePath());
		scriptEnv.put("id-base", idBase);
		scriptEnv.put("depth", 0);
		
		String packagePath = registryPath+"/"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */));		
		scriptEnv.put("diagram-url", packagePath+"/"+DocRoute.PACKAGE_SUMMARY_PNG);
		
		String script = htmlFactory.interpolate(getClass().getResource("ECoreDiagramAppLoader.js"), scriptEnv);
		tabs.item("Diagram", htmlFactory.fragment(contextDiagramApp, htmlFactory.tag(TagName.script, script)));
	}

	protected void classifierTabs(
			DocRoute docRoute, 
			URI baseURI, 
			String urlPrefix, 
			String registryPath,
			EPackage ePackage, 
			Tabs tabs) {
		
		HTMLFactory htmlFactory = docRoute.getHtmlFactory();
		String packagePath = DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+registryPath+"/"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */));
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
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName()+".html", eClassifier.getName()));
				row.cell(getFirstDocSentence(docRoute, baseURI, urlPrefix, eClassifier));
			} else if (eClassifier instanceof EEnum) {
				Row row = enumTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName()+".html", eClassifier.getName()));
				row.cell(getFirstDocSentence(docRoute, baseURI, urlPrefix, eClassifier));
			} else {
				Row row = dataTypeTable.row();
				row.cell(htmlFactory.link(packagePath+"/"+eClassifier.getName()+".html", eClassifier.getName()));
				row.cell(eClassifier.getInstanceTypeName());
				row.cell(getFirstDocSentence(docRoute, baseURI, urlPrefix, eClassifier));
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
			URI baseURI, 
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
			row.cell(htmlFactory.link(DocRoute.ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+registryPath+"/"+Hex.encodeHexString(subPackage.getNsURI().getBytes(/* UTF-8? */))+"/"+DocRoute.PACKAGE_SUMMARY_HTML, subPackage.getName()));
			row.cell(getFirstDocSentence(docRoute, baseURI, urlPrefix, subPackage));			
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
