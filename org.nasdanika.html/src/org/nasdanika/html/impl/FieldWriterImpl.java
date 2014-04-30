package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Button;
import org.nasdanika.html.FieldSet;
import org.nasdanika.html.FieldWriter;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.InputGroup;
import org.nasdanika.html.UIElement;

class FieldWriterImpl<T extends FieldWriter<?>> implements FieldWriter<T> {
	
	private FormImpl form;
	private T master;
	
	@SuppressWarnings("unchecked")
	FieldWriterImpl(T master, FormImpl form) {
		this.form = form;
		this.master = master==null ? (T) this : master;
	}

	
	private List<Object> content = new ArrayList<>();

	@Override
	public T content(String content) {
		this.content.add(content);
		return master;
	}
	
	@Override
	public FormGroup<?> formGroup(String label, String controlId, String controlDefintion, String helpText) {
		FormGroup<?> ret = new FormGroupImpl<FormGroup<?>, String>(form, label, controlId, controlDefintion, helpText);
		content.add(ret);
		return ret;
	}

	@Override
	public T checkbox(final String label, final String checkboxDefinition, final boolean inline) {
		content.add(new Object() {
			
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				if (inline) {
					sb.append("<label class=\"checkbox-inline\">")
							.append(checkboxDefinition)
							.append(label) 
							.append("</label>");
				} else {
					sb.append("<div class=\"checkbox\">") 
							.append("<label>") 
							.append(checkboxDefinition)
							.append(label) 
							.append("</label>")
							.append("</div>");
				}
				if (form.horizontal) {
					UIElement<?> controlDiv = form.builder.tag("div", sb.toString());
					controlDiv.addClass("col-"+form.deviceSize.code+"-"+(12-form.labelWidth));
					controlDiv.addClass("col-"+form.deviceSize.code+"-offset-"+form.labelWidth);
					return controlDiv.toString();
				}
				return sb.toString();				
			}
		});
				
		return master;
	}

	@Override
	public T radio(final String label, final String radioDefinition, final boolean inline) {
		content.add(new Object() {
			
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				if (inline) {
					sb.append("<label class=\"radio-inline\">")
							.append(radioDefinition)
							.append(label) 
							.append("</label>");
					content.add(sb.toString());
				} else {
					sb.append("<div class=\"radio\">") 
							.append("<label>") 
							.append(radioDefinition)
							.append(label) 
							.append("</label>")
							.append("</div>");
					content.add(sb.toString());
				}
				if (form.horizontal) {
					UIElement<?> controlDiv = form.builder.tag("div", sb.toString());
					controlDiv.addClass("col-"+form.deviceSize.code+"-"+(12-form.labelWidth));
					controlDiv.addClass("col-"+form.deviceSize.code+"-offset-"+form.labelWidth);
					return controlDiv.toString();
				}
				return sb.toString();				
			}
		});
		
		return master;
	}
	
	@Override
	public Button button(String text) {
		Button ret = new ButtonImpl(text, false);
		content.add(ret);
		return ret;
	}

	@Override
	public FieldSet fieldset() {
		FieldSet ret = new FieldSetImpl(form);
		content.add(ret);
		return ret;
	}

	@Override
	public FieldWriter<?> fieldWriter() {		
		return new FieldWriterImpl<FieldWriter<?>>(null, form);
	}

	@Override
	public InputGroup<?> inputGroup(String control) {
		InputGroup<?> ret = form.builder.inputGroup(control);
		content.add(ret);
		return ret;
	}
	
	@Override
	public FormInputGroup formInputGroup(String label, String controlId, String controlDefintion, String helpText) {
		FormInputGroupImpl ret = new FormInputGroupImpl(form, label, controlId, controlDefintion, helpText);
		content.add(ret);
		return ret;
	}	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Object o: content) {
			sb.append(o.toString());
		}
		return sb.toString();
	}


}
