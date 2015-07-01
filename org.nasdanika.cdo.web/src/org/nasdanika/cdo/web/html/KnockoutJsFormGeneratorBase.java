package org.nasdanika.cdo.web.html;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.cdo.web.routes.CDOWebUtil;
import org.nasdanika.html.Button;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.InputBase;
import org.nasdanika.html.UIElement;

/**
 * Adds KnockoutJs bindings, uses help text to display validation errors, adds form validation error text on the top of the form. 
 * @author Pavel
 *
 * @param <T>
 */
public abstract class KnockoutJsFormGeneratorBase<S extends EModelElement, T extends ETypedElement> extends FormGeneratorBase<T> {

	private String model;
	private String submitHandler;	
	private String cancelHandler;
	private S source;
	
	/**
	 * Source of generation metadata
	 * @return
	 */
	public S getSource() {
		return source;
	}
	
	@Override
	protected EAnnotation getFormAnnotation() {
		return source.getEAnnotation(FORM_ANNOTATION_SOURCE);
	}

	/**
	 * 
	 * @param model Model expression. The model object shall contain data object to which form controls are bound, validationResults object
	 * which holds validation messages for controls, and validationResult string with form validation result.
	 * @param submitHandler Form submit handler expression.
	 * @param cancelHandler Handler for the cancel button click.
	 */
	protected KnockoutJsFormGeneratorBase(
			S source, 
			String model, 
			String submitHandler, 
			String cancelHandler) {
		this.source = source;
		this.model = model;
		this.submitHandler = submitHandler;
		this.cancelHandler = cancelHandler;
	}
	
	@Override
	protected Button createCancelButton(HTMLFactory htmlFactory, Form form) {
		if (cancelHandler!=null) {
			Button ret = super.createCancelButton(htmlFactory, form);
			ret.koDataBind("click", cancelHandler);
			return ret;
		}
		return null;
	}	
	
	@Override
	protected Button createSubmitButton(HTMLFactory htmlFactory, Form form) {
		return super.createSubmitButton(htmlFactory, form).koDataBind("enable", getModelPrefix()+"isDirty");
	}
	
	@Override
	public Form generateForm(HTMLFactory htmlFactory) throws Exception {		
		Form form = super.generateForm(htmlFactory);
		form.koDataBind("submit", submitHandler);		
		return form;
	}
	
	protected String getModelPrefix() {
		return model==null ? "" : model+".";
	}
	
	/**
	 * Adds DIV for form validation message.
	 */
	@Override
	protected void populateForm(HTMLFactory htmlFactory, Form form)	throws Exception {
		form.content(htmlFactory.div("").style("color", "red").koDataBind("text", getModelPrefix()+"validationResults['"+CDOWebUtil.getThisKey(getSource())+"']"));		
	}
	
	@Override
	protected Object generateHelpText(HTMLFactory htmlFactory, T element) {
		return htmlFactory.span().style("color", "red").koDataBind("text", getModelPrefix()+"validationResults."+element.getName());
	}

	@Override
	protected void configureGroup(HTMLFactory htmlFactory, T element, Object group) {
		super.configureGroup(htmlFactory, element, group);
		if (group instanceof FormGroup) { 
			FormGroup<?> formGroup = (FormGroup<?>) group;
			if (!(group instanceof FormInputGroup)) {
				formGroup.feedback();
			}
			formGroup.koDataBind("css", "{ 'has-error' : "+getModelPrefix()+"validationResults."+element.getName()+" }");
		}
	}
	
	@Override
	protected void configureControl(HTMLFactory htmlFactory, T element,	Object control) {		
		super.configureControl(htmlFactory, element, control);
		if (control instanceof InputBase) {
			((InputBase<?>) control).koDataBind(isCheckbox(element, control) ? "checked" : "value", getModelPrefix()+"data."+element.getName());
		} else if (control instanceof UIElement) {
			((UIElement<?>) control).koDataBind("text", getModelPrefix()+"data."+element.getName());
		}
	}
	
	private static KnockoutJsModelGenerator MODEL_GENERATOR = new KnockoutJsModelGenerator();
	
	/**
	 * Generates model object with asynchronous validation function.
	 * @return
	 * @throws Exception 
	 */
	public String generateModel(Object... customDeclarations) throws Exception {
		StringBuilder customDeclarationsBuilder = new StringBuilder();
		for (Object cd: customDeclarations) {
			if (cd!=null) {
				customDeclarationsBuilder.append(cd);
				customDeclarationsBuilder.append(System.lineSeparator());
			}
		}
		EAnnotation formAnnotation = source.getEAnnotation(FORM_ANNOTATION_SOURCE);
		if (formAnnotation!=null && formAnnotation.getDetails().containsKey(MODEL_KEY)) {
			customDeclarationsBuilder.append(formAnnotation.getDetails().get(MODEL_KEY));
		}

		return MODEL_GENERATOR.generate(generateModelEntries(), generateLoadModel(), generateApply(), customDeclarationsBuilder.toString());
	}
	
	protected abstract String generateApply() throws Exception;
	
	protected String generateLoadModel() throws Exception {
		return null;
	}
	
	/**
	 * 
	 * @return [ entry name, default value, validator ]. First entry is for the form (this).
	 */
	protected List<String[]> generateModelEntries() {
		List<String[]> ret = new ArrayList<>();
		String validator = null;
		EAnnotation formAnnotation = getSource().getEAnnotation(FORM_ANNOTATION_SOURCE);
		if (formAnnotation!=null && formAnnotation.getDetails().containsKey(VALIDATOR_KEY)) {
			validator =  formAnnotation.getDetails().get(VALIDATOR_KEY);
		}

		ret.add(new String[] { CDOWebUtil.getThisKey(source), null, validator});
		return ret;
	}
	
}
