package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;

/**
 * Generates Bootstrap HTML form invoking EOperation through JavaScript API. Uses EOperation and EParameters metadata and annotations.
 * @author Pavel
 *
 */
public class AngularJsEOperationFormGenerator extends AngularJsFormGeneratorBase<EParameter> {

	private EOperation eOperation;

	public AngularJsEOperationFormGenerator(EOperation eOperation, String model, String handler) {
		super(model, handler);
		this.eOperation = eOperation;
	}

	/**
	 * 
	 * @param htmlFactory
	 * @param form
	 * @throws Exception
	 */
	protected void populateForm(HTMLFactory htmlFactory, Form form) throws Exception {
		for (EParameter param: sortParameters(eOperation.getEParameters().subList(1, eOperation.getEParameters().size()))) {
			generateGroup(htmlFactory, form, param);
		}		
	}

	/**
	 * Subclasses can override this method to sort parameters. This implementation just returns <code>parameters</code> argument.
	 * @param parameters
	 * @return
	 */
	protected List<EParameter> sortParameters(List<EParameter> parameters) {
		return parameters;
	}

	@Override
	protected List<String> generateValidationEntries() {
		List<String> ret = new ArrayList<>();
		EAnnotation formAnnotation = eOperation.getEAnnotation(FORM_ANNOTATION_SOURCE);
		if (formAnnotation!=null && formAnnotation.getDetails().containsKey(VALIDATOR_KEY)) {
			ret.add(generateValidationEntry("this.data", formAnnotation.getDetails().get(VALIDATOR_KEY), "this.validationResult"));
		}
		EList<EParameter> eParameters = eOperation.getEParameters();
		for (EParameter prm: eParameters.subList(1, eParameters.size())) {			
			EAnnotation formControlAnnotation = prm.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
			if (formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(VALIDATOR_KEY)) {
				ret.add(generateValidationEntry("this.data."+prm.getName(), formControlAnnotation.getDetails().get(VALIDATOR_KEY), "this.validationResults."+prm.getName()));
			}				
		}
		return ret;
	}
	
	@Override
	protected List<String> generateModelEntries() {
		List<String> ret = super.generateModelEntries();
		StringBuilder applyBuilder = new StringBuilder("apply: function(target) {");
		applyBuilder.append("if (typeof target === 'object' && typeof target.opName === 'function') { target = target.opName; } ");
		applyBuilder.append("return target(");
		Iterator<EParameter> pit = eOperation.getEParameters().subList(1, eOperation.getEParameters().size()).iterator();
		while (pit.hasNext()) {
			applyBuilder.append("this.data."+pit.next().getName());
			if (pit.hasNext()) {
				applyBuilder.append(",");
			}
		}		
		
		applyBuilder.append(");");
		applyBuilder.append("}");
		ret.add(applyBuilder.toString());
		
		ret.add("validateAndApply: function(target) { " + 
				"    return this.validate().then(function(isValid) { " + 
				"        if (isValid) { " + 
				"            return this.apply(target).then(undefined, function(reason) { " + 
				"                return { applyError: reason }; " + 
				"            }); " + 
				"        } " + 
				"        throw { validationFailed: true }; " + 
				"    }.bind(this)); " + 
				"}"); 
		return ret;
	}
}
