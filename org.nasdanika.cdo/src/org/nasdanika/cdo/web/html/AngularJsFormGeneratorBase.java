package org.nasdanika.cdo.web.html;

import java.util.List;

import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.InputBase;
import org.nasdanika.html.UIElement;

/**
 * Adds ng- attributes, uses help text to display validation errors, adds form validation error text on the top of the form. 
 * @author Pavel
 *
 * @param <T>
 */
public abstract class AngularJsFormGeneratorBase<T extends ETypedElement> extends FormGeneratorBase<T> {

	private String model;
	private String handler;

	/**
	 * 
	 * @param model Model expression. The model object shall contain data object to which form controls are bound, validationResults object
	 * which holds validation messages for controls, and validationResult string with form validation result.
	 * @param handler
	 */
	protected AngularJsFormGeneratorBase(String model, String handler) {
		this.model = model;
		this.handler = handler;
	}
	
	@Override
	public Form generateForm(HTMLFactory htmlFactory) throws Exception {		
		Form form = super.generateForm(htmlFactory);
		form.ngSubmit(handler);
		return form;
	}
	
	/**
	 * Adds DIV for form validation message.
	 */
	@Override
	protected void populateForm(HTMLFactory htmlFactory, Form form)	throws Exception {
		form.content(htmlFactory.div().style("color", "red").ngBind(model+".validationResult"));		
	}
	
	@Override
	protected Object generateHelpText(HTMLFactory htmlFactory, T element) {
		return htmlFactory.span().style("color", "red").ngBind(model+".validationResults."+element.getName());
	}

	@Override
	protected void configureGroup(HTMLFactory htmlFactory, T element, Object group) {
		super.configureGroup(htmlFactory, element, group);
		if (group instanceof FormGroup) { 
			FormGroup<?> formGroup = (FormGroup<?>) group;
			if (!(group instanceof FormInputGroup)) {
				formGroup.feedback();
			}
			formGroup.ngClass("{ 'has-error' : "+model+".validationResults."+element.getName()+" }");
		}
	}
	
	@Override
	protected void configureControl(HTMLFactory htmlFactory, T element,	Object control) {		
		super.configureControl(htmlFactory, element, control);
		if (control instanceof InputBase) {
			((InputBase<?>) control).ngModel(model+".data."+element.getName());
		} else if (control instanceof UIElement) {
			((UIElement<?>) control).ngBind(model+".data."+element.getName());
		}
	}
	
	/**
	 * Generates model object with asynchronous validation function.
	 * @return
	 */
	public String generateModel() {
		StringBuilder sb = new StringBuilder("{ data: {}, validationResults: {}, validate: function() {");
		sb.append("return Q.all([");
		List<String> vr = generateValidationEntries();
		for (int i=0, l=vr.size(); i<l; ++i) {
			if (i>0) {
				sb.append(",");
			}
			sb.append(vr.get(i));
		}
		sb.append("]).then(function(vResults) { return vResults.reduce(function(r1, r2) { return r1 && r2; }, true); });");
		sb.append("}}");
		return sb.toString();
	}
	
	protected abstract List<String> generateValidationEntries();
	
	protected String generateValidationEntry(String value, String validator, String target) {
		return "Q.when("+value+").then(function(value) { "+validator+"}).then(function(validationResult) { "+target+"=validationResult; return !validationResult; }.bind(this))";
	}
}
