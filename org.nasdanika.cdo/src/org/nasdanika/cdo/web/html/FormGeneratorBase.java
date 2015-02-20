package org.nasdanika.cdo.web.html;

import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.InputBase;
import org.nasdanika.html.TextArea;
import org.nasdanika.html.UIElement;

public abstract class FormGeneratorBase<T extends ETypedElement> {

	public static final String VALIDATOR_KEY = "validator";
	public static final String TRUE_LITERAL = "true";
	public static final String HELP_TEXT_KEY = "help-text";
	public static final String LABEL_KEY = "label";
	public static final String CONTROL_ID_KEY = "control-id";
	public static final String INPUT_TYPE_KEY = "input-type";
	public static final String REQUIRED_KEY = "required";
	public static final String PLACEHOLDER_KEY = "placeholder";
	public static final String ATTRIBUTE_PREFIX = "attribute:";
	public static final String STYLE_PREFIX = "style:";
	public static final String PRIVATE_KEY = "private";

	public static final String FORM_CONTROL_ANNOTATION_SOURCE = "org.nasdanika.cdo.web.html.form-control";
	public static final String FORM_ANNOTATION_SOURCE = "org.nasdanika.cdo.web.html.form";
	
	/**
	 * Generates form from EClass metadata.
	 * @param htmlFactory
	 * @return
	 * @throws Exception
	 */
	public Form generateForm(HTMLFactory htmlFactory) throws Exception {
		Form form = htmlFactory.form();
		populateForm(htmlFactory, form);
		return form;
	}

	/**
	 * 
	 * @param htmlFactory
	 * @param form
	 * @throws Exception
	 */
	protected abstract void populateForm(HTMLFactory htmlFactory, Form form) throws Exception;

	/**
	 * Generates form group or form input group for the feature. This implementation generates form group.
	 * @param htmlFactory
	 * @param form
	 * @param feature
	 * @throws Exception
	 */
	protected void generateGroup(HTMLFactory htmlFactory, Form form, T element) throws Exception {
		Object control = generateControl(htmlFactory, form,	element);
		if (control!=null) {
			configureControl(htmlFactory, element, control);
			FormGroup<?> group = form.formGroup(
					generateLabel(htmlFactory, element), 
					generateCondrolId(htmlFactory, element), 
					control, 
					generateHelpText(htmlFactory, element));
			
			configureGroup(htmlFactory, element, group);
		}		
	}

	/**
	 * Override to configure group.
	 * @param htmlFactory
	 * @param element
	 * @param group
	 */
	protected void configureGroup(HTMLFactory htmlFactory, T element, Object group) {
		
	}

	/**
	 * Generates help text.
	 * @param htmlFactory
	 * @param feature
	 * @return
	 */
	protected Object generateHelpText(HTMLFactory htmlFactory, T element) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null) {
			return formControlAnnotation.getDetails().get(HELP_TEXT_KEY);
		}
		return null;
	}

	protected Object generateCondrolId(HTMLFactory htmlFactory, T element) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(CONTROL_ID_KEY)) {
			return formControlAnnotation.getDetails().get(CONTROL_ID_KEY);
		}
		return "form_control_"+element.getName();
	}

	protected Object generateLabel(HTMLFactory htmlFactory, T element) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(LABEL_KEY)) {
			return formControlAnnotation.getDetails().get(LABEL_KEY);
		}
		String[] splitStr = StringUtils.splitByCharacterTypeCamelCase(element.getName());
		splitStr[0] = StringUtils.capitalize(splitStr[0]);
		for (int i=1; i<splitStr.length; ++i) {
			splitStr[i] = StringUtils.uncapitalize(splitStr[i]);
		}
		return StringUtils.join(splitStr, " ");
	}

	protected Object generatePlaceholder(HTMLFactory htmlFactory, T element) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(PLACEHOLDER_KEY)) {
			return formControlAnnotation.getDetails().get(PLACEHOLDER_KEY);
		}
		String[] splitStr = StringUtils.splitByCharacterTypeCamelCase(element.getName());
		splitStr[0] = StringUtils.capitalize(splitStr[0]);
		for (int i=1; i<splitStr.length; ++i) {
			splitStr[i] = StringUtils.uncapitalize(splitStr[i]);
		}
		return StringUtils.join(splitStr, " ");
	}

	/**
	 * Generates feature control. If this method returns null, then given feature is not included into the form.
	 * @param htmlFactory
	 * @param form
	 * @param feature
	 * @return Feature control
	 * @throws Exception
	 */
	protected Object generateControl(HTMLFactory htmlFactory, Form form, T element) throws Exception {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		boolean isPrivate = formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(PRIVATE_KEY) && TRUE_LITERAL.equalsIgnoreCase(formControlAnnotation.getDetails().get(PRIVATE_KEY).trim());
		if (isPrivate) {
			return null;
		}
		Input input = htmlFactory.input(getInputType(element));
		return input;
	}

	protected void configureControl(HTMLFactory htmlFactory,T element, Object control) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null) {
			EMap<String, String> details = formControlAnnotation.getDetails();
			for (Entry<String, String> de: details.entrySet()) {
				if (control instanceof UIElement) {
					if (de.getKey().startsWith(ATTRIBUTE_PREFIX)) {
						((UIElement<?>) control).attribute(de.getKey().substring(ATTRIBUTE_PREFIX.length()), de.getValue());
					} else if (de.getKey().startsWith(STYLE_PREFIX)) {
						((UIElement<?>) control).style(de.getKey().substring(STYLE_PREFIX.length()), de.getValue());						
					}
					boolean isRequired = details.containsKey(REQUIRED_KEY) && TRUE_LITERAL.equals(details.get(REQUIRED_KEY).trim());
					if (isRequired && control instanceof InputBase) {
						((InputBase<?>) control).required();
					}
					if (control instanceof Input) {
						((Input) control).placeholder(generatePlaceholder(htmlFactory, element));
					} else if (control instanceof TextArea) {
						((TextArea) control).placeholder(generatePlaceholder(htmlFactory, element));
					}
						
				}
			}
		}
	}

	protected InputType getInputType( T element) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null && formControlAnnotation.getDetails().containsKey(INPUT_TYPE_KEY)) {
			return InputType.valueOf(formControlAnnotation.getDetails().get(INPUT_TYPE_KEY).trim());
		}
		return getInputType(element.getEType().getInstanceClassName());
	}
	
	
	protected InputType getInputType(String typeName) {
		switch (typeName) {
		case "boolean":
		case "java.lang.Boolean":
			return InputType.checkbox;
		case "java.util.Date":
			return InputType.date;
		case "byte":
		case "short":
		case "int":
		case "long":
		case "java.lang.Byte":
		case "java.lang.Short":
		case "java.lang.Integer":
		case "java.lang.Long":
		case "java.math.BigInteger":
			return InputType.number;				
		default:
			return InputType.text;
		}
	}

}
