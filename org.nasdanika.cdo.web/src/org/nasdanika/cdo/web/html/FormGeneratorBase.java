package org.nasdanika.cdo.web.html;

import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Button;
import org.nasdanika.html.Button.Type;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.InputBase;
import org.nasdanika.html.Select;
import org.nasdanika.html.TextArea;
import org.nasdanika.html.UIElement;
import org.nasdanika.html.UIElement.Style;

public abstract class FormGeneratorBase<T extends ETypedElement> {

	public static final String VALIDATOR_KEY = "validator";
	public static final String TRUE_LITERAL = "true";
	public static final String HELP_TEXT_KEY = "help-text";
	public static final String LABEL_KEY = "label";
	public static final String CONTROL_ID_KEY = "control-id";
	public static final String INPUT_TYPE_KEY = "input-type";
	public static final String REQUIRED_KEY = "required";
	public static final String PLACEHOLDER_KEY = "placeholder";
	public static final String INLINE_KEY = "inline";
	public static final String ATTRIBUTE_PREFIX = "attribute:";
	public static final String STYLE_PREFIX = "style:";
	public static final String GROUP_ATTRIBUTE_PREFIX = "group-attribute:";
	public static final String GROUP_STYLE_PREFIX = "group-style:";
	public static final String PRIVATE_KEY = "private";
	public static final String DEFAULT_VALUE_KEY = "default";
	public static final String MODEL_KEY = "model";

	public static final String FORM_CONTROL_ANNOTATION_SOURCE = "org.nasdanika.cdo.web.html.form-control";
	public static final String FORM_ANNOTATION_SOURCE = "org.nasdanika.cdo.web.html.form";
	
	public static boolean hasDetails(EAnnotation ann, String key) {
		return !CoreUtil.isBlank(ann.getDetails().get(key));
	}
	
	/**
	 * Generates form from EClass metadata.
	 * @param htmlFactory
	 * @return
	 * @throws Exception
	 */
	public Form generateForm(HTMLFactory htmlFactory) throws Exception {
		Form form = htmlFactory.form();
		populateForm(htmlFactory, form);
		createSubmitButton(htmlFactory, form);
		form.content("&nbsp;");
		createCancelButton(htmlFactory, form);
		return form;
	}
	
	protected Button createSubmitButton(HTMLFactory htmlFactory, Form form) {
		return form.button(getSubmitButtonLabel()).type(Type.SUBMIT).style(Style.PRIMARY);
	}

	protected String getSubmitButtonLabel() {
		return "Submit";
	}

	protected Button createCancelButton(HTMLFactory htmlFactory, Form form) {
		return form.button(getCancelButtonLabel()).attribute("data-dismiss", "modal");		
	}

	protected String getCancelButtonLabel() {
		return "Cancel";
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
			if (isCheckbox(element, control)) {
				form.checkbox(generateLabel(htmlFactory, element), control, isInlineCheckbox(element, control));
			} else {
				FormGroup<?> group = form.formGroup(
						generateLabel(htmlFactory, element), 
						generateCondrolId(htmlFactory, element), 
						control, 
						generateHelpText(htmlFactory, element));
				
				configureGroup(htmlFactory, element, group);
			}
		}		
	}
	
	protected boolean isCheckbox(T element, Object control) {
		return control instanceof Input && "checkbox".equals(((Input) control).getAttribute("type"));
	}
	
	protected boolean isInlineCheckbox(T element, Object control) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		return formControlAnnotation!=null 
				&& hasDetails(formControlAnnotation, INLINE_KEY) 
				&& TRUE_LITERAL.equalsIgnoreCase(formControlAnnotation.getDetails().get(INLINE_KEY));
	}

	/**
	 * Configures group.
	 * @param htmlFactory
	 * @param element
	 * @param group
	 */
	protected void configureGroup(HTMLFactory htmlFactory, T element, Object group) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null) {
			EMap<String, String> details = formControlAnnotation.getDetails();
			for (Entry<String, String> de: details.entrySet()) {
				if (group instanceof UIElement) {
					if (de.getKey().startsWith(GROUP_ATTRIBUTE_PREFIX)) {
						((UIElement<?>) group).attribute(de.getKey().substring(GROUP_ATTRIBUTE_PREFIX.length()), de.getValue());
					} else if (de.getKey().startsWith(GROUP_STYLE_PREFIX)) {
						((UIElement<?>) group).style(de.getKey().substring(GROUP_STYLE_PREFIX.length()), de.getValue());						
					}
				}
			}
		}
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
		if (formControlAnnotation!=null && hasDetails(formControlAnnotation, CONTROL_ID_KEY)) {
			return formControlAnnotation.getDetails().get(CONTROL_ID_KEY);
		}
		return "form_control_"+element.getName();
	}

	protected Object generateLabel(HTMLFactory htmlFactory, T element) {		
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		boolean isRequired = formControlAnnotation!=null 
				&& hasDetails(formControlAnnotation, REQUIRED_KEY) 
				&& TRUE_LITERAL.equals(formControlAnnotation.getDetails().get(REQUIRED_KEY).trim());
		
		if (formControlAnnotation!=null && hasDetails(formControlAnnotation, LABEL_KEY)) {
			return formControlAnnotation.getDetails().get(LABEL_KEY) + (isRequired ? " <span style='color:red'>*</span>" : "");
		}
		String[] splitStr = StringUtils.splitByCharacterTypeCamelCase(element.getName());
		splitStr[0] = StringUtils.capitalize(splitStr[0]);
		for (int i=1; i<splitStr.length; ++i) {
			splitStr[i] = splitStr[i].toLowerCase();
		}
		return StringUtils.join(splitStr, " ") + (isRequired ? " <span style='color:red'>*</span>" : "");
	}

	protected Object generatePlaceholder(HTMLFactory htmlFactory, T element) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null && hasDetails(formControlAnnotation, PLACEHOLDER_KEY)) {
			return formControlAnnotation.getDetails().get(PLACEHOLDER_KEY);
		}
		String[] splitStr = StringUtils.splitByCharacterTypeCamelCase(element.getName());
		splitStr[0] = StringUtils.capitalize(splitStr[0]);
		for (int i=1; i<splitStr.length; ++i) {
			splitStr[i] = splitStr[i].toLowerCase();
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
		boolean isPrivate = formControlAnnotation!=null && hasDetails(formControlAnnotation, PRIVATE_KEY) && TRUE_LITERAL.equalsIgnoreCase(formControlAnnotation.getDetails().get(PRIVATE_KEY).trim());
		if (isPrivate) {
			return null;
		}
		Class<?> instanceClass = element.getEType().getInstanceClass();
		if (instanceClass.isEnum()) {
			Select ret = htmlFactory.select();
			int counter=0;
			for (Object ec: instanceClass.getEnumConstants()) {
				ret.option(((Enum<?>) ec).name(), StringEscapeUtils.escapeHtml4(ec.toString()), counter++ == 0, false);
			}
			return ret;
		} else {
			return htmlFactory.input(getInputType(element));
		}
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
					boolean isRequired = hasDetails(formControlAnnotation, REQUIRED_KEY) && TRUE_LITERAL.equals(details.get(REQUIRED_KEY).trim());
					if (isRequired && control instanceof InputBase) {
						((InputBase<?>) control).required();
					}
				}
			}
		}
		if (control instanceof Input) {
			((Input) control).placeholder(generatePlaceholder(htmlFactory, element));
		} else if (control instanceof TextArea) {
			((TextArea) control).placeholder(generatePlaceholder(htmlFactory, element));
		}
	}

	protected InputType getInputType(T element) {
		EAnnotation formControlAnnotation = element.getEAnnotation(FORM_CONTROL_ANNOTATION_SOURCE);
		if (formControlAnnotation!=null && hasDetails(formControlAnnotation, INPUT_TYPE_KEY)) {
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
