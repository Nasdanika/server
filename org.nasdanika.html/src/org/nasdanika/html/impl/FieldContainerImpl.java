package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Button;
import org.nasdanika.html.FieldContainer;
import org.nasdanika.html.FieldSet;
import org.nasdanika.html.FormFragment;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.InputGroup;
import org.nasdanika.html.Producer;
import org.nasdanika.html.UIElement;

class FieldContainerImpl<T extends FieldContainer<T>> implements FieldContainer<T>, Producer {
	
	private FormImpl form;
	private T master;
	private HTMLFactory factory;
	
	@SuppressWarnings("unchecked")
	FieldContainerImpl(HTMLFactory factory, T master, FormImpl form) {
		this.factory = factory;
		this.form = form;
		this.master = master==null ? (T) this : master;
	}

	
	private List<Object> content = new ArrayList<>();

	@Override
	public T content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return master;
	}
	
	@Override
	public FormGroup<?> formGroup(Object label, Object controlId, Object control, Object helpText) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		FormGroup<?> ret = new FormGroupImpl(factory, form, label, controlId, control, helpText);
		content.add(ret);
		return ret;
	}

	@Override
	public FormGroup<?> formGroup(Object label, UIElement<?> control, Object helpText) {
		return formGroup(label, UIElementImpl.autoId(factory, control), control, helpText) ;
	}

	@Override
	public T checkbox(final Object label, final Object checkboxControl, final boolean inline) {
		content.add(new Producer() {
			
			@Override
			public String produce() {
				StringBuilder sb = new StringBuilder();
				if (inline) {
					sb.append("<label class=\"checkbox-inline\">")
							.append(FieldContainerImpl.this.stringify(checkboxControl))
							.append(FieldContainerImpl.this.stringify(label)) 
							.append("</label>");
				} else {
					sb.append("<div class=\"checkbox\">") 
							.append("<label>") 
							.append(FieldContainerImpl.this.stringify(checkboxControl))
							.append(FieldContainerImpl.this.stringify(label)) 
							.append("</label>")
							.append("</div>");
				}
				if (form.horizontal) {
					UIElement<?> controlDiv = form.factory.div(sb);
					controlDiv.addClass("col-"+form.deviceSize.code+"-"+(12-form.labelWidth));
					controlDiv.addClass("col-"+form.deviceSize.code+"-offset-"+form.labelWidth);
					return stringify(controlDiv);
				}
				return sb.toString();				
			}
						
			/**
			 * Fall-back to mitigate misses during refactoring.
			 */
			@Override
			public String toString() {
				return stringify(produce());
			}
			
		});
				
		return master;
	}

	@Override
	public T radio(final Object label, final Object radioControl, final boolean inline) {
		content.add(new Producer() {
			
			@Override
			public String produce() {
				StringBuilder sb = new StringBuilder();
				if (inline) {
					sb.append("<label class=\"radio-inline\">")
							.append(FieldContainerImpl.this.stringify(radioControl))
							.append(FieldContainerImpl.this.stringify(label)) 
							.append("</label>");
				} else {
					sb.append("<div class=\"radio\">") 
							.append("<label>") 
							.append(FieldContainerImpl.this.stringify(radioControl))
							.append(FieldContainerImpl.this.stringify(label)) 
							.append("</label>")
							.append("</div>");
				}
				if (form.horizontal) {
					UIElement<?> controlDiv = form.factory.div(sb.toString());
					controlDiv.addClass("col-"+form.deviceSize.code+"-"+(12-form.labelWidth));
					controlDiv.addClass("col-"+form.deviceSize.code+"-offset-"+form.labelWidth);
					return stringify(controlDiv);
				}
				return sb.toString();				
			}
						
			/**
			 * Fall-back to mitigate misses during refactoring.
			 */
			@Override
			public String toString() {
				return stringify(produce());
			}
			
		});
		
		return master;
	}
	
	@Override
	public Button button(Object... content) {
		Button ret = new ButtonImpl(factory, false, content);
		this.content.add(ret);
		return ret;
	}

	@Override
	public FieldSet fieldset() {
		FieldSet ret = new FieldSetImpl(factory, form);
		content.add(ret);
		return ret;
	}

	@Override
	public FormFragment formFragment() {		
		class FormFragmentImpl extends FieldContainerImpl<FormFragment> implements FormFragment {

			FormFragmentImpl(FormFragment master, FormImpl form) {
				super(factory, master, form);
			}
			
		}
		return new FormFragmentImpl(null, form);
	}

	@Override
	public InputGroup<?> inputGroup(Object control) {
		InputGroup<?> ret = form.factory.inputGroup(control);
		content.add(ret);
		return ret;
	}
	
	@Override
	public FormInputGroup formInputGroup(Object label, Object controlId, Object control, Object helpText) {
		FormInputGroupImpl ret = new FormInputGroupImpl(factory, form, label, controlId, control, helpText);
		content.add(ret);
		return ret;
	}	

	@Override
	public FormInputGroup formInputGroup(Object label, UIElement<?> control, Object helpText) {
		return formInputGroup(label, UIElementImpl.autoId(factory, control), control, helpText);
	}
	
	@Override
	public String produce() {
		StringBuilder sb = new StringBuilder();
		for (Object o: content) {
			sb.append(stringify(o));
		}
		return sb.toString();
	}

	@Override
	public void close() throws Exception {
		for (Object o: content) {
			if (o instanceof AutoCloseable) {
				((AutoCloseable) o).close();
			}
		}
	}
	
	protected String stringify(Object content) {
		return UIElementImpl.stringify(content, factory);
	}
	
	/**
	 * Fall-back to mitigate misses during refactoring.
	 */
	@Override
	public String toString() {
		return stringify(produce());
	}
	
}
