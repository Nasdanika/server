package org.nasdanika.cdo.web.html;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
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
public class KnockoutJsEClassFormGenerator extends KnockoutJsFormGeneratorBase<EClass, EStructuralFeature> {

	public KnockoutJsEClassFormGenerator(EClass eClass, String model, String submitHandler, String cancelHandler) {
		super(eClass, model, submitHandler, cancelHandler);
	}
	
	/**
	 * 
	 * @param htmlFactory
	 * @param form
	 * @throws Exception
	 */
	protected void populateForm(HTMLFactory htmlFactory, Form form) throws Exception {
		super.populateForm(htmlFactory, form);
		for (EStructuralFeature sf: sortFeatures(getSource().getEAllStructuralFeatures())) {
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
	protected List<String[]> generateModelEntries() {
		List<String[]> ret = super.generateModelEntries();
		for (EStructuralFeature sf: getSource().getEAllStructuralFeatures()) {			
			if (sf instanceof EAttribute) {
				EAnnotation ann = sf.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
				if (ann!=null) { 
					EMap<String, String> details = ann.getDetails();
					if (details.containsKey(PRIVATE_KEY) && TRUE_LITERAL.equalsIgnoreCase(details.get(PRIVATE_KEY))) {
						continue;
					}
				}
				String defaultValue = null;
				if (ann!=null && hasDetails(ann, DEFAULT_VALUE_KEY)) {
					defaultValue = ann.getDetails().get(DEFAULT_VALUE_KEY);
				} else {
					defaultValue = sf.getDefaultValueLiteral();
				}
				ret.add(new String[] {
					sf.getName(),
					defaultValue,
					ann==null ? null : ann.getDetails().get(VALIDATOR_KEY)					
				});
			}
		}
		return ret;
	}
		
	@Override
	protected String generateLoadModel() throws Exception {
		StringBuilder applyBuilder = new StringBuilder();
		for (EStructuralFeature sf: getSource().getEAllStructuralFeatures()) {			
			if (sf instanceof EAttribute) {
				EAnnotation ann = sf.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
				if (ann!=null) { 
					EMap<String, String> details = ann.getDetails();
					if (details.containsKey(PRIVATE_KEY) && TRUE_LITERAL.equalsIgnoreCase(details.get(PRIVATE_KEY))) {
						continue;
					}
				}
				applyBuilder.append("if (source.hasOwnProperty('"+sf.getName()+"') && ko.isObservable(this.observableData."+sf.getName()+")) { Q.when(source."+sf.getName()+").then(this.observableData."+sf.getName()+"); }"+System.lineSeparator());
			}
		}
		return applyBuilder.toString();
	}	
	
	@Override
	protected String generateApply() throws Exception {
		StringBuilder applyBuilder = new StringBuilder();
		for (EStructuralFeature sf: getSource().getEAllStructuralFeatures()) {			
			if (sf instanceof EAttribute) {
				EAnnotation ann = sf.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
				if (ann!=null) { 
					EMap<String, String> details = ann.getDetails();
					if (details.containsKey(PRIVATE_KEY) && TRUE_LITERAL.equalsIgnoreCase(details.get(PRIVATE_KEY))) {
						continue;
					}
				}
				applyBuilder.append("applyTarget."+sf.getName()+" = this.observableData."+sf.getName()+"();"+System.lineSeparator());
			}
		}
		return applyBuilder.append("return applyTarget.$store();").toString();
	}
	
}
