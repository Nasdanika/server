package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
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
public class AngularJsEClassFormGenerator extends AngularJsFormGeneratorBase<EStructuralFeature> {

	private EClass eClass;

	public AngularJsEClassFormGenerator(EClass eClass, String model, String handler) {
		super(model, handler);
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

	@Override
	protected List<String> generateValidationEntries() {
		List<String> ret = new ArrayList<>();
		EAnnotation formAnnotation = eClass.getEAnnotation(FORM_ANNOTATION_SOURCE);
		if (formAnnotation!=null && formAnnotation.getDetails().containsKey(VALIDATOR_KEY)) {
			ret.add(generateValidationEntry("this.data", formAnnotation.getDetails().get(VALIDATOR_KEY), "this.validationResult"));
		}
		for (EStructuralFeature sf: eClass.getEAllStructuralFeatures()) {			
			if (sf instanceof EAttribute) {
				EAnnotation formControlAnnotation = sf.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
				if (formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(VALIDATOR_KEY)) {
					ret.add(generateValidationEntry("this.data."+sf.getName(), formControlAnnotation.getDetails().get(VALIDATOR_KEY), "this.validationResults."+sf.getName()));
				}				
			}
		}
		return ret;
	}
	
}
