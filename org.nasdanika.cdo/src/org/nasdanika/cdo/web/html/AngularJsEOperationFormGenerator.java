package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.json.JSONObject;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;

/**
 * Generates Bootstrap HTML form invoking EOperation through JavaScript API. Uses EOperation and EParameters metadata and annotations.
 * @author Pavel
 *
 */
public class AngularJsEOperationFormGenerator extends AngularJsFormGeneratorBase<EOperation, EParameter> {

	public AngularJsEOperationFormGenerator(EOperation eOperation, String model, String handler) {
		super(eOperation, model, handler);
	}

	/**
	 * 
	 * @param htmlFactory
	 * @param form
	 * @throws Exception
	 */
	protected void populateForm(HTMLFactory htmlFactory, Form form) throws Exception {
		super.populateForm(htmlFactory, form);
		for (EParameter param: sortParameters(getSource().getEParameters().subList(1, getSource().getEParameters().size()))) {
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
		EAnnotation formAnnotation = getSource().getEAnnotation(FORM_ANNOTATION_SOURCE);
		if (formAnnotation!=null && formAnnotation.getDetails().containsKey(VALIDATOR_KEY)) {
			ret.add(generateValidationEntry("this.data", formAnnotation.getDetails().get(VALIDATOR_KEY), "this.validationResult"));
		}
		EList<EParameter> eParameters = getSource().getEParameters();
		for (EParameter prm: eParameters.subList(1, eParameters.size())) {
			EAnnotation formControlAnnotation = prm.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
			if (formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(VALIDATOR_KEY)) {
				ret.add(generateValidationEntry("this.data."+prm.getName(), formControlAnnotation.getDetails().get(VALIDATOR_KEY), "this.validationResults."+prm.getName()));
			}				
		}
		return ret;
	}
	
	@Override
	protected List<String> generateModelEntries() throws Exception {
		List<String> ret = super.generateModelEntries();
		StringBuilder applyBuilder = new StringBuilder("apply: function(target) { ");
		applyBuilder.append("if (typeof target === 'object' && typeof target."+getSource().getName()+" === 'function') { target = target."+getSource().getName()+"; } ");
		applyBuilder.append("return target(");
		Iterator<EParameter> pit = getSource().getEParameters().subList(1, getSource().getEParameters().size()).iterator();
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
				"                throw { targetInvocationError: reason }; " + 
				"            }); " + 
				"        } " + 
				"        throw { validationFailed: true }; " + 
				"    }.bind(this)); " + 
				"}"); 
		return ret;
	}
		
	@Override
	protected String generateDataEntry() throws Exception {
		JSONObject ret = new JSONObject();
		EList<EParameter> eParameters = getSource().getEParameters();
		for (EParameter prm: eParameters.subList(1, eParameters.size())) {
			EAnnotation ann = prm.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
			if (ann!=null) { 
				EMap<String, String> details = ann.getDetails();
				if (details.containsKey(PRIVATE_KEY) && TRUE_LITERAL.equalsIgnoreCase(details.get(PRIVATE_KEY))) {
					continue;
				}
				if (details.containsKey(DEFAULT_VALUE_KEY)) {
					ret.put(prm.getName(), details.get(DEFAULT_VALUE_KEY));
					continue;
				}
			}
		}
		return ret.toString();
	}
	
}
