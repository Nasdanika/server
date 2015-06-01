package org.nasdanika.cdo.web.html;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;

/**
 * Generates Bootstrap HTML form using EClass metadata and annotations.
 * @author Pavel
 *
 */
public class EClassFormGenerator extends FormGeneratorBase<EStructuralFeature> {

	private EClass eClass;

	public EClassFormGenerator(EClass eClass) {
		this.eClass = eClass;
	}
	
	/**
	 * 
	 * @param htmlFactory
	 * @param form
	 * @throws Exception
	 */
	protected void populateForm(HTMLFactory htmlFactory, Form form) throws Exception {
		for (EStructuralFeature sf: sortFeatures(eClass.getEAllStructuralFeatures())) {
			generateGroup(htmlFactory, form, sf);
		}		
	}
	
	@Override
	protected EAnnotation getFormAnnotation() {
		return eClass.getEAnnotation(FORM_ANNOTATION_SOURCE);
	}

	/**
	 * Subclasses can override this method to sort features. This implementation just returns <code>allFeatures</code> argument.
	 * @param allFeatures
	 * @return
	 */
	protected List<EStructuralFeature> sortFeatures(EList<EStructuralFeature> allFeatures) {
		return allFeatures;
	}
	
	/**
	 * Generates feature control. If this method returns null, then given feature is not included into the form.
	 * @param htmlFactory
	 * @param form
	 * @param feature
	 * @return Feature control
	 * @throws Exception
	 */
	protected Object generateControl(HTMLFactory htmlFactory, Form form, EStructuralFeature element) throws Exception {
		if (element instanceof EReference) {
			return null; // No controls for references by default. 
		}
		
		return super.generateControl(htmlFactory, form, element); 
	}
	

}
