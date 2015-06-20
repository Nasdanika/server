package org.nasdanika.cdo.web.doc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.cdo.web.html.FormGeneratorBase;
import org.nasdanika.cdo.web.routes.CDOWebUtil;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.pegdown.LinkRenderer;

public class EClassDocumentationGenerator extends EModelElementDocumentationGenerator {

	public EClassDocumentationGenerator(LinkRenderer linkRenderer) {
		super(linkRenderer);
	}

	public String generate(
			HTMLFactory htmlFactory,
			String docRoutePath,
			String registryPath,
			EClass eClass) {
		
		// TODO - path?
		Tag classIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EClass.gif")
				.style("margin-right", "5px");
		
		Tag attributeIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EAttribute.gif")
				.style("margin-right", "5px");
		
		Tag referenceIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EReference.gif")
				.style("margin-right", "5px");
		
		Tag operationIcon = htmlFactory.tag(TagName.img)
				.attribute("src", docRoutePath+"/resources/images/EOperation.gif")
				.style("margin-right", "5px");
		
		Fragment ret = htmlFactory.fragment(htmlFactory.title("EClass "+eClass.getName()));
		ret.content(htmlFactory.tag(TagName.h2, classIcon, eClass.getName()));
		String doc = getModelDocumentation(eClass);
		if (!CoreUtil.isBlank(doc)) {
			ret.content(htmlFactory.div(doc)
					.addClass("markdown-body")
					.style("margin-top", "10px")
					.style("margin-bottom", "10px"));
		}
		
		// TODO - superclasses, subclasses.
		
		// TODO - tabs for attributes, references, operations, routes, and forms.
		
		for (EAnnotation eAnnotation: eClass.getEAnnotations()) {
			ret.content(documentAnnotation(htmlFactory, eAnnotation));
		}
	
		Tabs tabs = htmlFactory.tabs();
		ret.content(tabs);
		
		Comparator<ENamedElement> namedElementComparator = new Comparator<ENamedElement>() {

			@Override
			public int compare(ENamedElement o1, ENamedElement o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		};
		List<EAttribute> eAttributes = new ArrayList<>(eClass.getEAttributes());
		if (!eAttributes.isEmpty()) {
			Collections.sort(eAttributes, namedElementComparator);
			tabs.item(attributeIcon+" Attributes", "TODO");
		}
		
		List<EReference> eReferences = new ArrayList<>(eClass.getEReferences());
		if (!eReferences.isEmpty()) {
			Collections.sort(eReferences, namedElementComparator);
			tabs.item(referenceIcon+" References", "TODO");
		}
		
		List<EOperation> eOperations = new ArrayList<>();
		List<EOperation> routes = new ArrayList<>();
		List<EOperation> forms = new ArrayList<>();
		
		for (EOperation op: eClass.getEOperations()) {
			if (op.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE)!=null) {
				routes.add(op);
			} else if (op.getEAnnotation(FormGeneratorBase.FORM_ANNOTATION_SOURCE)!=null) {
				forms.add(op);
			} else {
				eOperations.add(op);
			}
		}
		
		if (!eOperations.isEmpty()) {
			Collections.sort(eOperations, namedElementComparator);
			tabs.item(operationIcon+" Operations", "TODO");
		}
		if (!routes.isEmpty()) {
			Collections.sort(routes, namedElementComparator);
			tabs.item(htmlFactory.glyphicon(Glyphicon.road)+" Routes", "TODO");
		}
		if (!forms.isEmpty()) {
			Collections.sort(forms, namedElementComparator);
			tabs.item(htmlFactory.glyphicon(Glyphicon.list_alt)+" Forms", "TODO");
		}
				
		return ret.toString();		
		
	}

}
